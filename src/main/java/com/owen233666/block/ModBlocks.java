package com.owen233666.block;


import com.owen233666.XheFurniture;
import com.owen233666.block.painting.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    //Cups
    public static final ResourceLocation HOT_COCOA_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "hot_cocoa");
    //Shoe Flowerpots
    public static final ResourceLocation WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION  = new ResourceLocation(XheFurniture.MOD_ID, "white_shoe_flowerpot");
    public static final ResourceLocation PINK_SHOE_FLOWERPOT_RESOURCE_LOCATION   = new ResourceLocation(XheFurniture.MOD_ID, "pink_shoe_flowerpot");
    public static final ResourceLocation RED_SHOE_FLOWERPOT_RESOURCE_LOCATION    = new ResourceLocation(XheFurniture.MOD_ID, "red_shoe_flowerpot");
    public static final ResourceLocation GREEN_SHOE_FLOWERPOT_RESOURCE_LOCATION  = new ResourceLocation(XheFurniture.MOD_ID, "green_shoe_flowerpot");
    public static final ResourceLocation YELLOW_SHOE_FLOWERPOT_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "yellow_shoe_flowerpot");
    //Slippers
    public static final ResourceLocation WHITE_BUNNY_SLIPPERS_RESOURCE_LOCATION     = new ResourceLocation(XheFurniture.MOD_ID, "white_bunny_slippers");
    public static final ResourceLocation WHITE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = new ResourceLocation(XheFurniture.MOD_ID, "white_hamsters_slippers");
    public static final ResourceLocation WHITE_BEAR_SLIPPERS_RESOURCE_LOCATION      = new ResourceLocation(XheFurniture.MOD_ID, "white_bear_slippers");
    public static final ResourceLocation BEIGE_BUNNY_SLIPPERS_RESOURCE_LOCATION     = new ResourceLocation(XheFurniture.MOD_ID, "beige_bunny_slippers");
    public static final ResourceLocation BEIGE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = new ResourceLocation(XheFurniture.MOD_ID, "beige_hamsters_slippers");
    public static final ResourceLocation BEIGE_BEAR_SLIPPERS_RESOURCE_LOCATION      = new ResourceLocation(XheFurniture.MOD_ID, "beige_bear_slippers");
    public static final ResourceLocation BROWN_BUNNY_SLIPPERS_RESOURCE_LOCATION     = new ResourceLocation(XheFurniture.MOD_ID, "brown_bunny_slippers");
    public static final ResourceLocation BROWN_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = new ResourceLocation(XheFurniture.MOD_ID, "brown_hamsters_slippers");
    public static final ResourceLocation BROWN_BEAR_SLIPPERS_RESOURCE_LOCATION      = new ResourceLocation(XheFurniture.MOD_ID, "brown_bear_slippers");
    public static final ResourceLocation BLACK_BUNNY_SLIPPERS_RESOURCE_LOCATION     = new ResourceLocation(XheFurniture.MOD_ID, "black_bunny_slippers");
    public static final ResourceLocation BLACK_HAMSTERS_SLIPPERS_RESOURCE_LOCATION  = new ResourceLocation(XheFurniture.MOD_ID, "black_hamsters_slippers");
    public static final ResourceLocation BLACK_BEAR_SLIPPERS_RESOURCE_LOCATION      = new ResourceLocation(XheFurniture.MOD_ID, "black_bear_slippers");
    public static final ResourceLocation CALICO_BUNNY_SLIPPERS_RESOURCE_LOCATION    = new ResourceLocation(XheFurniture.MOD_ID, "calico_bunny_slippers");
    public static final ResourceLocation CALICO_HAMSTERS_SLIPPERS_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "calico_hamsters_slippers");
    public static final ResourceLocation PANDA_SLIPPERS_RESOURCE_LOCATION           = new ResourceLocation(XheFurniture.MOD_ID, "panda_slippers");
    //Carpets
    public static final ResourceLocation CARPET_BLACK_RESOURCE_LOCATION         = new ResourceLocation(XheFurniture.MOD_ID, "carpet_black");
    public static final ResourceLocation CARPET_BLACK_A_RESOURCE_LOCATION       = new ResourceLocation(XheFurniture.MOD_ID, "carpet_black_a");
    public static final ResourceLocation CARPET_BLUE_RESOURCE_LOCATION          = new ResourceLocation(XheFurniture.MOD_ID, "carpet_blue");
    public static final ResourceLocation CARPET_BLUE_A_RESOURCE_LOCATION        = new ResourceLocation(XheFurniture.MOD_ID, "carpet_blue_a");
    public static final ResourceLocation CARPET_BLUE_B_RESOURCE_LOCATION        = new ResourceLocation(XheFurniture.MOD_ID, "carpet_blue_b");
    public static final ResourceLocation CARPET_BROWN_RESOURCE_LOCATION         = new ResourceLocation(XheFurniture.MOD_ID, "carpet_brown");
    public static final ResourceLocation CARPET_BROWN_A_RESOURCE_LOCATION       = new ResourceLocation(XheFurniture.MOD_ID, "carpet_brown_a");
    public static final ResourceLocation CARPET_DEEP_BLUE_RESOURCE_LOCATION     = new ResourceLocation(XheFurniture.MOD_ID, "carpet_deep_blue");
    public static final ResourceLocation CARPET_DEEP_BLUE_A_RESOURCE_LOCATION   = new ResourceLocation(XheFurniture.MOD_ID, "carpet_deep_blue_a");
    public static final ResourceLocation CARPET_DEEP_BLUE_B_RESOURCE_LOCATION   = new ResourceLocation(XheFurniture.MOD_ID, "carpet_deep_blue_b");
    public static final ResourceLocation CARPET_DEEP_GREEN_RESOURCE_LOCATION    = new ResourceLocation(XheFurniture.MOD_ID, "carpet_deep_green");
    public static final ResourceLocation CARPET_DEEP_GREEN_A_RESOURCE_LOCATION  = new ResourceLocation(XheFurniture.MOD_ID, "carpet_deep_green_a");
    public static final ResourceLocation CARPET_DEEP_PURPLE_RESOURCE_LOCATION   = new ResourceLocation(XheFurniture.MOD_ID, "carpet_deep_purple");
    public static final ResourceLocation CARPET_DEEP_PURPLE_A_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "carpet_deep_purple_a");
    public static final ResourceLocation CARPET_FLAPJACK_RESOURCE_LOCATION      = new ResourceLocation(XheFurniture.MOD_ID, "carpet_flapjack");
    public static final ResourceLocation CARPET_FLAPJACK_A_RESOURCE_LOCATION    = new ResourceLocation(XheFurniture.MOD_ID, "carpet_flapjack_a");
    public static final ResourceLocation CARPET_GRAY_RESOURCE_LOCATION          = new ResourceLocation(XheFurniture.MOD_ID, "carpet_gray");
    public static final ResourceLocation CARPET_GRAY_A_RESOURCE_LOCATION        = new ResourceLocation(XheFurniture.MOD_ID, "carpet_gray_a");
    public static final ResourceLocation CARPET_GREEN_RESOURCE_LOCATION         = new ResourceLocation(XheFurniture.MOD_ID, "carpet_green");
    public static final ResourceLocation CARPET_GREEN_A_RESOURCE_LOCATION       =  new ResourceLocation(XheFurniture.MOD_ID, "carpet_green_a");
    public static final ResourceLocation CARPET_LEMON_SLICE_RESOURCE_LOCATION   = new ResourceLocation(XheFurniture.MOD_ID, "carpet_lemon_slice");
    public static final ResourceLocation CARPET_ORANGE_RESOURCE_LOCATION        = new ResourceLocation(XheFurniture.MOD_ID, "carpet_orange");
    public static final ResourceLocation CARPET_ORANGE_A_RESOURCE_LOCATION      = new ResourceLocation(XheFurniture.MOD_ID, "carpet_orange_a");
    public static final ResourceLocation CARPET_PINK_RESOURCE_LOCATION          = new ResourceLocation(XheFurniture.MOD_ID, "carpet_pink");
    public static final ResourceLocation CARPET_PINK_A_RESOURCE_LOCATION        = new ResourceLocation(XheFurniture.MOD_ID, "carpet_pink_a");
    public static final ResourceLocation CARPET_PINK_B_RESOURCE_LOCATION        = new ResourceLocation(XheFurniture.MOD_ID, "carpet_pink_b");
    public static final ResourceLocation CARPET_PIZZA_RESOURCE_LOCATION         = new ResourceLocation(XheFurniture.MOD_ID, "carpet_pizza");
    public static final ResourceLocation CARPET_PURPLE_RESOURCE_LOCATION        = new ResourceLocation(XheFurniture.MOD_ID, "carpet_purple");
    public static final ResourceLocation CARPET_PURPLE_A_RESOURCE_LOCATION      = new ResourceLocation(XheFurniture.MOD_ID, "carpet_purple_a");
    public static final ResourceLocation CARPET_RED_RESOURCE_LOCATION           = new ResourceLocation(XheFurniture.MOD_ID, "carpet_red");
    public static final ResourceLocation CARPET_RED_A_RESOURCE_LOCATION         = new ResourceLocation(XheFurniture.MOD_ID, "carpet_red_a");
    public static final ResourceLocation CARPET_WAFFLE_RESOURCE_LOCATION        = new ResourceLocation(XheFurniture.MOD_ID, "carpet_waffle");
    public static final ResourceLocation CARPET_WAFFLE_A_RESOURCE_LOCATION      = new ResourceLocation(XheFurniture.MOD_ID, "carpet_waffle_a");
    public static final ResourceLocation CARPET_WHITE_RESOURCE_LOCATION         = new ResourceLocation(XheFurniture.MOD_ID, "carpet_white");
    public static final ResourceLocation CARPET_WHITE_A_RESOURCE_LOCATION       = new ResourceLocation(XheFurniture.MOD_ID, "carpet_white_a");
    public static final ResourceLocation CARPET_YELLOW_RESOURCE_LOCATION        = new ResourceLocation(XheFurniture.MOD_ID, "carpet_yellow");
    //Rattan Table
    public static final ResourceLocation RATTAN_TABLE_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "rattan_table");
    //Painting Studio Series
    public static final ResourceLocation EASEL_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "easel");
    public static final ResourceLocation CANVAS_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "canvas");
    public static final ResourceLocation PAINTING_FRAME_OAK_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame");
    public static final ResourceLocation PAINTING_FRAME_SPRUCE_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_spruce");
    public static final ResourceLocation PAINTING_FRAME_BIRCH_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_birch");
    public static final ResourceLocation PAINTING_FRAME_JUNGLE_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_jungle");
    public static final ResourceLocation PAINTING_FRAME_ACACIA_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_acacia");
    public static final ResourceLocation PAINTING_FRAME_DARK_OAK_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_dark_oak");
    public static final ResourceLocation PAINTING_FRAME_MANGROVE_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_mangrove");
    public static final ResourceLocation PAINTING_FRAME_CHERRY_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_cherry");
    public static final ResourceLocation PAINTING_FRAME_BAMBOO_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_bamboo");
    public static final ResourceLocation PAINTING_FRAME_PALE_OAK_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_palm");
    public static final ResourceLocation PAINTING_FRAME_BLACKSTONE_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_blackstone");
    public static final ResourceLocation DRAWING_BOARD_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "drawing_board");
    public static final ResourceLocation PHOTO_PAPER_WHITE_A_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "photo_paper_white_a");
    public static final ResourceLocation PHOTO_PAPER_WHITE_B_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "photo_paper_white_b");
    public static final ResourceLocation PHOTO_PAPER_WHITE_C_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "photo_paper_white_c");
    public static final ResourceLocation PHOTO_PAPER_BLACK_A_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "photo_paper_black_a");
    public static final ResourceLocation PHOTO_PAPER_BLACK_B_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "photo_paper_black_b");
    public static final ResourceLocation PHOTO_PAPER_BLACK_C_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "photo_paper_black_c");
    public static final ResourceLocation GRID_SHELF_OAK_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_oak");
    public static final ResourceLocation GRID_SHELF_SPRUCE_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_spruce");
    public static final ResourceLocation GRID_SHELF_BIRCH_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_birch");
    public static final ResourceLocation GRID_SHELF_JUNGLE_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_jungle");
    public static final ResourceLocation GRID_SHELF_ACACIA_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_acacia");
    public static final ResourceLocation GRID_SHELF_DARK_OAK_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_dark_oak");
    public static final ResourceLocation GRID_SHELF_MANGROVE_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_mangrove");
    public static final ResourceLocation GRID_SHELF_CHERRY_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID,"grid_shelf_cherry");
    public static final ResourceLocation GRID_SHELF_BAMBOO_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_bamboo");
    public static final ResourceLocation GRID_SHELF_PALE_OAK_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_pale_oak");
    public static final ResourceLocation GRID_SHELF_BLACKSTONE_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_blackstone");
    public static final ResourceLocation PAINT_BRUSH_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "paint_brush");
    public static final ResourceLocation PAINT_CAN_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "paint_can");
    public static final ResourceLocation MESSY_PAINT_CAN_RESOURCE_LOCATION = new ResourceLocation(XheFurniture.MOD_ID, "messy_paint_can");


    //Cups
    public static final Block HOT_COCOA = registerBlock(HOT_COCOA_RESOURCE_LOCATION, new CupBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.0F, 0.0F).instabreak().sound(SoundType.STONE).noCollission()));
    //Shoe Flowerpots
    public static final Block WHITE_SHOE_FLOWERPOT  = registerBlock(WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION,  new ShoeFlowerPotBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final Block PINK_SHOE_FLOWERPOT   = registerBlock(PINK_SHOE_FLOWERPOT_RESOURCE_LOCATION,   new ShoeFlowerPotBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final Block RED_SHOE_FLOWERPOT    = registerBlock(RED_SHOE_FLOWERPOT_RESOURCE_LOCATION,    new ShoeFlowerPotBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final Block GREEN_SHOE_FLOWERPOT  = registerBlock(GREEN_SHOE_FLOWERPOT_RESOURCE_LOCATION,  new ShoeFlowerPotBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final Block YELLOW_SHOE_FLOWERPOT = registerBlock(YELLOW_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    //Slippers
    public static final Block WHITE_BUNNY_SLIPPERS     = registerBlock(WHITE_BUNNY_SLIPPERS_RESOURCE_LOCATION,      new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block WHITE_HAMSTERS_SLIPPERS  = registerBlock(WHITE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,   new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block WHITE_BEAR_SLIPPERS      = registerBlock(WHITE_BEAR_SLIPPERS_RESOURCE_LOCATION,       new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block BEIGE_BUNNY_SLIPPERS     = registerBlock(BEIGE_BUNNY_SLIPPERS_RESOURCE_LOCATION,      new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block BEIGE_HAMSTERS_SLIPPERS  = registerBlock(BEIGE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,   new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block BEIGE_BEAR_SLIPPERS      = registerBlock(BEIGE_BEAR_SLIPPERS_RESOURCE_LOCATION,       new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block BROWN_BUNNY_SLIPPERS     = registerBlock(BROWN_BUNNY_SLIPPERS_RESOURCE_LOCATION,      new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block BROWN_HAMSTERS_SLIPPERS  = registerBlock(BROWN_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,   new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block BROWN_BEAR_SLIPPERS      = registerBlock(BROWN_BEAR_SLIPPERS_RESOURCE_LOCATION,       new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block BLACK_BUNNY_SLIPPERS     = registerBlock(BLACK_BUNNY_SLIPPERS_RESOURCE_LOCATION,      new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block BLACK_HAMSTERS_SLIPPERS  = registerBlock(BLACK_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,   new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block BLACK_BEAR_SLIPPERS      = registerBlock(BLACK_BEAR_SLIPPERS_RESOURCE_LOCATION,       new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block CALICO_BUNNY_SLIPPERS    = registerBlock(CALICO_BUNNY_SLIPPERS_RESOURCE_LOCATION,     new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block CALICO_HAMSTERS_SLIPPERS = registerBlock(CALICO_HAMSTERS_SLIPPERS_RESOURCE_LOCATION,  new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    public static final Block PANDA_SLIPPERS           = registerBlock(PANDA_SLIPPERS_RESOURCE_LOCATION,            new SlippersBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL).noCollission()));
    //Carpets
    public static final Block CARPET_BLACK          = registerBlock(CARPET_BLACK_RESOURCE_LOCATION,         new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CARPET)));
    public static final Block CARPET_BLACK_A        = registerBlock(CARPET_BLACK_A_RESOURCE_LOCATION,       new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CARPET)));
    public static final Block CARPET_BLUE           = registerBlock(CARPET_BLUE_RESOURCE_LOCATION,          new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CARPET)));
    public static final Block CARPET_BLUE_A         = registerBlock(CARPET_BLUE_A_RESOURCE_LOCATION,        new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CARPET)));
    public static final Block CARPET_BLUE_B         = registerBlock(CARPET_BLUE_B_RESOURCE_LOCATION,        new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CARPET)));
    public static final Block CARPET_BROWN          = registerBlock(CARPET_BROWN_RESOURCE_LOCATION,         new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CARPET)));
    public static final Block CARPET_BROWN_A        = registerBlock(CARPET_BROWN_A_RESOURCE_LOCATION,       new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CARPET)));
    public static final Block CARPET_DEEP_BLUE      = registerBlock(CARPET_DEEP_BLUE_RESOURCE_LOCATION,     new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CARPET)));
    public static final Block CARPET_DEEP_BLUE_A    = registerBlock(CARPET_DEEP_BLUE_A_RESOURCE_LOCATION,   new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CARPET)));
    public static final Block CARPET_DEEP_BLUE_B    = registerBlock(CARPET_DEEP_BLUE_B_RESOURCE_LOCATION,   new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CARPET)));
    public static final Block CARPET_DEEP_GREEN     = registerBlock(CARPET_DEEP_GREEN_RESOURCE_LOCATION,    new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CARPET)));
    public static final Block CARPET_DEEP_GREEN_A   = registerBlock(CARPET_DEEP_GREEN_A_RESOURCE_LOCATION,  new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CARPET)));
    public static final Block CARPET_DEEP_PURPLE    = registerBlock(CARPET_DEEP_PURPLE_RESOURCE_LOCATION,   new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CARPET)));
    public static final Block CARPET_DEEP_PURPLE_A  = registerBlock(CARPET_DEEP_PURPLE_A_RESOURCE_LOCATION, new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CARPET)));
    public static final Block CARPET_FLAPJACK       = registerBlock(CARPET_FLAPJACK_RESOURCE_LOCATION,      new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CARPET)));
    public static final Block CARPET_FLAPJACK_A     = registerBlock(CARPET_FLAPJACK_A_RESOURCE_LOCATION,    new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CARPET)));
    public static final Block CARPET_GRAY           = registerBlock(CARPET_GRAY_RESOURCE_LOCATION,          new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CARPET)));
    public static final Block CARPET_GRAY_A         = registerBlock(CARPET_GRAY_A_RESOURCE_LOCATION,        new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CARPET)));
    public static final Block CARPET_GREEN          = registerBlock(CARPET_GREEN_RESOURCE_LOCATION,         new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CARPET)));
    public static final Block CARPET_GREEN_A        = registerBlock(CARPET_GREEN_A_RESOURCE_LOCATION,       new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CARPET)));
    public static final Block CARPET_LEMON_SLICE    = registerBlock(CARPET_LEMON_SLICE_RESOURCE_LOCATION,   new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CARPET)));
    public static final Block CARPET_ORANGE         = registerBlock(CARPET_ORANGE_RESOURCE_LOCATION,        new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CARPET)));
    public static final Block CARPET_ORANGE_A       = registerBlock(CARPET_ORANGE_A_RESOURCE_LOCATION,      new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CARPET)));
    public static final Block CARPET_PINK           = registerBlock(CARPET_PINK_RESOURCE_LOCATION,          new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CARPET)));
    public static final Block CARPET_PINK_A         = registerBlock(CARPET_PINK_A_RESOURCE_LOCATION,        new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CARPET)));
    public static final Block CARPET_PINK_B         = registerBlock(CARPET_PINK_B_RESOURCE_LOCATION,        new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CARPET)));
    public static final Block CARPET_PIZZA          = registerBlock(CARPET_PIZZA_RESOURCE_LOCATION,         new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CARPET)));
    public static final Block CARPET_PURPLE         = registerBlock(CARPET_PURPLE_RESOURCE_LOCATION,        new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CARPET)));
    public static final Block CARPET_PURPLE_A       = registerBlock(CARPET_PURPLE_A_RESOURCE_LOCATION,      new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CARPET)));
    public static final Block CARPET_RED            = registerBlock(CARPET_RED_RESOURCE_LOCATION,           new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.RED_CARPET)));
    public static final Block CARPET_RED_A          = registerBlock(CARPET_RED_A_RESOURCE_LOCATION,         new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.RED_CARPET)));
    public static final Block CARPET_WAFFLE         = registerBlock(CARPET_WAFFLE_RESOURCE_LOCATION,        new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CARPET)));
    public static final Block CARPET_WAFFLE_A       = registerBlock(CARPET_WAFFLE_A_RESOURCE_LOCATION,      new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CARPET)));
    public static final Block CARPET_WHITE          = registerBlock(CARPET_WHITE_RESOURCE_LOCATION,         new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));
    public static final Block CARPET_WHITE_A        = registerBlock(CARPET_WHITE_A_RESOURCE_LOCATION,       new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));
    public static final Block CARPET_YELLOW         = registerBlock(CARPET_YELLOW_RESOURCE_LOCATION,        new BigCarpetBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CARPET)));
    //Rattan Table
    public static final Block RATTAN_TABLE = registerBlock(RATTAN_TABLE_RESOURCE_LOCATION, new RattanTableBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)));
    //Painting Studio Series
    public static final Block EASEL                     = registerBlock(EASEL_RESOURCE_LOCATION,                    new      EaselBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block CANVAS                    = registerBlock(CANVAS_RESOURCE_LOCATION,                   new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_OAK        = registerBlock(PAINTING_FRAME_OAK_RESOURCE_LOCATION,       new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_SPRUCE     = registerBlock(PAINTING_FRAME_SPRUCE_RESOURCE_LOCATION,    new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_JUNGLE     = registerBlock(PAINTING_FRAME_JUNGLE_RESOURCE_LOCATION,    new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_BIRCH      = registerBlock(PAINTING_FRAME_BIRCH_RESOURCE_LOCATION,     new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_ACACIA     = registerBlock(PAINTING_FRAME_ACACIA_RESOURCE_LOCATION,    new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_DARK_OAK   = registerBlock(PAINTING_FRAME_DARK_OAK_RESOURCE_LOCATION,  new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_MANGROVE   = registerBlock(PAINTING_FRAME_MANGROVE_RESOURCE_LOCATION,  new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_CHERRY     = registerBlock(PAINTING_FRAME_CHERRY_RESOURCE_LOCATION,    new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_BAMBOO     = registerBlock(PAINTING_FRAME_BAMBOO_RESOURCE_LOCATION,    new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_PALE_OAK   = registerBlock(PAINTING_FRAME_PALE_OAK_RESOURCE_LOCATION,  new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PAINTING_FRAME_BLACKSTONE = registerBlock(PAINTING_FRAME_BLACKSTONE_RESOURCE_LOCATION,new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block DRAWING_BOARD             = registerBlock(DRAWING_BOARD_RESOURCE_LOCATION,            new     CanvasBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission().noOcclusion()));
    public static final Block PHOTO_PAPER_WHITE_A       = registerBlock(PHOTO_PAPER_WHITE_A_RESOURCE_LOCATION,      new PhotoPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Block PHOTO_PAPER_WHITE_B       = registerBlock(PHOTO_PAPER_WHITE_B_RESOURCE_LOCATION,      new PhotoPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Block PHOTO_PAPER_WHITE_C       = registerBlock(PHOTO_PAPER_WHITE_C_RESOURCE_LOCATION,      new PhotoPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Block PHOTO_PAPER_BLACK_A       = registerBlock(PHOTO_PAPER_BLACK_A_RESOURCE_LOCATION,      new PhotoPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Block PHOTO_PAPER_BLACK_B       = registerBlock(PHOTO_PAPER_BLACK_B_RESOURCE_LOCATION,      new PhotoPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Block PHOTO_PAPER_BLACK_C       = registerBlock(PHOTO_PAPER_BLACK_C_RESOURCE_LOCATION,      new PhotoPaperBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE).instabreak().noCollission().noOcclusion()));
    public static final Block GRID_SHELF_OAK            = registerBlock(GRID_SHELF_OAK_RESOURCE_LOCATION,           new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_SPRUCE         = registerBlock(GRID_SHELF_SPRUCE_RESOURCE_LOCATION,        new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_JUNGLE         = registerBlock(GRID_SHELF_JUNGLE_RESOURCE_LOCATION,        new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_BIRCH          = registerBlock(GRID_SHELF_BIRCH_RESOURCE_LOCATION,         new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_ACACIA         = registerBlock(GRID_SHELF_ACACIA_RESOURCE_LOCATION,        new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_DARK_OAK       = registerBlock(GRID_SHELF_DARK_OAK_RESOURCE_LOCATION,      new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_MANGROVE       = registerBlock(GRID_SHELF_MANGROVE_RESOURCE_LOCATION,      new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_CHERRY         = registerBlock(GRID_SHELF_CHERRY_RESOURCE_LOCATION,        new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_BAMBOO         = registerBlock(GRID_SHELF_BAMBOO_RESOURCE_LOCATION,        new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_PALE_OAK       = registerBlock(GRID_SHELF_PALE_OAK_RESOURCE_LOCATION,      new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block GRID_SHELF_BLACKSTONE     = registerBlock(GRID_SHELF_BLACKSTONE_RESOURCE_LOCATION,    new  GridShelfBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final Block PAINT_BRUSH               = registerWithoutItem(PAINT_BRUSH_RESOURCE_LOCATION,        new PaintBrushBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().noOcclusion()));
    public static final Block PAINT_CAN                 = registerBlock(PAINT_CAN_RESOURCE_LOCATION,                new   PaintCanBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().noOcclusion(), 0, 0, 0, 16, 6, 16));
    public static final Block MESSY_PAINT_CAN           = registerBlock(MESSY_PAINT_CAN_RESOURCE_LOCATION,          new DyeablePaintCanBlock(BlockBehaviour.Properties.of().strength(1.0F).instabreak().noOcclusion(), 0, 0, 0, 16, 6, 16));

    public static Block registerBlock(ResourceLocation resourceLocation, Block block){
        registerBlockItem(resourceLocation, block);
        return Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block);
    }

    public static Block registerWithoutItem(ResourceLocation resourceLocation, Block block){
        return Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block);
    }

    private static Item registerBlockItem(ResourceLocation resourceLocation, Block block){
        return Registry.register(BuiltInRegistries.ITEM, resourceLocation, new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){

    }
}