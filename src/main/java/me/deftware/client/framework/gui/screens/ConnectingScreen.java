/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_412
 *  net.minecraft.class_437
 *  net.minecraft.class_500
 *  net.minecraft.class_639
 *  net.minecraft.class_642
 */
package me.deftware.client.framework.gui.screens;

import me.deftware.client.framework.minecraft.ServerDetails;
import net.minecraft.class_310;
import net.minecraft.class_412;
import net.minecraft.class_437;
import net.minecraft.class_500;
import net.minecraft.class_639;
import net.minecraft.class_642;

public interface ConnectingScreen {
    public static void _connect(ServerDetails server) {
        if (server != null) {
            class_412.method_36877((class_437)new class_500(class_310.method_1551().field_1755), (class_310)class_310.method_1551(), (class_639)class_639.method_2950((String)server._getAddress()), (class_642)((class_642)server), (boolean)false, null);
        }
    }
}

