package com.owen233666.item;

import com.owen233666.XheFurniture;
import com.owen233666.block.painting.*;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class PaintBrushItem extends Item implements Vanishable {
    private final Block block;

    public PaintBrushItem(Settings settings, Block block) {
        super(settings);
        this.block = block;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState blockstate = world.getBlockState(pos);
        Block clickedBlock = blockstate.getBlock();
        ItemStack itemstack = context.getStack();
        PlayerEntity playerentity = context.getPlayer();

        if (clickedBlock instanceof EaselBlock || clickedBlock instanceof CanvasBlock) {
            return ActionResult.SUCCESS;
        }

        BlockPos placePos = pos.offset(context.getSide());

        if (!world.getBlockState(placePos).isReplaceable()) {
            return ActionResult.FAIL;
        }

        if (!world.canSetBlock(placePos)) {
            return ActionResult.FAIL;
        }

        if (!world.isClient && playerentity.isSneaking()) {
            Direction facing = playerentity.getHorizontalFacing().getOpposite();

            if (clickedBlock instanceof DyeablePaintCanBlock) {
                itemstack.setDamage(0);
                return ActionResult.SUCCESS;
            }

            int currentDurability = itemstack.getMaxDamage() - itemstack.getDamage();

            BlockState placementState = (block).getDefaultState()
                    .with(PaintBrushBlock.FACING, facing)
                    .with(PaintBrushBlock.DURABILITY, currentDurability);

            world.setBlockState(placePos, placementState, 3);

            BlockSoundGroup soundGroup = block.getDefaultState().getSoundGroup();
            world.playSound(null, placePos, soundGroup.getPlaceSound(), SoundCategory.BLOCKS,
                    (soundGroup.getVolume() + 1.0F) / 2.0F, soundGroup.getPitch() * 0.8F);

            world.emitGameEvent(GameEvent.BLOCK_PLACE, placePos, GameEvent.Emitter.of(playerentity, placementState));

            if (playerentity instanceof ServerPlayerEntity serverPlayer) {
                Criteria.PLACED_BLOCK.trigger(serverPlayer, placePos, itemstack);
            }

            if (playerentity == null || !playerentity.getAbilities().creativeMode) {
                itemstack.decrement(1);
            }
        }

        return ActionResult.success(world.isClient);
    }


//    @Override
//    public ActionResult useOnBlock(ItemUsageContext context) {
//        World world = context.getWorld();
//        BlockState blockstate = world.getBlockState(context.getBlockPos());
//        Block block = blockstate.getBlock();
//        ItemStack itemstack = context.getStack();
//        PlayerEntity playerentity = context.getPlayer();
//        if (itemstack.getMaxDamage() - itemstack.getDamage() == 0) {
//            return ActionResult.FAIL;
//        }
//
//        if (block instanceof EaselBlock){
//            return ActionResult.SUCCESS;
//        }
//
//        if (block instanceof CanvasBlock){
//            return ActionResult.SUCCESS;
//        }
//        return ActionResult.SUCCESS;
//    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return this.getMaxCount() == 1;
    }
}
