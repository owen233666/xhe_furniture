package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.block.entity.PhotoCBlockEntity;
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

public class PhotoCBlockRenderer implements BlockEntityRenderer<PhotoCBlockEntity> {
    private final float[] CUBE_UV_1 = {0.50000f,     0.18750f,    0.75000f,     0.40625f};
    private final float[] CUBE_UV_2 = {0.21875f,     0.50000f,    0.46875f,     0.71875f};
    private final float[] CUBE_UV_3 = {0.21875f,     0.25000f,    0.46875f,     0.46875f};

    public PhotoCBlockRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(PhotoCBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
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
        //左下
        poseStack.pushPose();
        poseStack.translate(offsetX == null ? 0.0f : offsetX, 0.0F, offsetZ == null ? 0.0f : offsetZ);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                0.20000f, 0.64375f, 0.45000f, 0.86250f,
                CUBE_UV_1[0], CUBE_UV_1[1], CUBE_UV_1[2], CUBE_UV_1[3],
                packedLight, 255, 255, 255, 255);
        poseStack.popPose();
        //左上空的
        poseStack.pushPose();
        poseStack.translate(offsetX == null ? 0.0f : offsetX, 0.0F, offsetZ == null ? 0.0f : offsetZ);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                0.15625f, 0.23125f, 0.40625f, 0.45000f,
                CUBE_UV_2[0], CUBE_UV_2[1], CUBE_UV_2[2], CUBE_UV_2[3],
                packedLight, 255, 255, 255, 255);
        poseStack.popPose();
        //右边块
        poseStack.pushPose();
        poseStack.translate(offsetX == null ? 0.0f : offsetX, 0.0F, offsetZ == null ? 0.0f : offsetZ);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                0.59375f, 0.54375f, 0.84375f, 0.76250f,
                CUBE_UV_3[0], CUBE_UV_3[1], CUBE_UV_3[2], CUBE_UV_3[3],
                packedLight, 255, 255, 255, 255);
        poseStack.popPose();
    }


    private ResourceLocation compileRenderResourceLocationForPaintings(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.getNamespace(), "textures/item/paintings/" + resourceLocation.getPath().replace("painting_", "") + ".png");
    }
}
