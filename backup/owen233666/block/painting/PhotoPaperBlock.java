package com.owen233666.block.painting;

import com.owen233666.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PhotoPaperBlock extends AbstractPaintingBlock{

    public static final Supplier<VoxelShape> SHAPE_SUPPLIER = () -> Block.createCuboidShape(0, 0, 15F, 16, 16, 16);
    public static final Map<Direction, VoxelShape> SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_SUPPLIER.get()));
        }
    });

    public PhotoPaperBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(PAINTINGS, Paintings.NONE));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE.get(state.get(FACING));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Paintings paintingsTo = getPaintingsFromItem(player.getStackInHand(hand).getItem());
        Paintings paintingsOn = state.get(PAINTINGS);
        ItemStack heldStack = player.getStackInHand(hand);
        if (paintingsTo != Paintings.NONE){
            ItemStack giveStack = getItemFromPaintings(paintingsOn);
            heldStack.split(1);
            if (player.isCreative()) heldStack.increment(1);
            if (!player.getInventory().insertStack(giveStack)) player.dropStack(giveStack);
            world.setBlockState(pos, state.with(PAINTINGS, paintingsTo));
            return ActionResult.CONSUME_PARTIAL;
        }else if (paintingsOn != Paintings.NONE){
            ItemStack giveStack = getItemFromPaintings(paintingsOn);
            if (!player.getInventory().insertStack(giveStack)) player.dropStack(giveStack);
            world.setBlockState(pos, state.with(PAINTINGS, Paintings.NONE));
            return ActionResult.SUCCESS;
        }else {
            return ActionResult.PASS;
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }

        Direction facing = state.get(FACING);
        BlockPos behindPos = pos.offset(facing.getOpposite());

        if (world.getBlockState(behindPos).isAir()) {
            world.breakBlock(pos, true);
        }

        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction facing = state.get(FACING);
        BlockPos behindPos = pos.offset(facing.getOpposite());
        BlockState behindState = world.getBlockState(behindPos);
        return !behindState.isAir() && behindState.isSolid();
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction facing = ctx.getHorizontalPlayerFacing().getOpposite();
        BlockPos pos = ctx.getBlockPos();
        World world = ctx.getWorld();

        BlockPos behindPos = pos.offset(facing.getOpposite());
        if (!world.getBlockState(behindPos).isAir() && world.getBlockState(behindPos).isSolidBlock(world, behindPos)) {
            return this.getDefaultState().with(FACING, facing);
        }
        for (Direction direction : Direction.Type.HORIZONTAL) {
            if (direction == facing) continue;

            BlockPos checkBehindPos = pos.offset(direction.getOpposite());
            if (!world.getBlockState(checkBehindPos).isAir() && world.getBlockState(checkBehindPos).isSolidBlock(world, checkBehindPos)) {
                return this.getDefaultState().with(FACING, direction);
            }
        }
        return null;
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
        if (player.isCreative()) return;
        ItemStack painting = getItemFromPaintings(state.get(PAINTINGS));
        dropStack(world, pos, painting);
    }
}
