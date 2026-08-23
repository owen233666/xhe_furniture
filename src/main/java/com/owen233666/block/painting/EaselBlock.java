package com.owen233666.block.painting;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.EaselBlockEntity;
import com.owen233666.item.ModItemTags;
import com.owen233666.item.PaintBrushItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class EaselBlock extends HorizontalDirectionalBlock implements EntityBlock, PaintBrushDyeable {
    public static final BooleanProperty DIRTY = BooleanProperty.create("dirty");
    public static final BooleanProperty WIP = BooleanProperty.create("wip");
    public static final EnumProperty<CanvasType> CANVAS_TYPE = EnumProperty.create("canvas_type", CanvasType.class);
    public static final VoxelShape SHAPE = Block.box(2, 0, 2 ,14, 32, 14);

    public EaselBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(defaultBlockState()
                .setValue(DIRTY, false)
                .setValue(WIP, false)
                .setValue(CANVAS_TYPE, CanvasType.NONE)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, DIRTY,CANVAS_TYPE, WIP);
    }

    @Override
    public BooleanProperty getDirtyProperty() {
        return DIRTY;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        Item heldItem = heldStack.getItem();
        boolean hasCanvas = hasCanvas(state.getValue(CANVAS_TYPE));
        BlockEntity be = world.getBlockEntity(pos);
        NonNullList<ItemStack> inventory;

        if (be instanceof EaselBlockEntity){
            inventory = ((EaselBlockEntity) be).getInv();
        }else {
            inventory = NonNullList.withSize(1, ItemStack.EMPTY);
        }
        boolean hasPainting =!(inventory.getFirst() == ItemStack.EMPTY);

        if (heldItem instanceof PaintBrushItem) {
            InteractionResult dyeResult = dyeWithBrush(world, pos, state, player, hand);
            if (dyeResult.consumesAction()) {
                return dyeResult;
            }
        }

        if (byItem(heldItem) instanceof WetSpongeBlock){

            if (state.getValue(DIRTY)) {
                world.setBlockAndUpdate(pos, state.setValue(DIRTY, false));
                return InteractionResult.SUCCESS;
            }else {
                return InteractionResult.PASS;
            }
        }

        if (byItem(heldItem) instanceof CanvasBlock){

            if (!hasCanvas){
                if (byItem(heldItem) == ModBlocks.CANVAS){
                    world.setBlockAndUpdate(pos, state.setValue(CANVAS_TYPE, CanvasType.CANVAS));
                }else {
                    world.setBlockAndUpdate(pos, state.setValue(CANVAS_TYPE, CanvasType.DRAWING_BOARD));
                }
                if (!player.isCreative()) heldStack.shrink(1);
                return InteractionResult.CONSUME;
            }else {
                if (state.getValue(CANVAS_TYPE) == CanvasType.CANVAS){
                    ItemStack stack = new ItemStack(ModBlocks.CANVAS, 1);
                    if (!player.getInventory().add(stack)) player.spawnAtLocation(stack);
                }else{
                    ItemStack stack = new ItemStack(ModBlocks.DRAWING_BOARD, 1);
                    if (!player.getInventory().add(stack)) player.spawnAtLocation(stack);
                }
                return InteractionResult.SUCCESS;
            }
        }

        if (player.getItemInHand(hand).isEmpty() && player.isShiftKeyDown()) {
            if (hasCanvas && !hasPainting) {
                CanvasType canvasType = state.getValue(CANVAS_TYPE);
                return switch (canvasType) {
                    case NONE -> {
                        yield InteractionResult.PASS;
                    }
                    case CANVAS -> {
                        ItemStack giveStack = new ItemStack(ModBlocks.CANVAS);
                        if (!player.getInventory().add(giveStack)) {
                            player.spawnAtLocation(giveStack);
                        }
                        world.setBlockAndUpdate(pos, state.setValue(CANVAS_TYPE, CanvasType.NONE));
                        yield InteractionResult.SUCCESS;
                    }
                    case DRAWING_BOARD -> {
                        ItemStack giveStack = new ItemStack(ModBlocks.DRAWING_BOARD);
                        if (!player.getInventory().add(giveStack)) {
                            player.spawnAtLocation(giveStack);
                        }
                        world.setBlockAndUpdate(pos, state.setValue(CANVAS_TYPE, CanvasType.NONE));
                        yield InteractionResult.SUCCESS;
                    }
                };
            }
        }

        if (be instanceof EaselBlockEntity easelBlockEntity){
            boolean heldIsPainting = BuiltInRegistries.ITEM.wrapAsHolder(heldItem).is(ModItemTags.PAINTINGS);
            XheFurniture.LOGGER.info(String.valueOf(heldIsPainting));
            if (!hasCanvas)return InteractionResult.PASS;
            if (!(inventory.isEmpty() || inventory.getFirst() == ItemStack.EMPTY)) {
                if (heldIsPainting){
                    addItem(world, pos, player, easelBlockEntity, heldStack);
                    return InteractionResult.CONSUME;
                }else {
                    remove(world, pos, player, easelBlockEntity);
                    return InteractionResult.PASS;
                }
            }else {
                if (!hasCanvas)return InteractionResult.PASS;
                if (heldIsPainting){
                    remove(world, pos, player, easelBlockEntity);
                    addItem(world, pos, player, easelBlockEntity, heldStack);
                    return InteractionResult.CONSUME;
                }else{
                    remove(world, pos, player, easelBlockEntity);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if(!state.equals(newState)) {
            BlockEntity be  =  world.getBlockEntity(pos);
            if(be instanceof EaselBlockEntity easelBlockEntity){
                if(world instanceof ServerLevel serverWorld){
                    Containers.dropContents(serverWorld, pos, easelBlockEntity.getInv());
                }
            }
        }
        super.onRemove(state, world, pos, newState, moved);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, blockState, blockEntity, itemStack);
        if (!player.isCreative()) {
            if (blockState.getValue(CANVAS_TYPE) == CanvasType.CANVAS) {
                popResource(level, blockPos, new ItemStack(ModBlocks.CANVAS));
            } else if (blockState.getValue(CANVAS_TYPE) == CanvasType.DRAWING_BOARD) {
                popResource(level, blockPos, new ItemStack(ModBlocks.DRAWING_BOARD));
            }
        }
    }

    private boolean hasCanvas(CanvasType canvasType) {
        if (canvasType == CanvasType.NONE) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EaselBlockEntity(pos, state);
    }

    //向be的inv中添加物品的方法
    public void addItem(Level world, BlockPos pos, Player player, EaselBlockEntity easelBlockEntity, ItemStack stack){

        if(!world.isClientSide()) {
            easelBlockEntity.setStack(stack.split(1));
            world.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

            if(player.isCreative()) {
                stack.grow(1);
            }
        }
    }

    public void remove(Level world, BlockPos pos, Player player, EaselBlockEntity easelBlockEntity){
        if(!world.isClientSide()) {
            ItemStack toRemoveStack =easelBlockEntity.removeStack();
            world.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().add(toRemoveStack)){
                player.spawnAtLocation(toRemoveStack);
            }
        }
    }

    protected enum CanvasType implements StringRepresentable {
        NONE("none"),
        CANVAS("canvas"),
        DRAWING_BOARD("drawing_board");

        private final String name;

        CanvasType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
