/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class PhotoCBlockEntity extends PhotoBlockEntity {
    public PhotoCBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.PHOTO_C_BLOCK_BE.get(), blockPos, blockState);
    }
}
