package com.owen233666.creativetab;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import com.owen233666.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab FURNITURE_GROUP = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(XheFurniture.MOD_ID, "xhe_furniture.creativetab.items"),
            FabricItemGroup.builder().title(Component.translatable("xhe_furniture.creativetab.items"))
                    .icon(() -> new ItemStack(BuiltInRegistries.BLOCK.get(new ResourceLocation(XheFurniture.MOD_ID, "hot_cocoa"))))
                    .displayItems(((displayContext, entries) -> {
                        //Cups
                        entries.accept(ModBlocks.HOT_COCOA);
                        //Shoe Flowerpots
                        entries.accept(ModBlocks.WHITE_SHOE_FLOWERPOT);
                        entries.accept(ModBlocks.PINK_SHOE_FLOWERPOT);
                        entries.accept(ModBlocks.RED_SHOE_FLOWERPOT);
                        entries.accept(ModBlocks.GREEN_SHOE_FLOWERPOT);
                        entries.accept(ModBlocks.YELLOW_SHOE_FLOWERPOT);
                        //Slippers
                        entries.accept(ModBlocks.WHITE_BUNNY_SLIPPERS);
                        entries.accept(ModBlocks.WHITE_HAMSTERS_SLIPPERS);
                        entries.accept(ModBlocks.WHITE_BEAR_SLIPPERS);
                        entries.accept(ModBlocks.BEIGE_BUNNY_SLIPPERS);
                        entries.accept(ModBlocks.BEIGE_HAMSTERS_SLIPPERS);
                        entries.accept(ModBlocks.BEIGE_BEAR_SLIPPERS);
                        entries.accept(ModBlocks.BROWN_BUNNY_SLIPPERS);
                        entries.accept(ModBlocks.BROWN_HAMSTERS_SLIPPERS);
                        entries.accept(ModBlocks.BROWN_BEAR_SLIPPERS);
                        entries.accept(ModBlocks.BLACK_BUNNY_SLIPPERS);
                        entries.accept(ModBlocks.BLACK_HAMSTERS_SLIPPERS);
                        entries.accept(ModBlocks.BLACK_BEAR_SLIPPERS);
                        entries.accept(ModBlocks.CALICO_BUNNY_SLIPPERS);
                        entries.accept(ModBlocks.CALICO_HAMSTERS_SLIPPERS);
                        entries.accept(ModBlocks.PANDA_SLIPPERS);
                        //Carpets
                        entries.accept(ModBlocks.CARPET_BLACK);
                        entries.accept(ModBlocks.CARPET_BLACK_A);
                        entries.accept(ModBlocks.CARPET_BLUE);
                        entries.accept(ModBlocks.CARPET_BLUE_A);
                        entries.accept(ModBlocks.CARPET_BLUE_B);
                        entries.accept(ModBlocks.CARPET_BROWN);
                        entries.accept(ModBlocks.CARPET_BROWN_A);
                        entries.accept(ModBlocks.CARPET_DEEP_BLUE);
                        entries.accept(ModBlocks.CARPET_DEEP_BLUE_A);
                        entries.accept(ModBlocks.CARPET_DEEP_BLUE_B);
                        entries.accept(ModBlocks.CARPET_DEEP_GREEN);
                        entries.accept(ModBlocks.CARPET_DEEP_GREEN_A);
                        entries.accept(ModBlocks.CARPET_DEEP_PURPLE);
                        entries.accept(ModBlocks.CARPET_DEEP_PURPLE_A);
                        entries.accept(ModBlocks.CARPET_FLAPJACK);
                        entries.accept(ModBlocks.CARPET_FLAPJACK_A);
                        entries.accept(ModBlocks.CARPET_GRAY);
                        entries.accept(ModBlocks.CARPET_GRAY_A);
                        entries.accept(ModBlocks.CARPET_GREEN);
                        entries.accept(ModBlocks.CARPET_GREEN_A);
                        entries.accept(ModBlocks.CARPET_LEMON_SLICE);
                        entries.accept(ModBlocks.CARPET_ORANGE);
                        entries.accept(ModBlocks.CARPET_ORANGE_A);
                        entries.accept(ModBlocks.CARPET_PINK);
                        entries.accept(ModBlocks.CARPET_PINK_A);
                        entries.accept(ModBlocks.CARPET_PINK_B);
                        entries.accept(ModBlocks.CARPET_PIZZA);
                        entries.accept(ModBlocks.CARPET_PURPLE);
                        entries.accept(ModBlocks.CARPET_PURPLE_A);
                        entries.accept(ModBlocks.CARPET_RED);
                        entries.accept(ModBlocks.CARPET_RED_A);
                        entries.accept(ModBlocks.CARPET_WAFFLE);
                        entries.accept(ModBlocks.CARPET_WAFFLE_A);
                        entries.accept(ModBlocks.CARPET_WHITE);
                        entries.accept(ModBlocks.CARPET_WHITE_A);
                        entries.accept(ModBlocks.CARPET_YELLOW);
                        //Rattan Table
                        entries.accept(ModBlocks.RATTAN_TABLE);
                    })).build()
    );

    public static final CreativeModeTab PAINTINGS = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(XheFurniture.MOD_ID, "xhe_furniture.creativetab.paintings"),
            FabricItemGroup.builder().title(Component.translatable("xhe_furniture.creativetab.paintings")).icon(() -> new ItemStack(BuiltInRegistries.BLOCK.get(new ResourceLocation(XheFurniture.MOD_ID, "hot_cocoa"))))
                    .displayItems(((displayContext, entries) -> {
                        entries.accept(ModItems.PAINT_BRUSH);
                        entries.accept(ModBlocks.EASEL);
                        entries.accept(ModBlocks.CANVAS);
                        entries.accept(ModBlocks.PAINTING_FRAME_OAK);
                        entries.accept(ModBlocks.PAINTING_FRAME_SPRUCE);
                        entries.accept(ModBlocks.PAINTING_FRAME_JUNGLE);
                        entries.accept(ModBlocks.PAINTING_FRAME_BIRCH);
                        entries.accept(ModBlocks.PAINTING_FRAME_ACACIA);
                        entries.accept(ModBlocks.PAINTING_FRAME_DARK_OAK);
                        entries.accept(ModBlocks.PAINTING_FRAME_MANGROVE);
                        entries.accept(ModBlocks.PAINTING_FRAME_CHERRY);
                        entries.accept(ModBlocks.PAINTING_FRAME_BAMBOO);
                        entries.accept(ModBlocks.PAINTING_FRAME_PALE_OAK);
                        entries.accept(ModBlocks.PAINTING_FRAME_BLACKSTONE);
                        entries.accept(ModBlocks.DRAWING_BOARD);
                        entries.accept(ModBlocks.PHOTO_PAPER_WHITE_A);
                        entries.accept(ModBlocks.PHOTO_PAPER_WHITE_B);
                        entries.accept(ModBlocks.PHOTO_PAPER_WHITE_C);
                        entries.accept(ModBlocks.PHOTO_PAPER_BLACK_A);
                        entries.accept(ModBlocks.PHOTO_PAPER_BLACK_B);
                        entries.accept(ModBlocks.PHOTO_PAPER_BLACK_C);
                        entries.accept(ModBlocks.GRID_SHELF_OAK);
                        entries.accept(ModBlocks.GRID_SHELF_SPRUCE);
                        entries.accept(ModBlocks.GRID_SHELF_JUNGLE);
                        entries.accept(ModBlocks.GRID_SHELF_BIRCH);
                        entries.accept(ModBlocks.GRID_SHELF_ACACIA);
                        entries.accept(ModBlocks.GRID_SHELF_DARK_OAK);
                        entries.accept(ModBlocks.GRID_SHELF_MANGROVE);
                        entries.accept(ModBlocks.GRID_SHELF_CHERRY);
                        entries.accept(ModBlocks.GRID_SHELF_BAMBOO);
                        entries.accept(ModBlocks.GRID_SHELF_PALE_OAK);
                        entries.accept(ModBlocks.GRID_SHELF_BLACKSTONE);
                        entries.accept(ModBlocks.PAINT_CAN);
                        entries.accept(ModBlocks.MESSY_PAINT_CAN);
                        entries.accept(ModItems.PAINTING_ANGEL);
                        entries.accept(ModItems.PAINTING_BEDROOM_BED);
                        entries.accept(ModItems.PAINTING_BERRY_BUSH);
                        entries.accept(ModItems.PAINTING_BICHON);
                        entries.accept(ModItems.PAINTING_CAKE);
                        entries.accept(ModItems.PAINTING_CAT_UNDER_A_TREE);
                        entries.accept(ModItems.PAINTING_CHIME);
                        entries.accept(ModItems.PAINTING_CITY_NIGHT);
                        entries.accept(ModItems.PAINTING_CLOVER);
                        entries.accept(ModItems.PAINTING_COW);
                        entries.accept(ModItems.PAINTING_CRYSTAL_FAIRY);
                        entries.accept(ModItems.PAINTING_DESSERT);
                        entries.accept(ModItems.PAINTING_FLOWER_BASKET);
                        entries.accept(ModItems.PAINTING_FLOWERSEA_COTTAGE);
                        entries.accept(ModItems.PAINTING_FRIENDS_PARTY);
                        entries.accept(ModItems.PAINTING_FRUITS_BASKET);
                        entries.accept(ModItems.PAINTING_GARDEN_ENTRANCE);
                        entries.accept(ModItems.PAINTING_GRAMOPHONE);
                        entries.accept(ModItems.PAINTING_GRAVEYARD);
                        entries.accept(ModItems.PAINTING_HARVEST);
                        entries.accept(ModItems.PAINTING_ISLAND);
                        entries.accept(ModItems.PAINTING_KITCHEN_SINK);
                        entries.accept(ModItems.PAINTING_KITE);
                        entries.accept(ModItems.PAINTING_LEMON_SLICE);
                        entries.accept(ModItems.PAINTING_MERMAID);
                        entries.accept(ModItems.PAINTING_MILKYWAY);
                        entries.accept(ModItems.PAINTING_NIGHT_CAMPFIRE);
                        entries.accept(ModItems.PAINTING_PUMPKIN);
                        entries.accept(ModItems.PAINTING_RAINBOW_UNICORN);
                        entries.accept(ModItems.PAINTING_RESTAURANT);
                        entries.accept(ModItems.PAINTING_ROSE_SWING);
                        entries.accept(ModItems.PAINTING_SALTED_LEMON);
                        entries.accept(ModItems.PAINTING_SCENERY);
                        entries.accept(ModItems.PAINTING_SKETCH);
                        entries.accept(ModItems.PAINTING_SNOW_HOUSE);
                        entries.accept(ModItems.PAINTING_STATIONARY_OBJECTS);
                        entries.accept(ModItems.PAINTING_SUMPTUOUS_MEAL);
                        entries.accept(ModItems.PAINTING_SUNSET);
                        entries.accept(ModItems.PAINTING_TEDDY_BEAR);
                        entries.accept(ModItems.PAINTING_TOYS);
                        entries.accept(ModItems.PAINTING_TULIP);
                        entries.accept(ModItems.PAINTING_URBAN_BEAUTY);
                        entries.accept(ModItems.PAINTING_WAVES);
                        entries.accept(ModItems.PAINTING_WHEAT_FIELD);
                        entries.accept(ModItems.PAINTING_WILDFLOWER_PLAIN);
                        entries.accept(ModItems.PAINTING_WORLD_TREE);
                    })).build()
    );

    public static void registerItemGroup(){

    }
}