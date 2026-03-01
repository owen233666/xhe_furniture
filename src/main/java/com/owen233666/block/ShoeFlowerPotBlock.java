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
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class ShoeFlowerPotBlock extends StorageBlock implements BlockEntityProvider {

    public static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 12, 12);

    public ShoeFlowerPotBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
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
        return stack.isIn(ItemTags.SMALL_FLOWERS);
    }

    @Override
    public Direction[] unAllowedDirections() {
        return new Direction[]{Direction.DOWN};
    }

    @Override
    public int getSection(float x, float y) {
        return 0;
    }
}
