package com.owen233666.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RattanTableBlock extends HorizontalFacingBlock {
    public static final EnumProperty<RattanTableClothColor> CLOTH_COLOR = EnumProperty.of("cloth_color", RattanTableClothColor.class);
    public static final VoxelShape SHAPE =VoxelShapes.union(
            Block.createCuboidShape(7.0F, 3.0F, 7.0F, 9.0F, 11.0F, 9.0F),
                new VoxelShape[]{
                    Block.createCuboidShape(5.5F, 13, 5.5F, 10.5F, 14.0F, 10.5F),
                    Block.createCuboidShape(6.5F, 11, 6.5F, 9.5F, 13F, 9.5F),
                    Block.createCuboidShape(6.5F, 2, 6.5F, 9.5F, 3F, 9.5F),
                    Block.createCuboidShape(6.5F, 9, 6.5F, 9.5F, 10F, 9.5F),
                    Block.createCuboidShape(5.5F, 0.5, 5.5F, 10.5F, 2.5F, 10.5F),
                    Block.createCuboidShape(4.5F, 0, 4.5F, 6.5F, 2F, 6.5F),
                    Block.createCuboidShape(4.5F, 0, 9.5F, 6.5F, 2F, 11.5F),
                    Block.createCuboidShape(9.5F, 0, 9.5F, 11.5F, 2F, 11.5F),
                    Block.createCuboidShape(9.5F, 0, 4.5f, 11.5F, 2F, 6.5F),
                    Block.createCuboidShape(1, 14, 1, 15, 16, 15)
                }
            );

    public RattanTableBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(CLOTH_COLOR, RattanTableClothColor.NONE));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, CLOTH_COLOR);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        tooltip.add(Text.translatable("tooltip.xhe_furniture.rattan_table").formatted(Formatting.GRAY));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        Block block = state.getBlock();
        if (block instanceof RattanTableBlock) {
            RattanTableClothColor COLOR = state.get(CLOTH_COLOR);
            Item heldItem = player.getStackInHand(hand).getItem();
            if (!player.isSneaking()) {
                return switch (heldItem) {
                    case Item item when item == Items.ORANGE_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.ORANGE));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.PURPLE_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.DEEP_PURPLE));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.GREEN_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.DEEP_GREEN));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.BLUE_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.DEEP_BLUE));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.WHITE_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.WHITE));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.PINK_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.PINK));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.MAGENTA_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.PURPLE));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.RED_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.RED));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.LIME_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.GREEN));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.LIGHT_BLUE_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.BLUE));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    case Item item when item == Items.YELLOW_CARPET -> {
                        world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.YELLOW));
                        stack.split(1);
                        if (player.isCreative()) stack.increment(1);
                        yield ActionResult.CONSUME;
                    }
                    default -> {
                        world.setBlockState(pos, state);
                        yield ActionResult.PASS;
                    }
                };
            } else if (player.isSneaking() && player.getStackInHand(hand).isEmpty()) {
                switch (COLOR) {
                    case ORANGE -> {
                        if (!player.getInventory().insertStack(new ItemStack(Items.ORANGE_CARPET)))      player.dropStack(new ItemStack(Items.ORANGE_CARPET));
                    }
                    case RED -> {
                        if (!player.getInventory().insertStack(new ItemStack(Items.RED_CARPET)))         player.dropStack(new ItemStack(Items.RED_CARPET));
                    }
                    case DEEP_PURPLE -> {
                        if (!player.getInventory().insertStack(new ItemStack(Items.PURPLE_CARPET)))      player.dropStack(new ItemStack(Items.PURPLE_CARPET));
                    }
                    case DEEP_GREEN -> {
                        if (!player.getInventory().insertStack(new ItemStack(Items.GREEN_CARPET)))       player.dropStack(new ItemStack(Items.GREEN_CARPET));
                    }
                    case DEEP_BLUE -> {
                        if (!player.getInventory().insertStack(new ItemStack(Items.BLUE_CARPET)))        player.dropStack(new ItemStack(Items.BLUE_CARPET));
                    }
                    case PINK -> {
                        if (!player.getInventory().insertStack(new ItemStack(Items.PINK_CARPET)))        player.dropStack(new ItemStack(Items.PINK_CARPET));
                    }
                    case PURPLE -> {
                        if (!player.getInventory().insertStack(new ItemStack(Items.MAGENTA_CARPET)))     player.dropStack(new ItemStack(Items.MAGENTA_CARPET));
                    }
                    case GREEN ->  {
                        if (!player.getInventory().insertStack(new ItemStack(Items.LIME_CARPET)))        player.dropStack(new ItemStack(Items.LIME_CARPET));
                    }
                    case BLUE -> {
                        if (!player.getInventory().insertStack(new ItemStack(Items.LIGHT_BLUE_CARPET)))  player.dropStack(new ItemStack(Items.LIGHT_BLUE_CARPET));
                    }
                    case YELLOW -> {
                        if (!player.getInventory().insertStack(new ItemStack(Items.YELLOW_CARPET)))      player.dropStack(new ItemStack(Items.YELLOW_CARPET));
                    }
                }
                world.setBlockState(pos, state.with(CLOTH_COLOR, RattanTableClothColor.NONE));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    public enum RattanTableClothColor implements StringIdentifiable {
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
        public String asString() {
            return this.color;
        }
    }
}
