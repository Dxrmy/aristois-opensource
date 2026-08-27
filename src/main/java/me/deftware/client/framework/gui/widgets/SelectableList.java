/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_350
 *  net.minecraft.class_350$class_351
 *  net.minecraft.class_5481
 *  net.minecraft.class_6382
 */
package me.deftware.client.framework.gui.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import me.deftware.client.framework.gui.widgets.GenericComponent;
import me.deftware.client.framework.gui.widgets.properties.Tooltipable;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_350;
import net.minecraft.class_5481;
import net.minecraft.class_6382;

public class SelectableList<T extends ListItem>
extends class_350<ItemEntry>
implements Tooltipable,
GenericComponent {
    private final List<T> delegate;
    private boolean extended = false;
    private final List<class_5481> tooltipComponents = new ArrayList<class_5481>();
    private final Map<T, ItemEntry> map = new HashMap<T, ItemEntry>();

    public SelectableList(List<T> delegate, int width, int height, int top, int bottom, int itemHeight) {
        super(class_310.method_1551(), width, bottom - top, top, itemHeight);
        this.delegate = delegate;
    }

    public void reset() {
        this.setScrollbarPosition(0);
        this.deselect();
    }

    public List<T> getDelegate() {
        return this.delegate;
    }

    public void deselect() {
        this.method_25313(null);
    }

    public void setSelectedItem(T item) {
        this.method_25313(this.map.get(item));
        this.onSelectionUpdate(item);
    }

    public T getSelectedItem() {
        if (this.method_25334() != null) {
            return ((ItemEntry)this.method_25334()).item;
        }
        return null;
    }

    public T getHoveredItem(int mouseX, int mouseY) {
        ItemEntry entry = (ItemEntry)this.method_25308(mouseX, mouseY);
        if (entry != null) {
            return entry.item;
        }
        return null;
    }

    public void setScrollbarPosition(int y) {
        this.method_44382(y);
    }

    @Override
    public boolean isMouseOverComponent(int mouseX, int mouseY) {
        return this.getHoveredItem(mouseX, mouseY) != null;
    }

    @Override
    public List<class_5481> getTooltipComponents(int mouseX, int mouseY) {
        Message[] tooltip;
        ItemEntry entry = (ItemEntry)this.method_25308(mouseX, mouseY);
        if (entry != null && (tooltip = entry.item.getTooltip()) != null && tooltip.length > 0) {
            this._setTooltip(this.tooltipComponents, tooltip);
            return this.tooltipComponents;
        }
        return null;
    }

    public int method_25322() {
        if (this.extended) {
            return this.field_22758 - 12;
        }
        return super.method_25322();
    }

    public int method_65507() {
        if (this.extended) {
            return this.field_22758 - 6;
        }
        return super.method_65507();
    }

    protected void onSelectionUpdate(T item) {
    }

    protected void onDrawItem(GLX context, T item, int index, int x, int y, int entryWidth, int entryHeight, int mouseX, int mouseY, float tickDelta) {
    }

    public void method_25311(class_332 matrixStack, int mouseX, int mouseY, float tickDelta) {
        if (this.delegate.size() != this.map.size()) {
            this.rebuild();
        }
        super.method_25311(matrixStack, mouseX, mouseY, tickDelta);
    }

    private void rebuild() {
        this.deselect();
        this.map.clear();
        this.method_25396().clear();
        for (ListItem item : this.delegate) {
            ItemEntry entry = new ItemEntry(this, item);
            this.map.put(item, entry);
            this.method_25396().add(entry);
        }
    }

    protected void method_47399(class_6382 builder) {
    }

    @Generated
    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    protected static class ItemEntry
    extends class_350.class_351<ItemEntry> {
        private final T item;
        final /* synthetic */ SelectableList this$0;

        public ItemEntry(T item) {
            this.this$0 = this$0;
            this.item = item;
        }

        public void method_25343(class_332 context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            GLX glx = GLX.of(context);
            this.item.render(glx, index, x += 8, y, entryWidth, entryHeight, mouseX, mouseY, tickDelta);
            this.this$0.onDrawItem(glx, this.item, index, x, y, entryWidth, entryHeight, mouseX, mouseY, tickDelta);
        }

        public boolean method_25402(double mouseX, double mouseY, int button) {
            if (this.item.onMouseClicked(mouseX, mouseY, button)) {
                this.this$0.method_25313(this);
                this.this$0.onSelectionUpdate(this.item);
                return true;
            }
            return false;
        }
    }

    public static interface ListItem {
        public void render(GLX var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9);

        default public boolean onMouseClicked(double mouseX, double mouseY, int button) {
            return true;
        }

        default public Message[] getTooltip() {
            return null;
        }
    }
}

