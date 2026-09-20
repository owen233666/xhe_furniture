/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
// Forge-like datagen entry. Fabric uses XheFurnitureDataGenerator instead, since the two
// loaders have completely separate datagen APIs: Fabric drives providers through
// DataGeneratorEntrypoint, while Forge-like loaders fire GatherDataEvent on the mod bus.
//
// Run with `gradlew :<version>:runData`; output lands in that version's src/main/generated.
//#if FORGE_LIKE
package com.owen233666.datagen;

import com.owen233666.XheFurniture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Registers this mod's data providers on the Forge-like {@code GatherDataEvent}. The
 * providers themselves are plain vanilla {@code DataProvider} subclasses, which is what lets
 * NeoForge and Forge 1.20.1 share this one class.
 */
public class XheFurnitureForgeDataGenerator {

	/** Wires the mod-bus listener. Called from {@link XheFurniture}'s constructor. */
	public static void register(Object modBus) {
		//#if NEOFORGE
		((net.neoforged.bus.api.IEventBus) modBus).addListener(XheFurnitureForgeDataGenerator::onGatherData);
		//#endif
		//#if FORGE
		//$$ ((net.minecraftforge.eventbus.api.IEventBus) modBus).addListener(XheFurnitureForgeDataGenerator::onGatherData);
		//#endif
	}

	//#if NEOFORGE
	private static void onGatherData(net.neoforged.neoforge.data.event.GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

		generator.addProvider(event.includeServer(), new XheBlockTagProvider(output, lookup, event.getExistingFileHelper()));
		generator.addProvider(event.includeServer(), new XheLootTableProvider(output, lookup));
		generator.addProvider(event.includeServer(), new XheRecipeProvider(output, lookup));
	}
	//#endif
	//#if FORGE
	//$$ private static void onGatherData(net.minecraftforge.data.event.GatherDataEvent event) {
	//$$ 	DataGenerator generator = event.getGenerator();
	//$$ 	PackOutput output = generator.getPackOutput();
	//$$ 	CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
	//$$
	//$$ 	generator.addProvider(event.includeServer(), new XheBlockTagProvider(output, lookup, event.getExistingFileHelper()));
	//$$ 	// 1.20.1's loot provider takes a Supplier and has no registry-aware constructor.
	//$$ 	generator.addProvider(event.includeServer(), new XheLootTableProvider(output));
	//$$ 	generator.addProvider(event.includeServer(), new XheRecipeProvider(output));
	//$$ }
	//#endif
}

//#if NEOFORGE
/** Loot tables via the vanilla provider; the mod's tables are all "drops itself". */
class XheLootTableProvider extends LootTableProvider {
	XheLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
		super(output, Set.of(), List.of(
				new SubProviderEntry(XheBlockLootSubProvider::new, LootContextParamSets.BLOCK)
		), lookup);
	}
}
//#endif
//#if FORGE
//$$ /** Loot tables via the vanilla provider; the mod's tables are all "drops itself". */
//$$ class XheLootTableProvider extends LootTableProvider {
//$$ 	XheLootTableProvider(PackOutput output) {
//$$ 		super(output, Set.of(), List.of(
//$$ 				new SubProviderEntry(XheBlockLootSubProvider::new, LootContextParamSets.BLOCK)
//$$ 		));
//$$ 	}
//$$ }
//#endif
//#endif
