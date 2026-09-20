/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.creativetab;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import com.owen233666.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import com.owen233666.platform.Ids;
import com.owen233666.platform.Registrar;

public class ModCreativeTab {
    public static final CreativeModeTab FURNITURE_GROUP = Registrar.legacyCreativeTab(Ids.of(XheFurniture.MOD_ID, "xhe_furniture.creativetab.items"),
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).title(Component.translatable("xhe_furniture.creativetab.items"))
                    .icon(() -> new ItemStack(BuiltInRegistries.BLOCK.get(Ids.of(XheFurniture.MOD_ID, "hot_cocoa"))))
                    .displayItems(((displayContext, entries) -> {
                        //Kits
                        entries.accept(ModItems.SLIPPER_KIT.get());
                        entries.accept(ModItems.CARPET_KIT.get());
                        entries.accept(ModItems.SHOE_FLOWER_POT_KIT.get());
                        entries.accept(ModItems.PAINTING_FRAME_KIT.get());
                        entries.accept(ModItems.GRID_SHELF_KIT.get());
                        entries.accept(ModItems.FURNITURE_CRAFTING_TABLE_KIT.get());
                        entries.accept(ModItems.CORK_BOARD_KIT.get());
                        entries.accept(ModItems.PHOTO_PAPER_KIT.get());
                        //Furniture Crafting Tables
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_OAK.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_SPRUCE.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_JUNGLE.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_BIRCH.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_ACACIA.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_DARK_OAK.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_MANGROVE.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_CHERRY.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_BAMBOO.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_PALE_OAK.get());
                        entries.accept(ModBlocks.FURNITURE_CRAFTING_TABLE_BLACKSTONE.get());
                        //Cups
                        entries.accept(ModBlocks.HOT_COCOA.get());
                        //Shoe Flowerpots
                        entries.accept(ModBlocks.WHITE_SHOE_FLOWERPOT.get());
                        entries.accept(ModBlocks.PINK_SHOE_FLOWERPOT.get());
                        entries.accept(ModBlocks.RED_SHOE_FLOWERPOT.get());
                        entries.accept(ModBlocks.GREEN_SHOE_FLOWERPOT.get());
                        entries.accept(ModBlocks.YELLOW_SHOE_FLOWERPOT.get());
                        //Slippers
                        entries.accept(ModBlocks.WHITE_BUNNY_SLIPPERS.get());
                        entries.accept(ModBlocks.WHITE_HAMSTERS_SLIPPERS.get());
                        entries.accept(ModBlocks.WHITE_BEAR_SLIPPERS.get());
                        entries.accept(ModBlocks.BEIGE_BUNNY_SLIPPERS.get());
                        entries.accept(ModBlocks.BEIGE_HAMSTERS_SLIPPERS.get());
                        entries.accept(ModBlocks.BEIGE_BEAR_SLIPPERS.get());
                        entries.accept(ModBlocks.BROWN_BUNNY_SLIPPERS.get());
                        entries.accept(ModBlocks.BROWN_HAMSTERS_SLIPPERS.get());
                        entries.accept(ModBlocks.BROWN_BEAR_SLIPPERS.get());
                        entries.accept(ModBlocks.BLACK_BUNNY_SLIPPERS.get());
                        entries.accept(ModBlocks.BLACK_HAMSTERS_SLIPPERS.get());
                        entries.accept(ModBlocks.BLACK_BEAR_SLIPPERS.get());
                        entries.accept(ModBlocks.CALICO_BUNNY_SLIPPERS.get());
                        entries.accept(ModBlocks.CALICO_HAMSTERS_SLIPPERS.get());
                        entries.accept(ModBlocks.PANDA_SLIPPERS.get());
                        //Carpets
                        entries.accept(ModBlocks.CARPET_BLACK.get());
                        entries.accept(ModBlocks.CARPET_BLACK_A.get());
                        entries.accept(ModBlocks.CARPET_BLUE.get());
                        entries.accept(ModBlocks.CARPET_BLUE_A.get());
                        entries.accept(ModBlocks.CARPET_BLUE_B.get());
                        entries.accept(ModBlocks.CARPET_BROWN.get());
                        entries.accept(ModBlocks.CARPET_BROWN_A.get());
                        entries.accept(ModBlocks.CARPET_DEEP_BLUE.get());
                        entries.accept(ModBlocks.CARPET_DEEP_BLUE_A.get());
                        entries.accept(ModBlocks.CARPET_DEEP_BLUE_B.get());
                        entries.accept(ModBlocks.CARPET_DEEP_GREEN.get());
                        entries.accept(ModBlocks.CARPET_DEEP_GREEN_A.get());
                        entries.accept(ModBlocks.CARPET_DEEP_PURPLE.get());
                        entries.accept(ModBlocks.CARPET_DEEP_PURPLE_A.get());
                        entries.accept(ModBlocks.CARPET_FLAPJACK.get());
                        entries.accept(ModBlocks.CARPET_FLAPJACK_A.get());
                        entries.accept(ModBlocks.CARPET_GRAY.get());
                        entries.accept(ModBlocks.CARPET_GRAY_A.get());
                        entries.accept(ModBlocks.CARPET_GREEN.get());
                        entries.accept(ModBlocks.CARPET_GREEN_A.get());
                        entries.accept(ModBlocks.CARPET_LEMON_SLICE.get());
                        entries.accept(ModBlocks.CARPET_ORANGE.get());
                        entries.accept(ModBlocks.CARPET_ORANGE_A.get());
                        entries.accept(ModBlocks.CARPET_PINK.get());
                        entries.accept(ModBlocks.CARPET_PINK_A.get());
                        entries.accept(ModBlocks.CARPET_PINK_B.get());
                        entries.accept(ModBlocks.CARPET_PIZZA.get());
                        entries.accept(ModBlocks.CARPET_PURPLE.get());
                        entries.accept(ModBlocks.CARPET_PURPLE_A.get());
                        entries.accept(ModBlocks.CARPET_RED.get());
                        entries.accept(ModBlocks.CARPET_RED_A.get());
                        entries.accept(ModBlocks.CARPET_WAFFLE.get());
                        entries.accept(ModBlocks.CARPET_WAFFLE_A.get());
                        entries.accept(ModBlocks.CARPET_WHITE.get());
                        entries.accept(ModBlocks.CARPET_WHITE_A.get());
                        entries.accept(ModBlocks.CARPET_YELLOW.get());
                        //Rattan Table
                        entries.accept(ModBlocks.RATTAN_TABLE.get());

                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_OAK.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_SPRUCE.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_JUNGLE.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_BIRCH.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_ACACIA.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_DARK_OAK.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_MANGROVE.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_CHERRY.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_BAMBOO.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_PALE_OAK.get());
                        entries.accept(ModBlocks.CORK_BOARD_LIGHT_BLACKSTONE.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_OAK.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_SPRUCE.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_JUNGLE.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_BIRCH.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_ACACIA.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_DARK_OAK.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_MANGROVE.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_CHERRY.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_BAMBOO.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_PALE_OAK.get());
                        entries.accept(ModBlocks.CORK_BOARD_DARK_BLACKSTONE.get());

                    })).build()
    );

    public static final CreativeModeTab PAINTINGS = Registrar.legacyCreativeTab(Ids.of(XheFurniture.MOD_ID, "xhe_furniture.creativetab.paintings"),
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).title(Component.translatable("xhe_furniture.creativetab.paintings")).icon(() -> new ItemStack(BuiltInRegistries.BLOCK.get(Ids.of(XheFurniture.MOD_ID, "hot_cocoa"))))
                    .displayItems(((displayContext, entries) -> {
                        entries.accept(ModItems.PAINTING_KIT.get());
                        entries.accept(ModItems.PAINT_BRUSH.get());
                        entries.accept(ModBlocks.EASEL.get());
                        entries.accept(ModBlocks.CANVAS.get());
                        entries.accept(ModBlocks.DRAWING_BOARD.get());
                        entries.accept(ModBlocks.CANVAS_BIG.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_OAK.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_SPRUCE.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_JUNGLE.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_BIRCH.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_ACACIA.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_DARK_OAK.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_MANGROVE.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_CHERRY.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_BAMBOO.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_PALE_OAK.get());
                        entries.accept(ModBlocks.PAINTING_FRAME_BLACKSTONE.get());
                        entries.accept(ModBlocks.PHOTO_PAPER_WHITE_A.get());
                        entries.accept(ModBlocks.PHOTO_PAPER_WHITE_B.get());
                        entries.accept(ModBlocks.PHOTO_PAPER_WHITE_C.get());
                        entries.accept(ModBlocks.PHOTO_PAPER_BLACK_A.get());
                        entries.accept(ModBlocks.PHOTO_PAPER_BLACK_B.get());
                        entries.accept(ModBlocks.PHOTO_PAPER_BLACK_C.get());
                        entries.accept(ModBlocks.GRID_SHELF_OAK.get());
                        entries.accept(ModBlocks.GRID_SHELF_SPRUCE.get());
                        entries.accept(ModBlocks.GRID_SHELF_JUNGLE.get());
                        entries.accept(ModBlocks.GRID_SHELF_BIRCH.get());
                        entries.accept(ModBlocks.GRID_SHELF_ACACIA.get());
                        entries.accept(ModBlocks.GRID_SHELF_DARK_OAK.get());
                        entries.accept(ModBlocks.GRID_SHELF_MANGROVE.get());
                        entries.accept(ModBlocks.GRID_SHELF_CHERRY.get());
                        entries.accept(ModBlocks.GRID_SHELF_BAMBOO.get());
                        entries.accept(ModBlocks.GRID_SHELF_PALE_OAK.get());
                        entries.accept(ModBlocks.GRID_SHELF_BLACKSTONE.get());
                        entries.accept(ModBlocks.PAINT_CAN.get());
                        entries.accept(ModBlocks.MESSY_PAINT_CAN.get());
                        entries.accept(ModBlocks.PAINT_BRUSH_BUCKET.get());

                        entries.accept(ModBlocks.OPEN_BOOK.get());
                        entries.accept(ModBlocks.CRAYON_BOX.get());
                        entries.accept(ModBlocks.PALETTE.get());

                        entries.accept(ModItems.PAINTING_ANGEL.get());
                        entries.accept(ModItems.PAINTING_BEDROOM_BED.get());
                        entries.accept(ModItems.PAINTING_BERRY_BUSH.get());
                        entries.accept(ModItems.PAINTING_BICHON.get());
                        entries.accept(ModItems.PAINTING_CAKE.get());
                        entries.accept(ModItems.PAINTING_CAT_UNDER_A_TREE.get());
                        entries.accept(ModItems.PAINTING_CHIME.get());
                        entries.accept(ModItems.PAINTING_CITY_NIGHT.get());
                        entries.accept(ModItems.PAINTING_CLOVER.get());
                        entries.accept(ModItems.PAINTING_COW.get());
                        entries.accept(ModItems.PAINTING_CRYSTAL_FAIRY.get());
                        entries.accept(ModItems.PAINTING_DESSERT.get());
                        entries.accept(ModItems.PAINTING_FLOWER_BASKET.get());
                        entries.accept(ModItems.PAINTING_FLOWERSEA_COTTAGE.get());
                        entries.accept(ModItems.PAINTING_FRIENDS_PARTY.get());
                        entries.accept(ModItems.PAINTING_FRUITS_BASKET.get());
                        entries.accept(ModItems.PAINTING_GARDEN_ENTRANCE.get());
                        entries.accept(ModItems.PAINTING_GRAMOPHONE.get());
                        entries.accept(ModItems.PAINTING_GRAVEYARD.get());
                        entries.accept(ModItems.PAINTING_HARVEST.get());
                        entries.accept(ModItems.PAINTING_ISLAND.get());
                        entries.accept(ModItems.PAINTING_KITCHEN_SINK.get());
                        entries.accept(ModItems.PAINTING_KITE.get());
                        entries.accept(ModItems.PAINTING_LEMON_SLICE.get());
                        entries.accept(ModItems.PAINTING_MERMAID.get());
                        entries.accept(ModItems.PAINTING_MILKYWAY.get());
                        entries.accept(ModItems.PAINTING_NIGHT_CAMPFIRE.get());
                        entries.accept(ModItems.PAINTING_PUMPKIN.get());
                        entries.accept(ModItems.PAINTING_RAINBOW_UNICORN.get());
                        entries.accept(ModItems.PAINTING_RESTAURANT.get());
                        entries.accept(ModItems.PAINTING_ROSE_SWING.get());
                        entries.accept(ModItems.PAINTING_SALTED_LEMON.get());
                        entries.accept(ModItems.PAINTING_SCENERY.get());
                        entries.accept(ModItems.PAINTING_SKETCH.get());
                        entries.accept(ModItems.PAINTING_SNOW_HOUSE.get());
                        entries.accept(ModItems.PAINTING_STATIONARY_OBJECTS.get());
                        entries.accept(ModItems.PAINTING_SUMPTUOUS_MEAL.get());
                        entries.accept(ModItems.PAINTING_SUNSET.get());
                        entries.accept(ModItems.PAINTING_TEDDY_BEAR.get());
                        entries.accept(ModItems.PAINTING_TOYS.get());
                        entries.accept(ModItems.PAINTING_TULIP.get());
                        entries.accept(ModItems.PAINTING_URBAN_BEAUTY.get());
                        entries.accept(ModItems.PAINTING_WAVES.get());
                        entries.accept(ModItems.PAINTING_WHEAT_FIELD.get());
                        entries.accept(ModItems.PAINTING_WILDFLOWER_PLAIN.get());
                        entries.accept(ModItems.PAINTING_WORLD_TREE.get());
                    })).build()
    );

    public static void registerItemGroup(){

    }
}