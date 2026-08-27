/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_339
 *  net.minecraft.class_4185
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.gui;

import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.Message;
import me.deftware.mixin.mixins.gui.MixinClickableWidget;
import net.minecraft.class_2561;
import net.minecraft.class_339;
import net.minecraft.class_4185;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_4185.class})
public class MixinGuiButton
extends MixinClickableWidget
implements Button {
    @Override
    public Message getComponentLabel() {
        return (Message)((class_339)this).method_25369();
    }

    @Override
    public Button setComponentLabel(Message text) {
        ((class_339)this).method_25355((class_2561)text);
        return this;
    }

    @Override
    @Unique
    public void click() {
        ((class_4185)this).method_25306();
    }
}

