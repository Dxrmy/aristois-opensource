/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 */
package me.deftware.aristois.menu.widgets;

import \u0000nunyaboolean.catch.for.finally.enum;
import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;

public abstract class EnumWidget
extends ButtonWidget {
    protected final enum<?> boxedEnum;

    public EnumWidget(enum<?> enum_, interface interface_) {
        this(0.0, 0.0, 0.0, enum_, interface_);
    }

    public EnumWidget(double d, double d2, double d3, enum<?> enum_, interface interface_) {
        super(d, d2, d3, (Message)Dispatcher\ufe0f.bootstrap("call", 0L, 1, enum_.static()), interface_);
        this.boxedEnum = enum_;
    }

    @Override
    protected void onClick(int n) {
        if (n == 0) {
            this.boxedEnum.switch();
            this.implements();
            this.apply(this.boxedEnum.static(), this.boxedEnum.finally());
        }
    }

    protected abstract void apply(String var1, int var2);

    public enum<?> getBoxedEnum() {
        return this.boxedEnum;
    }
}

