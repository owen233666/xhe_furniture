/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block.painting;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
//#if MC >= 12005
import net.minecraft.world.ItemInteractionResult;
//#endif
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CrayonBoxBlock extends HorizontalDirectionalBlock {
    public static final IntegerProperty STATE = IntegerProperty.create("state", 1, 3);

    public static final VoxelShape SHAPE = box(0, 0, 0, 16, 2, 16);

    public CrayonBoxBlock(Properties properties) {
        super(properties);
    }

    // 1.20.5 起 BlockBehaviour.codec() 是抽象方法，每个具体方块都要给出自己的 MapCodec。
    //#if MC >= 12005
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(CrayonBoxBlock::new);
    }
    //#endif

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, STATE);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Random random = new Random();
        return this.defaultBlockState()
                .setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())
                .setValue(STATE, random.nextInt(1, 4));
    }

    // 1.20.5 起 BlockBehaviour#use 被拆成 useItemOn / useWithoutItem。
    //#if MC >= 12005
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.isShiftKeyDown()) {
            int current = blockState.getValue(STATE);
            int next = current + 1 > 3 ? 1 : current + 1;
            level.setBlockAndUpdate(blockPos, blockState.setValue(STATE, next));
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    //#else
    //$$ @Override
    //$$ public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
    //$$     if (player.isShiftKeyDown()) {
    //$$         int current = blockState.getValue(STATE);
    //$$         int next = current + 1 > 3 ? 1 : current + 1;
    //$$         level.setBlockAndUpdate(blockPos, blockState.setValue(STATE, next));
    //$$         return InteractionResult.SUCCESS;
    //$$     }
    //$$     return InteractionResult.PASS;
    //$$ }
    //#endif

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }
}
