/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_922
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.render;

import me.deftware.client.framework.event.events.EventRenderPlayerModel;
import net.minecraft.class_1309;
import net.minecraft.class_922;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_922.class})
public abstract class MixinRenderLivingBase<T extends class_1309> {
    @Unique
    private final EventRenderPlayerModel eventRenderPlayerModel = new EventRenderPlayerModel();
}

