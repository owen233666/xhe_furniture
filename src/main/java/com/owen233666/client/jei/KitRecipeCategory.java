/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.client.jei;

import com.owen233666.item.ModItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/**
 * JEI category that renders a {@link KitRecipe} as "one kit in, a grid of results out".
 *
 * <p>The layout is deliberately hard-coded rather than data-driven: the left column holds the kit
 * itself, and the right-hand 9-column grid is the same shape as the {@code KitMenu} the item
 * opens, so the JEI page and the in-game screen agree on where things are.
 */
public class KitRecipeCategory implements IRecipeCategory<KitRecipe> {

    private static final int SLOT = 18;
    private static final int COLUMNS = 9;
    private static final int ROWS = 5;
    private static final int GAP = 4;

    private final IDrawable icon;

    public KitRecipeCategory(IGuiHelper guiHelper) {
        this.icon = guiHelper.createDrawableItemStack(new ItemStack(ModItems.SLIPPER_KIT.get()));
    }

    @Override
    public RecipeType<KitRecipe> getRecipeType() {
        return KitJeiPlugin.KIT_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.xhe_furniture.kit");
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public int getWidth() {
        return 1 + SLOT + GAP + COLUMNS * SLOT;
    }

    @Override
    public int getHeight() {
        return ROWS * SLOT;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, KitRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, getHeight() / 2 - SLOT / 2)
                .addItemStack(recipe.kit());

        int col = 0;
        int row = 0;
        for (ItemStack output : recipe.outputs()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 1 + SLOT + GAP + col * SLOT, 1 + row * SLOT)
                    .addItemStack(output);
            col++;
            if (col >= COLUMNS) {
                col = 0;
                row++;
            }
        }
    }
}
