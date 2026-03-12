package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.owen233666.XheFurniture;
import com.owen233666.block.entity.PhotoABlockEntity;
import com.owen233666.clientUtil.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class PhotoABlockRenderer implements BlockEntityRenderer<PhotoABlockEntity> {
    private final float[] CUBE_UV_1 = {3.5f,     10.5f,    7.5f,     15f  };
    private final float[] CUBE_UV_2 = {5.5f,     1.5f,     9.7f,     6f   };
    private final float[] CUBE_UV_3 = {10.5f,    5f,       14.5f,    9.5f };

    public PhotoABlockRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(PhotoABlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        ItemStack itemStack = blockEntity.getInv().getFirst();
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
        ResourceLocation textureLocation = compileRenderResourceLocation(resourceLocation, "item/");

        poseStack.pushPose();
        poseStack.translate(0.5D, 0.5D, 0.5D);
        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                1,        1,       0,        0,
                CUBE_UV_1[0], CUBE_UV_1[1], CUBE_UV_1[2], CUBE_UV_1[3],
                i, 255, 255, 255, 255);
        poseStack.popPose();

        poseStack.pushPose();
        poseStack.translate(0.5D, 0.5D, 0.5D);
        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                1,        1,       0,        0,
                CUBE_UV_2[0], CUBE_UV_2[1], CUBE_UV_2[2], CUBE_UV_2[3],
                i, 255, 255, 255, 255);
        poseStack.popPose();

        poseStack.pushPose();
        poseStack.translate(0.5D, 0.5D, 0.5D);
        ClientUtil.renderTexture(textureLocation, poseStack, multiBufferSource,
                1,        1,       0,        0,
                CUBE_UV_3[0], CUBE_UV_3[1], CUBE_UV_3[2], CUBE_UV_3[3],
                i, 255, 255, 255, 255);
        poseStack.popPose();
    }

    private ResourceLocation compileRenderResourceLocation(ResourceLocation resourceLocation) {
        return compileRenderResourceLocation(resourceLocation, "block/");
    }
    private ResourceLocation compileRenderResourceLocation(ResourceLocation resourceLocation, String additional) {
        return new ResourceLocation(resourceLocation.getNamespace(), "texture/" + additional + resourceLocation.getPath());
    }
}
