package com.owen233666.block.painting;

import com.owen233666.XheFurniture;
import com.owen233666.block.ModBlocks;
import com.owen233666.block.entity.EaselBlockEntity;
import com.owen233666.block.entity.StorageBlockEntity;
import com.owen233666.item.ModItemTags;
import com.owen233666.item.ModItems;
import com.owen233666.item.PaintBrushItem;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.rmi.registry.Registry;

public class EaselBlock extends AbstractPaintingBlock implements BlockEntityProvider {
    public static final BooleanProperty DIRTY = BooleanProperty.of("dirty");
    public static final BooleanProperty WIP = BooleanProperty.of("wip");
    public static final EnumProperty<CanvasType> CANVAS_TYPE = EnumProperty.of("canvas_type", CanvasType.class);
    public static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2 ,14, 32, 14);

    public EaselBlock(Settings settings) {
        super(settings);
        this.setDefaultState(getDefaultState()
//                .with(PAINTINGS, Paintings.NONE)
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
        builder.add(FACING, DIRTY,CANVAS_TYPE, WIP);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getStackInHand(hand);
        Item heldItem = heldStack.getItem();
        boolean hasCanvas = hasCanvas(state.get(CANVAS_TYPE));
        BlockEntity be = world.getBlockEntity(pos);
        DefaultedList<ItemStack> inventory;

        //初始化inventory
        if (be instanceof EaselBlockEntity){
            inventory = ((EaselBlockEntity) be).getInv();
        }else {
            inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
        }
        //判断是否有画（获取be的inventory）
        boolean hasPainting =!(inventory.getFirst() == ItemStack.EMPTY);

        //染色逻辑，与be无关
        if (heldItem instanceof PaintBrushItem) {

            XheFurniture.LOGGER.info("1");

            if (state.get(DIRTY)) return ActionResult.PASS;
            if (heldStack.getDamage() == heldItem.getMaxDamage()) return ActionResult.PASS;
            world.setBlockState(pos, state.with(DIRTY, true));
            if (!player.isCreative()) heldStack.damage(1, player, (entity) -> {});
            return ActionResult.SUCCESS;
        }

        //洗色逻辑，与be无关
        if (getBlockFromItem(heldItem) instanceof WetSpongeBlock){

            XheFurniture.LOGGER.info("2");

            if (state.get(DIRTY)) {
                world.setBlockState(pos, state.with(DIRTY, false));
                return ActionResult.SUCCESS;
            }else {
                return ActionResult.PASS;
            }
        }

        //放画布逻辑
        if (getBlockFromItem(heldItem) instanceof CanvasBlock){

            XheFurniture.LOGGER.info("3");

            if (!hasCanvas){
                if (getBlockFromItem(heldItem) == ModBlocks.CANVAS){
                    world.setBlockState(pos, state.with(CANVAS_TYPE, CanvasType.CANVAS));
                }else {
                    world.setBlockState(pos, state.with(CANVAS_TYPE, CanvasType.DRAWING_BOARD));
                }
                if (!player.isCreative()) heldStack.decrement(1);
                return ActionResult.CONSUME;
            }else {
                if (state.get(CANVAS_TYPE) == CanvasType.CANVAS){
                    ItemStack stack = new ItemStack(ModBlocks.CANVAS, 1);
                    if (!player.getInventory().insertStack(stack)) player.dropStack(stack);
                }else{
                    ItemStack stack = new ItemStack(ModBlocks.DRAWING_BOARD, 1);
                    if (!player.getInventory().insertStack(stack)) player.dropStack(stack);
                }
                return ActionResult.SUCCESS;
            }
        }

        //取画布逻辑，仅hasPainting与be无关，大部分与be无关
        if (player.getStackInHand(hand).isEmpty() && player.isSneaking()) {
            XheFurniture.LOGGER.info("4");
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

        //放画逻辑
        //判断获取到的方块实体是EaselBlockEntity
        if (be instanceof EaselBlockEntity easelBlockEntity){
            XheFurniture.LOGGER.info("5");
            boolean heldIsPainting = Registries.ITEM.getEntry(heldItem).isIn(ModItemTags.PAINTINGS);
            //方块实体inv为空
            if (!(inventory.isEmpty() || inventory.getFirst() == ItemStack.EMPTY)) {
                //手上拿的东西是画
                if (heldIsPainting){
                    addItem(world, pos, player, easelBlockEntity, heldStack);
                    return ActionResult.CONSUME;
                }else {
                    return ActionResult.PASS;
                }
            //方块实体inv不为空
            }else {
                //手上拿的东西是画
                if (heldIsPainting){
                    remove(world, pos, player, easelBlockEntity);
                    addItem(world, pos, player, easelBlockEntity, heldStack);
                    return ActionResult.CONSUME;
                }else{
                    remove(world, pos, player, easelBlockEntity);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
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
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EaselBlockEntity(pos, state);
    }

    //向be的inv中添加物品的方法
    public void addItem(World world, BlockPos pos, PlayerEntity player, EaselBlockEntity easelBlockEntity, ItemStack stack){

        if(!world.isClient()) {
            easelBlockEntity.setStack(stack.split(1));
            world.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);

            if(player.isCreative()) {
                stack.increment(1);
            }
        }
    }

    public void remove(World world, BlockPos pos, PlayerEntity player, EaselBlockEntity easelBlockEntity){
        if(!world.isClient()) {
            ItemStack toRemoveStack =easelBlockEntity.removeStack();
            world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().insertStack(toRemoveStack)){
                player.dropStack(toRemoveStack);
            }
        }
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
