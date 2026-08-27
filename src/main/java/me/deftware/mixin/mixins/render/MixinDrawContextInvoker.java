/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597$class_4598
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package me.deftware.mixin.mixins.render;

import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_332.class})
public interface MixinDrawContextInvoker {
    @Invoker(value="<init>")
    public static class_332 create(class_310 client, class_4587 matrices, class_4597.class_4598 vertexConsumers) {
        throw new AssertionError();
    }
}

