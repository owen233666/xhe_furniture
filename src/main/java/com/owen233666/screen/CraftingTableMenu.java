/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.screen;

import com.owen233666.block.ModBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class CraftingTableMenu extends StonecutterMenu {

    /**
     * Remembered locally on purpose: {@code StonecutterMenu.access} is private in vanilla, and
     * reaching for it would tie this class to the Fabric access widener. Access wideners are not
     * applied on Forge-like platforms, so the value passed to the super constructor is kept here.
     */
    private final ContainerLevelAccess furnitureCraftingTableAccess;

    private static final Set<Block> VALID_BLOCKS = Set.of(
            ModBlocks.FURNITURE_CRAFTING_TABLE_OAK.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_SPRUCE.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_JUNGLE.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_BIRCH.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_ACACIA.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_DARK_OAK.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_MANGROVE.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_CHERRY.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_BAMBOO.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_PALE_OAK.get(),
            ModBlocks.FURNITURE_CRAFTING_TABLE_BLACKSTONE.get()
    );

    public CraftingTableMenu(int id, Inventory inventory, ContainerLevelAccess access) {
        super(id, inventory, access);
        this.furnitureCraftingTableAccess = access;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.furnitureCraftingTableAccess.evaluate((level, pos) ->
                        VALID_BLOCKS.contains(level.getBlockState(pos).getBlock()) &&
                                player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64.0,
                true
        );
    }
}
