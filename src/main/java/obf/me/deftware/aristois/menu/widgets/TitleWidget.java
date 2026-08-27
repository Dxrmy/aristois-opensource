/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.registry.font.IFontProvider
 *  me.deftware.client.framework.render.batching.LineRenderStack
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 *  me.deftware.client.framework.render.batching.font.FontRenderStack
 */
package me.deftware.aristois.menu.widgets;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.int.case;
import \u0000nunyaboolean.catch.for.int.do.synchronized;
import \u0000nunyaboolean.catch.for.int.enum;
import \u0000nunyaboolean.catch.for.int.long;
import \u0000nunyaboolean.catch.for.short.do.boolean.implements;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import java.awt.Color;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.font.IFontProvider;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class TitleWidget
extends ButtonWidget {
    protected double underlineHeight = 2.0;
    protected boolean drawArrowButton = false;
    protected boolean drawExitButton = false;
    protected double buttonPadding = 15.0;
    protected Color fontColor = null;
    protected boolean hover = false;
    protected boolean mousePressed = false;
    protected boolean drawIcon = false;
    protected final LineRenderStack lineRenderStack = new LineRenderStack();
    protected long atlas = synchronized.try\u00a0instanceof;
    protected int iconU;
    protected int iconV;
    protected final case arrow = new case(){

        @Override
        protected void long(double d, double d2, double d3, double d4) {
            TitleWidget.this.lineRenderStack.begin();
            TitleWidget.this.lineRenderStack.vertex(d, d2);
            TitleWidget.this.lineRenderStack.vertex(d + d3 / 2.0, d2 + d3);
            TitleWidget.this.lineRenderStack.vertex(d + d3 / 2.0, d2 + d3);
            TitleWidget.this.lineRenderStack.vertex(d + d3, d2);
            TitleWidget.this.lineRenderStack.end();
        }
    };
    protected final case exit = new case(){

        @Override
        protected void long(double d, double d2, double d3, double d4) {
            TitleWidget.this.lineRenderStack.begin();
            TitleWidget.this.lineRenderStack.vertex(d, d2);
            TitleWidget.this.lineRenderStack.vertex(d + d3, d2 + d3);
            TitleWidget.this.lineRenderStack.vertex(d, d2 + d3);
            TitleWidget.this.lineRenderStack.vertex(d + d3, d2);
            TitleWidget.this.lineRenderStack.end();
        }
    };

    public TitleWidget(Message message, interface interface_) {
        super(message, interface_);
        this.volatile\u00a0package = new FontRenderStack((IFontProvider)enum.private\u00a0native);
        this.init();
        this.setup();
    }

    @Override
    public void long(boolean bl) {
        super.long(bl);
        this.lineRenderStack.setScaled(bl);
    }

    @Override
    protected void drawText(double d, double d2, Message message) {
        this.volatile\u00a0package.glColor(this.fontColor != null ? this.fontColor : this.volatile\u00a0do.switch());
        this.volatile\u00a0package.begin().drawString((int)d, (int)d2, message).end();
    }

    protected void setup() {
        double d = this.volatile\u00a0short.static() - this.buttonPadding * 2.0;
        double d2 = this.buttonPadding;
        double d3 = this.buttonPadding;
        this.arrow.static().implements(d2, d3);
        this.arrow.static().if(d);
        this.arrow.static().for(d);
        this.exit.static().assert(d3);
        this.exit.static().if(d);
        this.exit.static().for(d);
        this.exit.long(90.0);
        this.exit.static().long(this.volatile\u00a0short);
        this.arrow.static().long(this.volatile\u00a0short);
    }

    @Override
    public boolean implements(double d, double d2, int n) {
        if (this.mousePressed) {
            this.mousePressed = false;
            this.onExitPress();
            return true;
        }
        return false;
    }

    @Override
    public boolean long(double d, double d2, int n) {
        super.long(d, d2, n);
        if (this.drawExitButton && this.exit.static().switch(d, d2)) {
            this.mousePressed = true;
            return true;
        }
        return false;
    }

    @Override
    protected void drawBackground(double d, double d2, float f) {
        super.drawBackground(d, d2, f);
        ((QuadRenderStack)this.quadRenderStack.glColor(this.volatile\u00a0do.break())).drawRect(this.volatile\u00a0short.implements(), this.volatile\u00a0short.long() + this.volatile\u00a0short.static() - this.underlineHeight, this.volatile\u00a0short.implements() + this.volatile\u00a0short.switch(), this.volatile\u00a0short.long() + this.volatile\u00a0short.static()).end();
        if (this.drawExitButton || this.drawArrowButton) {
            ((LineRenderStack)this.lineRenderStack.glColor(Color.white)).lineWidth(1.5f * Dispatcher\ufe0f.bootstrap("call", 0L, 1));
        }
        if (this.drawArrowButton) {
            this.arrow.implements(d, d2, f);
        }
        if (this.drawExitButton) {
            boolean bl = this.exit.static().switch(d, d2);
            if (bl != this.hover && this.exit.abstract().abstract()) {
                this.exit.implements();
                this.hover = bl;
            }
            this.exit.static().finally(this.volatile\u00a0short.switch() - this.buttonPadding - this.exit.static().switch());
            this.exit.implements(d, d2, f);
        }
        implements implements_ = (implements)((Object)Dispatcher\ufe0f.bootstrap("call", 1L, 1, implements.class));
        if (this.drawIcon && implements_.package()) {
            double d3 = 10.0;
            double d4 = (this.static().static() - d3 * 2.0) * (double)Dispatcher\ufe0f.bootstrap("call", 0L, 1);
            this.atlas.implements(d4, (this.static().implements() + d3) * (double)Dispatcher\ufe0f.bootstrap("call", 0L, 1), (this.static().long() + d3) * (double)Dispatcher\ufe0f.bootstrap("call", 0L, 1), this.iconU, this.iconV, implements_.goto());
        }
    }

    protected void onExitPress() {
    }

    public double getUnderlineHeight() {
        return this.underlineHeight;
    }

    public boolean isDrawArrowButton() {
        return this.drawArrowButton;
    }

    public boolean isDrawExitButton() {
        return this.drawExitButton;
    }

    public double getButtonPadding() {
        return this.buttonPadding;
    }

    public Color getFontColor() {
        return this.fontColor;
    }

    public boolean isHover() {
        return this.hover;
    }

    public boolean isMousePressed() {
        return this.mousePressed;
    }

    public boolean isDrawIcon() {
        return this.drawIcon;
    }

    public LineRenderStack getLineRenderStack() {
        return this.lineRenderStack;
    }

    public long getAtlas() {
        return this.atlas;
    }

    public int getIconU() {
        return this.iconU;
    }

    public int getIconV() {
        return this.iconV;
    }

    public void setUnderlineHeight(double d) {
        this.underlineHeight = d;
    }

    public void setDrawArrowButton(boolean bl) {
        this.drawArrowButton = bl;
    }

    public void setDrawExitButton(boolean bl) {
        this.drawExitButton = bl;
    }

    public void setButtonPadding(double d) {
        this.buttonPadding = d;
    }

    public void setFontColor(Color color) {
        this.fontColor = color;
    }

    public void setHover(boolean bl) {
        this.hover = bl;
    }

    public void setMousePressed(boolean bl) {
        this.mousePressed = bl;
    }

    public void setDrawIcon(boolean bl) {
        this.drawIcon = bl;
    }

    public void setAtlas(long longVal) {
        this.atlas = longVal;
    }

    public void setIconU(int n) {
        this.iconU = n;
    }

    public void setIconV(int n) {
        this.iconV = n;
    }

    public case getArrow() {
        return this.arrow;
    }

    public case getExit() {
        return this.exit;
    }
}

