/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.blockentityrenderer;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.world.level.block.entity.BlockEntity;

/**
 * Carries the block entity itself through the 26.1 extract/submit split.
 *
 * <p>Vanilla copies the data a renderer needs out of the block entity during {@code
 * extractRenderState} so that submission never touches live world state. Every renderer in this mod
 * was written against the pre-26.1 contract, where {@code render} received the block entity
 * directly, so the whole entity is carried here and the existing geometry code is reused verbatim
 * rather than being rewritten into per-field render states.
 */
public class BlockEntityRenderStateHolder<T extends BlockEntity> extends BlockEntityRenderState {

	public T blockEntity;
}
