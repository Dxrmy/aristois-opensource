/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap
 */
package me.deftware.client.framework.global.types;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import me.deftware.client.framework.global.types.IProperty;

public class PropertyManager<T extends IProperty> {
    private final Int2ObjectArrayMap<T> properties = new Int2ObjectArrayMap();
    private boolean active = false;

    public PropertyManager<T> register(T property) {
        this.properties.put(property.getId(), property);
        return this;
    }

    public void clear() {
        this.properties.clear();
    }

    public int size() {
        return this.properties.size();
    }

    public T get(int id) {
        return (T)((IProperty)this.properties.get(id));
    }

    public T remove(int id) {
        return (T)((IProperty)this.properties.remove(id));
    }

    public boolean contains(int propertyId) {
        return this.properties.containsKey(propertyId);
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

