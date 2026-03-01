package com.owen233666.block;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag options) {
        super.appendHoverText(stack, world, tooltip, options);
        tooltip.add(Component.translatable("tooltip.xhe_furniture.rattan_table").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Block block = state.getBlock();
        if (block instanceof RattanTableBlock) {
            RattanTableClothColor COLOR = state.getValue(CLOTH_COLOR);
            Item heldItem = player.getItemInHand(hand).getItem();
            if (!player.isShiftKeyDown()) {
                return switch (heldItem) {
                    case Item item when item == Items.ORANGE_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.ORANGE));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.PURPLE_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.DEEP_PURPLE));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.GREEN_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.DEEP_GREEN));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.BLUE_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.DEEP_BLUE));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.WHITE_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.WHITE));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.PINK_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.PINK));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.MAGENTA_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.PURPLE));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.RED_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.RED));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.LIME_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.GREEN));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.LIGHT_BLUE_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.BLUE));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    case Item item when item == Items.YELLOW_CARPET -> {
                        world.setBlockAndUpdate(pos, state.setValue(CLOTH_COLOR, RattanTableClothColor.YELLOW));
                        stack.split(1);
                        if (player.isCreative()) stack.grow(1);
                        yield InteractionResult.CONSUME;
                    }
                    default -> {
                        world.setBlockAndUpdate(pos, state);
                        yield InteractionResult.PASS;
                    }
                };
            } else if (player.isShiftKeyDown() && player.getItemInHand(hand).isEmpty()) {
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
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

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
