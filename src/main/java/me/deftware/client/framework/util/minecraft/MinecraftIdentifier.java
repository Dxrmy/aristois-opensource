/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 */
package me.deftware.client.framework.util.minecraft;

import net.minecraft.util.Identifier;

public class MinecraftIdentifier
extends class_2960 {
    public MinecraftIdentifier(class_2960 identifier) {
        super(identifier.method_12836(), identifier.method_12832());
    }

    public MinecraftIdentifier(String id) {
        super("minecraft", id);
    }

    public MinecraftIdentifier(String namespace, String path) {
        super(namespace, path);
    }
}

