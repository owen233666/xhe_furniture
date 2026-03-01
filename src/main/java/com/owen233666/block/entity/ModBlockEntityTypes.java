package com.owen233666.block.entity;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypes {

    public static final BlockEntityType<StorageBlockEntity> STORAGE_BLOCK_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(XheFurniture.MOD_ID, "storage_block_entity"),
                    BlockEntityType.Builder.of(
                            StorageBlockEntity::new,
                            ModBlocks.WHITE_SHOE_FLOWERPOT,
                            ModBlocks.PINK_SHOE_FLOWERPOT,
                            ModBlocks.RED_SHOE_FLOWERPOT,
                            ModBlocks.GREEN_SHOE_FLOWERPOT,
                            ModBlocks.YELLOW_SHOE_FLOWERPOT
                    ).build(null)
            );

    public static final BlockEntityType<EaselBlockEntity> EASEL_BLOCK_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(XheFurniture.MOD_ID, "easel_block_entity"),
                    BlockEntityType.Builder.of(
                            EaselBlockEntity::new,
                            ModBlocks.EASEL
                    ).build(null)
            );

    public static final BlockEntityType<CanvasBlockEntity> CANVAS_BLOCK_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(XheFurniture.MOD_ID, "canvas_block_entity"),
                    BlockEntityType.Builder.of(
                            CanvasBlockEntity::new,
                            ModBlocks.CANVAS,
                            ModBlocks.DRAWING_BOARD
                    ).build(null)
            );

    public static void registerBlockEntityTypes() {
    }
}
