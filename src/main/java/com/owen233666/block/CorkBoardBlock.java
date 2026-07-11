package com.owen233666.block;

import com.owen233666.XheFurniture;
import com.owen233666.block.entity.CorkBoardBlockEntity;
import com.owen233666.block.entity.PaintFrameBlockEntity;
import com.owen233666.item.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CorkBoardBlock extends HorizontalDirectionalBlock implements EntityBlock {
    public static final BooleanProperty ABOVE = BooleanProperty.create("above");
    public static final BooleanProperty BELOW = BooleanProperty.create("below");
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
//    public static final BooleanProperty WHITE = BooleanProperty.create("white");
//    public static final BooleanProperty HAS_PHOTO  = BooleanProperty.create("has_photo");
//    public static final EnumProperty<PhotoType> PHOTO_TYPE = EnumProperty.create("photo_type", PhotoType.class);

    public static final VoxelShape FACING_N = box(0,  0, 15, 16, 16, 16);
    public static final VoxelShape FACING_S = box(0,  0, 0,  16, 16, 1);
    public static final VoxelShape FACING_E = box(0,  0, 0,  1,  16, 16);
    public static final VoxelShape FACING_W = box(15, 0, 0,  16, 16, 16);

    public CorkBoardBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, ABOVE, BELOW, LEFT, RIGHT);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return switch (blockState.getValue(FACING)) {
            case NORTH -> FACING_N;
            case SOUTH -> FACING_S;
            case WEST -> FACING_W;
            case EAST -> FACING_E;
            default -> FACING_N;
        };
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState2.is(blockState.getBlock())) {
            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = blockPos.relative(direction);
                BlockState neighborState = level.getBlockState(neighborPos);
                if (neighborState.getBlock() instanceof CorkBoardBlock) {
                    level.setBlock(neighborPos, boardState(neighborState, level, neighborPos), 2);
                }
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        return boardState(blockState, levelAccessor, blockPos);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Direction facingDirectionOpposite = blockPlaceContext.getHorizontalDirection().getOpposite();
        LevelAccessor levelAccessor = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();

        BlockState baseState = super.getStateForPlacement(blockPlaceContext);
        if (baseState == null) {
            baseState = defaultBlockState();
        }

        BlockState stateWithFacing = baseState.setValue(FACING, facingDirectionOpposite);

        return boardState(stateWithFacing, levelAccessor, blockPos);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        BlockEntity be = level.getBlockEntity(pos);

        if (!(be instanceof CorkBoardBlockEntity corkBoardBlockEntity)) {
            return InteractionResult.PASS;
        }

        // 服务端处理所有业务
        if (!level.isClientSide()) {
            NonNullList<ItemStack> inventory = corkBoardBlockEntity.getInv();
            boolean hasPainting = !inventory.get(1).isEmpty();
            boolean hasPhoto    = !inventory.get(0).isEmpty();
            boolean isPhoto     = BuiltInRegistries.ITEM.wrapAsHolder(heldStack.getItem()).is(ModItemTags.PHOTO_PAPERS);
            boolean isPainting  = BuiltInRegistries.ITEM.wrapAsHolder(heldStack.getItem()).is(ModItemTags.PAINTINGS);

            if (hasPhoto) {
                if (isPhoto) {
                    setPhoto(level, pos, corkBoardBlockEntity, player, heldStack, hasPainting);
                } else if (isPainting) {
                    setPainting(level, pos, corkBoardBlockEntity, player, heldStack);
                } else if (hasPainting) {
                    removePainting(level, pos, corkBoardBlockEntity, player);
                } else {
                    removePhoto(level, pos, corkBoardBlockEntity, player, heldStack, hasPainting);
                }
            } else if (isPhoto) {
                setPhoto(level, pos, corkBoardBlockEntity, player, heldStack, hasPhoto);
            }
        }

        // 返回 SUCCESS 表示交互已处理（客户端和服务端都需要返回这个结果）
        return InteractionResult.SUCCESS;
    }

    private void setPhoto(Level level, BlockPos pos, CorkBoardBlockEntity corkBoardBlockEntity, Player player, ItemStack itemStack, boolean hasPainting) {
        XheFurniture.LOGGER.info("setPhoto");
//        if (!hasPainting) return;
        removeItem(level, pos, player, corkBoardBlockEntity,0);
        addItem(level, pos, player, corkBoardBlockEntity, itemStack, 0);
    }

    private void setPainting(Level level, BlockPos pos, CorkBoardBlockEntity corkBoardBlockEntity, Player player, ItemStack itemStack) {
        XheFurniture.LOGGER.info("setPainting");
        removeItem(level, pos, player, corkBoardBlockEntity,1);
        addItem(level, pos, player, corkBoardBlockEntity, itemStack, 1);
    }

    private void removePhoto(Level level, BlockPos pos, CorkBoardBlockEntity corkBoardBlockEntity, Player player, ItemStack heldStack, boolean hasPainting){
        XheFurniture.LOGGER.info("removePhoto");
        removeItem(level, pos, player, corkBoardBlockEntity,1);
    }

    private void removePainting(Level level, BlockPos pos, CorkBoardBlockEntity corkBoardBlockEntity, Player player) {
        XheFurniture.LOGGER.info("removePainting");
        removeItem(level, pos, player, corkBoardBlockEntity,0);
    }

    private BlockState boardState(BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos) {
        boolean above = isValidBoard(blockState, levelAccessor.getBlockState(blockPos.above()));
        boolean below = isValidBoard(blockState, levelAccessor.getBlockState(blockPos.below()));
        boolean left = isValidBoard(blockState, levelAccessor, blockPos, true);
        boolean right = isValidBoard(blockState, levelAccessor, blockPos, false);
        blockState = blockState
                .setValue(ABOVE, above)
                .setValue(BELOW, below)
                .setValue(LEFT, left)
                .setValue(RIGHT, right);
        return blockState;
    }

    //垂直方向可直接用这个方法
    private boolean isValidBoard(BlockState blockState1, BlockState blockState2) {
        Block block = blockState2.getBlock();
        if (block instanceof CorkBoardBlock) {
            Direction direction1 = blockState1.getValue(FACING);
            Direction direction2 = blockState2.getValue(FACING);
            return direction1 == direction2;
        }
        return false;
    }

    //水平方向用这个方法
    private boolean isValidBoard(BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos, boolean left) {
        Direction direction = blockState.getValue(FACING);
        BlockState blockState1 = levelAccessor.getBlockState(blockPos.above());
        switch (direction) {
            case NORTH -> blockState1 = left ? levelAccessor.getBlockState(blockPos.west() ) : levelAccessor.getBlockState(blockPos.east() );//left -> west;  right -> east
            case SOUTH -> blockState1 = left ? levelAccessor.getBlockState(blockPos.east() ) : levelAccessor.getBlockState(blockPos.west() );//left -> east;  right -> west
            case WEST  -> blockState1 = left ? levelAccessor.getBlockState(blockPos.south()) : levelAccessor.getBlockState(blockPos.north());//left -> south; right -> north
            case EAST  -> blockState1 = left ? levelAccessor.getBlockState(blockPos.north()) : levelAccessor.getBlockState(blockPos.south());//left -> north; right -> south
        }
        return isValidBoard(blockState, blockState1);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CorkBoardBlockEntity(blockPos, blockState);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if(!state.equals(newState)) {
            BlockEntity be  =  world.getBlockEntity(pos);
            if(be instanceof CorkBoardBlockEntity corkBoardBlockEntity){
                if(world instanceof ServerLevel serverWorld){
                    Containers.dropContents(serverWorld, pos, corkBoardBlockEntity.getInv());
                }
            }
        }
        super.onRemove(state, world, pos, newState, moved);
    }

    public void addItem(Level world, BlockPos pos, Player player, CorkBoardBlockEntity corkBoardBlockEntity, ItemStack stack, int index){
        if(!world.isClientSide()) {
            corkBoardBlockEntity.setStack(stack.split(1), index);
            world.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(player.isCreative()) {
                stack.grow(1);
            }
        }
    }

    public void removeItem(Level world, BlockPos pos, Player player, CorkBoardBlockEntity corkBoardBlockEntity, int index){
        if(!world.isClientSide()) {
            ItemStack toRemoveStack =corkBoardBlockEntity.removeStack(index);
            world.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(!player.getInventory().add(toRemoveStack)){
                player.spawnAtLocation(toRemoveStack);
            }
        }
    }
}
