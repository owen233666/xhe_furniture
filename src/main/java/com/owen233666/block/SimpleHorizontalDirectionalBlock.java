/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SimpleHorizontalDirectionalBlock extends HorizontalDirectionalBlock {
    private static VoxelShape SHAPE;
    protected SimpleHorizontalDirectionalBlock(Properties properties, VoxelShape shape) {
        super(properties);
        SHAPE = shape;
    }

    // simpleCodec 需要一个只接受 Properties 的构造器；形状用默认满方块占位，
    // 真正的形状由使用 2 参构造器的调用方传入（本类当前只在 ModBlocks 之外预留）。
    //#if MC >= 12005
    protected SimpleHorizontalDirectionalBlock(Properties properties) {
        this(properties, Block.box(0, 0, 0, 16, 16, 16));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(SimpleHorizontalDirectionalBlock::new);
    }
    //#endif

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }
}
