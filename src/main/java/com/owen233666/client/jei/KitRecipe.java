/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.client.jei;

import net.minecraft.world.item.ItemStack;

import java.util.List;

/**
 * One "kit" conversion: the kit item on the left, everything it can turn into on the right.
 *
 * <p>Not a real vanilla recipe. JEI is told about these directly from
 * {@link KitJeiPlugin#registerRecipes}, which is why this is a plain record rather than
 * something registered into a {@code RecipeType} of the game.
 */
public record KitRecipe(ItemStack kit, List<ItemStack> outputs) {
}
