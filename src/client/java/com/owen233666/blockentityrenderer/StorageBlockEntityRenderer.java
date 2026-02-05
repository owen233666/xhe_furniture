package com.owen233666.blockentityrenderer;

import com.owen233666.block.StorageBlock;
import com.owen233666.block.entity.StorageBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.RotationAxis;

import java.util.HashMap;

public class StorageBlockEntityRenderer implements BlockEntityRenderer<StorageBlockEntity> {
    private static final HashMap<Identifier, StorageTypeRenderer> STORAGE_TYPES = new HashMap<>();

    public static void registerStorageType(Identifier name, StorageTypeRenderer renderer) {
        STORAGE_TYPES.put(name, renderer);
    }

    public static StorageTypeRenderer getRendererForId(Identifier name) {
        return  STORAGE_TYPES.get(name);
    }

    public StorageBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(StorageBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (entity.hasWorld()) {
            BlockState state = entity.getCachedState();
            Block block = state.getBlock();
            if(block instanceof StorageBlock sb){
                DefaultedList<ItemStack> stacks = entity.getInv();
                matrices.push();
                applyBlockAngle(matrices, state, 180.0F);
                Identifier type = sb.type();
                StorageTypeRenderer renderer = getRendererForId(type);
                if(renderer != null){
                    renderer.render(entity, matrices, vertexConsumers, stacks);
                }
                matrices.pop();
            }
        }
    }

    public static void applyBlockAngle(MatrixStack matrcies, BlockState state, float angleOffSet){
        float angle = state.get(StorageBlock.FACING).asRotation();
        matrcies.translate(0.5, 0.0, 0.5);
        matrcies.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(angleOffSet - angle));
    }
}
