package com.owen233666.datagen;

import com.owen233666.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        ModBlocks.EASEL,
                        ModBlocks.CANVAS,
                        ModBlocks.DRAWING_BOARD,
                        ModBlocks.GRID_SHELF_OAK,
                        ModBlocks.GRID_SHELF_SPRUCE,
                        ModBlocks.GRID_SHELF_JUNGLE,
                        ModBlocks.GRID_SHELF_BIRCH,
                        ModBlocks.GRID_SHELF_ACACIA,
                        ModBlocks.GRID_SHELF_DARK_OAK,
                        ModBlocks.GRID_SHELF_MANGROVE,
                        ModBlocks.GRID_SHELF_CHERRY,
                        ModBlocks.GRID_SHELF_BAMBOO,
                        ModBlocks.GRID_SHELF_PALE_OAK,
                        ModBlocks.GRID_SHELF_BLACKSTONE
                );
    }
}
