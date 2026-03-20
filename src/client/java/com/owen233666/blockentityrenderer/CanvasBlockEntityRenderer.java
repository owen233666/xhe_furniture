package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
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
    private final boolean IS_CANVAS_METHOD;
    public CanvasBlockEntityRenderer(BlockEntityRendererProvider.Context context, boolean bool) {
        this.IS_CANVAS_METHOD = bool;
    }

    @Override
    public void render(CanvasBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockState blockState = blockEntity.getBlockState();
        ItemStack stack = blockEntity.getInv().get(0);
        Direction direction = blockState.getValue(CanvasBlock.FACING);

        poseStack.pushPose();
        poseStack.scale(0.87f, 0.87f, 0.87f);
        if (IS_CANVAS_METHOD) {
            if (blockState.getValue(CanvasBlock.PLACE_TYPE) == PlacementState.WALL) {

                switch (direction) {
                    case NORTH -> {
                        poseStack.translate(0.573, 0.573, 1.105);
                    }
                    case SOUTH -> {
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

            } else if (blockState.getValue(CanvasBlock.PLACE_TYPE) == PlacementState.CORNER) {
                int count = blockState.getValue(CanvasBlock.COUNT);
                renderPainting(count, direction, poseStack);
            }
        }else {

        }
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, i, j, poseStack, multiBufferSource, blockEntity.getLevel(), 0);
        poseStack.popPose();
    }

    public void renderPainting(int count, Direction direction, PoseStack poseStack){
        if (count == 1){
            switch (direction) {
                case NORTH -> {
                    poseStack.mulPose(Axis.XP.rotationDegrees(22.5f));
                    poseStack.translate(0.575, 0.855, 0.6085);
                }
                case SOUTH -> {
                    poseStack.mulPose(Axis.XN.rotationDegrees(22.5f));
                    poseStack.translate(0.575, 0.42, 0.4465);
                    poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
                }
                case EAST -> {
                    poseStack.mulPose(Axis.ZP.rotationDegrees(22.5f));
                    poseStack.translate(0.4485, 0.41, 0.575);
                    poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
                }
                case WEST -> {
                    poseStack.mulPose(Axis.ZN.rotationDegrees(22.5f));
                    poseStack.translate(0.6105, 0.855, 0.575);
                    poseStack.mulPose(Axis.YP.rotationDegrees(270.0f));
                }
            }
        } else if (count == 2) {
            switch (direction) {
                case NORTH -> {
                    poseStack.mulPose(Axis.XP.rotationDegrees(22.5f));
                    poseStack.translate(0.575, 0.82375, 0.546);
                }
                case SOUTH -> {
                    poseStack.mulPose(Axis.XN.rotationDegrees(22.5f));
                    poseStack.translate(0.575, 0.38875, 0.519);
                    poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
                }
                case EAST -> {
                    poseStack.mulPose(Axis.ZP.rotationDegrees(22.5f));
                    poseStack.translate(0.516, 0.37875, 0.575);
                    poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
                }
                case WEST -> {
                    poseStack.mulPose(Axis.ZN.rotationDegrees(22.5f));
                    poseStack.translate(0.548, 0.82375, 0.575);
                    poseStack.mulPose(Axis.YP.rotationDegrees(270.0f));
                }
            }
        } else {
            switch (direction) {
                case NORTH -> {
                    poseStack.mulPose(Axis.XP.rotationDegrees(22.5f));
                    poseStack.translate(0.575, 0.7925, 0.4535);
                }
                case SOUTH -> {
                    poseStack.mulPose(Axis.XN.rotationDegrees(22.5f));
                    poseStack.translate(0.575, 0.3575, 0.6015);
                    poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
                }
                case EAST -> {
                    poseStack.mulPose(Axis.ZP.rotationDegrees(22.5f));
                    poseStack.translate(0.6035, 0.3475, 0.575);
                    poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
                }
                case WEST -> {
                    poseStack.mulPose(Axis.ZN.rotationDegrees(22.5f));
                    poseStack.translate(0.4555, 0.7925, 0.575);
                    poseStack.mulPose(Axis.YP.rotationDegrees(270.0f));
                }
            }
        }
    }
}
