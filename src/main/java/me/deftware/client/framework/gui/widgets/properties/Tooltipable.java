/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_5481
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package me.deftware.client.framework.gui.widgets.properties;

import java.util.List;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_5481;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public interface Tooltipable {
    default public void _setTooltip(List<class_5481> list, Message ... tooltip) {
        list.clear();
        list.addAll(MinecraftScreen.getTooltipList(tooltip));
    }

    default public void _setTooltip(Message ... tooltip) {
        this._setTooltip(this.getTooltipComponents(0, 0), tooltip);
    }

    @ApiStatus.Internal
    public List<class_5481> getTooltipComponents(int var1, int var2);

    public boolean isMouseOverComponent(int var1, int var2);
}

