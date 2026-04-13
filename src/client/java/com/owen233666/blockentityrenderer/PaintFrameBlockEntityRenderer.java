package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.XheFurniture;
import com.owen233666.block.entity.PaintFrameBlockEntity;
import com.owen233666.block.painting.CanvasBlock;
import com.owen233666.block.painting.PlacementState;
import com.owen233666.clientUtil.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class PaintFrameBlockEntityRenderer implements BlockEntityRenderer<PaintFrameBlockEntity> {
    public PaintFrameBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(PaintFrameBlockEntity paintFrameBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockState blockState = paintFrameBlockEntity.getBlockState();
        ItemStack itemStack = paintFrameBlockEntity.getInv().get(0);
        Direction direction = blockState.getValue(CanvasBlock.FACING);
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
        if (resourceLocation.equals(new ResourceLocation("minecraft:air"))) {
            return;
        }
        ResourceLocation textureLocation = compileRenderResourceLocationForPaintings(resourceLocation);
        if (blockState.getValue(CanvasBlock.PLACE_TYPE) == PlacementState.WALL) {


        } else if (blockState.getValue(CanvasBlock.PLACE_TYPE) == PlacementState.CORNER) {
            int count = blockState.getValue(CanvasBlock.COUNT);
            renderCornerPainting(count, textureLocation, poseStack, multiBufferSource, direction, i);
        }
    }

    public void renderCornerPainting(int count, ResourceLocation textureLocation, PoseStack poseStack, MultiBufferSource multiBufferSource, Direction direction, int packedLight) {
        float x1 = 0.0625f, y1 = 0.0625f;
        float x2 = 0.9375f, y2 = 0.9375f;
        float w  = x2 - x1;//x相减得到宽度
        float h  = y2 - y1;//y相臧得到高度
        float hw = w/2; //半宽
        float hh = h/2; //半高

        float yRotation = switch (direction){
            case NORTH -> 0f;
            case SOUTH -> 180f;
            case EAST -> 90f;
            case WEST -> 270f;
            default -> 0f;
        };

        poseStack.pushPose();
        poseStack.translate(x1 + hw, y1 + hh, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(-yRotation));
        poseStack.translate(0, 0, 0.3125);
        poseStack.mulPose(Axis.XP.rotationDegrees(22.5f));
        poseStack.translate(0, -0.05, 0);
        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                hh, hw, -hh, -hw,
                0, 0, 1, 1,
                packedLight, 255, 255, 255, 255);
        poseStack.popPose();
    }

    public void renderVerticalPainting(int count, ResourceLocation textureLocation, PoseStack poseStack, MultiBufferSource multiBufferSource, Direction direction, int packedLight) {
        float x1 = 0.0625f, y1 = 0.0625f;
        float x2 = 0.9375f, y2 = 0.9375f;
        float w  = x2 - x1;//x相减得到宽度
        float h  = y2 - y1;//y相臧得到高度
        float hw = w/2; //半宽
        float hh = h/2; //半高

        float yRotation = switch (direction){
            case NORTH -> 0f;
            case SOUTH -> 180f;
            case EAST -> 90f;
            case WEST -> 270f;
            default -> 0f;
        };

        poseStack.pushPose();
        poseStack.translate(x1 + hw, y1 + hh, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(-yRotation));
        poseStack.translate(0, 0, 0.3125);
        poseStack.mulPose(Axis.XP.rotationDegrees(22.5f));
        poseStack.translate(0, -0.05, 0);
        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                hh, hw, -hh, -hw,
                0, 0, 1, 1,
                packedLight, 255, 255, 255, 255);
        poseStack.popPose();
    }

    private ResourceLocation compileRenderResourceLocationForPaintings(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.getNamespace(), "textures/item/paintings/" + resourceLocation.getPath().replace("painting_", "") + ".png");
    }
}
