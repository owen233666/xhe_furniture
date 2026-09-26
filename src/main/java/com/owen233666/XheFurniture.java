/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666;

import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.ModBlockEntityTypes;
import com.owen233666.creativetab.ModCreativeTab;
import com.owen233666.item.ModItemTags;
import com.owen233666.item.ModItems;
import com.owen233666.screen.ModMenus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//#if FORGE_LIKE
import com.owen233666.platform.Registrar;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
//#endif
//#if NEOFORGE
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
//#endif
//#if FORGE
//$$ import net.minecraftforge.eventbus.api.IEventBus;
//$$ import net.minecraftforge.fml.common.Mod;
//$$ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//$$ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//$$ import net.minecraftforge.registries.RegisterEvent;
//#endif

//#if MERGED
//$$ @net.minecraftforge.fml.common.Mod(XheFurniture.MOD_ID)
//$$ @net.neoforged.fml.common.Mod(XheFurniture.MOD_ID)
//#endif
//#if FORGE_LIKE
@Mod(XheFurniture.MOD_ID)
//#endif
public class XheFurniture
//#if FABRIC || MERGED
//$$ 		implements net.fabricmc.api.ModInitializer
//#endif
{
	public static final String MOD_ID = "xhe_furniture";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//#if FABRIC || MERGED
	//$$ public XheFurniture() {
	//$$ 	// The merged jar has to expose the same eager content on both loaders, so the
	//$$ 	// no-arg construction path builds it just like the Forge-like event path does.
	//$$ 	// Registration is immediate on these platforms, so no event listener is needed.
	//$$ 	init();
	//$$ }

	//$$ @Override
	//$$ public void onInitialize() {
	//$$ 	init();
	//$$ }
	//#endif
	//#if FORGE
	//$$ public XheFurniture() {
	//$$ 	// Forge 1.20.1 instantiates the mod class through a no-arg constructor only - injecting
	//$$ 	// an IEventBus there is a Forge 1.20.2+ feature - so the mod event bus is fetched from
	//$$ 	// the loading context instead.
	//$$ 	IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
	//$$ 	modBus.addListener(this::onRegister);
	//$$ 	modBus.addListener(this::onClientSetup);
	//$$ 	com.owen233666.datagen.XheFurnitureForgeDataGenerator.register(modBus);
	//$$ 	init();
	//$$ 	Registrar.attachToBus(modBus);
	//$$ }
	//#endif
	//#if NEOFORGE
	public XheFurniture(IEventBus modBus) {
		modBus.addListener(this::onRegister);
		modBus.addListener(this::onClientSetup);
		// 1.21 made MenuScreens#register private, so container screen factories have to be handed
		// to NeoForge through RegisterMenuScreensEvent. Two halves are needed and the ORDER matters:
		//
		//   * this listener, so the event has somewhere to deliver them;
		//   * the queueing below, which must run during mod construction.
		//
		// Queueing it from FMLClientSetupEvent (the natural-looking place) is too late: NeoForge
		// posts RegisterMenuScreensEvent from ClientHooks.initClientHooks before the deferred
		// mod-loading work dispatches client setup, so the event finds an empty queue and the kit
		// screen stays unregistered. Confirmed at runtime:
		//
		//   23:09:23  registerMenuScreens event fired, pending=0
		//   23:09:24  menuScreen() queued for MenuType@...
		modBus.addListener(com.owen233666.platform.ClientRegistrar::registerMenuScreens);
		if (net.neoforged.fml.loading.FMLEnvironment.dist.isClient()) {
			XheFurnitureClient.registerMenuScreens();
		}
		com.owen233666.datagen.XheFurnitureForgeDataGenerator.register(modBus);
		init();
		Registrar.attachToBus(modBus);
	}
	//#endif

	//#if FORGE_LIKE
	private void onRegister(RegisterEvent event) {
		ResourceKey<? extends Registry<?>> registryKey = event.getRegistryKey();
		Registrar.flush(registryKey);
	}

	private void onClientSetup(FMLClientSetupEvent event) {
		XheFurnitureClient.initClient();
	}
	//#endif

	/**
	 * Constructs and (on Forge-like platforms) queues every piece of content this mod adds.
	 * Runs during mod construction so that the loader's register event has something to flush.
	 */
	public static void init() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModCreativeTab.registerItemGroup();
		ModBlockEntityTypes.registerBlockEntityTypes();
		ModItemTags.registerModItemTags();
		ModMenus.registerModMenus();
	}
}