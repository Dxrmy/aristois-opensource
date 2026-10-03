/*
 * Aristois Community Edition — clean-room reimplementation.
 * SPDX-License-Identifier: MIT
 */
package org.aristois.client.module.modules;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.minecraft.Minecraft;
import org.aristois.client.module.Category;
import org.aristois.client.module.Module;

import org.lwjgl.glfw.GLFW;

/** One-shot module: prints the current position to chat. */
public final class CoordinatesModule extends Module {

    public CoordinatesModule() {
        super("Coordinates", "Prints your position to chat", Category.MISC);
        setKeyBind(GLFW.GLFW_KEY_J);
    }

    @Override
    protected void onEnable() {
        MainEntityPlayer player = Minecraft.getMinecraftGame()._getPlayer();
        if (player != null) {
            player.sendMessage(String.format("XYZ: %.2f / %.2f / %.2f",
                    player.getPosX(), player.getPosY(), player.getPosZ()));
        }
        // One-shot modules switch themselves back off.
        setEnabled(false);
    }
}
