package com.owen233666.block.painting;

import com.owen233666.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GridShelfBlock extends AbstractPaintingBlock {
    public static final BooleanProperty WHITE = BooleanProperty.of("white");
    public static final EnumProperty<PhotoType> PHOTO_TYPE = EnumProperty.of("photo_type", PhotoType.class);

    public static final Supplier<VoxelShape> SHAPE_SUPPLIER = () -> Block.createCuboidShape(0, 0, 15F, 16, 16, 16);
    public static final Map<Direction, VoxelShape> SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_SUPPLIER.get()));
        }
    });

    public GridShelfBlock(Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager.getDefaultState()
                        .with(WHITE, true)
                        .with(PAINTINGS, Paintings.NONE)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(PHOTO_TYPE, WHITE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE.get(state.get(FACING));
    }

    public enum PhotoType implements StringIdentifiable {
        A("a"),
        B("b"),
        C("c");

        private final String name;

        PhotoType(String name) {
            this.name = name;
        }

        @Override
        public String asString() {
            return name;
        }

    }
}
