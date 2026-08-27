/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2626
 *  net.minecraft.class_2637
 *  net.minecraft.class_2663
 *  net.minecraft.class_2664
 *  net.minecraft.class_2672
 *  net.minecraft.class_310
 *  net.minecraft.class_4076
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 *  net.minecraft.class_7469
 *  net.minecraft.class_7608
 *  net.minecraft.class_7610$class_7612
 *  net.minecraft.class_7637
 *  net.minecraft.class_7637$class_7816
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.network;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import me.deftware.client.framework.event.events.EventAnimation;
import me.deftware.client.framework.event.events.EventChunk;
import me.deftware.client.framework.event.events.EventChunkDataReceive;
import me.deftware.client.framework.event.events.EventKnockback;
import me.deftware.client.framework.network.NetworkHandler;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.player.PlayerEntry;
import me.deftware.mixin.mixins.network.ChunkDeltaAccessor;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2663;
import net.minecraft.class_2664;
import net.minecraft.class_2672;
import net.minecraft.class_310;
import net.minecraft.class_4076;
import net.minecraft.class_634;
import net.minecraft.class_746;
import net.minecraft.class_7469;
import net.minecraft.class_7608;
import net.minecraft.class_7610;
import net.minecraft.class_7637;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_634.class})
public abstract class MixinNetHandlerPlayClient
implements NetworkHandler {
    @Shadow
    private class_7637 field_39858;
    @Shadow
    private class_7610.class_7612 field_39808;
    @Unique
    private final EventAnimation eventAnimation = new EventAnimation();

    @Override
    public List<PlayerEntry> _getPlayerList() {
        return ((class_634)this).method_2880().stream().map(PlayerEntry.class::cast).collect(Collectors.toList());
    }

    @Inject(method={"onEntityStatus"}, at={@At(value="HEAD")}, cancellable=true)
    public void onEntityStatus(class_2663 packet, CallbackInfo ci) {
        if (packet.method_11470() == 35) {
            this.eventAnimation.create(EventAnimation.AnimationType.Totem);
            this.eventAnimation.broadcast();
            if (this.eventAnimation.isCanceled()) {
                ci.cancel();
            }
        }
    }

    @Inject(method={"onExplosion"}, at={@At(value="INVOKE", target="Ljava/util/Optional;ifPresent(Ljava/util/function/Consumer;)V")}, cancellable=true)
    private void onExplosion(class_2664 packet, CallbackInfo ci) {
        Optional knockback = packet.comp_2884();
        if (knockback.isPresent()) {
            class_243 velocity = (class_243)knockback.get();
            EventKnockback event = (EventKnockback)new EventKnockback(velocity.field_1352, velocity.field_1351, velocity.field_1350).broadcast();
            if (!event.isCanceled()) {
                class_746 player = class_310.method_1551().field_1724;
                player.method_18799(player.method_18798().method_1031(event.getX(), event.getY(), event.getZ()));
            }
            ci.cancel();
        }
    }

    @Inject(method={"onChunkData"}, at={@At(value="HEAD")}, cancellable=true)
    public void onReceiveChunkData(class_2672 packet, CallbackInfo ci) {
        EventChunkDataReceive event = (EventChunkDataReceive)new EventChunkDataReceive(packet).broadcast();
        if (event.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"onBlockUpdate"}, at={@At(value="HEAD")})
    private void onBlockUpdate(class_2626 packet, CallbackInfo ci) {
        class_2338 pos = packet.method_11309();
        int chunkX = pos.method_10263() >> 4;
        int chunkZ = pos.method_10260() >> 4;
        int chunkY = pos.method_10264() >> 4;
        int x = pos.method_10263() - (chunkX << 4);
        int z = pos.method_10260() - (chunkZ << 4);
        int y = pos.method_10264() & 0xF;
        short[] positions = new short[]{(short)(x << 8 | z << 4 | y)};
        Block[] blocks = new Block[]{(Block)packet.method_11308().method_26204()};
        new EventChunk.EventDeltaChunk(chunkX, chunkY, chunkZ, positions, blocks).broadcast();
    }

    @Inject(method={"onChunkDeltaUpdate"}, at={@At(value="HEAD")})
    private void onChunkDeltaPacket(class_2637 packet, CallbackInfo ci) {
        ChunkDeltaAccessor accessor = (ChunkDeltaAccessor)packet;
        Block[] blocks = (Block[])Arrays.stream(accessor.getBlockStates()).map(s -> (Block)s.method_26204()).toArray(Block[]::new);
        class_4076 pos = accessor.getSectionPos();
        new EventChunk.EventDeltaChunk(pos.method_10263(), pos.method_10264(), pos.method_10260(), accessor.getPositions(), blocks).broadcast();
    }

    @Override
    @Unique
    public class_7637.class_7816 collect() {
        return this.field_39858.method_46266();
    }

    @Override
    @Unique
    public class_7469 pack(class_7608 body) {
        return this.field_39808.pack(body);
    }
}

