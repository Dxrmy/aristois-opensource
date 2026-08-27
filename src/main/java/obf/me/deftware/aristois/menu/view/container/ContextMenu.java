/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 */
package me.deftware.aristois.menu.view.container;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.if.break.synchronized;
import \u0000nunyaboolean.catch.for.if.break.this.catch;
import \u0000nunyaboolean.catch.for.super.break;
import \u0000nunyaboolean.catch.for.super.break.default;
import \u0000nunyaboolean.catch.for.super.enum.for;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import java.awt.Color;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ContextMenu
extends ContainerWidget {
    private Object parent;
    private catch parentBounds;
    private double parentY;

    public ContextMenu(double d, double d2, double d3, double d4, interface interface_) {
        super(d, d2, d3, d4, interface_);
    }

    public void open(catch catch_, double d, double d2, Object object) {
        this.implements();
        double d3 = d2 - this.volatile\u00a0short.static();
        if (d3 < 5.0) {
            d3 = d2;
        }
        this.volatile\u00a0short.implements(d, d3);
        this.parentBounds = catch_;
        this.parentY = catch_.long();
        this.parent = object;
        List<synchronized> list = object instanceof \u0000nunyaboolean.catch.for.if.break ? ((\u0000nunyaboolean.catch.for.if.break)((Object)object)).long() : ((for)object).boolean();
        list.add(this);
    }

    @Override
    public void implements() {
        this.recalculate();
        super.implements();
    }

    @Override
    public void close() {
        if (this.isOpen()) {
            List<synchronized> list = this.parent instanceof \u0000nunyaboolean.catch.for.if.break ? ((\u0000nunyaboolean.catch.for.if.break)((Object)this.parent)).long() : ((for)this.parent).boolean();
            list.remove(this);
        }
    }

    public boolean isOpen() {
        if (this.parent != null) {
            List<synchronized> list = this.parent instanceof \u0000nunyaboolean.catch.for.if.break ? ((\u0000nunyaboolean.catch.for.if.break)((Object)this.parent)).long() : ((for)this.parent).boolean();
            return list.contains(this);
        }
        return false;
    }

    public void recalculate() {
        List list = (List)((ListWidget)this.children.get(0)).getWidgetStream().collect(Dispatcher\ufe0f.bootstrap("call", 0L, 1));
        double d = ((ListWidget)this.children.get(0)).getChildrenHeight(this.volatile\u00a0do.throw(), list);
        this.static().for(d);
    }

    @Override
    protected Color getBackgroundColor() {
        return this.volatile\u00a0do.byte();
    }

    @Override
    public void switch() {
        super.switch();
        if (this.parentY != this.parentBounds.long()) {
            this.close();
        }
    }

    @Override
    public boolean long(double d, double d2, int n) {
        if (this.volatile\u00a0short.switch(d, d2)) {
            return super.long(d, d2, n);
        }
        if (n == 0 || !this.parentBounds.switch(d, d2)) {
            this.close();
        }
        return false;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class ContextBuilder
    implements break<ContextMenu, ContextBuilder> {
        final private ContextMenu contextMenu;
        final private ListWidget listWidget;
        final private interface theme;

        public ContextBuilder(double d, interface interface_) {
            this.theme = interface_;
            this.contextMenu = new ContextMenu(0.0, 0.0, 200.0, 0.0, this.theme);
            this.listWidget = new ListWidget(0.0, 0.0, d, 0.0, interface_);
            this.listWidget.implements(default.goto\u00a0transient, default.goto\u00a0null);
            this.listWidget.setRenderBackground(false);
            this.listWidget.setStencil(true);
            this.contextMenu.implements(new synchronized[]{this.listWidget});
        }

        public ContextBuilder button(Message message, final Runnable runnable) {
            ButtonWidget buttonWidget = new ButtonWidget(message, this.theme){

                @Override
                protected void onClick(int n) {
                    if (n == 0) {
                        runnable.run();
                    }
                }
            };
            buttonWidget.implements(default.goto\u00a0transient);
            this.listWidget.implements(new synchronized[]{buttonWidget});
            return this;
        }

        public ContextMenu build() {
            return this.contextMenu;
        }

        @Override
        public synchronized switch() {
            return this.build();
        }
    }
}

