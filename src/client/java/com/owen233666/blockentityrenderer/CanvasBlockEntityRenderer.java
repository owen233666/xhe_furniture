package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.XheFurniture;
import com.owen233666.block.entity.CanvasBlockEntity;
import com.owen233666.block.painting.CanvasBlock;
import com.owen233666.block.painting.PlacementState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class CanvasBlockEntityRenderer implements BlockEntityRenderer<CanvasBlockEntity> {
    public CanvasBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(CanvasBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockState blockState = blockEntity.getBlockState();
        ItemStack stack = blockEntity.getInv().get(0);
        Direction direction = blockState.getValue(CanvasBlock.FACING);
        poseStack.pushPose();
        if (blockState.getValue(CanvasBlock.PLACE_TYPE) == PlacementState.WALL){
            poseStack.scale(0.87f, 0.87f, 0.87f);

            switch (direction){
                case NORTH -> {
                    poseStack.translate(0.573, 0.573, 1.105);
                }
                case SOUTH ->  {
                    poseStack.translate(0.573, 0.573, 0.045);
                    poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
                }
                case EAST -> {
                    poseStack.translate(0.045, 0.573, 0.573);
                    poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
                }
                case WEST -> {
                    poseStack.translate(1.105, 0.573, 0.573);
                    poseStack.mulPose(Axis.YP.rotationDegrees(270.0f));
                }
            }

        }else{

        }
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, i, j, poseStack, multiBufferSource, blockEntity.getLevel(), 0);
        poseStack.popPose();
    }
}
