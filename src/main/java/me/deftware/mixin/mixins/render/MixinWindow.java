/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.util.Window
 *  org.lwjgl.glfw.GLFW
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.render;

import me.deftware.client.framework.util.path.OSUtils;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_1041.class})
public abstract class MixinWindow {
    @Redirect(at=@At(value="INVOKE", target="Lorg/lwjgl/glfw/GLFW;glfwDefaultWindowHints()V"), method={"<init>"}, remap=false)
    private void redirectDefaultWindowHints() {
        GLFW.glfwDefaultWindowHints();
        if (OSUtils.isMac()) {
            GLFW.glfwWindowHint((int)143361, (int)0);
        }
    }
}

