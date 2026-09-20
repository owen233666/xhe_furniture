/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block;

import com.owen233666.screen.CraftingTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * The furniture crafting table. It reuses the stonecutter menu so the player can pick a
 * furniture variant.
 *
 * <p>It extends {@link StonecutterBlock} only for the menu behaviour, <em>not</em> for its
 * mining feel: the block's properties are plain wooden ones ({@code strength(2.5F)},
 * {@code SoundType.WOOD}) declared in {@code ModBlocks}, deliberately without
 * {@code requiresCorrectToolForDrops}. That matters because vanilla's destroy-speed maths
 * divides the tool's speed by 100 whenever a block requires a correct tool and the held tool
 * is not one, which is what made an axe feel slow on an earlier stonecutter-derived version.
 *
 * <p>The {@code minecraft:mineable/axe} tag (see {@code ModBlockTagProvider}) supplies the
 * axe speed bonus on top of that.
 */
public class FurnitureCraftingTable extends StonecutterBlock {
    public static final VoxelShape SHAPE = box(0, 0, 0, 16, 16, 16);

    public FurnitureCraftingTable(Properties properties) {
        super(properties);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider(
                (id, inventory, player) -> new CraftingTableMenu(id, inventory, ContainerLevelAccess.create(level, pos)),
                Component.translatable("block.xhe_furniture.furniture_crafting_table")
        );
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }
}
