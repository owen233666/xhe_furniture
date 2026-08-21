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
                    ResourceLocation.fromNamespaceAndPath(XheFurniture.MOD_ID, "paintings")
            );

    public static final TagKey<Item> PHOTO_PAPERS =
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    ResourceLocation.fromNamespaceAndPath(XheFurniture.MOD_ID, "photo_papers")
            );

    public static final TagKey<Item> TYPE_A_PHOTO_PAPERS =
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    ResourceLocation.fromNamespaceAndPath(XheFurniture.MOD_ID, "type_a_photo_papers")
            );

    public static final TagKey<Item> TYPE_B_PHOTO_PAPERS =
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    ResourceLocation.fromNamespaceAndPath(XheFurniture.MOD_ID, "type_b_photo_papers")
            );

    public static final TagKey<Item> TYPE_C_PHOTO_PAPERS =
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    ResourceLocation.fromNamespaceAndPath(XheFurniture.MOD_ID, "type_c_photo_papers")
            );

    public static void registerModItemTags() {
    }
}