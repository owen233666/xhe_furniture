package com.owen233666.item;

import com.owen233666.XheFurniture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> PAINTINGS =
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    new ResourceLocation(XheFurniture.MOD_ID, "paintings")
            );

    public static void registerModItemTags() {
    }
}
