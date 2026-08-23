package com.owen233666.screen;

import com.owen233666.item.KitItem;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
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
        // DataSlot.standalone() starts at 0, which would auto-select the first recipe when
        // the GUI opens. Force it to -1 so nothing is selected (and the result slot is
        // empty) until the player explicitly picks a recipe.
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
                // Let the standard slot logic remove the result first.
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
        // Hold the SAME ItemStack object the player's inventory slot holds. The input slot
        // becomes a locked mirror: it shows the kit and stays in sync with the inventory as
        // results are crafted. It is never moved out and never needs to be returned.
        this.input.setItem(0, stack);
        this.slotsChanged(this.input);
    }

    public void registerUpdateListener(Runnable listener) {
        this.slotUpdateListener = listener;
    }

    @Override
    public void slotsChanged(Container container) {
        this.setupResults(container);
        // Keep the current selection while the input still has kits, exactly like the
        // stonecutter: after taking a result the same recipe indexes are re-shown. Only
        // reset the selection when the recipe list no longer contains that index (e.g. the
        // input was emptied).
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
        // A normal left-click on the result slot takes it the same way as shift-click:
        // through quickMoveStack, which moves the result into the player's inventory.
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
        // The kit was never moved out of the inventory: the input slot is just a locked
        // mirror of the same stack. So there is nothing to return here -- writing it back
        // would duplicate it. Drop the menu's reference and re-sync to the client.
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
                // 获取物品副本
                ItemStack resultStack = slotStack.copy();

                // 尝试移动物品
                if (!this.moveItemStackTo(slotStack, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                // 如果物品完全移动了
                if (slotStack.isEmpty()) {
                    slot.set(ItemStack.EMPTY);
                } else {
                    slot.setChanged();
                }

                // 触发 onTake 逻辑
                slot.onTake(player, resultStack);

                // 调用 quickCraft
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
