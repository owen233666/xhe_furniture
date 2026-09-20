/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
// Forge-like recipe datagen. Only the furniture crafting table kit is generated here, matching
// the existing hand-written recipe; the mod's other recipes are still hand-written under
// src/main/resources/data/xhe_furniture/recipe.
//#if FORGE_LIKE
package com.owen233666.datagen;

import com.owen233666.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class XheRecipeProvider extends RecipeProvider {

	//#if NEOFORGE
	public XheRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
		super(output, lookup);
	}
	//#endif
	//#if FORGE
	//$$ public XheRecipeProvider(PackOutput output) {
	//$$ 	super(output);
	//$$ }
	//#endif

	//#if MC >= 12005
	@Override
	protected void buildRecipes(net.minecraft.data.recipes.RecipeOutput exporter) {
	//#endif
	//#if MC < 12005
	//$$ @Override
	//$$ protected void buildRecipes(java.util.function.Consumer<net.minecraft.data.recipes.FinishedRecipe> exporter) {
	//#endif
		// A wooden crafting-table silhouette, matching furniture_crafting_table_kit.json.
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.FURNITURE_CRAFTING_TABLE_KIT.get())
				.define('P', ItemTags.PLANKS)
				.define('S', Items.STICK)
				.pattern("PPP")
				.pattern("P P")
				.pattern("SSS")
				.unlockedBy("has_material", has(ItemTags.PLANKS))
				.save(exporter);
	}
}
//#endif
