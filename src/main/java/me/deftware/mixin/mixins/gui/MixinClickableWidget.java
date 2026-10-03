/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.widget.ClickableWidget
 *  net.minecraft.text.OrderedText
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.gui;

import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.gui.widgets.Component;
import me.deftware.client.framework.gui.widgets.properties.Tooltipable;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.OrderedText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_339.class})
public class MixinClickableWidget
implements Component,
Tooltipable {
    @Shadow
    protected int field_22759;
    @Shadow
    private int field_22760;
    @Shadow
    private int field_22761;
    @Unique
    private final List<class_5481> tooltipComponents = new ArrayList<class_5481>();

    @Override
    public int getPositionX() {
        return this.field_22760;
    }

    @Override
    public int getPositionY() {
        return this.field_22761;
    }

    @Override
    public int getComponentWidth() {
        return ((class_339)this).method_25368();
    }

    @Override
    public int getComponentHeight() {
        return ((class_339)this).method_25364();
    }

    @Override
    public boolean isActive() {
        return ((class_339)this).field_22763;
    }

    @Override
    public void setPositionX(int x) {
        this.field_22760 = x;
    }

    @Override
    public void setPositionY(int y) {
        this.field_22761 = y;
    }

    @Override
    public void setComponentWidth(int width) {
        ((class_339)this).method_25358(width);
    }

    @Override
    public void setComponentHeight(int height) {
        this.field_22759 = height;
    }

    @Override
    public void setActive(boolean state) {
        ((class_339)this).field_22763 = state;
    }

    @Override
    public List<class_5481> getTooltipComponents(int mouseX, int mouseY) {
        return this.tooltipComponents;
    }

    @Override
    public boolean isMouseOverComponent(int mouseX, int mouseY) {
        return ((class_339)this).method_49606();
    }

    @Override
    public void setPosition(int x, int y) {
        this.setPositionX(x);
        this.setPositionY(y);
    }
}

