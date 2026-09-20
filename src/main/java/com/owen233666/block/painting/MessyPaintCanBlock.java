/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block.painting;

import com.mojang.serialization.MapCodec;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MessyPaintCanBlock extends HorizontalDirectionalBlock implements PaintBrushDyeable {
    public static final BooleanProperty DIRTY = BooleanProperty.create("dirty");
    private final float x1, y1, z1, x2, y2, z2;

    public MessyPaintCanBlock(Properties settings, float x1, float y1, float z1, float x2, float y2, float z2) {
        super(settings);
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
        this.registerDefaultState(this.stateDefinition.any().setValue(DIRTY, false));
    }

    // 1.20.5 起 BlockBehaviour.codec() 是抽象方法，每个具体方块都要给出自己的 MapCodec。
    //#if MC >= 12005
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        // 包围盒来自构造器参数，没有单参数构造器，所以这里捕获当前实例的六个坐标。
        return simpleCodec(properties -> new MessyPaintCanBlock(properties, this.x1, this.y1, this.z1, this.x2, this.y2, this.z2));
    }
    //#endif

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, DIRTY);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(x1, y1, z1, x2, y2, z2);
    }

    @Override
    public BooleanProperty getDirtyProperty() {
        return DIRTY;
    }

    // 1.20.5 起 BlockBehaviour#use 被拆成 useItemOn / useWithoutItem。
    //#if MC >= 12005
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (dyeWithBrush(world, pos, state, player, hand).consumesAction()) {
            return ItemInteractionResult.SUCCESS;
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }
    //#else
    //$$ @Override
    //$$ public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    //$$     if (dyeWithBrush(world, pos, state, player, hand).consumesAction()) {
    //$$         return InteractionResult.SUCCESS;
    //$$     }
    //$$     return super.use(state, world, pos, player, hand, hit);
    //$$ }
    //#endif
}
