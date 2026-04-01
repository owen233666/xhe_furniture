package com.owen233666.datagen;

import com.owen233666.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        buildModStoneCuttingRecipes(exporter);
    }

    public void buildModStoneCuttingRecipes(Consumer<FinishedRecipe> exporter) {
        Block[] slippers = new Block[]{
                ModBlocks.WHITE_BUNNY_SLIPPERS,
                ModBlocks.WHITE_HAMSTERS_SLIPPERS,
                ModBlocks.WHITE_BEAR_SLIPPERS,
                ModBlocks.BEIGE_BUNNY_SLIPPERS,
                ModBlocks.BEIGE_HAMSTERS_SLIPPERS,
                ModBlocks.BEIGE_BEAR_SLIPPERS,
                ModBlocks.BROWN_BUNNY_SLIPPERS,
                ModBlocks.BROWN_HAMSTERS_SLIPPERS,
                ModBlocks.BROWN_BEAR_SLIPPERS,
                ModBlocks.CALICO_BUNNY_SLIPPERS,
                ModBlocks.CALICO_HAMSTERS_SLIPPERS,
                ModBlocks.PANDA_SLIPPERS
        };
        //羊毛制作
        for (Block block : slippers) {
            SingleItemRecipeBuilder.stonecutting(
                    Ingredient.of(ItemTags.WOOL),
                    RecipeCategory.BUILDING_BLOCKS,
                    block)
                    .unlockedBy("has_wool", has(ItemTags.WOOL))
                    .save(exporter, getStonecuttingRecipeId(block.asItem(), ItemTags.WOOL));
        }
        circleStoneCuttingReceipes(exporter, slippers, RecipeCategory.BUILDING_BLOCKS, "has_wool", has(ItemTags.WOOL));

        Block[] shoeFlowerPots = new Block[]{
                ModBlocks.WHITE_SHOE_FLOWERPOT,
                ModBlocks.PINK_SHOE_FLOWERPOT,
                ModBlocks.RED_SHOE_FLOWERPOT,
                ModBlocks.GREEN_SHOE_FLOWERPOT,
                ModBlocks.YELLOW_SHOE_FLOWERPOT
        };
        for (Block shoeFlowerPot : shoeFlowerPots) {
            SingleItemRecipeBuilder.stonecutting(
                    Ingredient.of(ItemTags.TERRACOTTA),
                    RecipeCategory.BUILDING_BLOCKS,
                    shoeFlowerPot)
                    .unlockedBy("has_terracotta", has(ItemTags.TERRACOTTA))
                    .save(exporter, getStonecuttingRecipeId(shoeFlowerPot.asItem(), ItemTags.TERRACOTTA));
        }
        circleStoneCuttingReceipes(exporter, shoeFlowerPots, RecipeCategory.BUILDING_BLOCKS, "has_terracotta", has(ItemTags.TERRACOTTA));

        Block[] bigCarpets = new Block[]{
                ModBlocks.CARPET_BLACK,
                ModBlocks.CARPET_BLACK_A,
                ModBlocks.CARPET_BLUE,
                ModBlocks.CARPET_BLUE_A,
                ModBlocks.CARPET_BLUE_B,
                ModBlocks.CARPET_BROWN,
                ModBlocks.CARPET_BROWN_A,
                ModBlocks.CARPET_DEEP_BLUE,
                ModBlocks.CARPET_DEEP_BLUE_A,
                ModBlocks.CARPET_DEEP_BLUE_B,
                ModBlocks.CARPET_DEEP_GREEN,
                ModBlocks.CARPET_DEEP_GREEN_A,
                ModBlocks.CARPET_DEEP_PURPLE,
                ModBlocks.CARPET_DEEP_PURPLE_A,
                ModBlocks.CARPET_FLAPJACK,
                ModBlocks.CARPET_FLAPJACK_A,
                ModBlocks.CARPET_GRAY,
                ModBlocks.CARPET_GRAY_A,
                ModBlocks.CARPET_GREEN,
                ModBlocks.CARPET_GREEN_A,
                ModBlocks.CARPET_LEMON_SLICE,
                ModBlocks.CARPET_ORANGE,
                ModBlocks.CARPET_ORANGE_A,
                ModBlocks.CARPET_PINK,
                ModBlocks.CARPET_PINK_A,
                ModBlocks.CARPET_PINK_B,
                ModBlocks.CARPET_PIZZA,
                ModBlocks.CARPET_PURPLE,
                ModBlocks.CARPET_PURPLE_A,
                ModBlocks.CARPET_RED,
                ModBlocks.CARPET_RED_A,
                ModBlocks.CARPET_WAFFLE,
                ModBlocks.CARPET_WAFFLE_A,
                ModBlocks.CARPET_WHITE,
                ModBlocks.CARPET_WHITE_A,
                ModBlocks.CARPET_YELLOW
        };
        circleStoneCuttingReceipes(exporter, bigCarpets, RecipeCategory.BUILDING_BLOCKS, "has_carpet", has(ItemTags.WOOL_CARPETS));
        for (Block carpet : bigCarpets) {
            SingleItemRecipeBuilder.stonecutting(
                    Ingredient.of(ItemTags.WOOL_CARPETS),
                    RecipeCategory.BUILDING_BLOCKS,
                    carpet)
                    .unlockedBy("has_carpet", has(ItemTags.WOOL_CARPETS))
                    .save(exporter, getStonecuttingRecipeId(carpet.asItem(), ItemTags.WOOL_CARPETS));
        }
        SingleItemRecipeBuilder.stonecutting(
                Ingredient.of(ItemTags.PLANKS),
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.EASEL)
                .unlockedBy("has_carpet", has(ItemTags.PLANKS))
                .save(exporter, getStonecuttingRecipeId(ModBlocks.EASEL.asItem(), ItemTags.PLANKS));

        Block[] photos = new Block[]{
                ModBlocks.PHOTO_PAPER_WHITE_A,
                ModBlocks.PHOTO_PAPER_WHITE_B,
                ModBlocks.PHOTO_PAPER_WHITE_C,
                ModBlocks.PHOTO_PAPER_BLACK_A,
                ModBlocks.PHOTO_PAPER_BLACK_B,
                ModBlocks.PHOTO_PAPER_BLACK_C
        };
        circleStoneCuttingReceipes(exporter, photos, RecipeCategory.BUILDING_BLOCKS, "has_paper", has(Items.PAPER));
        for (Block photo : photos) {
            SingleItemRecipeBuilder.stonecutting(
                    Ingredient.of(Items.PAPER),
                    RecipeCategory.BUILDING_BLOCKS,
                    photo)
                    .unlockedBy("has_paper", has(photo))
                    .save(exporter, getStonecuttingRecipeId(photo.asItem(), Items.PAPER));
        }

        Block[] cans = new Block[]{
                ModBlocks.PAINT_CAN,
                ModBlocks.MESSY_PAINT_CAN
        };
        circleStoneCuttingReceipes(exporter, cans, RecipeCategory.BUILDING_BLOCKS, "has_iron_ingots", has(Items.IRON_INGOT));
        for (Block can : cans) {
            SingleItemRecipeBuilder.stonecutting(
                    Ingredient.of(Items.IRON_INGOT),
                    RecipeCategory.BUILDING_BLOCKS,
                    can)
                    .unlockedBy("has_iron_ingot", has(can))
                    .save(exporter, getStonecuttingRecipeId(can.asItem(), Items.IRON_INGOT));
        }

        SingleItemRecipeBuilder.stonecutting(
                Ingredient.of(ItemTags.PLANKS),
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.PAINT_BRUSH)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(exporter, getStonecuttingRecipeId(ModBlocks.PAINT_BRUSH.asItem(), ItemTags.PLANKS));

        Block[] paintingFrames = new Block[]{
                ModBlocks.PAINTING_FRAME_OAK,
                ModBlocks.PAINTING_FRAME_SPRUCE,
                ModBlocks.PAINTING_FRAME_JUNGLE,
                ModBlocks.PAINTING_FRAME_BIRCH,
                ModBlocks.PAINTING_FRAME_ACACIA,
                ModBlocks.PAINTING_FRAME_DARK_OAK,
                ModBlocks.PAINTING_FRAME_MANGROVE,
                ModBlocks.PAINTING_FRAME_CHERRY,
                ModBlocks.PAINTING_FRAME_BAMBOO,
                ModBlocks.PAINTING_FRAME_PALE_OAK,
                ModBlocks.PAINTING_FRAME_BLACKSTONE
        };
        Block[] paintingFramesWithoutBlackstone = new Block[]{
                ModBlocks.PAINTING_FRAME_OAK,
                ModBlocks.PAINTING_FRAME_SPRUCE,
                ModBlocks.PAINTING_FRAME_JUNGLE,
                ModBlocks.PAINTING_FRAME_BIRCH,
                ModBlocks.PAINTING_FRAME_ACACIA,
                ModBlocks.PAINTING_FRAME_DARK_OAK,
                ModBlocks.PAINTING_FRAME_MANGROVE,
                ModBlocks.PAINTING_FRAME_CHERRY,
                ModBlocks.PAINTING_FRAME_BAMBOO,
                ModBlocks.PAINTING_FRAME_PALE_OAK
        };
        circleStoneCuttingReceipes(exporter, paintingFrames, RecipeCategory.BUILDING_BLOCKS, "has_planks", has(ItemTags.PLANKS));
        SingleItemRecipeBuilder.stonecutting(
                Ingredient.of(Items.BLACKSTONE),
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.PAINTING_FRAME_BLACKSTONE)
                .unlockedBy("has_blackstone", has(Items.BLACKSTONE))
                .save(exporter, getStonecuttingRecipeId(ModBlocks.PAINTING_FRAME_BLACKSTONE, Items.BLACKSTONE) + "ingredients");
        for (Block paintingFrame : paintingFramesWithoutBlackstone) {
            SingleItemRecipeBuilder.stonecutting(
                    Ingredient.of(ItemTags.PLANKS),
                    RecipeCategory.BUILDING_BLOCKS,
                    paintingFrame)
                    .unlockedBy("has_planks", has(paintingFrame))
                    .save(exporter, getStonecuttingRecipeId(paintingFrame, ItemTags.PLANKS) + "ingredients");
            SingleItemRecipeBuilder.stonecutting(
                            Ingredient.of(paintingFrame),
                            RecipeCategory.BUILDING_BLOCKS,
                            ModBlocks.PAINTING_FRAME_BLACKSTONE)
                    .unlockedBy("has_planks", has(paintingFrame))
                    .save(exporter, getStonecuttingRecipeId(ModBlocks.PAINTING_FRAME_BLACKSTONE, paintingFrame) + "ingredients");
        }

        Block[] gridShelves = new Block[]{
                ModBlocks.GRID_SHELF_OAK,
                ModBlocks.GRID_SHELF_SPRUCE,
                ModBlocks.GRID_SHELF_JUNGLE,
                ModBlocks.GRID_SHELF_BIRCH,
                ModBlocks.GRID_SHELF_ACACIA,
                ModBlocks.GRID_SHELF_DARK_OAK,
                ModBlocks.GRID_SHELF_MANGROVE,
                ModBlocks.GRID_SHELF_CHERRY,
                ModBlocks.GRID_SHELF_BAMBOO,
                ModBlocks.GRID_SHELF_PALE_OAK,
                ModBlocks.GRID_SHELF_BLACKSTONE
        };
        Block[] gridShelvesWithoutBlackstone = new Block[]{
                ModBlocks.GRID_SHELF_OAK,
                ModBlocks.GRID_SHELF_SPRUCE,
                ModBlocks.GRID_SHELF_JUNGLE,
                ModBlocks.GRID_SHELF_BIRCH,
                ModBlocks.GRID_SHELF_ACACIA,
                ModBlocks.GRID_SHELF_DARK_OAK,
                ModBlocks.GRID_SHELF_MANGROVE,
                ModBlocks.GRID_SHELF_CHERRY,
                ModBlocks.GRID_SHELF_BAMBOO,
                ModBlocks.GRID_SHELF_PALE_OAK
        };
        circleStoneCuttingReceipes(exporter, gridShelves, RecipeCategory.BUILDING_BLOCKS, "has_planks", has(ItemTags.PLANKS));
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(Items.BLACKSTONE),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.GRID_SHELF_BLACKSTONE)
                .unlockedBy("has_blackstone", has(Items.BLACKSTONE))
                .save(exporter);
        for (Block paintingFrame : gridShelvesWithoutBlackstone) {
            SingleItemRecipeBuilder.stonecutting(
                            Ingredient.of(ItemTags.PLANKS),
                            RecipeCategory.BUILDING_BLOCKS,
                            paintingFrame)
                    .unlockedBy("has_planks", has(paintingFrame))
                    .save(exporter, getStonecuttingRecipeId(paintingFrame, ItemTags.PLANKS) + "ingredients");
            SingleItemRecipeBuilder.stonecutting(
                            Ingredient.of(paintingFrame),
                            RecipeCategory.BUILDING_BLOCKS,
                            ModBlocks.GRID_SHELF_BLACKSTONE)
                    .unlockedBy("has_planks", has(paintingFrame))
                    .save(exporter, getStonecuttingRecipeId(ModBlocks.GRID_SHELF_BLACKSTONE, paintingFrame) + "ingredients");
        }
    }

    private void circleStoneCuttingReceipes(Consumer<FinishedRecipe> exporter, Block[] blocks, RecipeCategory recipeCategory, String unlockString, CriterionTriggerInstance criterionTriggerInstance) {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[i] == blocks[j]) continue;

                SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(blocks[i]),
                        recipeCategory,
                        blocks[j])
                        .unlockedBy(unlockString, criterionTriggerInstance)
                        .save(exporter, getStonecuttingRecipeId(blocks[i], blocks[j]));
            }
        }
    }

    private ResourceLocation getStonecuttingRecipeId(Item result, Item ingredient) {
        return new ResourceLocation(
                output.getModId(),
                getName(result) + "_from_" + getName(ingredient) + "_stonecutting"
        );
    }

    private ResourceLocation getStonecuttingRecipeId(Block result, Item ingredient) {
        return new ResourceLocation(
                output.getModId(),
                getName(result) + "_from_" + getName(ingredient) + "_stonecutting"
        );
    }

    private ResourceLocation getStonecuttingRecipeId(Item result, Block ingredient) {
        return new ResourceLocation(
                output.getModId(),
                getName(result) + "_from_" + getName(ingredient) + "_stonecutting"
        );
    }

    private ResourceLocation getStonecuttingRecipeId(Block result, Block ingredient) {
        return new ResourceLocation(
                output.getModId(),
                getName(result) + "_from_" + getName(ingredient) + "_stonecutting"
        );
    }

    private ResourceLocation getStonecuttingRecipeId(Item result, TagKey<Item> tag) {
        return new ResourceLocation(
                output.getModId(),
                getName(result) + "_from_" + tag.location().getPath() + "_stonecutting"
        );
    }

    private ResourceLocation getStonecuttingRecipeId(Block result, TagKey<Item> tag) {
        return new ResourceLocation(
                output.getModId(),
                getName(result) + "_from_" + tag.location().getPath() + "_stonecutting"
        );
    }

    private String getName(Block block) {
        return getName(block.asItem());
    }

    private String getName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }
}
