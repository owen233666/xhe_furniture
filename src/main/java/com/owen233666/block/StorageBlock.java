package com.owen233666.block;

import com.owen233666.block.entity.StorageBlockEntity;
import com.owen233666.util.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.*;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class StorageBlock extends HorizontalDirectionalBlock implements EntityBlock {
    protected StorageBlock(Properties settings) {
        super(settings);
    }

    public abstract int size();

    public abstract ResourceLocation type();

    public abstract Boolean canInsertStack(ItemStack stack);

    public abstract Direction[] unAllowedDirections();

    public abstract int getSection(float x, float y);

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity be = world.getBlockEntity(pos);
        ItemStack heldStack = player.getItemInHand(hand);

        if(be instanceof StorageBlockEntity storageBlockEntity){

            Optional<Tuple<Float, Float>> hitPos = BlockUtil.getHitSectionCoordinate(hit, state.getValue(FACING), this.unAllowedDirections());
            if (hitPos.isEmpty()) {
                return InteractionResult.PASS;
            }

            Tuple<Float, Float> coordinate = hitPos.get();
            int section = this.getSection(coordinate.getA(), coordinate.getB());
            if (section == Integer.MIN_VALUE) {
                return  InteractionResult.PASS;
            }

            ItemStack firstItem = storageBlockEntity.getInv().get(section);
            boolean hasItem = !firstItem.isEmpty();

            if(hasItem){
                remove(world, pos, player, storageBlockEntity, section);
                return InteractionResult.SUCCESS;
            }

            if(!heldStack.isEmpty()){
                boolean canInsert = this.canInsertStack(heldStack);

                if(canInsert){
                    this.addItem(world, pos, player, storageBlockEntity, heldStack, section);
                    return InteractionResult.SUCCESS;
                }
            }

            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    public void remove(Level world, BlockPos pos, Player player, StorageBlockEntity storageBlockEntity, int index){
        if(!world.isClientSide()) {
            ItemStack toRemoveStack =storageBlockEntity.removeStack(index);
            world.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().add(toRemoveStack)){
                player.spawnAtLocation(toRemoveStack);
            }
        }
    }

    public void addItem(Level world, BlockPos pos, Player player, StorageBlockEntity storageBlockEntity, ItemStack stack, int index){
        if(!world.isClientSide()) {
            storageBlockEntity.setStack(index, stack.split(1));
            world.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(player.isCreative()) {
                stack.grow(1);
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        Block block = state.getBlock();
        if(!state.equals(newState)) {
            BlockEntity be  =  world.getBlockEntity(pos);
            if(be instanceof StorageBlockEntity storageBlockEntity){
                if(world instanceof ServerLevel serverWorld){
                    Containers.dropContents(serverWorld, pos, storageBlockEntity.getInv());
                }
            }
        }
        super.onRemove(state, world, pos, newState, moved);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StorageBlockEntity(pos, state, this.size());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }
}
