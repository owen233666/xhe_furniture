package com.owen233666.block.painting;

import net.minecraft.util.StringIdentifiable;

public enum PlacementState implements StringIdentifiable {
    CORNER("corner"),
    WALL("wall");

    public final String name;

    PlacementState(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return name;
    }
}
