/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PhotoPaperItem extends BlockItem {

    public PhotoPaperItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (player.isShiftKeyDown()) {
            if (!level.isClientSide()) {
                handleShiftSwitch(player, level, itemStack, interactionHand);
            }
            return InteractionResultHolder.success(itemStack);
        }

        return super.use(level, player, interactionHand);
    }

    private void handleShiftSwitch(Player player, Level level, ItemStack itemStack, InteractionHand interactionHand) {
        Item item = itemStack.getItem();

        if (player != null && !level.isClientSide() && player.isShiftKeyDown()) {
            int count = itemStack.getCount();

            if (isWhitePaper(item)) {
                ItemStack newItemStack = new ItemStack(getNextWhitePaper(item), count);
                Item newItem = getNextWhitePaper(item);
                if (newItem != null) {
                    player.setItemInHand(interactionHand, newItemStack);
                }
            } else {
                ItemStack newItemStack = new ItemStack(getNextBlackPaper(item), count);
                Item newItem = getNextBlackPaper(item);
                if (newItem != null) {
                    player.setItemInHand(interactionHand, newItemStack);
                }
            }
        }
    }

    private boolean isWhitePaper(Item item) {
        return item == ModItems.PHOTO_PAPER_WHITE_A.get() ||
                item == ModItems.PHOTO_PAPER_WHITE_B.get() ||
                item == ModItems.PHOTO_PAPER_WHITE_C.get();
    }

    private boolean isBlackPaper(Item item) {
        return item == ModItems.PHOTO_PAPER_BLACK_A.get() ||
                item == ModItems.PHOTO_PAPER_BLACK_B.get() ||
                item == ModItems.PHOTO_PAPER_BLACK_C.get();
    }

    // 1.20.5 replaced the Level tooltip parameter with Item.TooltipContext.
    //#if MC >= 12005
    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
    //#else
    //$$ @Override
    //$$ public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
    //$$     super.appendHoverText(itemStack, level, list, tooltipFlag);
    //#endif
        list.add(Component.translatable(
                "tooltip.xhe_furniture.photo_paper",
                Component.keybind("key.sneak"),
                Component.keybind("key.use")
                )
                .withStyle(ChatFormatting.GRAY));
    }

    private Item getNextWhitePaper(Item current) {
        if (current == ModItems.PHOTO_PAPER_WHITE_A.get()) return ModItems.PHOTO_PAPER_WHITE_B.get();
        if (current == ModItems.PHOTO_PAPER_WHITE_B.get()) return ModItems.PHOTO_PAPER_WHITE_C.get();
        if (current == ModItems.PHOTO_PAPER_WHITE_C.get()) return ModItems.PHOTO_PAPER_WHITE_A.get();
        return null;
    }

    private Item getNextBlackPaper(Item current) {
        if (current == ModItems.PHOTO_PAPER_BLACK_A.get()) return ModItems.PHOTO_PAPER_BLACK_B.get();
        if (current == ModItems.PHOTO_PAPER_BLACK_B.get()) return ModItems.PHOTO_PAPER_BLACK_C.get();
        if (current == ModItems.PHOTO_PAPER_BLACK_C.get()) return ModItems.PHOTO_PAPER_BLACK_A.get();
        return null;
    }
}
