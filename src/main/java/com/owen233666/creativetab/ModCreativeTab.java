package com.owen233666.creativetab;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import com.owen233666.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTab {
    public static final ItemGroup FURNITURE_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(XheFurniture.MOD_ID, "xhe_furniture.creativetab.items"),
            FabricItemGroup.builder().displayName(Text.translatable("xhe_furniture.creativetab.items"))
                    .icon(() -> new ItemStack(Registries.BLOCK.get(new Identifier(XheFurniture.MOD_ID, "hot_cocoa"))))
                    .entries(((displayContext, entries) -> {
                        //Cups
                        entries.add(ModBlocks.HOT_COCOA);
                        //Shoe Flowerpots
                        entries.add(ModBlocks.WHITE_SHOE_FLOWERPOT);
                        entries.add(ModBlocks.PINK_SHOE_FLOWERPOT);
                        entries.add(ModBlocks.RED_SHOE_FLOWERPOT);
                        entries.add(ModBlocks.GREEN_SHOE_FLOWERPOT);
                        entries.add(ModBlocks.YELLOW_SHOE_FLOWERPOT);
                        //Slippers
                        entries.add(ModBlocks.WHITE_BUNNY_SLIPPERS);
                        entries.add(ModBlocks.WHITE_HAMSTERS_SLIPPERS);
                        entries.add(ModBlocks.WHITE_BEAR_SLIPPERS);
                        entries.add(ModBlocks.BEIGE_BUNNY_SLIPPERS);
                        entries.add(ModBlocks.BEIGE_HAMSTERS_SLIPPERS);
                        entries.add(ModBlocks.BEIGE_BEAR_SLIPPERS);
                        entries.add(ModBlocks.BROWN_BUNNY_SLIPPERS);
                        entries.add(ModBlocks.BROWN_HAMSTERS_SLIPPERS);
                        entries.add(ModBlocks.BROWN_BEAR_SLIPPERS);
                        entries.add(ModBlocks.BLACK_BUNNY_SLIPPERS);
                        entries.add(ModBlocks.BLACK_HAMSTERS_SLIPPERS);
                        entries.add(ModBlocks.BLACK_BEAR_SLIPPERS);
                        entries.add(ModBlocks.CALICO_BUNNY_SLIPPERS);
                        entries.add(ModBlocks.CALICO_HAMSTERS_SLIPPERS);
                        entries.add(ModBlocks.PANDA_SLIPPERS);
                        //Carpets
                        entries.add(ModBlocks.CARPET_BLACK);
                        entries.add(ModBlocks.CARPET_BLACK_A);
                        entries.add(ModBlocks.CARPET_BLUE);
                        entries.add(ModBlocks.CARPET_BLUE_A);
                        entries.add(ModBlocks.CARPET_BLUE_B);
                        entries.add(ModBlocks.CARPET_BROWN);
                        entries.add(ModBlocks.CARPET_BROWN_A);
                        entries.add(ModBlocks.CARPET_DEEP_BLUE);
                        entries.add(ModBlocks.CARPET_DEEP_BLUE_A);
                        entries.add(ModBlocks.CARPET_DEEP_BLUE_B);
                        entries.add(ModBlocks.CARPET_DEEP_GREEN);
                        entries.add(ModBlocks.CARPET_DEEP_GREEN_A);
                        entries.add(ModBlocks.CARPET_DEEP_PURPLE);
                        entries.add(ModBlocks.CARPET_DEEP_PURPLE_A);
                        entries.add(ModBlocks.CARPET_FLAPJACK);
                        entries.add(ModBlocks.CARPET_FLAPJACK_A);
                        entries.add(ModBlocks.CARPET_GRAY);
                        entries.add(ModBlocks.CARPET_GRAY_A);
                        entries.add(ModBlocks.CARPET_GREEN);
                        entries.add(ModBlocks.CARPET_GREEN_A);
                        entries.add(ModBlocks.CARPET_LEMON_SLICE);
                        entries.add(ModBlocks.CARPET_ORANGE);
                        entries.add(ModBlocks.CARPET_ORANGE_A);
                        entries.add(ModBlocks.CARPET_PINK);
                        entries.add(ModBlocks.CARPET_PINK_A);
                        entries.add(ModBlocks.CARPET_PINK_B);
                        entries.add(ModBlocks.CARPET_PIZZA);
                        entries.add(ModBlocks.CARPET_PURPLE);
                        entries.add(ModBlocks.CARPET_PURPLE_A);
                        entries.add(ModBlocks.CARPET_RED);
                        entries.add(ModBlocks.CARPET_RED_A);
                        entries.add(ModBlocks.CARPET_WAFFLE);
                        entries.add(ModBlocks.CARPET_WAFFLE_A);
                        entries.add(ModBlocks.CARPET_WHITE);
                        entries.add(ModBlocks.CARPET_WHITE_A);
                        entries.add(ModBlocks.CARPET_YELLOW);
                        //Rattan Table
                        entries.add(ModBlocks.RATTAN_TABLE);
                    })).build()
    );

    public static final ItemGroup PAINTINGS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(XheFurniture.MOD_ID, "xhe_furniture.creativetab.paintings"),
            FabricItemGroup.builder().displayName(Text.translatable("xhe_furniture.creativetab.paintings")).icon(() -> new ItemStack(Registries.BLOCK.get(new Identifier(XheFurniture.MOD_ID, "hot_cocoa"))))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.PAINT_BRUSH);
                        entries.add(ModBlocks.EASEL);
                        entries.add(ModBlocks.CANVAS);
                        entries.add(ModBlocks.PAINTING_FRAME_OAK);
                        entries.add(ModBlocks.PAINTING_FRAME_SPRUCE);
                        entries.add(ModBlocks.PAINTING_FRAME_JUNGLE);
                        entries.add(ModBlocks.PAINTING_FRAME_BIRCH);
                        entries.add(ModBlocks.PAINTING_FRAME_ACACIA);
                        entries.add(ModBlocks.PAINTING_FRAME_DARK_OAK);
                        entries.add(ModBlocks.PAINTING_FRAME_MANGROVE);
                        entries.add(ModBlocks.PAINTING_FRAME_CHERRY);
                        entries.add(ModBlocks.PAINTING_FRAME_BAMBOO);
                        entries.add(ModBlocks.PAINTING_FRAME_PALE_OAK);
                        entries.add(ModBlocks.PAINTING_FRAME_BLACKSTONE);
                        entries.add(ModBlocks.DRAWING_BOARD);
                        entries.add(ModBlocks.PHOTO_PAPER_WHITE_A);
                        entries.add(ModBlocks.PHOTO_PAPER_WHITE_B);
                        entries.add(ModBlocks.PHOTO_PAPER_WHITE_C);
                        entries.add(ModBlocks.PHOTO_PAPER_BLACK_A);
                        entries.add(ModBlocks.PHOTO_PAPER_BLACK_B);
                        entries.add(ModBlocks.PHOTO_PAPER_BLACK_C);
                        entries.add(ModBlocks.GRID_SHELF_OAK);
                        entries.add(ModBlocks.GRID_SHELF_SPRUCE);
                        entries.add(ModBlocks.GRID_SHELF_JUNGLE);
                        entries.add(ModBlocks.GRID_SHELF_BIRCH);
                        entries.add(ModBlocks.GRID_SHELF_ACACIA);
                        entries.add(ModBlocks.GRID_SHELF_DARK_OAK);
                        entries.add(ModBlocks.GRID_SHELF_MANGROVE);
                        entries.add(ModBlocks.GRID_SHELF_CHERRY);
                        entries.add(ModBlocks.GRID_SHELF_BAMBOO);
                        entries.add(ModBlocks.GRID_SHELF_PALE_OAK);
                        entries.add(ModBlocks.GRID_SHELF_BLACKSTONE);
                        entries.add(ModBlocks.PAINT_CAN);
                        entries.add(ModBlocks.MESSY_PAINT_CAN);
                        entries.add(ModItems.PAINTING_ANGEL);
                        entries.add(ModItems.PAINTING_BEDROOM_BED);
                        entries.add(ModItems.PAINTING_BERRY_BUSH);
                        entries.add(ModItems.PAINTING_BICHON);
                        entries.add(ModItems.PAINTING_CAKE);
                        entries.add(ModItems.PAINTING_CAT_UNDER_A_TREE);
                        entries.add(ModItems.PAINTING_CHIME);
                        entries.add(ModItems.PAINTING_CITY_NIGHT);
                        entries.add(ModItems.PAINTING_CLOVER);
                        entries.add(ModItems.PAINTING_COW);
                        entries.add(ModItems.PAINTING_CRYSTAL_FAIRY);
                        entries.add(ModItems.PAINTING_DESSERT);
                        entries.add(ModItems.PAINTING_FLOWER_BASKET);
                        entries.add(ModItems.PAINTING_FLOWERSEA_COTTAGE);
                        entries.add(ModItems.PAINTING_FRIENDS_PARTY);
                        entries.add(ModItems.PAINTING_FRUITS_BASKET);
                        entries.add(ModItems.PAINTING_GARDEN_ENTRANCE);
                        entries.add(ModItems.PAINTING_GRAMOPHONE);
                        entries.add(ModItems.PAINTING_GRAVEYARD);
                        entries.add(ModItems.PAINTING_HARVEST);
                        entries.add(ModItems.PAINTING_ISLAND);
                        entries.add(ModItems.PAINTING_KITCHEN_SINK);
                        entries.add(ModItems.PAINTING_KITE);
                        entries.add(ModItems.PAINTING_LEMON_SLICE);
                        entries.add(ModItems.PAINTING_MERMAID);
                        entries.add(ModItems.PAINTING_MILKYWAY);
                        entries.add(ModItems.PAINTING_NIGHT_CAMPFIRE);
                        entries.add(ModItems.PAINTING_PUMPKIN);
                        entries.add(ModItems.PAINTING_RAINBOW_UNICORN);
                        entries.add(ModItems.PAINTING_RESTAURANT);
                        entries.add(ModItems.PAINTING_ROSE_SWING);
                        entries.add(ModItems.PAINTING_SALTED_LEMON);
                        entries.add(ModItems.PAINTING_SCENERY);
                        entries.add(ModItems.PAINTING_SKETCH);
                        entries.add(ModItems.PAINTING_SNOW_HOUSE);
                        entries.add(ModItems.PAINTING_STATIONARY_OBJECTS);
                        entries.add(ModItems.PAINTING_SUMPTUOUS_MEAL);
                        entries.add(ModItems.PAINTING_SUNSET);
                        entries.add(ModItems.PAINTING_TEDDY_BEAR);
                        entries.add(ModItems.PAINTING_TOYS);
                        entries.add(ModItems.PAINTING_TULIP);
                        entries.add(ModItems.PAINTING_URBAN_BEAUTY);
                        entries.add(ModItems.PAINTING_WAVES);
                        entries.add(ModItems.PAINTING_WHEAT_FIELD);
                        entries.add(ModItems.PAINTING_WILDFLOWER_PLAIN);
                        entries.add(ModItems.PAINTING_WORLD_TREE);
                    })).build()
    );

    public static void registerItemGroup(){

    }
}