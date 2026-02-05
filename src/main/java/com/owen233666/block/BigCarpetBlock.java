package com.owen233666.block;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class BigCarpetBlock extends StorageBlock{
    protected BigCarpetBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Identifier type() {
        return null;
    }

    @Override
    public Boolean canInsertStack(ItemStack stack) {
        return null;
    }
}
