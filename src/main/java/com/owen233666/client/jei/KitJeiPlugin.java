/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.client.jei;

import com.owen233666.item.KitItem;
import com.owen233666.platform.Ids;
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

/**
 * JEI integration: adds one "kit" page per {@link KitItem} registered by this mod.
 *
 * <p>Discovery differs per loader, and both paths are wired:
 * <ul>
 *   <li>Fabric reads the {@code jei_mod_plugin} entrypoint from {@code fabric.mod.json}.</li>
 *   <li>Forge and NeoForge scan every mod file for the {@link JeiPlugin} annotation - see
 *       {@code AnnotatedInstanceUtil} / {@code ForgePluginFinder}, both of which walk
 *       {@code ModList.get().getAllScanData()}. No manifest entry is involved.</li>
 * </ul>
 * That is why the annotation is required even though the Fabric side never looks at it, and why
 * no {@code jei_mod_plugin} key belongs in either {@code mods.toml}.
 *
 * <p>JEI is a compile-only dependency, so this class is never touched when JEI is absent.
 */
@JeiPlugin
public class KitJeiPlugin implements IModPlugin {

    private static final ResourceLocation PLUGIN_ID = Ids.of("xhe_furniture", "kit_jei_plugin");

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
        // All items are registered by the time JEI loads its plugins, so iterating the item
        // registry here is safe even on the deferred-registration loaders. BuiltInRegistries.ITEM
        // is deprecated on 1.21.1 but still the only spelling that exists on both 1.20.1 and
        // 1.21.1, and the replacement is not worth a version split for a read-only loop.
        @SuppressWarnings("deprecation")
        Iterable<Item> items = BuiltInRegistries.ITEM;
        for (Item item : items) {
            if (item instanceof KitItem kit) {
                List<ItemStack> outputs = kit.getOutputs().stream().map(ItemStack::new).toList();
                // getOutputs() resolves lazily and may briefly contain AIR; drop empties so JEI
                // never receives a count-0 stack.
                if (!outputs.isEmpty()) {
                    recipes.add(new KitRecipe(new ItemStack(kit), outputs));
                }
            }
        }
        registration.addRecipes(KIT_TYPE, recipes);
    }
}
