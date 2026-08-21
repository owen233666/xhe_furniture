package com.owen233666;

import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.ModBlockEntityTypes;
import com.owen233666.creativetab.ModCreativeTab;
import com.owen233666.item.ModItemTags;
import com.owen233666.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(XheFurniture.MOD_ID)
public class XheFurniture {
	public static final String MOD_ID = "xhe_furniture";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public XheFurniture(IEventBus modEventBus) {
		modEventBus.addListener(RegisterEvent.class, event -> {
			ResourceKey<? extends Registry<?>> key = event.getRegistryKey();
			if (key == Registries.BLOCK) {
				ModBlocks.registerModBlocks();
			} else if (key == Registries.ITEM) {
				ModItems.registerModItems();
			} else if (key == Registries.BLOCK_ENTITY_TYPE) {
				ModBlockEntityTypes.registerBlockEntityTypes();
			} else if (key == Registries.CREATIVE_MODE_TAB) {
				ModCreativeTab.registerItemGroup();
			}
			ModItemTags.registerModItemTags();
		});
	}
}
