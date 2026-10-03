/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.chunk.WorldChunk
 *  net.minecraft.client.world.ClientChunkManager$ClientChunkMap
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.world;

import me.deftware.client.framework.event.events.EventChunk;
import me.deftware.client.framework.world.chunk.ChunkAccessor;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.client.world.ClientChunkManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_631.class_3681.class})
public class MixinChunkManager {
    @Inject(method={"set"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/world/ClientChunkManager$ClientChunkMap;loadChunkSections(Lnet/minecraft/world/chunk/WorldChunk;)V", shift=At.Shift.AFTER)})
    private void onChunkSet$Load(int index, class_2818 chunk, CallbackInfo ci) {
        new EventChunk((ChunkAccessor)chunk, EventChunk.Action.LOAD, chunk.method_12004().field_9181, chunk.method_12004().field_9180).broadcast();
    }

    @Inject(method={"unloadChunk"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/world/ClientChunkManager$ClientChunkMap;unloadChunkSections(Lnet/minecraft/world/chunk/WorldChunk;)V", shift=At.Shift.AFTER)})
    private void onChunkUnload(int index, class_2818 chunk, CallbackInfo ci) {
        new EventChunk(null, EventChunk.Action.UNLOAD, chunk.method_12004().field_9181, chunk.method_12004().field_9180).broadcast();
    }
}

