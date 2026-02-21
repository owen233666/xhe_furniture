package com.owen233666.block.painting;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EaselBlock extends AbstractPaintingBlock {
    public static final BooleanProperty DIRTY = BooleanProperty.of("dirty");
    public static final BooleanProperty WIP = BooleanProperty.of("wip");
    public static final EnumProperty<CanvasType> CANVAS_TYPE = EnumProperty.of("canvas_type", CanvasType.class);
    public static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2 ,14, 32, 14);

    public EaselBlock(Settings settings) {
        super(settings);
        this.setDefaultState(getDefaultState()
                .with(PAINTINGS, Paintings.NONE)
                .with(DIRTY, false)
                .with(WIP, false)
                .with(CANVAS_TYPE, CanvasType.NONE)
        );
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(DIRTY,CANVAS_TYPE, WIP);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getStackInHand(hand);
        Item heldItem = heldStack.getItem();
        boolean hasCanvas = hasCanvas(state.get(CANVAS_TYPE));
        boolean hasPainting = hasPainting(state.get(PAINTINGS));
        Paintings paintingsOn = state.get(PAINTINGS);
        Paintings paintingsTo = this.getPaintingsFromItem(heldItem);

        if (player.getStackInHand(hand).isEmpty() && player.isSneaking()) {
            if (hasCanvas && !hasPainting) {
                CanvasType canvasType = state.get(CANVAS_TYPE);
                return switch (canvasType) {
                    case NONE -> {
                        yield ActionResult.PASS;
                    }
                    case CANVAS -> {
                        ItemStack giveStack = new ItemStack(ModBlocks.CANVAS);
                        if (!player.getInventory().insertStack(giveStack)) {
                            player.dropStack(giveStack);
                        }
                        world.setBlockState(pos, state.with(CANVAS_TYPE, CanvasType.NONE));
                        yield ActionResult.SUCCESS;
                    }
                    case DRAWING_BOARD -> {
                        ItemStack giveStack = new ItemStack(ModBlocks.DRAWING_BOARD);
                        if (!player.getInventory().insertStack(giveStack)) {
                            player.dropStack(giveStack);
                        }
                        world.setBlockState(pos, state.with(CANVAS_TYPE, CanvasType.NONE));
                        yield ActionResult.SUCCESS;
                    }
                };
            }
        }

        if (hasCanvas) {
            if (paintingsOn == paintingsTo) {
                return ActionResult.PASS;
            } else if (paintingsTo == Paintings.NONE) {
                if (hasPainting) {
                    ItemStack giveStack = this.getItemFromPaintings(paintingsOn);
                    if (!player.getInventory().insertStack(giveStack)) {
                        player.dropStack(giveStack);
                    }
                    world.setBlockState(pos, state.with(PAINTINGS, Paintings.NONE));
                    return ActionResult.SUCCESS;
                }
                return ActionResult.PASS;
            } else {
                ItemStack giveStack = this.getItemFromPaintings(paintingsOn);
                world.setBlockState(pos, state.with(PAINTINGS, paintingsTo));

                if (!player.isCreative()) {
                    heldStack.split(1);
                }

                if (!player.getInventory().insertStack(giveStack)) {
                    player.dropStack(giveStack);
                }

                return ActionResult.SUCCESS;
            }
        } else {
            if (heldItem == ModBlocks.CANVAS.asItem()) {
                world.setBlockState(pos, state.with(CANVAS_TYPE, CanvasType.CANVAS));
                if (!player.isCreative()) {
                    heldStack.split(1);
                }
                return ActionResult.SUCCESS;
            } else if (heldItem == ModBlocks.DRAWING_BOARD.asItem()) {
                world.setBlockState(pos, state.with(CANVAS_TYPE, CanvasType.DRAWING_BOARD));
                if (!player.isCreative()) {
                    heldStack.split(1);
                }
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.PASS;
            }
        }
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
        if (player.isCreative()) return;
        if (hasCanvas(state.get(CANVAS_TYPE))) {
            ItemStack toDrop = state.get(CANVAS_TYPE) == CanvasType.CANVAS ? new ItemStack(ModBlocks.CANVAS, 1) : new ItemStack(ModBlocks.DRAWING_BOARD, 1);
            dropStack(world, pos, toDrop);
        }
        ItemStack paintings = getItemFromPaintings(state.get(PAINTINGS));
        dropStack(world, pos, paintings);
    }

    private boolean hasCanvas(CanvasType canvasType) {
        if (canvasType == CanvasType.NONE) {
            return false;
        }else {
            return true;
        }
    }

    private boolean hasPainting(Paintings paintings) {
        return paintings != Paintings.NONE;
    }

    protected enum CanvasType implements StringIdentifiable {
        NONE("none"),
        CANVAS("canvas"),
        DRAWING_BOARD("drawing_board");

        private final String name;

        CanvasType(String name) {
            this.name = name;
        }

        @Override
        public String asString() {
            return this.name;
        }
    }
}
