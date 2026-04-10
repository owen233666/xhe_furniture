package com.owen233666.block.painting;

import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.GridShelfBlockEntity;
import com.owen233666.item.ModItemTags;
import com.owen233666.util.BlockUtil;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.Containers;
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
        builder.add(FACING, PHOTO_TYPE, HAS_PHOTO, WHITE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE.get(state.getValue(FACING));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        Item heldItem = heldStack.getItem();
        BlockEntity blockEntity = world.getBlockEntity(pos);
        Boolean hasPhoto = state.getValue(HAS_PHOTO);

        if (blockEntity instanceof GridShelfBlockEntity gridShelfBlockEntity) {
            boolean hasPainting = !(gridShelfBlockEntity.getInv().getFirst() == ItemStack.EMPTY);
            if (hasPhoto) {
                if (heldStack.isEmpty()) {
                    if (hasPainting) {
                        remove(world, pos, player, gridShelfBlockEntity);
                        return InteractionResult.SUCCESS;
                    }
                }

                if (!hasPainting) {
                    if (heldIsPainting(heldItem)) {
                        addItem(world, pos, player, gridShelfBlockEntity, heldStack);
                        return InteractionResult.SUCCESS;
                    }
                }

                if (heldIsPhoto(heldItem)) {
                    ItemStack toGive = getFromShelf(state.getValue(PHOTO_TYPE), state.getValue(WHITE));

                    if (!player.addItem(toGive)) player.drop(toGive, false);

                    state = state.setValue(WHITE, heldIsWhite(heldItem));
                    state = state.setValue(PHOTO_TYPE, getPhotoType(heldItem));
                    world.setBlockAndUpdate(pos, state);
                    return InteractionResult.SUCCESS;
                }

                if (!(heldIsPainting(heldItem) || heldIsPhoto(heldItem))) {
                    ItemStack toGive = getFromShelf(state.getValue(PHOTO_TYPE), state.getValue(WHITE));

                    if (!player.addItem(toGive)) player.drop(toGive, false);

                    if (!(gridShelfBlockEntity.getInv().getFirst() == ItemStack.EMPTY)) remove(world, pos, player, gridShelfBlockEntity);

                    state = state.setValue(HAS_PHOTO, false);
                    state = state.setValue(WHITE, true);
                    state = state.setValue(PHOTO_TYPE, PhotoType.A);
                    world.setBlockAndUpdate(pos, state);
                    return InteractionResult.SUCCESS;
                }
            } else {
                if (heldIsPhoto(heldItem)) {
                    if (!player.isCreative()) heldStack.shrink(1);
                    state = state.setValue(HAS_PHOTO, true);
                    state = state.setValue(WHITE, heldIsWhite(heldItem));
                    state = state.setValue(PHOTO_TYPE, getPhotoType(heldItem));
                    world.setBlockAndUpdate(pos, state);
                    return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.PASS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new GridShelfBlockEntity(blockPos, blockState);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, blockState, blockEntity, itemStack);
        if (blockState.getValue(HAS_PHOTO)) {
            popResource(level, blockPos, getFromShelf(blockState.getValue(PHOTO_TYPE), blockState.getValue(WHITE)));
        }
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if(!state.equals(newState)) {
            BlockEntity be  =  world.getBlockEntity(pos);
            if(be instanceof GridShelfBlockEntity gridShelfBlockEntity){
                if(world instanceof ServerLevel serverWorld){
                    Containers.dropContents(serverWorld, pos, gridShelfBlockEntity.getInv());
                }
            }
        }
        super.onRemove(state, world, pos, newState, moved);
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
        return (Block.byItem(heldItem) == ModBlocks.PHOTO_PAPER_WHITE_A || Block.byItem(heldItem) == ModBlocks.PHOTO_PAPER_WHITE_B || Block.byItem(heldItem) == ModBlocks.PHOTO_PAPER_WHITE_C);
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

    public void addItem(Level world, BlockPos pos, Player player, GridShelfBlockEntity gridShelfBlockEntity, ItemStack stack){
        if(!world.isClientSide()) {
            gridShelfBlockEntity.setStack(stack.split(1));
            world.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(player.isCreative()) {
                stack.grow(1);
            }
        }
    }

    public void remove(Level world, BlockPos pos, Player player, GridShelfBlockEntity gridShelfBlockEntity){
        if(!world.isClientSide()) {
            ItemStack toRemoveStack =gridShelfBlockEntity.removeStack();
            world.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().add(toRemoveStack)){
                player.spawnAtLocation(toRemoveStack);
            }
        }
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
