/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.aristois.menu.view.container;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.if.break.this.catch;
import \u0000nunyaboolean.catch.for.int.float;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import me.deftware.aristois.menu.view.container.ContainerWidget;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CollapsableContainerWidget
extends ContainerWidget {
    protected boolean collapsed = false;
    protected double lastHeight;
    protected double lastMin;
    protected double lastMax;
    protected double top;
    final private float animation = new float(110.0f, 16.0){

        @Override
        protected void static(double d) {
            double d2 = CollapsableContainerWidget.this.collapsed ? 1.0 - d : d;
            ((catch)((Object)Dispatcher\ufe0f.bootstrap("call", 0L, 1, CollapsableContainerWidget.this))).for(CollapsableContainerWidget.this.top + d2 * CollapsableContainerWidget.this.lastHeight);
        }

        @Override
        protected void short() {
            ((catch)((Object)Dispatcher\ufe0f.bootstrap("call", 0L, 1, CollapsableContainerWidget.this))).for(CollapsableContainerWidget.this.collapsed ? CollapsableContainerWidget.this.top : CollapsableContainerWidget.this.top + CollapsableContainerWidget.this.lastHeight);
        }
    };

    public CollapsableContainerWidget(double d, double d2, double d3, double d4, interface interface_) {
        super(d, d2, d3, d4, interface_);
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        this.animation.implements(f);
        bl = super.implements(d, d2, f, bl);
        return bl;
    }

    public boolean togglePanel(boolean bl) {
        if (bl && !this.animation.abstract()) {
            return false;
        }
        this.top = this.boolean().get(0).static().static();
        if (!this.collapsed) {
            this.lastHeight = this.volatile\u00a0short.static() - this.top;
            this.lastMin = this.getMinHeight();
            this.lastMax = this.getMaxHeight();
            this.setMaxHeight(this.volatile\u00a0short.static());
            this.setMinHeight(this.volatile\u00a0short.static());
            if (!bl) {
                this.volatile\u00a0short.for(this.top);
            }
        } else {
            this.setMinHeight(this.lastMin);
            this.setMaxHeight(this.lastMax);
            if (!bl) {
                this.volatile\u00a0short.for(this.top + this.lastHeight);
            }
        }
        boolean bl2 = this.collapsed = !this.collapsed;
        if (bl) {
            this.animation.static();
        }
        return true;
    }

    public boolean isCollapsed() {
        return this.collapsed;
    }

    public void setCollapsed(boolean bl) {
        this.collapsed = bl;
    }

    public double getLastHeight() {
        return this.lastHeight;
    }

    public double getLastMin() {
        return this.lastMin;
    }

    public double getLastMax() {
        return this.lastMax;
    }

    public double getTop() {
        return this.top;
    }

    public float getAnimation() {
        return this.animation;
    }

    public static catch access$000(CollapsableContainerWidget collapsableContainerWidget) {
        return collapsableContainerWidget.volatile\u00a0short;
    }

    public static catch access$100(CollapsableContainerWidget collapsableContainerWidget) {
        return collapsableContainerWidget.volatile\u00a0short;
    }
}

