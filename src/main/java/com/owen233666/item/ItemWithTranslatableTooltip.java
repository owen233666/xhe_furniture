package com.owen233666.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemWithTranslatableTooltip extends Item {
    private final String key;
    private final String author;

    public ItemWithTranslatableTooltip(Settings settings, String textKey, String author) {
        super(settings);
        this.key = textKey;
        this.author = author;
    }

    @Override
    public String getTranslationKey() {
        return "item.xhe_furniture.painting";
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("painting.xhe_furniture." + key).formatted(Formatting.GRAY));
        tooltip.add(
                Text.empty()
                        .append(Text.translatable("tooltip.xhe_furniture.author").formatted(Formatting.GRAY))
                        .append(Text.literal(author).formatted(Formatting.GRAY))
        );
    }
}
