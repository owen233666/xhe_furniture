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

public class KitItem extends Item {

    private final List<Item> outputs;

    public KitItem(Properties properties, List<Item> outputs) {
        super(properties);
        this.outputs = outputs;
    }

    public List<Item> getOutputs() {
        return this.outputs;
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
