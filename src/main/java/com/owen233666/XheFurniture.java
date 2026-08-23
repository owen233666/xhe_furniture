package com.owen233666;

import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.ModBlockEntityTypes;
import com.owen233666.creativetab.ModCreativeTab;
import com.owen233666.item.ModItemTags;
import com.owen233666.item.ModItems;
import com.owen233666.screen.ModMenus;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XheFurniture implements ModInitializer {
	public static final String MOD_ID = "xhe_furniture";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModCreativeTab.registerItemGroup();
		ModBlockEntityTypes.registerBlockEntityTypes();
		ModItemTags.registerModItemTags();
		ModMenus.registerModMenus();
	}
}