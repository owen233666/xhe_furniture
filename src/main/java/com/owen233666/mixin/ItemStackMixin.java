package com.owen233666.mixin;

import com.owen233666.XheFurniture;
import com.owen233666.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Inject(method = "hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V",
            at = @At("HEAD"),
            cancellable = true)
    private void onDamage(int amount, LivingEntity entity, Consumer<LivingEntity> breakCallback, CallbackInfo ci) {
        ItemStack itemStack = (ItemStack) (Object) this;
        if (itemStack.is(ModItems.PAINT_BRUSH)){
            int currentDamage = itemStack.getDamageValue();
            int maxDamage = itemStack.getMaxDamage();

            if (currentDamage <= maxDamage - 2) {
//                XheFurniture.LOGGER.info("damage 2 耐久正常-1");
                return;
            }

            if (currentDamage == 63){
//                XheFurniture.LOGGER.info("damage 2 耐久剩余1，减到0");
                itemStack.setDamageValue(maxDamage);
                ci.cancel();
            }

            if (currentDamage == 64){
//                XheFurniture.LOGGER.info("damage 2 耐久为0，不减耐久");
                ci.cancel();
            }
        }
    }

}
