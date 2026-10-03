/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Style
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.chat;

import me.deftware.client.framework.message.Appearance;
import net.minecraft.text.Style;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_2583.class})
public class MixinStyle
implements Appearance {
    @Shadow
    @Final
    Boolean field_11852;
    @Shadow
    @Final
    Boolean field_11856;
    @Shadow
    @Final
    Boolean field_11851;
    @Shadow
    @Final
    Boolean field_11857;
    @Shadow
    @Final
    Boolean field_11861;

    @Override
    @Unique
    public boolean isItalic() {
        return this.field_11852;
    }

    @Override
    @Unique
    public boolean isBold() {
        return this.field_11856;
    }

    @Override
    @Unique
    public boolean isUnderlined() {
        return this.field_11851;
    }

    @Override
    @Unique
    public boolean isStrikethrough() {
        return this.field_11857;
    }

    @Override
    @Unique
    public boolean isObfuscated() {
        return this.field_11861;
    }
}

