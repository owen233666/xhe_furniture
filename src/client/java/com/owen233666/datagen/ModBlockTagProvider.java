package com.owen233666.datagen;

import com.owen233666.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, "xhe_furniture", existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(BlockTags.MINEABLE_WITH_AXE)
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