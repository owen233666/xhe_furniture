package com.owen233666.block.painting;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EaselBlock extends AbstractPaintingBlock {
    public static final BooleanProperty DIRTY = BooleanProperty.of("dirty");

    public EaselBlock(Settings settings) {
        super(settings);
        this.setDefaultState(getDefaultState().with(PAINTINGS, Paintings.NONE).with(DIRTY, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(DIRTY);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        Item heldItem = stack.getItem();
        Paintings paintingsOn = state.get(PAINTINGS);
        Paintings paintingsTo = this.getPaintingsFromItem(heldItem);
        if (paintingsOn == Paintings.NONE) {//画架无画
            if (paintingsTo == Paintings.NONE) {//手中无画，不执行操作
                return ActionResult.PASS;
            }else {
                stack.split(1);
                if (player.isCreative()) stack.increment(1);
                world.setBlockState(pos, state.with(PAINTINGS, paintingsTo));
            }
        }else {//画架有画
            //获取要交换的画（ItemStack）
            ItemStack giveStack = this.getItemFromPaintings(paintingsOn);

            if (paintingsTo == Paintings.NONE) {//手中无画，取下画架上的画
                player.getInventory().insertStack(giveStack);
                return ActionResult.PASS;
            } else if (heldItem == Items.STICK) {//手持木棍（改变画架上的画的状态），此物品以后会被替换成刷子

                world.setBlockState(pos, state.with(WIP, true));
                return  ActionResult.SUCCESS;
            }else {//手中有画，和手上的交换
                if (!player.getInventory().insertStack(giveStack)) player.dropStack(giveStack);
                stack.split(1);
                if (player.isCreative()) stack.increment(1);
                //更新画架
                world.setBlockState(pos, state.with(PAINTINGS, paintingsTo));
                return ActionResult.CONSUME_PARTIAL;
            }
        }
        return ActionResult.PASS;
    }
}
