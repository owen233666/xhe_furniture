package com.owen233666.mixin;

import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class ServerPlayNetworkHandlerMixin {
    @ModifyConstant(
            method = "handleUseItemOn",
            constant = @Constant(doubleValue = 1.0000001)
    )
    private double modifyOffsetConstant(double originalValue) {
        return 2.0000001;
    }
}

