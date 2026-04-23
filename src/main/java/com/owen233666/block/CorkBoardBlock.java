package com.owen233666.block;

import com.owen233666.block.painting.PhotoType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CorkBoardBlock extends HorizontalDirectionalBlock {
    public static final BooleanProperty ABOVE = BooleanProperty.create("above");
    public static final BooleanProperty BELOW = BooleanProperty.create("below");
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    public static final BooleanProperty WHITE = BooleanProperty.create("white");
    public static final BooleanProperty HAS_PHOTO  = BooleanProperty.create("has_photo");
    public static final EnumProperty<PhotoType> PHOTO_TYPE = EnumProperty.create("photo_type", PhotoType.class);

    public static final VoxelShape FACING_N = box(0, 0, 14, 16,  16, 16);
    public static final VoxelShape FACING_S = box(0,  0, 0,  16, 16, 2);
    public static final VoxelShape FACING_E = box(14, 0, 0,  16, 16, 16);
    public static final VoxelShape FACING_W = box(2,  0, 0,  16, 16, 16);

    public CorkBoardBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, ABOVE, BELOW, LEFT, RIGHT, PHOTO_TYPE, HAS_PHOTO, WHITE);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return switch (blockState.getValue(FACING)) {
            case NORTH -> FACING_N;
            case SOUTH -> FACING_S;
            case WEST -> FACING_W;
            case EAST -> FACING_E;
            default -> FACING_N;
        };
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState2.is(blockState.getBlock())) {
//            level.setBlock(blockPos, blockState2, 2);

            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = blockPos.relative(direction);
                BlockState neighborState = level.getBlockState(neighborPos);
                if (neighborState.getBlock() instanceof CorkBoardBlock) {
                    level.setBlock(neighborPos, boardState(neighborState, level, neighborPos), 2);
                }
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        return boardState(blockState, levelAccessor, blockPos);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Direction facingDirectionOpposite = blockPlaceContext.getHorizontalDirection().getOpposite();
        LevelAccessor levelAccessor = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();

        BlockState baseState = super.getStateForPlacement(blockPlaceContext);
        if (baseState == null) {
            baseState = defaultBlockState();
        }

        BlockState stateWithFacing = baseState.setValue(FACING, facingDirectionOpposite);

        return boardState(stateWithFacing, levelAccessor, blockPos);
    }

    private BlockState boardState(BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos) {
        boolean above = isValidBoard(blockState, levelAccessor.getBlockState(blockPos.above()));
        boolean below = isValidBoard(blockState, levelAccessor.getBlockState(blockPos.below()));
        boolean left = isValidBoard(blockState, levelAccessor, blockPos, true);
        boolean right = isValidBoard(blockState, levelAccessor, blockPos, false);
        blockState = blockState
                .setValue(ABOVE, above)
                .setValue(BELOW, below)
                .setValue(LEFT, left)
                .setValue(RIGHT, right);
        return blockState;
    }

    //垂直方向可直接用这个方法
    private boolean isValidBoard(BlockState blockState1, BlockState blockState2) {
        Block block = blockState2.getBlock();
        if (block instanceof CorkBoardBlock) {
            Direction direction1 = blockState1.getValue(FACING);
            Direction direction2 = blockState2.getValue(FACING);
            return direction1 == direction2;
        }
        return false;
    }

    //水平方向用这个方法
    private boolean isValidBoard(BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos, boolean left) {
        Direction direction = blockState.getValue(FACING);
        BlockState blockState1 = levelAccessor.getBlockState(blockPos.above());
        switch (direction) {
            case NORTH -> blockState1 = left ? levelAccessor.getBlockState(blockPos.west() ) : levelAccessor.getBlockState(blockPos.east() );//left -> west;  right -> east
            case SOUTH -> blockState1 = left ? levelAccessor.getBlockState(blockPos.east() ) : levelAccessor.getBlockState(blockPos.west() );//left -> east;  right -> west
            case WEST  -> blockState1 = left ? levelAccessor.getBlockState(blockPos.south()) : levelAccessor.getBlockState(blockPos.north());//left -> south; right -> north
            case EAST  -> blockState1 = left ? levelAccessor.getBlockState(blockPos.north()) : levelAccessor.getBlockState(blockPos.south());//left -> north; right -> south
        }
        return isValidBoard(blockState, blockState1);
    }

}
