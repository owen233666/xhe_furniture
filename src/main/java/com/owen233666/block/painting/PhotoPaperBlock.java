package com.owen233666.block.painting;

import com.owen233666.block.entity.EaselBlockEntity;
import com.owen233666.block.entity.PhotoBlockEntity;
import com.owen233666.item.ModItemTags;
import com.owen233666.util.BlockUtil;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.StateDefinition;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class PhotoPaperBlock extends AbstractPaintingBlock implements EntityBlock {

    public static final Supplier<VoxelShape> SHAPE_SUPPLIER = () -> Block.box(0, 0, 15F, 16, 16, 16);
    public static final Map<Direction, VoxelShape> SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_SUPPLIER.get()));
        }
    });

    public PhotoPaperBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE.get(state.getValue(FACING));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        Item heldItem = heldStack.getItem();
        BlockEntity be = world.getBlockEntity(pos);
        NonNullList<ItemStack> inventory;

        //初始化inventory
        if (be instanceof EaselBlockEntity){
            inventory = ((EaselBlockEntity) be).getInv();
        }else {
            inventory = NonNullList.withSize(1, ItemStack.EMPTY);
        }
        //判断是否有画（获取be的inventory）
        boolean hasPainting =!(inventory.getFirst() == ItemStack.EMPTY);


        if (be instanceof PhotoBlockEntity photoBlockEntity) {
            boolean heldIsPainting = BuiltInRegistries.ITEM.wrapAsHolder(heldItem).is(ModItemTags.PAINTINGS);
            //方块实体inv为空
            if (!(inventory.isEmpty() || inventory.getFirst() == ItemStack.EMPTY)) {
                //手上拿的东西是画
                if (heldIsPainting){
                    addItem(world, pos, player, photoBlockEntity, heldStack);
                    return InteractionResult.CONSUME;
                }else {
                    remove(world, pos, player, photoBlockEntity);
                    return InteractionResult.PASS;
                }
                //方块实体inv不为空
            }else {
                //手上拿的东西是画
                if (heldIsPainting){
                    remove(world, pos, player, photoBlockEntity);
                    addItem(world, pos, player, photoBlockEntity, heldStack);
                    return InteractionResult.CONSUME;
                }else{
                    remove(world, pos, player, photoBlockEntity);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClientSide) {
            return;
        }

        Direction facing = state.getValue(FACING);
        BlockPos behindPos = pos.relative(facing.getOpposite());

        if (world.getBlockState(behindPos).isAir()) {
            world.destroyBlock(pos, true);
        }

        super.neighborChanged(state, world, pos, sourceBlock, sourcePos, notify);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockPos behindPos = pos.relative(facing.getOpposite());
        BlockState behindState = world.getBlockState(behindPos);
        return !behindState.isAir() && behindState.isSolid();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction facing = ctx.getHorizontalDirection().getOpposite();
        BlockPos pos = ctx.getClickedPos();
        Level world = ctx.getLevel();

        BlockPos behindPos = pos.relative(facing.getOpposite());
        if (!world.getBlockState(behindPos).isAir() && world.getBlockState(behindPos).isRedstoneConductor(world, behindPos)) {
            return this.defaultBlockState().setValue(FACING, facing);
        }
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (direction == facing) continue;

            BlockPos checkBehindPos = pos.relative(direction.getOpposite());
            if (!world.getBlockState(checkBehindPos).isAir() && world.getBlockState(checkBehindPos).isRedstoneConductor(world, checkBehindPos)) {
                return this.defaultBlockState().setValue(FACING, direction);
            }
        }
        return null;
    }

    public void addItem(Level world, BlockPos pos, Player player, PhotoBlockEntity photoBlockEntity, ItemStack stack){

        if(!world.isClientSide()) {
            photoBlockEntity.setStack(stack.split(1));
            world.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

            if(player.isCreative()) {
                stack.grow(1);
            }
        }
    }

    public void remove(Level world, BlockPos pos, Player player, PhotoBlockEntity photoBlockEntity){
        if(!world.isClientSide()) {
            ItemStack toRemoveStack =photoBlockEntity.removeStack();
            world.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().add(toRemoveStack)){
                player.spawnAtLocation(toRemoveStack);
            }
        }
    }

//    @Override
//    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
//        super.playerDestroy(world, player, pos, state, blockEntity, tool);
//        if (player.isCreative()) return;
//        ItemStack painting = getItemFromPaintings(state.getValue(PAINTINGS));
//        popResource(world, pos, painting);
//    }
}
