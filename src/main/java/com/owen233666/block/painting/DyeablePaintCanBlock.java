package com.owen233666.block.painting;

import com.owen233666.item.PaintBrushItem;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DyeablePaintCanBlock extends HorizontalFacingBlock {
    public static final BooleanProperty DIRTY = BooleanProperty.of("dirty");
    private final float x1, y1, z1, x2, y2, z2;

    public DyeablePaintCanBlock(Settings settings, float x1, float y1, float z1, float x2, float y2, float z2) {
        super(settings);
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
        this.setDefaultState(this.stateManager.getDefaultState().with(DIRTY, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, DIRTY);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(x1, y1, z1, x2, y2, z2);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getStackInHand(hand);
        Item heldItem = heldStack.getItem();

        if (heldItem instanceof PaintBrushItem){
            if (!state.get(DIRTY)){
                if (heldStack.getDamage() != heldStack.getMaxDamage()) {
                    world.setBlockState(pos, state.with(DIRTY, true));
                    heldStack.damage(1, player, (playerx) -> playerx.sendToolBreakStatus(hand));
                    return ActionResult.SUCCESS;
                }
            }else {
                if (getBlockFromItem(heldItem) instanceof WetSpongeBlock){
                    world.setBlockState(pos, state.with(DIRTY, false));
                    return ActionResult.SUCCESS;
                }
            }

            if (player.isSneaking()){
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
