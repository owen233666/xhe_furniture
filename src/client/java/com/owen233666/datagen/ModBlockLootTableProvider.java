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
        addDrop(ModBlocks.CARPET_WAFFLE);

    }
}
