package com.owen233666.blockentityrenderer;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.math.Axis;
//import com.owen233666.block.entity.PhotoABlockEntity;
//import com.owen233666.block.entity.PhotoBBlockEntity;
//import com.owen233666.block.painting.PhotoPaperBlock;
//import com.owen233666.clientUtil.ClientUtil;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
//import net.minecraft.core.Direction;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import org.jetbrains.annotations.Nullable;
//
//public class PhotoBBlockRenderer implements BlockEntityRenderer<PhotoBBlockEntity> {
//    private final float[] CUBE_UV_1 = {0.43750f,     0.00000f,    0.68750f,     0.28125f};
//    private final float[] CUBE_UV_2 = {0.21875f,     0.25000f,    0.46875f,     0.53125f};
//
//    public PhotoBBlockRenderer(BlockEntityRendererProvider.Context context) {
//    }
//
//    @Override
//    public void render(PhotoBBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
//        ItemStack itemStack = blockEntity.getInv().getFirst();
//        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
//        if (resourceLocation.equals(new ResourceLocation("minecraft:air"))) {
//            return;
//        }
//        ResourceLocation textureLocation = compileRenderResourceLocationForPaintings(resourceLocation);
//        Direction direction = blockEntity.getBlockState().getValue(PhotoPaperBlock.FACING);
//
//        switch (direction) {
//            case NORTH -> {
//
//                poseStack.pushPose();
//
//                float centerX1 = (0.57500f + 0.82500f) / 2;
//                float centerY1 = (0.20625f + 0.48750f) / 2;
//
//                poseStack.translate(centerX1, centerY1, 0);
//
//                poseStack.mulPose(Axis.YP.rotationDegrees(0.0f));
//                poseStack.mulPose(Axis.ZP.rotationDegrees(-22.5f));
//
//                poseStack.translate(-centerX1, -centerY1, 0);
//
//                poseStack.translate(0.0f, 0.0F, 0.99f);
//
//
//
//                ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
//                        0.57500f, 0.20625f, 0.82500f, 0.48750f,
//                        CUBE_UV_1[0], CUBE_UV_1[1], CUBE_UV_1[2], CUBE_UV_1[3],
//                        i, 255, 255, 255, 255);
//
//                poseStack.popPose();
//            }
//            case SOUTH -> {
//
//                poseStack.pushPose();
//
//                float centerX1 = (0.57500f + 0.82500f) / 2;
//                float centerY1 = (0.20625f + 0.48750f) / 2;
//
//                poseStack.translate(centerX1, centerY1, 0);
//
//                poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
//                poseStack.mulPose(Axis.ZP.rotationDegrees(-22.5f));
//
//                poseStack.translate(-centerX1, -centerY1, 0);
//
//                poseStack.translate(0.4125, 0.1625f, -0.01f);
//
//
//
//                ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
//                        0.57500f, 0.20625f, 0.82500f, 0.48750f,
//                        CUBE_UV_1[0], CUBE_UV_1[1], CUBE_UV_1[2], CUBE_UV_1[3],
//                        i, 255, 255, 255, 255);
//
//                poseStack.popPose();
////                renderPhotos(poseStack, multiBufferSource, textureLocation, i, -1.0f, -0.01f, 180.0f);
//            }
//            case WEST -> {
////                renderPhotos(poseStack, multiBufferSource, textureLocation, i, -1.0f, 0.99f, 90.0f);
//            }
//            case EAST -> {
////                renderPhotos(poseStack, multiBufferSource, textureLocation, i, null, 0.01f, 270.0f);
//            }
//        }
//    }
//
////    private void renderPhotos(PoseStack poseStack, MultiBufferSource multiBufferSource, ResourceLocation textureLocation,
////                              int packedLight, @Nullable Float offsetX, @Nullable Float offsetZ, Float yRotationDegrees) {
////
////        // 第一个照片
////        poseStack.pushPose();
////
////        // 先计算原始中心点（不考虑偏移）
////        float centerX1 = (0.57500f + 0.82500f) / 2;
////        float centerY1 = (0.20625f + 0.48750f) / 2;
////
////        // 然后再移动到照片的中心位置
////        poseStack.translate(centerX1, centerY1, 0);
////
////        // 应用旋转
////        poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
////        poseStack.mulPose(Axis.ZP.rotationDegrees(-22.5f));
////
////        // 移回原位以便在正确位置渲染
////        poseStack.translate(-centerX1, -centerY1, 0);
////
////
////        // 先应用基础变换到照片位置（包括偏移）
////        poseStack.translate(offsetX == null ? 0.0f : offsetX,
////                0.0F,
////                offsetZ == null ? 0.0f : offsetZ);
////
////
////
////        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
////                0.57500f, 0.20625f, 0.82500f, 0.48750f,
////                CUBE_UV_1[0], CUBE_UV_1[1], CUBE_UV_1[2], CUBE_UV_1[3],
////                packedLight, 255, 255, 255, 255);
////
////        poseStack.popPose();
////
////        // 第二个照片
////        poseStack.pushPose();
////
////        float centerX2 = (0.15625f + 0.40625f) / 2;
////        float centerY2 = (0.54375f + 0.82500f) / 2;
////        // 然后再移动到照片的中心位置
////        poseStack.translate(centerX2, centerY2, 0);
////
////        // 应用旋转
////        poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
////        poseStack.mulPose(Axis.ZP.rotationDegrees(22.5f));
////
////        // 移回原位
////        poseStack.translate(-centerX2, -centerY2, 0);
////        // 先应用基础变换到照片位置（包括偏移）
////        poseStack.translate(offsetX == null ? 0.0f : offsetX,
////                0.0F,
////                offsetZ == null ? 0.0f : offsetZ);
////
////
////
////        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
////                0.15625f, 0.54375f, 0.40625f, 0.82500f,
////                CUBE_UV_2[0], CUBE_UV_2[1], CUBE_UV_2[2], CUBE_UV_2[3],
////                packedLight, 255, 255, 255, 255);
////
////        poseStack.popPose();
////    }
//
//
//    private ResourceLocation compileRenderResourceLocationForPaintings(ResourceLocation resourceLocation) {
//        return new ResourceLocation(resourceLocation.getNamespace(), "textures/item/paintings/" + resourceLocation.getPath().replace("painting_", "") + ".png");
//    }
//}


//package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.block.entity.PhotoBBlockEntity;
import com.owen233666.block.painting.PhotoPaperBlock;
import com.owen233666.clientUtil.ClientUtil;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class PhotoBBlockRenderer implements BlockEntityRenderer<PhotoBBlockEntity> {
    private final float[] CUBE_UV_1 = {0.43750f,     0.00000f,    0.68750f,     0.28125f};
    private final float[] CUBE_UV_2 = {0.21875f,     0.25000f,    0.46875f,     0.53125f};

    public PhotoBBlockRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(PhotoBBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        ItemStack itemStack = blockEntity.getInv().getFirst();
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
        if (resourceLocation.equals(new ResourceLocation("minecraft:air"))) {
            return;
        }
        ResourceLocation textureLocation = compileRenderResourceLocationForPaintings(resourceLocation);
        Direction direction = blockEntity.getBlockState().getValue(PhotoPaperBlock.FACING);

        switch (direction) {
            case NORTH -> {
                renderPhotos(poseStack, multiBufferSource, textureLocation, i, null, 0.99f, 0.0f);
            }
            case SOUTH -> {
                renderPhotos(poseStack, multiBufferSource, textureLocation, i, 0.99f, 0.01f, 180.0f);
            }
            case WEST -> {
                renderPhotos(poseStack, multiBufferSource, textureLocation, i, 0.99f, 0.99f, 90.0f);
            }
            case EAST -> {
                renderPhotos(poseStack, multiBufferSource, textureLocation, i, 0.01f, null, 270.0f);
            }
        }
    }

    private void renderPhotos(PoseStack poseStack, MultiBufferSource multiBufferSource, ResourceLocation textureLocation,
                              int packedLight, @Nullable Float offsetX, @Nullable Float offsetZ, Float yRotationDegrees) {
        float x1 = 0.57500f;//左下x
        float y1 = 0.20625f;//左下y
        float x2 = 0.82500f;//右上x
        float y2 = 0.48750f;//右上y
        float w  = x2-x1;//x相减得到宽度
        float h  = y2 - y1;//y相臧得到高度
        float hw = w/2; //半宽
        float hh = h/2; //半高

        poseStack.pushPose();
        //x1和y1是仅限”图片左下角为原点”时的移动长度，图片左下角距离图片中心（我们设定的原点）差个半高半宽，加上
        poseStack.translate(offsetX == null ? 0.0f :offsetX, 0.0F, offsetZ == null ? 0.0f :offsetZ);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
        poseStack.translate(x1 + hw, y1 + hh, 0);
        poseStack.mulPose(Axis.ZP.rotationDegrees(-22.5f));
        //以图片中心为原点绘制图片
        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                -hw, -hh, hw, hh,
                CUBE_UV_1[0],CUBE_UV_1[1],CUBE_UV_1[2],CUBE_UV_1[3],
                packedLight,255,255,255,255);
        poseStack.popPose();


        x1 = 0.15625f;//左下x
        y1 = 0.54375f;//左下y
        x2 = 0.40625f;//右上x
        y2 = 0.82500f;//右上y
        w  = x2 - x1;//x相减得到宽度
        h  = y2 - y1;//y相减得到高度
        hw = w/2;//半宽
        hh = h/2;//半高

        poseStack.pushPose();
        poseStack.translate(offsetX == null? 0.0f :offsetX, 0.0F, offsetZ== null ? 0.0f :offsetZ);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
        poseStack.translate(x1 + hw, y1 + hh, 0);
        poseStack.mulPose(Axis.ZP.rotationDegrees(22.5f));
        ClientUtil.renderTexture(textureLocation,poseStack,multiBufferSource,
                -hw,-hh,hw, hh,
                CUBE_UV_2[0],CUBE_UV_2[1],CUBE_UV_2[2],CUBE_UV_2[3],
                packedLight,255,255,255,255);
        poseStack.popPose();
    }


    private ResourceLocation compileRenderResourceLocationForPaintings(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.getNamespace(), "textures/item/paintings/" + resourceLocation.getPath().replace("painting_", "") + ".png");
    }
}
