/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 */
package me.deftware.aristois.menu.view.container;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.if.break.continue;
import \u0000nunyaboolean.catch.for.if.break.synchronized;
import \u0000nunyaboolean.catch.for.int.extends;
import \u0000nunyaboolean.catch.for.super.break.default;
import \u0000nunyaboolean.catch.for.super.break.this;
import \u0000nunyaboolean.catch.for.super.enum.boolean;
import \u0000nunyaboolean.catch.for.super.enum.for;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import \u0000nunyaboolean.catch.for.super.enum.native;
import \u0000nunyaboolean.catch.for.super.enum.transient;
import java.awt.Color;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import me.deftware.aristois.menu.view.container.ModifiableWidget;
import me.deftware.aristois.menu.view.list.ScrollbarWidget;
import me.deftware.aristois.menu.widgets.TitleWidget;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ContainerWidget
extends ModifiableWidget
implements for,
\u0000nunyaboolean.catch.for.super.enum.default {
    protected final QuadRenderStack quadRenderStack = new QuadRenderStack();
    protected final List<synchronized> children = new CopyOnWriteArrayList<synchronized>();
    protected boolean stencil = false;
    protected boolean scissor = false;
    protected boolean renderBackground = true;
    protected boolean renderShadow = false;
    protected final extends stencilBuffer = new extends();
    protected TitleWidget title;
    protected double shadowSize = 1.5;

    public ContainerWidget(double d, double d2, double d3, double d4, interface interface_) {
        super(d, d2, d3, d4, interface_);
    }

    @Override
    public void implements(synchronized ... synchronizedArray) {
        this.children.addAll((Collection<synchronized>)((Object)Dispatcher\ufe0f.bootstrap("call", 0L, 1, synchronizedArray)));
    }

    @Override
    public void long(boolean bl) {
        this.quadRenderStack.setScaled(bl);
        this.title.long(bl);
    }

    public void addTitle(Message message, final Consumer<Integer> consumer) {
        this.title = new TitleWidget(message, this.volatile\u00a0do){

            @Override
            protected void onClick(int n) {
                consumer.accept(Dispatcher\ufe0f.bootstrap("call", 0L, 1, n));
            }

            @Override
            public boolean isMouseOver(double d, double d2, boolean bl) {
                return super.isMouseOver(d, d2, bl) || ContainerWidget.this.isDragging();
            }

            @Override
            protected void onExitPress() {
                ContainerWidget.this.close();
            }
        };
        this.title.setDrawArrowButton(false);
        this.title.implements(default.goto\u00a0transient);
        this.implements(new synchronized[]{this.title});
        this.title.setTextAlign(this.goto\u00a0default);
        this.setDraggableBorder(this.title.static().static());
    }

    public void close() {
    }

    public double getChildrenHeight(int n, List<synchronized> list) {
        if (list == null) {
            list = this.children;
        }
        boolean bl = list.get(0) instanceof ScrollbarWidget;
        double d = 0.0;
        for (int i = bl ? 1 : 0; i <= n + (bl ? 1 : 0) && list.size() > i; ++i) {
            d += list.get(i).static().static();
        }
        return d;
    }

    public void center() {
        this.volatile\u00a0short.implements((double)((float)Dispatcher\ufe0f.bootstrap("call", 0L, 1) / Dispatcher\ufe0f.bootstrap("call", 1L, 1) / 2.0f) - this.volatile\u00a0short.switch() / 2.0, (double)((float)Dispatcher\ufe0f.bootstrap("call", 2L, 1) / Dispatcher\ufe0f.bootstrap("call", 1L, 1) / 2.0f) - this.volatile\u00a0short.static() / 2.0);
    }

    @Override
    public void implements() {
        this.children.forEach(synchronized::implements);
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        bl = super.implements(d, d2, f, bl);
        this.drawBackground();
        if (this.stencil) {
            this.stencilBuffer.implements().implements(this.volatile\u00a0short).long();
        } else if (this.scissor) {
            this.volatile\u00a0short.implements(true);
            Dispatcher\ufe0f.bootstrap("call", 1L, 1, 3089);
        }
        bl = this.drawChildren(d, d2, f, bl || !this.volatile\u00a0short.switch(d, d2));
        if (this.stencil) {
            this.stencilBuffer.switch();
        } else if (this.scissor) {
            Dispatcher\ufe0f.bootstrap("call", 2L, 1, 3089);
        }
        return bl;
    }

    @Override
    public continue abstract() {
        if (this.volatile\u00a0short.switch(this.mouseX, this.mouseY)) {
            for (synchronized synchronized_ : this.children) {
                if (!synchronized_.static().switch(this.mouseX, this.mouseY)) continue;
                return synchronized_.abstract();
            }
        }
        return null;
    }

    public <T extends synchronized> T getSpecificWidget(Class<T> clazz) {
        for (synchronized synchronized_ : this.children) {
            if (!synchronized_.getClass().isAssignableFrom(clazz)) continue;
            return (T)synchronized_;
        }
        return null;
    }

    protected Color getBackgroundColor() {
        return this.volatile\u00a0do.abstract();
    }

    protected void drawBackground() {
        if (this.volatile\u00a0do != null && this.renderBackground) {
            this.quadRenderStack.begin();
            this.drawOverlay();
            if (this.renderShadow) {
                this.volatile\u00a0short.implements((QuadRenderStack)this.quadRenderStack.glColor(this.volatile\u00a0do.abstract().darker(), 180.0f), this.shadowSize);
            }
            ((QuadRenderStack)this.quadRenderStack.glColor(this.getBackgroundColor())).drawRect(this.volatile\u00a0short.implements(), this.volatile\u00a0short.long(), this.volatile\u00a0short.implements() + this.volatile\u00a0short.switch(), this.volatile\u00a0short.long() + this.volatile\u00a0short.static()).end();
        }
    }

    protected void drawOverlay() {
    }

    protected boolean drawChildren(double d, double d2, float f, boolean bl) {
        for (synchronized synchronized_ : this.children) {
            if (!this.shouldDrawChild(synchronized_)) {
                synchronized_.static().implements((double)Dispatcher\ufe0f.bootstrap("call", 0L, 1), (double)Dispatcher\ufe0f.bootstrap("call", 1L, 1));
                continue;
            }
            this.applyBoundsUpdates(synchronized_);
            if (synchronized_ instanceof ScrollbarWidget) continue;
            if (synchronized_ instanceof transient) {
                ((transient)((Object)synchronized_)).implements(this);
            }
            bl = synchronized_.implements(d, d2, f, bl);
        }
        return bl;
    }

    protected boolean shouldDrawChild(synchronized synchronized_) {
        return true;
    }

    protected void applyBoundsUpdates(synchronized synchronized_) {
        if (synchronized_ instanceof transient) {
            Enum[] enumArray;
            if (synchronized_ instanceof native && (enumArray = ((native)((Object)synchronized_)).float()) != null) {
                Dispatcher\ufe0f.bootstrap("call", 0L, 1, enumArray).forEach(boolean_ -> boolean_.implements(synchronized_, this));
            }
            if (synchronized_ instanceof \u0000nunyaboolean.catch.for.super.enum.this && (enumArray = ((\u0000nunyaboolean.catch.for.super.enum.this)((Object)synchronized_)).break()) != null) {
                Dispatcher\ufe0f.bootstrap("call", 0L, 1, enumArray).forEach(default_ -> default_.implements(synchronized_, this));
            }
        }
    }

    @Override
    public int long(double d, double d2) {
        int n = super.long(d, d2);
        if (n != -1) {
            return n;
        }
        for (int i = this.children.size() - 1; i >= 0; --i) {
            int n2;
            synchronized synchronized_ = this.children.get(i);
            if (!(synchronized_ instanceof boolean) || (n2 = ((boolean)((Object)synchronized_)).long(d, d2)) == -1) continue;
            n = n2;
        }
        if (n == -1 && this.volatile\u00a0short.switch(d, d2)) {
            n = 221185;
        }
        return n;
    }

    @Override
    public void switch(double d, double d2) {
        this.children.stream().filter(synchronized_ -> synchronized_.static().switch(this.mouseX, this.mouseY)).forEach(synchronized_ -> synchronized_.switch(d, d2));
    }

    @Override
    public boolean implements(double d, double d2, int n) {
        super.implements(d, d2, n);
        for (synchronized synchronized_ : this.children) {
            if (!synchronized_.implements(d, d2, n)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean long(double d, double d2, int n) {
        boolean bl = false;
        boolean bl2 = this.volatile\u00a0short.switch(this.border).switch(d, d2);
        for (synchronized synchronized_ : this.children) {
            if (!bl2 && !(synchronized_ instanceof ScrollbarWidget)) continue;
            if (synchronized_ instanceof transient) {
                ((transient)((Object)synchronized_)).implements(this);
            }
            if (!(bl = synchronized_.long(d, d2, n))) continue;
            break;
        }
        return bl || super.long(d, d2, n) || this.static().switch(d, d2);
    }

    @Override
    public boolean long(int n, int n2, int n3) {
        for (synchronized synchronized_ : this.children) {
            if (!synchronized_.long(n, n2, n3)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void switch() {
        this.children.forEach(synchronized::switch);
    }

    @Override
    public void long(int n) {
        this.children.stream().filter(synchronized_ -> synchronized_ instanceof \u0000nunyaboolean.catch.for.super.enum.default).map(synchronized_ -> (\u0000nunyaboolean.catch.for.super.enum.default)((Object)synchronized_)).forEach(default_ -> default_.long(n));
    }

    public void setStencil(boolean bl) {
        this.stencil = bl;
    }

    public void setScissor(boolean bl) {
        this.scissor = bl;
    }

    public void setRenderBackground(boolean bl) {
        this.renderBackground = bl;
    }

    public void setRenderShadow(boolean bl) {
        this.renderShadow = bl;
    }

    public void setTitle(TitleWidget titleWidget) {
        this.title = titleWidget;
    }

    public void setShadowSize(double d) {
        this.shadowSize = d;
    }

    public QuadRenderStack getQuadRenderStack() {
        return this.quadRenderStack;
    }

    @Override
    public List<synchronized> boolean() {
        return this.children;
    }

    public boolean isStencil() {
        return this.stencil;
    }

    public boolean isScissor() {
        return this.scissor;
    }

    public boolean isRenderBackground() {
        return this.renderBackground;
    }

    public boolean isRenderShadow() {
        return this.renderShadow;
    }

    public extends getStencilBuffer() {
        return this.stencilBuffer;
    }

    public TitleWidget getTitle() {
        return this.title;
    }

    public double getShadowSize() {
        return this.shadowSize;
    }
}

