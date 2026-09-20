/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block.entity;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import com.owen233666.platform.Ids;
import com.owen233666.platform.Registrar;

public class ModBlockEntityTypes {

    public static final Registrar.Holder<BlockEntityType<StorageBlockEntity>> STORAGE_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "storage_block_entity"), () -> BlockEntityType.Builder.of(
                            StorageBlockEntity::new,
                            ModBlocks.WHITE_SHOE_FLOWERPOT.get(),
                            ModBlocks.PINK_SHOE_FLOWERPOT.get(),
                            ModBlocks.RED_SHOE_FLOWERPOT.get(),
                            ModBlocks.GREEN_SHOE_FLOWERPOT.get(),
                            ModBlocks.YELLOW_SHOE_FLOWERPOT.get()
                    ).build(null)
            );

    public static final Registrar.Holder<BlockEntityType<PhotoABlockEntity>> PHOTO_A_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "photo_a_block_entity"), () -> BlockEntityType.Builder.of(
                            PhotoABlockEntity::new,
                            ModBlocks.PHOTO_PAPER_WHITE_A.get(),
                            ModBlocks.PHOTO_PAPER_BLACK_A.get()
                    ).build(null)
            );

    public static final Registrar.Holder<BlockEntityType<PhotoBBlockEntity>> PHOTO_B_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "photo_b_block_entity"), () -> BlockEntityType.Builder.of(
                            PhotoBBlockEntity::new,
                            ModBlocks.PHOTO_PAPER_WHITE_B.get(),
                            ModBlocks.PHOTO_PAPER_BLACK_B.get()
                    ).build(null)
            );

    public static final Registrar.Holder<BlockEntityType<PhotoCBlockEntity>> PHOTO_C_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "photo_c_block_entity"), () -> BlockEntityType.Builder.of(
                            PhotoCBlockEntity::new,
                            ModBlocks.PHOTO_PAPER_WHITE_C.get(),
                            ModBlocks.PHOTO_PAPER_BLACK_C.get()
                    ).build(null)
            );

    public static final Registrar.Holder<BlockEntityType<EaselBlockEntity>> EASEL_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "easel_block_entity"), () -> BlockEntityType.Builder.of(
                            EaselBlockEntity::new,
                            ModBlocks.EASEL.get()
                    ).build(null)
            );

    public static final Registrar.Holder<BlockEntityType<CanvasBlockEntity>> CANVAS_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "canvas_block_entity"), () -> BlockEntityType.Builder.of(
                            CanvasBlockEntity::new,
                            ModBlocks.CANVAS.get(),
                            ModBlocks.DRAWING_BOARD.get(),
                            ModBlocks.CANVAS_BIG.get()
                    ).build(null)
            );

    public static final Registrar.Holder<BlockEntityType<GridShelfBlockEntity>> GRID_SHELF_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "grid_shelf_block_entity"), () -> BlockEntityType.Builder.of(
                            GridShelfBlockEntity::new,
                            ModBlocks.GRID_SHELF_OAK.get(),
                            ModBlocks.GRID_SHELF_SPRUCE.get(),
                            ModBlocks.GRID_SHELF_JUNGLE.get(),
                            ModBlocks.GRID_SHELF_BIRCH.get(),
                            ModBlocks.GRID_SHELF_ACACIA.get(),
                            ModBlocks.GRID_SHELF_DARK_OAK.get(),
                            ModBlocks.GRID_SHELF_MANGROVE.get(),
                            ModBlocks.GRID_SHELF_CHERRY.get(),
                            ModBlocks.GRID_SHELF_BAMBOO.get(),
                            ModBlocks.GRID_SHELF_PALE_OAK.get(),
                            ModBlocks.GRID_SHELF_BLACKSTONE.get()
                    ).build(null)
            );

    public static final Registrar.Holder<BlockEntityType<PaintFrameBlockEntity>> PAINTING_FRAME_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "painting_frame_block_entity"), () -> BlockEntityType.Builder.of(
                            PaintFrameBlockEntity::new,
                            ModBlocks.PAINTING_FRAME_OAK.get(),
                            ModBlocks.PAINTING_FRAME_SPRUCE.get(),
                            ModBlocks.PAINTING_FRAME_JUNGLE.get(),
                            ModBlocks.PAINTING_FRAME_BIRCH.get(),
                            ModBlocks.PAINTING_FRAME_ACACIA.get(),
                            ModBlocks.PAINTING_FRAME_DARK_OAK.get(),
                            ModBlocks.PAINTING_FRAME_MANGROVE.get(),
                            ModBlocks.PAINTING_FRAME_CHERRY.get(),
                            ModBlocks.PAINTING_FRAME_BAMBOO.get(),
                            ModBlocks.PAINTING_FRAME_PALE_OAK.get(),
                            ModBlocks.PAINTING_FRAME_BLACKSTONE.get()
                    ).build(null)
            );

    public static final Registrar.Holder<BlockEntityType<BookLikeBlockEntity>> BOOK_LIKE_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "book_like_block_entity"), () -> BlockEntityType.Builder.of(
                            BookLikeBlockEntity::new,
                            ModBlocks.CANVAS.get()
                    ).build(null)
            );

    public static final Registrar.Holder<BlockEntityType<CorkBoardBlockEntity>> CORK_BOARD_BLOCK_BE =
            Registrar.blockEntity(Ids.of(XheFurniture.MOD_ID, "cork_board_block_entity"), () -> BlockEntityType.Builder.of(
                            CorkBoardBlockEntity::new,
                            ModBlocks.CORK_BOARD_LIGHT_OAK.get(),
                            ModBlocks.CORK_BOARD_LIGHT_SPRUCE.get(),
                            ModBlocks.CORK_BOARD_LIGHT_JUNGLE.get(),
                            ModBlocks.CORK_BOARD_LIGHT_BIRCH.get(),
                            ModBlocks.CORK_BOARD_LIGHT_ACACIA.get(),
                            ModBlocks.CORK_BOARD_LIGHT_DARK_OAK.get(),
                            ModBlocks.CORK_BOARD_LIGHT_MANGROVE.get(),
                            ModBlocks.CORK_BOARD_LIGHT_CHERRY.get(),
                            ModBlocks.CORK_BOARD_LIGHT_BAMBOO.get(),
                            ModBlocks.CORK_BOARD_LIGHT_PALE_OAK.get(),
                            ModBlocks.CORK_BOARD_LIGHT_BLACKSTONE.get(),
                            ModBlocks.CORK_BOARD_DARK_OAK.get(),
                            ModBlocks.CORK_BOARD_DARK_SPRUCE.get(),
                            ModBlocks.CORK_BOARD_DARK_JUNGLE.get(),
                            ModBlocks.CORK_BOARD_DARK_BIRCH.get(),
                            ModBlocks.CORK_BOARD_DARK_ACACIA.get(),
                            ModBlocks.CORK_BOARD_DARK_DARK_OAK.get(),
                            ModBlocks.CORK_BOARD_DARK_MANGROVE.get(),
                            ModBlocks.CORK_BOARD_DARK_CHERRY.get(),
                            ModBlocks.CORK_BOARD_DARK_BAMBOO.get(),
                            ModBlocks.CORK_BOARD_DARK_PALE_OAK.get(),
                            ModBlocks.CORK_BOARD_DARK_BLACKSTONE.get()
                    ).build(null)
            );
    public static void registerBlockEntityTypes() {
    }
}
