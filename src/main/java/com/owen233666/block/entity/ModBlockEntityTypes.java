package com.owen233666.block.entity;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityTypes {

    public static final BlockEntityType<StorageBlockEntity> STORAGE_BLOCK_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(XheFurniture.MOD_ID, "storage_block_entity"),
                    BlockEntityType.Builder.create(
                            StorageBlockEntity::new,
                            ModBlocks.WHITE_SHOE_FLOWERPOT,
                            ModBlocks.PINK_SHOE_FLOWERPOT,
                            ModBlocks.RED_SHOE_FLOWERPOT,
                            ModBlocks.GREEN_SHOE_FLOWERPOT,
                            ModBlocks.YELLOW_SHOE_FLOWERPOT
                    ).build(null)
            );

    public static final BlockEntityType<EaselBlockEntity> EASEL_BLOCK_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(XheFurniture.MOD_ID, "easel_block_entity"),
                    BlockEntityType.Builder.create(
                            EaselBlockEntity::new,
                            ModBlocks.EASEL
                    ).build(null)
            );

    public static void registerBlockEntityTypes() {
    }
}
