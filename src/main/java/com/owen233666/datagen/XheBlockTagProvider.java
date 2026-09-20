/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
// Forge-like block tag datagen. Mirrors ModBlockTagProvider (Fabric) exactly; the two exist
// separately because the loaders' datagen APIs share nothing but vanilla's tag plumbing.
//#if FORGE_LIKE
package com.owen233666.datagen;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

//#if NEOFORGE
public class XheBlockTagProvider extends net.neoforged.neoforge.common.data.BlockTagsProvider {

	public XheBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup,
			net.neoforged.neoforge.common.data.ExistingFileHelper existingFileHelper) {
		super(output, lookup, XheFurniture.MOD_ID, existingFileHelper);
	}
//#endif
//#if FORGE
//$$ public class XheBlockTagProvider extends net.minecraftforge.common.data.BlockTagsProvider {
//$$
//$$ 	public XheBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup,
//$$ 			net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
//$$ 		super(output, lookup, XheFurniture.MOD_ID, existingFileHelper);
//$$ 	}
//#endif

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		// Pre-existing wooden blocks, kept identical to the hand-written axe.json.
		tag(BlockTags.MINEABLE_WITH_AXE).add(
				ModBlocks.EASEL.get(),
				ModBlocks.CANVAS.get(),
				ModBlocks.DRAWING_BOARD.get(),
				ModBlocks.GRID_SHELF_OAK.get(),
				ModBlocks.GRID_SHELF_SPRUCE.get(),
				ModBlocks.GRID_SHELF_JUNGLE.get(),
				ModBlocks.GRID_SHELF_BIRCH.get(),
				ModBlocks.GRID_SHELF_ACACIA.get(),
				ModBlocks.GRID_SHELF_DARK_OAK.get(),
				ModBlocks.GRID_SHELF_MANGROVE.get(),
				ModBlocks.GRID_SHELF_CHERRY.get(),
				ModBlocks.GRID_SHELF_BAMBOO.get(),
				ModBlocks.GRID_SHELF_PALE_OAK.get(),
				ModBlocks.GRID_SHELF_BLACKSTONE.get()
		);

		// The furniture crafting tables are wooden, so an axe mines them quickly.
		tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.craftingTableBlocks().toArray(new Block[0]));
	}
}
//#endif
