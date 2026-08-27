/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.render.batching.CircleRenderStack
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 */
package me.deftware.aristois.menu.widgets;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.int.float;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import \u0000nunyaboolean.catch.for.super.enum.transient;
import java.awt.Color;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.CircleRenderStack;
import me.deftware.client.framework.render.batching.QuadRenderStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class BooleanWidget
extends ButtonWidget
implements transient.catch {
    protected boolean enabled = false;
    private double sliderWidth = 20.0;
    protected final CircleRenderStack circleRenderStack = new CircleRenderStack();
    final private float animation = new float(60.0f, 33.0){

        @Override
        protected void static(double d) {
            if (BooleanWidget.this.enabled) {
                Dispatcher\ufe0f.bootstrap("call", 1L, 1, BooleanWidget.this, Dispatcher\ufe0f.bootstrap("call", 0L, 1, BooleanWidget.this) * d);
            } else {
                Dispatcher\ufe0f.bootstrap("call", 1L, 1, BooleanWidget.this, Dispatcher\ufe0f.bootstrap("call", 0L, 1, BooleanWidget.this) - Dispatcher\ufe0f.bootstrap("call", 0L, 1, BooleanWidget.this) * d);
            }
        }
    };
    private double sliderOffset = 0.0;

    public BooleanWidget(Message message, interface interface_) {
        super(message, interface_);
        this.animation.implements(float.default.private\u00a0extends);
    }

    public BooleanWidget(double d, double d2, double d3, Message message, interface interface_) {
        super(d, d2, d3, message, interface_);
    }

    @Override
    public void long(boolean bl) {
        super.long(bl);
        this.circleRenderStack.setScaled(bl);
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        bl = super.implements(d, d2, f, bl);
        this.animation.implements(f);
        double d3 = this.volatile\u00a0short.long() + this.volatile\u00a0short.static() / 2.0;
        double d4 = 2.0;
        double d5 = this.volatile\u00a0short.switch() - this.padding * 2.0 - this.sliderWidth;
        ((QuadRenderStack)((QuadRenderStack)this.quadRenderStack.begin().glColor(Color.green)).drawRect(this.volatile\u00a0short.implements() + d5, d3 - d4 / 2.0, this.volatile\u00a0short.implements() + d5 + this.sliderOffset, d3 + d4 / 2.0).glColor(Color.red)).drawRect(this.volatile\u00a0short.implements() + d5 + this.sliderOffset, d3 - d4 / 2.0, this.volatile\u00a0short.implements() + d5 + this.sliderWidth, d3 + d4 / 2.0).end();
        ((CircleRenderStack)this.circleRenderStack.glColor(Color.white)).begin().drawFilledCircle((float)(this.volatile\u00a0short.implements() + d5 + this.sliderOffset), (float)d3, 5.0f).end();
        return bl;
    }

    @Override
    protected void onClick(int n) {
        if (n == 0) {
            this.enabled = !this.enabled;
            this.apply(this.enabled);
            this.animation.static();
        }
    }

    protected abstract void apply(boolean var1);

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public double getSliderWidth() {
        return this.sliderWidth;
    }

    public void setSliderWidth(double d) {
        this.sliderWidth = d;
    }

    public float getAnimation() {
        return this.animation;
    }

    public static double access$002(BooleanWidget booleanWidget, double d) {
        booleanWidget.sliderOffset = d;
        return booleanWidget.sliderOffset;
    }

    public static double access$100(BooleanWidget booleanWidget) {
        return booleanWidget.sliderWidth;
    }
}

