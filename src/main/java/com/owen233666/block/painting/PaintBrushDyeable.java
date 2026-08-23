package com.owen233666.block.painting;

import com.owen233666.item.PaintBrushItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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

    default InteractionResult dyeWithBrush(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        Item heldItem = heldStack.getItem();

        BooleanProperty dirty = getDirtyProperty();
        if (dirty == null) {
            return InteractionResult.PASS;
        }

        boolean isDirty = state.getValue(dirty);

        // 洗色：湿海绵可以清洗，无需手持颜料刷。而如果方块是干净的，湿海绵不消耗。
        if (isDirty && Block.byItem(heldItem) instanceof WetSpongeBlock) {
            level.setBlockAndUpdate(pos, state.setValue(dirty, false));
            return InteractionResult.SUCCESS;
        }

        // 染色：只有手持颜料刷且耐久未耗尽时才生效。
        if (!(heldItem instanceof PaintBrushItem) || !canDyeWithBrush(state)) {
            return InteractionResult.PASS;
        }

        if (!isDirty) {
            if (heldStack.getDamageValue() != heldStack.getMaxDamage()) {
                level.setBlockAndUpdate(pos, state.setValue(dirty, true));
                if (!player.isCreative()) {
                    heldStack.hurtAndBreak(1, player, (playerx) -> playerx.broadcastBreakEvent(hand));
                }
                return InteractionResult.SUCCESS;
            }
        }

        if (player.isShiftKeyDown()) {
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
