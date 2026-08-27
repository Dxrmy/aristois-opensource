/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 */
package me.deftware.aristois.menu.view.list;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.if.break.this.catch;
import \u0000nunyaboolean.catch.for.int.float;
import \u0000nunyaboolean.catch.for.super.do;
import \u0000nunyaboolean.catch.for.super.enum.boolean;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import java.lang.invoke.CallSite;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.client.framework.render.batching.QuadRenderStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ScrollbarWidget
extends do
implements boolean {
    protected final QuadRenderStack quadRenderStack = new QuadRenderStack();
    protected final ListWidget parent;
    protected double scrollerHeight = 35.0;
    protected double scrollerWidth = 10.0;
    protected double scrollerY = 0.0;
    protected boolean mouseDrag = false;
    protected boolean hover = false;
    private double scrollMultiplier = 1.5;
    private double target = 0.0;
    final private float animation = new float(140.0f, 35.0){

        @Override
        protected void static(double d) {
            ScrollbarWidget.this.setScrollerPosition(ScrollbarWidget.this.parent.getOffset() + Dispatcher\ufe0f.bootstrap("call", 0L, 1, ScrollbarWidget.this) * d);
        }
    };
    final private float scrollbarAnimation = new float(60.0f, 16.0){

        @Override
        protected void static(double d) {
            double d2 = ScrollbarWidget.this.hover ? d : 1.0 - d;
            double d3 = ScrollbarWidget.this.scrollerWidth / 2.0;
            ((catch)((Object)Dispatcher\ufe0f.bootstrap("call", 0L, 1, ScrollbarWidget.this))).if(d3 + d3 * d2);
        }
    };

    public ScrollbarWidget(double d, double d2, double d3, ListWidget listWidget, interface interface_) {
        super(d, d2, 0.0, d3, interface_);
        this.volatile\u00a0short.if(this.scrollerWidth / 2.0);
        this.parent = listWidget;
        this.animation.implements(true);
    }

    @Override
    public void long(boolean bl) {
        this.quadRenderStack.setScaled(bl);
    }

    @Override
    public void implements() {
        this.scrollerWidth = this.volatile\u00a0do.assert();
        this.volatile\u00a0short.if(this.scrollerWidth / 2.0);
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        if (this.shouldUseScrollbar()) {
            if (this.mouseDrag) {
                this.applyDrag(d2);
            } else {
                boolean bl2;
                boolean bl3 = bl2 = this.volatile\u00a0short.switch(d, d2) && !bl;
                if (bl2 != this.hover && this.scrollbarAnimation.abstract()) {
                    this.scrollbarAnimation.implements(this.volatile\u00a0do.short());
                    this.hover = bl2;
                } else if (this.hover && !bl2 && !this.scrollbarAnimation.abstract() && !this.scrollbarAnimation.long()) {
                    this.scrollbarAnimation.switch();
                    this.hover = false;
                }
            }
            this.animation.implements(f);
            this.scrollbarAnimation.implements(f);
            if (this.animation.abstract()) {
                this.target = 0.0;
            }
            this.renderScrollbar(d, d2, f);
        } else {
            this.parent.setOffset(0.0);
        }
        return bl || this.mouseDrag;
    }

    protected double getScrollerHeightOffset() {
        return this.scrollerHeight;
    }

    protected void renderScrollbar(double d, double d2, float f) {
        this.updateScrollerPosition();
        ((QuadRenderStack)((QuadRenderStack)this.quadRenderStack.begin().glColor(this.volatile\u00a0do.finally().darker(), (float)this.volatile\u00a0do.finally().getAlpha())).drawRect(this.volatile\u00a0short.implements(), this.volatile\u00a0short.long(), this.volatile\u00a0short.implements() + this.volatile\u00a0short.switch(), this.volatile\u00a0short.long() + this.volatile\u00a0short.static()).glColor(this.volatile\u00a0do.finally(), (float)this.volatile\u00a0do.finally().getAlpha())).drawRect(this.volatile\u00a0short.implements(), this.volatile\u00a0short.long() + this.scrollerY, this.volatile\u00a0short.implements() + this.volatile\u00a0short.switch(), this.volatile\u00a0short.long() + this.scrollerY + this.scrollerHeight).end();
    }

    protected boolean shouldUseScrollbar() {
        return this.parent.getMaxHeight() > 0.0;
    }

    @Override
    public void switch(double d, double d2) {
        if (!this.mouseDrag) {
            if (d2 < 0.0 && this.target < 0.0 || d2 > 0.0 && this.target > 0.0) {
                this.target = 0.0;
            }
            this.target += -(d2 * this.scrollMultiplier);
            this.animation.static();
        }
    }

    @Override
    public boolean implements(double d, double d2, int n) {
        this.mouseDrag = false;
        return false;
    }

    @Override
    public boolean long(double d, double d2, int n) {
        boolean bl = this.mouseDrag = this.volatile\u00a0short.switch(d, d2) && this.shouldUseScrollbar();
        if (this.mouseDrag && !this.scrollbarAnimation.abstract() && !this.scrollbarAnimation.long()) {
            this.scrollbarAnimation.switch(0L);
        }
        return this.mouseDrag;
    }

    protected void applyDrag(double d) {
        double d2 = d - this.volatile\u00a0short.long();
        this.setScrollerPosition((d2 -= this.scrollerHeight / 2.0) / ((this.parent.static().static() - this.getScrollerHeightOffset()) / this.parent.getMaxHeight()));
    }

    @Override
    public int long(double d, double d2) {
        CallSite callSite = Dispatcher\ufe0f.bootstrap("call", 0L, 1, false);
        if ((this.volatile\u00a0short.switch(d, d2) && callSite == false || this.mouseDrag) && this.shouldUseScrollbar()) {
            return 221188;
        }
        return -1;
    }

    public void setScrollerPosition(double d) {
        this.parent.setOffset((double)Dispatcher\ufe0f.bootstrap("call", 1L, 1, Dispatcher\ufe0f.bootstrap("call", 0L, 1, 0.0, d), this.parent.getMaxHeight()));
    }

    protected void updateScrollerPosition() {
        this.scrollerHeight = (double)Dispatcher\ufe0f.bootstrap("call", 0L, 1, 30.0, this.parent.static().static(), this.parent.static().static() * (this.parent.static().static() / (this.parent.getMaxHeight() + this.parent.static().static())));
        this.scrollerY = (this.parent.static().static() - this.getScrollerHeightOffset()) / this.parent.getMaxHeight() * this.parent.getOffset();
    }

    public QuadRenderStack getQuadRenderStack() {
        return this.quadRenderStack;
    }

    public ListWidget getParent() {
        return this.parent;
    }

    public double getScrollerHeight() {
        return this.scrollerHeight;
    }

    public double getScrollerWidth() {
        return this.scrollerWidth;
    }

    public void setScrollerHeight(double d) {
        this.scrollerHeight = d;
    }

    public void setScrollerWidth(double d) {
        this.scrollerWidth = d;
    }

    public double getScrollerY() {
        return this.scrollerY;
    }

    public boolean isMouseDrag() {
        return this.mouseDrag;
    }

    public boolean isHover() {
        return this.hover;
    }

    public double getScrollMultiplier() {
        return this.scrollMultiplier;
    }

    public double getTarget() {
        return this.target;
    }

    public void setScrollMultiplier(double d) {
        this.scrollMultiplier = d;
    }

    public void setTarget(double d) {
        this.target = d;
    }

    public float getAnimation() {
        return this.animation;
    }

    public float getScrollbarAnimation() {
        return this.scrollbarAnimation;
    }

    public static double access$000(ScrollbarWidget scrollbarWidget) {
        return scrollbarWidget.target;
    }

    public static catch access$100(ScrollbarWidget scrollbarWidget) {
        return scrollbarWidget.volatile\u00a0short;
    }
}

