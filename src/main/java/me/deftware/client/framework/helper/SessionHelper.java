/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package me.deftware.client.framework.helper;

import java.util.UUID;
import net.minecraft.class_310;

public class SessionHelper {
    public static String getSessionId() {
        return class_310.method_1551().method_1548().method_1675();
    }

    public static String getPlayerUUID() {
        UUID uuid = class_310.method_1551().method_1548().method_44717();
        if (uuid != null) {
            return uuid.toString();
        }
        return "0";
    }

    public static String getPlayerUsername() {
        return class_310.method_1551().method_1548().method_1676();
    }

    public static String getAccessToken() {
        return class_310.method_1551().method_1548().method_1674();
    }
}

