package com.owen233666.blockentityrenderer;


import com.owen233666.block.ShoeFlowerPotBlock;
import com.owen233666.block.entity.StorageBlockEntity;
import com.owen233666.clientUtil.ClientUtil;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.RotationAxis;

public class ShoeFlowerPotBlockEntityRenderer implements StorageTypeRenderer {
    public ShoeFlowerPotBlockEntityRenderer() {

    }

    @Override
    public void render(StorageBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, DefaultedList<ItemStack> itemStacks) {
        matrices.translate(-0.5f, 0.4f, 0.6f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));

        for (int i = 0; i < itemStacks.size(); i++) {
            ItemStack stack = itemStacks.get(i);
            if (!stack.isEmpty() && stack.getItem() instanceof BlockItem blockItem) {
                matrices.push();
                matrices.translate(0f, 0f, -0.5f * i);
                ClientUtil.renderBlockFromItem(blockItem, matrices, vertexConsumers, entity);
                matrices.pop();
            }
        }
    }
}
