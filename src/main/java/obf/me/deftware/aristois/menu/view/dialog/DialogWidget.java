/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 */
package me.deftware.aristois.menu.view.dialog;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import \u0000nunyaboolean.catch.for.super.try;
import java.awt.Color;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class DialogWidget
extends ContainerWidget {
    private try parent;
    protected boolean darkOverlay = true;

    public DialogWidget(double d, double d2, double d3, double d4, interface interface_) {
        super(d, d2, d3, d4, interface_);
        this.setDraggable(true);
        this.setRenderShadow(true);
    }

    public DialogWidget setupComponents(Message message) {
        this.addTitle(message, n -> {});
        this.title.setDrawExitButton(true);
        this.title.setDrawArrowButton(false);
        return this;
    }

    @Override
    public void implements() {
        super.implements();
        this.center();
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        bl = super.implements(d, d2, f, bl);
        return this.darkOverlay || bl;
    }

    @Override
    protected void drawOverlay() {
        if (this.darkOverlay) {
            ((QuadRenderStack)this.quadRenderStack.glColor(Color.black, 150.0f)).drawRect(0.0f, 0.0f, (float)Dispatcher\ufe0f.bootstrap("call", 0L, 1) / Dispatcher\ufe0f.bootstrap("call", 1L, 1), (float)Dispatcher\ufe0f.bootstrap("call", 2L, 1) / Dispatcher\ufe0f.bootstrap("call", 1L, 1));
        }
    }

    @Override
    public boolean long(double d, double d2, int n) {
        boolean bl = super.long(d, d2, n);
        return this.darkOverlay || bl;
    }

    public boolean isOpen() {
        if (this.parent != null) {
            return this.parent.long().contains(this);
        }
        return false;
    }

    public void open(try try_) {
        this.parent = try_;
        if (!this.isOpen()) {
            this.implements();
            this.parent.long().add(this);
        }
    }

    @Override
    public void close() {
        if (this.isOpen() && this.parent != null) {
            this.parent.long().remove(this);
        }
    }

    public boolean isDarkOverlay() {
        return this.darkOverlay;
    }

    public void setDarkOverlay(boolean bl) {
        this.darkOverlay = bl;
    }
}

