/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.gui.widgets;

import me.deftware.client.framework.gui.widgets.GenericComponent;

public interface Component
extends GenericComponent {
    public int getPositionX();

    public int getPositionY();

    public int getComponentWidth();

    public int getComponentHeight();

    public boolean isActive();

    public void setPositionX(int var1);

    public void setPositionY(int var1);

    public void setComponentWidth(int var1);

    public void setComponentHeight(int var1);

    public void setActive(boolean var1);

    default public void setPosition(int x, int y) {
        this.setPositionX(x);
        this.setPositionY(y);
    }

    default public void setSize(int width, int height) {
        this.setComponentWidth(width);
        this.setComponentHeight(height);
    }
}

