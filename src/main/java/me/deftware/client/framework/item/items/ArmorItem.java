/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.item.items;

import me.deftware.client.framework.item.Item;

public interface ArmorItem
extends Item {
    public int getDamageReduceAmount();

    public float getToughness();

    public int getTypeOrdinal();
}

