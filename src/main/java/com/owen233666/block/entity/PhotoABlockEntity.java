package com.owen233666.block.entity;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class PhotoABlockEntity extends PhotoBlockEntity {
    public PhotoABlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.PHOTO_A_BLOCK_BE, blockPos, blockState);
    }
}