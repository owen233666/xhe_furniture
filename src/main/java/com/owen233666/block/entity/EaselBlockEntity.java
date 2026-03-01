package com.owen233666.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
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

public class EaselBlockEntity extends BlockEntity {
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private Boolean wip;

    public EaselBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.EASEL_BLOCK_BE, pos, state);
        this.wip = false;
    }

    public void setStack(ItemStack stack) {
        this.inventory.set(0, stack);
        markDirty();
    }

    public void setWip(boolean wip) {
        this.wip = wip;
        markDirty();
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
        this.wip = nbt.getBoolean("wip");
        Inventories.readNbt(nbt, this.inventory);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, this.inventory);
        nbt.putBoolean("wip", wip);
        super.writeNbt(nbt);
    }

    @Override
    public void markDirty() {
        World world = this.world;
        if (world instanceof ServerWorld serverWorld) {
            if(!this.world.isClient()){
                Packet<ClientPlayPacketListener> updatePacket = this.getUpdatePacket();
                for(ServerPlayerEntity serverPlayerEntity : serverWorld.getChunkManager().threadedAnvilChunkStorage.getPlayersWatchingChunk(new ChunkPos(this.getPos()))) {
                    serverPlayerEntity.networkHandler.sendPacket(updatePacket);
                }
            }
        }
        super.markDirty();
    }

    public BlockEntityUpdateS2CPacket getUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public @NotNull NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    public DefaultedList<ItemStack> getInv() {
        return this.inventory;
    }

    public void setInv(DefaultedList<ItemStack> inventory) {
        for(int i = 0; i < inventory.size(); ++i) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    public ItemStack removeStack() {
        ItemStack itemstack = this.inventory.set(0, ItemStack.EMPTY);
        markDirty();
        return itemstack;
    }
}
