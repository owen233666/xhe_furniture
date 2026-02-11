package com.owen233666.clientUtil;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class ClientUtil {
    public static <T extends BlockEntity> void renderBlock(BlockState state, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, T entity) {
        World world = entity.getWorld();
        if (world != null) {
            MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(state, matrixStack, vertexConsumerProvider, getLightLevel(world, entity.getPos()), OverlayTexture.DEFAULT_UV);
        }
    }

    public static <T extends BlockEntity> void renderBlockFromItem(BlockItem blockItem, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, T blockEntity) {
        renderBlock(blockItem.getBlock().getDefaultState(), matrixStack, vertexConsumerProvider, blockEntity);
    }

    public static int getLightLevel(World world, BlockPos pos) {
        int blockLight = world.getLightLevel(LightType.BLOCK, pos);
        int skyLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(blockLight, skyLight);
    }
}
