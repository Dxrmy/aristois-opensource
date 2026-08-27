/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_6880
 *  net.minecraft.class_702
 *  net.minecraft.class_703
 *  net.minecraft.class_7923
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.render;

import java.util.List;
import me.deftware.client.framework.event.events.EventParticle;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_6880;
import net.minecraft.class_702;
import net.minecraft.class_703;
import net.minecraft.class_7923;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_702.class})
public class MixinParticleManager {
    @Unique
    private final List<class_2394> IGNORED_PARTICLES = List.of(class_2398.field_11248, class_2398.field_17909);

    @Inject(method={"addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)Lnet/minecraft/client/particle/Particle;"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAddParticle(class_2394 parameters, double x, double y, double z, double velocityX, double velocityY, double velocityZ, CallbackInfoReturnable<class_703> ci) {
        class_6880 entry;
        String id;
        EventParticle event;
        if (!this.IGNORED_PARTICLES.contains(parameters) && (event = (EventParticle)new EventParticle(id = (entry = class_7923.field_41180.method_47983((Object)parameters.method_10295())).method_55840(), x, y, z, velocityX, velocityY, velocityZ).broadcast()).isCanceled()) {
            ci.cancel();
        }
    }
}

