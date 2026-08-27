/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 */
package me.deftware.aristois.menu.widgets;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.if.break.this.catch;
import \u0000nunyaboolean.catch.for.private.s.Dispatcher;
import \u0000nunyaboolean.catch.for.super.break.this;
import \u0000nunyaboolean.catch.for.super.do;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class ButtonWidget
extends do {
    protected Message label;
    protected double padding;
    protected catch fontBounds = new catch();
    protected this textAlign;
    protected boolean loading = false;
    protected boolean hover = false;
    protected final QuadRenderStack quadRenderStack = new QuadRenderStack();
    private int ticks = 0;

    public ButtonWidget(Message message, interface interface_) {
        this(0.0, 0.0, 0.0, message, interface_);
    }

    public ButtonWidget(double d, double d2, double d3, Message message, interface interface_) {
        super(d, d2, d3, 0.0, interface_);
        this.label = message;
        this.fontBounds.long(this.volatile\u00a0short);
        this.init();
    }

    public void init() {
        this.fontBounds.for(this.volatile\u00a0package.getFontHeight());
        this.padding = this.volatile\u00a0do.boolean();
        this.updatePadding(this.padding);
    }

    public void updatePadding(double d) {
        this.padding = d;
        this.static().for((double)this.volatile\u00a0package.getFontHeight() + d * 2.0);
        this.fontBounds.implements(d, this.getTextCenter());
    }

    @Override
    public void long(boolean bl) {
        this.quadRenderStack.setScaled(bl);
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        boolean bl2 = this.isMouseOver(d, d2, bl);
        if (bl2 != this.hover) {
            this.hover = bl2;
        }
        this.drawBackground(d, d2, f);
        if (this.quadRenderStack.isBuilding()) {
            this.quadRenderStack.end();
        }
        Object object = this.label;
        if (this.loading) {
            object = Dispatcher\ufe0f.bootstrap("call", 1L, 1, Dispatcher\ufe0f.bootstrap("call", 0L, 1, Dispatcher.bootstrap("get", 8589934650L), this.ticks / 6 % 4));
        }
        this.prepareText(d, d2, f, (Message)object);
        return bl;
    }

    @Override
    public void switch() {
        ++this.ticks;
    }

    public <T extends ButtonWidget> T setTextAlign(this this_) {
        this.textAlign = this_;
        return (T)this;
    }

    public <T extends ButtonWidget> T autoWidth() {
        this.volatile\u00a0short.if(this.padding * 2.0 + (double)this.volatile\u00a0package.getStringWidth(this.label));
        return (T)this;
    }

    public boolean isMouseOver(double d, double d2, boolean bl) {
        return this.volatile\u00a0short.switch(d, d2) && !bl;
    }

    protected void drawBackground(double d, double d2, float f) {
        ((QuadRenderStack)this.quadRenderStack.glColor(this.volatile\u00a0do.float(), this.hover ? (float)this.volatile\u00a0do.float().getAlpha() : 0.0f)).begin().drawRect(this.volatile\u00a0short.implements(), this.volatile\u00a0short.long(), this.volatile\u00a0short.implements() + this.volatile\u00a0short.switch(), this.volatile\u00a0short.long() + this.volatile\u00a0short.static());
    }

    protected this getAlign() {
        if (this.textAlign != null) {
            return this.textAlign;
        }
        return this.volatile\u00a0do.false().break();
    }

    protected void prepareText(double d, double d2, float f, Message message) {
        double d3 = this.volatile\u00a0short.implements() + (this.volatile\u00a0short.switch() / 2.0 - (double)this.volatile\u00a0package.getStringWidth(message) / 2.0);
        double d4 = this.volatile\u00a0short.long() + this.getTextCenter();
        if (this.getAlign() == this.goto\u00a0goto) {
            d3 = this.volatile\u00a0short.implements() + this.padding;
        } else if (this.getAlign() == this.goto\u00a0final) {
            d3 = this.volatile\u00a0short.implements() + this.volatile\u00a0short.switch() - (double)this.volatile\u00a0package.getStringWidth(message) - this.padding;
        }
        this.drawText(d3, d4, message);
    }

    protected double getTextCenter() {
        return this.volatile\u00a0short.static() / 2.0 - (double)this.volatile\u00a0package.getFontHeight() / 2.0;
    }

    protected void drawText(double d, double d2, Message message) {
        this.volatile\u00a0package.begin().drawString((int)d, (int)d2, message).end();
    }

    @Override
    public boolean long(double d, double d2, int n) {
        if (this.volatile\u00a0short.switch(d, d2)) {
            this.onClick(n);
            return true;
        }
        return false;
    }

    public void updateLabel() {
    }

    protected abstract void onClick(int var1);

    public Message getLabel() {
        return this.label;
    }

    public void setLabel(Message message) {
        this.label = message;
    }

    public double getPadding() {
        return this.padding;
    }

    public catch getFontBounds() {
        return this.fontBounds;
    }

    public this getTextAlign() {
        return this.textAlign;
    }

    public void setLoading(boolean bl) {
        this.loading = bl;
    }
}

