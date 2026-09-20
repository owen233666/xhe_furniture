/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.mixin;

import com.owen233666.item.ModItems;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

//#if MC >= 12100
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
//#else
//$$ import net.minecraft.world.entity.LivingEntity;
//#endif

@Mixin(ItemStack.class)
public class ItemStackMixin {
    /*
     * The damage entry point this hook injects into changed shape:
     *
     *   1.20.1:  hurtAndBreak(int, LivingEntity, Consumer)
     *   1.21.1:  hurtAndBreak(int, ServerLevel, ServerPlayer, Consumer)
     *
     * Mixin matches the target descriptor literally, and a handler's own parameter list is
     * never checked against the target at compile time -- so an unadapted @Inject target
     * compiles cleanly and only blows up when the target class is first loaded, taking the
     * game down during Bootstrap with InvalidInjectionException. That is exactly what
     * happened on 1.21.1-fabric, so both branches have to exist here.
     *
     * The threshold below is 1.21.0 because that is the only interval our targets require:
     * 1.20.1 is below it, 1.21.1 and 26.1.2 are above it.
     */
    //#if MC >= 12100
    @Inject(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V",
            at = @At("HEAD"),
            cancellable = true)
    private void onDamage(int amount, ServerLevel level, ServerPlayer player, Consumer<Item> breakCallback, CallbackInfo ci) {
        applyPaintBrushDamage((ItemStack) (Object) this, ci);
    }
    //#else
    //$$ @Inject(method = "hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V",
    //$$         at = @At("HEAD"),
    //$$         cancellable = true)
    //$$ private void onDamage(int amount, LivingEntity entity, Consumer<LivingEntity> breakCallback, CallbackInfo ci) {
    //$$     applyPaintBrushDamage((ItemStack) (Object) this, ci);
    //$$ }
    //#endif

    /**
     * Shared by both @Inject branches so the two cannot drift apart. Mixin merges this
     * private helper into the target class alongside the handler.
     */
    private void applyPaintBrushDamage(ItemStack itemStack, CallbackInfo ci) {
        if (itemStack.is(ModItems.PAINT_BRUSH.get())) {
            int currentDamage = itemStack.getDamageValue();
            int maxDamage = itemStack.getMaxDamage();

            if (currentDamage <= maxDamage - 2) {
                return;
            }

            if (currentDamage == 63) {
                itemStack.setDamageValue(maxDamage);
                ci.cancel();
            }

            if (currentDamage == 64) {
                ci.cancel();
            }
        }
    }
}
