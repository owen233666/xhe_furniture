package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.owen233666.block.entity.PhotoABlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;

public class PhotoABlockRenderer implements BlockEntityRenderer<PhotoABlockEntity> {
    private final float[] CUBE_UV_1 = {3.5f,  10.5f, 7.5f,  15f};
    private final float[] CUBE_UV_2 = {5.5f,  1.5f,  9.7f,  6f};
    private final float[] CUBE_UV_3 = {10.5f, 5f,    14.5f, 9.5f};
    @Override
    public void render(PhotoABlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        float w = 0.5f;
        float h = 0.3f;
        float d = 0.4f;

        ItemStack itemStack = blockEntity.getInv().getFirst();
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(itemStack.getItem());

        ResourceLocation textureLocation = new ResourceLocation(
                itemId.getNamespace(),
                "block/" + itemId.getPath()
        );
        // 获取贴图
        TextureAtlasSprite sprite = Minecraft.getInstance()
                .getTextureAtlas(InventoryMenu.BLOCK_ATLAS)
                .apply(textureLocation);

        // 计算UV裁切（可以根据尺寸动态计算）
         float minU = sprite.getU(CUBE_UV_1[0]);
         float minV = sprite.getV(CUBE_UV_1[1]);
         float maxU = sprite.getU(CUBE_UV_1[2]);
         float maxV = sprite.getV(CUBE_UV_1[3]);

        VertexConsumer vertexConsumer    = multiBufferSource.getBuffer(RenderType.cutout());

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);

        renderFace(poseStack, vertexConsumer, Direction.NORTH, // 南面 (+Z)
                -w, -h, -d,  w,  h, -d,
                minU, minV, maxU, maxV, i);

        renderFace(poseStack, vertexConsumer, Direction.SOUTH, // 西面 (-X)
                -w, -h, d, w,  h, d,
                minU, minV, maxU, maxV, i);

        renderFace(poseStack, vertexConsumer, Direction.WEST,
                -w, -h, -d, -w,  h,  d,
                minU, minV, maxU, maxV, i);

        renderFace(poseStack, vertexConsumer, Direction.EAST, // 东面 (+X)
                w, -h, -d, w,  h,  d,
                minU, minV, maxU, maxV, i);

        renderFace(poseStack, vertexConsumer, Direction.UP, // 上面 (+Y)
                -w, h, -d, w, h,  d,
                minU, minV, maxU, maxV, i);

        renderFace(poseStack, vertexConsumer, Direction.DOWN, // 下面 (-Y)
                -w, -h, -d, w, -h,  d,
                minU, minV, maxU, maxV, i);

        poseStack.popPose();
    }

    private void renderFace(PoseStack poseStack, VertexConsumer vertexConsumer, Direction direction,
                            float x1, float y1, float z1, float x2, float y2, float z2,
                            float u1, float v1, float u2, float v2,
                            int packedLight) {

        var pose = poseStack.last().pose();
        var normal = poseStack.last().normal();

        // 根据面的方向设置法线
        float nx = direction.getStepX();
        float ny = direction.getStepY();
        float nz = direction.getStepZ();

        switch (direction) {
            case DOWN: // Y负
                vertexConsumer.vertex(pose, x1, y1, z1).color(255, 255, 255, 255).uv(u1, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x1, y1, z2).color(255, 255, 255, 255).uv(u1, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y1, z2).color(255, 255, 255, 255).uv(u2, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y1, z1).color(255, 255, 255, 255).uv(u2, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                break;

            case UP: // Y正
                vertexConsumer.vertex(pose, x1, y2, z1).color(255, 255, 255, 255).uv(u1, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y2, z1).color(255, 255, 255, 255).uv(u2, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y2, z2).color(255, 255, 255, 255).uv(u2, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x1, y2, z2).color(255, 255, 255, 255).uv(u1, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                break;

            case NORTH: // Z负
                vertexConsumer.vertex(pose, x1, y1, z1).color(255, 255, 255, 255).uv(u1, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y1, z1).color(255, 255, 255, 255).uv(u2, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y2, z1).color(255, 255, 255, 255).uv(u2, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x1, y2, z1).color(255, 255, 255, 255).uv(u1, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                break;

            case SOUTH: // Z正
                vertexConsumer.vertex(pose, x1, y1, z2).color(255, 255, 255, 255).uv(u1, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x1, y2, z2).color(255, 255, 255, 255).uv(u1, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y2, z2).color(255, 255, 255, 255).uv(u2, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y1, z2).color(255, 255, 255, 255).uv(u2, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                break;

            case WEST: // X负
                vertexConsumer.vertex(pose, x1, y1, z1).color(255, 255, 255, 255).uv(u1, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x1, y2, z1).color(255, 255, 255, 255).uv(u1, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x1, y2, z2).color(255, 255, 255, 255).uv(u2, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x1, y1, z2).color(255, 255, 255, 255).uv(u2, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                break;

            case EAST: // X正
                vertexConsumer.vertex(pose, x2, y1, z1).color(255, 255, 255, 255).uv(u1, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y1, z2).color(255, 255, 255, 255).uv(u2, v1).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y2, z2).color(255, 255, 255, 255).uv(u2, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                vertexConsumer.vertex(pose, x2, y2, z1).color(255, 255, 255, 255).uv(u1, v2).uv2(packedLight).normal(normal, nx, ny, nz).endVertex();
                break;
        }
    }
}
