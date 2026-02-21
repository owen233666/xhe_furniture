package com.owen233666.datagen;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import com.owen233666.block.painting.GridShelfBlock;
import com.owen233666.block.painting.Paintings;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Optional;

import static com.owen233666.datagen.CanvasAndDrawingBoardPaintingWallModelProvider.IMAGE_NAMES;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        final List<Block> BLOCKS = List.of(
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
        );

        for (Block block : BLOCKS) {
            MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(block);

            Identifier id = ModelIds.getBlockModelId(block);
            for (Direction direction : Direction.Type.HORIZONTAL) {
                VariantSettings.Rotation rotation = switch (direction) {
                    case NORTH -> VariantSettings.Rotation.R0;
                    case EAST -> VariantSettings.Rotation.R90;
                    case SOUTH -> VariantSettings.Rotation.R180;
                    case WEST -> VariantSettings.Rotation.R270;
                    default -> VariantSettings.Rotation.R0;
                };

                BlockStateVariant variant = BlockStateVariant.create()
                        .put(VariantSettings.MODEL, id);

                multipartBlockStateSupplier.with(
                        When.create().set(GridShelfBlock.FACING, direction),
                        variant.put(VariantSettings.Y, rotation)
                );

                final List<GridShelfBlock.PhotoType> PHOTO_TYPES = List.of(GridShelfBlock.PhotoType.A, GridShelfBlock.PhotoType.B, GridShelfBlock.PhotoType.C);

                for (GridShelfBlock.PhotoType photoType : PHOTO_TYPES) {
                    for (Boolean white : List.of(true, false)) {
                        Identifier photoModelID = new Identifier(XheFurniture.MOD_ID, "block/grid_shelf_photo_paper_" + (white ? "white_" : "black_") + photoType.asString().toLowerCase());

                        multipartBlockStateSupplier.with(
                                When.create()
                                        .set(GridShelfBlock.FACING, direction)
                                        .set(GridShelfBlock.PHOTO_TYPE, photoType)
                                        .set(GridShelfBlock.WHITE, white),
                                BlockStateVariant.create().put(VariantSettings.MODEL, photoModelID)
                                        .put(VariantSettings.Y, rotation)
                        );
                    }
                    for (String painting_name : IMAGE_NAMES) {
                        String modelPath = "block/paintings/grid_shelf_photo_paper_" + photoType.toString().toLowerCase() + "/" + painting_name;
                        Identifier modelID = new Identifier(XheFurniture.MOD_ID, modelPath);
                        multipartBlockStateSupplier.with(
                                When.create()
                                        .set(GridShelfBlock.FACING, direction)
                                        .set(GridShelfBlock.PHOTO_TYPE, photoType)
                                        .set(GridShelfBlock.PAINTINGS, Paintings.createFromString(painting_name)),
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, modelID)
                                        .put(VariantSettings.Y, rotation)
                        );
                    }
                }
            }

            blockStateModelGenerator.blockStateCollector.accept(multipartBlockStateSupplier);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
