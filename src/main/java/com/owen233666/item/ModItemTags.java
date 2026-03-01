package com.owen233666.item;

import com.owen233666.XheFurniture;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> PAINTINGS =
            TagKey.of(
                    Registries.ITEM.getKey(),
                    new Identifier(XheFurniture.MOD_ID, "paintings")
            );

    public static void registerModItemTags() {
    }
}
