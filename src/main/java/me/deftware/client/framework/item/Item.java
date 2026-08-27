/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.AtomicDouble
 *  net.minecraft.class_1322
 *  net.minecraft.class_1792
 *  net.minecraft.class_2960
 *  net.minecraft.class_9285
 *  net.minecraft.class_9285$class_9287
 *  net.minecraft.class_9334
 */
package me.deftware.client.framework.item;

import com.google.common.util.concurrent.AtomicDouble;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList;
import me.deftware.client.framework.item.Itemizable;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.ItemRendering;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.class_1322;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import net.minecraft.class_9285;
import net.minecraft.class_9334;

public interface Item
extends Itemizable,
SelectableList.ListItem {
    public int getID();

    public Message getName();

    public boolean isFood();

    public int getHunger();

    public float getSaturation();

    @Override
    default public void render(GLX context, int index, int x, int y, int entryWidth, int entryHeight, int mouseX, int mouseY, float tickDelta) {
        ItemRendering.getInstance().drawItem(context, x, y + 5, this);
        FontRenderer.drawString(context, this.getName(), x + 28, y + (entryHeight / 2 - FontRenderer.getFontHeight() / 2) - 3, 0xFFFFFF);
    }

    public static void modifiers(Item item, Predicate<class_2960> predicate, Consumer<Double> consumer) {
        class_9285 component = (class_9285)((class_1792)item).method_57347().method_57829(class_9334.field_49636);
        if (component != null) {
            List modifiers = component.comp_2393();
            for (class_9285.class_9287 entry : modifiers) {
                class_1322 modifier = entry.comp_2396();
                if (!predicate.test(modifier.comp_2447())) continue;
                consumer.accept(modifier.comp_2449());
            }
        }
    }

    public static float damage(Item item) {
        AtomicDouble sum = new AtomicDouble();
        Item.modifiers(item, id -> id.equals((Object)class_1792.field_8006), arg_0 -> ((AtomicDouble)sum).addAndGet(arg_0));
        return (float)sum.get();
    }
}

