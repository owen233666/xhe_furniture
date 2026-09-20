/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
// Forge-like block loot datagen. Mirrors ModBlockLootTableProvider (Fabric).
//#if FORGE_LIKE
package com.owen233666.datagen;

import com.owen233666.block.ModBlocks;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class XheBlockLootSubProvider extends net.minecraft.data.loot.BlockLootSubProvider {

	//#if NEOFORGE
	public XheBlockLootSubProvider(net.minecraft.core.HolderLookup.Provider registries) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
	}
	//#endif
	//#if FORGE
	//$$ public XheBlockLootSubProvider() {
	//$$ 	super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	//$$ }
	//#endif

	@Override
	protected void generate() {
		//Furniture Crafting Tables
		for (Block block : ModBlocks.craftingTableBlocks()) {
			dropSelf(block);
		}
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.craftingTableBlocks();
	}
}
//#endif
