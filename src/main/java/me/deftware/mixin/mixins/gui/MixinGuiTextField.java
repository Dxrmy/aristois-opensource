/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_342
 *  net.minecraft.class_5481
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.gui;

import java.awt.Color;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import me.deftware.client.framework.gui.widgets.TextField;
import me.deftware.mixin.mixins.gui.MixinClickableWidget;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_342;
import net.minecraft.class_5481;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_342.class})
public class MixinGuiTextField
extends MixinClickableWidget
implements TextField {
    @Unique
    private String overlay = "";
    @Unique
    private boolean passwordField = false;
    @Shadow
    private BiFunction<String, Integer, class_5481> field_2099;
    @Shadow
    @Final
    private class_327 field_2105;

    @Inject(method={"renderWidget"}, at={@At(value="RETURN")})
    public void drawTextFieldReturn(class_332 matrixStack, int mouseX, int mouseY, float tickDelta, CallbackInfo ci) {
        class_342 self = (class_342)this;
        if (!this.overlay.isEmpty()) {
            int currentWidth = this.field_2105.method_1727(self.method_1882());
            int x = this.getPositionX();
            int y = this.getPositionY();
            if (self.method_25370()) {
                x += 4;
                y += (this.getComponentHeight() - 8) / 2;
            }
            matrixStack.method_25303(this.field_2105, this.overlay, x + currentWidth - 3, y - 2, Color.GRAY.getRGB());
        }
    }

    @Redirect(method={"renderWidget"}, at=@At(value="INVOKE", target="Ljava/util/function/BiFunction;apply(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"))
    public Object render(BiFunction<String, Integer, class_5481> biFunction, Object text, Object index) {
        String data = (String)text;
        if (this.passwordField) {
            data = "*".repeat(data.length());
        }
        return this.field_2099.apply(data, (int)((Integer)index));
    }

    @Override
    public void _setText(String text) {
        ((class_342)this).method_1852(text);
    }

    @Override
    public String _getText() {
        return ((class_342)this).method_1882();
    }

    @Override
    public void _setPasswordMode(boolean state) {
        this.passwordField = true;
    }

    @Override
    public void _setMaxLength(int length) {
        ((class_342)this).method_1880(length);
    }

    @Override
    public void _setOverlay(String text) {
        this.overlay = text;
    }

    @Override
    public void _setPredicate(Predicate<String> predicate) {
        ((class_342)this).method_1890(predicate);
    }
}

