package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.block.entity.PhotoBBlockEntity;
import com.owen233666.block.painting.PhotoPaperBlock;
import com.owen233666.clientUtil.ExposurePhotoUtil;
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
        if (itemStack.isEmpty()) {
            return;
        }
        Object exposureImage = ExposurePhotoUtil.getRenderableImage(itemStack);
        ResourceLocation textureLocation = null;
        if (exposureImage == null) {
            if (ExposurePhotoUtil.isPhotograph(itemStack)) {
                return;
            }
            ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
            if (resourceLocation.equals(new ResourceLocation("minecraft:air"))) {
                return;
            }
            textureLocation = compileRenderResourceLocationForPaintings(resourceLocation);
        }
        Direction direction = blockEntity.getBlockState().getValue(PhotoPaperBlock.FACING);

        switch (direction) {
            case NORTH -> {
                renderPhotos(poseStack, multiBufferSource, exposureImage, textureLocation, i, null, 0.99f, 0.0f);
            }
            case SOUTH -> {
                renderPhotos(poseStack, multiBufferSource, exposureImage, textureLocation, i, 0.99f, 0.01f, 180.0f);
            }
            case WEST -> {
                renderPhotos(poseStack, multiBufferSource, exposureImage, textureLocation, i, 0.99f, 0.99f, 90.0f);
            }
            case EAST -> {
                renderPhotos(poseStack, multiBufferSource, exposureImage, textureLocation, i, 0.01f, null, 270.0f);
            }
        }
    }

    private void renderPhotos(PoseStack poseStack, MultiBufferSource multiBufferSource,
                              @Nullable Object exposureImage, ResourceLocation textureLocation,
                              int packedLight, @Nullable Float offsetX, @Nullable Float offsetZ, Float yRotationDegrees) {
        float x1 = 0.57500f;
        float y1 = 0.20625f;
        float x2 = 0.82500f;
        float y2 = 0.48750f;
        float w  = x2-x1;
        float h  = y2 - y1;
        float hw = w/2;
        float hh = h/2;

        poseStack.pushPose();
        poseStack.translate(offsetX == null ? 0.0f :offsetX, 0.0F, offsetZ == null ? 0.0f :offsetZ);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
        poseStack.translate(x1 + hw, y1 + hh, 0);
        poseStack.mulPose(Axis.ZP.rotationDegrees(-22.5f));
        ExposurePhotoUtil.renderPhotoOrPainting(exposureImage, textureLocation, poseStack, multiBufferSource,
                -hw, -hh, hw, hh,
                CUBE_UV_1[0],CUBE_UV_1[1],CUBE_UV_1[2],CUBE_UV_1[3],
                packedLight);
        poseStack.popPose();


        x1 = 0.15625f;
        y1 = 0.54375f;
        x2 = 0.40625f;
        y2 = 0.82500f;
        w  = x2 - x1;
        h  = y2 - y1;
        hw = w/2;
        hh = h/2;

        poseStack.pushPose();
        poseStack.translate(offsetX == null? 0.0f :offsetX, 0.0F, offsetZ== null ? 0.0f :offsetZ);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRotationDegrees));
        poseStack.translate(x1 + hw, y1 + hh, 0);
        poseStack.mulPose(Axis.ZP.rotationDegrees(22.5f));
        ExposurePhotoUtil.renderPhotoOrPainting(exposureImage, textureLocation, poseStack, multiBufferSource,
                -hw,-hh,hw, hh,
                CUBE_UV_2[0],CUBE_UV_2[1],CUBE_UV_2[2],CUBE_UV_2[3],
                packedLight);
        poseStack.popPose();
    }


    private ResourceLocation compileRenderResourceLocationForPaintings(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.getNamespace(), "textures/item/paintings/" + resourceLocation.getPath().replace("painting_", "") + ".png");
    }
}
