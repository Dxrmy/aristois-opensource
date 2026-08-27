/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_3298
 */
package me.deftware.client.framework.resource;

import java.io.InputStream;
import net.minecraft.class_2960;
import net.minecraft.class_3298;

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

