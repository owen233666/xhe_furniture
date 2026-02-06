package com.owen233666.util;

import net.minecraft.util.Pair;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.Arrays;
import java.util.Optional;

public class BlockUtil {
    @Deprecated
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

    public static Optional<Pair<Float, Float>> getHitSectionCoordinate(BlockHitResult blockHitResult, Direction direction, Direction[] unAllowedDirections) {
        Direction direction2 = blockHitResult.getSide();
        if (Arrays.asList(unAllowedDirections).contains(direction2)) {
            return Optional.empty();
        } else if (direction != direction2 && direction2 != Direction.UP && direction2 != Direction.DOWN) {
            return Optional.empty();
        } else {
            BlockPos blockPos = blockHitResult.getBlockPos().offset(direction2);
            Vec3d vec3d = blockHitResult.getPos().subtract(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            float d = (float) vec3d.getX(), f = (float) vec3d.getY(), y = (float) vec3d.getZ();

            if (direction2 == Direction.UP || direction2 == Direction.DOWN) {
                direction2 = direction;
            }

            return switch (direction2) {
                case NORTH -> Optional.of(new Pair<>((float) (1.0 - d), y));
                case SOUTH -> Optional.of(new Pair<>(d, y));
                case WEST -> Optional.of(new Pair<>(f, y));
                case EAST -> Optional.of(new Pair<>((float) (1.0 - f), y));
                case DOWN, UP -> Optional.empty();
            };
        }
    }
}
