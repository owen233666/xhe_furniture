package com.owen233666.datagen;

import com.owen233666.item.ModItemTags;
import com.owen233666.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {


        getOrCreateTagBuilder(ModItemTags.PAINTINGS)
                .add(ModItems.PAINTING_ANGEL)
                .add(ModItems.PAINTING_BEDROOM_BED)
                .add(ModItems.PAINTING_BERRY_BUSH)
                .add(ModItems.PAINTING_BICHON)
                .add(ModItems.PAINTING_CAKE)
                .add(ModItems.PAINTING_CAT_UNDER_A_TREE)
                .add(ModItems.PAINTING_CHIME)
                .add(ModItems.PAINTING_CITY_NIGHT)
                .add(ModItems.PAINTING_CLOVER)
                .add(ModItems.PAINTING_COW)
                .add(ModItems.PAINTING_CRYSTAL_FAIRY)
                .add(ModItems.PAINTING_DESSERT)
                .add(ModItems.PAINTING_FLOWER_BASKET)
                .add(ModItems.PAINTING_FLOWERSEA_COTTAGE)
                .add(ModItems.PAINTING_FRIENDS_PARTY)
                .add(ModItems.PAINTING_FRUITS_BASKET)
                .add(ModItems.PAINTING_GARDEN_ENTRANCE)
                .add(ModItems.PAINTING_GRAMOPHONE)
                .add(ModItems.PAINTING_GRAVEYARD)
                .add(ModItems.PAINTING_HARVEST)
                .add(ModItems.PAINTING_ISLAND)
                .add(ModItems.PAINTING_KITCHEN_SINK)
                .add(ModItems.PAINTING_KITE)
                .add(ModItems.PAINTING_LEMON_SLICE)
                .add(ModItems.PAINTING_MERMAID)
                .add(ModItems.PAINTING_MILKYWAY)
                .add(ModItems.PAINTING_NIGHT_CAMPFIRE)
                .add(ModItems.PAINTING_PUMPKIN)
                .add(ModItems.PAINTING_RAINBOW_UNICORN)
                .add(ModItems.PAINTING_RESTAURANT)
                .add(ModItems.PAINTING_ROSE_SWING)
                .add(ModItems.PAINTING_SALTED_LEMON)
                .add(ModItems.PAINTING_SCENERY)
                .add(ModItems.PAINTING_SKETCH)
                .add(ModItems.PAINTING_SNOW_HOUSE)
                .add(ModItems.PAINTING_STATIONARY_OBJECTS)
                .add(ModItems.PAINTING_SUMPTUOUS_MEAL)
                .add(ModItems.PAINTING_SUNSET)
                .add(ModItems.PAINTING_TEDDY_BEAR)
                .add(ModItems.PAINTING_TOYS)
                .add(ModItems.PAINTING_TULIP)
                .add(ModItems.PAINTING_URBAN_BEAUTY)
                .add(ModItems.PAINTING_WAVES)
                .add(ModItems.PAINTING_WHEAT_FIELD)
                .add(ModItems.PAINTING_WILDFLOWER_PLAIN)
                .add(ModItems.PAINTING_WORLD_TREE);
    }
}
