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

public class KitRecipeCategory implements IRecipeCategory<KitRecipe> {

    private static final int SLOT = 18;
    private static final int COLUMNS = 9;
    private static final int ROWS = 5;

    private final IDrawable icon;

    public KitRecipeCategory(IGuiHelper guiHelper) {
        this.icon = guiHelper.createDrawableItemStack(new ItemStack(ModItems.SLIPPER_KIT));
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
        return 1 + SLOT + 4 + COLUMNS * SLOT;
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
            builder.addSlot(RecipeIngredientRole.OUTPUT, 1 + SLOT + 4 + col * SLOT, 1 + row * SLOT)
                    .addItemStack(output);
            col++;
            if (col >= COLUMNS) {
                col = 0;
                row++;
            }
        }
    }
}
