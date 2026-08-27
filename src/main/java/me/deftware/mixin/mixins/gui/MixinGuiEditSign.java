/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_2625
 *  net.minecraft.class_7743
 *  net.minecraft.class_8242
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package me.deftware.mixin.mixins.gui;

import me.deftware.client.framework.gui.screens.SignEditScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.mixin.mixins.gui.MixinGuiScreen;
import net.minecraft.class_2561;
import net.minecraft.class_2625;
import net.minecraft.class_7743;
import net.minecraft.class_8242;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={class_7743.class})
public abstract class MixinGuiEditSign
extends MixinGuiScreen
implements SignEditScreen {
    @Final
    @Shadow
    private class_2625 field_40424;
    @Shadow
    private int field_40428;
    @Shadow
    private class_8242 field_43362;
    @Shadow
    @Final
    private boolean field_43363;
    @Shadow
    @Final
    private String[] field_40425;

    @Override
    public int _getCurrentLine() {
        return this.field_40428;
    }

    @Override
    public String _getLine(int line) {
        return this.field_43362.method_49859(line, false).getString();
    }

    @Override
    public void _setLine(int line, String text) {
        Message message = Message.of(text);
        this.field_40425[line] = text;
        this.field_43362 = this.field_43362.method_49857(line, (class_2561)message);
        this.field_40424.method_49840(this.field_43362, this.field_43363);
    }

    @Override
    public void _save() {
        this.field_40424.method_5431();
    }
}

