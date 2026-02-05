package com.owen233666.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class StorageBlockEntity extends BlockEntity {
    private int size;
    private DefaultedList<ItemStack> inventory;

    public StorageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.STORAGE_BLOCK_BE, pos, state);
    }

    public StorageBlockEntity(BlockPos pos, BlockState state, int size) {
        super(ModBlockEntityTypes.STORAGE_BLOCK_BE, pos, state);
        this.size = size;
        this.inventory = DefaultedList.ofSize(this.size, ItemStack.EMPTY);
    }

    public ItemStack removeStack(int slot) {
//        System.out.println("StorageBlockEntity.removeStack called"); //debug
        ItemStack itemstack = this.inventory.set(slot, ItemStack.EMPTY);
        setChanged();
        return itemstack;
    }

    public void setStack(int slot, ItemStack stack) {
//        System.out.println("StorageBlockEntity.setStack called"); //debug
        this.inventory.set(slot, stack);
        setChanged();
    }

    public void setChanged(){
        World world = this.world;
        if (world instanceof ServerWorld serverWorld) {
            if(!this.world.isClient()){
                Packet<ClientPlayPacketListener> updatePacket = this.getUpdatePacket();
//                System.out.println("StorageBlockEntity.setChanged called"); //debug
                for(ServerPlayerEntity serverPlayerEntity : serverWorld.getChunkManager().threadedAnvilChunkStorage.getPlayersWatchingChunk(new ChunkPos(this.getPos()))) {
                    serverPlayerEntity.networkHandler.sendPacket(updatePacket);
                }
            }
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.size = nbt.getInt("size");
        this.inventory = DefaultedList.ofSize(this.size, ItemStack.EMPTY);
//        System.out.println("StorageBlockEntity.readNbt called"); //debug
        Inventories.readNbt(nbt, this.inventory);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, this.inventory);
        nbt.putInt("size", this.size);
//        System.out.println("StorageBlockEntity.writeNbt called"); //debug
        super.writeNbt(nbt);
    }

    public BlockEntityUpdateS2CPacket getUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public @NotNull NbtCompound toInitialChunkDataNbt() {
//        System.out.println("StorageBlockEntity.toInitialChunkDataNbt called"); //debug
        return createNbt();
    }

    public void setInv(DefaultedList<ItemStack> inventory) {
        for(int i = 0; i < inventory.size(); ++i) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    public DefaultedList<ItemStack> getInv() {
        return this.inventory;
    }
}
