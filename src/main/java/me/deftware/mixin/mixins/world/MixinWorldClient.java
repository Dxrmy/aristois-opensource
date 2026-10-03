/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.particle.BlockStateParticleEffect
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleTypes
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.world.tick.TickManager
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.world;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.events.EventEntityUpdated;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.mixin.mixins.world.MixinWorld;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.tick.TickManager;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_638.class})
public abstract class MixinWorldClient
extends MixinWorld
implements ClientWorld {
    @Unique
    private final Int2ObjectMap<Entity> entities = new Int2ObjectOpenHashMap();

    @Shadow
    public abstract void method_8406(class_2394 var1, double var2, double var4, double var6, double var8, double var10, double var12);

    @ModifyVariable(method={"randomBlockDisplayTick"}, at=@At(value="TAIL"))
    private class_2338.class_2339 onGetBlockParticle(class_2338.class_2339 pos) {
        boolean barrier = GameMap.INSTANCE.get(GameKeys.FULL_BARRIER_TEXTURE, false);
        boolean light = GameMap.INSTANCE.get(GameKeys.FULL_LIGHT_TEXTURE, false);
        if (barrier || light) {
            class_2680 blockState = ((class_1937)this).method_8320((class_2338)pos);
            class_2248 block = blockState.method_26204();
            class_2388 effect = new class_2388(class_2398.field_35434, blockState);
            if (barrier && block == class_2246.field_10499 || light && block == class_2246.field_31037) {
                this.method_8406((class_2394)effect, (double)pos.method_10263() + 0.5, (double)pos.method_10264() + 0.5, (double)pos.method_10260() + 0.5, 0.0, 0.0, 0.0);
            }
        }
        return pos;
    }

    @Inject(method={"addEntity"}, at={@At(value="TAIL")})
    private void addEntityPrivate(class_1297 entity, CallbackInfo ci) {
        Entity e = Entity.newInstance(entity);
        this.entities.put(e.getEntityId(), (Object)e);
        new EventEntityUpdated(EventEntityUpdated.Change.Added, e).broadcast();
    }

    @Inject(method={"removeEntity"}, at={@At(value="TAIL")})
    public void removeEntity(int entityId, class_1297.class_5529 reason, CallbackInfo ci) {
        new EventEntityUpdated(EventEntityUpdated.Change.Removed, (Entity)this.entities.remove(entityId)).broadcast();
    }

    @Override
    public Stream<Entity> getLoadedEntities() {
        return this.entities.values().stream();
    }

    @Override
    public Entity _getEntityById(int id) {
        return (Entity)this.entities.get(id);
    }

    @Override
    public void _addEntity(int id, Entity entity) {
        ((class_638)this).method_53875(entity.getMinecraftEntity());
    }

    @Override
    public void _removeEntity(int id) {
        ((class_638)this).method_2945(id, class_1297.class_5529.field_26999);
    }

    @Override
    @Nullable
    public <T extends Entity> T getEntityByReference(class_1297 reference) {
        if (reference != null) {
            return (T)((Entity)this.entities.get(reference.method_5628()));
        }
        return null;
    }

    @Override
    public float getTickRate() {
        class_8921 manager = ((class_638)this).method_54719();
        if (manager.method_54754()) {
            return 0.0f;
        }
        return manager.method_54748();
    }
}

