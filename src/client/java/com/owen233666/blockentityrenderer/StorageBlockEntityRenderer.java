package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.owen233666.block.StorageBlock;
import com.owen233666.block.entity.StorageBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;

public class StorageBlockEntityRenderer implements BlockEntityRenderer<StorageBlockEntity> {
    private static final HashMap<ResourceLocation, StorageTypeRenderer> STORAGE_TYPES = new HashMap<>();

    public static void registerStorageType(ResourceLocation name, StorageTypeRenderer renderer) {
        STORAGE_TYPES.put(name, renderer);
    }

    public static StorageTypeRenderer getRendererForId(ResourceLocation name) {
        return  STORAGE_TYPES.get(name);
    }

    public StorageBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(StorageBlockEntity entity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        if (entity.hasLevel()) {
            BlockState state = entity.getBlockState();
            Block block = state.getBlock();
            if(block instanceof StorageBlock sb){
                NonNullList<ItemStack> stacks = entity.getInv();
                poseStack.pushPose();
                applyBlockAngle(poseStack, state, 180.0F);
                ResourceLocation type = sb.type();
                StorageTypeRenderer renderer = getRendererForId(type);
                if(renderer != null){
                    renderer.render(entity, poseStack, multiBufferSource, stacks);
                }
                poseStack.popPose();
            }
        }
    }
//    float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay
    public static void applyBlockAngle(PoseStack poseStack, BlockState state, float angleOffSet){
        float angle = state.getValue(StorageBlock.FACING).toYRot();
        poseStack.translate(0.5, 0.0, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(angleOffSet - angle));
    }
}
