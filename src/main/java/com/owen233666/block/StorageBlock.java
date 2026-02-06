package com.owen233666.block;

import com.owen233666.block.entity.StorageBlockEntity;
import com.owen233666.util.BlockUtil;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class StorageBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    protected StorageBlock(Settings settings) {
        super(settings);
    }

    public abstract int size();

    public abstract Identifier type();

    public abstract Boolean canInsertStack(ItemStack stack);

    public abstract Direction[] unAllowedDirections();

    public abstract int getSection(float x, float y);

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity be = world.getBlockEntity(pos);
        ItemStack heldStack = player.getStackInHand(hand);

        if(be instanceof StorageBlockEntity storageBlockEntity){

            Optional<Pair<Float, Float>> hitPos = BlockUtil.getHitSectionCoordinate(hit, state.get(FACING), this.unAllowedDirections());
            if (hitPos.isEmpty()) {
                return ActionResult.PASS;
            }

            Pair<Float, Float> coordinate = hitPos.get();
            int section = this.getSection(coordinate.getLeft(), coordinate.getRight());
            if (section == Integer.MIN_VALUE) {
                return  ActionResult.PASS;
            }

            ItemStack firstItem = storageBlockEntity.getInv().get(section);
            boolean hasItem = !firstItem.isEmpty();

            if(hasItem){
                remove(world, pos, player, storageBlockEntity, section);
                return ActionResult.SUCCESS;
            }

            if(!heldStack.isEmpty()){
                boolean canInsert = this.canInsertStack(heldStack);

                if(canInsert){
                    this.add(world, pos, player, storageBlockEntity, heldStack, section);
                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }

    public void remove(World world, BlockPos pos, PlayerEntity player, StorageBlockEntity storageBlockEntity, int index){
        if(!world.isClient()) {
            ItemStack toRemoveStack =storageBlockEntity.removeStack(index);
            world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().insertStack(toRemoveStack)){
                player.dropStack(toRemoveStack);
            }
        }
    }

    public void add(World world, BlockPos pos, PlayerEntity player, StorageBlockEntity storageBlockEntity, ItemStack stack, int index){
        if(!world.isClient()) {
            storageBlockEntity.setStack(index, stack.split(1));
            world.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if(player.isCreative()) {
                stack.increment(1);
            }
        }
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        Block block = state.getBlock();
        if(!state.equals(newState)) {
            BlockEntity be  =  world.getBlockEntity(pos);
            if(be instanceof StorageBlockEntity storageBlockEntity){
                if(world instanceof ServerWorld serverWorld){
                    ItemScatterer.spawn(serverWorld, pos, storageBlockEntity.getInv());
                }
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public @NotNull BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StorageBlockEntity(pos, state, this.size());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }
}
