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
                        entries.add(ModBlocks.HOT_COCOA);
                        entries.add(ModBlocks.WHITE_SHOE_FLOWERPOT);
                        entries.add(ModBlocks.PINK_SHOE_FLOWERPOT);
                        entries.add(ModBlocks.RED_SHOE_FLOWERPOT);
                        entries.add(ModBlocks.GREEN_SHOE_FLOWERPOT);
                        entries.add(ModBlocks.YELLOW_SHOE_FLOWERPOT);
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
                    }).build()
    );

    public static void registerItemGroup(){

    }
}
