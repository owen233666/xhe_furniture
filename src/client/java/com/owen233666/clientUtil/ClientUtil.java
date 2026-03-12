package com.owen233666.clientUtil;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;

public class ClientUtil {
    public static <T extends BlockEntity> void renderBlock(BlockState state, PoseStack poseStack, MultiBufferSource multiBufferSource, T entity) {
        Level level = entity.getLevel();
        if (level != null) {
            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(state, poseStack, multiBufferSource, getLightLevel(level, entity.getBlockPos()), OverlayTexture.NO_OVERLAY);
        }
    }

    public static <T extends BlockEntity> void renderBlockFromItem(BlockItem blockItem, PoseStack poseStack, MultiBufferSource multiBufferSource, T blockEntity) {
        renderBlock(blockItem.getBlock().defaultBlockState(), poseStack, multiBufferSource, blockEntity);
    }

    public static int getLightLevel(Level level, BlockPos pos) {
        int blockLight = level.getBrightness(LightLayer.BLOCK, pos);
        int skyLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(blockLight, skyLight);
    }

    public static void renderTexture(ResourceLocation resourceLocation, PoseStack poseStack, MultiBufferSource multiBufferSource,
                                     float x1, float y1, float x2, float y2,
                                     float u1, float v1, float u2, float v2,
                                     int packedLight, int r, int g, int b, int a) {
        RenderSystem.setShaderTexture(0, resourceLocation);
        RenderSystem.setShader(GameRenderer::getPositionColorTexLightmapShader);
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();

        Matrix4f matrix4f = poseStack.last().pose();
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.text(resourceLocation));
        vertexConsumer.vertex(matrix4f, x1, y2, 0).color(r, g, b, a).uv(u1, v2).uv2(packedLight).endVertex();
        vertexConsumer.vertex(matrix4f, x2, y2, 0).color(r, g, b, a).uv(u2, v2).uv2(packedLight).endVertex();
        vertexConsumer.vertex(matrix4f, x2, y1, 0).color(r, g, b, a).uv(u2, v1).uv2(packedLight).endVertex();
        vertexConsumer.vertex(matrix4f, x1, y1, 0).color(r, g, b, a).uv(u1, v1).uv2(packedLight).endVertex();
    }
}
