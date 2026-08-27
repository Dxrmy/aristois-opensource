/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_7469
 *  net.minecraft.class_7608
 *  net.minecraft.class_7637$class_7816
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package me.deftware.client.framework.network;

import java.util.List;
import me.deftware.client.framework.world.player.PlayerEntry;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_7469;
import net.minecraft.class_7608;
import net.minecraft.class_7637;
import org.jetbrains.annotations.ApiStatus;

public interface NetworkHandler {
    public static NetworkHandler getNetworkHandler() {
        class_634 handler = class_310.method_1551().method_1562();
        if (handler == null) {
            return null;
        }
        return (NetworkHandler)handler;
    }

    public List<PlayerEntry> _getPlayerList();

    @ApiStatus.Internal
    public class_7637.class_7816 collect();

    @ApiStatus.Internal
    public class_7469 pack(class_7608 var1);
}

