package com.owen233666.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class SlippersBlock extends HorizontalDirectionalBlock {
    public static final EnumProperty<SlippersType> SLIPPERS_TYPE = EnumProperty.create("slippers_type", SlippersType.class);

    public SlippersBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SLIPPERS_TYPE, SlippersType.A));
    }


    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SLIPPERS_TYPE);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide) {
            SlippersType slippersType = state.getValue(SLIPPERS_TYPE).next();
            BlockState newState = state.setValue(SLIPPERS_TYPE, slippersType);
            world.setBlockAndUpdate(pos, newState);
        }
        return InteractionResult.SUCCESS;
    }

    public enum SlippersType implements StringRepresentable {
        A("a"),
        B("b"),
        C("c");

        public final String name;

        SlippersType(String name){
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public SlippersType next() {
            SlippersType[] values = values();
            int nextOrdinal = (this.ordinal() + 1) % values.length;
            return values[nextOrdinal];
        }
    }
}
