package com.owen233666.client.screen;

import com.owen233666.screen.KitMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class KitScreen extends AbstractContainerScreen<KitMenu> {

    private static final ResourceLocation BG = new ResourceLocation("textures/gui/container/stonecutter.png");

    private static final int RECIPES_COLUMNS = 4;
    private static final int RECIPES_ROWS = 3;
    private static final int RECIPES_IMAGE_SIZE_WIDTH = 16;
    private static final int RECIPES_IMAGE_SIZE_HEIGHT = 18;
    private static final int SCROLLER_FULL_HEIGHT = 54;
    private static final int RECIPES_X = 52;
    private static final int RECIPES_Y = 14;
    private static final int MAX_VISIBLE_RECIPES = RECIPES_COLUMNS * RECIPES_ROWS;

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;
    private boolean hadInput;

    public KitScreen(KitMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        menu.registerUpdateListener(this::containerChanged);
        this.containerChanged();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        this.renderBackground(guiGraphics);
        int x = this.leftPos;
        int y = this.topPos;
        guiGraphics.blit(BG, x, y, 0, 0, this.imageWidth, this.imageHeight);

        int scroll = (int) (41.0F * this.scrollOffs);
        guiGraphics.blit(BG, x + 119, y + 15 + scroll, 176 + (this.isScrollBarActive() ? 0 : 12), 0, 12, 15);

        int gridX = x + RECIPES_X;
        int gridY = y + RECIPES_Y;
        this.renderButtons(guiGraphics, mouseX, mouseY, gridX, gridY, this.startIndex + MAX_VISIBLE_RECIPES);
        this.renderRecipes(guiGraphics, gridX, gridY, this.startIndex + MAX_VISIBLE_RECIPES);
    }

    private void renderButtons(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y, int maxIndex) {
        int k = this.startIndex;
        for (; k < maxIndex && k < this.menu.getNumResults(); ++k) {
            int rel = k - this.startIndex;
            int col = rel % RECIPES_COLUMNS;
            int row = rel / RECIPES_COLUMNS;
            int bx = x + col * RECIPES_IMAGE_SIZE_WIDTH;
            int by = y + row * RECIPES_IMAGE_SIZE_HEIGHT + 2;
            int v = this.imageHeight;
            if (k == this.menu.getSelectedIndex()) {
                v += RECIPES_IMAGE_SIZE_HEIGHT;
            } else if (mouseX >= bx && mouseY >= by && mouseX < bx + RECIPES_IMAGE_SIZE_WIDTH && mouseY < by + RECIPES_IMAGE_SIZE_HEIGHT) {
                v += RECIPES_IMAGE_SIZE_HEIGHT * 2;
            }
            guiGraphics.blit(BG, bx, by - 1, 0, v, RECIPES_IMAGE_SIZE_WIDTH, RECIPES_IMAGE_SIZE_HEIGHT);
        }
    }

    private void renderRecipes(GuiGraphics guiGraphics, int x, int y, int maxIndex) {
        List<ItemStack> results = this.menu.getResults();
        for (int k = this.startIndex; k < maxIndex && k < this.menu.getNumResults(); ++k) {
            int rel = k - this.startIndex;
            int col = rel % RECIPES_COLUMNS;
            int row = rel / RECIPES_COLUMNS;
            int ix = x + col * RECIPES_IMAGE_SIZE_WIDTH;
            int iy = y + row * RECIPES_IMAGE_SIZE_HEIGHT + 2;
            guiGraphics.renderItem(results.get(k), ix, iy);
        }
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);
        if (this.displayRecipes) {
            int x = this.leftPos + RECIPES_X;
            int y = this.topPos + RECIPES_Y;
            int maxIndex = this.startIndex + MAX_VISIBLE_RECIPES;
            List<ItemStack> results = this.menu.getResults();
            for (int k = this.startIndex; k < maxIndex && k < this.menu.getNumResults(); ++k) {
                int rel = k - this.startIndex;
                int col = rel % RECIPES_COLUMNS;
                int row = rel / RECIPES_COLUMNS;
                int ix = x + col * RECIPES_IMAGE_SIZE_WIDTH;
                int iy = y + row * RECIPES_IMAGE_SIZE_HEIGHT + 2;
                if (mouseX >= ix && mouseX < ix + RECIPES_IMAGE_SIZE_WIDTH && mouseY >= iy && mouseY < iy + RECIPES_IMAGE_SIZE_HEIGHT) {
                    guiGraphics.renderTooltip(this.font, results.get(k), mouseX, mouseY);
                }
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;
        if (this.displayRecipes) {
            int x = this.leftPos + RECIPES_X;
            int y = this.topPos + RECIPES_Y;
            int maxIndex = this.startIndex + MAX_VISIBLE_RECIPES;
            for (int k = this.startIndex; k < maxIndex; ++k) {
                int rel = k - this.startIndex;
                int col = rel % RECIPES_COLUMNS;
                int row = rel / RECIPES_COLUMNS;
                double dx = mouseX - (double) (x + col * RECIPES_IMAGE_SIZE_WIDTH);
                double dy = mouseY - (double) (y + row * RECIPES_IMAGE_SIZE_HEIGHT + 2);
                if (dx >= 0.0D && dy >= 0.0D && dx < RECIPES_IMAGE_SIZE_WIDTH && dy < RECIPES_IMAGE_SIZE_HEIGHT) {
                    if (this.menu.clickMenuButton(this.minecraft.player, k)) {
                        this.minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                        this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, k);
                        return true;
                    }
                }
            }
            int sbx = this.leftPos + 119;
            int sby = this.topPos + 9;
            if (mouseX >= (double) sbx && mouseX < (double) (sbx + 12) && mouseY >= (double) sby && mouseY < (double) (sby + SCROLLER_FULL_HEIGHT)) {
                this.scrolling = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.scrolling && this.isScrollBarActive()) {
            int minY = this.topPos + RECIPES_Y;
            int maxY = minY + SCROLLER_FULL_HEIGHT;
            this.scrollOffs = Mth.clamp((float) ((mouseY - (double) minY - 7.5D) / (double) ((float) (maxY - minY) - 15.0F)), 0.0F, 1.0F);
            this.startIndex = (int) ((double) (this.scrollOffs * (float) this.getOffscreenRows()) + 0.5D) * RECIPES_COLUMNS;
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        if (this.isScrollBarActive()) {
            int rows = this.getOffscreenRows();
            this.scrollOffs = Mth.clamp(this.scrollOffs - (float) delta / (float) rows, 0.0F, 1.0F);
            this.startIndex = (int) ((double) (this.scrollOffs * (float) rows) + 0.5D) * RECIPES_COLUMNS;
        }
        return true;
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && this.menu.getNumResults() > MAX_VISIBLE_RECIPES;
    }

    protected int getOffscreenRows() {
        return (this.menu.getNumResults() + RECIPES_COLUMNS - 1) / RECIPES_COLUMNS - RECIPES_ROWS;
    }

    private void containerChanged() {
        boolean hasInput = this.menu.hasInputItem();
        this.hadInput = hasInput;
        this.displayRecipes = hasInput;
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
        }
    }
}
