/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.gui.screens;

import me.deftware.client.framework.gui.screens.MinecraftScreen;

public interface SignEditScreen
extends MinecraftScreen {
    public int _getCurrentLine();

    public String _getLine(int var1);

    public void _setLine(int var1, String var2);

    public void _save();
}

