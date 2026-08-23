package com.owen233666.client.jei;

import com.owen233666.item.KitItem;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class KitJeiPlugin implements IModPlugin {

    private static final ResourceLocation PLUGIN_ID = new ResourceLocation("xhe_furniture", "kit_jei_plugin");

    public static final RecipeType<KitRecipe> KIT_TYPE = RecipeType.create("xhe_furniture", "kit", KitRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new KitRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<KitRecipe> recipes = new ArrayList<>();
        for (Item item : BuiltInRegistries.ITEM) {
            if (item instanceof KitItem kit) {
                List<ItemStack> outputs = kit.getOutputs().stream().map(ItemStack::new).toList();
                recipes.add(new KitRecipe(new ItemStack(kit), outputs));
            }
        }
        registration.addRecipes(KIT_TYPE, recipes);
    }
}
