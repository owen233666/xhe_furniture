/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block.painting;

import com.owen233666.item.PaintBrushItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
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

        if (isDirty && Block.byItem(heldItem) instanceof WetSpongeBlock) {
            level.setBlockAndUpdate(pos, state.setValue(dirty, false));
            return InteractionResult.SUCCESS;
        }

        if (!(heldItem instanceof PaintBrushItem) || !canDyeWithBrush(state)) {
            return InteractionResult.PASS;
        }

        if (!isDirty) {
            if (heldStack.getDamageValue() != heldStack.getMaxDamage()) {
                level.setBlockAndUpdate(pos, state.setValue(dirty, true));
                if (!player.isCreative()) {
//#disable-remap
                    // 1.20.5 起 hurtAndBreak 的第三个参数由 Consumer 变成 EquipmentSlot。
                    //#if MC >= 12005
                    heldStack.hurtAndBreak(1, player, hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                    //#else
                    //$$                 heldStack.hurtAndBreak(1, player, (playerx) -> playerx.broadcastBreakEvent(hand));
                    //#endif
//#enable-remap
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
