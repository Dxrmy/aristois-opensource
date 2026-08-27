/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1452
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.entity;

import me.deftware.client.framework.event.events.EventSaddleCheck;
import net.minecraft.class_1452;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1452.class})
public abstract class MixinAbstractPig {
    @Inject(method={"isSaddled"}, at={@At(value="TAIL")}, cancellable=true)
    private void onIsSaddled(CallbackInfoReturnable<Boolean> cir) {
        EventSaddleCheck event = new EventSaddleCheck((Boolean)cir.getReturnValue());
        event.broadcast();
        cir.setReturnValue((Object)event.isState());
    }

    @Inject(method={"canBeSaddled"}, at={@At(value="TAIL")}, cancellable=true)
    public void canBeControlled(CallbackInfoReturnable<Boolean> cir) {
        EventSaddleCheck event = new EventSaddleCheck((Boolean)cir.getReturnValue());
        event.broadcast();
        cir.setReturnValue((Object)event.isState());
    }
}

