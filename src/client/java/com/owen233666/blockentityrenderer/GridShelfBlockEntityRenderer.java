package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.XheFurniture;
import com.owen233666.block.entity.GridShelfBlockEntity;
import com.owen233666.block.painting.GridShelfBlock;
import com.owen233666.clientUtil.ClientUtil;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class GridShelfBlockEntityRenderer implements BlockEntityRenderer<GridShelfBlockEntity> {
    private final float[] CUBE_UV_1_A = {0.21875f,     0.65625f,    0.46875f,     0.93750f};
    private final float[] CUBE_UV_2_A = {0.34375f,     0.09375f,    0.60625f,     0.37500f};
    private final float[] CUBE_UV_3_A = {0.65625f,     0.31250f,    0.90625f,     0.59375f};
    private final float[] CUBE_UV_1_B = {0.43750f,     0.00000f,    0.68750f,     0.28125f};
    private final float[] CUBE_UV_2_B = {0.21875f,     0.25000f,    0.46875f,     0.53125f};
    private final float[] CUBE_UV_1_C = {0.50000f,     0.18750f,    0.75000f,     0.40625f};
    private final float[] CUBE_UV_2_C = {0.21875f,     0.50000f,    0.46875f,     0.71875f};
    private final float[] CUBE_UV_3_C = {0.21875f,     0.25000f,    0.46875f,     0.46875f};

    public GridShelfBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(GridShelfBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockState state = blockEntity.getBlockState();
        ItemStack stack = blockEntity.getInv().getFirst();
        Direction direction = state.getValue(GridShelfBlock.FACING);
        GridShelfBlock.PhotoType photoType = state.getValue(GridShelfBlock.PHOTO_TYPE);

        if (!state.getValue(GridShelfBlock.HAS_PHOTO)) return;

        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(stack.getItem());
        if (resourceLocation.equals(new ResourceLocation("minecraft:air"))) {
            return;
        }
        ResourceLocation textureLocation = compileRenderResourceLocationForPaintings(resourceLocation);

        switch (direction) {
            case NORTH -> {
                renderAsPhotoType(photoType, poseStack, multiBufferSource, textureLocation, i, null, 0.9275f, 0.0f);
            }
            case SOUTH -> {
                renderAsPhotoType(photoType, poseStack, multiBufferSource, textureLocation, i, 1.00f, 0.0725f, 180.0f);
            }
            case WEST -> {
                renderAsPhotoType(photoType, poseStack, multiBufferSource, textureLocation, i, 0.9275f, 1.00f, 90.0f);
            }
            case EAST -> {
                renderAsPhotoType(photoType, poseStack, multiBufferSource, textureLocation, i, 0.0725f, null, 270.0f);
            }
        }
    }

    public void renderAsPhotoType(GridShelfBlock.PhotoType photoType, PoseStack poseStack, MultiBufferSource multiBufferSource, ResourceLocation textureLocation,
                                  int packedLight, @Nullable Float offsetX, @Nullable Float offsetZ, Float yRotationDegrees) {
        switch (photoType) {
            case A -> {
                //左下
                poseStack.pushPose();
                poseStack.translate(offsetX == null ? 0.0f : offsetX, 0.0F, offsetZ == null ? 0.0f : offsetZ);
                poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
                ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                        0.50000f, 0.16875f, 0.75000f, 0.45000f,
                        CUBE_UV_1_A[0], CUBE_UV_1_A[1], CUBE_UV_1_A[2], CUBE_UV_1_A[3],
                        packedLight, 255, 255, 255, 255);
                poseStack.popPose();
                //左上空的
                poseStack.pushPose();
                poseStack.translate(offsetX == null ? 0.0f : offsetX, 0.0F, offsetZ == null ? 0.0f : offsetZ);
                poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
                ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                        0.58750f, 0.58750f, 0.85000f, 0.86875f,
                        CUBE_UV_2_A[0], CUBE_UV_2_A[1], CUBE_UV_2_A[2], CUBE_UV_2_A[3],
                        packedLight, 255, 255, 255, 255);
                poseStack.popPose();
                //右边块
                poseStack.pushPose();
                poseStack.translate(offsetX == null ? 0.0f : offsetX, 0.0F, offsetZ == null ? 0.0f : offsetZ);
                poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
                ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                        0.15625f, 0.43750f, 0.40625f, 0.71875f,
                        CUBE_UV_3_A[0], CUBE_UV_3_A[1], CUBE_UV_3_A[2], CUBE_UV_3_A[3],
                        packedLight, 255, 255, 255, 255);
                poseStack.popPose();
            }
            case B -> {
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
                        CUBE_UV_1_B[0], CUBE_UV_1_B[1], CUBE_UV_1_B[2], CUBE_UV_1_B[3],
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
                        CUBE_UV_2_B[0], CUBE_UV_2_B[1], CUBE_UV_2_B[2], CUBE_UV_2_B[3],
                        packedLight,255,255,255,255);
                poseStack.popPose();
            }
            case C -> {
                //左下
                poseStack.pushPose();
                poseStack.translate(offsetX == null ? 0.0f : offsetX, 0.0F, offsetZ == null ? 0.0f : offsetZ);
                poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
                ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                        0.20000f, 0.64375f, 0.45000f, 0.86250f,
                        CUBE_UV_1_C[0], CUBE_UV_1_C[1], CUBE_UV_1_C[2], CUBE_UV_1_C[3],
                        packedLight, 255, 255, 255, 255);
                poseStack.popPose();
                //左上空的
                poseStack.pushPose();
                poseStack.translate(offsetX == null ? 0.0f : offsetX, 0.0F, offsetZ == null ? 0.0f : offsetZ);
                poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
                ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                        0.15625f, 0.23125f, 0.40625f, 0.45000f,
                        CUBE_UV_2_C[0], CUBE_UV_2_C[1], CUBE_UV_2_C[2], CUBE_UV_2_C[3],
                        packedLight, 255, 255, 255, 255);
                poseStack.popPose();
                //右边块
                poseStack.pushPose();
                poseStack.translate(offsetX == null ? 0.0f : offsetX, 0.0F, offsetZ == null ? 0.0f : offsetZ);
                poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
                ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                        0.59375f, 0.54375f, 0.84375f, 0.76250f,
                        CUBE_UV_3_C[0], CUBE_UV_3_C[1], CUBE_UV_3_C[2], CUBE_UV_3_C[3],
                        packedLight, 255, 255, 255, 255);
                poseStack.popPose();
            }
        }
    }

    private ResourceLocation compileRenderResourceLocationForPaintings(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.getNamespace(), "textures/item/paintings/" + resourceLocation.getPath().replace("painting_", "") + ".png");
    }
}
