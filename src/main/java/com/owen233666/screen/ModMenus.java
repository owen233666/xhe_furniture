package com.owen233666.screen;

import com.owen233666.XheFurniture;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;

public class ModMenus {

    public static final MenuType<KitMenu> KIT_MENU = ScreenHandlerRegistry.registerSimple(
            new ResourceLocation(XheFurniture.MOD_ID, "kit"),
            (syncId, inventory) -> new KitMenu(syncId, inventory, ContainerLevelAccess.NULL)
    );

    public static void registerModMenus() {
    }
}
