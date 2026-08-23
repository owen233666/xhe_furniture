package com.owen233666.client.jei;

import net.minecraft.world.item.ItemStack;

import java.util.List;

public record KitRecipe(ItemStack kit, List<ItemStack> outputs) {
}
