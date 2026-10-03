/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.screen.slot.SlotActionType
 */
package me.deftware.client.framework.entity.types.main;

import net.minecraft.screen.slot.SlotActionType;

public enum WindowClickAction {
    THROW(class_1713.field_7795),
    QUICK_MOVE(class_1713.field_7794),
    PICKUP(class_1713.field_7790);

    private final class_1713 actionType;

    private WindowClickAction(class_1713 actionType) {
        this.actionType = actionType;
    }

    public class_1713 getMinecraftActionType() {
        return this.actionType;
    }
}

