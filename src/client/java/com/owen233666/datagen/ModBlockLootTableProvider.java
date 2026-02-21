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
        addDrop(ModBlocks.HOT_COCOA);
        //Shoe Flowerpots
        addDrop(ModBlocks.WHITE_SHOE_FLOWERPOT);
        addDrop(ModBlocks.PINK_SHOE_FLOWERPOT);
        addDrop(ModBlocks.RED_SHOE_FLOWERPOT);
        addDrop(ModBlocks.GREEN_SHOE_FLOWERPOT);
        addDrop(ModBlocks.YELLOW_SHOE_FLOWERPOT);
        //Slippers
        addDrop(ModBlocks.WHITE_BUNNY_SLIPPERS);
        addDrop(ModBlocks.WHITE_HAMSTERS_SLIPPERS);
        addDrop(ModBlocks.WHITE_BEAR_SLIPPERS);
        addDrop(ModBlocks.BEIGE_BUNNY_SLIPPERS);
        addDrop(ModBlocks.BEIGE_HAMSTERS_SLIPPERS);
        addDrop(ModBlocks.BEIGE_BEAR_SLIPPERS);
        addDrop(ModBlocks.BROWN_BUNNY_SLIPPERS);
        addDrop(ModBlocks.BROWN_HAMSTERS_SLIPPERS);
        addDrop(ModBlocks.BROWN_BEAR_SLIPPERS);
        addDrop(ModBlocks.BLACK_BUNNY_SLIPPERS);
        addDrop(ModBlocks.BLACK_HAMSTERS_SLIPPERS);
        addDrop(ModBlocks.BLACK_BEAR_SLIPPERS);
        addDrop(ModBlocks.CALICO_BUNNY_SLIPPERS);
        addDrop(ModBlocks.CALICO_HAMSTERS_SLIPPERS);
        addDrop(ModBlocks.PANDA_SLIPPERS);
        //Carpets
        addDrop(ModBlocks.CARPET_BLACK);
        addDrop(ModBlocks.CARPET_BLACK_A);
        addDrop(ModBlocks.CARPET_BLUE);
        addDrop(ModBlocks.CARPET_BLUE_A);
        addDrop(ModBlocks.CARPET_BLUE_B);
        addDrop(ModBlocks.CARPET_BROWN);
        addDrop(ModBlocks.CARPET_BROWN_A);
        addDrop(ModBlocks.CARPET_DEEP_BLUE);
        addDrop(ModBlocks.CARPET_DEEP_BLUE_A);
        addDrop(ModBlocks.CARPET_DEEP_BLUE_B);
        addDrop(ModBlocks.CARPET_DEEP_GREEN);
        addDrop(ModBlocks.CARPET_DEEP_GREEN_A);
        addDrop(ModBlocks.CARPET_DEEP_PURPLE);
        addDrop(ModBlocks.CARPET_DEEP_PURPLE_A);
        addDrop(ModBlocks.CARPET_FLAPJACK);
        addDrop(ModBlocks.CARPET_FLAPJACK_A);
        addDrop(ModBlocks.CARPET_GRAY);
        addDrop(ModBlocks.CARPET_GRAY_A);
        addDrop(ModBlocks.CARPET_GREEN);
        addDrop(ModBlocks.CARPET_GREEN_A);
        addDrop(ModBlocks.CARPET_LEMON_SLICE);
        addDrop(ModBlocks.CARPET_ORANGE);
        addDrop(ModBlocks.CARPET_ORANGE_A);
        addDrop(ModBlocks.CARPET_PINK);
        addDrop(ModBlocks.CARPET_PINK_A);
        addDrop(ModBlocks.CARPET_PINK_B);
        addDrop(ModBlocks.CARPET_PIZZA);
        addDrop(ModBlocks.CARPET_PURPLE);
        addDrop(ModBlocks.CARPET_PURPLE_A);
        addDrop(ModBlocks.CARPET_RED);
        addDrop(ModBlocks.CARPET_RED_A);
        addDrop(ModBlocks.CARPET_WAFFLE);
        addDrop(ModBlocks.CARPET_WAFFLE_A);
        addDrop(ModBlocks.CARPET_WHITE);
        addDrop(ModBlocks.CARPET_WHITE_A);
        addDrop(ModBlocks.CARPET_YELLOW);
        //Rattan Table
        addDrop(ModBlocks.RATTAN_TABLE);
        //Painting Studio Series
        addDrop(ModBlocks.EASEL);
        addDrop(ModBlocks.CANVAS);
        addDrop(ModBlocks.DRAWING_BOARD);
        addDrop(ModBlocks.GRID_SHELF_OAK);
        addDrop(ModBlocks.GRID_SHELF_SPRUCE);
        addDrop(ModBlocks.GRID_SHELF_JUNGLE);
        addDrop(ModBlocks.GRID_SHELF_BIRCH);
        addDrop(ModBlocks.GRID_SHELF_ACACIA);
        addDrop(ModBlocks.GRID_SHELF_DARK_OAK);
        addDrop(ModBlocks.GRID_SHELF_MANGROVE);
        addDrop(ModBlocks.GRID_SHELF_CHERRY);
        addDrop(ModBlocks.GRID_SHELF_BAMBOO);
        addDrop(ModBlocks.GRID_SHELF_PALE_OAK);
        addDrop(ModBlocks.GRID_SHELF_BLACKSTONE);
    }
}
