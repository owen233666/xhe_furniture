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
            ItemGroup.create(TOP, 0).displayName(Text.translatable("creativetab.items"))
                    .icon(() -> {
                        return new ItemStack(Registries.BLOCK.get(new Identifier(XheFurniture.MOD_ID, "hot_cocoa")));
                    })
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.HOT_COCOA);
                    }).build()
    );

    public static void registerItemGroup(){

    }
}
