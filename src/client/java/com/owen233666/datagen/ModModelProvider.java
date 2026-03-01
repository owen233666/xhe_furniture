//package com.owen233666.datagen;
//
//import com.owen233666.XheFurniture;
//import com.owen233666.block.ModBlocks;
//import com.owen233666.block.painting.*;
//import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
//import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import static com.owen233666.datagen.CanvasAndDrawingBoardPaintingWallModelProvider.IMAGE_NAMES;
//
//@Deprecated
//public class ModModelProvider extends FabricModelProvider {
//
//    public ModModelProvider(FabricDataOutput output) {
//        super(output);
//    }
//
//    @Override
//    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
//        final List<Block> BLOCKS = List.of(
//                ModBlocks.GRID_SHELF_OAK,
//                ModBlocks.GRID_SHELF_SPRUCE,
//                ModBlocks.GRID_SHELF_JUNGLE,
//                ModBlocks.GRID_SHELF_BIRCH,
//                ModBlocks.GRID_SHELF_ACACIA,
//                ModBlocks.GRID_SHELF_DARK_OAK,
//                ModBlocks.GRID_SHELF_MANGROVE,
//                ModBlocks.GRID_SHELF_CHERRY,
//                ModBlocks.GRID_SHELF_BAMBOO,
//                ModBlocks.GRID_SHELF_PALE_OAK,
//                ModBlocks.GRID_SHELF_BLACKSTONE
//        );
//
//        for (Block block : BLOCKS) {
//            MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(block);
//
//            Identifier id = ModelIds.getBlockModelId(block);
//            for (Direction direction : Direction.Type.HORIZONTAL) {
//                VariantSettings.Rotation rotation = switch (direction) {
//                    case NORTH -> VariantSettings.Rotation.R0;
//                    case EAST -> VariantSettings.Rotation.R90;
//                    case SOUTH -> VariantSettings.Rotation.R180;
//                    case WEST -> VariantSettings.Rotation.R270;
//                    default -> VariantSettings.Rotation.R0;
//                };
//
//                BlockStateVariant variant = BlockStateVariant.create()
//                        .put(VariantSettings.MODEL, id);
//
//                multipartBlockStateSupplier.with(
//                        When.create().set(GridShelfBlock.FACING, direction),
//                        variant.put(VariantSettings.Y, rotation)
//                );
//
//                final List<GridShelfBlock.PhotoType> PHOTO_TYPES = List.of(GridShelfBlock.PhotoType.A, GridShelfBlock.PhotoType.B, GridShelfBlock.PhotoType.C);
//
//                for (GridShelfBlock.PhotoType photoType : PHOTO_TYPES) {
//                    Identifier whitePhotoModelID = new Identifier(XheFurniture.MOD_ID, "block/grid_shelf_photo_paper_white_" + photoType.asString().toLowerCase());
//                    Identifier blackPhotoModelID = new Identifier(XheFurniture.MOD_ID, "block/grid_shelf_photo_paper_black_" + photoType.asString().toLowerCase());
//                    multipartBlockStateSupplier.with(
//                            When.create()
//                                    .set(GridShelfBlock.FACING, direction)
//                                    .set(GridShelfBlock.PHOTO_TYPE, photoType)
//                                    .set(GridShelfBlock.WHITE, true)
//                                    .set(GridShelfBlock.HAS_PHOTO, true),
//                            BlockStateVariant.create().put(VariantSettings.MODEL, whitePhotoModelID)
//                                    .put(VariantSettings.Y, rotation)
//                    );
//                    multipartBlockStateSupplier.with(
//                            When.create()
//                                    .set(GridShelfBlock.FACING, direction)
//                                    .set(GridShelfBlock.PHOTO_TYPE, photoType)
//                                    .set(GridShelfBlock.WHITE, false)
//                                    .set(GridShelfBlock.HAS_PHOTO, true),
//                            BlockStateVariant.create().put(VariantSettings.MODEL, blackPhotoModelID)
//                                    .put(VariantSettings.Y, rotation)
//                    );
//
//                    for (String painting_name : IMAGE_NAMES) {
//                        String modelPath = "block/paintings/grid_shelf_photo_paper_" + photoType.toString().toLowerCase() + "/" + painting_name;
//                        Identifier modelID = new Identifier(XheFurniture.MOD_ID, modelPath);
//                        multipartBlockStateSupplier.with(
//                                When.create()
//                                        .set(GridShelfBlock.FACING, direction)
//                                        .set(GridShelfBlock.PHOTO_TYPE, photoType)
//                                        .set(GridShelfBlock.PAINTINGS, Paintings.createFromString(painting_name)),
//                                BlockStateVariant.create()
//                                        .put(VariantSettings.MODEL, modelID)
//                                        .put(VariantSettings.Y, rotation)
//                        );
//                    }
//                }
//            }
//
//            blockStateModelGenerator.blockStateCollector.accept(multipartBlockStateSupplier);
//        }
//        MultipartBlockStateSupplier multipartBlockStateSupplierForPaintBrush = MultipartBlockStateSupplier.create(ModBlocks.PAINT_BRUSH);
//        for (Direction direction : Direction.Type.HORIZONTAL){
//            for (int i = 0; i <= 64; i++) {
//
//
//                VariantSettings.Rotation rotation = switch (direction) {
//                    case NORTH -> VariantSettings.Rotation.R0;
//                    case EAST -> VariantSettings.Rotation.R90;
//                    case SOUTH -> VariantSettings.Rotation.R180;
//                    case WEST -> VariantSettings.Rotation.R270;
//                    default -> VariantSettings.Rotation.R0;
//                };
//
//                if (i == 0) {
//                    multipartBlockStateSupplierForPaintBrush.with(
//                            When.create()
//                                    .set(PaintBrushBlock.DURABILITY, i)
//                                    .set(PaintBrushBlock.FACING, direction),
//                            BlockStateVariant.create()
//                                    .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/paint_brush"))
//                                    .put(VariantSettings.Y, rotation)
//                    );
//                }else {
//                    multipartBlockStateSupplierForPaintBrush.with(
//                            When.create()
//                                    .set(PaintBrushBlock.DURABILITY, i)
//                                    .set(PaintBrushBlock.FACING, direction),
//                            BlockStateVariant.create()
//                                    .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/dirty_paint_brush"))
//                                    .put(VariantSettings.Y, rotation)
//                    );
//                }
//            }
//        }
//        blockStateModelGenerator.blockStateCollector.accept(multipartBlockStateSupplierForPaintBrush);
//
//        MultipartBlockStateSupplier multipartBlockStateSupplierForPaintCan = MultipartBlockStateSupplier.create(ModBlocks.PAINT_CAN);
//        MultipartBlockStateSupplier multipartBlockStateSupplierForMessyPaintCan = MultipartBlockStateSupplier.create(ModBlocks.MESSY_PAINT_CAN);
//        for (Direction direction : Direction.Type.HORIZONTAL){
//            VariantSettings.Rotation rotation = switch (direction) {
//                case NORTH -> VariantSettings.Rotation.R0;
//                case EAST -> VariantSettings.Rotation.R90;
//                case SOUTH -> VariantSettings.Rotation.R180;
//                case WEST -> VariantSettings.Rotation.R270;
//                default -> VariantSettings.Rotation.R0;
//            };
//
//            multipartBlockStateSupplierForPaintCan.with(
//                    When.create()
//                            .set(PaintCanBlock.DIRTY, false)
//                            .set(PaintCanBlock.FACING, direction),
//                    BlockStateVariant.create()
//                            .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/paint_can"))
//                            .put(VariantSettings.Y, rotation)
//            );
//
//            multipartBlockStateSupplierForPaintCan.with(
//                    When.create()
//                            .set(PaintCanBlock.DIRTY, true)
//                            .set(PaintCanBlock.FACING, direction),
//                    BlockStateVariant.create()
//                            .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/dirty_paint_can"))
//                            .put(VariantSettings.Y, rotation)
//            );
//
//            multipartBlockStateSupplierForMessyPaintCan.with(
//                    When.create()
//                            .set(DyeablePaintCanBlock.DIRTY, false)
//                            .set(DyeablePaintCanBlock.FACING, direction),
//                    BlockStateVariant.create()
//                            .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/messy_paint_can"))
//                            .put(VariantSettings.Y, rotation)
//            );
//
//            multipartBlockStateSupplierForMessyPaintCan.with(
//                    When.create()
//                            .set(DyeablePaintCanBlock.DIRTY, true)
//                            .set(DyeablePaintCanBlock.FACING, direction),
//                    BlockStateVariant.create()
//                            .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/dirty_messy_paint_can"))
//                            .put(VariantSettings.Y, rotation)
//            );
//
//        }
//        blockStateModelGenerator.blockStateCollector.accept(multipartBlockStateSupplierForPaintCan);
//        blockStateModelGenerator.blockStateCollector.accept(multipartBlockStateSupplierForMessyPaintCan);
//        genPaintingFrameResources(blockStateModelGenerator);
//    }
//
//    @Override
//    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//    }
//
//    private void genPaintingFrameResources(BlockStateModelGenerator blockStateModelGenerator){
//        for (Block block : new Block[]{
//                ModBlocks.PAINTING_FRAME_OAK,
//                ModBlocks.PAINTING_FRAME_SPRUCE,
//                ModBlocks.PAINTING_FRAME_JUNGLE,
//                ModBlocks.PAINTING_FRAME_BIRCH,
//                ModBlocks.PAINTING_FRAME_ACACIA,
//                ModBlocks.PAINTING_FRAME_DARK_OAK,
//                ModBlocks.PAINTING_FRAME_MANGROVE,
//                ModBlocks.PAINTING_FRAME_CHERRY,
//                ModBlocks.PAINTING_FRAME_BAMBOO,
//                ModBlocks.PAINTING_FRAME_PALE_OAK,
//                ModBlocks.PAINTING_FRAME_BLACKSTONE
//        }){
//            MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(block);
//
//            Map<Block, String> blockIdentifierMap =  new HashMap<>();
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_OAK, "oak");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_SPRUCE, "spruce");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_JUNGLE, "jungle");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_BIRCH, "birch");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_ACACIA, "acacia");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_DARK_OAK, "dark_oak");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_MANGROVE, "mangrove");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_CHERRY, "cherry");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_BAMBOO, "bamboo");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_PALE_OAK, "pale_oak");
//            blockIdentifierMap.put(ModBlocks.PAINTING_FRAME_BLACKSTONE, "blackstone");
//
//            for (Direction direction : Direction.Type.HORIZONTAL){
//                VariantSettings.Rotation rotation = switch (direction) {
//                    case NORTH -> VariantSettings.Rotation.R0;
//                    case EAST -> VariantSettings.Rotation.R90;
//                    case SOUTH -> VariantSettings.Rotation.R180;
//                    case WEST -> VariantSettings.Rotation.R270;
//                    default -> VariantSettings.Rotation.R0;
//                };
//
//                //wall
//                multipartBlockStateSupplier.with(
//                        When.create()
//                                .set(CanvasBlock.FACING, direction)
//                                .set(CanvasBlock.PLACE_TYPE, PlacementState.WALL),
//                        BlockStateVariant.create()
//                                .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block.painting_frame_wall" + blockIdentifierMap.get(block)))
//                                .put(VariantSettings.Y, rotation)
//                );
//
//                //corner
//                multipartBlockStateSupplier.with(
//                        When.create()
//                                .set(CanvasBlock.FACING, direction)
//                                .set(CanvasBlock.PLACE_TYPE, PlacementState.CORNER)
//                                .set(CanvasBlock.COUNT, 1),
//                        BlockStateVariant.create()
//                                .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/painting_frame_corner_1_" +  blockIdentifierMap.get(block)))
//                                .put(VariantSettings.Y, rotation)
//                );
//
//                multipartBlockStateSupplier.with(
//                        When.create()
//                                .set(CanvasBlock.FACING, direction)
//                                .set(CanvasBlock.PLACE_TYPE, PlacementState.CORNER)
//                                .set(CanvasBlock.COUNT, 2),
//                        BlockStateVariant.create()
//                                .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/painting_frame_corner_2_" +  blockIdentifierMap.get(block)))
//                                .put(VariantSettings.Y, rotation)
//                );
//
//                multipartBlockStateSupplier.with(
//                        When.create()
//                                .set(CanvasBlock.FACING, direction)
//                                .set(CanvasBlock.PLACE_TYPE, PlacementState.CORNER)
//                                .set(CanvasBlock.COUNT, 3),
//                        BlockStateVariant.create()
//                                .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/painting_frame_corner_3_" +  blockIdentifierMap.get(block)))
//                                .put(VariantSettings.Y, rotation)
//                );
//
//                for (String painting_name : IMAGE_NAMES){
//                    multipartBlockStateSupplier.with(
//                            When.create()
//                                    .set(CanvasBlock.FACING, direction)
//                                    .set(CanvasBlock.PLACE_TYPE, PlacementState.WALL)
//                                    .set(CanvasBlock.PAINTINGS, Paintings.createFromString(painting_name)),
//                            BlockStateVariant.create()
//                                    .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/paintings/painting_frame/wall/" + painting_name))
//                                    .put(VariantSettings.Y, rotation)
//                    );
//
//                    multipartBlockStateSupplier.with(
//                            When.create()
//                                    .set(CanvasBlock.FACING, direction)
//                                    .set(CanvasBlock.PLACE_TYPE, PlacementState.CORNER)
//                                    .set(CanvasBlock.COUNT, 1)
//                                    .set(CanvasBlock.PAINTINGS, Paintings.createFromString(painting_name)),
//                            BlockStateVariant.create()
//                                    .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/paintings/painting_frame/corner_1/" + painting_name))
//                    );
//
//                    multipartBlockStateSupplier.with(
//                            When.create()
//                                    .set(CanvasBlock.FACING, direction)
//                                    .set(CanvasBlock.PLACE_TYPE, PlacementState.CORNER)
//                                    .set(CanvasBlock.COUNT, 2)
//                                    .set(CanvasBlock.PAINTINGS, Paintings.createFromString(painting_name)),
//                            BlockStateVariant.create()
//                                    .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/paintings/painting_frame/corner_2/" + painting_name))
//                    );
//
//                    multipartBlockStateSupplier.with(
//                            When.create()
//                                    .set(CanvasBlock.FACING, direction)
//                                    .set(CanvasBlock.PLACE_TYPE, PlacementState.CORNER)
//                                    .set(CanvasBlock.COUNT, 2)
//                                    .set(CanvasBlock.PAINTINGS, Paintings.createFromString(painting_name)),
//                            BlockStateVariant.create()
//                                    .put(VariantSettings.MODEL, new Identifier(XheFurniture.MOD_ID, "block/paintings/painting_frame/corner_2/" + painting_name))
//                    );
//                }
//            }
//            blockStateModelGenerator.blockStateCollector.accept(multipartBlockStateSupplier);
//        }
//    }
//}
