package com.owen233666.block.painting;

import net.minecraft.util.StringRepresentable;

public enum PhotoType implements StringRepresentable {
    A("a"),
    B("b"),
    C("c");

    private final String name;

    PhotoType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }

}
