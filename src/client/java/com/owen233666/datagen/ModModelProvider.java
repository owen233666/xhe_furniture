package com.owen233666.datagen;

import com.owen233666.block.ModBlocks;
import com.owen233666.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_BLACK, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_BLACK_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_BLUE, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_BLUE_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_BLUE_B, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_BROWN, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_BROWN_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_DEEP_BLUE, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_DEEP_BLUE_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_DEEP_BLUE_B, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_DEEP_GREEN, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_DEEP_GREEN_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_DEEP_PURPLE, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_DEEP_PURPLE_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_FLAPJACK, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_FLAPJACK_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_GRAY, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_GRAY_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_GREEN, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_GREEN_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_LEMON_SLICE, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_ORANGE, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_ORANGE_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_PINK, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_PINK_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_PINK_B, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_PIZZA, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_PURPLE, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_PURPLE_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_RED, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_RED_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_WAFFLE, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_WAFFLE_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_WHITE, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_WHITE_A, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(ModBlocks.CARPET_YELLOW, TexturedModel.CUBE_ALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PAINTING_ANGEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_BEDROOM_BED, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_BICHON, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_CAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_CAT_UNDER_A_TREE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_CHIME, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_CITY_NIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_CLOVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_COW, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_CRYSTAL_FAIRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_DESSERT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_FLOWER_BASKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_FLOWERSEA_COTTAGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_FRIENDS_PARTY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_FRUITS_BASKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_GARDEN_ENTRANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_GRAMOPHONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_GRAVEYARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_HARVEST, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_ISLAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_KITCHEN_SINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_KITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_LEMON_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_MERMAID, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_MILKYWAY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_NIGHT_CAMPFIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_PUMPKIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_RAINBOW_UNICORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_RESTAURANT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_ROSE_SWING, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_SALTED_LEMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_SCENERY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_SKETCH, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_SNOW_HOUSE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_STATIONARY_OBJECTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_SUMPTUOUS_MEAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_SUNSET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_TEDDY_BEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_TOYS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_TULIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_URBAN_BEAUTY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_WAVES, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_WHEAT_FIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_WILDFLOWER_PLAIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTING_WORLD_TREE, Models.GENERATED);
    }
}
