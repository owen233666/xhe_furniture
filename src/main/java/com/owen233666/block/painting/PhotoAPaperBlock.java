package com.owen233666.block.painting;

import com.owen233666.block.entity.PhotoABlockEntity;
import com.owen233666.block.entity.PhotoBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PhotoAPaperBlock extends PhotoPaperBlock{
    public PhotoAPaperBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PhotoABlockEntity(blockPos, blockState);
    }
}
