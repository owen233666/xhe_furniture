package com.owen233666.block.painting;

import com.owen233666.block.entity.BookLikeBlockEntity;
import com.owen233666.block.entity.GridShelfBlockEntity;
import com.owen233666.item.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class OpenBookBlock extends HorizontalDirectionalBlock implements EntityBlock {
    public static final IntegerProperty STATE = IntegerProperty.create("state", 1, 5);

    public static final VoxelShape SHAPE = box(2, 0, 2,14, 14, 14);

    public OpenBookBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, STATE);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Random random = new Random();
        return this.defaultBlockState()
                .setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())
                .setValue(STATE, random.nextInt(1, 6));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        ItemStack heldStack = player.getItemInHand(interactionHand);
        Item heldItem = heldStack.getItem();
        BlockEntity blockEntity = level.getBlockEntity(blockPos);

        if (blockEntity instanceof BookLikeBlockEntity bookLikeBlockEntity) {
            if (heldStack.isEmpty()) {
                if (player.isShiftKeyDown()) {
                    int bstate = blockState.getValue(STATE);
                    int state;
                    if (bstate + 1 > 5) {
                        state = 1;
                    }else {
                        state = bstate + 1;
                    }
                    level.setBlockAndUpdate(blockPos, blockState.setValue(STATE, state));
                    return InteractionResult.SUCCESS;
                }else {
                    remove(level, blockPos, player, bookLikeBlockEntity);
                }
            }
            if (heldIsPainting(heldItem)) {
                remove(level, blockPos, player, bookLikeBlockEntity);
                addItem(level, blockPos, player, bookLikeBlockEntity, heldStack);
                return InteractionResult.SUCCESS;
            }
            if (!(bookLikeBlockEntity.getInv().getFirst() == ItemStack.EMPTY)){
                remove(level, blockPos, player, bookLikeBlockEntity);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BookLikeBlockEntity(blockPos, blockState);
    }

    public boolean heldIsPainting(Item heldItem) {
        return BuiltInRegistries.ITEM.wrapAsHolder(heldItem).is(ModItemTags.PAINTINGS);
    }

    public void addItem(Level world, BlockPos pos, Player player, BookLikeBlockEntity bookLikeBlockEntity, ItemStack stack){
        if(!world.isClientSide()) {
            bookLikeBlockEntity.setStack(stack.split(1));
            world.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(player.isCreative()) {
                stack.grow(1);
            }
        }
    }

    public void remove(Level world, BlockPos pos, Player player, BookLikeBlockEntity bookLikeBlockEntity){
        if(!world.isClientSide()) {
            ItemStack toRemoveStack =bookLikeBlockEntity.removeStack();
            world.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().add(toRemoveStack)){
                player.spawnAtLocation(toRemoveStack);
            }
        }
    }
}
