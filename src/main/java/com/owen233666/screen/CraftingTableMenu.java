package com.owen233666.screen;

import com.owen233666.block.ModBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class CraftingTableMenu extends StonecutterMenu {

    private static final Set<Block> VALID_BLOCKS = Set.of(
            ModBlocks.FURNITURE_ORDER_TABLE_OAK,
            ModBlocks.FURNITURE_ORDER_TABLE_SPRUCE,
            ModBlocks.FURNITURE_ORDER_TABLE_JUNGLE,
            ModBlocks.FURNITURE_ORDER_TABLE_BIRCH,
            ModBlocks.FURNITURE_ORDER_TABLE_ACACIA,
            ModBlocks.FURNITURE_ORDER_TABLE_DARK_OAK,
            ModBlocks.FURNITURE_ORDER_TABLE_MANGROVE,
            ModBlocks.FURNITURE_ORDER_TABLE_CHERRY,
            ModBlocks.FURNITURE_ORDER_TABLE_BAMBOO,
            ModBlocks.FURNITURE_ORDER_TABLE_PALE_OAK,
            ModBlocks.FURNITURE_ORDER_TABLE_BLACKSTONE
    );

    public CraftingTableMenu(int id, Inventory inventory, ContainerLevelAccess access) {
        super(id, inventory, access);
    }

    @Override
    public boolean stillValid(Player player) {
        return access.evaluate((level, pos) ->
                        VALID_BLOCKS.contains(level.getBlockState(pos).getBlock()) &&
                                player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64.0,
                true
        );
    }
}