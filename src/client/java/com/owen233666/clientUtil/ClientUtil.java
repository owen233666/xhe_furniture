package com.owen233666.clientUtil;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

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
}
