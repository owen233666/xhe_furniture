package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.block.entity.EaselBlockEntity;
import com.owen233666.block.painting.EaselBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class EaselBlockEntityRenderer implements BlockEntityRenderer<EaselBlockEntity> {

    public EaselBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(EaselBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        ItemStack stack = blockEntity.getInv().get(0);
        BlockState state = blockEntity.getBlockState();
        Direction direction = state.getValue(EaselBlock.FACING);
        if (stack.isEmpty()) {
            return;
        }

        // 保存当前矩阵状态
        poseStack.pushPose();

        switch (direction) {
            case NORTH -> {
                // 移动到方块中心并抬高一点
                poseStack.translate(0.5, 1.17, 0.43);

                //添加轴旋转
                poseStack.mulPose(Axis.XP.rotationDegrees(22.5F));

                // 设置缩放，让物品大小适中
                poseStack.scale(0.87F, 0.87F, 0.87F);
            }
            case SOUTH -> {
                // 移动到方块中心并抬高一点
                poseStack.translate(0.5, 1.17, 0.57);

                //添加轴旋转
                poseStack.mulPose(Axis.XN.rotationDegrees(22.5F));

                // 设置缩放，让物品大小适中
                poseStack.scale(0.87F, 0.87F, 0.87F);
            }
            case EAST -> {
                poseStack.translate(0.57, 1.17, 0.5);
                poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
                poseStack.mulPose(Axis.XN.rotationDegrees(22.5F));
                poseStack.scale(0.87F, 0.87F, 0.87F);
            }
            case WEST -> {
                poseStack.translate(0.43, 1.17, 0.5);
                poseStack.mulPose(Axis.YN.rotationDegrees(90.0F));
                poseStack.mulPose(Axis.XN.rotationDegrees(22.5F));
                poseStack.scale(0.87F, 0.87F, 0.87F);
            }
        }

        // 获取物品渲染器
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, i, j, poseStack, multiBufferSource, blockEntity.getLevel(), 0);
        poseStack.popPose();
    }
}
