package com.owen233666.item;

import com.owen233666.XheFurniture;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PAINTING_ANGEL = registerItem("painting_angel", new Item(new FabricItemSettings()));
    public static final Item PAINTING_BEDROOM_BED = registerItem("painting_bedroom_bed", new Item(new FabricItemSettings()));
    public static final Item PAINTING_BICHON = registerItem("painting_bichon", new Item(new FabricItemSettings()));
    public static final Item PAINTING_CAKE = registerItem("painting_cake", new Item(new FabricItemSettings()));
    public static final Item PAINTING_CAT_UNDER_A_TREE = registerItem("painting_cat_under_a_tree", new Item(new FabricItemSettings()));
    public static final Item PAINTING_CHIME = registerItem("painting_chime", new Item(new FabricItemSettings()));
    public static final Item PAINTING_CITY_NIGHT = registerItem("painting_city_night", new Item(new FabricItemSettings()));
    public static final Item PAINTING_CLOVER = registerItem("painting_clover", new Item(new FabricItemSettings()));
    public static final Item PAINTING_COW = registerItem("painting_cow", new Item(new FabricItemSettings()));
    public static final Item PAINTING_CRYSTAL_FAIRY = registerItem("painting_crystal_fairy", new Item(new FabricItemSettings()));
    public static final Item PAINTING_DESSERT = registerItem("painting_dessert", new Item(new FabricItemSettings()));
    public static final Item PAINTING_FLOWER_BASKET = registerItem("painting_flower_basket", new Item(new FabricItemSettings()));
    public static final Item PAINTING_FLOWERSEA_COTTAGE = registerItem("painting_flowersea_cottage", new Item(new FabricItemSettings()));
    public static final Item PAINTING_FRIENDS_PARTY = registerItem("painting_friends_party", new Item(new FabricItemSettings()));
    public static final Item PAINTING_FRUITS_BASKET = registerItem("painting_fruits_basket", new Item(new FabricItemSettings()));
    public static final Item PAINTING_GARDEN_ENTRANCE = registerItem("painting_garden_entrance", new Item(new FabricItemSettings()));
    public static final Item PAINTING_GRAMOPHONE = registerItem("painting_gramophone", new Item(new FabricItemSettings()));
    public static final Item PAINTING_GRAVEYARD = registerItem("painting_graveyard", new Item(new FabricItemSettings()));
    public static final Item PAINTING_HARVEST = registerItem("painting_harvest", new Item(new FabricItemSettings()));
    public static final Item PAINTING_ISLAND = registerItem("painting_island", new Item(new FabricItemSettings()));
    public static final Item PAINTING_KITCHEN_SINK = registerItem("painting_kitchen_sink", new Item(new FabricItemSettings()));
    public static final Item PAINTING_KITE = registerItem("painting_kite", new Item(new FabricItemSettings()));
    public static final Item PAINTING_LEMON_SLICE = registerItem("painting_lemon_slice", new Item(new FabricItemSettings()));
    public static final Item PAINTING_MERMAID = registerItem("painting_mermaid", new Item(new FabricItemSettings()));
    public static final Item PAINTING_MILKYWAY = registerItem("painting_milkyway", new Item(new FabricItemSettings()));
    public static final Item PAINTING_NIGHT_CAMPFIRE = registerItem("painting_night_campfire", new Item(new FabricItemSettings()));
    public static final Item PAINTING_PUMPKIN = registerItem("painting_pumpkin", new Item(new FabricItemSettings()));
    public static final Item PAINTING_RAINBOW_UNICORN = registerItem("painting_rainbow_unicorn", new Item(new FabricItemSettings()));
    public static final Item PAINTING_RESTAURANT = registerItem("painting_restaurant", new Item(new FabricItemSettings()));
    public static final Item PAINTING_ROSE_SWING = registerItem("painting_rose_swing", new Item(new FabricItemSettings()));
    public static final Item PAINTING_SALTED_LEMON = registerItem("painting_salted_lemon", new Item(new FabricItemSettings()));
    public static final Item PAINTING_SCENERY = registerItem("painting_scenery", new Item(new FabricItemSettings()));
    public static final Item PAINTING_SKETCH = registerItem("painting_sketch", new Item(new FabricItemSettings()));
    public static final Item PAINTING_SNOW_HOUSE = registerItem("painting_snow_house", new Item(new FabricItemSettings()));
    public static final Item PAINTING_STATIONARY_OBJECTS = registerItem("painting_stationary_objects", new Item(new FabricItemSettings()));
    public static final Item PAINTING_SUMPTUOUS_MEAL = registerItem("painting_sumptuous_meal", new Item(new FabricItemSettings()));
    public static final Item PAINTING_SUNSET = registerItem("painting_sunset", new Item(new FabricItemSettings()));
    public static final Item PAINTING_TEDDY_BEAR = registerItem("painting_teddy_bear", new Item(new FabricItemSettings()));
    public static final Item PAINTING_TOYS = registerItem("painting_toys", new Item(new FabricItemSettings()));
    public static final Item PAINTING_TULIP = registerItem("painting_tulip", new Item(new FabricItemSettings()));
    public static final Item PAINTING_URBAN_BEAUTY = registerItem("painting_urban_beauty", new Item(new FabricItemSettings()));
    public static final Item PAINTING_WAVES = registerItem("painting_waves", new Item(new FabricItemSettings()));
    public static final Item PAINTING_WHEAT_FIELD = registerItem("painting_wheat_field", new Item(new FabricItemSettings()));
    public static final Item PAINTING_WILDFLOWER_PLAIN = registerItem("painting_wildflower_plain", new Item(new FabricItemSettings()));
    public static final Item PAINTING_WORLD_TREE = registerItem("painting_world_tree", new Item(new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(XheFurniture.MOD_ID, name), item);
    }

    public static void registerModItems() {

    }
}
