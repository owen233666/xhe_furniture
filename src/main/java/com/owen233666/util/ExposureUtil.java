package com.owen233666.util;

import net.minecraft.world.item.Item;

/**
 * Helpers for integrating with the Exposure mod (camera photographs).
 * <p>
 * Exposure is an <b>optional</b> (soft) dependency: all access is done via reflection so that
 * referencing this class never triggers a {@link NoClassDefFoundError} when Exposure is absent.
 */
public class ExposureUtil {

    private static final String PHOTOGRAPH_ITEM_CLASS = "io.github.mortuusars.exposure.world.item.PhotographItem";

    private static boolean exposureChecked = false;
    private static boolean exposureAvailable = false;
    private static Class<?> photographItemClass;

    private static void ensureExposureLoaded() {
        if (exposureChecked) {
            return;
        }
        exposureChecked = true;
        try {
            photographItemClass = Class.forName(PHOTOGRAPH_ITEM_CLASS);
            exposureAvailable = true;
        } catch (Throwable ignored) {
            exposureAvailable = false;
        }
    }

    /**
     * Whether the given item is an Exposure photograph (a developed/printed photo produced with
     * the Exposure camera). Returns {@code false} when Exposure is not installed.
     */
    public static boolean isExposurePhotograph(Item item) {
        ensureExposureLoaded();
        if (!exposureAvailable || item == null) {
            return false;
        }
        return photographItemClass.isAssignableFrom(item.getClass());
    }
}
