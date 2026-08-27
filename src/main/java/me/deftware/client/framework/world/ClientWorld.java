/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  org.jetbrains.annotations.ApiStatus$Internal
 *  org.jetbrains.annotations.Nullable
 */
package me.deftware.client.framework.world;

import java.util.stream.Stream;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.World;
import net.minecraft.class_1297;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

public interface ClientWorld
extends World {
    @Nullable
    public static ClientWorld getClientWorld() {
        return Minecraft.getMinecraftGame().getClientWorld();
    }

    public float getTickRate();

    public Stream<Entity> getLoadedEntities();

    public Entity _getEntityById(int var1);

    public void _addEntity(int var1, Entity var2);

    public void _removeEntity(int var1);

    @Nullable
    @ApiStatus.Internal
    public <T extends Entity> T getEntityByReference(class_1297 var1);
}

