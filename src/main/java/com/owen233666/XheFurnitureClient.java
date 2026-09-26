/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666;

import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.ModBlockEntityTypes;
import com.owen233666.blockentityrenderer.*;
import com.owen233666.client.screen.KitScreen;
import com.owen233666.screen.ModMenus;
import com.owen233666.platform.ClientRegistrar;
import net.minecraft.resources.ResourceLocation;

//#if FABRIC || MERGED
//$$ import net.fabricmc.api.ClientModInitializer;
//#endif

public class XheFurnitureClient
//#if FABRIC || MERGED
//$$ 		implements ClientModInitializer
//#endif
{
	//#if FABRIC || MERGED
	//$$ @Override
	//$$ public void onInitializeClient() {
	//$$ 	initClient();
	//$$ }
	//#endif

	/**
	 * Queues the container screen factories.
	 *
	 * <p>Called from two places depending on the platform, because the correct moment differs:
	 *
	 * <ul>
	 *   <li><b>NeoForge</b> &mdash; from the mod constructor. {@code MenuScreens.init()} posts
	 *       {@code RegisterMenuScreensEvent} from {@code ClientHooks.initClientHooks}, which runs
	 *       before the deferred mod-loading work dispatches {@code FMLClientSetupEvent}. Queueing
	 *       during client setup is therefore too late: the event finds an empty queue. Verified at
	 *       runtime:
	 *       <pre>
	 *         23:09:23  registerMenuScreens event fired, pending=0
	 *         23:09:24  menuScreen() queued for MenuType@...   &lt;-- too late
	 *       </pre></li>
	 *   <li><b>Fabric / Forge</b> &mdash; from {@link #initClient()}, which forwards straight to
	 *       {@code MenuScreens.register} and has no such ordering constraint.</li>
	 * </ul>
	 *
	 * <p>Called from the mod constructor on NeoForge (via {@code XheFurniture}) and from
	 * {@link #initClient()} everywhere else. Both paths are safe to leave unconditional: on
	 * non-NeoForge platforms {@code ClientRegistrar.menuScreen} forwards straight to
	 * {@code MenuScreens.register}, and the NeoForge queue is cleared once drained, so a second
	 * queueing would simply be re-delivered rather than throwing.
	 */
	public static void registerMenuScreens() {
		ClientRegistrar.menuScreen(ModMenus.KIT_MENU, KitScreen::new);
	}

	/** Registers render layers and block entity renderers. */
	public static void initClient() {

		// Shoe Flowerpots
		ClientRegistrar.renderLayer(ModBlocks.WHITE_SHOE_FLOWERPOT.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.PINK_SHOE_FLOWERPOT.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.RED_SHOE_FLOWERPOT.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.GREEN_SHOE_FLOWERPOT.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.YELLOW_SHOE_FLOWERPOT.get(), ClientRegistrar.Layer.SOLID);
		// Slippers
		ClientRegistrar.renderLayer(ModBlocks.WHITE_BUNNY_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.WHITE_HAMSTERS_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.WHITE_BEAR_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.BEIGE_BUNNY_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.BEIGE_HAMSTERS_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.BEIGE_BEAR_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.BROWN_BUNNY_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.BROWN_HAMSTERS_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.BROWN_BEAR_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.BLACK_BUNNY_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.BLACK_HAMSTERS_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.BLACK_BEAR_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.CALICO_BUNNY_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.CALICO_HAMSTERS_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		ClientRegistrar.renderLayer(ModBlocks.PANDA_SLIPPERS.get(), ClientRegistrar.Layer.SOLID);
		//Carpets
		ClientRegistrar.renderLayer(ModBlocks.CARPET_BLACK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_BLACK_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_BLUE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_BLUE_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_BLUE_B.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_BROWN.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_BROWN_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_DEEP_BLUE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_DEEP_BLUE_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_DEEP_BLUE_B.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_DEEP_GREEN.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_DEEP_GREEN_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_DEEP_PURPLE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_DEEP_PURPLE_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_FLAPJACK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_FLAPJACK_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_GRAY.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_GRAY_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_GREEN.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_GREEN_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_LEMON_SLICE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_ORANGE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_ORANGE_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_PINK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_PINK_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_PINK_B.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_PIZZA.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_PURPLE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_PURPLE_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_RED.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_RED_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_WAFFLE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_WAFFLE_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_WHITE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_WHITE_A.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CARPET_YELLOW.get(), ClientRegistrar.Layer.CUTOUT);
		//Rattan Table
		ClientRegistrar.renderLayer(ModBlocks.RATTAN_TABLE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.PAINT_BRUSH.get(), ClientRegistrar.Layer.CUTOUT);

		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_OAK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_SPRUCE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_JUNGLE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_BIRCH.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_ACACIA.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_DARK_OAK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_MANGROVE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_CHERRY.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_BAMBOO.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_PALE_OAK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.FURNITURE_CRAFTING_TABLE_BLACKSTONE.get(), ClientRegistrar.Layer.CUTOUT);

		ClientRegistrar.renderLayer(ModBlocks.OPEN_BOOK.get(), ClientRegistrar.Layer.CUTOUT);

		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_OAK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_SPRUCE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_JUNGLE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_BIRCH.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_ACACIA.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_DARK_OAK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_MANGROVE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_CHERRY.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_BAMBOO.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_PALE_OAK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_LIGHT_BLACKSTONE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_OAK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_SPRUCE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_JUNGLE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_BIRCH.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_ACACIA.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_DARK_OAK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_MANGROVE.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_CHERRY.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_BAMBOO.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_PALE_OAK.get(), ClientRegistrar.Layer.CUTOUT);
		ClientRegistrar.renderLayer(ModBlocks.CORK_BOARD_DARK_BLACKSTONE.get(), ClientRegistrar.Layer.CUTOUT);


		ClientRegistrar.blockEntityRenderer(ModBlockEntityTypes.STORAGE_BLOCK_BE.get(), StorageBlockEntityRenderer::new);
		ClientRegistrar.blockEntityRenderer(ModBlockEntityTypes.EASEL_BLOCK_BE.get(), EaselBlockEntityRenderer::new);
		ClientRegistrar.blockEntityRenderer(ModBlockEntityTypes.CANVAS_BLOCK_BE.get(), context -> new CanvasBlockEntityRenderer(context, true));
		ClientRegistrar.blockEntityRenderer(ModBlockEntityTypes.PAINTING_FRAME_BLOCK_BE.get(), PaintFrameBlockEntityRenderer::new);
		ClientRegistrar.blockEntityRenderer(ModBlockEntityTypes.PHOTO_A_BLOCK_BE.get(), PhotoABlockRenderer::new);
		ClientRegistrar.blockEntityRenderer(ModBlockEntityTypes.PHOTO_B_BLOCK_BE.get(), PhotoBBlockRenderer::new);
		ClientRegistrar.blockEntityRenderer(ModBlockEntityTypes.PHOTO_C_BLOCK_BE.get(), PhotoCBlockRenderer::new);
		ClientRegistrar.blockEntityRenderer(ModBlockEntityTypes.GRID_SHELF_BLOCK_BE.get(), GridShelfBlockEntityRenderer::new);
		ClientRegistrar.blockEntityRenderer(ModBlockEntityTypes.CORK_BOARD_BLOCK_BE.get(), CorkBoardBlockEntityRenderer::new);

		// On NeoForge this is a no-op: the factory was already queued from the mod constructor, for
		// the ordering reasons documented on registerMenuScreens().
		registerMenuScreens();

		berInit();
		registerStorageTypeRenderers();

	}

	public static void registerStorageTypeRenderers(){
		StorageBlockEntityRenderer.registerStorageType(ModBlocks.WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlockEntityRenderer());
	}

	public static void registerStorageType(ResourceLocation resourceLocation, StorageTypeRenderer renderer) {
		StorageBlockEntityRenderer.registerStorageType(resourceLocation, renderer);
	}

	public static void berInit(){
		registerStorageType(ModBlocks.WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlockEntityRenderer());
	}
}