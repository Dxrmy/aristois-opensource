/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.aristois.menu.view.container;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.super.do;
import \u0000nunyaboolean.catch.for.super.enum.boolean;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import java.lang.invoke.CallSite;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class ModifiableWidget
extends do
implements boolean {
    protected boolean dragging = false;
    protected boolean resizable = false;
    protected boolean draggable = false;
    protected double border = 10.0;
    protected double draggableBorder = 30.0;
    protected double minWidth = this.volatile\u00a0short.switch();
    protected double minHeight = this.volatile\u00a0short.static();
    protected double maxHeight;
    protected double maxWidth = this.minWidth * 3.0;
    protected boolean resizeLeft = false;
    protected boolean resizeRight = false;
    protected boolean resizeBottom = false;
    protected int cursor = -1;
    protected double mouseX = 0.0;
    protected double mouseY = 0.0;
    protected double x2 = 0.0;
    protected double y2 = 0.0;
    protected double oldWidth;

    public ModifiableWidget(double d, double d2, double d3, double d4, interface interface_) {
        super(d, d2, d3, d4, interface_);
        this.maxHeight = this.minHeight * 3.0;
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        this.mouseX = d;
        this.mouseY = d2;
        return this.update(bl);
    }

    @Override
    public boolean implements(double d, double d2, int n) {
        this.resizeBottom = false;
        this.resizeRight = false;
        this.resizeLeft = false;
        this.dragging = false;
        return false;
    }

    @Override
    public boolean long(double d, double d2, int n) {
        if (n == 0) {
            if (this.volatile\u00a0short.abstract(this.draggableBorder).switch(d, d2)) {
                if (!this.draggable) {
                    return false;
                }
                this.dragging = true;
                this.x2 = this.volatile\u00a0short.implements() - d;
                this.y2 = this.volatile\u00a0short.long() - d2;
            } else if (this.resizable) {
                this.resizeLeft = this.volatile\u00a0short.float(this.border).switch(d, d2);
                this.resizeRight = this.volatile\u00a0short.break(this.border).switch(d, d2);
                this.resizeBottom = this.volatile\u00a0short.byte(this.border).switch(d, d2);
                if (this.resizeLeft) {
                    this.oldWidth = this.volatile\u00a0short.switch() + this.volatile\u00a0short.implements();
                }
            }
        }
        return n == 0 && (this.dragging || this.resizeLeft || this.resizeRight || this.resizeBottom);
    }

    protected boolean update(boolean bl) {
        if (this.dragging) {
            double d = this.x2 + this.mouseX;
            double d2 = this.y2 + this.mouseY;
            this.volatile\u00a0short.implements((float)(d > -1.0 ? d : this.volatile\u00a0short.implements()), (double)((float)(d2 > -1.0 ? d2 : this.volatile\u00a0short.long())));
        } else {
            if (this.resizeBottom) {
                this.volatile\u00a0short.for((double)Dispatcher\ufe0f.bootstrap("call", 1L, 1, Dispatcher\ufe0f.bootstrap("call", 0L, 1, this.mouseY - this.volatile\u00a0short.long(), this.minHeight), this.maxHeight));
            }
            if (this.resizeLeft) {
                double d = this.oldWidth - this.mouseX;
                if (d <= this.maxWidth && d >= this.minWidth) {
                    this.volatile\u00a0short.if(d);
                    this.volatile\u00a0short.finally(this.volatile\u00a0short.implements() + (this.mouseX - this.volatile\u00a0short.implements()));
                }
            } else if (this.resizeRight) {
                this.volatile\u00a0short.if((double)Dispatcher\ufe0f.bootstrap("call", 1L, 1, Dispatcher\ufe0f.bootstrap("call", 0L, 1, this.mouseX - this.volatile\u00a0short.implements(), this.minWidth), this.maxWidth));
            }
        }
        return bl || this.dragging || this.resizeBottom || this.resizeLeft || this.resizeRight;
    }

    protected int getModificationCursor(double d, double d2) {
        CallSite callSite = Dispatcher\ufe0f.bootstrap("call", 0L, 1, false);
        if (!this.volatile\u00a0short.abstract(this.draggableBorder).switch(d, d2) && this.resizable) {
            if (this.resizeLeft || this.volatile\u00a0short.float(this.border).switch(d, d2) && callSite == false || this.resizeRight || this.volatile\u00a0short.break(this.border).switch(d, d2) && callSite == false) {
                return 221189;
            }
            if (this.resizeBottom || this.volatile\u00a0short.byte(this.border).switch(d, d2) && callSite == false) {
                return 221190;
            }
        }
        return -1;
    }

    @Override
    public int long(double d, double d2) {
        return this.getModificationCursor(d, d2);
    }

    public boolean isDragging() {
        return this.dragging;
    }

    public boolean isResizable() {
        return this.resizable;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void setResizable(boolean bl) {
        this.resizable = bl;
    }

    public void setDraggable(boolean bl) {
        this.draggable = bl;
    }

    public double getBorder() {
        return this.border;
    }

    public double getDraggableBorder() {
        return this.draggableBorder;
    }

    public double getMinWidth() {
        return this.minWidth;
    }

    public double getMinHeight() {
        return this.minHeight;
    }

    public double getMaxHeight() {
        return this.maxHeight;
    }

    public double getMaxWidth() {
        return this.maxWidth;
    }

    public void setBorder(double d) {
        this.border = d;
    }

    public void setDraggableBorder(double d) {
        this.draggableBorder = d;
    }

    public void setMinWidth(double d) {
        this.minWidth = d;
    }

    public void setMinHeight(double d) {
        this.minHeight = d;
    }

    public void setMaxHeight(double d) {
        this.maxHeight = d;
    }

    public void setMaxWidth(double d) {
        this.maxWidth = d;
    }

    public boolean isResizeLeft() {
        return this.resizeLeft;
    }

    public boolean isResizeRight() {
        return this.resizeRight;
    }

    public boolean isResizeBottom() {
        return this.resizeBottom;
    }

    public int getCursor() {
        return this.cursor;
    }
}

