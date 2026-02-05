package com.owen233666.blockentityrenderer;

import com.owen233666.block.ShoeFlowerPotBlock;
import com.owen233666.block.entity.StorageBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface StorageTypeRenderer {
    void render(StorageBlockEntity entity, MatrixStack poseStack, VertexConsumerProvider vertexConsumerProvider, DefaultedList<ItemStack> nonNullList);
}
