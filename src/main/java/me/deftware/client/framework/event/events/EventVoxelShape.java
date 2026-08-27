/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_238
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.math.BoundingBox;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.class_238;
import net.minecraft.class_259;
import net.minecraft.class_265;

public class EventVoxelShape
extends Event {
    public class_265 shape;
    public boolean modified = false;
    public Block block;

    public EventVoxelShape(class_265 shape, Block block) {
        this.shape = shape;
        this.block = block;
    }

    public BoundingBox getBoundingBox() {
        return (BoundingBox)this.shape.method_1107();
    }

    public void setFullCube() {
        this.shape = class_259.method_1077();
    }

    public void setEmpty() {
        this.shape = class_259.method_1073();
    }

    public void setShape(BoundingBox bb) {
        this.modified = true;
        this.shape = class_259.method_1078((class_238)((class_238)bb));
    }
}

