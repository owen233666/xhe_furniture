package com.owen233666.datagen;

import com.owen233666.block.ModBlocks;
import com.owen233666.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        buildKitRecipes(exporter);
        buildSingleItemRecipes(exporter);
    }

    private void buildKitRecipes(Consumer<FinishedRecipe> exporter) {
        shaped(exporter, ModItems.SLIPPER_KIT, has(ItemTags.WOOL),
                new Object[]{'W', ItemTags.WOOL},
                "WWW", " WW");

        shaped(exporter, ModItems.CARPET_KIT, has(ItemTags.WOOL),
                new Object[]{'W', ItemTags.WOOL},
                "WW", "WW");

        shaped(exporter, ModItems.SHOE_FLOWER_POT_KIT, has(Items.FLOWER_POT),
                new Object[]{'W', ItemTags.WOOL, 'P', Items.FLOWER_POT},
                "W W", "P P");

        shaped(exporter, ModItems.PAINTING_FRAME_KIT, has(ItemTags.PLANKS),
                new Object[]{'P', ItemTags.PLANKS},
                "PPP", "P P", "PPP");

        shaped(exporter, ModItems.GRID_SHELF_KIT, has(ItemTags.PLANKS),
                new Object[]{'P', ItemTags.PLANKS, 'S', Items.STICK},
                "PPP", "SSS");

        shaped(exporter, ModItems.FURNITURE_ORDER_TABLE_KIT, has(ItemTags.PLANKS),
                new Object[]{'P', ItemTags.PLANKS, 'S', Items.STICK},
                "PPP", "P P", "SSS");

        shaped(exporter, ModItems.CORK_BOARD_KIT, has(Items.BROWN_WOOL),
                new Object[]{'P', ItemTags.PLANKS, 'C', Items.BROWN_WOOL},
                "PPP", "PCP", "PPP");

        shapeless(exporter, ModItems.PHOTO_PAPER_KIT, has(Items.BLACK_DYE),
                Items.PAPER, Items.PAPER, Items.PAPER, Items.PAPER, Items.BLACK_DYE);

        shaped(exporter, ModItems.PAINTING_KIT, has(Items.WHITE_WOOL),
                new Object[]{'P', Items.PAPER, 'W', Items.WHITE_WOOL},
                "PPP", "PWP", "PPP");
    }

    private void buildSingleItemRecipes(Consumer<FinishedRecipe> exporter) {
        shapeless(exporter, ModBlocks.HOT_COCOA.asItem(), has(Items.COCOA_BEANS),
                Items.GLASS_BOTTLE, Items.COCOA_BEANS, Items.SUGAR, Items.MILK_BUCKET);

        shaped(exporter, ModBlocks.RATTAN_TABLE.asItem(), has(Items.BAMBOO),
                new Object[]{'B', Items.BAMBOO, 'S', Items.STICK},
                "BBB", " B ", " S ");

        shaped(exporter, ModBlocks.EASEL.asItem(), has(Items.STICK),
                new Object[]{'S', Items.STICK},
                "S S", "SSS", "S S");

        shaped(exporter, ModBlocks.CANVAS.asItem(), has(Items.WHITE_WOOL),
                new Object[]{'P', ItemTags.PLANKS, 'W', Items.WHITE_WOOL},
                "PPP", "PWP", "PPP");

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CANVAS_BIG.asItem())
                .define('C', ModBlocks.CANVAS)
                .pattern("CC")
                .pattern("CC")
                .unlockedBy("has_canvas", has(ModBlocks.CANVAS))
                .save(exporter);

        shaped(exporter, ModBlocks.DRAWING_BOARD.asItem(), has(Items.PAPER),
                new Object[]{'P', ItemTags.PLANKS, 'W', Items.PAPER},
                "PPP", "PWP", "PPP");

        shaped(exporter, ModItems.PAINT_BRUSH, has(Items.STICK),
                new Object[]{'W', Items.WHITE_WOOL, 'S', Items.STICK},
                "W", "S");

        shaped(exporter, ModBlocks.PAINT_CAN.asItem(), has(Items.IRON_INGOT),
                new Object[]{'I', Items.IRON_INGOT},
                "II", "II", "II");

        shapeless(exporter, ModBlocks.MESSY_PAINT_CAN.asItem(), has(ModBlocks.PAINT_CAN),
                ModBlocks.PAINT_CAN, Items.BLACK_DYE);

        shapeless(exporter, ModBlocks.PAINT_BRUSH_BUCKET.asItem(), has(Items.BUCKET),
                Items.BUCKET, ModItems.PAINT_BRUSH);

        shapeless(exporter, ModBlocks.OPEN_BOOK.asItem(), has(Items.PAPER),
                Items.PAPER, Items.PAPER, Items.PAPER, Items.LEATHER);

        shaped(exporter, ModBlocks.CRAYON_BOX.asItem(), has(ItemTags.PLANKS),
                new Object[]{'P', ItemTags.PLANKS, 'W', Items.PAPER},
                "PPP", "PWP", "PPP");

        shaped(exporter, ModBlocks.PALETTE.asItem(), has(ItemTags.PLANKS),
                new Object[]{'P', ItemTags.PLANKS, 'W', Items.WHITE_WOOL},
                "PW", "PP");
    }

    private void shaped(Consumer<FinishedRecipe> exporter, ItemLike result, CriterionTriggerInstance unlock,
                        Object[] keyed, String... pattern) {
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result);
        for (String row : pattern) {
            builder.pattern(row);
        }
        for (int i = 0; i < keyed.length; i += 2) {
            char key = (Character) keyed[i];
            Object value = keyed[i + 1];
            if (value instanceof TagKey<?> tag) {
                builder.define(key, (TagKey<Item>) tag);
            } else {
                builder.define(key, (ItemLike) value);
            }
        }
        builder.unlockedBy("has_material", unlock).save(exporter);
    }

    private void shapeless(Consumer<FinishedRecipe> exporter, ItemLike result, CriterionTriggerInstance unlock,
                           ItemLike... ingredients) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result);
        for (ItemLike ingredient : ingredients) {
            builder.requires(ingredient);
        }
        builder.unlockedBy("has_material", unlock).save(exporter);
    }
}
