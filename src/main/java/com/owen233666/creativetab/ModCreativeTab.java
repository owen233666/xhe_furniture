package com.owen233666.creativetab;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.minecraft.item.ItemGroup.Row.TOP;

public class ModCreativeTab {
    public static final ItemGroup ITEM_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(XheFurniture.MOD_ID, "itemtab"),
            ItemGroup.create(TOP, 0).displayName(Text.translatable("xhe_furniture.creativetab.items"))
                    .icon(() -> {
                        return new ItemStack(Registries.BLOCK.get(new Identifier(XheFurniture.MOD_ID, "hot_cocoa")));
                    })
                    .entries((displayContext, entries) -> {
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
                    }).build()
    );

    public static void registerItemGroup(){

    }
}
