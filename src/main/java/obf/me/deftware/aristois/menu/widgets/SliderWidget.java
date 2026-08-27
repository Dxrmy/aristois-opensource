/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 */
package me.deftware.aristois.menu.widgets;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.private.s.Dispatcher;
import \u0000nunyaboolean.catch.for.super.break.this;
import \u0000nunyaboolean.catch.for.super.enum.default;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import \u0000nunyaboolean.catch.for.super.enum.transient;
import java.awt.Color;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.aristois.menu.widgets.TextBoxWidget;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class SliderWidget
extends ButtonWidget
implements transient.catch,
default {
    protected boolean drag = false;
    protected double value = 0.5;
    protected double sliderHeight = 2.0;
    protected boolean manualInput = false;
    protected boolean percentageMode = false;
    protected TextBoxWidget textBoxWidget;
    final private String numberRegex = Dispatcher.bootstrap("get", 0x900000007L);

    public SliderWidget(interface interface_) {
        this(0.0, 0.0, 0.0, interface_);
    }

    public SliderWidget(double d, double d2, double d3, interface interface_) {
        super(d, d2, d3, (Message)Dispatcher\ufe0f.bootstrap("call", 0L, 1, Dispatcher.bootstrap("get", 0x900000006L)), interface_);
    }

    public void addTextBox() {
        this.textBoxWidget = new TextBoxWidget(0.0, 0.0, this.volatile\u00a0short.switch(), this.volatile\u00a0do){

            @Override
            protected void apply(String string) {
            }
        };
        this.textBoxWidget.setTextAlign(this.goto\u00a0goto);
        this.textBoxWidget.static().long(this.volatile\u00a0short);
    }

    @Override
    public void long(boolean bl) {
        super.long(bl);
        this.textBoxWidget.long(bl);
    }

    @Override
    public void implements() {
        this.manualInput = false;
    }

    @Override
    public void long(int n) {
        if (this.manualInput) {
            this.textBoxWidget.long(n);
        }
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        double d3;
        if (this.manualInput) {
            return this.textBoxWidget.implements(d, d2, f, bl);
        }
        bl = super.implements(d, d2, f, bl);
        double d4 = this.volatile\u00a0short.switch() - this.padding * 2.0;
        if (this.drag) {
            d3 = d - this.volatile\u00a0short.implements() - this.padding;
            this.value = (double)(Dispatcher\ufe0f.bootstrap("call", 0L, 1, 0.0, d4, d3) / d4);
            this.apply(this.value, false);
            this.updateLabel();
        }
        d3 = (this.volatile\u00a0short.switch() - this.padding * 2.0) * this.value;
        double d5 = this.volatile\u00a0short.long() + (this.volatile\u00a0short.static() / 2.0 + (double)this.volatile\u00a0package.getFontHeight() / 2.0);
        ((QuadRenderStack)this.quadRenderStack.begin().glColor(Color.white)).drawRect(this.volatile\u00a0short.implements() + this.padding, d5, this.volatile\u00a0short.implements() + this.padding + d3, d5 + this.sliderHeight).end();
        return bl || this.drag;
    }

    @Override
    public boolean isMouseOver(double d, double d2, boolean bl) {
        return super.isMouseOver(d, d2, bl) || this.drag;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean long(int n, int n2, int n3) {
        if (this.manualInput) {
            if (n != 257 && n != 335) return this.textBoxWidget.long(n, n2, n3);
            if (this.textBoxWidget.getText().isEmpty() || !this.textBoxWidget.getText().matches((String)((Object)Dispatcher.bootstrap("get", 0x900000007L)))) return false;
            this.value = !this.percentageMode ? this.normalize((double)Dispatcher\ufe0f.bootstrap("call", 0L, 1, this.textBoxWidget.getText())) : (double)(Dispatcher\ufe0f.bootstrap("call", 0L, 1, this.textBoxWidget.getText().replace((CharSequence)((Object)Dispatcher.bootstrap("get", 30064771112L)), "")) / 100.0);
            this.apply(this.value, true);
            this.updateLabel();
            this.manualInput = false;
            return true;
        }
        if (!this.volatile\u00a0else || n != 263 && n != 262 || !this.hover) return false;
        double d = 0.01;
        this.value = (double)Dispatcher\ufe0f.bootstrap("call", 1L, 1, 0.0, 1.0, this.value += n == 263 ? -d : d);
        this.apply(this.value, true);
        this.updateLabel();
        return true;
    }

    @Override
    public void switch() {
        if (this.manualInput) {
            this.textBoxWidget.switch();
        }
    }

    @Override
    public boolean implements(double d, double d2, int n) {
        if (this.drag) {
            this.drag = false;
            this.apply(this.value, true);
        }
        return false;
    }

    public static double clamp(double d, double d2, double d3) {
        return (double)Dispatcher\ufe0f.bootstrap("call", 1L, 1, Dispatcher\ufe0f.bootstrap("call", 0L, 1, d, d3), d2);
    }

    public double percentage() {
        return this.value * 100.0;
    }

    @Override
    protected void onClick(int n) {
        if (n == 1 && !this.volatile\u00a0else) {
            if (this.textBoxWidget == null) {
                this.addTextBox();
            }
            boolean bl = this.manualInput = !this.manualInput;
            if (this.manualInput) {
                this.textBoxWidget.setFocused(true);
                this.textBoxWidget.setText(this.getValueText());
            }
        }
        this.drag = n == 0;
    }

    public abstract double normalize(double var1);

    public abstract void apply(double var1, boolean var3);

    @Override
    public abstract void updateLabel();

    public abstract String getValueText();

    public boolean isDrag() {
        return this.drag;
    }

    public double getValue() {
        return this.value;
    }

    public double getSliderHeight() {
        return this.sliderHeight;
    }

    public void setValue(double d) {
        this.value = d;
    }

    public void setSliderHeight(double d) {
        this.sliderHeight = d;
    }

    public boolean isManualInput() {
        return this.manualInput;
    }

    public void setManualInput(boolean bl) {
        this.manualInput = bl;
    }

    public void setPercentageMode(boolean bl) {
        this.percentageMode = bl;
    }

    public String getNumberRegex() {
        this.getClass();
        return Dispatcher.bootstrap("get", 0x900000007L);
    }
}

