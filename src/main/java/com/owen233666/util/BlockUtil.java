package com.owen233666.util;

import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class BlockUtil {
    public static VoxelShape rotateVoxelShape(Direction facing1, Direction facing2, VoxelShape voxelShape) {
        VoxelShape[] tempVoxelShape = new VoxelShape[]{voxelShape, VoxelShapes.empty()};
        int times = (facing2.getHorizontal() - facing1.getHorizontal() + 4) % 4;

        for (int i = 0; i < times; ++i) {
            tempVoxelShape[0].forEachBox(
                    (minX, minY, minZ, maxX, maxY, maxZ) -> {
                        tempVoxelShape[1] = VoxelShapes.combine(
                                tempVoxelShape[1],
                                VoxelShapes.cuboid(1.0 - maxZ, minY, minX, 1.0 - minZ, maxY, maxX),
                                BooleanBiFunction.OR
                        );
                    }
            );
            tempVoxelShape[0] = tempVoxelShape[1];
            tempVoxelShape[1] = VoxelShapes.empty();
        }
        return tempVoxelShape[0];
    }
}
