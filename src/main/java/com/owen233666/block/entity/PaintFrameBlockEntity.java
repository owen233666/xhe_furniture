package com.owen233666.block.entity;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PaintFrameBlockEntity extends BlockEntity {
    private NonNullList<ItemStack> inventory;

    public PaintFrameBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.PAINTING_FRAME_BLOCK_BE, blockPos, blockState);
        this.inventory = NonNullList.withSize(1, ItemStack.EMPTY);
    }

    public void setStack(ItemStack stack) {
        this.inventory.set(0, stack);
        setChanged();
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        super.loadAdditional(nbt, registries);
        this.inventory = NonNullList.withSize(1, ItemStack.EMPTY);
        ContainerHelper.loadAllItems(nbt, this.inventory, registries);
    }

    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        ContainerHelper.saveAllItems(nbt, this.inventory, registries);
        super.saveAdditional(nbt, registries);
    }

    @Override
    public void setChanged() {
        Level world = this.level;
        if (world instanceof ServerLevel serverWorld) {
            if(!this.level.isClientSide()){
                Packet<ClientGamePacketListener> updatePacket = this.getUpdatePacket();
                for(ServerPlayer serverPlayerEntity : serverWorld.getChunkSource().chunkMap.getPlayersCloseForSpawning(new ChunkPos(this.getBlockPos()))) {
                    serverPlayerEntity.connection.send(updatePacket);
                }
            }
        }
        super.setChanged();
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveWithoutMetadata(registries);
    }

    public NonNullList<ItemStack> getInv() {
        return this.inventory;
    }

    public void setInv(NonNullList<ItemStack> inventory) {
        for(int i = 0; i < inventory.size(); ++i) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    public ItemStack removeStack() {
        ItemStack itemstack = this.inventory.set(0, ItemStack.EMPTY);
        setChanged();
        return itemstack;
    }

}