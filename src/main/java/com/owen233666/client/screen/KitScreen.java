/*
 * This file is part of the XHeYa's Furniture project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2026  Fallen_Breath and contributors
 *
 * XHeYa's Furniture is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * XHeYa's Furniture is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with XHeYa's Furniture.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.owen233666.client.screen;

import com.owen233666.screen.KitMenu;
import net.minecraft.ChatFormatting;
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

    /** Optional replacement panel art. When {@code null} the frame is drawn procedurally. */
    private static final ResourceLocation TEXTURE = null;
    private static final int TEX_WIDTH = 220;
    private static final int TEX_HEIGHT = 224;

    // ---------------------------------------------------------------------------------------------
    // Geometry
    // ---------------------------------------------------------------------------------------------
    //
    // The panel is wider than the vanilla 176 to fit a 6x4 picker, so the inventory block is centred
    // rather than left-aligned -- at 8 from the left it would leave a visibly larger gap on the
    // right.
    //
    // Across the width: picker 8..108, scrollbar 117..124, showcase 133..211, 8px right margin.
    // Down the height: title 6, slot row 18, picker 38..104, showcase band 38..103, inventory label
    // 129, inventory 140..215, panel 224.
    //
    // Everything downstream of the picker is derived from GRID_COLUMNS, so changing the grid shape
    // moves the scrollbar and showcase with it instead of leaving them pointing at the old layout.

    private static final int PANEL_WIDTH = 220;
    private static final int PANEL_HEIGHT = 224;

    private static final int GRID_COLUMNS = 6;
    private static final int GRID_ROWS = 4;
    private static final int CELL = 16;
    private static final int CELL_STEP = 17;
    private static final int GRID_X = 8;
    private static final int GRID_Y = 38;
    private static final int MAX_VISIBLE = GRID_COLUMNS * GRID_ROWS;

    /** Width of the whole cell block, derived so the scrollbar can sit past it automatically. */
    private static final int GRID_WIDTH = GRID_COLUMNS * CELL_STEP - 1;
    private static final int GRID_HEIGHT = GRID_ROWS * CELL_STEP - 1;

    /**
     * Scrollbar, placed in the gutter just right of the picker.
     *
     * <p>Derived from the grid rather than pinned to a literal: at six columns the cell block is
     * 101 wide, so a fixed {@code 84} -- which was correct for the old four-column grid -- would
     * land on top of the cells.
     */
    private static final int SCROLLBAR_X = GRID_X + GRID_WIDTH + 8;
    private static final int SCROLLBAR_Y = GRID_Y;
    private static final int SCROLLBAR_WIDTH = 8;
    private static final int SCROLLBAR_HEIGHT = GRID_HEIGHT;
    private static final int SCROLLER_HEIGHT = 15;

    /**
     * Showcase: one large rendering of the current selection, with its name and hint stacked
     * underneath.
     *
     * <p>It takes whatever width is left between the scrollbar and the panel's right margin, so it
     * grows with {@link #PANEL_WIDTH} instead of leaving a bare strip. With the panel at 220 that
     * works out as x 133..211.
     */
    private static final int SHOWCASE_X = SCROLLBAR_X + SCROLLBAR_WIDTH + 8;
    private static final int SHOWCASE_Y = GRID_Y;
    private static final int SHOWCASE_WIDTH = PANEL_WIDTH - SHOWCASE_X - 8;
    private static final int SHOWCASE_HEIGHT = PANEL_WIDTH - SHOWCASE_X - 8;
    private static final int SHOWCASE_NAME_Y = SHOWCASE_Y + SHOWCASE_HEIGHT + 3;
    private static final int SHOWCASE_HINT_Y = SHOWCASE_NAME_Y + 10;

    /**
     * Input and result slots, laid out on one row under the title.
     *
     * <p>The geometry is owned by {@link KitMenu}, which is what actually positions the slots and
     * therefore decides where the items render; the frames drawn below are only chrome around those
     * same coordinates. Duplicating the numbers here would let the two drift apart silently.
     */
    private static final int INPUT_SLOT_X = KitMenu.INPUT_SLOT_X;
    private static final int SLOT_Y = KitMenu.SLOT_Y;
    private static final int RESULT_SLOT_X = KitMenu.RESULT_SLOT_X;

    private static final int INVENTORY_X = KitMenu.INVENTORY_X;
    private static final int INVENTORY_Y = KitMenu.INVENTORY_Y;

    /** Largest and smallest on-screen size of the previewed item, in pixels. */
    private static final int SHOWCASE_ITEM_MAX = 48;
    private static final int SHOWCASE_ITEM_MIN = 16;

    // ---------------------------------------------------------------------------------------------
    // Palette. ARGB, matching the vanilla container palette so the screen does not look foreign.
    // ---------------------------------------------------------------------------------------------

    private static final int COL_PANEL = 0xFFC6C6C6;
    private static final int COL_PANEL_DARK = 0xFF8B8B8B;
    private static final int COL_PANEL_LIGHT = 0xFFFFFFFF;
    private static final int COL_SLOT = 0xFF8B8B8B;
    private static final int COL_SLOT_INNER = 0xFF373737;
    private static final int COL_WELL = 0xFF2B2B2B;
    private static final int COL_WELL_EDGE = 0xFF1A1A1A;
    private static final int COL_CELL = 0xFF9E9E9E;
    private static final int COL_CELL_HOVER = 0xFFC5C5C5;
    private static final int COL_CELL_SELECTED = 0xFF5C9CF5;
    private static final int COL_TEXT = 0xFF404040;
    private static final int COL_TEXT_DIM = 0xFF707070;
    private static final int COL_TRACK = 0xFF555555;
    private static final int COL_TRACK_IDLE = 0xFF7A7A7A;

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    /**
     * Index the client last told the server to select, or {@code -1} when the client and server
     * agree. Keeping it lets the showcase show the new item immediately instead of flickering back
     * to the previous one until the server's update arrives.
     */
    private int pendingIndex = -1;

    public KitScreen(KitMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = PANEL_WIDTH;
        this.imageHeight = PANEL_HEIGHT;
        this.titleLabelX = 8;
        this.titleLabelY = 6;
        this.inventoryLabelX = INVENTORY_X;
        this.inventoryLabelY = INVENTORY_Y - 11;
        menu.registerUpdateListener(this::containerChanged);
        this.containerChanged();
    }

    // ---------------------------------------------------------------------------------------------
    // Rendering
    // ---------------------------------------------------------------------------------------------

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        //#if MC < 12005
        //$$ this.renderBackground(guiGraphics);
        //#endif

        int x = this.leftPos;
        int y = this.topPos;

        if (TEXTURE != null) {
            guiGraphics.blit(TEXTURE, x, y, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, TEX_WIDTH, TEX_HEIGHT);
        } else {
            this.drawPanel(guiGraphics, x, y);
        }

        this.drawSlot(guiGraphics, x + INPUT_SLOT_X, y + SLOT_Y);
        this.drawSlot(guiGraphics, x + RESULT_SLOT_X, y + SLOT_Y);

        this.drawWell(guiGraphics, x + SHOWCASE_X, y + SHOWCASE_Y, SHOWCASE_WIDTH, SHOWCASE_HEIGHT);
        this.drawScrollbar(guiGraphics, x, y);

        this.drawGrid(guiGraphics, x + GRID_X, y + GRID_Y, mouseX, mouseY);
        this.drawShowcase(guiGraphics, x, y);
    }

    /** Flat panel with a two-tone bezel: dark on the bottom/right, light on the top/left. */
    private void drawPanel(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.fill(x, y, x + PANEL_WIDTH, y + PANEL_HEIGHT, COL_PANEL);
        guiGraphics.fill(x, y, x + PANEL_WIDTH - 1, y + 1, COL_PANEL_LIGHT);
        guiGraphics.fill(x, y, x + 1, y + PANEL_HEIGHT - 1, COL_PANEL_LIGHT);
        guiGraphics.fill(x + PANEL_WIDTH - 1, y, x + PANEL_WIDTH, y + PANEL_HEIGHT, COL_PANEL_DARK);
        guiGraphics.fill(x, y + PANEL_HEIGHT - 1, x + PANEL_WIDTH, y + PANEL_HEIGHT, COL_PANEL_DARK);

        // Recessed well behind the picker so the grid reads as one container, not loose buttons.
        this.drawWell(guiGraphics, x + GRID_X - 2, y + GRID_Y - 2,
                GRID_COLUMNS * CELL_STEP + 3, GRID_ROWS * CELL_STEP + 3);
    }

    private void drawWell(GuiGraphics guiGraphics, int x, int y, int width, int height) {
        guiGraphics.fill(x, y, x + width, y + height, COL_WELL);
        guiGraphics.fill(x, y, x + width - 1, y + 1, COL_WELL_EDGE);
        guiGraphics.fill(x, y, x + 1, y + height - 1, COL_WELL_EDGE);
        guiGraphics.fill(x + width - 1, y + 1, x + width, y + height, COL_PANEL_LIGHT);
        guiGraphics.fill(x + 1, y + height - 1, x + width, y + height, COL_PANEL_LIGHT);
    }

    /** Single inventory-style slot: dark recess with an inner edge. */
    private void drawSlot(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.fill(x - 1, y - 1, x + 17, y + 17, COL_SLOT);
        guiGraphics.fill(x, y, x + 16, y + 16, COL_SLOT_INNER);
    }

    private void drawScrollbar(GuiGraphics guiGraphics, int x, int y) {
        int trackX = x + SCROLLBAR_X;
        int trackY = y + SCROLLBAR_Y;
        boolean active = this.isScrollBarActive();

        guiGraphics.fill(trackX, trackY, trackX + SCROLLBAR_WIDTH, trackY + SCROLLBAR_HEIGHT,
                active ? COL_TRACK : COL_TRACK_IDLE);

        int travel = SCROLLBAR_HEIGHT - SCROLLER_HEIGHT;
        int thumbY = trackY + (int) (travel * this.scrollOffs);
        guiGraphics.fill(trackX, thumbY, trackX + SCROLLBAR_WIDTH, thumbY + SCROLLER_HEIGHT,
                active ? COL_PANEL_LIGHT : COL_PANEL_DARK);
        guiGraphics.fill(trackX, thumbY, trackX + SCROLLBAR_WIDTH - 1, thumbY + 1, COL_PANEL_LIGHT);
    }

    private void drawGrid(GuiGraphics guiGraphics, int gridX, int gridY, int mouseX, int mouseY) {
        List<ItemStack> results = this.menu.getResults();
        for (int k = this.startIndex; k < this.startIndex + MAX_VISIBLE && k < results.size(); ++k) {
            int cellX = gridX + this.cellX(k);
            int cellY = gridY + this.cellY(k);

            int background;
            if (k == this.getSelectionIndex()) {
                background = COL_CELL_SELECTED;
            } else if (this.isOverCell(mouseX, mouseY, cellX, cellY)) {
                background = COL_CELL_HOVER;
            } else {
                background = COL_CELL;
            }
            guiGraphics.fill(cellX, cellY, cellX + CELL, cellY + CELL, background);

            guiGraphics.renderItem(results.get(k), cellX, cellY);
        }
    }

    /**
     * Draws the selected stack large, plus its name and a hint.
     *
     * <p>A scaled item cannot be drawn by simply passing a size to {@code renderItem} -- its
     * {@code (stack, x, y, size)} overload only exists from 1.21.1 on, and it re-enables the depth
     * test in ways that fight a GUI scale. Scaling the pose instead works on every target: the item
     * is drawn at 16x16 pre-scale space, so translating to the target and scaling by
     * {@code size / 16} makes it fill exactly {@code size} pixels.
     */
    private void drawShowcase(GuiGraphics guiGraphics, int x, int y) {
        ItemStack selected = this.getSelectedStack();

        int wellX = x + SHOWCASE_X;
        int wellY = y + SHOWCASE_Y;

        if (selected.isEmpty()) {
            // Nothing chosen yet: label the empty well rather than leaving a blank hole, so the
            // area still explains itself.
            Component empty = Component.translatable("gui.xhe_furniture.kit.empty");
            this.drawCentred(guiGraphics, empty, wellX, SHOWCASE_WIDTH,
                    wellY + SHOWCASE_HEIGHT / 2 - 4, COL_TEXT_DIM);
            return;
        }

        int size = this.getShowcaseItemSize();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(
                (float) wellX + (SHOWCASE_WIDTH - size) / 2.0F,
                (float) wellY + (SHOWCASE_HEIGHT - size) / 2.0F,
                0.0F);
        float scale = size / 16.0F;
        guiGraphics.pose().scale(scale, scale, 1.0F);
        guiGraphics.renderItem(selected, 0, 0);
        guiGraphics.pose().popPose();

        int nameY = y + SHOWCASE_NAME_Y;
        Component name = selected.getHoverName().copy().withStyle(ChatFormatting.DARK_GRAY);
        this.drawCentred(guiGraphics, name, wellX, SHOWCASE_WIDTH, nameY, COL_TEXT);

        // Only advertise the click when the result slot can actually be taken.
//        if (this.canTakeResult()) {
//            Component hint = Component.translatable("gui.xhe_furniture.kit.take");
//            this.drawCentred(guiGraphics, hint, wellX, SHOWCASE_WIDTH, y + SHOWCASE_HINT_Y, COL_TEXT_DIM);
//        }
    }

    /** Draws {@code text} centred on {@code width}, clamped so long names never leave the panel. */
    private void drawCentred(GuiGraphics guiGraphics, Component text, int x, int width, int y, int colour) {
        String label = this.font.plainSubstrByWidth(text.getString(), width).trim();
        int textWidth = this.font.width(label);
        guiGraphics.drawString(this.font, label, x + (width - textWidth) / 2, y, colour, false);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, COL_TEXT, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle,
                this.inventoryLabelX, this.inventoryLabelY, COL_TEXT, false);
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);

        // Hovering a picker cell tooltips that cell: the showcase may be showing a different item,
        // so the cell under the cursor is what the player is actually asking about.
        if (!this.displayRecipes) {
            return;
        }
        List<ItemStack> results = this.menu.getResults();
        for (int k = this.startIndex; k < this.startIndex + MAX_VISIBLE && k < results.size(); ++k) {
            int cellX = this.leftPos + GRID_X + this.cellX(k);
            int cellY = this.topPos + GRID_Y + this.cellY(k);
            if (this.isOverCell(mouseX, mouseY, cellX, cellY)) {
                guiGraphics.renderTooltip(this.font, results.get(k), mouseX, mouseY);
                return;
            }
        }
    }


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;
        if (this.displayRecipes) {
            List<ItemStack> results = this.menu.getResults();
            for (int k = this.startIndex; k < this.startIndex + MAX_VISIBLE && k < results.size(); ++k) {
                int cellX = this.leftPos + GRID_X + this.cellX(k);
                int cellY = this.topPos + GRID_Y + this.cellY(k);
                if (!this.isOverCell(mouseX, mouseY, cellX, cellY)) {
                    continue;
                }
                // clickMenuButton applies the selection server-side too, so the local call is only
                // what keeps the showcase responsive; the packet makes it authoritative.
                if (this.menu.clickMenuButton(this.minecraft.player, k)) {
                    this.pendingIndex = k;
                    this.minecraft.getSoundManager().play(
                            SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, k);
                    return true;
                }
            }

            int trackX = this.leftPos + SCROLLBAR_X;
            int trackY = this.topPos + SCROLLBAR_Y;
            if (mouseX >= trackX && mouseX < trackX + SCROLLBAR_WIDTH
                    && mouseY >= trackY && mouseY < trackY + SCROLLBAR_HEIGHT) {
                this.scrolling = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.scrolling && this.isScrollBarActive()) {
            this.scrollTo(mouseY);
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    // 1.20.2 split the scroll delta of GuiEventListener#mouseScrolled into (horizontal, vertical).
    //#if MC >= 12005
    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        return this.applyScrollDelta(scrollY);
    }
    //#else
    //$$ @Override
    //$$ public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
    //$$     return this.applyScrollDelta(delta);
    //$$ }
    //#endif

    private boolean applyScrollDelta(double delta) {
        if (this.isScrollBarActive()) {
            this.scrollOffs = Mth.clamp(this.scrollOffs - (float) delta / (float) this.getOffscreenRows(), 0.0F, 1.0F);
            this.startIndex = this.toStartIndex(this.scrollOffs);
        }
        return true;
    }

    /** Maps a cursor Y on the track to a scroll fraction, keeping the thumb under the cursor. */
    private void scrollTo(double mouseY) {
        int trackY = this.topPos + SCROLLBAR_Y;
        int travel = SCROLLBAR_HEIGHT - SCROLLER_HEIGHT;
        this.scrollOffs = Mth.clamp(
                (float) ((mouseY - (double) trackY - SCROLLER_HEIGHT / 2.0D) / (double) travel),
                0.0F, 1.0F);
        this.startIndex = this.toStartIndex(this.scrollOffs);
    }

    // ---------------------------------------------------------------------------------------------
    // State
    // ---------------------------------------------------------------------------------------------

    /**
     * Keeps the local view in step with the menu.
     *
     * <p>{@code pendingIndex} is cleared once the menu agrees with it. Until then the menu may still
     * report the previous index, and trusting it would make the showcase snap back for a frame or
     * two after every click.
     */
    private void containerChanged() {
        this.displayRecipes = this.menu.hasInputItem();
        if (this.menu.getSelectedIndex() == this.pendingIndex) {
            this.pendingIndex = -1;
        }
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
            this.pendingIndex = -1;
        }
        // The window can shrink past the current offset when the kit changes, which would leave the
        // grid scrolled off the end of a shorter list.
        int maxStart = Math.max(0, this.getRowCount() - GRID_ROWS) * GRID_COLUMNS;
        this.startIndex = Mth.clamp(this.startIndex, 0, maxStart);
        this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
    }

    private ItemStack getSelectedStack() {
        List<ItemStack> results = this.menu.getResults();
        int index = this.getSelectionIndex();
        if (index < 0 || index >= results.size()) {
            return ItemStack.EMPTY;
        }
        return results.get(index);
    }

    /**
     * Index to treat as selected: the optimistic local one while a click is in flight, otherwise
     * whatever the menu reports.
     */
    private int getSelectionIndex() {
        return this.pendingIndex >= 0 ? this.pendingIndex : this.menu.getSelectedIndex();
    }

    /**
     * Whether the shown item can actually be taken yet.
     *
     * <p>While a click is in flight the result slot still holds the previous item, so the menu is
     * only trusted once it agrees with the pending index; before that the optimistic selection
     * stands in for it.
     */
    private boolean canTakeResult() {
        if (this.pendingIndex >= 0) {
            return true;
        }
        return this.menu.getResultSlot().hasItem();
    }

    /** Preview size in pixels: the item fills the well, since 16px art stays legible scaled up. */
    private int getShowcaseItemSize() {
        return Mth.clamp(Math.min(SHOWCASE_WIDTH, SHOWCASE_HEIGHT) - 6, SHOWCASE_ITEM_MIN, SHOWCASE_ITEM_MAX);
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && this.menu.getNumResults() > MAX_VISIBLE;
    }

    private int getRowCount() {
        return (this.menu.getNumResults() + GRID_COLUMNS - 1) / GRID_COLUMNS;
    }

    private int getOffscreenRows() {
        return Math.max(1, this.getRowCount() - GRID_ROWS);
    }

    private int toStartIndex(float offs) {
        return (int) ((double) (offs * (float) this.getOffscreenRows()) + 0.5D) * GRID_COLUMNS;
    }

    /** Column of {@code index} within the visible window, in pixels. */
    private int cellX(int index) {
        return ((index - this.startIndex) % GRID_COLUMNS) * CELL_STEP;
    }

    /** Row of {@code index} within the visible window, in pixels. */
    private int cellY(int index) {
        return ((index - this.startIndex) / GRID_COLUMNS) * CELL_STEP;
    }

    private boolean isOverCell(double mouseX, double mouseY, int cellX, int cellY) {
        return mouseX >= cellX && mouseX < cellX + CELL && mouseY >= cellY && mouseY < cellY + CELL;
    }
}
