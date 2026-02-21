package com.owen233666.block.painting;

import net.minecraft.util.StringIdentifiable;

public enum Paintings implements StringIdentifiable {
    ANGEL("angel"),
    BEDROOM_BED("bedroom_bed"),
    BERRY_BUSH("berry_bush"),
    BICHON("bichon"),
    CAKE("cake"),
    CAT_UNDER_A_TREE("cat_under_a_tree"),
    CHIME("chime"),
    CITY_NIGHT("city_night"),
    CLOVER("clover"),
    COW("cow"),
    CRYSTAL_FAIRY("crystal_fairy"),
    DESSERT("dessert"),
    FLOWER_BASKET("flower_basket"),
    FLOWERSEA_COTTAGE("flowersea_cottage"),
    FRIENDS_PARTY("friends_party"),
    FRUITS_BASKET("fruits_basket"),
    GARDEN_ENTRANCE("garden_entrance"),
    GRAMOPHONE("gramophone"),
    GRAVEYARD("graveyard"),
    HARVEST("harvest"),
    ISLAND("island"),
    KITCHEN_SINK("kitchen_sink"),
    KITE("kite"),
    LEMON_SLICE("lemon_slice"),
    MERMAID("mermaid"),
    MILKYWAY("milkyway"),
    NIGHT_CAMPFIRE("night_campfire"),
    PUMPKIN("pumpkin"),
    RAINBOW_UNICORN("rainbow_unicorn"),
    RESTAURANT("restaurant"),
    ROSE_SWING("rose_swing"),
    SALTED_LEMON("salted_lemon"),
    SCENERY("scenery"),
    SKETCH("sketch"),
    SNOW_HOUSE("snow_house"),
    STATIONARY_OBJECTS("stationary_objects"),
    SUMPTUOUS_MEAL("sumptuous_meal"),
    SUNSET("sunset"),
    TEDDY_BEAR("teddy_bear"),
    TOYS("toys"),
    TULIP("tulip"),
    URBAN_BEAUTY("urban_beauty"),
    WAVES("waves"),
    WHEAT_FIELD("wheat_field"),
    WILDFLOWER_PLAIN("wildflower_plain"),
    WORLD_TREE("world_tree"),
    NONE("none");



    public final String name;

    Paintings(String name) {this.name = name;}

    @Override
    public String asString() {
        return name;
    }

    public static Paintings createFromString(String name) {
        for (Paintings p : values()) {
            if (p.name.equals(name)) {
                return p;
            }else {
                return Paintings.NONE;
            }
        }
        return Paintings.NONE;
    }
}
