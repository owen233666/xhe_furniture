/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.platform;

import com.owen233666.XheFurniture;
import net.minecraft.resources.ResourceLocation;

/**
 * Version-neutral factory for {@link ResourceLocation}.
 *
 * <p>The {@code ResourceLocation(String, String)} constructor is public on 1.20.1 but private from
 * 1.21 on, where the static factories below are the only way in. Keeping the difference here
 * leaves the rest of the source tree free of version directives.
 */
public final class Ids {
	private Ids() {
	}

	public static ResourceLocation of(String namespace, String path) {
		//#if MC >= 12100
		return ResourceLocation.fromNamespaceAndPath(namespace, path);
		//#else
		//$$ return new ResourceLocation(namespace, path);
		//#endif
	}

	public static ResourceLocation parse(String value) {
		//#if MC >= 12100
		return ResourceLocation.parse(value);
		//#else
		//$$ return new ResourceLocation(value);
		//#endif
	}

	public static ResourceLocation mod(String path) {
		return of(XheFurniture.MOD_ID, path);
	}
}
