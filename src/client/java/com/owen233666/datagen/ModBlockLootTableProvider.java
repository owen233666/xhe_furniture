package com.owen233666.datagen;

import com.owen233666.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //Cups
        dropSelf(ModBlocks.HOT_COCOA);
        //Shoe Flowerpots
        dropSelf(ModBlocks.WHITE_SHOE_FLOWERPOT);
        dropSelf(ModBlocks.PINK_SHOE_FLOWERPOT);
        dropSelf(ModBlocks.RED_SHOE_FLOWERPOT);
        dropSelf(ModBlocks.GREEN_SHOE_FLOWERPOT);
        dropSelf(ModBlocks.YELLOW_SHOE_FLOWERPOT);
        //Slippers
        dropSelf(ModBlocks.WHITE_BUNNY_SLIPPERS);
        dropSelf(ModBlocks.WHITE_HAMSTERS_SLIPPERS);
        dropSelf(ModBlocks.WHITE_BEAR_SLIPPERS);
        dropSelf(ModBlocks.BEIGE_BUNNY_SLIPPERS);
        dropSelf(ModBlocks.BEIGE_HAMSTERS_SLIPPERS);
        dropSelf(ModBlocks.BEIGE_BEAR_SLIPPERS);
        dropSelf(ModBlocks.BROWN_BUNNY_SLIPPERS);
        dropSelf(ModBlocks.BROWN_HAMSTERS_SLIPPERS);
        dropSelf(ModBlocks.BROWN_BEAR_SLIPPERS);
        dropSelf(ModBlocks.BLACK_BUNNY_SLIPPERS);
        dropSelf(ModBlocks.BLACK_HAMSTERS_SLIPPERS);
        dropSelf(ModBlocks.BLACK_BEAR_SLIPPERS);
        dropSelf(ModBlocks.CALICO_BUNNY_SLIPPERS);
        dropSelf(ModBlocks.CALICO_HAMSTERS_SLIPPERS);
        dropSelf(ModBlocks.PANDA_SLIPPERS);
        //Carpets
        dropSelf(ModBlocks.CARPET_BLACK);
        dropSelf(ModBlocks.CARPET_BLACK_A);
        dropSelf(ModBlocks.CARPET_BLUE);
        dropSelf(ModBlocks.CARPET_BLUE_A);
        dropSelf(ModBlocks.CARPET_BLUE_B);
        dropSelf(ModBlocks.CARPET_BROWN);
        dropSelf(ModBlocks.CARPET_BROWN_A);
        dropSelf(ModBlocks.CARPET_DEEP_BLUE);
        dropSelf(ModBlocks.CARPET_DEEP_BLUE_A);
        dropSelf(ModBlocks.CARPET_DEEP_BLUE_B);
        dropSelf(ModBlocks.CARPET_DEEP_GREEN);
        dropSelf(ModBlocks.CARPET_DEEP_GREEN_A);
        dropSelf(ModBlocks.CARPET_DEEP_PURPLE);
        dropSelf(ModBlocks.CARPET_DEEP_PURPLE_A);
        dropSelf(ModBlocks.CARPET_FLAPJACK);
        dropSelf(ModBlocks.CARPET_FLAPJACK_A);
        dropSelf(ModBlocks.CARPET_GRAY);
        dropSelf(ModBlocks.CARPET_GRAY_A);
        dropSelf(ModBlocks.CARPET_GREEN);
        dropSelf(ModBlocks.CARPET_GREEN_A);
        dropSelf(ModBlocks.CARPET_LEMON_SLICE);
        dropSelf(ModBlocks.CARPET_ORANGE);
        dropSelf(ModBlocks.CARPET_ORANGE_A);
        dropSelf(ModBlocks.CARPET_PINK);
        dropSelf(ModBlocks.CARPET_PINK_A);
        dropSelf(ModBlocks.CARPET_PINK_B);
        dropSelf(ModBlocks.CARPET_PIZZA);
        dropSelf(ModBlocks.CARPET_PURPLE);
        dropSelf(ModBlocks.CARPET_PURPLE_A);
        dropSelf(ModBlocks.CARPET_RED);
        dropSelf(ModBlocks.CARPET_RED_A);
        dropSelf(ModBlocks.CARPET_WAFFLE);
        dropSelf(ModBlocks.CARPET_WAFFLE_A);
        dropSelf(ModBlocks.CARPET_WHITE);
        dropSelf(ModBlocks.CARPET_WHITE_A);
        dropSelf(ModBlocks.CARPET_YELLOW);
        //Rattan Table
        dropSelf(ModBlocks.RATTAN_TABLE);
        //Painting Studio Series
        dropSelf(ModBlocks.EASEL);
        dropSelf(ModBlocks.CANVAS);
        dropSelf(ModBlocks.DRAWING_BOARD);
        dropSelf(ModBlocks.GRID_SHELF_OAK);
        dropSelf(ModBlocks.GRID_SHELF_SPRUCE);
        dropSelf(ModBlocks.GRID_SHELF_JUNGLE);
        dropSelf(ModBlocks.GRID_SHELF_BIRCH);
        dropSelf(ModBlocks.GRID_SHELF_ACACIA);
        dropSelf(ModBlocks.GRID_SHELF_DARK_OAK);
        dropSelf(ModBlocks.GRID_SHELF_MANGROVE);
        dropSelf(ModBlocks.GRID_SHELF_CHERRY);
        dropSelf(ModBlocks.GRID_SHELF_BAMBOO);
        dropSelf(ModBlocks.GRID_SHELF_PALE_OAK);
        dropSelf(ModBlocks.GRID_SHELF_BLACKSTONE);
    }
}
