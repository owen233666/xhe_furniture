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
        Direction hitSide = blockHitResult.getSide();

        // 检查是否点击了不允许的方向
        if (Arrays.asList(unAllowedDirections).contains(hitSide)) {
            return Optional.empty();
        }

        // 获取点击点在方块内部的相对坐标
        Vec3d hitPos = blockHitResult.getPos();
        BlockPos blockPos = blockHitResult.getBlockPos();

        // 计算相对于方块左下角的坐标 (0,0,0 到 1,1,1)
        Vec3d relativePos = hitPos.subtract(blockPos.getX(), blockPos.getY(), blockPos.getZ());

        float x = (float) relativePos.getX();
        float y = (float) relativePos.getY();
        float z = (float) relativePos.getZ();

        return switch (hitSide) {
            case DOWN -> Optional.empty();
            case UP -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Pair<>(1.0f - x, z));
                    case SOUTH -> Optional.of(new Pair<>(x, z));
                    case WEST -> Optional.of(new Pair<>(z, 1.0f - x));
                    case EAST -> Optional.of(new Pair<>(1.0f - z, x));
                    default -> Optional.empty();
                };
            }
            case NORTH -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Pair<>(x, y));
                    case SOUTH -> Optional.of(new Pair<>(1.0f - x, y));
                    case WEST -> Optional.of(new Pair<>(1.0f - y, x));
                    case EAST -> Optional.of(new Pair<>(y, 1.0f - x));
                    default -> Optional.empty();
                };
            }
            case SOUTH -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Pair<>(1.0f - x, y));
                    case SOUTH -> Optional.of(new Pair<>(x, y));
                    case WEST -> Optional.of(new Pair<>(y, 1.0f - x));
                    case EAST -> Optional.of(new Pair<>(1.0f - y, x));
                    default -> Optional.empty();
                };
            }
            case WEST -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Pair<>(z, y));
                    case SOUTH -> Optional.of(new Pair<>(1.0f - z, y));
                    case WEST -> Optional.of(new Pair<>(x, y));
                    case EAST -> Optional.of(new Pair<>(1.0f - x, y));
                    default -> Optional.empty();
                };
            }
            case EAST -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Pair<>(1.0f - z, y));
                    case SOUTH -> Optional.of(new Pair<>(z, y));
                    case WEST -> Optional.of(new Pair<>(1.0f - x, y));
                    case EAST -> Optional.of(new Pair<>(x, y));
                    default -> Optional.empty();
                };
            }
        };
    }
}