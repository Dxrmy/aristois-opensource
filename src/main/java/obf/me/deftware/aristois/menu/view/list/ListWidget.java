/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.aristois.menu.view.list;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.if.break.synchronized;
import \u0000nunyaboolean.catch.for.if.break.this.catch;
import \u0000nunyaboolean.catch.for.super.break.boolean;
import \u0000nunyaboolean.catch.for.super.break.default;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import \u0000nunyaboolean.catch.for.super.enum.native;
import \u0000nunyaboolean.catch.for.super.enum.this;
import \u0000nunyaboolean.catch.for.super.enum.transient;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.list.ScrollbarWidget;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ListWidget
extends ContainerWidget
implements this,
native {
    private double offset = 0.0;
    final private ScrollbarWidget scrollbar;
    protected boolean offsetForScrollbar = false;
    protected Predicate<synchronized> filter = null;
    protected int selectedIndex = 0;
    private double childY;

    public ListWidget(interface interface_) {
        this(0.0, 0.0, 0.0, 0.0, interface_);
    }

    public ListWidget(double d, double d2, double d3, double d4, interface interface_) {
        super(d, d2, d3, d4, interface_);
        this.setStencil(true);
        this.setBorder(0.0);
        this.scrollbar = new ScrollbarWidget(0.0, 0.0, 0.0, this, interface_);
        this.scrollbar.implements(boolean.goto\u00a0short, boolean.goto\u00a0public);
        this.scrollbar.implements(default.goto\u00a0null);
        this.scrollbar.implements(this);
        this.implements(new synchronized[]{this.scrollbar});
    }

    @Override
    public void switch() {
        this.maxHeight = this.getWidgetStream().filter(synchronized_ -> !(synchronized_ instanceof ScrollbarWidget)).mapToDouble(synchronized_ -> synchronized_.static().static()).sum() - this.volatile\u00a0short.static();
        super.switch();
    }

    public Stream<synchronized> getWidgetStream() {
        return this.children.stream().filter(this::shouldDrawChild);
    }

    public boolean isAtTop() {
        return this.offset == 0.0;
    }

    public void adjust() {
        catch catch_ = ((synchronized)this.children.get(this.children.size() - 1)).static();
        double d = catch_.long() + catch_.static();
        double d2 = this.volatile\u00a0short.long() + this.volatile\u00a0short.static();
        if (!this.isAtTop() && d < d2) {
            double d3 = d2 - d;
            this.offset -= d3;
        }
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        if (this.volatile\u00a0else) {
            d = this.getEmulatedMouseX();
            d2 = this.getEmulatedMouseY();
        }
        return super.implements(d, d2, f, bl);
    }

    protected double getEmulatedMouseX() {
        return this.volatile\u00a0short.implements() + this.volatile\u00a0short.switch() / 2.0;
    }

    protected double getScrollOffset() {
        return ((synchronized)this.children.get(1)).static().static();
    }

    protected double getEmulatedMouseY() {
        double d = this.getSelectedIndexPosition(this.selectedIndex) - this.getScrollOffset() / 2.0;
        if (this.scrollbar.shouldUseScrollbar()) {
            d -= this.offset;
        }
        return d;
    }

    protected double getSelectedIndexPosition(int n) {
        return this.volatile\u00a0short.long() + this.getScrollOffset() * (double)(n + 1);
    }

    @Override
    public boolean long(int n, int n2, int n3) {
        if (this.volatile\u00a0else) {
            if (n == 265 || n == 264) {
                this.setSelectedIndex(this.selectedIndex + (n == 265 ? -1 : 1));
                this.emulateScroll(n);
            } else if (n == 262 || n == 257 || n == 335) {
                double d = this.getEmulatedMouseX();
                double d2 = this.getEmulatedMouseY();
                double d3 = n == 262 ? 0.0 : 1.0;
                this.long(d, d2, (int)d3);
                this.implements(d, d2, (int)d3);
            }
        }
        return super.long(n, n2, n3);
    }

    protected void emulateScroll(int n) {
        double d = this.getScrollOffset();
        double d2 = this.getSelectedIndexPosition(this.selectedIndex - (n == 265 ? 1 : 0)) - this.offset;
        if (this.scrollbar.shouldUseScrollbar() && (d2 > this.volatile\u00a0short.long() + this.volatile\u00a0short.static() && n == 264 || d2 < this.volatile\u00a0short.long() && n == 265)) {
            this.scrollbar.setScrollerPosition(this.offset + (n == 265 ? -d : d));
        }
    }

    @Override
    protected boolean shouldDrawChild(synchronized synchronized_) {
        if (synchronized_ instanceof ScrollbarWidget) {
            return true;
        }
        if (this.filter != null) {
            return this.filter.test(synchronized_);
        }
        return true;
    }

    @Override
    protected boolean drawChildren(double d, double d2, float f, boolean bl) {
        if (this.filter == null) {
            this.adjust();
        }
        this.childY = -this.offset;
        boolean bl2 = bl;
        boolean bl3 = this.scrollbar.static().switch(d, d2);
        if ((bl = super.drawChildren(d, d2, f, bl || this.scrollbar.isMouseDrag() || bl3)) && !bl2 && bl3) {
            bl = false;
        }
        return this.scrollbar.implements(d, d2, f, bl);
    }

    @Override
    protected void applyBoundsUpdates(synchronized synchronized_) {
        synchronized_.static().implements(0.0, this.childY);
        if (!(synchronized_ instanceof ScrollbarWidget)) {
            this.childY += synchronized_.static().static();
        }
        super.applyBoundsUpdates(synchronized_);
        if (!(synchronized_ instanceof ScrollbarWidget) && this.scrollbar.shouldUseScrollbar() && (this.offsetForScrollbar || synchronized_ instanceof transient.catch)) {
            synchronized_.static().if(synchronized_.static().switch() - this.scrollbar.static().switch());
        }
    }

    @Override
    public void switch(double d, double d2) {
        if (this.volatile\u00a0short.switch(this.mouseX, this.mouseY)) {
            this.scrollbar.switch(d, d2);
        }
        super.switch(d, d2);
    }

    public int getMaxSelectionIndex() {
        return (int)this.getWidgetStream().count();
    }

    public void setSelectedIndex(int n) {
        this.selectedIndex = (int)Dispatcher\ufe0f.bootstrap("call", 0L, 1, 0.0, this.getMaxSelectionIndex() - 2, (double)n);
    }

    public void setOffset(double d) {
        this.offset = d;
    }

    public void setOffsetForScrollbar(boolean bl) {
        this.offsetForScrollbar = bl;
    }

    public void setFilter(Predicate<synchronized> predicate) {
        this.filter = predicate;
    }

    public void setChildY(double d) {
        this.childY = d;
    }

    public double getOffset() {
        return this.offset;
    }

    public ScrollbarWidget getScrollbar() {
        return this.scrollbar;
    }

    public boolean isOffsetForScrollbar() {
        return this.offsetForScrollbar;
    }

    public Predicate<synchronized> getFilter() {
        return this.filter;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public double getChildY() {
        return this.childY;
    }
}

