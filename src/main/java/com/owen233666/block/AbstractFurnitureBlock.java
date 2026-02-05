    package com.owen233666.block;

    import net.minecraft.block.Block;
    import net.minecraft.block.BlockState;
    import net.minecraft.item.ItemPlacementContext;
    import net.minecraft.state.StateManager;
    import net.minecraft.state.property.DirectionProperty;
    import net.minecraft.state.property.Property;
    import net.minecraft.util.math.BlockPos;
    import net.minecraft.util.math.Direction;
    import net.minecraft.world.World;
    import org.jetbrains.annotations.Nullable;

    public abstract class AbstractFurnitureBlock extends Block {
    //    protected VoxelShape SHAPE = Block.createCuboidShape(4.0d, 0.0d, 4.0d, 12.0d, 6.0d, 12.0d);
        protected static final DirectionProperty FACING = DirectionProperty.of("facing", new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST});
    //    public static final EnumProperty<EightDirection> FACING = EnumProperty.of("facing", EightDirection.class);


        public AbstractFurnitureBlock(Settings settings) {
            super(settings);
            // 初始化默认状态
            this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
        }

    //    @Override
    //    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    //        return SHAPE;
    //    }

        @Override
        public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
            if(!state.isOf(oldState.getBlock())){
                world.setBlockState(pos, state, 2);
            }
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(new Property[]{FACING});
        }

        @Override
        public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
    //        float playerYaw = ctx.getPlayerYaw();
    //
    //        float angle = playerYaw % 360;
    //        if (angle < 0) {
    //            angle += 360;
    //        }
    //
    //        EightDirection facing = getDirectionFromYaw(angle);
            return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
        }

    //    private static EightDirection getDirectionFromYaw(float yaw) {
    //        // Minecraft中：0=南，90=西，180=北，270=东
    //        // 我们需要将Minecraft的角度系统转换到我们的方向系统
    //
    //        // 调整角度：让0对应南，然后逆时针增加
    //        float adjustedYaw = (yaw + 180) % 360;
    //
    //        // 将360度分为8个45度的扇形
    //        int directionIndex = MathHelper.floor((adjustedYaw * 8.0F / 360.0F) + 0.5D) & 7;
    //
    //        return switch (directionIndex) {
    //            case 0 -> EightDirection.SOUTH;
    //            case 1 -> EightDirection.SOUTH_WEST;
    //            case 2 -> EightDirection.WEST;
    //            case 3 -> EightDirection.NORTH_WEST;
    //            case 4 -> EightDirection.NORTH;
    //            case 5 -> EightDirection.NORTH_EAST;
    //            case 6 -> EightDirection.EAST;
    //            case 7 -> EightDirection.SOUTH_EAST;
    //            default -> EightDirection.NORTH;
    //        };
    //    }
    //    public enum EightDirection implements StringIdentifiable {
    //        NORTH("north"),
    //        SOUTH("south"),
    //        WEST("west"),
    //        EAST("east"),
    //        NORTH_WEST("north_west"),
    //        NORTH_EAST("north_east"),
    //        SOUTH_WEST("south_west"),
    //        SOUTH_EAST("south_east");
    //
    //        private final String name;
    //        EightDirection(String name){this.name = name;}
    //
    //        @Override
    //        public @NotNull String asString() {
    //            return this.name;
    //        }
    //    }
    }