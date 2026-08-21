package com.owen233666.block.painting;

import com.owen233666.item.PaintBrushItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public interface PaintBrushDyeable {

    BooleanProperty getDirtyProperty();
    default boolean canDyeWithBrush(BlockState state) {
        return true;
    }

    default ItemInteractionResult dyeWithBrush(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);

        if (!(heldStack.getItem() instanceof PaintBrushItem) || !canDyeWithBrush(state)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        BooleanProperty dirty = getDirtyProperty();
        if (dirty == null) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        if (!state.getValue(dirty)) {
            if (heldStack.getDamageValue() != heldStack.getMaxDamage()) {
                level.setBlockAndUpdate(pos, state.setValue(dirty, true));
                if (!player.isCreative() && level instanceof ServerLevel serverLevel) {
                    heldStack.hurtAndBreak(1, serverLevel, player, (item) -> {});
                }
                return ItemInteractionResult.SUCCESS;
            }
        } else {
            if (Block.byItem(heldStack.getItem()) instanceof WetSpongeBlock) {
                level.setBlockAndUpdate(pos, state.setValue(dirty, false));
                return ItemInteractionResult.SUCCESS;
            }
        }

        if (player.isShiftKeyDown()) {
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}