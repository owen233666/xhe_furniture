package com.owen233666.block.painting;

import com.owen233666.item.ModItems;
import com.owen233666.item.PaintBrushItem;
import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PaintCanBlock extends HorizontalDirectionalBlock {
    public static final BooleanProperty DIRTY = BooleanProperty.create("dirty");
    private final float x1, y1, z1, x2, y2, z2;

    public PaintCanBlock(Properties settings, float x1, float y1, float z1, float x2, float y2, float z2) {
        super(settings);
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
        this.registerDefaultState(this.stateDefinition.any().setValue(DIRTY, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, DIRTY);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(x1, y1, z1, x2, y2, z2);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        Item heldItem = heldStack.getItem();

        if (heldItem instanceof PaintBrushItem){
            if (!state.getValue(DIRTY)){
                if (heldStack.getDamageValue() != heldStack.getMaxDamage()) {
                    world.setBlockAndUpdate(pos, state.setValue(DIRTY, true));
                    heldStack.hurtAndBreak(1, player, (playerx) -> playerx.broadcastBreakEvent(hand));
                    return InteractionResult.SUCCESS;
                }
            }else {
                if (byItem(heldItem) instanceof WetSpongeBlock){
                    world.setBlockAndUpdate(pos, state.setValue(DIRTY, false));
                    return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.PASS;
        }
        return super.use(state, world, pos, player, hand, hit);
    }
}
