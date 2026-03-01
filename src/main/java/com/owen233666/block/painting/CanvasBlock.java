package com.owen233666.block.painting;

import com.owen233666.block.entity.CanvasBlockEntity;
import com.owen233666.block.entity.EaselBlockEntity;
import com.owen233666.item.ModItemTags;
import com.owen233666.item.PaintBrushItem;
import com.owen233666.util.BlockUtil;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
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

public class CanvasBlock extends HorizontalDirectionalBlock implements EntityBlock {
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CanvasBlockEntity(blockPos, blockState);
    }

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
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, COUNT, PLACE_TYPE, DIRTY, RACK);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(PLACE_TYPE) == PlacementState.WALL ? SHAPE_WALL.get(state.getValue(FACING)) : SHAPE_CORNER.get(state.getValue(FACING));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        Item heldItem = heldStack.getItem();
        BlockEntity be = level.getBlockEntity(pos);
        NonNullList<ItemStack> inventory;
        boolean canAddCanvas = !state.getValue(RACK);

        //初始化inventory
        if (be instanceof EaselBlockEntity){
            inventory = ((EaselBlockEntity) be).getInv();
        }else {
            inventory = NonNullList.withSize(1, ItemStack.EMPTY);
        }
        //判断是否有画（获取be的inventory）
        boolean hasPainting =!(inventory.getFirst() == ItemStack.EMPTY);

        if (heldItem instanceof PaintBrushItem) {
            if (state.getValue(DIRTY)) return InteractionResult.PASS;
            if (heldStack.getDamageValue() == heldItem.getMaxDamage()) return InteractionResult.PASS;
            level.setBlockAndUpdate(pos, state.setValue(DIRTY, true));
            if (!player.isCreative()) heldStack.hurtAndBreak(1, player, (entity) -> {});
            return InteractionResult.SUCCESS;
        }


        if (Block.byItem(heldItem) instanceof WetSpongeBlock){
            if (state.getValue(DIRTY)) {
                level.setBlockAndUpdate(pos, state.setValue(DIRTY, false));
                return InteractionResult.SUCCESS;
            }else {
                return InteractionResult.PASS;
            }
        }

        if (canAddCanvas && state.getBlock().asItem() == heldItem) {
            if (state.getValue(COUNT) == 3) {
                return InteractionResult.PASS;
            }
            level.setBlockAndUpdate(pos, state.setValue(COUNT, state.getValue(COUNT) + 1));
            heldStack.split(1);
            if (player.isCreative()) heldStack.grow(1);
            return InteractionResult.CONSUME_PARTIAL;
        }

        if (be instanceof CanvasBlockEntity canvasBlockEntity){
            boolean heldIsPainting = BuiltInRegistries.ITEM.wrapAsHolder(heldItem).is(ModItemTags.PAINTINGS);

            //有画
            if (hasPainting) {
                //手上是画
                if (heldIsPainting){
                    remove(level, pos, player, canvasBlockEntity);
                    addItem(level, pos, player, canvasBlockEntity, heldStack);
                    return InteractionResult.CONSUME;
                }else {
                    remove(level, pos, player, canvasBlockEntity);
                    return InteractionResult.SUCCESS;
                }
            }else{
                if (heldIsPainting){
                    addItem(level, pos, player, canvasBlockEntity, heldStack);
                    return InteractionResult.CONSUME;
                }
            }
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

    //向be的inv中添加物品的方法
    public void addItem(Level level, BlockPos pos, Player player, CanvasBlockEntity canvasBlockEntity, ItemStack stack){
        if(!level.isClientSide()) {
            canvasBlockEntity.setStack(stack.split(1));
            level.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

            if(player.isCreative()) {
                stack.grow(1);
            }
        }
    }

    public void remove(Level level, BlockPos pos, Player player, CanvasBlockEntity canvasBlockEntity){
        if(!level.isClientSide()) {
            ItemStack toRemoveStack =canvasBlockEntity.removeStack();

            level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().add(toRemoveStack)){
                player.spawnAtLocation(toRemoveStack);
            }
        }
    }

}