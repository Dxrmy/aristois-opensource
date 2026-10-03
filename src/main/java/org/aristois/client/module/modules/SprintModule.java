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

/** Keeps the local player sprinting. */
public final class SprintModule extends Module {

    public SprintModule() {
        super("Sprint", "Forces the player to keep sprinting", Category.MOVEMENT);
    }

    @EventHandler
    public void onUpdate(EventUpdate event) {
        if (Minecraft.getMinecraftGame()._getPlayer() == null) {
            return;
        }
        Minecraft.getMinecraftGame()._getPlayer().getMinecraftEntity().setSprinting(true);
    }
}
