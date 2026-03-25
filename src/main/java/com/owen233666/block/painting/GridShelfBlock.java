package com.owen233666.block.painting;

import com.owen233666.block.ModBlocks;
import com.owen233666.item.ModItemTags;
import com.owen233666.util.BlockUtil;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GridShelfBlock extends HorizontalDirectionalBlock implements EntityBlock {
    public static final BooleanProperty WHITE = BooleanProperty.create("white");
    public static final BooleanProperty HAS_PHOTO  = BooleanProperty.create("has_photo");
    public static final EnumProperty<PhotoType> PHOTO_TYPE = EnumProperty.create("photo_type", PhotoType.class);

    public static final Supplier<VoxelShape> SHAPE_SUPPLIER = () -> Block.box(0, 0, 15F, 16, 16, 16);
    public static final Map<Direction, VoxelShape> SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
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

    public GridShelfBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(HAS_PHOTO, false)
                        .setValue(WHITE, true)
                        .setValue(PHOTO_TYPE, PhotoType.A)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(PHOTO_TYPE, HAS_PHOTO, WHITE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE.get(state.getValue(FACING));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        Item heldItem = heldStack.getItem();
        Boolean hasPhoto = state.getValue(HAS_PHOTO);
        Boolean white = state.getValue(WHITE);
        PhotoType photoType = state.getValue(PHOTO_TYPE);

        if (!world.isClientSide) {
            if (hasPhoto) {
                if (heldIsPhoto(heldItem)) {
                    return InteractionResult.PASS;
                }

                if ()
            }
        }
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    public boolean heldIsPhoto(Item heldItem) {
                return  heldItem == ModBlocks.PHOTO_PAPER_WHITE_A.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_WHITE_B.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_WHITE_C.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_BLACK_A.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_BLACK_B.asItem() ||
                        heldItem == ModBlocks.PHOTO_PAPER_BLACK_C.asItem();
    }

    public boolean heldIsPainting(Item heldItem) {
        return BuiltInRegistries.ITEM.wrapAsHolder(heldItem).is(ModItemTags.PAINTINGS);
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

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return null;
    }

    public enum PhotoType implements StringRepresentable {
        A("a"),
        B("b"),
        C("c");

        private final String name;

        PhotoType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return name;
        }

    }
}
