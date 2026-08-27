/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.input;

import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.event.events.EventMouseClick;
import me.deftware.client.framework.input.Mouse;
import net.minecraft.class_310;
import net.minecraft.class_312;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_312.class})
public class MixinMouseListener {
    @Shadow
    private boolean field_1783;

    @Inject(at={@At(value="FIELD", target="Lnet/minecraft/client/Mouse;cursorLocked:Z")}, method={"onMouseButton"})
    public void onMouseButton(long window, int button, int action, int mods, CallbackInfo ci) {
        if (this.field_1783 && button >= 0 && button <= 7 && action == 1) {
            new EventKeyAction(button, action, mods).broadcast();
        }
    }

    @Inject(method={"onMouseButton"}, at={@At(value="HEAD")}, cancellable=true)
    private void mouseButtonCallback(long windowPointer, int button, int action, int modifiers, CallbackInfo ci) {
        EventMouseClick event;
        if ((windowPointer == class_310.method_1551().method_22683().method_4490() || class_310.method_1551().field_1755 != null) && (event = (EventMouseClick)new EventMouseClick(button, action, modifiers).broadcast()).isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"onMouseScroll"}, at={@At(value="HEAD")})
    private void scrollCallback(long windowPointer, double horizontal, double vertical, CallbackInfo ci) {
        if (windowPointer == class_310.method_1551().method_22683().method_4490()) {
            Mouse.onScroll(horizontal, vertical);
        }
    }
}

