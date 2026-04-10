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

public class PhotoPaperItem extends BlockItem implements Vanishable {

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
        return item == ModItems.PHOTO_PAPER_WHITE_A ||
                item == ModItems.PHOTO_PAPER_WHITE_B ||
                item == ModItems.PHOTO_PAPER_WHITE_C;
    }

    private boolean isBlackPaper(Item item) {
        return item == ModItems.PHOTO_PAPER_BLACK_A ||
                item == ModItems.PHOTO_PAPER_BLACK_B ||
                item == ModItems.PHOTO_PAPER_BLACK_C;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(Component.translatable(
                "tooltip.xhe_furniture.photo_paper",
                Component.keybind("key.sneak"),
                Component.keybind("key.use")
                )
                .withStyle(ChatFormatting.GRAY));
    }

    private Item getNextWhitePaper(Item current) {
        if (current == ModItems.PHOTO_PAPER_WHITE_A) return ModItems.PHOTO_PAPER_WHITE_B;
        if (current == ModItems.PHOTO_PAPER_WHITE_B) return ModItems.PHOTO_PAPER_WHITE_C;
        if (current == ModItems.PHOTO_PAPER_WHITE_C) return ModItems.PHOTO_PAPER_WHITE_A;
        return null;
    }

    private Item getNextBlackPaper(Item current) {
        if (current == ModItems.PHOTO_PAPER_BLACK_A) return ModItems.PHOTO_PAPER_BLACK_B;
        if (current == ModItems.PHOTO_PAPER_BLACK_B) return ModItems.PHOTO_PAPER_BLACK_C;
        if (current == ModItems.PHOTO_PAPER_BLACK_C) return ModItems.PHOTO_PAPER_BLACK_A;
        return null;
    }
}
