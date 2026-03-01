package com.owen233666.block.painting;

import com.owen233666.block.ModBlocks;
import com.owen233666.item.PaintBrushItem;
import com.owen233666.util.BlockUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CanvasBlock extends AbstractPaintingBlock {

    public static final IntegerProperty COUNT = IntegerProperty.create("count", 1, 3);
    public static final BooleanProperty DIRTY = BooleanProperty.create("dirty");
    public static final BooleanProperty RACK = BooleanProperty.create("rack");
    public static final EnumProperty<PlacementState> PLACE_TYPE = EnumProperty.create("type", PlacementState.class);


    public static final Supplier<VoxelShape> SHAPE_WALL_SUPPLIER = () -> Block.box(0, 0, 15, 16, 16, 16);
    public static final Supplier<VoxelShape> SHAPE_CORNER_SUPPLIER = () -> Block.box(0, 0, 6, 16, 16, 16);
    public static final Map<Direction, VoxelShape> SHAPE_WALL = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_WALL_SUPPLIER.get()));
        }
    });
    public static final Map<Direction, VoxelShape> SHAPE_CORNER = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_CORNER_SUPPLIER.get()));
        }
    });


    public CanvasBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(COUNT, 1)
                        .setValue(DIRTY, false)
                        .setValue(RACK, false)
                        .setValue(PLACE_TYPE, PlacementState.CORNER)
                        .setValue(PAINTINGS, Paintings.NONE)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(PLACE_TYPE) == PlacementState.WALL ? SHAPE_WALL.get(state.getValue(FACING)) : SHAPE_CORNER.get(state.getValue(FACING));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        Item heldItem = heldStack.getItem();
        boolean canAddCanvas = !state.getValue(RACK);

        if (heldItem instanceof PaintBrushItem) {
            if (state.getValue(DIRTY)) return InteractionResult.PASS;
            if (heldStack.getDamageValue() == heldItem.getMaxDamage()) return InteractionResult.PASS;
            world.setBlockAndUpdate(pos, state.setValue(DIRTY, true));
            if (!player.isCreative()) heldStack.hurtAndBreak(1, player, (entity) -> {});
            return InteractionResult.SUCCESS;
        }


        if (Block.byItem(heldItem) instanceof WetSpongeBlock){
            if (state.getValue(DIRTY)) {
                world.setBlockAndUpdate(pos, state.setValue(DIRTY, false));
                return InteractionResult.SUCCESS;
            }else {
                return InteractionResult.PASS;
            }
        }

        if (canAddCanvas && state.getBlock().asItem() == heldItem) {
            if (state.getValue(COUNT) == 3) {
                return InteractionResult.PASS;
            }
            world.setBlockAndUpdate(pos, state.setValue(COUNT, state.getValue(COUNT) + 1));
            heldStack.split(1);
            if (player.isCreative()) heldStack.grow(1);
            return InteractionResult.CONSUME_PARTIAL;
        }

        if (getPaintingsFromItem(heldItem) != Paintings.NONE){
            Paintings paintings = getPaintingsFromItem(heldItem);
            heldStack.split(1);
            if (player.isCreative()) heldStack.grow(1);
            if (!player.getInventory().add(getItemFromPaintings(state.getValue(PAINTINGS)))) player.spawnAtLocation(getItemFromPaintings(state.getValue(PAINTINGS)).getItem());
            world.setBlockAndUpdate(pos, state.setValue(PAINTINGS, paintings));
            return InteractionResult.SUCCESS;
        }

        if (heldStack.isEmpty()) {
            ItemStack giveStack = getItemFromPaintings(state.getValue(PAINTINGS));
            if (!player.getInventory().add(giveStack)) player.spawnAtLocation(heldStack.getItem());
            world.setBlockAndUpdate(pos, state.setValue(PAINTINGS, Paintings.NONE));
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState state = super.getStateForPlacement(ctx);
        if (state == null) return state;

        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Direction playerFacing = ctx.getHorizontalDirection();
        Direction directionOpp1 = playerFacing.getOpposite();

        BlockPos belowPos = pos.below();
        boolean hasBlockBelow = !world.isEmptyBlock(belowPos) && world.getBlockState(belowPos).isFaceSturdy(world, belowPos, Direction.UP);

        BlockPos directionPos = pos.relative(directionOpp1);
        boolean hasBlockInDirection = !world.isEmptyBlock(directionPos) &&
                world.getBlockState(directionPos).isFaceSturdy(world, directionPos, directionOpp1.getOpposite());

        if (hasBlockBelow && hasBlockInDirection) {
            state = state.setValue(PLACE_TYPE, PlacementState.CORNER)
                    .setValue(FACING, playerFacing);
        } else if (!hasBlockBelow && hasBlockInDirection) {
            state = state.setValue(PLACE_TYPE, PlacementState.WALL)
                    .setValue(FACING, playerFacing);
        } else if (hasBlockBelow) {
            for (Direction dir : Direction.Plane.HORIZONTAL) {
                BlockPos checkPos = pos.relative(dir);
                if (!world.isEmptyBlock(checkPos) && world.getBlockState(checkPos).isFaceSturdy(world, checkPos, dir.getOpposite())) {

                    state = state.setValue(PLACE_TYPE, PlacementState.CORNER)
                            .setValue(FACING, dir.getOpposite());
                    return state;
                }
            }
            return this.defaultBlockState().setValue(FACING, playerFacing.getOpposite()).setValue(RACK, true);
        } else {
            for (Direction dir : Direction.Plane.HORIZONTAL) {
                BlockPos checkPos = pos.relative(dir);
                if (!world.isEmptyBlock(checkPos) && world.getBlockState(checkPos).isFaceSturdy(world, checkPos, dir.getOpposite())) {
                    state = state.setValue(PLACE_TYPE, PlacementState.WALL)
                            .setValue(FACING, dir.getOpposite());
                    return state;
                }
            }
            return this.defaultBlockState().setValue(FACING, playerFacing.getOpposite()).setValue(RACK, true);
        }

        return this.defaultBlockState().setValue(FACING, playerFacing.getOpposite()).setValue(RACK, true);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COUNT, PLACE_TYPE, DIRTY, RACK);
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(world, player, pos, state, blockEntity, tool);
        if (player.isCreative()) return;
        int canvasItemToDropCount = state.getValue(COUNT) - 1;
        popResource(world, pos, state.is(ModBlocks.CANVAS) ? new ItemStack(ModBlocks.CANVAS, canvasItemToDropCount) : new ItemStack(ModBlocks.DRAWING_BOARD, canvasItemToDropCount));
        popResource(world, pos, getItemFromPaintings(state.getValue(PAINTINGS)));
    }
}