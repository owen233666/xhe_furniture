/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
//#if MC >= 12005
import net.minecraft.world.ItemInteractionResult;
//#endif
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RattanTableBlock extends HorizontalDirectionalBlock {
    public static final EnumProperty<RattanTableClothColor> CLOTH_COLOR = EnumProperty.create("cloth_color", RattanTableClothColor.class);
    public static final VoxelShape SHAPE =Shapes.or(
            Block.box(7.0F, 3.0F, 7.0F, 9.0F, 11.0F, 9.0F),
                new VoxelShape[]{
                    Block.box(5.5F, 13, 5.5F, 10.5F, 14.0F, 10.5F),
                    Block.box(6.5F, 11, 6.5F, 9.5F, 13F, 9.5F),
                    Block.box(6.5F, 2, 6.5F, 9.5F, 3F, 9.5F),
                    Block.box(6.5F, 9, 6.5F, 9.5F, 10F, 9.5F),
                    Block.box(5.5F, 0.5, 5.5F, 10.5F, 2.5F, 10.5F),
                    Block.box(4.5F, 0, 4.5F, 6.5F, 2F, 6.5F),
                    Block.box(4.5F, 0, 9.5F, 6.5F, 2F, 11.5F),
                    Block.box(9.5F, 0, 9.5F, 11.5F, 2F, 11.5F),
                    Block.box(9.5F, 0, 4.5f, 11.5F, 2F, 6.5F),
                    Block.box(1, 14, 1, 15, 16, 15)
                }
            );

    public RattanTableBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(CLOTH_COLOR, RattanTableClothColor.NONE));
    }

    // 1.20.5 起 BlockBehaviour.codec() 是抽象方法，每个具体方块都要给出自己的 MapCodec。
    //#if MC >= 12005
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(RattanTableBlock::new);
    }
    //#endif

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, CLOTH_COLOR);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    // 1.20.5 起 appendHoverText 的第二个参数由 BlockGetter 变成 Item.TooltipContext。
    //#if MC >= 12005
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        super.appendHoverText(stack, context, tooltip, options);
        tooltip.add(Component.translatable("tooltip.xhe_furniture.rattan_table").withStyle(ChatFormatting.GRAY));
    }
    //#else
    //$$ @Override
    //$$ public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag options) {
    //$$     super.appendHoverText(stack, world, tooltip, options);
    //$$     tooltip.add(Component.translatable("tooltip.xhe_furniture.rattan_table").withStyle(ChatFormatting.GRAY));
    //$$ }
    //#endif

    // 1.20.5 起 BlockBehaviour#use 被拆成 useItemOn / useWithoutItem。
    //#if MC >= 12005
    /** 把桌布换成 {@code color}，消耗一个手持物品（创造模式补回），返回 {@link ItemInteractionResult#CONSUME}。 */
    private static ItemInteractionResult applyCloth(Level world, BlockPos pos, BlockState state, ItemStack stack, Player player, RattanTableClothColor color) {
        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, color));
        stack.split(1);
        if (player.isCreative()) {
            stack.grow(1);
        }
        return ItemInteractionResult.CONSUME;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = stack;
        Block block = state.getBlock();
        if (block instanceof RattanTableBlock) {
            RattanTableClothColor COLOR = state.getValue(CLOTH_COLOR);
            Item heldItem = heldStack.getItem();
            if (!player.isShiftKeyDown()) {
                // 原来这里是 Java 21 的 switch 模式匹配 + when 守卫。1.20.1 目标按模板要求编译在
                // Java 17，所以改成等价的身份比较链，各版本一致，无需预处理器指令。
                if (heldItem == Items.ORANGE_CARPET)     return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.ORANGE);
                if (heldItem == Items.PURPLE_CARPET)     return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.DEEP_PURPLE);
                if (heldItem == Items.GREEN_CARPET)      return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.DEEP_GREEN);
                if (heldItem == Items.BLUE_CARPET)       return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.DEEP_BLUE);
                if (heldItem == Items.WHITE_CARPET)      return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.WHITE);
                if (heldItem == Items.PINK_CARPET)       return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.PINK);
                if (heldItem == Items.MAGENTA_CARPET)    return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.PURPLE);
                if (heldItem == Items.RED_CARPET)        return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.RED);
                if (heldItem == Items.LIME_CARPET)       return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.GREEN);
                if (heldItem == Items.LIGHT_BLUE_CARPET) return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.BLUE);
                if (heldItem == Items.YELLOW_CARPET)     return applyCloth(world, pos, state, heldStack, player, RattanTableClothColor.YELLOW);
                world.setBlockAndUpdate(pos, state);
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            } else if (player.isShiftKeyDown() && heldStack.isEmpty()) {
                switch (COLOR) {
                    case ORANGE -> {
                        if (!player.getInventory().add(new ItemStack(Items.ORANGE_CARPET)))      player.spawnAtLocation(new ItemStack(Items.ORANGE_CARPET));
                    }
                    case RED -> {
                        if (!player.getInventory().add(new ItemStack(Items.RED_CARPET)))         player.spawnAtLocation(new ItemStack(Items.RED_CARPET));
                    }
                    case DEEP_PURPLE -> {
                        if (!player.getInventory().add(new ItemStack(Items.PURPLE_CARPET)))      player.spawnAtLocation(new ItemStack(Items.PURPLE_CARPET));
                    }
                    case DEEP_GREEN -> {
                        if (!player.getInventory().add(new ItemStack(Items.GREEN_CARPET)))       player.spawnAtLocation(new ItemStack(Items.GREEN_CARPET));
                    }
                    case DEEP_BLUE -> {
                        if (!player.getInventory().add(new ItemStack(Items.BLUE_CARPET)))        player.spawnAtLocation(new ItemStack(Items.BLUE_CARPET));
                    }
                    case PINK -> {
                        if (!player.getInventory().add(new ItemStack(Items.PINK_CARPET)))        player.spawnAtLocation(new ItemStack(Items.PINK_CARPET));
                    }
                    case PURPLE -> {
                        if (!player.getInventory().add(new ItemStack(Items.MAGENTA_CARPET)))     player.spawnAtLocation(new ItemStack(Items.MAGENTA_CARPET));
                    }
                    case GREEN ->  {
                        if (!player.getInventory().add(new ItemStack(Items.LIME_CARPET)))        player.spawnAtLocation(new ItemStack(Items.LIME_CARPET));
                    }
                    case BLUE -> {
                        if (!player.getInventory().add(new ItemStack(Items.LIGHT_BLUE_CARPET)))  player.spawnAtLocation(new ItemStack(Items.LIGHT_BLUE_CARPET));
                    }
                    case YELLOW -> {
                        if (!player.getInventory().add(new ItemStack(Items.YELLOW_CARPET)))      player.spawnAtLocation(new ItemStack(Items.YELLOW_CARPET));
                    }
                }
                world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.NONE));
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    //#else
    //$$ /** 把桌布换成 {@code color}，消耗一个手持物品（创造模式补回），返回 {@link InteractionResult#CONSUME}。 */
    //$$ private static InteractionResult applyCloth(Level world, BlockPos pos, BlockState state, ItemStack stack, Player player, RattanTableClothColor color) {
    //$$     world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, color));
    //$$     stack.split(1);
    //$$     if (player.isCreative()) {
    //$$         stack.grow(1);
    //$$     }
    //$$     return InteractionResult.CONSUME;
    //$$ }
    //$$
    //$$ @Override
    //$$ public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    //$$     ItemStack stack = player.getItemInHand(hand);
    //$$     Block block = state.getBlock();
    //$$     if (block instanceof RattanTableBlock) {
    //$$         RattanTableClothColor COLOR = state.getValue(CLOTH_COLOR);
    //$$         Item heldItem = player.getItemInHand(hand).getItem();
    //$$         if (!player.isShiftKeyDown()) {
    //$$             // 原来这里是 Java 21 的 switch 模式匹配 + when 守卫。1.20.1 目标按模板要求编译在
    //$$             // Java 17，所以改成等价的身份比较链，各版本一致，无需预处理器指令。
    //$$             if (heldItem == Items.ORANGE_CARPET)     return applyCloth(world, pos, state, stack, player, RattanTableClothColor.ORANGE);
    //$$             if (heldItem == Items.PURPLE_CARPET)     return applyCloth(world, pos, state, stack, player, RattanTableClothColor.DEEP_PURPLE);
    //$$             if (heldItem == Items.GREEN_CARPET)      return applyCloth(world, pos, state, stack, player, RattanTableClothColor.DEEP_GREEN);
    //$$             if (heldItem == Items.BLUE_CARPET)       return applyCloth(world, pos, state, stack, player, RattanTableClothColor.DEEP_BLUE);
    //$$             if (heldItem == Items.WHITE_CARPET)      return applyCloth(world, pos, state, stack, player, RattanTableClothColor.WHITE);
    //$$             if (heldItem == Items.PINK_CARPET)       return applyCloth(world, pos, state, stack, player, RattanTableClothColor.PINK);
    //$$             if (heldItem == Items.MAGENTA_CARPET)    return applyCloth(world, pos, state, stack, player, RattanTableClothColor.PURPLE);
    //$$             if (heldItem == Items.RED_CARPET)        return applyCloth(world, pos, state, stack, player, RattanTableClothColor.RED);
    //$$             if (heldItem == Items.LIME_CARPET)       return applyCloth(world, pos, state, stack, player, RattanTableClothColor.GREEN);
    //$$             if (heldItem == Items.LIGHT_BLUE_CARPET) return applyCloth(world, pos, state, stack, player, RattanTableClothColor.BLUE);
    //$$             if (heldItem == Items.YELLOW_CARPET)     return applyCloth(world, pos, state, stack, player, RattanTableClothColor.YELLOW);
    //$$             world.setBlockAndUpdate(pos, state);
    //$$             return InteractionResult.PASS;
    //$$         } else if (player.isShiftKeyDown() && player.getItemInHand(hand).isEmpty()) {
    //$$             switch (COLOR) {
    //$$                 case ORANGE -> {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.ORANGE_CARPET)))      player.spawnAtLocation(new ItemStack(Items.ORANGE_CARPET));
    //$$                 }
    //$$                 case RED -> {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.RED_CARPET)))         player.spawnAtLocation(new ItemStack(Items.RED_CARPET));
    //$$                 }
    //$$                 case DEEP_PURPLE -> {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.PURPLE_CARPET)))      player.spawnAtLocation(new ItemStack(Items.PURPLE_CARPET));
    //$$                 }
    //$$                 case DEEP_GREEN -> {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.GREEN_CARPET)))       player.spawnAtLocation(new ItemStack(Items.GREEN_CARPET));
    //$$                 }
    //$$                 case DEEP_BLUE -> {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.BLUE_CARPET)))        player.spawnAtLocation(new ItemStack(Items.BLUE_CARPET));
    //$$                 }
    //$$                 case PINK -> {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.PINK_CARPET)))        player.spawnAtLocation(new ItemStack(Items.PINK_CARPET));
    //$$                 }
    //$$                 case PURPLE -> {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.MAGENTA_CARPET)))     player.spawnAtLocation(new ItemStack(Items.MAGENTA_CARPET));
    //$$                 }
    //$$                 case GREEN ->  {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.LIME_CARPET)))        player.spawnAtLocation(new ItemStack(Items.LIME_CARPET));
    //$$                 }
    //$$                 case BLUE -> {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.LIGHT_BLUE_CARPET)))  player.spawnAtLocation(new ItemStack(Items.LIGHT_BLUE_CARPET));
    //$$                 }
    //$$                 case YELLOW -> {
    //$$                     if (!player.getInventory().add(new ItemStack(Items.YELLOW_CARPET)))      player.spawnAtLocation(new ItemStack(Items.YELLOW_CARPET));
    //$$                 }
    //$$             }
    //$$             world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.NONE));
    //$$             return InteractionResult.SUCCESS;
    //$$         }
    //$$     }
    //$$     return InteractionResult.PASS;
    //$$ }
    //#endif

    public enum RattanTableClothColor implements StringRepresentable {
        NONE("none"),
        ORANGE("orange"),
        DEEP_PURPLE("deep_purple"),
        DEEP_GREEN("deep_green"),
        DEEP_BLUE("deep_blue"),
        WHITE("white"),
        PINK("pink"),
        PURPLE("purple"),
        RED("red"),
        GREEN("green"),
        BLUE("blue"),
        YELLOW("yellow");

        public final String color;

        RattanTableClothColor(String color) {
            this.color = color;
        }

        @Override
        public String getSerializedName() {
            return this.color;
        }
    }
}
