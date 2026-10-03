/*
 * Aristois Community Edition — clean-room reimplementation.
 * SPDX-License-Identifier: MIT
 */
package org.aristois.client.module.modules;

import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;
import org.aristois.client.module.Category;
import org.aristois.client.module.Module;

/** Removes the right-click cooldown. */
public final class FastUseModule extends Module {

    public FastUseModule() {
        super("FastUse", "Removes the item use cooldown", Category.PLAYER);
    }

    @EventHandler
    public void onUpdate(EventUpdate event) {
        Minecraft.getMinecraftGame().setRightClickDelayTimer(0);
    }
}
