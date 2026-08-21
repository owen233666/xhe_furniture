package com.owen233666.block.painting;
import net.minecraft.world.ItemInteractionResult;
import com.mojang.serialization.MapCodec;

import com.owen233666.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PaintBrushBlock extends HorizontalDirectionalBlock {
    public static final IntegerProperty DURABILITY = IntegerProperty.create("durability", 0, 64);
    public static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 2, 15);

    public PaintBrushBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, DURABILITY);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (Block.byItem(player.getItemInHand(hand).getItem()) instanceof WetSpongeBlock && state.getValue(DURABILITY) != 0){
            world.setBlockAndUpdate(pos, state.setValue(DURABILITY, 0));
            return ItemInteractionResult.SUCCESS;
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(world, player, pos, state, blockEntity, tool);
        if (player.isCreative()) return;
        int durability = state.getValue(DURABILITY);
        ItemStack toDropStack = new ItemStack(ModItems.PAINT_BRUSH, 1);
        toDropStack.setDamageValue(new ItemStack(ModItems.PAINT_BRUSH).getMaxDamage() - durability);
        popResource(world, pos, toDropStack);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(PaintBrushBlock::new);
    }

}