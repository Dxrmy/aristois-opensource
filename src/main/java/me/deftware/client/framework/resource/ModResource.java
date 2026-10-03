/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.resource.Resource
 */
package me.deftware.client.framework.resource;

import java.io.InputStream;
import net.minecraft.util.Identifier;
import net.minecraft.resource.Resource;

public class ModResource
extends class_3298 {
    private final InputStream stream;
    private final class_2960 id;

    public ModResource(InputStream stream, class_2960 id) {
        super(null, () -> stream);
        this.id = id;
        this.stream = stream;
    }

    public InputStream method_14482() {
        return this.stream;
    }

    public String method_14480() {
        return this.id.toString();
    }
}

