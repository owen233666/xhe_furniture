/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.util;

import com.owen233666.XheFurniture;

/**
 * Shared plumbing for the optional Exposure integration.
 * <p>
 * Exposure is a <b>soft</b> dependency: it may be absent, or present in a build whose API does
 * not match what we reflect against. Both cases must degrade silently instead of taking the game
 * down, because a load-time failure in an optional integration is far worse than a missing
 * cosmetic feature.
 *
 * <h2>Why the class loader matters</h2>
 * Forge and NeoForge load mods through a module-aware class loader. A plain
 * {@code Class.forName(name)} resolves against the <i>caller's</i> loader, which on those
 * loaders may not see another mod's module. Passing our own loader explicitly keeps the probe
 * working on every platform we ship.
 */
public final class ExposureReflection {

    private static boolean warned = false;

    private ExposureReflection() {
    }

    /**
     * Loads a class without initialising it. {@code initialize=false} matters: several Exposure
     * classes touch static client state on init, and a probe must not have side effects.
     */
    public static Class<?> loadClass(String name) throws ClassNotFoundException {
        return Class.forName(name, false, ExposureReflection.class.getClassLoader());
    }

    /**
     * Emits a one-shot warning the first time an optional integration cannot be initialised.
     * <p>
     * Kept to a single line per class so a version mismatch is diagnosable without spamming the
     * log every time a renderer asks whether Exposure is available.
     */
    public static void warnUnavailableOnce(String owner, String detail, Throwable cause) {
        if (warned) {
            return;
        }
        warned = true;
        XheFurniture.LOGGER.warn(
                "[{}] Exposure integration unavailable ({}): {}. Photographs will render as plain paintings.",
                owner, detail, cause.getClass().getSimpleName()
                        + (cause.getMessage() != null ? ": " + cause.getMessage() : ""));
    }
}
