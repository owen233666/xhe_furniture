/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.platform;

import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * Version-neutral factory for a {@link BlockBehaviour.Properties} copied from another block.
 *
 * <p>1.20.5 renamed the old {@code Properties.copy(Block)} into a pair of explicit factories
 * ({@code ofFullCopy} / {@code ofLegacyCopy}), so the call site is kept in one place.
 */
public final class BlockProps {
	private BlockProps() {
	}

	public static BlockBehaviour.Properties copyOf(BlockBehaviour source) {
		//#if MC >= 12005
		return BlockBehaviour.Properties.ofFullCopy(source);
		//#else
		//$$ return BlockBehaviour.Properties.copy(source);
		//#endif
	}
}