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

    public static final BlockEntityType<PhotoABlockEntity> PHOTO_A_BLOCK_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(XheFurniture.MOD_ID, "photo_a_block_entity"),
                    BlockEntityType.Builder.of(
                            PhotoABlockEntity::new,
                            ModBlocks.PHOTO_PAPER_WHITE_A,
                            ModBlocks.PHOTO_PAPER_BLACK_A
                    ).build(null)
            );

    public static final BlockEntityType<PhotoBBlockEntity> PHOTO_B_BLOCK_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(XheFurniture.MOD_ID, "photo_b_block_entity"),
                    BlockEntityType.Builder.of(
                            PhotoBBlockEntity::new,
                            ModBlocks.PHOTO_PAPER_WHITE_B,
                            ModBlocks.PHOTO_PAPER_BLACK_B
                    ).build(null)
            );

    public static final BlockEntityType<PhotoCBlockEntity> PHOTO_C_BLOCK_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(XheFurniture.MOD_ID, "photo_c_block_entity"),
                    BlockEntityType.Builder.of(
                            PhotoCBlockEntity::new,
                            ModBlocks.PHOTO_PAPER_WHITE_C,
                            ModBlocks.PHOTO_PAPER_BLACK_C
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

    public static final BlockEntityType<GridShelfBlockEntity> GRID_SHELF_BLOCK_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(XheFurniture.MOD_ID, "grid_shelf_block_entity"),
                    BlockEntityType.Builder.of(
                            GridShelfBlockEntity::new,
                            ModBlocks.GRID_SHELF_OAK,
                            ModBlocks.GRID_SHELF_SPRUCE,
                            ModBlocks.GRID_SHELF_JUNGLE,
                            ModBlocks.GRID_SHELF_BIRCH,
                            ModBlocks.GRID_SHELF_ACACIA,
                            ModBlocks.GRID_SHELF_DARK_OAK,
                            ModBlocks.GRID_SHELF_MANGROVE,
                            ModBlocks.GRID_SHELF_CHERRY,
                            ModBlocks.GRID_SHELF_BAMBOO,
                            ModBlocks.GRID_SHELF_PALE_OAK,
                            ModBlocks.GRID_SHELF_BLACKSTONE
                    ).build(null)
            );

    public static final BlockEntityType<CanvasBlockEntity> PAINTING_FRAME_BLOCK_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(XheFurniture.MOD_ID, "painting_frame_block_entity"),
                    BlockEntityType.Builder.of(
                            CanvasBlockEntity::new,
                            ModBlocks.PAINTING_FRAME_OAK
                    ).build(null)
            );

    public static void registerBlockEntityTypes() {
    }
}
