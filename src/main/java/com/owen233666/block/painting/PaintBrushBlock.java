/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block.painting;

import com.mojang.serialization.MapCodec;
import com.owen233666.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
//#if MC >= 12005
import net.minecraft.world.ItemInteractionResult;
//#endif
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PaintBrushBlock extends HorizontalDirectionalBlock {
    public static final IntegerProperty DURABILITY = IntegerProperty.create("durability", 0, 64);
    public static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 2, 15);

    public PaintBrushBlock(Properties settings) {
        super(settings);
    }

    // 1.20.5 起 BlockBehaviour.codec() 是抽象方法，每个具体方块都要给出自己的 MapCodec。
    //#if MC >= 12005
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(PaintBrushBlock::new);
    }
    //#endif

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, DURABILITY);
    }

    // 1.20.5 起 BlockBehaviour#use 被拆成 useItemOn / useWithoutItem。
    //#if MC >= 12005
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (Block.byItem(stack.getItem()) instanceof WetSpongeBlock && state.getValue(DURABILITY) != 0){
            world.setBlockAndUpdate(pos, state.setValue(DURABILITY, 0));
            return ItemInteractionResult.SUCCESS;
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }
    //#else
    //$$ @Override
    //$$ public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    //$$     if (Block.byItem(player.getItemInHand(hand).getItem()) instanceof WetSpongeBlock && state.getValue(DURABILITY) != 0){
    //$$         world.setBlockAndUpdate(pos, state.setValue(DURABILITY, 0));
    //$$         return InteractionResult.SUCCESS;
    //$$     }
    //$$     return super.use(state, world, pos, player, hand, hit);
    //$$ }
    //#endif

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(world, player, pos, state, blockEntity, tool);
        if (player.isCreative()) return;
        int durability = state.getValue(DURABILITY);
        ItemStack toDropStack = new ItemStack(ModItems.PAINT_BRUSH.get(), 1);
        // 1.20.1 的 Item#getMaxDamage() 是 Forge/NeoForge 的物品扩展方法，1.21.1 已经移除
        // （最大耐久改由 MAX_DAMAGE 数据组件保存），所以在现代分支改为从 ItemStack 读取；
        // 两个版本的 ItemStack#getMaxDamage() 语义一致，行为不变。
        //#if MC >= 12005
        toDropStack.setDamageValue(toDropStack.getMaxDamage() - durability);
        //#else
        //$$ toDropStack.setDamageValue(ModItems.PAINT_BRUSH.get().getMaxDamage() - durability);
        //#endif
        popResource(world, pos, toDropStack);
    }
}
