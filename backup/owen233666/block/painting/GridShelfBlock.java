package com.owen233666.block.painting;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import com.owen233666.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class GridShelfBlock extends AbstractPaintingBlock {
    public static final BooleanProperty WHITE = BooleanProperty.of("white");
    public static final BooleanProperty HAS_PHOTO  = BooleanProperty.of("has_photo");
    public static final EnumProperty<PhotoType> PHOTO_TYPE = EnumProperty.of("photo_type", PhotoType.class);

    public static final Supplier<VoxelShape> SHAPE_SUPPLIER = () -> Block.createCuboidShape(0, 0, 15F, 16, 16, 16);
    public static final Map<Direction, VoxelShape> SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            map.put(direction, BlockUtil.rotateVoxelShape(Direction.NORTH, direction, SHAPE_SUPPLIER.get()));
        }
    });

    public static final Supplier<Map<PhotoType, Item>> whitePhotosSupplier = () -> {
        HashMap map = new HashMap();
        map.put(PhotoType.A, ModBlocks.PHOTO_PAPER_WHITE_A);
        map.put(PhotoType.B, ModBlocks.PHOTO_PAPER_WHITE_B);
        map.put(PhotoType.C, ModBlocks.PHOTO_PAPER_WHITE_C);
        return map;
    };
    public static final Supplier<Map<Item, PhotoType>> reversedWhitePhotosSupplier = () -> {
        HashMap map = new HashMap();
        map.put(ModBlocks.PHOTO_PAPER_WHITE_A, PhotoType.A);
        map.put(ModBlocks.PHOTO_PAPER_WHITE_B, PhotoType.B);
        map.put(ModBlocks.PHOTO_PAPER_WHITE_C, PhotoType.C);
        return map;
    };
    public static final Supplier<Map<PhotoType, Item>> blackPhotosSupplier = () -> {
        HashMap map = new HashMap();
        map.put(PhotoType.A, ModBlocks.PHOTO_PAPER_BLACK_A);
        map.put(PhotoType.B, ModBlocks.PHOTO_PAPER_BLACK_B);
        map.put(PhotoType.C, ModBlocks.PHOTO_PAPER_BLACK_C);
        return map;
    };
    public static final Supplier<Map<Item, PhotoType>> reversedBlackPhotosSupplier = () -> {
        HashMap map = new HashMap();
        map.put(ModBlocks.PHOTO_PAPER_BLACK_A, PhotoType.A);
        map.put(ModBlocks.PHOTO_PAPER_BLACK_B, PhotoType.B);
        map.put(ModBlocks.PHOTO_PAPER_BLACK_C, PhotoType.C);
        return map;
    };

    public GridShelfBlock(Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager.getDefaultState()
                        .with(HAS_PHOTO, false)
                        .with(WHITE, true)
                        .with(PAINTINGS, Paintings.NONE)
                        .with(PHOTO_TYPE, PhotoType.A)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(PHOTO_TYPE, HAS_PHOTO, WHITE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE.get(state.get(FACING));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getStackInHand(hand);
        Item heldItem = heldStack.getItem();
        Paintings paintingsOn = state.get(PAINTINGS);
        Paintings paintingsTo = getPaintingsFromItem(heldItem);
        Boolean hasPhoto = state.get(HAS_PHOTO);
        Boolean white = state.get(WHITE);
        PhotoType photoType = state.get(PHOTO_TYPE);

//        XheFurniture.LOGGER.info(heldStack.toString());
//        XheFurniture.LOGGER.info(heldItem.toString());
//        XheFurniture.LOGGER.info(paintingsOn.toString());
//        XheFurniture.LOGGER.info(paintingsTo.toString());
//        XheFurniture.LOGGER.info(hasPhoto.toString());
//        XheFurniture.LOGGER.info(white.toString());
//        XheFurniture.LOGGER.info(photoType.toString());

        if (hasPhoto){
            if (paintingsTo != Paintings.NONE) {
                if (paintingsOn != Paintings.NONE) {
                    ItemStack giveStack = getItemFromPaintings(paintingsOn);
                    if (!player.isCreative()) heldStack.split(1);
                    if (!player.getInventory().insertStack(giveStack)) player.dropStack(giveStack);
                    world.setBlockState(pos, state.with(PAINTINGS, paintingsTo));
                    return ActionResult.CONSUME_PARTIAL;
                }else {
                    if (!player.isCreative()) heldStack.split(1);
                    world.setBlockState(pos, state.with(PAINTINGS, paintingsTo));
                    return ActionResult.CONSUME_PARTIAL;
                }
            }else {
                if (player.isSneaking() && heldStack.isEmpty()) {
                    ItemStack giveStack = getFromShelf(photoType, white);
                    if (!player.getInventory().insertStack(giveStack)) player.dropStack(giveStack);
                    world.setBlockState(pos, state.with(PAINTINGS, Paintings.NONE).with(HAS_PHOTO, false));
                    return ActionResult.SUCCESS;
                }
                ItemStack giveStack = getItemFromPaintings(paintingsOn);
                if (!player.getInventory().insertStack(giveStack)) player.dropStack(giveStack);
                world.setBlockState(pos, state.with(PAINTINGS, Paintings.NONE));
                return ActionResult.SUCCESS;
            }
        } else {
            if (heldIsPhoto(heldItem)){
//                XheFurniture.LOGGER.info("held is photo");
                if (heldIsWhite(heldItem)){
//                    XheFurniture.LOGGER.info("held is white photo");
                    world.setBlockState(
                            pos,
                            state.with(HAS_PHOTO, true)
                                    .with(WHITE, true)
                                    .with(PHOTO_TYPE, getPhotoType(heldItem))
                    );
                    if (!player.isCreative()) heldStack.split(1);
                    return ActionResult.SUCCESS;
                }else {
//                    XheFurniture.LOGGER.info("held is black photo");
                    world.setBlockState(
                            pos,
                            state.with(HAS_PHOTO, true)
                                    .with(WHITE, false)
                                    .with(PHOTO_TYPE, getPhotoType(heldItem))
                    );
                    if (!player.isCreative()) heldStack.split(1);
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        }
    }

    public boolean heldIsPhoto(Item heldItem) {
                return  heldItem == ModBlocks.PHOTO_PAPER_WHITE_A.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_WHITE_B.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_WHITE_C.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_BLACK_A.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_BLACK_B.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_BLACK_C.asItem();
    }

    public Boolean heldIsWhite(Item heldItem) {
        return heldItem == ModBlocks.PHOTO_PAPER_WHITE_A.asItem() || heldItem == ModBlocks.PHOTO_PAPER_WHITE_B.asItem() || heldItem == ModBlocks.PHOTO_PAPER_WHITE_C.asItem();
    }

    public ItemStack getFromShelf(PhotoType photoType, Boolean white) {
        if (photoType == PhotoType.A) return white ? new ItemStack(ModBlocks.PHOTO_PAPER_WHITE_A, 1) :  new ItemStack(ModBlocks.PHOTO_PAPER_BLACK_A, 1);
        else if (photoType == PhotoType.B) return white ? new ItemStack(ModBlocks.PHOTO_PAPER_WHITE_B, 1) :  new ItemStack(ModBlocks.PHOTO_PAPER_BLACK_B, 1);
        else return white ? new ItemStack(ModBlocks.PHOTO_PAPER_WHITE_C, 1) :  new ItemStack(ModBlocks.PHOTO_PAPER_BLACK_C, 1);
    }

    public PhotoType getPhotoType(Item heldItem) {
        if (heldItem == ModBlocks.PHOTO_PAPER_WHITE_A.asItem() || heldItem == ModBlocks.PHOTO_PAPER_BLACK_A.asItem()) return PhotoType.A;
        if (heldItem == ModBlocks.PHOTO_PAPER_WHITE_B.asItem() || heldItem == ModBlocks.PHOTO_PAPER_BLACK_B.asItem()) return PhotoType.B;
        if (heldItem == ModBlocks.PHOTO_PAPER_WHITE_C.asItem() || heldItem == ModBlocks.PHOTO_PAPER_BLACK_C.asItem()) return PhotoType.C;
        return PhotoType.A;
    }

    public enum PhotoType implements StringIdentifiable {
        A("a"),
        B("b"),
        C("c");

        private final String name;

        PhotoType(String name) {
            this.name = name;
        }

        @Override
        public String asString() {
            return name;
        }

    }
}
