/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
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
        try {
            photographItemClass = ExposureReflection.loadClass(PHOTOGRAPH_ITEM_CLASS);
            exposureAvailable = true;
        } catch (Throwable t) {
            // Exposure is absent, or its classes are not visible to this mod's class loader. Either
            // way the integration is simply unavailable; never let it take the game down.
            exposureAvailable = false;
            ExposureReflection.warnUnavailableOnce("ExposureUtil", PHOTOGRAPH_ITEM_CLASS, t);
        }
        // Only latch the flag once the probe actually settled, so a half-failed probe is retried
        // instead of permanently disabling the integration.
        exposureChecked = true;
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
