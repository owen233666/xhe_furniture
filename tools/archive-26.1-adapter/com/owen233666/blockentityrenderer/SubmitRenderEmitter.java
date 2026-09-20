/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
// 26.1-only: it talks to the submit pipeline, so the body is kept out of the older builds. The
// preprocessor's remapper only ever sees it as a reference inside a `//#if MC >= 260102` method
// body, never in a signature, so it does not need a stub.
//#if MC >= 260102
package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.owen233666.clientUtil.ClientUtil;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * Hands geometry to the 26.1 submit pipeline instead of drawing immediately.
 *
 * <p>Item and block models are resolved into their render states first, because the submit phase no
 * longer has any way to reach the model manager. Everything else is a plain custom-geometry quad,
 * which is exactly what {@code RenderType.text} expects.
 */
public final class SubmitRenderEmitter implements RenderEmitter {

	private final SubmitNodeCollector collector;
	private final ItemModelResolver itemModelResolver;
	private final BlockModelResolver blockModelResolver;

	public SubmitRenderEmitter(SubmitNodeCollector collector,
	                           ItemModelResolver itemModelResolver,
	                           BlockModelResolver blockModelResolver) {
		this.collector = collector;
		this.itemModelResolver = itemModelResolver;
		this.blockModelResolver = blockModelResolver;
	}

	@Override
	public void item(PoseStack poseStack, ItemStack stack, ItemDisplayContext context, Level level, int packedLight, int overlay) {
		if (stack.isEmpty()) {
			return;
		}
		ItemStackRenderState renderState = new ItemStackRenderState();
		// No ItemOwner is available here; the only owner-dependent model property is the item
		// frame / entity context, which none of this mod's models use.
		this.itemModelResolver.updateForTopItem(renderState, stack, context, level, null, 0);
		renderState.submit(poseStack, this.collector, packedLight, overlay, 0);
	}

	@Override
	public void block(BlockState state, PoseStack poseStack, Level level, BlockPos pos, int packedLight, int overlay) {
		BlockModelRenderState renderState = new BlockModelRenderState();
		this.blockModelResolver.update(renderState, state, BlockDisplayContext.create());
		renderState.submit(poseStack, this.collector, packedLight, overlay, 0);
	}

	@Override
	public void photoOrPainting(@Nullable Object exposureImage, Identifier texture, PoseStack poseStack,
	                            float x1, float y1, float x2, float y2,
	                            float u1, float v1, float u2, float v2,
	                            int packedLight) {
		if (exposureImage != null) {
			// Drawing a live Exposure image needs a MultiBufferSource, which the submit phase does
			// not carry. Exposure has no 26.1 build, so getRenderableImage always returns null here
			// and this branch is unreachable in practice.
			return;
		}

		this.collector.submitCustomGeometry(poseStack, RenderTypes.text(texture), (pose, consumer) ->
				ClientUtil.emitTexturedQuad(consumer, pose.pose(),
						x1, y1, x2, y2, u1, v1, u2, v2, packedLight, 255, 255, 255, 255));
	}
}
//#endif
