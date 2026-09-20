/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
//#if MC < 260102
package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.owen233666.clientUtil.ExposurePhotoUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * Draws immediately through the pre-26.1 {@link MultiBufferSource} pipeline.
 */
public final class LegacyRenderEmitter implements RenderEmitter {

	private final MultiBufferSource bufferSource;

	public LegacyRenderEmitter(MultiBufferSource bufferSource) {
		this.bufferSource = bufferSource;
	}

	@Override
	public void item(PoseStack poseStack, ItemStack stack, ItemDisplayContext context, Level level, int packedLight, int overlay) {
		if (stack.isEmpty()) {
			return;
		}
		Minecraft.getInstance().getItemRenderer()
				.renderStatic(stack, context, packedLight, overlay, poseStack, this.bufferSource, level, 0);
	}

	@Override
	public void block(BlockState state, PoseStack poseStack, Level level, BlockPos pos, int packedLight, int overlay) {
		Minecraft.getInstance().getBlockRenderer()
				.renderSingleBlock(state, poseStack, this.bufferSource, packedLight, OverlayTexture.NO_OVERLAY);
	}

	@Override
	public void photoOrPainting(@Nullable Object exposureImage, ResourceLocation texture, PoseStack poseStack,
	                            float x1, float y1, float x2, float y2,
	                            float u1, float v1, float u2, float v2,
	                            int packedLight) {
		ExposurePhotoUtil.renderPhotoOrPainting(exposureImage, texture, poseStack, this.bufferSource,
				x1, y1, x2, y2, u1, v1, u2, v2, packedLight);
	}
}
//#endif
