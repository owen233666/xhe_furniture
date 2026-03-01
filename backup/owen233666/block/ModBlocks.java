package com.owen233666.block;


import com.owen233666.XheFurniture;
import com.owen233666.block.painting.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //Cups
    public static final Identifier HOT_COCOA_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "hot_cocoa");
    //Shoe Flowerpots
    public static final Identifier WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION  = new Identifier(XheFurniture.MOD_ID, "white_shoe_flowerpot");
    public static final Identifier PINK_SHOE_FLOWERPOT_RESOURCE_LOCATION   = new Identifier(XheFurniture.MOD_ID, "pink_shoe_flowerpot");
    public static final Identifier RED_SHOE_FLOWERPOT_RESOURCE_LOCATION    = new Identifier(XheFurniture.MOD_ID, "red_shoe_flowerpot");
    public static final Identifier GREEN_SHOE_FLOWERPOT_RESOURCE_LOCATION  = new Identifier(XheFurniture.MOD_ID, "green_shoe_flowerpot");
    public static final Identifier YELLOW_SHOE_FLOWERPOT_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "yellow_shoe_flowerpot");
    //Slippers
    public static final Identifier WHITE_BUNNY_SLIPPERS_RESOURCE_LOCATION     = new Identifier(XheFurniture.MOD_ID, "white_bunny_slippers");
    public static final Identifier WHITE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = new Identifier(XheFurniture.MOD_ID, "white_hamsters_slippers");
    public static final Identifier WHITE_BEAR_SLIPPERS_RESOURCE_LOCATION      = new Identifier(XheFurniture.MOD_ID, "white_bear_slippers");
    public static final Identifier BEIGE_BUNNY_SLIPPERS_RESOURCE_LOCATION     = new Identifier(XheFurniture.MOD_ID, "beige_bunny_slippers");
    public static final Identifier BEIGE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = new Identifier(XheFurniture.MOD_ID, "beige_hamsters_slippers");
    public static final Identifier BEIGE_BEAR_SLIPPERS_RESOURCE_LOCATION      = new Identifier(XheFurniture.MOD_ID, "beige_bear_slippers");
    public static final Identifier BROWN_BUNNY_SLIPPERS_RESOURCE_LOCATION     = new Identifier(XheFurniture.MOD_ID, "brown_bunny_slippers");
    public static final Identifier BROWN_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = new Identifier(XheFurniture.MOD_ID, "brown_hamsters_slippers");
    public static final Identifier BROWN_BEAR_SLIPPERS_RESOURCE_LOCATION      = new Identifier(XheFurniture.MOD_ID, "brown_bear_slippers");
    public static final Identifier BLACK_BUNNY_SLIPPERS_RESOURCE_LOCATION     = new Identifier(XheFurniture.MOD_ID, "black_bunny_slippers");
    public static final Identifier BLACK_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = new Identifier(XheFurniture.MOD_ID, "black_hamsters_slippers");
    public static final Identifier BLACK_BEAR_SLIPPERS_RESOURCE_LOCATION      = new Identifier(XheFurniture.MOD_ID, "black_bear_slippers");
    public static final Identifier CALICO_BUNNY_SLIPPERS_RESOURCE_LOCATION    = new Identifier(XheFurniture.MOD_ID, "calico_bunny_slippers");
    public static final Identifier CALICO_HAMSTERS_SLIPPERS_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "calico_hamsters_slippers");
    public static final Identifier PANDA_SLIPPERS_RESOURCE_LOCATION           = new Identifier(XheFurniture.MOD_ID, "panda_slippers");
    //Carpets
    public static final Identifier CARPET_BLACK_RESOURCE_LOCATION         = new Identifier(XheFurniture.MOD_ID, "carpet_black");
    public static final Identifier CARPET_BLACK_A_RESOURCE_LOCATION       = new Identifier(XheFurniture.MOD_ID, "carpet_black_a");
    public static final Identifier CARPET_BLUE_RESOURCE_LOCATION          = new Identifier(XheFurniture.MOD_ID, "carpet_blue");
    public static final Identifier CARPET_BLUE_A_RESOURCE_LOCATION        = new Identifier(XheFurniture.MOD_ID, "carpet_blue_a");
    public static final Identifier CARPET_BLUE_B_RESOURCE_LOCATION        = new Identifier(XheFurniture.MOD_ID, "carpet_blue_b");
    public static final Identifier CARPET_BROWN_RESOURCE_LOCATION         = new Identifier(XheFurniture.MOD_ID, "carpet_brown");
    public static final Identifier CARPET_BROWN_A_RESOURCE_LOCATION       = new Identifier(XheFurniture.MOD_ID, "carpet_brown_a");
    public static final Identifier CARPET_DEEP_BLUE_RESOURCE_LOCATION     = new Identifier(XheFurniture.MOD_ID, "carpet_deep_blue");
    public static final Identifier CARPET_DEEP_BLUE_A_RESOURCE_LOCATION   = new Identifier(XheFurniture.MOD_ID, "carpet_deep_blue_a");
    public static final Identifier CARPET_DEEP_BLUE_B_RESOURCE_LOCATION   = new Identifier(XheFurniture.MOD_ID, "carpet_deep_blue_b");
    public static final Identifier CARPET_DEEP_GREEN_RESOURCE_LOCATION    = new Identifier(XheFurniture.MOD_ID, "carpet_deep_green");
    public static final Identifier CARPET_DEEP_GREEN_A_RESOURCE_LOCATION  = new Identifier(XheFurniture.MOD_ID, "carpet_deep_green_a");
    public static final Identifier CARPET_DEEP_PURPLE_RESOURCE_LOCATION   = new Identifier(XheFurniture.MOD_ID, "carpet_deep_purple");
    public static final Identifier CARPET_DEEP_PURPLE_A_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "carpet_deep_purple_a");
    public static final Identifier CARPET_FLAPJACK_RESOURCE_LOCATION      = new Identifier(XheFurniture.MOD_ID, "carpet_flapjack");
    public static final Identifier CARPET_FLAPJACK_A_RESOURCE_LOCATION    = new Identifier(XheFurniture.MOD_ID, "carpet_flapjack_a");
    public static final Identifier CARPET_GRAY_RESOURCE_LOCATION          = new Identifier(XheFurniture.MOD_ID, "carpet_gray");
    public static final Identifier CARPET_GRAY_A_RESOURCE_LOCATION        = new Identifier(XheFurniture.MOD_ID, "carpet_gray_a");
    public static final Identifier CARPET_GREEN_RESOURCE_LOCATION         = new Identifier(XheFurniture.MOD_ID, "carpet_green");
    public static final Identifier CARPET_GREEN_A_RESOURCE_LOCATION       =  new Identifier(XheFurniture.MOD_ID, "carpet_green_a");
    public static final Identifier CARPET_LEMON_SLICE_RESOURCE_LOCATION   = new Identifier(XheFurniture.MOD_ID, "carpet_lemon_slice");
    public static final Identifier CARPET_ORANGE_RESOURCE_LOCATION        = new Identifier(XheFurniture.MOD_ID, "carpet_orange");
    public static final Identifier CARPET_ORANGE_A_RESOURCE_LOCATION      = new Identifier(XheFurniture.MOD_ID, "carpet_orange_a");
    public static final Identifier CARPET_PINK_RESOURCE_LOCATION          = new Identifier(XheFurniture.MOD_ID, "carpet_pink");
    public static final Identifier CARPET_PINK_A_RESOURCE_LOCATION        = new Identifier(XheFurniture.MOD_ID, "carpet_pink_a");
    public static final Identifier CARPET_PINK_B_RESOURCE_LOCATION        = new Identifier(XheFurniture.MOD_ID, "carpet_pink_b");
    public static final Identifier CARPET_PIZZA_RESOURCE_LOCATION         = new Identifier(XheFurniture.MOD_ID, "carpet_pizza");
    public static final Identifier CARPET_PURPLE_RESOURCE_LOCATION        = new Identifier(XheFurniture.MOD_ID, "carpet_purple");
    public static final Identifier CARPET_PURPLE_A_RESOURCE_LOCATION      = new Identifier(XheFurniture.MOD_ID, "carpet_purple_a");
    public static final Identifier CARPET_RED_RESOURCE_LOCATION           = new Identifier(XheFurniture.MOD_ID, "carpet_red");
    public static final Identifier CARPET_RED_A_RESOURCE_LOCATION         = new Identifier(XheFurniture.MOD_ID, "carpet_red_a");
    public static final Identifier CARPET_WAFFLE_RESOURCE_LOCATION        = new Identifier(XheFurniture.MOD_ID, "carpet_waffle");
    public static final Identifier CARPET_WAFFLE_A_RESOURCE_LOCATION      = new Identifier(XheFurniture.MOD_ID, "carpet_waffle_a");
    public static final Identifier CARPET_WHITE_RESOURCE_LOCATION         = new Identifier(XheFurniture.MOD_ID, "carpet_white");
    public static final Identifier CARPET_WHITE_A_RESOURCE_LOCATION       = new Identifier(XheFurniture.MOD_ID, "carpet_white_a");
    public static final Identifier CARPET_YELLOW_RESOURCE_LOCATION        = new Identifier(XheFurniture.MOD_ID, "carpet_yellow");
    //Rattan Table
    public static final Identifier RATTAN_TABLE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "rattan_table");
    //Painting Studio Series
    public static final Identifier EASEL_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "easel");
    public static final Identifier CANVAS_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "canvas");
    public static final Identifier PAINTING_FRAME_OAK_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame");
    public static final Identifier PAINTING_FRAME_SPRUCE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_spruce");
    public static final Identifier PAINTING_FRAME_BIRCH_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_birch");
    public static final Identifier PAINTING_FRAME_JUNGLE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_jungle");
    public static final Identifier PAINTING_FRAME_ACACIA_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_acacia");
    public static final Identifier PAINTING_FRAME_DARK_OAK_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_dark_oak");
    public static final Identifier PAINTING_FRAME_MANGROVE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_mangrove");
    public static final Identifier PAINTING_FRAME_CHERRY_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_cherry");
    public static final Identifier PAINTING_FRAME_BAMBOO_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_bamboo");
    public static final Identifier PAINTING_FRAME_PALE_OAK_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_palm");
    public static final Identifier PAINTING_FRAME_BLACKSTONE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "painting_frame_blackstone");
    public static final Identifier DRAWING_BOARD_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "drawing_board");
    public static final Identifier PHOTO_PAPER_WHITE_A_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "photo_paper_white_a");
    public static final Identifier PHOTO_PAPER_WHITE_B_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "photo_paper_white_b");
    public static final Identifier PHOTO_PAPER_WHITE_C_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "photo_paper_white_c");
    public static final Identifier PHOTO_PAPER_BLACK_A_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "photo_paper_black_a");
    public static final Identifier PHOTO_PAPER_BLACK_B_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "photo_paper_black_b");
    public static final Identifier PHOTO_PAPER_BLACK_C_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "photo_paper_black_c");
    public static final Identifier GRID_SHELF_OAK_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_oak");
    public static final Identifier GRID_SHELF_SPRUCE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_spruce");
    public static final Identifier GRID_SHELF_BIRCH_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_birch");
    public static final Identifier GRID_SHELF_JUNGLE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_jungle");
    public static final Identifier GRID_SHELF_ACACIA_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_acacia");
    public static final Identifier GRID_SHELF_DARK_OAK_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_dark_oak");
    public static final Identifier GRID_SHELF_MANGROVE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_mangrove");
    public static final Identifier GRID_SHELF_CHERRY_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID,"grid_shelf_cherry");
    public static final Identifier GRID_SHELF_BAMBOO_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_bamboo");
    public static final Identifier GRID_SHELF_PALE_OAK_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_pale_oak");
    public static final Identifier GRID_SHELF_BLACKSTONE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "grid_shelf_blackstone");
    public static final Identifier PAINT_BRUSH_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "paint_brush");
    public static final Identifier PAINT_CAN_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "paint_can");
    public static final Identifier MESSY_PAINT_CAN_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "messy_paint_can");


    //Cups
    public static final Block HOT_COCOA = registerBlock(HOT_COCOA_RESOURCE_LOCATION, new CupBlock(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(0.0F, 0.0F).breakInstantly().sounds(BlockSoundGroup.STONE).noCollision()));
    //Shoe Flowerpots
    public static final Block WHITE_SHOE_FLOWERPOT  = registerBlock(WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION,  new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    public static final Block PINK_SHOE_FLOWERPOT   = registerBlock(PINK_SHOE_FLOWERPOT_RESOURCE_LOCATION,   new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    public static final Block RED_SHOE_FLOWERPOT    = registerBlock(RED_SHOE_FLOWERPOT_RESOURCE_LOCATION,    new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    public static final Block GREEN_SHOE_FLOWERPOT  = registerBlock(GREEN_SHOE_FLOWERPOT_RESOURCE_LOCATION,  new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    public static final Block YELLOW_SHOE_FLOWERPOT = registerBlock(YELLOW_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    //Slippers
    public static final Block WHITE_BUNNY_SLIPPERS     = registerBlock(WHITE_BUNNY_SLIPPERS_RESOURCE_LOCATION,      new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block WHITE_HAMSTERS_SLIPPERS  = registerBlock(WHITE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,   new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block WHITE_BEAR_SLIPPERS      = registerBlock(WHITE_BEAR_SLIPPERS_RESOURCE_LOCATION,       new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BEIGE_BUNNY_SLIPPERS     = registerBlock(BEIGE_BUNNY_SLIPPERS_RESOURCE_LOCATION,      new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BEIGE_HAMSTERS_SLIPPERS  = registerBlock(BEIGE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,   new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BEIGE_BEAR_SLIPPERS      = registerBlock(BEIGE_BEAR_SLIPPERS_RESOURCE_LOCATION,       new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BROWN_BUNNY_SLIPPERS     = registerBlock(BROWN_BUNNY_SLIPPERS_RESOURCE_LOCATION,      new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BROWN_HAMSTERS_SLIPPERS  = registerBlock(BROWN_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,   new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BROWN_BEAR_SLIPPERS      = registerBlock(BROWN_BEAR_SLIPPERS_RESOURCE_LOCATION,       new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BLACK_BUNNY_SLIPPERS     = registerBlock(BLACK_BUNNY_SLIPPERS_RESOURCE_LOCATION,      new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BLACK_HAMSTERS_SLIPPERS  = registerBlock(BLACK_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,   new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BLACK_BEAR_SLIPPERS      = registerBlock(BLACK_BEAR_SLIPPERS_RESOURCE_LOCATION,       new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block CALICO_BUNNY_SLIPPERS    = registerBlock(CALICO_BUNNY_SLIPPERS_RESOURCE_LOCATION,     new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block CALICO_HAMSTERS_SLIPPERS = registerBlock(CALICO_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,  new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block PANDA_SLIPPERS           = registerBlock(PANDA_SLIPPERS_RESOURCE_LOCATION,            new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    //Carpets
    public static final Block CARPET_BLACK          = registerBlock(CARPET_BLACK_RESOURCE_LOCATION,         new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BLACK_CARPET)));
    public static final Block CARPET_BLACK_A        = registerBlock(CARPET_BLACK_A_RESOURCE_LOCATION,       new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BLACK_CARPET)));
    public static final Block CARPET_BLUE           = registerBlock(CARPET_BLUE_RESOURCE_LOCATION,          new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CARPET)));
    public static final Block CARPET_BLUE_A         = registerBlock(CARPET_BLUE_A_RESOURCE_LOCATION,        new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CARPET)));
    public static final Block CARPET_BLUE_B         = registerBlock(CARPET_BLUE_B_RESOURCE_LOCATION,        new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CARPET)));
    public static final Block CARPET_BROWN          = registerBlock(CARPET_BROWN_RESOURCE_LOCATION,         new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CARPET)));
    public static final Block CARPET_BROWN_A        = registerBlock(CARPET_BROWN_A_RESOURCE_LOCATION,       new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CARPET)));
    public static final Block CARPET_DEEP_BLUE      = registerBlock(CARPET_DEEP_BLUE_RESOURCE_LOCATION,     new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CARPET)));
    public static final Block CARPET_DEEP_BLUE_A    = registerBlock(CARPET_DEEP_BLUE_A_RESOURCE_LOCATION,   new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CARPET)));
    public static final Block CARPET_DEEP_BLUE_B    = registerBlock(CARPET_DEEP_BLUE_B_RESOURCE_LOCATION,   new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CARPET)));
    public static final Block CARPET_DEEP_GREEN     = registerBlock(CARPET_DEEP_GREEN_RESOURCE_LOCATION,    new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CARPET)));
    public static final Block CARPET_DEEP_GREEN_A   = registerBlock(CARPET_DEEP_GREEN_A_RESOURCE_LOCATION,  new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CARPET)));
    public static final Block CARPET_DEEP_PURPLE    = registerBlock(CARPET_DEEP_PURPLE_RESOURCE_LOCATION,   new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_CARPET)));
    public static final Block CARPET_DEEP_PURPLE_A  = registerBlock(CARPET_DEEP_PURPLE_A_RESOURCE_LOCATION, new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_CARPET)));
    public static final Block CARPET_FLAPJACK       = registerBlock(CARPET_FLAPJACK_RESOURCE_LOCATION,      new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET)));
    public static final Block CARPET_FLAPJACK_A     = registerBlock(CARPET_FLAPJACK_A_RESOURCE_LOCATION,    new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET)));
    public static final Block CARPET_GRAY           = registerBlock(CARPET_GRAY_RESOURCE_LOCATION,          new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.GRAY_CARPET)));
    public static final Block CARPET_GRAY_A         = registerBlock(CARPET_GRAY_A_RESOURCE_LOCATION,        new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.GRAY_CARPET)));
    public static final Block CARPET_GREEN          = registerBlock(CARPET_GREEN_RESOURCE_LOCATION,         new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.LIME_CARPET)));
    public static final Block CARPET_GREEN_A        = registerBlock(CARPET_GREEN_A_RESOURCE_LOCATION,       new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.LIME_CARPET)));
    public static final Block CARPET_LEMON_SLICE    = registerBlock(CARPET_LEMON_SLICE_RESOURCE_LOCATION,   new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET)));
    public static final Block CARPET_ORANGE         = registerBlock(CARPET_ORANGE_RESOURCE_LOCATION,        new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_CARPET)));
    public static final Block CARPET_ORANGE_A       = registerBlock(CARPET_ORANGE_A_RESOURCE_LOCATION,      new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_CARPET)));
    public static final Block CARPET_PINK           = registerBlock(CARPET_PINK_RESOURCE_LOCATION,          new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.PINK_CARPET)));
    public static final Block CARPET_PINK_A         = registerBlock(CARPET_PINK_A_RESOURCE_LOCATION,        new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.PINK_CARPET)));
    public static final Block CARPET_PINK_B         = registerBlock(CARPET_PINK_B_RESOURCE_LOCATION,        new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.PINK_CARPET)));
    public static final Block CARPET_PIZZA          = registerBlock(CARPET_PIZZA_RESOURCE_LOCATION,         new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET)));
    public static final Block CARPET_PURPLE         = registerBlock(CARPET_PURPLE_RESOURCE_LOCATION,        new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_CARPET)));
    public static final Block CARPET_PURPLE_A       = registerBlock(CARPET_PURPLE_A_RESOURCE_LOCATION,      new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_CARPET)));
    public static final Block CARPET_RED            = registerBlock(CARPET_RED_RESOURCE_LOCATION,           new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.RED_CARPET)));
    public static final Block CARPET_RED_A          = registerBlock(CARPET_RED_A_RESOURCE_LOCATION,         new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.RED_CARPET)));
    public static final Block CARPET_WAFFLE         = registerBlock(CARPET_WAFFLE_RESOURCE_LOCATION,        new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CARPET)));
    public static final Block CARPET_WAFFLE_A       = registerBlock(CARPET_WAFFLE_A_RESOURCE_LOCATION,      new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CARPET)));
    public static final Block CARPET_WHITE          = registerBlock(CARPET_WHITE_RESOURCE_LOCATION,         new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CARPET)));
    public static final Block CARPET_WHITE_A        = registerBlock(CARPET_WHITE_A_RESOURCE_LOCATION,       new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CARPET)));
    public static final Block CARPET_YELLOW         = registerBlock(CARPET_YELLOW_RESOURCE_LOCATION,        new BigCarpetBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET)));
    //Rattan Table
    public static final Block RATTAN_TABLE = registerBlock(RATTAN_TABLE_RESOURCE_LOCATION, new RattanTableBlock(AbstractBlock.Settings.create().strength(2.0F).sounds(BlockSoundGroup.WOOD)));
    //Painting Studio Series
    public static final Block EASEL                     = registerBlock(EASEL_RESOURCE_LOCATION,                    new      EaselBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block CANVAS                    = registerBlock(CANVAS_RESOURCE_LOCATION,                   new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_OAK        = registerBlock(PAINTING_FRAME_OAK_RESOURCE_LOCATION,       new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_SPRUCE     = registerBlock(PAINTING_FRAME_SPRUCE_RESOURCE_LOCATION,    new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_JUNGLE     = registerBlock(PAINTING_FRAME_JUNGLE_RESOURCE_LOCATION,    new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_BIRCH      = registerBlock(PAINTING_FRAME_BIRCH_RESOURCE_LOCATION,     new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_ACACIA     = registerBlock(PAINTING_FRAME_ACACIA_RESOURCE_LOCATION,    new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_DARK_OAK   = registerBlock(PAINTING_FRAME_DARK_OAK_RESOURCE_LOCATION,  new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_MANGROVE   = registerBlock(PAINTING_FRAME_MANGROVE_RESOURCE_LOCATION,  new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_CHERRY     = registerBlock(PAINTING_FRAME_CHERRY_RESOURCE_LOCATION,    new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_BAMBOO     = registerBlock(PAINTING_FRAME_BAMBOO_RESOURCE_LOCATION,    new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_PALE_OAK   = registerBlock(PAINTING_FRAME_PALE_OAK_RESOURCE_LOCATION,  new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PAINTING_FRAME_BLACKSTONE = registerBlock(PAINTING_FRAME_BLACKSTONE_RESOURCE_LOCATION,new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block DRAWING_BOARD             = registerBlock(DRAWING_BOARD_RESOURCE_LOCATION,            new     CanvasBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).noCollision().nonOpaque()));
    public static final Block PHOTO_PAPER_WHITE_A       = registerBlock(PHOTO_PAPER_WHITE_A_RESOURCE_LOCATION,      new PhotoPaperBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.STONE).breakInstantly().noCollision().nonOpaque()));
    public static final Block PHOTO_PAPER_WHITE_B       = registerBlock(PHOTO_PAPER_WHITE_B_RESOURCE_LOCATION,      new PhotoPaperBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.STONE).breakInstantly().noCollision().nonOpaque()));
    public static final Block PHOTO_PAPER_WHITE_C       = registerBlock(PHOTO_PAPER_WHITE_C_RESOURCE_LOCATION,      new PhotoPaperBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.STONE).breakInstantly().noCollision().nonOpaque()));
    public static final Block PHOTO_PAPER_BLACK_A       = registerBlock(PHOTO_PAPER_BLACK_A_RESOURCE_LOCATION,      new PhotoPaperBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.STONE).breakInstantly().noCollision().nonOpaque()));
    public static final Block PHOTO_PAPER_BLACK_B       = registerBlock(PHOTO_PAPER_BLACK_B_RESOURCE_LOCATION,      new PhotoPaperBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.STONE).breakInstantly().noCollision().nonOpaque()));
    public static final Block PHOTO_PAPER_BLACK_C       = registerBlock(PHOTO_PAPER_BLACK_C_RESOURCE_LOCATION,      new PhotoPaperBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.STONE).breakInstantly().noCollision().nonOpaque()));
    public static final Block GRID_SHELF_OAK            = registerBlock(GRID_SHELF_OAK_RESOURCE_LOCATION,           new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_SPRUCE         = registerBlock(GRID_SHELF_SPRUCE_RESOURCE_LOCATION,        new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_JUNGLE         = registerBlock(GRID_SHELF_JUNGLE_RESOURCE_LOCATION,        new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_BIRCH          = registerBlock(GRID_SHELF_BIRCH_RESOURCE_LOCATION,         new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_ACACIA         = registerBlock(GRID_SHELF_ACACIA_RESOURCE_LOCATION,        new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_DARK_OAK       = registerBlock(GRID_SHELF_DARK_OAK_RESOURCE_LOCATION,      new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_MANGROVE       = registerBlock(GRID_SHELF_MANGROVE_RESOURCE_LOCATION,      new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_CHERRY         = registerBlock(GRID_SHELF_CHERRY_RESOURCE_LOCATION,        new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_BAMBOO         = registerBlock(GRID_SHELF_BAMBOO_RESOURCE_LOCATION,        new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_PALE_OAK       = registerBlock(GRID_SHELF_PALE_OAK_RESOURCE_LOCATION,      new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block GRID_SHELF_BLACKSTONE     = registerBlock(GRID_SHELF_BLACKSTONE_RESOURCE_LOCATION,    new  GridShelfBlock(AbstractBlock.Settings.create().strength(1.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block PAINT_BRUSH               = registerWithoutItem(PAINT_BRUSH_RESOURCE_LOCATION,        new PaintBrushBlock(AbstractBlock.Settings.create().strength(1.0F).breakInstantly().nonOpaque()));
    public static final Block PAINT_CAN                 = registerBlock(PAINT_CAN_RESOURCE_LOCATION,                new   PaintCanBlock(AbstractBlock.Settings.create().strength(1.0F).breakInstantly().nonOpaque(), 0, 0, 0, 16, 6, 16));
    public static final Block MESSY_PAINT_CAN           = registerBlock(MESSY_PAINT_CAN_RESOURCE_LOCATION,          new DyeablePaintCanBlock(AbstractBlock.Settings.create().strength(1.0F).breakInstantly().nonOpaque(), 0, 0, 0, 16, 6, 16));

    public static Block registerBlock(Identifier resourceLocation, Block block){
        registerBlockItem(resourceLocation, block);
        return Registry.register(Registries.BLOCK, resourceLocation, block);
    }

    public static Block registerWithoutItem(Identifier resourceLocation, Block block){
        return Registry.register(Registries.BLOCK, resourceLocation, block);
    }

    private static Item registerBlockItem(Identifier resourceLocation, Block block){
        return Registry.register(Registries.ITEM, resourceLocation, new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){

    }
}