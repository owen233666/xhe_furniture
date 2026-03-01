package com.owen233666.block.entity;

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

public class StorageBlockEntity extends BlockEntity {
    private int size;
    private NonNullList<ItemStack> inventory;

    public StorageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.STORAGE_BLOCK_BE, pos, state);
    }

    public StorageBlockEntity(BlockPos pos, BlockState state, int size) {
        super(ModBlockEntityTypes.STORAGE_BLOCK_BE, pos, state);
        this.size = size;
        this.inventory = NonNullList.withSize(this.size, ItemStack.EMPTY);
    }

    public ItemStack removeStack(int slot) {
        ItemStack itemstack = this.inventory.set(slot, ItemStack.EMPTY);
        setChanged();
        return itemstack;
    }

    public void setStack(int slot, ItemStack stack) {
        this.inventory.set(slot, stack);
        setChanged();
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

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.size = nbt.getInt("size");
        this.inventory = NonNullList.withSize(this.size, ItemStack.EMPTY);
        ContainerHelper.loadAllItems(nbt, this.inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        ContainerHelper.saveAllItems(nbt, this.inventory);
        nbt.putInt("size", this.size);
        super.saveAdditional(nbt);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    public void setInv(NonNullList<ItemStack> inventory) {
        for(int i = 0; i < inventory.size(); ++i) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    public NonNullList<ItemStack> getInv() {
        return this.inventory;
    }
}
