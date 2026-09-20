/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.screen;

import com.owen233666.XheFurniture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import com.owen233666.platform.Ids;
import com.owen233666.platform.Registrar;

public class ModMenus {

    public static final MenuType<KitMenu> KIT_MENU = Registrar.legacySimpleMenu(
            Ids.of(XheFurniture.MOD_ID, "kit"),
            (syncId, inventory) -> new KitMenu(syncId, inventory, ContainerLevelAccess.NULL)
    );

    public static void registerModMenus() {
    }
}
