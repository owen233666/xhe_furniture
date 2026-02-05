package com.owen233666;

import com.owen233666.block.ModBlocks;
import com.owen233666.block.ShoeFlowerPotBlock;
import com.owen233666.block.entity.ModBlockEntityTypes;
import com.owen233666.blockentityrenderer.ShoeFlowerPotBlockEntityRenderer;
import com.owen233666.blockentityrenderer.StorageBlockEntityRenderer;
import com.owen233666.blockentityrenderer.StorageTypeRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class XheFurnitureClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		// Shoe Flowerpots 系列
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_SHOE_FLOWERPOT, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_SHOE_FLOWERPOT, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_SHOE_FLOWERPOT, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_SHOE_FLOWERPOT, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_SHOE_FLOWERPOT, RenderLayer.getSolid());
		// Slippers 系列
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_BUNNY_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_HAMSTERS_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_BEAR_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEIGE_BUNNY_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEIGE_HAMSTERS_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEIGE_BEAR_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROWN_BUNNY_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROWN_HAMSTERS_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROWN_BEAR_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_BUNNY_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_HAMSTERS_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_BEAR_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALICO_BUNNY_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALICO_HAMSTERS_SLIPPERS, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PANDA_SLIPPERS, RenderLayer.getSolid());

		BlockEntityRendererFactories.register(ModBlockEntityTypes.STORAGE_BLOCK_BE, StorageBlockEntityRenderer::new);
		berInit();
		registerStorageTypeRenderers();
	}

	public static void registerStorageTypeRenderers(){
		StorageBlockEntityRenderer.registerStorageType(ModBlocks.WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlockEntityRenderer());
	}

	public static void registerStorageType(Identifier identifier, StorageTypeRenderer renderer) {
		StorageBlockEntityRenderer.registerStorageType(identifier, renderer);
	}

	public static void berInit(){
		registerStorageType(ModBlocks.WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlockEntityRenderer());
	}
}