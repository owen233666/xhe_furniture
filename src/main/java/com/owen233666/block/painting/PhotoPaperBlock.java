package com.owen233666.block.painting;

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

public class PhotoPaperBlock extends AbstractPaintingBlock{

    public static final Supplier<VoxelShape> SHAPE_SUPPLIER = () -> Block.box(0, 0, 15F, 16, 16, 16);
    public static final Map<Direction, VoxelShape> SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_SUPPLIER.get()));
        }
    });

    public PhotoPaperBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(PAINTINGS, Paintings.NONE));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE.get(state.getValue(FACING));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        Paintings paintingsTo = getPaintingsFromItem(player.getItemInHand(hand).getItem());
        Paintings paintingsOn = state.getValue(PAINTINGS);
        ItemStack heldStack = player.getItemInHand(hand);
        if (paintingsTo != Paintings.NONE){
            ItemStack giveStack = getItemFromPaintings(paintingsOn);
            heldStack.split(1);
            if (player.isCreative()) heldStack.grow(1);
            if (!player.getInventory().add(giveStack)) player.spawnAtLocation(giveStack);
            world.setBlockAndUpdate(pos, state.setValue(PAINTINGS, paintingsTo));
            return InteractionResult.CONSUME_PARTIAL;
        }else if (paintingsOn != Paintings.NONE){
            ItemStack giveStack = getItemFromPaintings(paintingsOn);
            if (!player.getInventory().add(giveStack)) player.spawnAtLocation(giveStack);
            world.setBlockAndUpdate(pos, state.setValue(PAINTINGS, Paintings.NONE));
            return InteractionResult.SUCCESS;
        }else {
            return InteractionResult.PASS;
        }
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

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(world, player, pos, state, blockEntity, tool);
        if (player.isCreative()) return;
        ItemStack painting = getItemFromPaintings(state.getValue(PAINTINGS));
        popResource(world, pos, painting);
    }
}
