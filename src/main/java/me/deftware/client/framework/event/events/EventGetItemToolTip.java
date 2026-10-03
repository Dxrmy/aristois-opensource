/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 */
package me.deftware.client.framework.event.events;

import java.util.List;
import java.util.function.Function;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.message.Message;
import net.minecraft.text.Text;

public class EventGetItemToolTip
extends Event {
    private final List<class_2561> list;
    private final Item item;
    private final boolean advanced;

    public EventGetItemToolTip(List<class_2561> list, Item item, boolean advanced) {
        this.list = list;
        this.item = item;
        this.advanced = advanced;
    }

    public void remove(Function<Message, Boolean> visitor) {
        this.list.removeIf(text -> (Boolean)visitor.apply((Message)text));
    }

    public List<class_2561> getList() {
        return this.list;
    }

    public Item getItem() {
        return this.item;
    }

    public boolean isAdvanced() {
        return this.advanced;
    }
}

