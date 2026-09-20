/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemWithTranslatableTooltip extends Item {
    private final String key;
    private final String author;

    public ItemWithTranslatableTooltip(Properties settings, String textKey, String author) {
        super(settings);
        this.key = textKey;
        this.author = author;
    }

    @Override
    public String getDescriptionId() {
        return "item.xhe_furniture.painting";
    }

    // 1.20.5 replaced the Level tooltip parameter with Item.TooltipContext.
    //#if MC >= 12005
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag context) {
    //#else
    //$$ @Override
    //$$ public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
    //#endif
        tooltip.add(Component.translatable("painting.xhe_furniture." + key).withStyle(ChatFormatting.GRAY));
        tooltip.add(
                Component.empty()
                        .append(Component.translatable("tooltip.xhe_furniture.author").withStyle(ChatFormatting.GRAY))
                        .append(Component.literal(author).withStyle(ChatFormatting.GRAY))
        );
    }
}
