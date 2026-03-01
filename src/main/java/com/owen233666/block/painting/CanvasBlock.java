package com.owen233666.block.painting;

import com.owen233666.block.ModBlocks;
import com.owen233666.item.PaintBrushItem;
import com.owen233666.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.WetSpongeBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CanvasBlock extends AbstractPaintingBlock {

    public static final IntProperty COUNT = IntProperty.of("count", 1, 3);
    public static final BooleanProperty DIRTY = BooleanProperty.of("dirty");
    public static final BooleanProperty RACK = BooleanProperty.of("rack");
    public static final EnumProperty<PlacementState> PLACE_TYPE = EnumProperty.of("type", PlacementState.class);


    public static final Supplier<VoxelShape> SHAPE_WALL_SUPPLIER = () -> Block.createCuboidShape(0, 0, 15, 16, 16, 16);
    public static final Supplier<VoxelShape> SHAPE_CORNER_SUPPLIER = () -> Block.createCuboidShape(0, 0, 6, 16, 16, 16);
    public static final Map<Direction, VoxelShape> SHAPE_WALL = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_WALL_SUPPLIER.get()));
        }
    });
    public static final Map<Direction, VoxelShape> SHAPE_CORNER = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_CORNER_SUPPLIER.get()));
        }
    });


    public CanvasBlock(Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager.getDefaultState()
                        .with(COUNT, 1)
                        .with(DIRTY, false)
                        .with(RACK, false)
                        .with(PLACE_TYPE, PlacementState.CORNER)
                        .with(PAINTINGS, Paintings.NONE)
        );
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(PLACE_TYPE) == PlacementState.WALL ? SHAPE_WALL.get(state.get(FACING)) : SHAPE_CORNER.get(state.get(FACING));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getStackInHand(hand);
        Item heldItem = heldStack.getItem();
        boolean canAddCanvas = !state.get(RACK);

        if (heldItem instanceof PaintBrushItem) {
            if (state.get(DIRTY)) return ActionResult.PASS;
            if (heldStack.getDamage() == heldItem.getMaxDamage()) return ActionResult.PASS;
            world.setBlockState(pos, state.with(DIRTY, true));
            if (!player.isCreative()) heldStack.damage(1, player, (entity) -> {});
            return ActionResult.SUCCESS;
        }


        if (Block.getBlockFromItem(heldItem) instanceof WetSpongeBlock){
            if (state.get(DIRTY)) {
                world.setBlockState(pos, state.with(DIRTY, false));
                return ActionResult.SUCCESS;
            }else {
                return ActionResult.PASS;
            }
        }

        if (canAddCanvas && state.getBlock().asItem() == heldItem) {
            if (state.get(COUNT) == 3) {
                return ActionResult.PASS;
            }
            world.setBlockState(pos, state.with(COUNT, state.get(COUNT) + 1));
            heldStack.split(1);
            if (player.isCreative()) heldStack.increment(1);
            return ActionResult.CONSUME_PARTIAL;
        }

        if (getPaintingsFromItem(heldItem) != Paintings.NONE){
            Paintings paintings = getPaintingsFromItem(heldItem);
            heldStack.split(1);
            if (player.isCreative()) heldStack.increment(1);
            if (!player.getInventory().insertStack(getItemFromPaintings(state.get(PAINTINGS)))) player.dropItem(getItemFromPaintings(state.get(PAINTINGS)).getItem());
            world.setBlockState(pos, state.with(PAINTINGS, paintings));
            return ActionResult.SUCCESS;
        }

        if (heldStack.isEmpty()) {
            ItemStack giveStack = getItemFromPaintings(state.get(PAINTINGS));
            if (!player.getInventory().insertStack(giveStack)) player.dropItem(heldStack.getItem());
            world.setBlockState(pos, state.with(PAINTINGS, Paintings.NONE));
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = super.getPlacementState(ctx);
        if (state == null) return state;

        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        Direction playerFacing = ctx.getHorizontalPlayerFacing();
        Direction directionOpp1 = playerFacing.getOpposite();

        BlockPos belowPos = pos.down();
        boolean hasBlockBelow = !world.isAir(belowPos) && world.getBlockState(belowPos).isSideSolidFullSquare(world, belowPos, Direction.UP);

        BlockPos directionPos = pos.offset(directionOpp1);
        boolean hasBlockInDirection = !world.isAir(directionPos) &&
                world.getBlockState(directionPos).isSideSolidFullSquare(world, directionPos, directionOpp1.getOpposite());

        if (hasBlockBelow && hasBlockInDirection) {
            state = state.with(PLACE_TYPE, PlacementState.CORNER)
                    .with(FACING, playerFacing);
        } else if (!hasBlockBelow && hasBlockInDirection) {
            state = state.with(PLACE_TYPE, PlacementState.WALL)
                    .with(FACING, playerFacing);
        } else if (hasBlockBelow) {
            for (Direction dir : Direction.Type.HORIZONTAL) {
                BlockPos checkPos = pos.offset(dir);
                if (!world.isAir(checkPos) && world.getBlockState(checkPos).isSideSolidFullSquare(world, checkPos, dir.getOpposite())) {

                    state = state.with(PLACE_TYPE, PlacementState.CORNER)
                            .with(FACING, dir.getOpposite());
                    return state;
                }
            }
            return this.getDefaultState().with(FACING, playerFacing.getOpposite()).with(RACK, true);
        } else {
            for (Direction dir : Direction.Type.HORIZONTAL) {
                BlockPos checkPos = pos.offset(dir);
                if (!world.isAir(checkPos) && world.getBlockState(checkPos).isSideSolidFullSquare(world, checkPos, dir.getOpposite())) {
                    state = state.with(PLACE_TYPE, PlacementState.WALL)
                            .with(FACING, dir.getOpposite());
                    return state;
                }
            }
            return this.getDefaultState().with(FACING, playerFacing.getOpposite()).with(RACK, true);
        }

        return this.getDefaultState().with(FACING, playerFacing.getOpposite()).with(RACK, true);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(COUNT, PLACE_TYPE, DIRTY, RACK);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
        if (player.isCreative()) return;
        int canvasItemToDropCount = state.get(COUNT) - 1;
        dropStack(world, pos, state.isOf(ModBlocks.CANVAS) ? new ItemStack(ModBlocks.CANVAS, canvasItemToDropCount) : new ItemStack(ModBlocks.DRAWING_BOARD, canvasItemToDropCount));
        dropStack(world, pos, getItemFromPaintings(state.get(PAINTINGS)));
    }
}