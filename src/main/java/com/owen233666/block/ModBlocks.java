/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block;


import com.owen233666.XheFurniture;
import java.util.function.Supplier;
import com.owen233666.block.painting.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import com.owen233666.platform.BlockProps;
import com.owen233666.platform.Ids;
import com.owen233666.platform.Registrar;

public class ModBlocks {
    //Cups
    public static final ResourceLocation HOT_COCOA_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "hot_cocoa");
    //Shoe Flowerpots
    public static final ResourceLocation WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION  = Ids.of(XheFurniture.MOD_ID, "white_shoe_flowerpot");
    public static final ResourceLocation PINK_SHOE_FLOWERPOT_RESOURCE_LOCATION   = Ids.of(XheFurniture.MOD_ID, "pink_shoe_flowerpot");
    public static final ResourceLocation RED_SHOE_FLOWERPOT_RESOURCE_LOCATION    = Ids.of(XheFurniture.MOD_ID, "red_shoe_flowerpot");
    public static final ResourceLocation GREEN_SHOE_FLOWERPOT_RESOURCE_LOCATION  = Ids.of(XheFurniture.MOD_ID, "green_shoe_flowerpot");
    public static final ResourceLocation YELLOW_SHOE_FLOWERPOT_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "yellow_shoe_flowerpot");
    //Slippers
    public static final ResourceLocation WHITE_BUNNY_SLIPPERS_RESOURCE_LOCATION     = Ids.of(XheFurniture.MOD_ID, "white_bunny_slippers");
    public static final ResourceLocation WHITE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = Ids.of(XheFurniture.MOD_ID, "white_hamsters_slippers");
    public static final ResourceLocation WHITE_BEAR_SLIPPERS_RESOURCE_LOCATION      = Ids.of(XheFurniture.MOD_ID, "white_bear_slippers");
    public static final ResourceLocation BEIGE_BUNNY_SLIPPERS_RESOURCE_LOCATION     = Ids.of(XheFurniture.MOD_ID, "beige_bunny_slippers");
    public static final ResourceLocation BEIGE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = Ids.of(XheFurniture.MOD_ID, "beige_hamsters_slippers");
    public static final ResourceLocation BEIGE_BEAR_SLIPPERS_RESOURCE_LOCATION      = Ids.of(XheFurniture.MOD_ID, "beige_bear_slippers");
    public static final ResourceLocation BROWN_BUNNY_SLIPPERS_RESOURCE_LOCATION     = Ids.of(XheFurniture.MOD_ID, "brown_bunny_slippers");
    public static final ResourceLocation BROWN_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = Ids.of(XheFurniture.MOD_ID, "brown_hamsters_slippers");
    public static final ResourceLocation BROWN_BEAR_SLIPPERS_RESOURCE_LOCATION      = Ids.of(XheFurniture.MOD_ID, "brown_bear_slippers");
    public static final ResourceLocation BLACK_BUNNY_SLIPPERS_RESOURCE_LOCATION     = Ids.of(XheFurniture.MOD_ID, "black_bunny_slippers");
    public static final ResourceLocation BLACK_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = Ids.of(XheFurniture.MOD_ID, "black_hamsters_slippers");
    public static final ResourceLocation BLACK_BEAR_SLIPPERS_RESOURCE_LOCATION      = Ids.of(XheFurniture.MOD_ID, "black_bear_slippers");
    public static final ResourceLocation CALICO_BUNNY_SLIPPERS_RESOURCE_LOCATION    = Ids.of(XheFurniture.MOD_ID, "calico_bunny_slippers");
    public static final ResourceLocation CALICO_HAMSTERS_SLIPPERS_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "calico_hamsters_slippers");
    public static final ResourceLocation PANDA_SLIPPERS_RESOURCE_LOCATION           = Ids.of(XheFurniture.MOD_ID, "panda_slippers");
    //Carpets
    public static final ResourceLocation CARPET_BLACK_RESOURCE_LOCATION         = Ids.of(XheFurniture.MOD_ID, "carpet_black");
    public static final ResourceLocation CARPET_BLACK_A_RESOURCE_LOCATION       = Ids.of(XheFurniture.MOD_ID, "carpet_black_a");
    public static final ResourceLocation CARPET_BLUE_RESOURCE_LOCATION          = Ids.of(XheFurniture.MOD_ID, "carpet_blue");
    public static final ResourceLocation CARPET_BLUE_A_RESOURCE_LOCATION        = Ids.of(XheFurniture.MOD_ID, "carpet_blue_a");
    public static final ResourceLocation CARPET_BLUE_B_RESOURCE_LOCATION        = Ids.of(XheFurniture.MOD_ID, "carpet_blue_b");
    public static final ResourceLocation CARPET_BROWN_RESOURCE_LOCATION         = Ids.of(XheFurniture.MOD_ID, "carpet_brown");
    public static final ResourceLocation CARPET_BROWN_A_RESOURCE_LOCATION       = Ids.of(XheFurniture.MOD_ID, "carpet_brown_a");
    public static final ResourceLocation CARPET_DEEP_BLUE_RESOURCE_LOCATION     = Ids.of(XheFurniture.MOD_ID, "carpet_deep_blue");
    public static final ResourceLocation CARPET_DEEP_BLUE_A_RESOURCE_LOCATION   = Ids.of(XheFurniture.MOD_ID, "carpet_deep_blue_a");
    public static final ResourceLocation CARPET_DEEP_BLUE_B_RESOURCE_LOCATION   = Ids.of(XheFurniture.MOD_ID, "carpet_deep_blue_b");
    public static final ResourceLocation CARPET_DEEP_GREEN_RESOURCE_LOCATION    = Ids.of(XheFurniture.MOD_ID, "carpet_deep_green");
    public static final ResourceLocation CARPET_DEEP_GREEN_A_RESOURCE_LOCATION  = Ids.of(XheFurniture.MOD_ID, "carpet_deep_green_a");
    public static final ResourceLocation CARPET_DEEP_PURPLE_RESOURCE_LOCATION   = Ids.of(XheFurniture.MOD_ID, "carpet_deep_purple");
    public static final ResourceLocation CARPET_DEEP_PURPLE_A_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "carpet_deep_purple_a");
    public static final ResourceLocation CARPET_FLAPJACK_RESOURCE_LOCATION      = Ids.of(XheFurniture.MOD_ID, "carpet_flapjack");
    public static final ResourceLocation CARPET_FLAPJACK_A_RESOURCE_LOCATION    = Ids.of(XheFurniture.MOD_ID, "carpet_flapjack_a");
    public static final ResourceLocation CARPET_GRAY_RESOURCE_LOCATION          = Ids.of(XheFurniture.MOD_ID, "carpet_gray");
    public static final ResourceLocation CARPET_GRAY_A_RESOURCE_LOCATION        = Ids.of(XheFurniture.MOD_ID, "carpet_gray_a");
    public static final ResourceLocation CARPET_GREEN_RESOURCE_LOCATION         = Ids.of(XheFurniture.MOD_ID, "carpet_green");
    public static final ResourceLocation CARPET_GREEN_A_RESOURCE_LOCATION       = Ids.of(XheFurniture.MOD_ID, "carpet_green_a");
    public static final ResourceLocation CARPET_LEMON_SLICE_RESOURCE_LOCATION   = Ids.of(XheFurniture.MOD_ID, "carpet_lemon_slice");
    public static final ResourceLocation CARPET_ORANGE_RESOURCE_LOCATION        = Ids.of(XheFurniture.MOD_ID, "carpet_orange");
    public static final ResourceLocation CARPET_ORANGE_A_RESOURCE_LOCATION      = Ids.of(XheFurniture.MOD_ID, "carpet_orange_a");
    public static final ResourceLocation CARPET_PINK_RESOURCE_LOCATION          = Ids.of(XheFurniture.MOD_ID, "carpet_pink");
    public static final ResourceLocation CARPET_PINK_A_RESOURCE_LOCATION        = Ids.of(XheFurniture.MOD_ID, "carpet_pink_a");
    public static final ResourceLocation CARPET_PINK_B_RESOURCE_LOCATION        = Ids.of(XheFurniture.MOD_ID, "carpet_pink_b");
    public static final ResourceLocation CARPET_PIZZA_RESOURCE_LOCATION         = Ids.of(XheFurniture.MOD_ID, "carpet_pizza");
    public static final ResourceLocation CARPET_PURPLE_RESOURCE_LOCATION        = Ids.of(XheFurniture.MOD_ID, "carpet_purple");
    public static final ResourceLocation CARPET_PURPLE_A_RESOURCE_LOCATION      = Ids.of(XheFurniture.MOD_ID, "carpet_purple_a");
    public static final ResourceLocation CARPET_RED_RESOURCE_LOCATION           = Ids.of(XheFurniture.MOD_ID, "carpet_red");
    public static final ResourceLocation CARPET_RED_A_RESOURCE_LOCATION         = Ids.of(XheFurniture.MOD_ID, "carpet_red_a");
    public static final ResourceLocation CARPET_WAFFLE_RESOURCE_LOCATION        = Ids.of(XheFurniture.MOD_ID, "carpet_waffle");
    public static final ResourceLocation CARPET_WAFFLE_A_RESOURCE_LOCATION      = Ids.of(XheFurniture.MOD_ID, "carpet_waffle_a");
    public static final ResourceLocation CARPET_WHITE_RESOURCE_LOCATION         = Ids.of(XheFurniture.MOD_ID, "carpet_white");
    public static final ResourceLocation CARPET_WHITE_A_RESOURCE_LOCATION       = Ids.of(XheFurniture.MOD_ID, "carpet_white_a");
    public static final ResourceLocation CARPET_YELLOW_RESOURCE_LOCATION        = Ids.of(XheFurniture.MOD_ID, "carpet_yellow");
    //Rattan Table
    public static final ResourceLocation RATTAN_TABLE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "rattan_table");
    //Painting Studio Series
    public static final ResourceLocation EASEL_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "easel");
    public static final ResourceLocation CANVAS_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "canvas");
    public static final ResourceLocation CANVAS_BIG_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "canvas_big");
    public static final ResourceLocation PAINTING_FRAME_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_oak");
    public static final ResourceLocation PAINTING_FRAME_SPRUCE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_spruce");
    public static final ResourceLocation PAINTING_FRAME_BIRCH_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_birch");
    public static final ResourceLocation PAINTING_FRAME_JUNGLE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_jungle");
    public static final ResourceLocation PAINTING_FRAME_ACACIA_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_acacia");
    public static final ResourceLocation PAINTING_FRAME_DARK_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_dark_oak");
    public static final ResourceLocation PAINTING_FRAME_MANGROVE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_mangrove");
    public static final ResourceLocation PAINTING_FRAME_CHERRY_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_cherry");
    public static final ResourceLocation PAINTING_FRAME_BAMBOO_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_bamboo");
    public static final ResourceLocation PAINTING_FRAME_PALE_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_pale_oak");
    public static final ResourceLocation PAINTING_FRAME_BLACKSTONE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "painting_frame_blackstone");
    public static final ResourceLocation DRAWING_BOARD_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "drawing_board");
    public static final ResourceLocation PHOTO_PAPER_WHITE_A_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "photo_paper_white_a");
    public static final ResourceLocation PHOTO_PAPER_WHITE_B_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "photo_paper_white_b");
    public static final ResourceLocation PHOTO_PAPER_WHITE_C_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "photo_paper_white_c");
    public static final ResourceLocation PHOTO_PAPER_BLACK_A_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "photo_paper_black_a");
    public static final ResourceLocation PHOTO_PAPER_BLACK_B_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "photo_paper_black_b");
    public static final ResourceLocation PHOTO_PAPER_BLACK_C_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "photo_paper_black_c");
    public static final ResourceLocation GRID_SHELF_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_oak");
    public static final ResourceLocation GRID_SHELF_SPRUCE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_spruce");
    public static final ResourceLocation GRID_SHELF_BIRCH_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_birch");
    public static final ResourceLocation GRID_SHELF_JUNGLE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_jungle");
    public static final ResourceLocation GRID_SHELF_ACACIA_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_acacia");
    public static final ResourceLocation GRID_SHELF_DARK_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_dark_oak");
    public static final ResourceLocation GRID_SHELF_MANGROVE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_mangrove");
    public static final ResourceLocation GRID_SHELF_CHERRY_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_cherry");
    public static final ResourceLocation GRID_SHELF_BAMBOO_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_bamboo");
    public static final ResourceLocation GRID_SHELF_PALE_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_pale_oak");
    public static final ResourceLocation GRID_SHELF_BLACKSTONE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "grid_shelf_blackstone");
    public static final ResourceLocation PAINT_BRUSH_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "paint_brush");
    public static final ResourceLocation PAINT_CAN_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "paint_can");
    public static final ResourceLocation MESSY_PAINT_CAN_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "messy_paint_can");
    public static final ResourceLocation PAINT_BRUSH_BUCKET_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "paint_brush_bucket");
    //Furniture Crafting Tables
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_oak");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_SPRUCE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_spruce");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_BIRCH_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_birch");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_JUNGLE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_jungle");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_ACACIA_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_acacia");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_DARK_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_dark_oak");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_MANGROVE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_mangrove");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_CHERRY_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_cherry");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_BAMBOO_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_bamboo");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_PALE_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_pale_oak");
    public static final ResourceLocation FURNITURE_CRAFTING_TABLE_BLACKSTONE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "furniture_crafting_table_blackstone");
    //Books
    public static final ResourceLocation OPEN_BOOK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "open_book");

    public static final ResourceLocation CRAYON_BOX_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "crayon_box");
    public static final ResourceLocation PALETTE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "palette");

    public static final ResourceLocation CORK_BOARD_LIGHT_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_oak");

    public static final ResourceLocation CORK_BOARD_LIGHT_SPRUCE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_spruce");
    public static final ResourceLocation CORK_BOARD_LIGHT_JUNGLE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_jungle");
    public static final ResourceLocation CORK_BOARD_LIGHT_BIRCH_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_birch");
    public static final ResourceLocation CORK_BOARD_LIGHT_ACACIA_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_acacia");
    public static final ResourceLocation CORK_BOARD_LIGHT_DARK_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_dark_oak");
    public static final ResourceLocation CORK_BOARD_LIGHT_MANGROVE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_mangrove");
    public static final ResourceLocation CORK_BOARD_LIGHT_CHERRY_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_cherry");
    public static final ResourceLocation CORK_BOARD_LIGHT_BAMBOO_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_bamboo");
    public static final ResourceLocation CORK_BOARD_LIGHT_PALE_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_pale_oak");
    public static final ResourceLocation CORK_BOARD_LIGHT_BLACKSTONE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_light_blackstone");

    public static final ResourceLocation CORK_BOARD_DARK_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_oak");
    public static final ResourceLocation CORK_BOARD_DARK_SPRUCE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_spruce");
    public static final ResourceLocation CORK_BOARD_DARK_JUNGLE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_jungle");
    public static final ResourceLocation CORK_BOARD_DARK_BIRCH_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_birch");
    public static final ResourceLocation CORK_BOARD_DARK_ACACIA_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_acacia");
    public static final ResourceLocation CORK_BOARD_DARK_DARK_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_dark_oak");
    public static final ResourceLocation CORK_BOARD_DARK_MANGROVE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_mangrove");
    public static final ResourceLocation CORK_BOARD_DARK_CHERRY_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_cherry");
    public static final ResourceLocation CORK_BOARD_DARK_BAMBOO_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_bamboo");
    public static final ResourceLocation CORK_BOARD_DARK_PALE_OAK_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_pale_oak");
    public static final ResourceLocation CORK_BOARD_DARK_BLACKSTONE_RESOURCE_LOCATION = Ids.of(XheFurniture.MOD_ID, "cork_board_dark_blackstone");


    //Cups
    public static final Registrar.Holder<Block> HOT_COCOA = registerBlock(HOT_COCOA_RESOURCE_LOCATION, () -> new CupBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.0F, 0.0F).instabreak().sound(SoundType.STONE).noCollission()));
    //Shoe Flowerpots
    public static final Registrar.Holder<Block> WHITE_SHOE_FLOWERPOT  = registerBlock(WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION, () -> new ShoeFlowerPotBlock(BlockProps.copyOf(Blocks.FLOWER_POT)));
    public static final Registrar.Holder<Block> PINK_SHOE_FLOWERPOT   = registerBlock(PINK_SHOE_FLOWERPOT_RESOURCE_LOCATION, () -> new ShoeFlowerPotBlock(BlockProps.copyOf(Blocks.FLOWER_POT)));
    public static final Registrar.Holder<Block> RED_SHOE_FLOWERPOT    = registerBlock(RED_SHOE_FLOWERPOT_RESOURCE_LOCATION, () -> new ShoeFlowerPotBlock(BlockProps.copyOf(Blocks.FLOWER_POT)));
    public static final Registrar.Holder<Block> GREEN_SHOE_FLOWERPOT  = registerBlock(GREEN_SHOE_FLOWERPOT_RESOURCE_LOCATION, () -> new ShoeFlowerPotBlock(BlockProps.copyOf(Blocks.FLOWER_POT)));
    public static final Registrar.Holder<Block> YELLOW_SHOE_FLOWERPOT = registerBlock(YELLOW_SHOE_FLOWERPOT_RESOURCE_LOCATION, () -> new ShoeFlowerPotBlock(BlockProps.copyOf(Blocks.FLOWER_POT)));
    //Slippers
    public static final Registrar.Holder<Block> WHITE_BUNNY_SLIPPERS     = registerBlock(WHITE_BUNNY_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> WHITE_HAMSTERS_SLIPPERS  = registerBlock(WHITE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> WHITE_BEAR_SLIPPERS      = registerBlock(WHITE_BEAR_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> BEIGE_BUNNY_SLIPPERS     = registerBlock(BEIGE_BUNNY_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> BEIGE_HAMSTERS_SLIPPERS  = registerBlock(BEIGE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> BEIGE_BEAR_SLIPPERS      = registerBlock(BEIGE_BEAR_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> BROWN_BUNNY_SLIPPERS     = registerBlock(BROWN_BUNNY_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> BROWN_HAMSTERS_SLIPPERS  = registerBlock(BROWN_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> BROWN_BEAR_SLIPPERS      = registerBlock(BROWN_BEAR_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> BLACK_BUNNY_SLIPPERS     = registerBlock(BLACK_BUNNY_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> BLACK_HAMSTERS_SLIPPERS  = registerBlock(BLACK_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> BLACK_BEAR_SLIPPERS      = registerBlock(BLACK_BEAR_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> CALICO_BUNNY_SLIPPERS    = registerBlock(CALICO_BUNNY_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> CALICO_HAMSTERS_SLIPPERS = registerBlock(CALICO_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Registrar.Holder<Block> PANDA_SLIPPERS           = registerBlock(PANDA_SLIPPERS_RESOURCE_LOCATION, () -> new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    //Carpets
    public static final Registrar.Holder<Block> CARPET_BLACK          = registerBlock(CARPET_BLACK_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BLACK_CARPET)));
    public static final Registrar.Holder<Block> CARPET_BLACK_A        = registerBlock(CARPET_BLACK_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BLACK_CARPET)));
    public static final Registrar.Holder<Block> CARPET_BLUE           = registerBlock(CARPET_BLUE_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.LIGHT_BLUE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_BLUE_A         = registerBlock(CARPET_BLUE_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.LIGHT_BLUE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_BLUE_B         = registerBlock(CARPET_BLUE_B_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BLUE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_BROWN          = registerBlock(CARPET_BROWN_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BROWN_CARPET)));
    public static final Registrar.Holder<Block> CARPET_BROWN_A        = registerBlock(CARPET_BROWN_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BROWN_CARPET)));
    public static final Registrar.Holder<Block> CARPET_DEEP_BLUE      = registerBlock(CARPET_DEEP_BLUE_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BLUE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_DEEP_BLUE_A    = registerBlock(CARPET_DEEP_BLUE_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BLUE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_DEEP_BLUE_B    = registerBlock(CARPET_DEEP_BLUE_B_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BLUE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_DEEP_GREEN     = registerBlock(CARPET_DEEP_GREEN_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.GREEN_CARPET)));
    public static final Registrar.Holder<Block> CARPET_DEEP_GREEN_A   = registerBlock(CARPET_DEEP_GREEN_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.GREEN_CARPET)));
    public static final Registrar.Holder<Block> CARPET_DEEP_PURPLE    = registerBlock(CARPET_DEEP_PURPLE_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.MAGENTA_CARPET)));
    public static final Registrar.Holder<Block> CARPET_DEEP_PURPLE_A  = registerBlock(CARPET_DEEP_PURPLE_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.MAGENTA_CARPET)));
    public static final Registrar.Holder<Block> CARPET_FLAPJACK       = registerBlock(CARPET_FLAPJACK_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.YELLOW_CARPET)));
    public static final Registrar.Holder<Block> CARPET_FLAPJACK_A     = registerBlock(CARPET_FLAPJACK_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.YELLOW_CARPET)));
    public static final Registrar.Holder<Block> CARPET_GRAY           = registerBlock(CARPET_GRAY_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.GRAY_CARPET)));
    public static final Registrar.Holder<Block> CARPET_GRAY_A         = registerBlock(CARPET_GRAY_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.GRAY_CARPET)));
    public static final Registrar.Holder<Block> CARPET_GREEN          = registerBlock(CARPET_GREEN_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.LIME_CARPET)));
    public static final Registrar.Holder<Block> CARPET_GREEN_A        = registerBlock(CARPET_GREEN_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.LIME_CARPET)));
    public static final Registrar.Holder<Block> CARPET_LEMON_SLICE    = registerBlock(CARPET_LEMON_SLICE_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.YELLOW_CARPET)));
    public static final Registrar.Holder<Block> CARPET_ORANGE         = registerBlock(CARPET_ORANGE_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.ORANGE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_ORANGE_A       = registerBlock(CARPET_ORANGE_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.ORANGE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_PINK           = registerBlock(CARPET_PINK_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.PINK_CARPET)));
    public static final Registrar.Holder<Block> CARPET_PINK_A         = registerBlock(CARPET_PINK_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.PINK_CARPET)));
    public static final Registrar.Holder<Block> CARPET_PINK_B         = registerBlock(CARPET_PINK_B_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.PINK_CARPET)));
    public static final Registrar.Holder<Block> CARPET_PIZZA          = registerBlock(CARPET_PIZZA_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.YELLOW_CARPET)));
    public static final Registrar.Holder<Block> CARPET_PURPLE         = registerBlock(CARPET_PURPLE_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.PURPLE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_PURPLE_A       = registerBlock(CARPET_PURPLE_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.PURPLE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_RED            = registerBlock(CARPET_RED_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.RED_CARPET)));
    public static final Registrar.Holder<Block> CARPET_RED_A          = registerBlock(CARPET_RED_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.RED_CARPET)));
    public static final Registrar.Holder<Block> CARPET_WAFFLE         = registerBlock(CARPET_WAFFLE_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BROWN_CARPET)));
    public static final Registrar.Holder<Block> CARPET_WAFFLE_A       = registerBlock(CARPET_WAFFLE_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.BROWN_CARPET)));
    public static final Registrar.Holder<Block> CARPET_WHITE          = registerBlock(CARPET_WHITE_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.WHITE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_WHITE_A        = registerBlock(CARPET_WHITE_A_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.WHITE_CARPET)));
    public static final Registrar.Holder<Block> CARPET_YELLOW         = registerBlock(CARPET_YELLOW_RESOURCE_LOCATION, () -> new BigCarpetBlock(BlockProps.copyOf(Blocks.YELLOW_CARPET)));
    //Rattan Table
    public static final Registrar.Holder<Block> RATTAN_TABLE = registerBlock(RATTAN_TABLE_RESOURCE_LOCATION, () -> new RattanTableBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)));
    //Painting Studio Series
    public static final Registrar.Holder<Block> EASEL                     = registerBlock(EASEL_RESOURCE_LOCATION, () -> new           EaselBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> CANVAS                    = registerBlock(CANVAS_RESOURCE_LOCATION, () -> new          CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> CANVAS_BIG                = registerBlock(CANVAS_BIG_RESOURCE_LOCATION, () -> new          CanvasBigBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> DRAWING_BOARD             = registerBlock(DRAWING_BOARD_RESOURCE_LOCATION, () -> new          CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_OAK        = registerBlock(PAINTING_FRAME_OAK_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_SPRUCE     = registerBlock(PAINTING_FRAME_SPRUCE_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_JUNGLE     = registerBlock(PAINTING_FRAME_JUNGLE_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_BIRCH      = registerBlock(PAINTING_FRAME_BIRCH_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_ACACIA     = registerBlock(PAINTING_FRAME_ACACIA_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_DARK_OAK   = registerBlock(PAINTING_FRAME_DARK_OAK_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_MANGROVE   = registerBlock(PAINTING_FRAME_MANGROVE_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_CHERRY     = registerBlock(PAINTING_FRAME_CHERRY_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_BAMBOO     = registerBlock(PAINTING_FRAME_BAMBOO_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_PALE_OAK   = registerBlock(PAINTING_FRAME_PALE_OAK_RESOURCE_LOCATION, () -> new      PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PAINTING_FRAME_BLACKSTONE = registerBlock(PAINTING_FRAME_BLACKSTONE_RESOURCE_LOCATION, () -> new       PaintFrameBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PHOTO_PAPER_WHITE_A       = registerWithoutItem(PHOTO_PAPER_WHITE_A_RESOURCE_LOCATION, () -> new      PhotoAPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PHOTO_PAPER_WHITE_B       = registerWithoutItem(PHOTO_PAPER_WHITE_B_RESOURCE_LOCATION, () -> new      PhotoBPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PHOTO_PAPER_WHITE_C       = registerWithoutItem(PHOTO_PAPER_WHITE_C_RESOURCE_LOCATION, () -> new      PhotoCPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PHOTO_PAPER_BLACK_A       = registerWithoutItem(PHOTO_PAPER_BLACK_A_RESOURCE_LOCATION, () -> new      PhotoAPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PHOTO_PAPER_BLACK_B       = registerWithoutItem(PHOTO_PAPER_BLACK_B_RESOURCE_LOCATION, () -> new      PhotoBPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> PHOTO_PAPER_BLACK_C       = registerWithoutItem(PHOTO_PAPER_BLACK_C_RESOURCE_LOCATION, () -> new      PhotoCPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_OAK            = registerBlock(GRID_SHELF_OAK_RESOURCE_LOCATION,            () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_SPRUCE         = registerBlock(GRID_SHELF_SPRUCE_RESOURCE_LOCATION,         () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_JUNGLE         = registerBlock(GRID_SHELF_JUNGLE_RESOURCE_LOCATION,         () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_BIRCH          = registerBlock(GRID_SHELF_BIRCH_RESOURCE_LOCATION,          () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_ACACIA         = registerBlock(GRID_SHELF_ACACIA_RESOURCE_LOCATION,         () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_DARK_OAK       = registerBlock(GRID_SHELF_DARK_OAK_RESOURCE_LOCATION,       () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_MANGROVE       = registerBlock(GRID_SHELF_MANGROVE_RESOURCE_LOCATION,       () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_CHERRY         = registerBlock(GRID_SHELF_CHERRY_RESOURCE_LOCATION,         () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_BAMBOO         = registerBlock(GRID_SHELF_BAMBOO_RESOURCE_LOCATION,         () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_PALE_OAK       = registerBlock(GRID_SHELF_PALE_OAK_RESOURCE_LOCATION,       () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> GRID_SHELF_BLACKSTONE     = registerBlock(GRID_SHELF_BLACKSTONE_RESOURCE_LOCATION,     () -> new        GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> PAINT_BRUSH               = registerWithoutItem(PAINT_BRUSH_RESOURCE_LOCATION,         () -> new       PaintBrushBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().noOcclusion()));
    public static final Registrar.Holder<Block> PAINT_CAN                 = registerBlock(PAINT_CAN_RESOURCE_LOCATION,                 () -> new         PaintCanBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().noOcclusion(), 0, 0, 0, 16, 6, 16));
    public static final Registrar.Holder<Block> MESSY_PAINT_CAN           = registerBlock(MESSY_PAINT_CAN_RESOURCE_LOCATION,           () -> new    MessyPaintCanBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().noOcclusion(), 0, 0, 0, 16, 6, 16));
    public static final Registrar.Holder<Block> PAINT_BRUSH_BUCKET        = registerBlock(PAINT_BRUSH_BUCKET_RESOURCE_LOCATION,        () -> new PaintBrushBucketBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().noOcclusion(), 0, 0, 0, 16, 11, 16));
    //Furniture Crafting Tables
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_OAK         = registerBlock(FURNITURE_CRAFTING_TABLE_OAK_RESOURCE_LOCATION,          () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_SPRUCE      = registerBlock(FURNITURE_CRAFTING_TABLE_SPRUCE_RESOURCE_LOCATION,       () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_JUNGLE      = registerBlock(FURNITURE_CRAFTING_TABLE_JUNGLE_RESOURCE_LOCATION,       () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_BIRCH       = registerBlock(FURNITURE_CRAFTING_TABLE_BIRCH_RESOURCE_LOCATION,        () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_ACACIA      = registerBlock(FURNITURE_CRAFTING_TABLE_ACACIA_RESOURCE_LOCATION,       () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_DARK_OAK    = registerBlock(FURNITURE_CRAFTING_TABLE_DARK_OAK_RESOURCE_LOCATION,     () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_MANGROVE    = registerBlock(FURNITURE_CRAFTING_TABLE_MANGROVE_RESOURCE_LOCATION,     () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_CHERRY      = registerBlock(FURNITURE_CRAFTING_TABLE_CHERRY_RESOURCE_LOCATION,       () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_BAMBOO      = registerBlock(FURNITURE_CRAFTING_TABLE_BAMBOO_RESOURCE_LOCATION,       () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_PALE_OAK    = registerBlock(FURNITURE_CRAFTING_TABLE_PALE_OAK_RESOURCE_LOCATION,     () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    public static final Registrar.Holder<Block> FURNITURE_CRAFTING_TABLE_BLACKSTONE  = registerBlock(FURNITURE_CRAFTING_TABLE_BLACKSTONE_RESOURCE_LOCATION,   () -> new FurnitureCraftingTable(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.WOOD)));
    //Books
    public static final Registrar.Holder<Block> OPEN_BOOK = registerBlock(OPEN_BOOK_RESOURCE_LOCATION, () -> new OpenBookBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().sound(SoundType.WOOD).noOcclusion()));

    public static final Registrar.Holder<Block> CRAYON_BOX = registerBlock(CRAYON_BOX_RESOURCE_LOCATION, () -> new CrayonBoxBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().sound(SoundType.WOOD).noOcclusion()));

    public static final Registrar.Holder<Block> PALETTE = registerBlock(PALETTE_RESOURCE_LOCATION, () -> new PaletteBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().sound(SoundType.WOOD).noOcclusion()));

    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_OAK = registerBlock(CORK_BOARD_LIGHT_OAK_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));

    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_SPRUCE = registerBlock(CORK_BOARD_LIGHT_SPRUCE_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_JUNGLE = registerBlock(CORK_BOARD_LIGHT_JUNGLE_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_BIRCH = registerBlock(CORK_BOARD_LIGHT_BIRCH_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_ACACIA = registerBlock(CORK_BOARD_LIGHT_ACACIA_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_DARK_OAK = registerBlock(CORK_BOARD_LIGHT_DARK_OAK_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_MANGROVE = registerBlock(CORK_BOARD_LIGHT_MANGROVE_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_CHERRY = registerBlock(CORK_BOARD_LIGHT_CHERRY_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_BAMBOO = registerBlock(CORK_BOARD_LIGHT_BAMBOO_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_PALE_OAK = registerBlock(CORK_BOARD_LIGHT_PALE_OAK_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_LIGHT_BLACKSTONE = registerBlock(CORK_BOARD_LIGHT_BLACKSTONE_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));

    public static final Registrar.Holder<Block> CORK_BOARD_DARK_OAK = registerBlock(CORK_BOARD_DARK_OAK_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_SPRUCE = registerBlock(CORK_BOARD_DARK_SPRUCE_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_JUNGLE = registerBlock(CORK_BOARD_DARK_JUNGLE_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_BIRCH = registerBlock(CORK_BOARD_DARK_BIRCH_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_ACACIA = registerBlock(CORK_BOARD_DARK_ACACIA_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_DARK_OAK = registerBlock(CORK_BOARD_DARK_DARK_OAK_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_MANGROVE = registerBlock(CORK_BOARD_DARK_MANGROVE_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_CHERRY = registerBlock(CORK_BOARD_DARK_CHERRY_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_BAMBOO = registerBlock(CORK_BOARD_DARK_BAMBOO_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_PALE_OAK = registerBlock(CORK_BOARD_DARK_PALE_OAK_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final Registrar.Holder<Block> CORK_BOARD_DARK_BLACKSTONE = registerBlock(CORK_BOARD_DARK_BLACKSTONE_RESOURCE_LOCATION, () -> new CorkBoardBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noOcclusion()));

    /**
     * Every furniture crafting table variant. Datagen providers iterate this for the axe tag
     * and the drop-self loot tables, so adding a variant here registers it in all generated
     * data at once.
     *
     * <p>Deliberately a method rather than a static field: on Forge-like loaders the entries
     * above are deferred holders that only bind after the loader's register event, so reading
     * them during class initialisation would throw.
     */
    public static java.util.List<Block> craftingTableBlocks() {
        return java.util.List.of(
                FURNITURE_CRAFTING_TABLE_OAK.get(),
                FURNITURE_CRAFTING_TABLE_SPRUCE.get(),
                FURNITURE_CRAFTING_TABLE_BIRCH.get(),
                FURNITURE_CRAFTING_TABLE_JUNGLE.get(),
                FURNITURE_CRAFTING_TABLE_ACACIA.get(),
                FURNITURE_CRAFTING_TABLE_DARK_OAK.get(),
                FURNITURE_CRAFTING_TABLE_MANGROVE.get(),
                FURNITURE_CRAFTING_TABLE_CHERRY.get(),
                FURNITURE_CRAFTING_TABLE_BAMBOO.get(),
                FURNITURE_CRAFTING_TABLE_PALE_OAK.get(),
                FURNITURE_CRAFTING_TABLE_BLACKSTONE.get()
        );
    }

    public static Registrar.Holder<Block> registerBlock(ResourceLocation resourceLocation, Supplier<Block> factory){
        return Registrar.block(resourceLocation, factory);
    }

    public static Registrar.Holder<Block> registerWithoutItem(ResourceLocation resourceLocation, Supplier<Block> factory){
        return Registrar.blockWithoutItem(resourceLocation, factory);
    }

    
    public static void registerModBlocks(){

    }
}