package com.owen233666.blockentityrenderer;

import com.owen233666.block.entity.EaselBlockEntity;
import com.owen233666.block.painting.EaselBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;

public class EaselEntityRenderer implements BlockEntityRenderer<EaselBlockEntity> {

    public EaselEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(EaselBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack stack = entity.getInv().get(0);
        BlockState state = entity.getCachedState();
        Direction direction = state.get(EaselBlock.FACING);
        if (stack.isEmpty()) {
            return;
        }

        // 保存当前矩阵状态
        matrices.push();

        switch (direction) {
            case NORTH -> {
                // 移动到方块中心并抬高一点
                matrices.translate(0.5, 1.17, 0.43);

                //添加轴旋转
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(22.5F));

                // 设置缩放，让物品大小适中
                matrices.scale(0.87F, 0.87F, 0.87F);
            }
            case SOUTH -> {
                // 移动到方块中心并抬高一点
                matrices.translate(0.5, 1.17, 0.57);

                //添加轴旋转
                matrices.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(22.5F));

                // 设置缩放，让物品大小适中
                matrices.scale(0.87F, 0.87F, 0.87F);
            }
            case EAST -> {
                matrices.translate(0.57, 1.17, 0.5);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F));
                matrices.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(22.5F));
                matrices.scale(0.87F, 0.87F, 0.87F);
            }
            case WEST -> {
                matrices.translate(0.43, 1.17, 0.5);
                matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(90.0F));
                matrices.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(22.5F));
                matrices.scale(0.87F, 0.87F, 0.87F);
            }
        }

        // 获取物品渲染器
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        // 获取物品的模型
        BakedModel model = itemRenderer.getModel(stack, entity.getWorld(), null, 0);

        // 渲染物品
        itemRenderer.renderItem(stack, ModelTransformationMode.FIXED, false, matrices,
                vertexConsumers, light, OverlayTexture.DEFAULT_UV, model);

        // 恢复矩阵状态
        matrices.pop();
    }
}
