package com.owen233666.screen;

import com.owen233666.item.KitItem;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class KitMenu extends AbstractContainerMenu {

    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;

    private final ContainerLevelAccess access;
    private final DataSlot selectedIndex = DataSlot.standalone();
    private final List<ItemStack> results = new ArrayList<>();
    private final ResultContainer resultContainer = new ResultContainer();
    private final Slot inputSlot;
    private final Slot resultSlot;
    private Runnable slotUpdateListener = () -> {
    };

    public final SimpleContainer input = new SimpleContainer(1) {
        @Override
        public void setChanged() {
            super.setChanged();
            slotsChanged(KitMenu.this.input);
            slotUpdateListener.run();
        }
    };

    public KitMenu(int id, Inventory inventory) {
        this(id, inventory, ContainerLevelAccess.NULL);
    }

    public KitMenu(int id, Inventory inventory, ContainerLevelAccess access) {
        super(ModMenus.KIT_MENU, id);
        this.access = access;
        this.selectedIndex.set(-1);
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 33) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public boolean mayPickup(Player player) {
                return false;
            }
        });
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                super.onTake(player, stack);

                stack.onCraftedBy(player.level(), player, 1);

                ItemStack inputStack = input.getItem(0);
                if (!inputStack.isEmpty()) {
                    inputStack.shrink(1);
                    input.setItem(0, inputStack.isEmpty() ? ItemStack.EMPTY : inputStack);
                }

                access.execute((level, pos) -> level.levelEvent(1045, pos, 0));
            }
        });
        this.addDataSlot(this.selectedIndex);

        for (int l = 0; l < 3; ++l) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + l * 9 + 9, 8 + j * 18, 84 + l * 18));
            }
        }
        for (int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(inventory, l, 8 + l * 18, 142));
        }
    }

    public void setInput(ItemStack stack) {
        this.input.setItem(0, stack);
        this.slotsChanged(this.input);
    }

    public void registerUpdateListener(Runnable listener) {
        this.slotUpdateListener = listener;
    }

    @Override
    public void slotsChanged(Container container) {
        this.setupResults(container);
        if (!this.isValidIndex(this.selectedIndex.get())) {
            this.selectedIndex.set(-1);
        }
        this.setupResult();
        this.broadcastChanges();
        this.slotUpdateListener.run();
    }

    private void setupResults(Container container) {
        this.results.clear();
        ItemStack stack = container.getItem(0);
        if (stack.getItem() instanceof KitItem kit) {
            for (Item item : kit.getOutputs()) {
                this.results.add(new ItemStack(item));
            }
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.results.size();
    }

    @Override
    public boolean clickMenuButton(Player player, int index) {
        if (this.isValidIndex(index)) {
            this.selectedIndex.set(index);
            this.setupResult();
        }
        return true;
    }

    private void setupResult() {
        if (this.isValidIndex(this.selectedIndex.get())) {
            this.resultContainer.setItem(0, this.results.get(this.selectedIndex.get()).copy());
        } else {
            this.resultContainer.setItem(0, ItemStack.EMPTY);
        }
        this.broadcastChanges();
    }

    public List<ItemStack> getResults() {
        return this.results;
    }

    public int getNumResults() {
        return this.results.size();
    }

    public int getSelectedIndex() {
        return this.selectedIndex.get();
    }

    public boolean hasInputItem() {
        return !this.input.getItem(0).isEmpty();
    }

    public Slot getInputSlot() {
        return this.inputSlot;
    }

    public Slot getResultSlot() {
        return this.resultSlot;
    }

    @Override
    public MenuType<?> getType() {
        return ModMenus.KIT_MENU;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clicked(int slotId, int button, ClickType clickType, Player player) {
        if (slotId == RESULT_SLOT && clickType == ClickType.PICKUP && button == 0) {
            if (this.resultSlot.hasItem() && this.getCarried().isEmpty()) {
                this.quickMoveStack(player, RESULT_SLOT);
                return;
            }
        }
        super.clicked(slotId, button, clickType, player);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.input.setItem(0, ItemStack.EMPTY);
        this.broadcastChanges();
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            itemStack = slotStack.copy();
            if (index == RESULT_SLOT) {
                ItemStack resultStack = slotStack.copy();

                if (!this.moveItemStackTo(slotStack, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                if (slotStack.isEmpty()) {
                    slot.set(ItemStack.EMPTY);
                } else {
                    slot.setChanged();
                }
                slot.onTake(player, resultStack);
                slot.onQuickCraft(slotStack, resultStack);

                return resultStack;
            } else if (index != INPUT_SLOT) {
                if (slotStack.getItem() instanceof KitItem) {
                    if (!this.moveItemStackTo(slotStack, INPUT_SLOT, INPUT_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 2 && index < 29) {
                    if (!this.moveItemStackTo(slotStack, 29, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 29 && index < 38) {
                    if (!this.moveItemStackTo(slotStack, 2, 29, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(slotStack, 2, 38, false)) {
                return ItemStack.EMPTY;
            }
            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (slotStack.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, slotStack);
        }
        return itemStack;
    }
}
