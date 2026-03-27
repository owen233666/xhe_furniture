package com.owen233666.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class GridShelfBlockEntity extends PhotoBlockEntity {
    public GridShelfBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.GRID_SHELF_BLOCK_BE, blockPos, blockState);
    }
}
