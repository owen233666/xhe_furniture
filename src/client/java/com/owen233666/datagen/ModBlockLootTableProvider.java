package com.owen233666.datagen;

import com.owen233666.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public class ModBlockLootTableProvider implements LootTableSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {}

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer) {
        generateLootTables(consumer);
    }

    public void generateLootTables(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer) {
        dropSelf(consumer, ModBlocks.HOT_COCOA);
        //Shoe Flowerpots
        dropSelf(consumer, ModBlocks.WHITE_SHOE_FLOWERPOT);
        dropSelf(consumer, ModBlocks.PINK_SHOE_FLOWERPOT);
        dropSelf(consumer, ModBlocks.RED_SHOE_FLOWERPOT);
        dropSelf(consumer, ModBlocks.GREEN_SHOE_FLOWERPOT);
        dropSelf(consumer, ModBlocks.YELLOW_SHOE_FLOWERPOT);
        //Slippers
        dropSelf(consumer, ModBlocks.WHITE_BUNNY_SLIPPERS);
        dropSelf(consumer, ModBlocks.WHITE_HAMSTERS_SLIPPERS);
        dropSelf(consumer, ModBlocks.WHITE_BEAR_SLIPPERS);
        dropSelf(consumer, ModBlocks.BEIGE_BUNNY_SLIPPERS);
        dropSelf(consumer, ModBlocks.BEIGE_HAMSTERS_SLIPPERS);
        dropSelf(consumer, ModBlocks.BEIGE_BEAR_SLIPPERS);
        dropSelf(consumer, ModBlocks.BROWN_BUNNY_SLIPPERS);
        dropSelf(consumer, ModBlocks.BROWN_HAMSTERS_SLIPPERS);
        dropSelf(consumer, ModBlocks.BROWN_BEAR_SLIPPERS);
        dropSelf(consumer, ModBlocks.BLACK_BUNNY_SLIPPERS);
        dropSelf(consumer, ModBlocks.BLACK_HAMSTERS_SLIPPERS);
        dropSelf(consumer, ModBlocks.BLACK_BEAR_SLIPPERS);
        dropSelf(consumer, ModBlocks.CALICO_BUNNY_SLIPPERS);
        dropSelf(consumer, ModBlocks.CALICO_HAMSTERS_SLIPPERS);
        dropSelf(consumer, ModBlocks.PANDA_SLIPPERS);
        //Carpets
        dropSelf(consumer, ModBlocks.CARPET_BLACK);
        dropSelf(consumer, ModBlocks.CARPET_BLACK_A);
        dropSelf(consumer, ModBlocks.CARPET_BLUE);
        dropSelf(consumer, ModBlocks.CARPET_BLUE_A);
        dropSelf(consumer, ModBlocks.CARPET_BLUE_B);
        dropSelf(consumer, ModBlocks.CARPET_BROWN);
        dropSelf(consumer, ModBlocks.CARPET_BROWN_A);
        dropSelf(consumer, ModBlocks.CARPET_DEEP_BLUE);
        dropSelf(consumer, ModBlocks.CARPET_DEEP_BLUE_A);
        dropSelf(consumer, ModBlocks.CARPET_DEEP_BLUE_B);
        dropSelf(consumer, ModBlocks.CARPET_DEEP_GREEN);
        dropSelf(consumer, ModBlocks.CARPET_DEEP_GREEN_A);
        dropSelf(consumer, ModBlocks.CARPET_DEEP_PURPLE);
        dropSelf(consumer, ModBlocks.CARPET_DEEP_PURPLE_A);
        dropSelf(consumer, ModBlocks.CARPET_FLAPJACK);
        dropSelf(consumer, ModBlocks.CARPET_FLAPJACK_A);
        dropSelf(consumer, ModBlocks.CARPET_GRAY);
        dropSelf(consumer, ModBlocks.CARPET_GRAY_A);
        dropSelf(consumer, ModBlocks.CARPET_GREEN);
        dropSelf(consumer, ModBlocks.CARPET_GREEN_A);
        dropSelf(consumer, ModBlocks.CARPET_LEMON_SLICE);
        dropSelf(consumer, ModBlocks.CARPET_ORANGE);
        dropSelf(consumer, ModBlocks.CARPET_ORANGE_A);
        dropSelf(consumer, ModBlocks.CARPET_PINK);
        dropSelf(consumer, ModBlocks.CARPET_PINK_A);
        dropSelf(consumer, ModBlocks.CARPET_PINK_B);
        dropSelf(consumer, ModBlocks.CARPET_PIZZA);
        dropSelf(consumer, ModBlocks.CARPET_PURPLE);
        dropSelf(consumer, ModBlocks.CARPET_PURPLE_A);
        dropSelf(consumer, ModBlocks.CARPET_RED);
        dropSelf(consumer, ModBlocks.CARPET_RED_A);
        dropSelf(consumer, ModBlocks.CARPET_WAFFLE);
        dropSelf(consumer, ModBlocks.CARPET_WAFFLE_A);
        dropSelf(consumer, ModBlocks.CARPET_WHITE);
        dropSelf(consumer, ModBlocks.CARPET_WHITE_A);
        dropSelf(consumer, ModBlocks.CARPET_YELLOW);
        //Rattan Table
        dropSelf(consumer, ModBlocks.RATTAN_TABLE);
        //Painting Studio Series
        dropSelf(consumer, ModBlocks.EASEL);
        dropSelf(consumer, ModBlocks.CANVAS);
        dropSelf(consumer, ModBlocks.DRAWING_BOARD);
        dropSelf(consumer, ModBlocks.CANVAS_BIG);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_OAK);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_SPRUCE);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_JUNGLE);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_BIRCH);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_ACACIA);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_DARK_OAK);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_MANGROVE);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_CHERRY);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_BAMBOO);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_PALE_OAK);
        dropSelf(consumer, ModBlocks.PAINTING_FRAME_BLACKSTONE);
        dropSelf(consumer, ModBlocks.PHOTO_PAPER_WHITE_A);
        dropSelf(consumer, ModBlocks.PHOTO_PAPER_WHITE_B);
        dropSelf(consumer, ModBlocks.PHOTO_PAPER_WHITE_C);
        dropSelf(consumer, ModBlocks.PHOTO_PAPER_BLACK_A);
        dropSelf(consumer, ModBlocks.PHOTO_PAPER_BLACK_B);
        dropSelf(consumer, ModBlocks.PHOTO_PAPER_BLACK_C);
        dropSelf(consumer, ModBlocks.GRID_SHELF_OAK);
        dropSelf(consumer, ModBlocks.GRID_SHELF_SPRUCE);
        dropSelf(consumer, ModBlocks.GRID_SHELF_JUNGLE);
        dropSelf(consumer, ModBlocks.GRID_SHELF_BIRCH);
        dropSelf(consumer, ModBlocks.GRID_SHELF_ACACIA);
        dropSelf(consumer, ModBlocks.GRID_SHELF_DARK_OAK);
        dropSelf(consumer, ModBlocks.GRID_SHELF_MANGROVE);
        dropSelf(consumer, ModBlocks.GRID_SHELF_CHERRY);
        dropSelf(consumer, ModBlocks.GRID_SHELF_BAMBOO);
        dropSelf(consumer, ModBlocks.GRID_SHELF_PALE_OAK);
        dropSelf(consumer, ModBlocks.GRID_SHELF_BLACKSTONE);
        dropSelf(consumer, ModBlocks.PAINT_BRUSH);
        dropSelf(consumer, ModBlocks.PAINT_CAN);
        dropSelf(consumer, ModBlocks.MESSY_PAINT_CAN);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_OAK);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_SPRUCE);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_JUNGLE);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_BIRCH);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_ACACIA);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_DARK_OAK);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_MANGROVE);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_CHERRY);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_BAMBOO);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_PALE_OAK);
        dropSelf(consumer, ModBlocks.CORK_BOARD_LIGHT_BLACKSTONE);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_OAK);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_SPRUCE);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_JUNGLE);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_BIRCH);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_ACACIA);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_DARK_OAK);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_MANGROVE);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_CHERRY);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_BAMBOO);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_PALE_OAK);
        dropSelf(consumer, ModBlocks.CORK_BOARD_DARK_BLACKSTONE);
    }

    private static void dropSelf(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer, net.minecraft.world.level.block.Block block) {
        consumer.accept(block.getLootTable(), LootTable.lootTable().withPool(net.minecraft.world.level.storage.loot.LootPool.lootPool()
                .setRolls(net.minecraft.world.level.storage.loot.providers.number.ConstantValue.exactly(1))
                .add(net.minecraft.world.level.storage.loot.entries.LootItem.lootTableItem(block))));
    }
}