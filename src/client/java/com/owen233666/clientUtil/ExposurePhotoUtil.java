package com.owen233666.clientUtil;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;

public class ExposurePhotoUtil {

    private static final String PHOTOGRAPH_ITEM_CLASS = "io.github.mortuusars.exposure.world.item.PhotographItem";
    private static final String EXPOSURE_CLIENT_CLASS = "io.github.mortuusars.exposure.ExposureClient";
    private static final String RENDERED_EXPOSURES_CLASS = "io.github.mortuusars.exposure.client.RenderedExposures";
    private static final String IMAGE_RENDERER_CLASS = "io.github.mortuusars.exposure.client.render.image.ImageRenderer";
    private static final String RENDERABLE_IMAGE_CLASS = "io.github.mortuusars.exposure.client.image.renderable.RenderableImage";

    private static boolean exposureChecked = false;
    private static boolean exposureAvailable = false;

    private static Class<?> photographItemClass;
    private static Class<?> exposureClientClass;
    private static Class<?> renderedExposuresClass;
    private static Class<?> imageRendererClass;
    private static Class<?> renderableImageClass;

    private static Method getFrameMethod;
    private static Method renderedExposuresMethod;
    private static Method getOrCreateMethod;
    private static Method isEmptyMethod;
    private static Method imageRendererMethod;
    private static Method renderMethod;

    private static void ensureExposureLoaded() {
        if (exposureChecked) {
            return;
        }
        exposureChecked = true;
        try {
            photographItemClass = Class.forName(PHOTOGRAPH_ITEM_CLASS);
            exposureClientClass = Class.forName(EXPOSURE_CLIENT_CLASS);
            renderedExposuresClass = Class.forName(RENDERED_EXPOSURES_CLASS);
            imageRendererClass = Class.forName(IMAGE_RENDERER_CLASS);
            renderableImageClass = Class.forName(RENDERABLE_IMAGE_CLASS);

            getFrameMethod = photographItemClass.getMethod("getFrame", ItemStack.class);
            renderedExposuresMethod = exposureClientClass.getMethod("renderedExposures");
            imageRendererMethod = exposureClientClass.getMethod("imageRenderer");
            isEmptyMethod = renderableImageClass.getMethod("isEmpty");
            renderMethod = imageRendererClass.getMethod("render",
                    renderableImageClass, PoseStack.class, MultiBufferSource.class,
                    float.class, float.class, float.class, float.class,
                    float.class, float.class, float.class, float.class,
                    int.class, int.class, int.class, int.class, int.class);

            exposureAvailable = true;
        } catch (Throwable ignored) {
            exposureAvailable = false;
        }
    }

    @Nullable
    public static Object getRenderableImage(ItemStack stack) {
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        ensureExposureLoaded();
        if (!exposureAvailable) {
            return null;
        }
        try {
            if (!photographItemClass.isAssignableFrom(stack.getItem().getClass())) {
                return null;
            }
            Object frame = getFrameMethod.invoke(stack.getItem(), (Object) stack);
            if (frame == null) {
                return null;
            }
            Method getOrCreate = getOrCreateMethod;
            if (getOrCreate == null) {
                getOrCreate = renderedExposuresClass.getMethod("getOrCreate", frame.getClass());
                getOrCreateMethod = getOrCreate;
            }
            Object renderedExposures = renderedExposuresMethod.invoke(null);
            Object image = getOrCreate.invoke(renderedExposures, frame);
            if (image == null || Boolean.TRUE.equals(isEmptyMethod.invoke(image))) {
                return null;
            }
            return image;
        } catch (Throwable t) {
            return null;
        }
    }

    public static void renderPhotoOrPainting(@Nullable Object exposureImage,
                                             ResourceLocation paintingTexture,
                                             PoseStack poseStack,
                                             MultiBufferSource multiBufferSource,
                                             float x1, float y1, float x2, float y2,
                                             float paintingU1, float paintingV1,
                                             float paintingU2, float paintingV2,
                                             int packedLight) {
        if (exposureImage != null) {
            renderExposureImage(exposureImage, poseStack, multiBufferSource,
                    x1, y1, x2, y2,
                    paintingU1, paintingV2, paintingU2, paintingV1, // V flipped to correct orientation
                    packedLight);
        } else {
            ClientUtil.renderTexture(
                    paintingTexture, poseStack, multiBufferSource,
                    x1, y1, x2, y2,
                    paintingU1, paintingV1, paintingU2, paintingV2,
                    packedLight, 255, 255, 255, 255);
        }
    }

    private static void renderExposureImage(Object image, PoseStack poseStack, MultiBufferSource multiBufferSource,
                                            float x1, float y1, float x2, float y2,
                                            float u1, float v1, float u2, float v2,
                                            int packedLight) {
        if (!exposureAvailable) {
            return;
        }
        try {
            Object imageRenderer = imageRendererMethod.invoke(null);
            renderMethod.invoke(imageRenderer, image, poseStack, multiBufferSource,
                    x1, y1, x2, y2, u1, v1, u2, v2,
                    packedLight, 255, 255, 255, 255);
        } catch (Throwable t) {
        }
    }
}
