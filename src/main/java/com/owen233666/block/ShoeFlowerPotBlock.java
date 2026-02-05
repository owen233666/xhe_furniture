package com.owen233666.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class ShoeFlowerPotBlock extends StorageBlock implements BlockEntityProvider {

//    private static final Supplier<VoxelShape> SHAPE_SUPPLIER = () -> {
//        VoxelShape shape = VoxelShapes.empty();
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(9.5, 0, 8,  10.5, 8, 11), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(5.5, 0, 8,  6.5,  8, 11), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(6.5, 2, 7,  9.5,  8, 8 ), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(6.5, 0, 4,  9.5,  2, 11), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(5.5, 0, 6,  6.5,  2, 8 ), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(6.5, 2, 5,  9.5,  3, 7 ), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(9.5, 0, 6,  10.5, 2, 8 ), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(6.5, 0, 11, 9.5,  8, 12), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(6.5, 2, 8,  9.5,  7, 11), BooleanBiFunction.OR);
//        return shape;
//    };
//
//    public static final Map<Direction, VoxelShape> SHAPE_BY_DIRECTION = Util.make(new HashMap<>(), map ->{
//        for(Direction direction : Direction.Type.HORIZONTAL) {
//            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_SUPPLIER.get()));
//        }
//    });

    public static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 12, 12);

    public ShoeFlowerPotBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        XheFurniture.LOGGER.debug("StorageBlock.getOutlineShape called"); //debug
        return SHAPE;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
//        XheFurniture.LOGGER.debug("StorageBlock.getPlacementState called"); //debug
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public Identifier type() {
        return ModBlocks.WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION;
    }

    @Override
    public Boolean canInsertStack(ItemStack stack) {
//        XheFurniture.LOGGER.info("=== canInsertStack 检查 ===");
//        XheFurniture.LOGGER.info("物品: {}", stack.getItem());
//        XheFurniture.LOGGER.info("物品ID: {}", Registries.ITEM.getId(stack.getItem()));
//
//        boolean isSmallFlower = stack.isIn(ItemTags.SMALL_FLOWERS);
//        XheFurniture.LOGGER.info("是否在小花标签中: {}", isSmallFlower);

//        // 打印所有标签以便调试
//        List<TagKey<Item>> tags = stack.streamTags().toList();
//        XheFurniture.LOGGER.info("物品的所有标签: {}", tags);

        return stack.isIn(ItemTags.SMALL_FLOWERS);
    }
}
