package com.owen233666;

import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.ModBlockEntityTypes;
import com.owen233666.blockentityrenderer.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = XheFurniture.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class XheFurnitureClient {

	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {

		// Shoe Flowerpots
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_SHOE_FLOWERPOT, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_SHOE_FLOWERPOT, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_SHOE_FLOWERPOT, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.GREEN_SHOE_FLOWERPOT, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.YELLOW_SHOE_FLOWERPOT, RenderType.solid());
		// Slippers
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_BUNNY_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_HAMSTERS_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_BEAR_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BEIGE_BUNNY_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BEIGE_HAMSTERS_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BEIGE_BEAR_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_BUNNY_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_HAMSTERS_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_BEAR_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_BUNNY_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_HAMSTERS_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_BEAR_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CALICO_BUNNY_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CALICO_HAMSTERS_SLIPPERS, RenderType.solid());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.PANDA_SLIPPERS, RenderType.solid());
		//Carpets
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_BLACK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_BLACK_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_BLUE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_BLUE_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_BLUE_B, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_BROWN, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_BROWN_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_DEEP_BLUE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_DEEP_BLUE_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_DEEP_BLUE_B, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_DEEP_GREEN, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_DEEP_GREEN_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_DEEP_PURPLE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_DEEP_PURPLE_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_FLAPJACK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_FLAPJACK_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_GRAY, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_GRAY_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_GREEN, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_GREEN_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_LEMON_SLICE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_ORANGE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_ORANGE_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_PINK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_PINK_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_PINK_B, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_PIZZA, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_PURPLE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_PURPLE_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_RED, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_RED_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_WAFFLE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_WAFFLE_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_WHITE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_WHITE_A, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_YELLOW, RenderType.cutout());
		//Rattan Table
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.RATTAN_TABLE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.PAINT_BRUSH, RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_OAK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_SPRUCE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_JUNGLE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_BIRCH, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_ACACIA, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_DARK_OAK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_MANGROVE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_CHERRY, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_BAMBOO, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_PALE_OAK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FURNITURE_ORDER_TABLE_BLACKSTONE, RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(ModBlocks.OPEN_BOOK, RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_OAK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_SPRUCE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_JUNGLE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_BIRCH, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_ACACIA, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_DARK_OAK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_MANGROVE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_CHERRY, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_BAMBOO, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_PALE_OAK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_LIGHT_BLACKSTONE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_OAK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_SPRUCE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_JUNGLE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_BIRCH, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_ACACIA, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_DARK_OAK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_MANGROVE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_CHERRY, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_BAMBOO, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_PALE_OAK, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORK_BOARD_DARK_BLACKSTONE, RenderType.cutout());

		BlockEntityRenderers.register(ModBlockEntityTypes.STORAGE_BLOCK_BE, StorageBlockEntityRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityTypes.EASEL_BLOCK_BE, EaselBlockEntityRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityTypes.CANVAS_BLOCK_BE, context -> new CanvasBlockEntityRenderer(context, true));
		BlockEntityRenderers.register(ModBlockEntityTypes.PAINTING_FRAME_BLOCK_BE, PaintFrameBlockEntityRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityTypes.PHOTO_A_BLOCK_BE, PhotoABlockRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityTypes.PHOTO_B_BLOCK_BE, PhotoBBlockRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityTypes.PHOTO_C_BLOCK_BE, PhotoCBlockRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityTypes.GRID_SHELF_BLOCK_BE, GridShelfBlockEntityRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityTypes.CORK_BOARD_BLOCK_BE, CorkBoardBlockEntityRenderer::new);

		registerStorageType(ModBlocks.WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlockEntityRenderer());
	}

	public static void registerStorageType(ResourceLocation resourceLocation, StorageTypeRenderer renderer) {
		StorageBlockEntityRenderer.registerStorageType(resourceLocation, renderer);
	}
}
