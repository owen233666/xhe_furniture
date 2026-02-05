package com.owen233666.block;


import com.owen233666.XheFurniture;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

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
//    //Christmas Decorations
//    public static final Identifier SPRUCE_TREE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "spruce_tree");
//    public static final Identifier CHRISTMAS_TREE_RESOURCE_LOCATION = new Identifier(XheFurniture.MOD_ID, "christmas_tree");
//    public static final Identifier
    //Carpets


    //Cups
    public static final Block HOT_COCOA = registerBlock(HOT_COCOA_RESOURCE_LOCATION, new CupBlock(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(0.0F, 0.0F).breakInstantly().sounds(BlockSoundGroup.STONE).noCollision()));
    //Shoe Flowerpots
    public static final Block WHITE_SHOE_FLOWERPOT  = registerBlock(WHITE_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    public static final Block PINK_SHOE_FLOWERPOT   = registerBlock(PINK_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    public static final Block RED_SHOE_FLOWERPOT    = registerBlock(RED_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    public static final Block GREEN_SHOE_FLOWERPOT  = registerBlock(GREEN_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    public static final Block YELLOW_SHOE_FLOWERPOT = registerBlock(YELLOW_SHOE_FLOWERPOT_RESOURCE_LOCATION, new ShoeFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    //Slippers
    public static final Block WHITE_BUNNY_SLIPPERS     = registerBlock(WHITE_BUNNY_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block WHITE_HAMSTERS_SLIPPERS  = registerBlock(WHITE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block WHITE_BEAR_SLIPPERS      = registerBlock(WHITE_BEAR_SLIPPERS_RESOURCE_LOCATION,new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BEIGE_BUNNY_SLIPPERS     = registerBlock(BEIGE_BUNNY_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BEIGE_HAMSTERS_SLIPPERS  = registerBlock(BEIGE_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BEIGE_BEAR_SLIPPERS      = registerBlock(BEIGE_BEAR_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BROWN_BUNNY_SLIPPERS     = registerBlock(BROWN_BUNNY_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BROWN_HAMSTERS_SLIPPERS  = registerBlock(BROWN_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BROWN_BEAR_SLIPPERS      = registerBlock(BROWN_BEAR_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BLACK_BUNNY_SLIPPERS     = registerBlock(BLACK_BUNNY_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BLACK_HAMSTERS_SLIPPERS  = registerBlock(BLACK_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block BLACK_BEAR_SLIPPERS      = registerBlock(BLACK_BEAR_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block CALICO_BUNNY_SLIPPERS    = registerBlock(CALICO_BUNNY_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block CALICO_HAMSTERS_SLIPPERS = registerBlock(CALICO_HAMSTERS_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    public static final Block PANDA_SLIPPERS           = registerBlock(PANDA_SLIPPERS_RESOURCE_LOCATION, new SlippersBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).noCollision()));
    //Christmas Decorations
    //Carpets
    public static Block registerBlock(Identifier resourceLocation, Block block){
        registerBlockItem(resourceLocation, block);
        return Registry.register(Registries.BLOCK, resourceLocation, block);
    }

    private static Item registerBlockItem(Identifier resourceLocation, Block block){
        return Registry.register(Registries.ITEM, resourceLocation, new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){

    }
}