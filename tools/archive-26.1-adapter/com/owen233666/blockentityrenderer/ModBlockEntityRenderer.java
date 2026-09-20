/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
//#if MC >= 260102
package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;

/**
 * Common base for this mod's block entity renderers.
 *
 * <p>Every renderer only has to implement {@link #draw}, which is written against {@link
 * RenderEmitter}. This class supplies the two different contracts the game has used around it:
 * immediate drawing on 1.21.1 and older, and the 26.1 extract/submit pair. The item and block model
 * resolvers needed by the 26.1 submit phase are taken from the renderer context here.
 */
public abstract class ModBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<T, BlockEntityRenderStateHolder<T>> {

	protected final ItemModelResolver itemModelResolver;
	protected final BlockModelResolver blockModelResolver;

	protected ModBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
		this.itemModelResolver = context.itemModelResolver();
		this.blockModelResolver = context.blockModelResolver();
	}

	@Override
	public BlockEntityRenderStateHolder<T> createRenderState() {
		return new BlockEntityRenderStateHolder<>();
	}

	@Override
	public void extractRenderState(T blockEntity, BlockEntityRenderStateHolder<T> state, float partialTick, Vec3 cameraPosition, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
		BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTick, cameraPosition, breakProgress);
		state.blockEntity = blockEntity;
	}

	@Override
	public final void submit(BlockEntityRenderStateHolder<T> state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {
		this.draw(state.blockEntity, poseStack,
				new SubmitRenderEmitter(collector, this.itemModelResolver, this.blockModelResolver),
				state.lightCoords, OverlayTexture.NO_OVERLAY);
	}

	/** Draws the block entity at the current pose. */
	protected abstract void draw(T blockEntity, PoseStack poseStack, RenderEmitter emitter, int packedLight, int overlay);
}
//#else
//$$ package com.owen233666.blockentityrenderer;
//$$
//$$ import com.mojang.blaze3d.vertex.PoseStack;
//$$ import net.minecraft.client.renderer.MultiBufferSource;
//$$ import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//$$ import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
//$$ import net.minecraft.world.level.block.entity.BlockEntity;
//$$
//$$ /**
//$$  * Common base for this mod's block entity renderers.
//$$  *
//$$  * <p>Every renderer only has to implement {@link #draw}, which is written against {@link
//$$  * RenderEmitter}. This class supplies the two different contracts the game has used around it:
//$$  * immediate drawing on 1.21.1 and older, and the 26.1 extract/submit pair.
//$$  */
//$$ public abstract class ModBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {
//$$
//$$ 	protected ModBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
//$$ 	}
//$$
//$$ 	@Override
//$$ 	public void render(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int overlay) {
//$$ 		this.draw(blockEntity, poseStack, new LegacyRenderEmitter(multiBufferSource), packedLight, overlay);
//$$ 	}
//$$
//$$ 	/** Draws the block entity at the current pose. */
//$$ 	protected abstract void draw(T blockEntity, PoseStack poseStack, RenderEmitter emitter, int packedLight, int overlay);
//$$ }
//#endif
