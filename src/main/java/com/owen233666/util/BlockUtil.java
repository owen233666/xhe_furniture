package com.owen233666.util;

import java.util.Arrays;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockUtil {
    public static VoxelShape rotateVoxelShape(Direction facing1, Direction facing2, VoxelShape voxelShape) {
        VoxelShape[] tempVoxelShape = new VoxelShape[]{voxelShape, Shapes.empty()};
        int times = (facing2.get2DDataValue() - facing1.get2DDataValue() + 4) % 4;

        for (int i = 0; i < times; ++i) {
            tempVoxelShape[0].forAllBoxes(
                    (minX, minY, minZ, maxX, maxY, maxZ) -> {
                        tempVoxelShape[1] = Shapes.joinUnoptimized(
                                tempVoxelShape[1],
                                Shapes.box(1.0 - maxZ, minY, minX, 1.0 - minZ, maxY, maxX),
                                BooleanOp.OR
                        );
                    }
            );
            tempVoxelShape[0] = tempVoxelShape[1];
            tempVoxelShape[1] = Shapes.empty();
        }
        return tempVoxelShape[0];
    }

    public static Optional<Tuple<Float, Float>> getHitSectionCoordinate(BlockHitResult blockHitResult, Direction direction, Direction[] unAllowedDirections) {
        Direction hitSide = blockHitResult.getDirection();

        // 检查是否点击了不允许的方向
        if (Arrays.asList(unAllowedDirections).contains(hitSide)) {
            return Optional.empty();
        }

        // 获取点击点在方块内部的相对坐标
        Vec3 hitPos = blockHitResult.getLocation();
        BlockPos blockPos = blockHitResult.getBlockPos();

        // 计算相对于方块左下角的坐标 (0,0,0 到 1,1,1)
        Vec3 relativePos = hitPos.subtract(blockPos.getX(), blockPos.getY(), blockPos.getZ());

        float x = (float) relativePos.x();
        float y = (float) relativePos.y();
        float z = (float) relativePos.z();

        return switch (hitSide) {
            case DOWN -> Optional.empty();
            case UP -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Tuple<>(1.0f - x, z));
                    case SOUTH -> Optional.of(new Tuple<>(x, z));
                    case WEST -> Optional.of(new Tuple<>(z, 1.0f - x));
                    case EAST -> Optional.of(new Tuple<>(1.0f - z, x));
                    default -> Optional.empty();
                };
            }
            case NORTH -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Tuple<>(x, y));
                    case SOUTH -> Optional.of(new Tuple<>(1.0f - x, y));
                    case WEST -> Optional.of(new Tuple<>(1.0f - y, x));
                    case EAST -> Optional.of(new Tuple<>(y, 1.0f - x));
                    default -> Optional.empty();
                };
            }
            case SOUTH -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Tuple<>(1.0f - x, y));
                    case SOUTH -> Optional.of(new Tuple<>(x, y));
                    case WEST -> Optional.of(new Tuple<>(y, 1.0f - x));
                    case EAST -> Optional.of(new Tuple<>(1.0f - y, x));
                    default -> Optional.empty();
                };
            }
            case WEST -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Tuple<>(z, y));
                    case SOUTH -> Optional.of(new Tuple<>(1.0f - z, y));
                    case WEST -> Optional.of(new Tuple<>(x, y));
                    case EAST -> Optional.of(new Tuple<>(1.0f - x, y));
                    default -> Optional.empty();
                };
            }
            case EAST -> {
                yield switch (direction) {
                    case NORTH -> Optional.of(new Tuple<>(1.0f - z, y));
                    case SOUTH -> Optional.of(new Tuple<>(z, y));
                    case WEST -> Optional.of(new Tuple<>(1.0f - x, y));
                    case EAST -> Optional.of(new Tuple<>(x, y));
                    default -> Optional.empty();
                };
            }
        };
    }
}