package com.owen233666;

import com.owen233666.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModItemProperties {

    public static void registerModItemProperties(){
        ModelPredicateProviderRegistry.register(
                ModItems.PAINT_BRUSH,
                new Identifier(XheFurniture.MOD_ID, "has_paint"),
                ((stack, world, entity, seed) -> {
                    if (stack == null || !stack.isDamageable()) {
                        return 0.0F;
                    }
                    if (stack.getDamage() < stack.getMaxDamage()) {
                        return 1.0F;
                    } else {
                        return 0.0F;
                    }
                })
        );
    }
}
