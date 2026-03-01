package com.owen233666.item;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        tooltip.add(Component.translatable("painting.xhe_furniture." + key).withStyle(ChatFormatting.GRAY));
        tooltip.add(
                Component.empty()
                        .append(Component.translatable("tooltip.xhe_furniture.author").withStyle(ChatFormatting.GRAY))
                        .append(Component.literal(author).withStyle(ChatFormatting.GRAY))
        );
    }
}
