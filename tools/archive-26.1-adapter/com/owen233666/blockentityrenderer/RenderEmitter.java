/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * The three drawing primitives every block-entity renderer in this mod needs, expressed in a way
 * that does not mention how the draw call reaches the GPU.
 *
 * <p>Up to 1.21.1 a {@code BlockEntityRenderer#render} received a {@link
 * net.minecraft.client.renderer.MultiBufferSource} and drew immediately. 26.1 replaced that with a
 * two-phase model: {@code extractRenderState} copies data out of the block entity, and {@code
 * submit} hands geometry to a {@code SubmitNodeCollector} for later batching. The geometry code in
 * these renderers is identical under both models, so it is written once against this interface and
 * fed either a {@link LegacyRenderEmitter} or a {@link SubmitRenderEmitter}.
 */
public interface RenderEmitter {

	/** Draws an item model at the current pose. */
	void item(PoseStack poseStack, ItemStack stack, ItemDisplayContext context, Level level, int packedLight, int overlay);

	/** Draws a single block model at the current pose. */
	void block(BlockState state, PoseStack poseStack, Level level, BlockPos pos, int packedLight, int overlay);

	/**
	 * Draws a flat quad carrying either an Exposure photo or a painting texture.
	 *
	 * @param exposureImage a live Exposure renderable image, or {@code null} to use the texture
	 */
	void photoOrPainting(@Nullable Object exposureImage,
	                     ResourceLocation texture,
	                     PoseStack poseStack,
	                     float x1, float y1, float x2, float y2,
	                     float u1, float v1, float u2, float v2,
	                     int packedLight);
}
