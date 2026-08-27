/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 *  me.deftware.client.framework.render.batching.font.FontRenderStack
 */
package me.deftware.aristois.menu.view;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.if.break.continue;
import \u0000nunyaboolean.catch.for.if.break.synchronized;
import \u0000nunyaboolean.catch.for.if.break.this.catch;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class RectTooltip
extends continue
implements interface.catch {
    private interface theme;
    final private FontRenderStack fontRenderStack;
    final private QuadRenderStack quadRenderStack = new QuadRenderStack();

    public RectTooltip(synchronized synchronized_, interface interface_, Message ... messageArray) {
        this(synchronized_.static(), interface_, messageArray);
    }

    public RectTooltip(catch catch_, interface interface_, Message ... messageArray) {
        super(catch_, messageArray);
        this.theme = interface_;
        this.fontRenderStack = interface_.implements();
        this.implements();
    }

    public RectTooltip withScale(boolean bl) {
        this.long(bl);
        return this;
    }

    @Override
    public void long(boolean bl) {
        super.long(bl);
        this.quadRenderStack.setScaled(bl);
    }

    @Override
    protected double implements(double d, double d2) {
        d = d + this.enum\u00a0double.switch() + this.enum\u00a0enum + d2 * 2.0 > (double)Dispatcher\ufe0f.bootstrap("call", 0L, 1) ? (d -= this.enum\u00a0double.switch() + d2 + this.enum\u00a0enum) : (d += d2 * 2.0 + this.enum\u00a0enum);
        return d;
    }

    @Override
    protected double for() {
        if (this.fontRenderStack == null) {
            return super.for();
        }
        return this.fontRenderStack.getFontHeight();
    }

    @Override
    protected int long(Message message) {
        if (this.fontRenderStack == null) {
            return super.long(message);
        }
        return this.fontRenderStack.getStringWidth(message);
    }

    @Override
    protected void long(Message message, int n, int n2) {
        this.fontRenderStack.begin().drawString(n, n2, message).end();
    }

    @Override
    protected void long(double d, double d2, double d3, double d4) {
        double d5 = 3.0;
        catch catch_ = new catch(d - d5, d2, d3 - d + d5 * 2.0, d4 - d2);
        this.quadRenderStack.begin();
        double d6 = 1.5;
        catch_.implements((QuadRenderStack)this.quadRenderStack.glColor(this.theme.abstract().darker(), 180.0f), d6);
        catch_.implements((QuadRenderStack)this.quadRenderStack.glColor(this.theme.byte()));
        this.quadRenderStack.end();
    }

    @Override
    public interface if() {
        return this.theme;
    }

    public void setTheme(interface interface_) {
        this.theme = interface_;
    }
}

