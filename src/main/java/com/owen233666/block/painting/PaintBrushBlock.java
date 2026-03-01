package com.owen233666.block.painting;

import com.owen233666.block.ModBlocks;
import com.owen233666.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PaintBrushBlock extends HorizontalFacingBlock {
    public static final IntProperty DURABILITY = IntProperty.of("durability", 0, 64);
    public static final VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 15, 2, 15);

    public PaintBrushBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, DURABILITY);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (Block.getBlockFromItem(player.getStackInHand(hand).getItem()) instanceof WetSpongeBlock && state.get(DURABILITY) != 0){
            world.setBlockState(pos, state.with(DURABILITY, 0));
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
        if (player.isCreative()) return;
        int durability = state.get(DURABILITY);
        ItemStack toDropStack = new ItemStack(ModItems.PAINT_BRUSH, 1);
        toDropStack.setDamage(ModItems.PAINT_BRUSH.getMaxDamage() - durability);
        dropStack(world, pos, toDropStack);
    }
}
