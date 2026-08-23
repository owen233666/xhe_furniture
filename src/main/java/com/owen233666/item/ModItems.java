package com.owen233666.item;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.List;

public class ModItems {
    public static final Item PAINTING_ANGEL                 = registerItem("painting_angel",                new ItemWithTranslatableTooltip(new FabricItemSettings(), "angel",              "在掐饭的小禾"));
    public static final Item PAINTING_BEDROOM_BED           = registerItem("painting_bedroom_bed",          new ItemWithTranslatableTooltip(new FabricItemSettings(), "bedroom_bed",        "在掐饭的小禾"));
    public static final Item PAINTING_BERRY_BUSH            = registerItem("painting_berry_bush",           new ItemWithTranslatableTooltip(new FabricItemSettings(), "berry_bush",         "焦焦"));
    public static final Item PAINTING_BICHON                = registerItem("painting_bichon",               new ItemWithTranslatableTooltip(new FabricItemSettings(), "bichon",             "在掐饭的小禾"));
    public static final Item PAINTING_CAKE                  = registerItem("painting_cake",                 new ItemWithTranslatableTooltip(new FabricItemSettings(), "cake",               "在掐饭的小禾"));
    public static final Item PAINTING_CAT_UNDER_A_TREE      = registerItem("painting_cat_under_a_tree",     new ItemWithTranslatableTooltip(new FabricItemSettings(), "cat_under_a_tree",   "在掐饭的小禾"));
    public static final Item PAINTING_CHIME                 = registerItem("painting_chime",                new ItemWithTranslatableTooltip(new FabricItemSettings(), "chime",              "在掐饭的小禾"));
    public static final Item PAINTING_CITY_NIGHT            = registerItem("painting_city_night",           new ItemWithTranslatableTooltip(new FabricItemSettings(), "city_night",         "在掐饭的小禾"));
    public static final Item PAINTING_CLOVER                = registerItem("painting_clover",               new ItemWithTranslatableTooltip(new FabricItemSettings(), "clover",             "在掐饭的小禾"));
    public static final Item PAINTING_COW                   = registerItem("painting_cow",                  new ItemWithTranslatableTooltip(new FabricItemSettings(), "cow",                "在掐饭的小禾"));
    public static final Item PAINTING_CRYSTAL_FAIRY         = registerItem("painting_crystal_fairy",        new ItemWithTranslatableTooltip(new FabricItemSettings(), "crystal_fairy",      "在掐饭的小禾"));
    public static final Item PAINTING_DESSERT               = registerItem("painting_dessert",              new ItemWithTranslatableTooltip(new FabricItemSettings(), "dessert",            "在掐饭的小禾"));
    public static final Item PAINTING_FLOWER_BASKET         = registerItem("painting_flower_basket",        new ItemWithTranslatableTooltip(new FabricItemSettings(), "flower_basket",      "在掐饭的小禾"));
    public static final Item PAINTING_FLOWERSEA_COTTAGE     = registerItem("painting_flowersea_cottage",    new ItemWithTranslatableTooltip(new FabricItemSettings(), "flowersea_cottage",  "在掐饭的小禾"));
    public static final Item PAINTING_FRIENDS_PARTY         = registerItem("painting_friends_party",        new ItemWithTranslatableTooltip(new FabricItemSettings(), "friends_party",      "在掐饭的小禾"));
    public static final Item PAINTING_FRUITS_BASKET         = registerItem("painting_fruits_basket",        new ItemWithTranslatableTooltip(new FabricItemSettings(), "fruits_basket",      "在掐饭的小禾"));
    public static final Item PAINTING_GARDEN_ENTRANCE       = registerItem("painting_garden_entrance",      new ItemWithTranslatableTooltip(new FabricItemSettings(), "garden_entrance",    "在掐饭的小禾"));
    public static final Item PAINTING_GRAMOPHONE            = registerItem("painting_gramophone",           new ItemWithTranslatableTooltip(new FabricItemSettings(), "gramophone",         "在掐饭的小禾"));
    public static final Item PAINTING_GRAVEYARD             = registerItem("painting_graveyard",            new ItemWithTranslatableTooltip(new FabricItemSettings(), "graveyard",          "在掐饭的小禾"));
    public static final Item PAINTING_HARVEST               = registerItem("painting_harvest",              new ItemWithTranslatableTooltip(new FabricItemSettings(), "harvest",            "在掐饭的小禾"));
    public static final Item PAINTING_ISLAND                = registerItem("painting_island",               new ItemWithTranslatableTooltip(new FabricItemSettings(), "island",             "在掐饭的小禾"));
    public static final Item PAINTING_KITCHEN_SINK          = registerItem("painting_kitchen_sink",         new ItemWithTranslatableTooltip(new FabricItemSettings(), "kitchen_sink",       "在掐饭的小禾"));
    public static final Item PAINTING_KITE                  = registerItem("painting_kite",                 new ItemWithTranslatableTooltip(new FabricItemSettings(), "kite",               "在掐饭的小禾"));
    public static final Item PAINTING_LEMON_SLICE           = registerItem("painting_lemon_slice",          new ItemWithTranslatableTooltip(new FabricItemSettings(), "lemon_slice",        "在掐饭的小禾"));
    public static final Item PAINTING_MERMAID               = registerItem("painting_mermaid",              new ItemWithTranslatableTooltip(new FabricItemSettings(), "mermaid",            "在掐饭的小禾"));
    public static final Item PAINTING_MILKYWAY              = registerItem("painting_milkyway",             new ItemWithTranslatableTooltip(new FabricItemSettings(), "milkyway",           "在掐饭的小禾"));
    public static final Item PAINTING_NIGHT_CAMPFIRE        = registerItem("painting_night_campfire",       new ItemWithTranslatableTooltip(new FabricItemSettings(), "night_campfire",     "在掐饭的小禾"));
    public static final Item PAINTING_PUMPKIN               = registerItem("painting_pumpkin",              new ItemWithTranslatableTooltip(new FabricItemSettings(), "pumpkin",            "在掐饭的小禾"));
    public static final Item PAINTING_RAINBOW_UNICORN       = registerItem("painting_rainbow_unicorn",      new ItemWithTranslatableTooltip(new FabricItemSettings(), "rainbow_unicorn",    "在掐饭的小禾"));
    public static final Item PAINTING_RESTAURANT            = registerItem("painting_restaurant",           new ItemWithTranslatableTooltip(new FabricItemSettings(), "restaurant",         "在掐饭的小禾"));
    public static final Item PAINTING_ROSE_SWING            = registerItem("painting_rose_swing",           new ItemWithTranslatableTooltip(new FabricItemSettings(), "rose_swing",         "在掐饭的小禾"));
    public static final Item PAINTING_SALTED_LEMON          = registerItem("painting_salted_lemon",         new ItemWithTranslatableTooltip(new FabricItemSettings(), "salted_lemon",       "在掐饭的小禾"));
    public static final Item PAINTING_SCENERY               = registerItem("painting_scenery",              new ItemWithTranslatableTooltip(new FabricItemSettings(), "scenery",            "在掐饭的小禾"));
    public static final Item PAINTING_SKETCH                = registerItem("painting_sketch",               new ItemWithTranslatableTooltip(new FabricItemSettings(), "sketch",             "在掐饭的小禾"));
    public static final Item PAINTING_SNOW_HOUSE            = registerItem("painting_snow_house",           new ItemWithTranslatableTooltip(new FabricItemSettings(), "snow_house",         "在掐饭的小禾"));
    public static final Item PAINTING_STATIONARY_OBJECTS    = registerItem("painting_stationary_objects",   new ItemWithTranslatableTooltip(new FabricItemSettings(), "stationary_objects", "焦焦"));
    public static final Item PAINTING_SUMPTUOUS_MEAL        = registerItem("painting_sumptuous_meal",       new ItemWithTranslatableTooltip(new FabricItemSettings(), "sumptuous_meal",     "在掐饭的小禾"));
    public static final Item PAINTING_SUNSET                = registerItem("painting_sunset",               new ItemWithTranslatableTooltip(new FabricItemSettings(), "sunset",             "在掐饭的小禾"));
    public static final Item PAINTING_TEDDY_BEAR            = registerItem("painting_teddy_bear",           new ItemWithTranslatableTooltip(new FabricItemSettings(), "teddy_bear",         "在掐饭的小禾"));
    public static final Item PAINTING_TOYS                  = registerItem("painting_toys",                 new ItemWithTranslatableTooltip(new FabricItemSettings(), "toys",               "在掐饭的小禾"));
    public static final Item PAINTING_TULIP                 = registerItem("painting_tulip",                new ItemWithTranslatableTooltip(new FabricItemSettings(), "tulip",              "在掐饭的小禾"));
    public static final Item PAINTING_URBAN_BEAUTY          = registerItem("painting_urban_beauty",         new ItemWithTranslatableTooltip(new FabricItemSettings(), "urban_beauty",       "在掐饭的小禾"));
    public static final Item PAINTING_WAVES                 = registerItem("painting_waves",                new ItemWithTranslatableTooltip(new FabricItemSettings(), "waves",              "在掐饭的小禾"));
    public static final Item PAINTING_WHEAT_FIELD           = registerItem("painting_wheat_field",          new ItemWithTranslatableTooltip(new FabricItemSettings(), "wheat_field",        "在掐饭的小禾"));
    public static final Item PAINTING_WILDFLOWER_PLAIN      = registerItem("painting_wildflower_plain",     new ItemWithTranslatableTooltip(new FabricItemSettings(), "wildflower_plain",   "在掐饭的小禾"));
    public static final Item PAINTING_WORLD_TREE            = registerItem("painting_world_tree",           new ItemWithTranslatableTooltip(new FabricItemSettings(), "world_tree",         "在掐饭的小禾"));
    public static final Item PAINT_BRUSH                    = registerItem("paint_brush",                   new PaintBrushItem(new FabricItemSettings().stacksTo(1).durability(64).rarity(Rarity.RARE), ModBlocks.PAINT_BRUSH));
    public static final Item PHOTO_PAPER_WHITE_A            = registerItem("photo_paper_white_a",           new PhotoPaperItem(ModBlocks.PHOTO_PAPER_WHITE_A, new Item.Properties()));
    public static final Item PHOTO_PAPER_WHITE_B            = registerItem("photo_paper_white_b",           new PhotoPaperItem(ModBlocks.PHOTO_PAPER_WHITE_B, new Item.Properties()));
    public static final Item PHOTO_PAPER_WHITE_C            = registerItem("photo_paper_white_c",           new PhotoPaperItem(ModBlocks.PHOTO_PAPER_WHITE_C, new Item.Properties()));
    public static final Item PHOTO_PAPER_BLACK_A            = registerItem("photo_paper_black_a",           new PhotoPaperItem(ModBlocks.PHOTO_PAPER_BLACK_A, new Item.Properties()));
    public static final Item PHOTO_PAPER_BLACK_B            = registerItem("photo_paper_black_b",           new PhotoPaperItem(ModBlocks.PHOTO_PAPER_BLACK_B, new Item.Properties()));
    public static final Item PHOTO_PAPER_BLACK_C            = registerItem("photo_paper_black_c",           new PhotoPaperItem(ModBlocks.PHOTO_PAPER_BLACK_C, new Item.Properties()));

    // ---- Kits (套件): right-click to open the conversion GUI ----
    public static final Item SLIPPER_KIT = registerItem("slipper_kit", new KitItem(new Item.Properties(), List.of(
            ModBlocks.WHITE_BUNNY_SLIPPERS.asItem(), ModBlocks.WHITE_HAMSTERS_SLIPPERS.asItem(), ModBlocks.WHITE_BEAR_SLIPPERS.asItem(),
            ModBlocks.BEIGE_BUNNY_SLIPPERS.asItem(), ModBlocks.BEIGE_HAMSTERS_SLIPPERS.asItem(), ModBlocks.BEIGE_BEAR_SLIPPERS.asItem(),
            ModBlocks.BROWN_BUNNY_SLIPPERS.asItem(), ModBlocks.BROWN_HAMSTERS_SLIPPERS.asItem(), ModBlocks.BROWN_BEAR_SLIPPERS.asItem(),
            ModBlocks.BLACK_BUNNY_SLIPPERS.asItem(), ModBlocks.BLACK_HAMSTERS_SLIPPERS.asItem(), ModBlocks.BLACK_BEAR_SLIPPERS.asItem(),
            ModBlocks.CALICO_BUNNY_SLIPPERS.asItem(), ModBlocks.CALICO_HAMSTERS_SLIPPERS.asItem(), ModBlocks.PANDA_SLIPPERS.asItem())));

    public static final Item CARPET_KIT = registerItem("carpet_kit", new KitItem(new Item.Properties(), List.of(
            ModBlocks.CARPET_BLACK.asItem(), ModBlocks.CARPET_BLACK_A.asItem(),
            ModBlocks.CARPET_BLUE.asItem(), ModBlocks.CARPET_BLUE_A.asItem(), ModBlocks.CARPET_BLUE_B.asItem(),
            ModBlocks.CARPET_BROWN.asItem(), ModBlocks.CARPET_BROWN_A.asItem(),
            ModBlocks.CARPET_DEEP_BLUE.asItem(), ModBlocks.CARPET_DEEP_BLUE_A.asItem(), ModBlocks.CARPET_DEEP_BLUE_B.asItem(),
            ModBlocks.CARPET_DEEP_GREEN.asItem(), ModBlocks.CARPET_DEEP_GREEN_A.asItem(),
            ModBlocks.CARPET_DEEP_PURPLE.asItem(), ModBlocks.CARPET_DEEP_PURPLE_A.asItem(),
            ModBlocks.CARPET_FLAPJACK.asItem(), ModBlocks.CARPET_FLAPJACK_A.asItem(),
            ModBlocks.CARPET_GRAY.asItem(), ModBlocks.CARPET_GRAY_A.asItem(),
            ModBlocks.CARPET_GREEN.asItem(), ModBlocks.CARPET_GREEN_A.asItem(),
            ModBlocks.CARPET_LEMON_SLICE.asItem(),
            ModBlocks.CARPET_ORANGE.asItem(), ModBlocks.CARPET_ORANGE_A.asItem(),
            ModBlocks.CARPET_PINK.asItem(), ModBlocks.CARPET_PINK_A.asItem(), ModBlocks.CARPET_PINK_B.asItem(),
            ModBlocks.CARPET_PIZZA.asItem(),
            ModBlocks.CARPET_PURPLE.asItem(), ModBlocks.CARPET_PURPLE_A.asItem(),
            ModBlocks.CARPET_RED.asItem(), ModBlocks.CARPET_RED_A.asItem(),
            ModBlocks.CARPET_WAFFLE.asItem(), ModBlocks.CARPET_WAFFLE_A.asItem(),
            ModBlocks.CARPET_WHITE.asItem(), ModBlocks.CARPET_WHITE_A.asItem(),
            ModBlocks.CARPET_YELLOW.asItem())));

    public static final Item SHOE_FLOWER_POT_KIT = registerItem("shoe_flower_pot_kit", new KitItem(new Item.Properties(), List.of(
            ModBlocks.WHITE_SHOE_FLOWERPOT.asItem(), ModBlocks.PINK_SHOE_FLOWERPOT.asItem(),
            ModBlocks.RED_SHOE_FLOWERPOT.asItem(), ModBlocks.GREEN_SHOE_FLOWERPOT.asItem(),
            ModBlocks.YELLOW_SHOE_FLOWERPOT.asItem())));

    public static final Item PAINTING_FRAME_KIT = registerItem("painting_frame_kit", new KitItem(new Item.Properties(), List.of(
            ModBlocks.PAINTING_FRAME_OAK.asItem(), ModBlocks.PAINTING_FRAME_SPRUCE.asItem(),
            ModBlocks.PAINTING_FRAME_BIRCH.asItem(), ModBlocks.PAINTING_FRAME_JUNGLE.asItem(),
            ModBlocks.PAINTING_FRAME_ACACIA.asItem(), ModBlocks.PAINTING_FRAME_DARK_OAK.asItem(),
            ModBlocks.PAINTING_FRAME_MANGROVE.asItem(), ModBlocks.PAINTING_FRAME_CHERRY.asItem(),
            ModBlocks.PAINTING_FRAME_BAMBOO.asItem(), ModBlocks.PAINTING_FRAME_PALE_OAK.asItem(),
            ModBlocks.PAINTING_FRAME_BLACKSTONE.asItem())));

    public static final Item GRID_SHELF_KIT = registerItem("grid_shelf_kit", new KitItem(new Item.Properties(), List.of(
            ModBlocks.GRID_SHELF_OAK.asItem(), ModBlocks.GRID_SHELF_SPRUCE.asItem(),
            ModBlocks.GRID_SHELF_BIRCH.asItem(), ModBlocks.GRID_SHELF_JUNGLE.asItem(),
            ModBlocks.GRID_SHELF_ACACIA.asItem(), ModBlocks.GRID_SHELF_DARK_OAK.asItem(),
            ModBlocks.GRID_SHELF_MANGROVE.asItem(), ModBlocks.GRID_SHELF_CHERRY.asItem(),
            ModBlocks.GRID_SHELF_BAMBOO.asItem(), ModBlocks.GRID_SHELF_PALE_OAK.asItem(),
            ModBlocks.GRID_SHELF_BLACKSTONE.asItem())));

    public static final Item FURNITURE_ORDER_TABLE_KIT = registerItem("furniture_order_table_kit", new KitItem(new Item.Properties(), List.of(
            ModBlocks.FURNITURE_ORDER_TABLE_OAK.asItem(), ModBlocks.FURNITURE_ORDER_TABLE_SPRUCE.asItem(),
            ModBlocks.FURNITURE_ORDER_TABLE_BIRCH.asItem(), ModBlocks.FURNITURE_ORDER_TABLE_JUNGLE.asItem(),
            ModBlocks.FURNITURE_ORDER_TABLE_ACACIA.asItem(), ModBlocks.FURNITURE_ORDER_TABLE_DARK_OAK.asItem(),
            ModBlocks.FURNITURE_ORDER_TABLE_MANGROVE.asItem(), ModBlocks.FURNITURE_ORDER_TABLE_CHERRY.asItem(),
            ModBlocks.FURNITURE_ORDER_TABLE_BAMBOO.asItem(), ModBlocks.FURNITURE_ORDER_TABLE_PALE_OAK.asItem(),
            ModBlocks.FURNITURE_ORDER_TABLE_BLACKSTONE.asItem())));

    public static final Item CORK_BOARD_KIT = registerItem("cork_board_kit", new KitItem(new Item.Properties(), List.of(
            ModBlocks.CORK_BOARD_LIGHT_OAK.asItem(), ModBlocks.CORK_BOARD_LIGHT_SPRUCE.asItem(),
            ModBlocks.CORK_BOARD_LIGHT_BIRCH.asItem(), ModBlocks.CORK_BOARD_LIGHT_JUNGLE.asItem(),
            ModBlocks.CORK_BOARD_LIGHT_ACACIA.asItem(), ModBlocks.CORK_BOARD_LIGHT_DARK_OAK.asItem(),
            ModBlocks.CORK_BOARD_LIGHT_MANGROVE.asItem(), ModBlocks.CORK_BOARD_LIGHT_CHERRY.asItem(),
            ModBlocks.CORK_BOARD_LIGHT_BAMBOO.asItem(), ModBlocks.CORK_BOARD_LIGHT_PALE_OAK.asItem(),
            ModBlocks.CORK_BOARD_LIGHT_BLACKSTONE.asItem(),
            ModBlocks.CORK_BOARD_DARK_OAK.asItem(), ModBlocks.CORK_BOARD_DARK_SPRUCE.asItem(),
            ModBlocks.CORK_BOARD_DARK_BIRCH.asItem(), ModBlocks.CORK_BOARD_DARK_JUNGLE.asItem(),
            ModBlocks.CORK_BOARD_DARK_ACACIA.asItem(), ModBlocks.CORK_BOARD_DARK_DARK_OAK.asItem(),
            ModBlocks.CORK_BOARD_DARK_MANGROVE.asItem(), ModBlocks.CORK_BOARD_DARK_CHERRY.asItem(),
            ModBlocks.CORK_BOARD_DARK_BAMBOO.asItem(), ModBlocks.CORK_BOARD_DARK_PALE_OAK.asItem(),
            ModBlocks.CORK_BOARD_DARK_BLACKSTONE.asItem())));

    public static final Item PHOTO_PAPER_KIT = registerItem("photo_paper_kit", new KitItem(new Item.Properties(), List.of(
            PHOTO_PAPER_WHITE_A, PHOTO_PAPER_WHITE_B, PHOTO_PAPER_WHITE_C,
            PHOTO_PAPER_BLACK_A, PHOTO_PAPER_BLACK_B, PHOTO_PAPER_BLACK_C)));

    public static final Item PAINTING_KIT = registerItem("painting_kit", new KitItem(new Item.Properties(), List.of(
            PAINTING_ANGEL, PAINTING_BEDROOM_BED, PAINTING_BERRY_BUSH, PAINTING_BICHON,
            PAINTING_CAKE, PAINTING_CAT_UNDER_A_TREE, PAINTING_CHIME, PAINTING_CITY_NIGHT,
            PAINTING_CLOVER, PAINTING_COW, PAINTING_CRYSTAL_FAIRY, PAINTING_DESSERT,
            PAINTING_FLOWER_BASKET, PAINTING_FLOWERSEA_COTTAGE, PAINTING_FRIENDS_PARTY, PAINTING_FRUITS_BASKET,
            PAINTING_GARDEN_ENTRANCE, PAINTING_GRAMOPHONE, PAINTING_GRAVEYARD, PAINTING_HARVEST,
            PAINTING_ISLAND, PAINTING_KITCHEN_SINK, PAINTING_KITE, PAINTING_LEMON_SLICE,
            PAINTING_MERMAID, PAINTING_MILKYWAY, PAINTING_NIGHT_CAMPFIRE, PAINTING_PUMPKIN,
            PAINTING_RAINBOW_UNICORN, PAINTING_RESTAURANT, PAINTING_ROSE_SWING, PAINTING_SALTED_LEMON,
            PAINTING_SCENERY, PAINTING_SKETCH, PAINTING_SNOW_HOUSE, PAINTING_STATIONARY_OBJECTS,
            PAINTING_SUMPTUOUS_MEAL, PAINTING_SUNSET, PAINTING_TEDDY_BEAR, PAINTING_TOYS,
            PAINTING_TULIP, PAINTING_URBAN_BEAUTY, PAINTING_WAVES, PAINTING_WHEAT_FIELD,
            PAINTING_WILDFLOWER_PLAIN, PAINTING_WORLD_TREE)));

    /** All kit items, used for JEI integration (a safe static list instead of scanning the registry). */
    public static final List<Item> KITS = List.of(
            SLIPPER_KIT, CARPET_KIT, SHOE_FLOWER_POT_KIT, PAINTING_FRAME_KIT,
            GRID_SHELF_KIT, FURNITURE_ORDER_TABLE_KIT, CORK_BOARD_KIT, PHOTO_PAPER_KIT, PAINTING_KIT);

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(XheFurniture.MOD_ID, name), item);
    }

    public static void registerModItems() {

    }
}
