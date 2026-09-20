/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.item;

import com.owen233666.screen.KitMenu;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Supplier;

public class KitItem extends Item {

    /**
     * Lazily resolved on purpose. The contents are the block items of this mod, obtained via
     * {@code Block#asItem()} -- and that call has to happen only once every block item exists.
     *
     * <p>{@code Block#asItem()} caches its result in a private field: {@code if (item == null)
     * item = Item.byBlock(this)}, and {@code Item.byBlock} falls back to {@code Items.AIR}. On
     * Forge-like loaders our items are registered inside the register event, so resolving these
     * lists in the {@code KitItem} constructor ran while the block items had not been constructed
     * yet. That cached {@code AIR} permanently, which made {@code new ItemStack(someBlock)} an
     * empty count-0 stack and crashed NeoForge's creative-tab build hook with
     * "The stack count must be 1".
     *
     * <p>Holding a supplier moves the resolution to first use (menu open / JEI plugin load),
     * which is always after registration. {@link #getOutputs()} keeps its signature, so callers
     * are unaffected.
     */
    private final Supplier<List<Item>> outputs;

    public KitItem(Properties properties, Supplier<List<Item>> outputs) {
        super(properties);
        this.outputs = outputs;
    }

    public List<Item> getOutputs() {
        return this.outputs.get();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack held = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            player.openMenu(new SimpleMenuProvider((id, inventory, ignored) -> {
                KitMenu menu = new KitMenu(id, inventory, ContainerLevelAccess.NULL);
                menu.setInput(held);
                return menu;
            }, this.getDescription()));
        }
        return InteractionResultHolder.sidedSuccess(held, level.isClientSide());
    }
}
