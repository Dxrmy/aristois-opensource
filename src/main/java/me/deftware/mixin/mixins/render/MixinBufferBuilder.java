/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_287
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package me.deftware.mixin.mixins.render;

import me.deftware.client.framework.global.types.BlockPropertyManager;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import net.minecraft.class_287;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value={class_287.class})
public class MixinBufferBuilder {
    @ModifyVariable(method={"vertex(FFFIFFIIFFF)V"}, at=@At(value="HEAD"), index=4, argsOnly=true)
    private int alphaModifier(int color) {
        BlockPropertyManager props = Bootstrap.blockProperties;
        if (props.isActive() && props.isOpacityMode()) {
            int alpha = (int)props.getOpacity();
            return color & 0xFFFFFF | alpha << 24;
        }
        return color;
    }
}

