package com.owen233666.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class PhotoCBlockEntity extends PhotoBlockEntity {
    public PhotoCBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.PHOTO_B_BLOCK_BE, blockPos, blockState);
    }
}
