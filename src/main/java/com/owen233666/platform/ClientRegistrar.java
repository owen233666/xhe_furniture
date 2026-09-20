/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.platform;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

//#if NEOFORGE
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
//#endif

/**
 * Client-only counterpart of {@link Registrar}.
 *
 * <p>Client setup happens inside the client mod initialiser on Fabric and inside the loader's
 * client-setup event on Forge-like platforms, so the calls are funneled through here and invoked
 * from the loader glue in {@code XheFurnitureClient}.
 */
public final class ClientRegistrar {
	private ClientRegistrar() {
	}

	public enum Layer {
		SOLID,
		CUTOUT,
		CUTOUT_MIPPED,
		TRANSLUCENT
	}

	public static void renderLayer(Block block, Layer layer) {
		RenderType type;
		switch (layer) {
			case CUTOUT:
				type = RenderType.cutout();
				break;
			case CUTOUT_MIPPED:
				type = RenderType.cutoutMipped();
				break;
			case TRANSLUCENT:
				type = RenderType.translucent();
				break;
			case SOLID:
			default:
				type = RenderType.solid();
				break;
		}

		// 1.20.1 has no vanilla way to set a block render layer, so Fabric goes through fabric-api.
		//#if FABRIC
		//$$ net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap.INSTANCE.putBlock(block, type);
		//#else
		ItemBlockRenderTypes.setRenderLayer(block, type);
		//#endif
	}

	public static <T extends BlockEntity> void blockEntityRenderer(BlockEntityType<T> type, BlockEntityRendererProvider<T> provider) {
		// 1.20.1 has no accessible BlockEntityRenderers.register, so Fabric goes through fabric-api.
		//#if FABRIC
		//$$ net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry.register(type, provider::create);
		//#else
		BlockEntityRenderers.register(type, provider);
		//#endif
	}

	// 1.21 made MenuScreens#register private, so NeoForge has to go through the mod-bus
	// RegisterMenuScreensEvent instead. Calls made before that event fires are queued here.
	//#if NEOFORGE
	private static final List<Consumer<RegisterMenuScreensEvent>> PENDING_MENU_SCREENS = new ArrayList<>();

	public static <M extends AbstractContainerMenu, S extends AbstractContainerScreen<M>> void menuScreen(
			MenuType<M> type,
			MenuScreens.ScreenConstructor<M, S> constructor
	) {
		PENDING_MENU_SCREENS.add(event -> event.register(type, constructor));
	}

	/**
	 * NeoForge replacement for {@code MenuScreens.register}.
	 *
	 * <p>It has to be driven by the loader, so the {@code @Mod} entry point is expected to add
	 * {@code modBus.addListener(ClientRegistrar::registerMenuScreens);} next to its other
	 * listeners, or to annotate a client-side class with a mod-bus subscriber.
	 */
	public static void registerMenuScreens(RegisterMenuScreensEvent event) {
		for (Consumer<RegisterMenuScreensEvent> pending : PENDING_MENU_SCREENS) {
			pending.accept(event);
		}
		PENDING_MENU_SCREENS.clear();
	}
	//#else
	//$$ public static <M extends AbstractContainerMenu, S extends AbstractContainerScreen<M>> void menuScreen(
	//$$ 		MenuType<M> type,
	//$$ 		MenuScreens.ScreenConstructor<M, S> constructor
	//$$ ) {
	//$$ 	MenuScreens.register(type, constructor);
	//$$ }
	//#endif
}
