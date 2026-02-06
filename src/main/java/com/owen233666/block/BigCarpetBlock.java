package com.owen233666.block;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class BigCarpetBlock extends StorageBlock{
    protected BigCarpetBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public Identifier type() {
        return null;
    }

    @Override
    public Boolean canInsertStack(ItemStack stack) {
        return null;
    }

    @Override
    public Direction[] unAllowedDirections() {
        return new Direction[]{Direction.DOWN};
    }

    @Override
    public int getSection(float x, float y) {
        return 0;
    }
}
