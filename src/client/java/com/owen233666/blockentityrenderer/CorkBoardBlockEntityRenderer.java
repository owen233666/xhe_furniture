package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.owen233666.XheFurniture;
import com.owen233666.block.CorkBoardBlock;
import com.owen233666.block.entity.CorkBoardBlockEntity;
import com.owen233666.block.painting.GridShelfBlock;
import com.owen233666.block.painting.PhotoType;
import com.owen233666.item.ModItemTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
        ItemStack paintingStack   = blockEntity.getInv().get(1);
        Direction direction = state.getValue(CorkBoardBlock.FACING);
        PhotoType photoType = photoType(photoPaperStack);

        if (photoPaperStack.isEmpty()) return;

        BakedModel model = bakedmodel(photoType);

        XheFurniture.LOGGER.warn("model=" + model);
        XheFurniture.LOGGER.warn("missing=" + (model == Minecraft.getInstance()
                .getModelManager()
                .getMissingModel()));

        ResourceLocation photoTextureLocation = new ResourceLocation(XheFurniture.MOD_ID, BuiltInRegistries.ITEM.getKey(photoPaperStack.getItem()).toString().replaceFirst(XheFurniture.MOD_ID + ":", "textures/block/").replaceAll("_[abc]$", "")+".png");

        renderPhotoPaper(photoPaperStack.getItem(), poseStack, multiBufferSource, photoTextureLocation, i, direction);

        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(paintingStack.getItem());

        if (resourceLocation.equals(new ResourceLocation("minecraft:air"))) return;

        ResourceLocation paintingTextureLocation = GridShelfBlockEntityRenderer.compileRenderResourceLocationForPaintings(resourceLocation);

        switch (direction) {
            case NORTH -> GridShelfBlockEntityRenderer.renderAsPhotoType(photoType, poseStack, multiBufferSource, paintingTextureLocation, i,  null,     0.9275f, 0.0f);
            case SOUTH -> GridShelfBlockEntityRenderer.renderAsPhotoType(photoType, poseStack, multiBufferSource, paintingTextureLocation, i,  1.00f,    0.0725f, 180.0f);
            case WEST  -> GridShelfBlockEntityRenderer.renderAsPhotoType(photoType, poseStack, multiBufferSource, paintingTextureLocation, i,  0.9275f,  1.00f,   90.0f);
            default    -> GridShelfBlockEntityRenderer.renderAsPhotoType(photoType, poseStack, multiBufferSource, paintingTextureLocation, i,  0.0725f,  null,    270.0f);
        }
    }

    private PhotoType photoType(ItemStack stack) {
        Item item = stack.getItem();
        if (BuiltInRegistries.ITEM.wrapAsHolder(item).is(ModItemTags.TYPE_A_PHOTO_PAPERS)) return PhotoType.A;
        else if (BuiltInRegistries.ITEM.wrapAsHolder(item).is(ModItemTags.TYPE_B_PHOTO_PAPERS)) return PhotoType.B;
        else return PhotoType.C;
    }

    private void renderPhotoPaper(Item photoItem, PoseStack poseStack, MultiBufferSource multiBufferSource, ResourceLocation textureLocation, int packedLight, Direction direction) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);

        RenderSystem.setShaderTexture(0, textureLocation);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();

        switch (direction) {
            case NORTH -> poseStack.translate(-0.5, -0.5, -0.5);
            case SOUTH -> poseStack.translate(0.5, -0.5, -0.5);
            case WEST  -> poseStack.translate(-0.5, -0.5, -0.5);
            case EAST  -> poseStack.translate(0.5, -0.5, -0.5);
        }

        if (getPhotoType(photoItem) == PhotoType.A) {
            XheFurniture.LOGGER.warn(String.valueOf(new ModelResourceLocation(XheFurniture.MOD_ID, "block/parent/photo_paper_a", "")));
        }else if (getPhotoType(photoItem) == PhotoType.B) {
            XheFurniture.LOGGER.warn(String.valueOf(new ModelResourceLocation(XheFurniture.MOD_ID, "block/parent/photo_paper_b", "")));
        }else {
            XheFurniture.LOGGER.warn(String.valueOf(new ModelResourceLocation(XheFurniture.MOD_ID, "block/parent/photo_paper_c", "")));
        }

        modelBlockRenderer.renderModel(
                poseStack.last(),
                multiBufferSource.getBuffer(RenderType.solid()),
                null, bakedmodel(getPhotoType(photoItem)),
                1.0F, 1.0F, 1.0F,
                packedLight, 0
        );
        poseStack.popPose();
    }

    private static PhotoType getPhotoType (Item item){
        if (BuiltInRegistries.ITEM.wrapAsHolder(item).is(ModItemTags.TYPE_A_PHOTO_PAPERS)) return PhotoType.A;
        if (BuiltInRegistries.ITEM.wrapAsHolder(item).is(ModItemTags.TYPE_B_PHOTO_PAPERS)) return PhotoType.B;
        else return PhotoType.C;
    }

    private static BakedModel bakedmodel(PhotoType photoType) {

        ModelManager modelManager = Minecraft.getInstance().getModelManager();

        ResourceLocation id;

        switch(photoType){
            case A:
                id = new ResourceLocation(
                        XheFurniture.MOD_ID,
                        "block/parent/photo_paper_a"
                );
                break;

            case B:
                id = new ResourceLocation(
                        XheFurniture.MOD_ID,
                        "block/parent/photo_paper_b"
                );
                break;

            default:
                id = new ResourceLocation(
                        XheFurniture.MOD_ID,
                        "block/parent/photo_paper_c"
                );
        }


        return modelManager.getModel(
                new ModelResourceLocation(id, "")
        );
    }
}