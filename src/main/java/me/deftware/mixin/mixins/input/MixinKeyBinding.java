/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil$Key
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package me.deftware.mixin.mixins.input;

import me.deftware.mixin.imp.IMixinKeyBinding;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={class_304.class})
public class MixinKeyBinding
implements IMixinKeyBinding {
    @Shadow
    private boolean field_1653;
    @Shadow
    private class_3675.class_306 field_1655;

    @Override
    public void emcSetPressed(boolean state) {
        this.field_1653 = state;
    }

    @Override
    public class_3675.class_306 getInput() {
        return this.field_1655;
    }
}

