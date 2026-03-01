package com.owen233666.block.painting;

import net.minecraft.util.StringRepresentable;

public enum PlacementState implements StringRepresentable {
    CORNER("corner"),
    WALL("wall");

    public final String name;

    PlacementState(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
