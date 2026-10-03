/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.session.telemetry.TelemetryManager
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.network;

import net.minecraft.client.session.telemetry.TelemetryManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_6628.class})
public class MixinTelemetry {
    @Redirect(method={"computeSender"}, at=@At(value="FIELD", target="Lnet/minecraft/SharedConstants;isDevelopment:Z", opcode=178))
    private boolean onIsDevelopment() {
        return true;
    }
}

