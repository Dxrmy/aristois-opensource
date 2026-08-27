/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 */
package me.deftware.aristois.menu.widgets;

import \u0000nunyaboolean.catch.for.super.enum.interface;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.message.Message;

public abstract class ModButton
extends ButtonWidget {
    final private AbstractMod mod;

    public ModButton(Message message, interface interface_, AbstractMod abstractMod) {
        super(message, interface_);
        this.mod = abstractMod;
    }

    public AbstractMod getMod() {
        return this.mod;
    }
}

