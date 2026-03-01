package com.owen233666.blockentityrenderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.block.entity.StorageBlockEntity;
import com.owen233666.clientUtil.ClientUtil;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

public class ShoeFlowerPotBlockEntityRenderer implements StorageTypeRenderer {
    public ShoeFlowerPotBlockEntityRenderer() {

    }

    @Override
    public void render(StorageBlockEntity entity, PoseStack poseStack, MultiBufferSource vertexConsumerProvider, NonNullList<ItemStack> nonNullList) {
        poseStack.translate(-0.5f, 0.4f, 0.6f);
        poseStack.mulPose(Axis.YP.rotationDegrees(90));

        for (int i = 0; i < nonNullList.size(); i++) {
            ItemStack stack = nonNullList.get(i);
            if (!stack.isEmpty() && stack.getItem() instanceof BlockItem blockItem) {
                poseStack.pushPose();
                poseStack.translate(0f, 0f, -0.5f * i);
                ClientUtil.renderBlockFromItem(blockItem, poseStack, vertexConsumerProvider, entity);
                poseStack.popPose();
            }
        }
    }
}
