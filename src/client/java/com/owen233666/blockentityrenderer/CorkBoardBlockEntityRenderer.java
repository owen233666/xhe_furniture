package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.block.CorkBoardBlock;
import com.owen233666.block.entity.CorkBoardBlockEntity;
import com.owen233666.block.painting.PhotoType;
import com.owen233666.item.ModItemTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class CorkBoardBlockEntityRenderer implements BlockEntityRenderer<CorkBoardBlockEntity> {

    private final ModelBlockRenderer modelBlockRenderer;

    public CorkBoardBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.modelBlockRenderer = context.getBlockRenderDispatcher().getModelRenderer();
    }

    @Override
    public void render(CorkBoardBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockState state = blockEntity.getBlockState();
        ItemStack photoPaperStack = blockEntity.getInv().get(0);
        ItemStack paintingStack = blockEntity.getInv().get(1);
        Direction direction = state.getValue(CorkBoardBlock.FACING);

        //slot0物品应在ModItemTags.PHOTO_PAPERS中，否则不渲染
        if (photoPaperStack.isEmpty()
                || !BuiltInRegistries.ITEM.wrapAsHolder(photoPaperStack.getItem()).is(ModItemTags.PHOTO_PAPERS)) {
            return;
        }

        PhotoType photoType = photoType(photoPaperStack);

        renderPhotoPaper(photoPaperStack, poseStack, multiBufferSource, i, direction);

        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(paintingStack.getItem());
        if (resourceLocation.equals(new ResourceLocation("minecraft:air"))) return;

        ResourceLocation paintingTextureLocation = GridShelfBlockEntityRenderer.compileRenderResourceLocationForPaintings(resourceLocation);

        switch (direction) {
            case NORTH -> GridShelfBlockEntityRenderer.renderAsPhotoType(photoType, poseStack, multiBufferSource, paintingTextureLocation, i, null, 0.9275f, 0.0f);
            case SOUTH -> GridShelfBlockEntityRenderer.renderAsPhotoType(photoType, poseStack, multiBufferSource, paintingTextureLocation, i, 1.00f, 0.0725f, 180.0f);
            case WEST  -> GridShelfBlockEntityRenderer.renderAsPhotoType(photoType, poseStack, multiBufferSource, paintingTextureLocation, i, 0.9275f, 1.00f, 90.0f);
            default    -> GridShelfBlockEntityRenderer.renderAsPhotoType(photoType, poseStack, multiBufferSource, paintingTextureLocation, i, 0.0725f, null, 270.0f);
        }
    }

    private PhotoType photoType(ItemStack stack) {
        Item item = stack.getItem();
        if (BuiltInRegistries.ITEM.wrapAsHolder(item).is(ModItemTags.TYPE_A_PHOTO_PAPERS)) return PhotoType.A;
        else if (BuiltInRegistries.ITEM.wrapAsHolder(item).is(ModItemTags.TYPE_B_PHOTO_PAPERS)) return PhotoType.B;
        else return PhotoType.C;
    }

    private void renderPhotoPaper(ItemStack photoPaperStack, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Direction direction) {
        BakedModel model = getPhotoPaperModel(photoPaperStack);
        if (model == null) return;

        poseStack.pushPose();

        poseStack.translate(direction.getStepX() * 0.0625, 0.0, direction.getStepZ() * 0.0625);

        poseStack.translate(0.5, 0.5, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRotation(direction)));
        poseStack.translate(-0.5, -0.5, -0.5);

        modelBlockRenderer.renderModel(
                poseStack.last(),
                multiBufferSource.getBuffer(RenderType.cutout()),
                null, model,
                1.0F, 1.0F, 1.0F,
                packedLight, OverlayTexture.NO_OVERLAY
        );

        poseStack.popPose();
    }

    private float yRotation(Direction direction) {
        return switch (direction) {
            case NORTH -> 0f;
            case SOUTH -> 180f;
            case EAST -> 270f;
            case WEST -> 90f;
            default -> 0f;
        };
    }

    private static BakedModel getPhotoPaperModel(ItemStack stack) {
        BakedModel model = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getItemModel(stack.getItem());
        ModelManager modelManager = Minecraft.getInstance().getModelManager();
        return model == modelManager.getMissingModel() ? null : model;
    }
}
