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

public class EaselBlockEntity extends BlockEntity {
    private NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);
    private Boolean wip;

    public EaselBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.EASEL_BLOCK_BE, pos, state);
        this.wip = false;
    }

    public void setStack(ItemStack stack) {
        this.inventory.set(0, stack);
        setChanged();
    }

    public void setWip(boolean wip) {
        this.wip = wip;
        setChanged();
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.inventory = NonNullList.withSize(1, ItemStack.EMPTY);
        this.wip = nbt.getBoolean("wip");
        ContainerHelper.loadAllItems(nbt, this.inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        ContainerHelper.saveAllItems(nbt, this.inventory);
        nbt.putBoolean("wip", wip);
        super.saveAdditional(nbt);
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
    public @NotNull CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
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
