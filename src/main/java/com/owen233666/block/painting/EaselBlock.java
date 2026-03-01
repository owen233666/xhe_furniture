package com.owen233666.block.painting;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.EaselBlockEntity;
import com.owen233666.block.entity.StorageBlockEntity;
import com.owen233666.item.ModItemTags;
import com.owen233666.item.ModItems;
import com.owen233666.item.PaintBrushItem;
import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
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

import java.rmi.registry.Registry;

public class EaselBlock extends AbstractPaintingBlock implements EntityBlock {
    public static final BooleanProperty DIRTY = BooleanProperty.create("dirty");
    public static final BooleanProperty WIP = BooleanProperty.create("wip");
    public static final EnumProperty<CanvasType> CANVAS_TYPE = EnumProperty.create("canvas_type", CanvasType.class);
    public static final VoxelShape SHAPE = Block.box(2, 0, 2 ,14, 32, 14);

    public EaselBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(defaultBlockState()
//                .with(PAINTINGS, Paintings.NONE)
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
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        Item heldItem = heldStack.getItem();
        boolean hasCanvas = hasCanvas(state.getValue(CANVAS_TYPE));
        BlockEntity be = world.getBlockEntity(pos);
        NonNullList<ItemStack> inventory;

        //初始化inventory
        if (be instanceof EaselBlockEntity){
            inventory = ((EaselBlockEntity) be).getInv();
        }else {
            inventory = NonNullList.withSize(1, ItemStack.EMPTY);
        }
        //判断是否有画（获取be的inventory）
        boolean hasPainting =!(inventory.getFirst() == ItemStack.EMPTY);

        //染色逻辑，与be无关
        if (heldItem instanceof PaintBrushItem) {

            XheFurniture.LOGGER.info("1");

            if (state.getValue(DIRTY)) return InteractionResult.PASS;
            if (heldStack.getDamageValue() == heldItem.getMaxDamage()) return InteractionResult.PASS;
            world.setBlockAndUpdate(pos, state.setValue(DIRTY, true));
            if (!player.isCreative()) heldStack.hurtAndBreak(1, player, (entity) -> {});
            return InteractionResult.SUCCESS;
        }

        //洗色逻辑，与be无关
        if (byItem(heldItem) instanceof WetSpongeBlock){

            XheFurniture.LOGGER.info("2");

            if (state.getValue(DIRTY)) {
                world.setBlockAndUpdate(pos, state.setValue(DIRTY, false));
                return InteractionResult.SUCCESS;
            }else {
                return InteractionResult.PASS;
            }
        }

        //放画布逻辑
        if (byItem(heldItem) instanceof CanvasBlock){

            XheFurniture.LOGGER.info("3");

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

        //取画布逻辑，仅hasPainting与be无关，大部分与be无关
        if (player.getItemInHand(hand).isEmpty() && player.isShiftKeyDown()) {
            XheFurniture.LOGGER.info("4");
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

        //放画逻辑
        //判断获取到的方块实体是EaselBlockEntity
        if (be instanceof EaselBlockEntity easelBlockEntity){
            XheFurniture.LOGGER.info("5");
            boolean heldIsPainting = BuiltInRegistries.ITEM.wrapAsHolder(heldItem).is(ModItemTags.PAINTINGS);
            //方块实体inv为空
            if (!(inventory.isEmpty() || inventory.getFirst() == ItemStack.EMPTY)) {
                //手上拿的东西是画
                if (heldIsPainting){
                    addItem(world, pos, player, easelBlockEntity, heldStack);
                    return InteractionResult.CONSUME;
                }else {
                    return InteractionResult.PASS;
                }
            //方块实体inv不为空
            }else {
                //手上拿的东西是画
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

    {    //没用了，有大括号是为了能收起来
//    @Override
//    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
//        super.afterBreak(world, player, pos, state, blockEntity, tool);
//        if (player.isCreative()) return;
//        if (hasCanvas(state.get(CANVAS_TYPE))) {
//            ItemStack toDrop = state.get(CANVAS_TYPE) == CanvasType.CANVAS ? new ItemStack(ModBlocks.CANVAS, 1) : new ItemStack(ModBlocks.DRAWING_BOARD, 1);
//            dropStack(world, pos, toDrop);
//        }
//        ItemStack paintings = getItemFromPaintings(state.get(PAINTINGS));
//        dropStack(world, pos, paintings);
//    }
    }

    private boolean hasCanvas(CanvasType canvasType) {
        if (canvasType == CanvasType.NONE) {
            return false;
        }else {
            return true;
        }
    }

    //没用了
    @Deprecated
    private boolean hasPainting(Paintings paintings) {
        return paintings != Paintings.NONE;
    }

    //构造be的方法
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
