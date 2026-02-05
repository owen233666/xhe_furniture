package com.owen233666.block;

import com.owen233666.block.entity.StorageBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class StorageBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    protected StorageBlock(Settings settings) {
        super(settings);
    }

    public abstract int size();

    public abstract Identifier type();

    public abstract Boolean canInsertStack(ItemStack stack);

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        XheFurniture.LOGGER.info("=== StorageBlock.onUse START ===");

        BlockEntity be = world.getBlockEntity(pos);
        ItemStack heldStack = player.getStackInHand(hand);

        if(be instanceof StorageBlockEntity storageBlockEntity){
            ItemStack firstItem = storageBlockEntity.getInv().get(0);
            boolean hasItem = !firstItem.isEmpty();

//            XheFurniture.LOGGER.info("库存第一个物品: {}, 是否为空: {}", firstItem, firstItem.isEmpty());

            if(hasItem){  // 如果有物品
//                XheFurniture.LOGGER.info("执行移除操作");
                remove(world, pos, player, storageBlockEntity, 0);
                return ActionResult.SUCCESS;
            }

            if(!heldStack.isEmpty()){
//                XheFurniture.LOGGER.info("检查是否可以插入");
                boolean canInsert = this.canInsertStack(heldStack);
//                XheFurniture.LOGGER.info("检查结果: {}", canInsert);

                if(canInsert){
//                    XheFurniture.LOGGER.info("执行添加操作");
                    this.add(world, pos, player, storageBlockEntity, heldStack, 0);
                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.CONSUME;
        }

        return ActionResult.PASS;
    }

    public void remove(World world, BlockPos pos, PlayerEntity player, StorageBlockEntity storageBlockEntity, int index){
        if(!world.isClient()) {
//            System.out.println("StorageBlock.remove called"); //debug
            ItemStack toRemoveStack =storageBlockEntity.removeStack(index);
            world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().insertStack(toRemoveStack)){
                player.dropStack(toRemoveStack);
            }
        }
    }

    public void add(World world, BlockPos pos, PlayerEntity player, StorageBlockEntity storageBlockEntity, ItemStack stack, int index){
        if(!world.isClient()) {
//            System.out.println("StorageBlock.add called"); //debug
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
//            System.out.println("StorageBlock.onStateReplaced called"); //debug
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
//        System.out.println("StorageBlock.createBlockEntity called"); //debug
        return new StorageBlockEntity(pos, state, this.size());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        System.out.println("StorageBlock.appendProperties called"); //debug
        builder.add(new Property[]{FACING});
    }
}
