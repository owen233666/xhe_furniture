package com.owen233666.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SimpleHorizontalDirectionalBlock extends HorizontalDirectionalBlock {
    private static VoxelShape SHAPE;
    protected SimpleHorizontalDirectionalBlock(Properties properties, VoxelShape shape) {
        super(properties);
        this.SHAPE = shape;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }
}
