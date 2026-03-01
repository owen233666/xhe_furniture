package com.owen233666.item;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

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

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(XheFurniture.MOD_ID, name), item);
    }

    public static void registerModItems() {

    }
}
