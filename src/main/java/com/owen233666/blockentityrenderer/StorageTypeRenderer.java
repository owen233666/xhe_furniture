/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.owen233666.block.entity.StorageBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

public interface StorageTypeRenderer {
    void render(StorageBlockEntity entity, PoseStack poseStack, MultiBufferSource vertexConsumerProvider, NonNullList<ItemStack> nonNullList);
}
