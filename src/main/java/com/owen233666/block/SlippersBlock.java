package com.owen233666.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SlippersBlock extends HorizontalFacingBlock {
    public static final EnumProperty<SlippersType> SLIPPERS_TYPE = EnumProperty.of("slippers_type", SlippersType.class);

    public SlippersBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(SLIPPERS_TYPE, SlippersType.A));
    }


    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SLIPPERS_TYPE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            SlippersType slippersType = state.get(SLIPPERS_TYPE).next();
            BlockState newState = state.with(SLIPPERS_TYPE, slippersType);
            world.setBlockState(pos, newState);
        }
        return ActionResult.SUCCESS;
    }

    public enum SlippersType implements StringIdentifiable {
        A("a"),
        B("b"),
        C("c");

        public final String name;

        SlippersType(String name){
            this.name = name;
        }

        @Override
        public String asString() {
            return this.name;
        }

        public SlippersType next() {
            SlippersType[] values = values();
            int nextOrdinal = (this.ordinal() + 1) % values.length;
            return values[nextOrdinal];
        }
    }
}
