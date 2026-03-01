package com.owen233666.item;

import com.owen233666.XheFurniture;
import com.owen233666.block.painting.*;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class PaintBrushItem extends Item implements Vanishable {
    private final Block block;

    public PaintBrushItem(Properties settings, Block block) {
        super(settings);
        this.block = block;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(pos);
        Block clickedBlock = blockstate.getBlock();
        ItemStack itemstack = context.getItemInHand();
        Player playerentity = context.getPlayer();

        if (clickedBlock instanceof EaselBlock || clickedBlock instanceof CanvasBlock) {
            return InteractionResult.SUCCESS;
        }

        BlockPos placePos = pos.relative(context.getClickedFace());

        if (!world.getBlockState(placePos).canBeReplaced()) {
            return InteractionResult.FAIL;
        }

        if (!world.isLoaded(placePos)) {
            return InteractionResult.FAIL;
        }

        if (!world.isClientSide && playerentity.isShiftKeyDown()) {
            Direction facing = playerentity.getDirection().getOpposite();

            if (clickedBlock instanceof DyeablePaintCanBlock) {
                itemstack.setDamageValue(0);
                return InteractionResult.SUCCESS;
            }

            int currentDurability = itemstack.getMaxDamage() - itemstack.getDamageValue();

            BlockState placementState = (block).defaultBlockState()
                    .setValue(PaintBrushBlock.FACING, facing)
                    .setValue(PaintBrushBlock.DURABILITY, currentDurability);

            world.setBlock(placePos, placementState, 3);

            SoundType soundGroup = block.defaultBlockState().getSoundType();
            world.playSound(null, placePos, soundGroup.getPlaceSound(), SoundSource.BLOCKS,
                    (soundGroup.getVolume() + 1.0F) / 2.0F, soundGroup.getPitch() * 0.8F);

            world.gameEvent(GameEvent.BLOCK_PLACE, placePos, GameEvent.Context.of(playerentity, placementState));

            if (playerentity instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, placePos, itemstack);
            }

            if (playerentity == null || !playerentity.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
        }

        return InteractionResult.sidedSuccess(world.isClientSide);
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
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return this.getMaxStackSize() == 1;
    }
}
