/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 */
package me.deftware.aristois.menu.widgets;

import \u0000nunyaboolean.catch.for.if.break.this.catch;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import \u0000nunyaboolean.catch.for.super.enum.transient;
import java.awt.Color;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public abstract class ColorSelectionButton
extends ButtonWidget
implements transient.catch {
    public ColorSelectionButton(Message message, interface interface_) {
        super(message, interface_);
    }

    @Override
    protected void drawBackground(double d, double d2, float f) {
        super.drawBackground(d, d2, f);
        double d3 = this.volatile\u00a0do.boolean();
        double d4 = this.volatile\u00a0short.static() - d3 * 2.0;
        catch catch_ = new catch(this.volatile\u00a0short.implements() + this.volatile\u00a0short.switch() - d4 - d3 - 5.0, this.volatile\u00a0short.long() + d3, d4, d4);
        catch_.implements((QuadRenderStack)this.quadRenderStack.glColor(this.getColor()));
        catch_.implements((QuadRenderStack)this.quadRenderStack.glColor(Color.gray, 120.0f), 2.0);
    }

    protected abstract Color getColor();
}

