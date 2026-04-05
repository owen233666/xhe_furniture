package com.owen233666.blockentityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.owen233666.block.entity.BookLikeBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class OpenBookBlockEntityRenderer implements BlockEntityRenderer<BookLikeBlockEntity> {
    private static final float[] UV_1  = new float[]{0.68750f, 0.78125f, 0.50000f, 0.75000f};
    private static final float[] UV_2  = new float[]{0.78125f, 0.43750f, 0.59375f, 0.34375f};
    private static final float[] UV_3  = new float[]{0.56250f, 0.53125f, 0.37500f, 0.50000f};
    private static final float[] UV_4  = new float[]{0.90625f, 0.68750f, 0.71875f, 0.65625f};

    private static final float[] UV_5  = new float[]{0.37500f, 0.31250f, 0.18750f, 0.21875f};
    private static final float[] UV_6  = new float[]{0.59375f, 0.25000f, 0.40625f, 0.21875f};
    private static final float[] UV_7  = new float[]{0.96875f, 0.40625f, 0.78125f, 0.35700f};
    private static final float[] UV_8  = new float[]{0.75000f, 0.56250f, 0.56250f, 0.53125f};


    private static final float[] UV_9  = new float[]{0.40625f, 0.87500f, 0.21875f, 0.84375f};
    private static final float[] UV_10 = new float[]{0.53125f, 0.96875f, 0.34375f, 0.93750f};
    private static final float[] UV_11 = new float[]{0.96875f, 0.84375f, 0.78125f, 0.81250f};
    private static final float[] UV_12 = new float[]{0.18750f, 0.84375f, 0.78125f, 0.81250f};
    private static final float[] UV_13 = new float[]{0.18750f, 0.71875f, 0.00000f, 0.68750f};

    private static final float[] UV_14 = new float[]{0.65625f, 0.06250f, 0.46875f, 0.03125f};
    private static final float[] UV_15 = new float[]{1.00000f, 0.96875f, 0.78125f, 1.00000f};
    private static final float[] UV_16 = new float[]{0.21875f, 0.96875f, 0.00000f, 1.00000f};
    private static final float[] UV_17 = new float[]{0.59375f, 0.28125f, 0.37500f, 0.12500f};
    private static final float[] UV_18 = new float[]{0.87500f, 0.68750f, 0.81250f, 0.65625f};


    private static final float[] UV_19 = new float[]{};
    private static final float[] UV_20 = new float[]{};
    private static final float[] UV_21 = new float[]{};

    private static final float[] UV_22 = new float[]{};
    private static final float[] UV_23 = new float[]{};
    private static final float[] UV_24 = new float[]{};
    private static final float[] UV_25 = new float[]{};
    private static final float[] UV_26 = new float[]{};
    private static final float[] UV_27 = new float[]{};

    private static final float[] UV_28 = new float[]{};
    public OpenBookBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(BookLikeBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {

    }
}
