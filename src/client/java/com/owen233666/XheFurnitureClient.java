package com.owen233666;

import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.ModBlockEntityTypes;
import com.owen233666.blockentityrenderer.EaselEntityRenderer;
import com.owen233666.blockentityrenderer.ShoeFlowerPotBlockEntityRenderer;
import com.owen233666.blockentityrenderer.StorageBlockEntityRenderer;
import com.owen233666.blockentityrenderer.StorageTypeRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class XheFurnitureClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		// Shoe Flowerpots
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_SHOE_FLOWERPOT, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_SHOE_FLOWERPOT, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_SHOE_FLOWERPOT, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_SHOE_FLOWERPOT, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_SHOE_FLOWERPOT, RenderType.solid());
		// Slippers
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_BUNNY_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_HAMSTERS_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_BEAR_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEIGE_BUNNY_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEIGE_HAMSTERS_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEIGE_BEAR_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROWN_BUNNY_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROWN_HAMSTERS_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROWN_BEAR_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_BUNNY_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_HAMSTERS_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_BEAR_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALICO_BUNNY_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALICO_HAMSTERS_SLIPPERS, RenderType.solid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PANDA_SLIPPERS, RenderType.solid());
		//Carpets
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_BLACK, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_BLACK_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_BLUE, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_BLUE_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_BLUE_B, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_BROWN, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_BROWN_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_DEEP_BLUE, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_DEEP_BLUE_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_DEEP_BLUE_B, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_DEEP_GREEN, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_DEEP_GREEN_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_DEEP_PURPLE, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_DEEP_PURPLE_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_FLAPJACK, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_FLAPJACK_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_GRAY, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_GRAY_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_GREEN, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_GREEN_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_LEMON_SLICE, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_ORANGE, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_ORANGE_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_PINK, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_PINK_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_PINK_B, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_PIZZA, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_PURPLE, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_PURPLE_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_RED, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_RED_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_WAFFLE, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_WAFFLE_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_WHITE, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_WHITE_A, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARPET_YELLOW, RenderType.cutout());
		//Rattan Table
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RATTAN_TABLE, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PAINT_BRUSH, RenderType.cutout());


		BlockEntityRenderers.register(ModBlockEntityTypes.STORAGE_BLOCK_BE, StorageBlockEntityRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityTypes.EASEL_BLOCK_BE, EaselEntityRenderer::new);
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