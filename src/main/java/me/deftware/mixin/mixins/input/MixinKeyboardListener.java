/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Keyboard
 *  net.minecraft.client.MinecraftClient
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.input;

import me.deftware.client.framework.event.events.EventCharacter;
import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.event.events.EventKeyActionRaw;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_309.class})
public class MixinKeyboardListener {
    @Inject(method={"onKey"}, at={@At(value="HEAD")})
    private void onKeyEventRaw(long windowPointer, int keyCode, int scanCode, int action, int modifiers, CallbackInfo ci) {
        class_310 minecraft = class_310.method_1551();
        if (windowPointer == minecraft.method_22683().method_4490()) {
            new EventKeyActionRaw(keyCode, action, modifiers).broadcast();
            if (minecraft.field_1755 == null && keyCode >= 32 && keyCode <= 348 && action != 0) {
                new EventKeyAction(keyCode, action, modifiers).broadcast();
            }
        }
    }

    @Inject(method={"onChar"}, at={@At(value="HEAD")})
    private void onCharEvent(long windowPointer, int codePoint, int modifiers, CallbackInfo ci) {
        if (windowPointer == class_310.method_1551().method_22683().method_4490() && class_310.method_1551().field_1755 == null && codePoint >= 32 && codePoint <= 348) {
            if (Character.charCount(codePoint) == 1) {
                new EventCharacter((char)codePoint, modifiers).broadcast();
            } else {
                for (char character : Character.toChars(codePoint)) {
                    new EventCharacter(character, modifiers).broadcast();
                }
            }
        }
    }
}

