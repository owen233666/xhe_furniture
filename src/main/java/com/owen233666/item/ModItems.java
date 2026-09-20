/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.item;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.List;
import java.util.function.Supplier;
import com.owen233666.platform.Ids;
import com.owen233666.platform.Registrar;

public class ModItems {
    public static final Registrar.Holder<Item> PAINTING_ANGEL                 = registerItem("painting_angel", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "angel",              "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_BEDROOM_BED           = registerItem("painting_bedroom_bed", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "bedroom_bed",        "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_BERRY_BUSH            = registerItem("painting_berry_bush", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "berry_bush",         "焦焦"));
    public static final Registrar.Holder<Item> PAINTING_BICHON                = registerItem("painting_bichon", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "bichon",             "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_CAKE                  = registerItem("painting_cake", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "cake",               "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_CAT_UNDER_A_TREE      = registerItem("painting_cat_under_a_tree", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "cat_under_a_tree",   "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_CHIME                 = registerItem("painting_chime", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "chime",              "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_CITY_NIGHT            = registerItem("painting_city_night", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "city_night",         "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_CLOVER                = registerItem("painting_clover", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "clover",             "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_COW                   = registerItem("painting_cow", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "cow",                "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_CRYSTAL_FAIRY         = registerItem("painting_crystal_fairy", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "crystal_fairy",      "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_DESSERT               = registerItem("painting_dessert", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "dessert",            "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_FLOWER_BASKET         = registerItem("painting_flower_basket", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "flower_basket",      "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_FLOWERSEA_COTTAGE     = registerItem("painting_flowersea_cottage", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "flowersea_cottage",  "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_FRIENDS_PARTY         = registerItem("painting_friends_party", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "friends_party",      "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_FRUITS_BASKET         = registerItem("painting_fruits_basket", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "fruits_basket",      "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_GARDEN_ENTRANCE       = registerItem("painting_garden_entrance", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "garden_entrance",    "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_GRAMOPHONE            = registerItem("painting_gramophone", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "gramophone",         "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_GRAVEYARD             = registerItem("painting_graveyard", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "graveyard",          "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_HARVEST               = registerItem("painting_harvest", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "harvest",            "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_ISLAND                = registerItem("painting_island", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "island",             "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_KITCHEN_SINK          = registerItem("painting_kitchen_sink", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "kitchen_sink",       "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_KITE                  = registerItem("painting_kite", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "kite",               "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_LEMON_SLICE           = registerItem("painting_lemon_slice", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "lemon_slice",        "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_MERMAID               = registerItem("painting_mermaid", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "mermaid",            "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_MILKYWAY              = registerItem("painting_milkyway", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "milkyway",           "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_NIGHT_CAMPFIRE        = registerItem("painting_night_campfire", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "night_campfire",     "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_PUMPKIN               = registerItem("painting_pumpkin", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "pumpkin",            "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_RAINBOW_UNICORN       = registerItem("painting_rainbow_unicorn", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "rainbow_unicorn",    "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_RESTAURANT            = registerItem("painting_restaurant", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "restaurant",         "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_ROSE_SWING            = registerItem("painting_rose_swing", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "rose_swing",         "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_SALTED_LEMON          = registerItem("painting_salted_lemon", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "salted_lemon",       "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_SCENERY               = registerItem("painting_scenery", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "scenery",            "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_SKETCH                = registerItem("painting_sketch", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "sketch",             "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_SNOW_HOUSE            = registerItem("painting_snow_house", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "snow_house",         "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_STATIONARY_OBJECTS    = registerItem("painting_stationary_objects", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "stationary_objects", "焦焦"));
    public static final Registrar.Holder<Item> PAINTING_SUMPTUOUS_MEAL        = registerItem("painting_sumptuous_meal", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "sumptuous_meal",     "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_SUNSET                = registerItem("painting_sunset", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "sunset",             "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_TEDDY_BEAR            = registerItem("painting_teddy_bear", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "teddy_bear",         "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_TOYS                  = registerItem("painting_toys", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "toys",               "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_TULIP                 = registerItem("painting_tulip", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "tulip",              "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_URBAN_BEAUTY          = registerItem("painting_urban_beauty", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "urban_beauty",       "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_WAVES                 = registerItem("painting_waves", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "waves",              "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_WHEAT_FIELD           = registerItem("painting_wheat_field", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "wheat_field",        "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_WILDFLOWER_PLAIN      = registerItem("painting_wildflower_plain", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "wildflower_plain",   "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINTING_WORLD_TREE            = registerItem("painting_world_tree", () -> new ItemWithTranslatableTooltip(new Item.Properties(), "world_tree",         "在掐饭的小禾"));
    public static final Registrar.Holder<Item> PAINT_BRUSH                    = registerItem("paint_brush", () -> new PaintBrushItem(new Item.Properties().stacksTo(1).durability(64).rarity(Rarity.RARE), ModBlocks.PAINT_BRUSH.get()));
    public static final Registrar.Holder<Item> PHOTO_PAPER_WHITE_A            = registerItem("photo_paper_white_a", () -> new PhotoPaperItem(ModBlocks.PHOTO_PAPER_WHITE_A.get(), new Item.Properties()));
    public static final Registrar.Holder<Item> PHOTO_PAPER_WHITE_B            = registerItem("photo_paper_white_b", () -> new PhotoPaperItem(ModBlocks.PHOTO_PAPER_WHITE_B.get(), new Item.Properties()));
    public static final Registrar.Holder<Item> PHOTO_PAPER_WHITE_C            = registerItem("photo_paper_white_c", () -> new PhotoPaperItem(ModBlocks.PHOTO_PAPER_WHITE_C.get(), new Item.Properties()));
    public static final Registrar.Holder<Item> PHOTO_PAPER_BLACK_A            = registerItem("photo_paper_black_a", () -> new PhotoPaperItem(ModBlocks.PHOTO_PAPER_BLACK_A.get(), new Item.Properties()));
    public static final Registrar.Holder<Item> PHOTO_PAPER_BLACK_B            = registerItem("photo_paper_black_b", () -> new PhotoPaperItem(ModBlocks.PHOTO_PAPER_BLACK_B.get(), new Item.Properties()));
    public static final Registrar.Holder<Item> PHOTO_PAPER_BLACK_C            = registerItem("photo_paper_black_c", () -> new PhotoPaperItem(ModBlocks.PHOTO_PAPER_BLACK_C.get(), new Item.Properties()));

    // ---- Kits (套件): right-click to open the conversion GUI ----
    public static final Registrar.Holder<Item> SLIPPER_KIT = registerItem("slipper_kit", () -> new KitItem(new Item.Properties(), () -> List.of(
            ModBlocks.WHITE_BUNNY_SLIPPERS.get().asItem(), ModBlocks.WHITE_HAMSTERS_SLIPPERS.get().asItem(), ModBlocks.WHITE_BEAR_SLIPPERS.get().asItem(),
            ModBlocks.BEIGE_BUNNY_SLIPPERS.get().asItem(), ModBlocks.BEIGE_HAMSTERS_SLIPPERS.get().asItem(), ModBlocks.BEIGE_BEAR_SLIPPERS.get().asItem(),
            ModBlocks.BROWN_BUNNY_SLIPPERS.get().asItem(), ModBlocks.BROWN_HAMSTERS_SLIPPERS.get().asItem(), ModBlocks.BROWN_BEAR_SLIPPERS.get().asItem(),
            ModBlocks.BLACK_BUNNY_SLIPPERS.get().asItem(), ModBlocks.BLACK_HAMSTERS_SLIPPERS.get().asItem(), ModBlocks.BLACK_BEAR_SLIPPERS.get().asItem(),
            ModBlocks.CALICO_BUNNY_SLIPPERS.get().asItem(), ModBlocks.CALICO_HAMSTERS_SLIPPERS.get().asItem(), ModBlocks.PANDA_SLIPPERS.get().asItem())));

    public static final Registrar.Holder<Item> CARPET_KIT = registerItem("carpet_kit", () -> new KitItem(new Item.Properties(), () -> List.of(
            ModBlocks.CARPET_BLACK.get().asItem(), ModBlocks.CARPET_BLACK_A.get().asItem(),
            ModBlocks.CARPET_BLUE.get().asItem(), ModBlocks.CARPET_BLUE_A.get().asItem(), ModBlocks.CARPET_BLUE_B.get().asItem(),
            ModBlocks.CARPET_BROWN.get().asItem(), ModBlocks.CARPET_BROWN_A.get().asItem(),
            ModBlocks.CARPET_DEEP_BLUE.get().asItem(), ModBlocks.CARPET_DEEP_BLUE_A.get().asItem(), ModBlocks.CARPET_DEEP_BLUE_B.get().asItem(),
            ModBlocks.CARPET_DEEP_GREEN.get().asItem(), ModBlocks.CARPET_DEEP_GREEN_A.get().asItem(),
            ModBlocks.CARPET_DEEP_PURPLE.get().asItem(), ModBlocks.CARPET_DEEP_PURPLE_A.get().asItem(),
            ModBlocks.CARPET_FLAPJACK.get().asItem(), ModBlocks.CARPET_FLAPJACK_A.get().asItem(),
            ModBlocks.CARPET_GRAY.get().asItem(), ModBlocks.CARPET_GRAY_A.get().asItem(),
            ModBlocks.CARPET_GREEN.get().asItem(), ModBlocks.CARPET_GREEN_A.get().asItem(),
            ModBlocks.CARPET_LEMON_SLICE.get().asItem(),
            ModBlocks.CARPET_ORANGE.get().asItem(), ModBlocks.CARPET_ORANGE_A.get().asItem(),
            ModBlocks.CARPET_PINK.get().asItem(), ModBlocks.CARPET_PINK_A.get().asItem(), ModBlocks.CARPET_PINK_B.get().asItem(),
            ModBlocks.CARPET_PIZZA.get().asItem(),
            ModBlocks.CARPET_PURPLE.get().asItem(), ModBlocks.CARPET_PURPLE_A.get().asItem(),
            ModBlocks.CARPET_RED.get().asItem(), ModBlocks.CARPET_RED_A.get().asItem(),
            ModBlocks.CARPET_WAFFLE.get().asItem(), ModBlocks.CARPET_WAFFLE_A.get().asItem(),
            ModBlocks.CARPET_WHITE.get().asItem(), ModBlocks.CARPET_WHITE_A.get().asItem(),
            ModBlocks.CARPET_YELLOW.get().asItem())));

    public static final Registrar.Holder<Item> SHOE_FLOWER_POT_KIT = registerItem("shoe_flower_pot_kit", () -> new KitItem(new Item.Properties(), () -> List.of(
            ModBlocks.WHITE_SHOE_FLOWERPOT.get().asItem(), ModBlocks.PINK_SHOE_FLOWERPOT.get().asItem(),
            ModBlocks.RED_SHOE_FLOWERPOT.get().asItem(), ModBlocks.GREEN_SHOE_FLOWERPOT.get().asItem(),
            ModBlocks.YELLOW_SHOE_FLOWERPOT.get().asItem())));

    public static final Registrar.Holder<Item> PAINTING_FRAME_KIT = registerItem("painting_frame_kit", () -> new KitItem(new Item.Properties(), () -> List.of(
            ModBlocks.PAINTING_FRAME_OAK.get().asItem(), ModBlocks.PAINTING_FRAME_SPRUCE.get().asItem(),
            ModBlocks.PAINTING_FRAME_BIRCH.get().asItem(), ModBlocks.PAINTING_FRAME_JUNGLE.get().asItem(),
            ModBlocks.PAINTING_FRAME_ACACIA.get().asItem(), ModBlocks.PAINTING_FRAME_DARK_OAK.get().asItem(),
            ModBlocks.PAINTING_FRAME_MANGROVE.get().asItem(), ModBlocks.PAINTING_FRAME_CHERRY.get().asItem(),
            ModBlocks.PAINTING_FRAME_BAMBOO.get().asItem(), ModBlocks.PAINTING_FRAME_PALE_OAK.get().asItem(),
            ModBlocks.PAINTING_FRAME_BLACKSTONE.get().asItem())));

    public static final Registrar.Holder<Item> GRID_SHELF_KIT = registerItem("grid_shelf_kit", () -> new KitItem(new Item.Properties(), () -> List.of(
            ModBlocks.GRID_SHELF_OAK.get().asItem(), ModBlocks.GRID_SHELF_SPRUCE.get().asItem(),
            ModBlocks.GRID_SHELF_BIRCH.get().asItem(), ModBlocks.GRID_SHELF_JUNGLE.get().asItem(),
            ModBlocks.GRID_SHELF_ACACIA.get().asItem(), ModBlocks.GRID_SHELF_DARK_OAK.get().asItem(),
            ModBlocks.GRID_SHELF_MANGROVE.get().asItem(), ModBlocks.GRID_SHELF_CHERRY.get().asItem(),
            ModBlocks.GRID_SHELF_BAMBOO.get().asItem(), ModBlocks.GRID_SHELF_PALE_OAK.get().asItem(),
            ModBlocks.GRID_SHELF_BLACKSTONE.get().asItem())));

    public static final Registrar.Holder<Item> FURNITURE_CRAFTING_TABLE_KIT = registerItem("furniture_crafting_table_kit", () -> new KitItem(new Item.Properties(), () -> List.of(
            ModBlocks.FURNITURE_CRAFTING_TABLE_OAK.get().asItem(), ModBlocks.FURNITURE_CRAFTING_TABLE_SPRUCE.get().asItem(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_BIRCH.get().asItem(), ModBlocks.FURNITURE_CRAFTING_TABLE_JUNGLE.get().asItem(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_ACACIA.get().asItem(), ModBlocks.FURNITURE_CRAFTING_TABLE_DARK_OAK.get().asItem(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_MANGROVE.get().asItem(), ModBlocks.FURNITURE_CRAFTING_TABLE_CHERRY.get().asItem(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_BAMBOO.get().asItem(), ModBlocks.FURNITURE_CRAFTING_TABLE_PALE_OAK.get().asItem(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_BLACKSTONE.get().asItem())));

    public static final Registrar.Holder<Item> CORK_BOARD_KIT = registerItem("cork_board_kit", () -> new KitItem(new Item.Properties(), () -> List.of(
            ModBlocks.CORK_BOARD_LIGHT_OAK.get().asItem(), ModBlocks.CORK_BOARD_LIGHT_SPRUCE.get().asItem(),
            ModBlocks.CORK_BOARD_LIGHT_BIRCH.get().asItem(), ModBlocks.CORK_BOARD_LIGHT_JUNGLE.get().asItem(),
            ModBlocks.CORK_BOARD_LIGHT_ACACIA.get().asItem(), ModBlocks.CORK_BOARD_LIGHT_DARK_OAK.get().asItem(),
            ModBlocks.CORK_BOARD_LIGHT_MANGROVE.get().asItem(), ModBlocks.CORK_BOARD_LIGHT_CHERRY.get().asItem(),
            ModBlocks.CORK_BOARD_LIGHT_BAMBOO.get().asItem(), ModBlocks.CORK_BOARD_LIGHT_PALE_OAK.get().asItem(),
            ModBlocks.CORK_BOARD_LIGHT_BLACKSTONE.get().asItem(),
            ModBlocks.CORK_BOARD_DARK_OAK.get().asItem(), ModBlocks.CORK_BOARD_DARK_SPRUCE.get().asItem(),
            ModBlocks.CORK_BOARD_DARK_BIRCH.get().asItem(), ModBlocks.CORK_BOARD_DARK_JUNGLE.get().asItem(),
            ModBlocks.CORK_BOARD_DARK_ACACIA.get().asItem(), ModBlocks.CORK_BOARD_DARK_DARK_OAK.get().asItem(),
            ModBlocks.CORK_BOARD_DARK_MANGROVE.get().asItem(), ModBlocks.CORK_BOARD_DARK_CHERRY.get().asItem(),
            ModBlocks.CORK_BOARD_DARK_BAMBOO.get().asItem(), ModBlocks.CORK_BOARD_DARK_PALE_OAK.get().asItem(),
            ModBlocks.CORK_BOARD_DARK_BLACKSTONE.get().asItem())));

    public static final Registrar.Holder<Item> PHOTO_PAPER_KIT = registerItem("photo_paper_kit", () -> new KitItem(new Item.Properties(), () -> List.of(
            PHOTO_PAPER_WHITE_A.get(), PHOTO_PAPER_WHITE_B.get(), PHOTO_PAPER_WHITE_C.get(),
            PHOTO_PAPER_BLACK_A.get(), PHOTO_PAPER_BLACK_B.get(), PHOTO_PAPER_BLACK_C.get())));

    public static final Registrar.Holder<Item> PAINTING_KIT = registerItem("painting_kit", () -> new KitItem(new Item.Properties(), () -> List.of(
            PAINTING_ANGEL.get(), PAINTING_BEDROOM_BED.get(), PAINTING_BERRY_BUSH.get(), PAINTING_BICHON.get(),
            PAINTING_CAKE.get(), PAINTING_CAT_UNDER_A_TREE.get(), PAINTING_CHIME.get(), PAINTING_CITY_NIGHT.get(),
            PAINTING_CLOVER.get(), PAINTING_COW.get(), PAINTING_CRYSTAL_FAIRY.get(), PAINTING_DESSERT.get(),
            PAINTING_FLOWER_BASKET.get(), PAINTING_FLOWERSEA_COTTAGE.get(), PAINTING_FRIENDS_PARTY.get(), PAINTING_FRUITS_BASKET.get(),
            PAINTING_GARDEN_ENTRANCE.get(), PAINTING_GRAMOPHONE.get(), PAINTING_GRAVEYARD.get(), PAINTING_HARVEST.get(),
            PAINTING_ISLAND.get(), PAINTING_KITCHEN_SINK.get(), PAINTING_KITE.get(), PAINTING_LEMON_SLICE.get(),
            PAINTING_MERMAID.get(), PAINTING_MILKYWAY.get(), PAINTING_NIGHT_CAMPFIRE.get(), PAINTING_PUMPKIN.get(),
            PAINTING_RAINBOW_UNICORN.get(), PAINTING_RESTAURANT.get(), PAINTING_ROSE_SWING.get(), PAINTING_SALTED_LEMON.get(),
            PAINTING_SCENERY.get(), PAINTING_SKETCH.get(), PAINTING_SNOW_HOUSE.get(), PAINTING_STATIONARY_OBJECTS.get(),
            PAINTING_SUMPTUOUS_MEAL.get(), PAINTING_SUNSET.get(), PAINTING_TEDDY_BEAR.get(), PAINTING_TOYS.get(),
            PAINTING_TULIP.get(), PAINTING_URBAN_BEAUTY.get(), PAINTING_WAVES.get(), PAINTING_WHEAT_FIELD.get(),
            PAINTING_WILDFLOWER_PLAIN.get(), PAINTING_WORLD_TREE.get())));

    /** All kit items, used for JEI integration (a safe static list instead of scanning the registry). */
    public static final List<Registrar.Holder<Item>> KITS = List.of(
            SLIPPER_KIT, CARPET_KIT, SHOE_FLOWER_POT_KIT, PAINTING_FRAME_KIT,
            GRID_SHELF_KIT, FURNITURE_CRAFTING_TABLE_KIT, CORK_BOARD_KIT, PHOTO_PAPER_KIT, PAINTING_KIT);

    private static Registrar.Holder<Item> registerItem(String name, Supplier<Item> factory) {
        return Registrar.item(Ids.of(XheFurniture.MOD_ID, name), factory);
    }

    public static void registerModItems() {

    }
}
