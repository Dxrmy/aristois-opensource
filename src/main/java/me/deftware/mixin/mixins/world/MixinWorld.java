/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_1959
 *  net.minecraft.class_2338
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_310
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_424
 *  net.minecraft.class_437
 *  net.minecraft.class_5321
 *  net.minecraft.class_5562
 *  net.minecraft.class_638
 *  net.minecraft.class_6880
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.world;

import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.block.TileEntity;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.world.Biome;
import me.deftware.client.framework.world.World;
import me.deftware.client.framework.world.block.BlockState;
import me.deftware.client.framework.world.chunk.ChunkAccessor;
import net.minecraft.class_1937;
import net.minecraft.class_1959;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_310;
import net.minecraft.class_3959;
import net.minecraft.class_424;
import net.minecraft.class_437;
import net.minecraft.class_5321;
import net.minecraft.class_5562;
import net.minecraft.class_638;
import net.minecraft.class_6880;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1937.class})
public class MixinWorld
implements World {
    @Unique
    public final HashMap<class_2586, TileEntity> emcTileEntities = new HashMap();
    @Unique
    public final HashMap<Long, class_2586> longTileEntities = new HashMap();
    @Unique
    private static final Biome _biome = new Biome();

    @Inject(method={"addBlockEntityTicker"}, at={@At(value="HEAD")})
    public void addBlockEntityTicker(class_5562 blockEntityTickInvoker, CallbackInfo ci) {
        if (this.longTileEntities.containsKey(blockEntityTickInvoker.method_31705().method_10063())) {
            class_2586 entity = this.longTileEntities.remove(blockEntityTickInvoker.method_31705().method_10063());
            this.emcTileEntities.put(entity, TileEntity.newInstance(entity, blockEntityTickInvoker));
        }
    }

    @Redirect(method={"tickBlockEntities"}, at=@At(value="INVOKE", target="Ljava/util/Iterator;next()Ljava/lang/Object;", opcode=180))
    protected Object tickBlockEntities(Iterator<class_5562> iterator) {
        class_5562 ticker = iterator.next();
        if (ticker.method_31704()) {
            this.emcTileEntities.values().removeIf(e -> e.getTicker().equals((Object)ticker));
        }
        return ticker;
    }

    @Override
    public Stream<TileEntity> getLoadedTileEntities() {
        return this.emcTileEntities.values().stream();
    }

    @Override
    public int _getDifficulty() {
        return ((class_1937)this).method_8407().method_5461();
    }

    @Override
    public long _getWorldTime() {
        return ((class_1937)this).method_8532();
    }

    @Override
    public int _getWorldHeight() {
        return ((class_1937)this).method_31605();
    }

    @Override
    public int _getBlockLightLevel(BlockPosition position) {
        return ((class_1937)this).method_22339((class_2338)position);
    }

    @Override
    public void _disconnect() {
        class_310 mc = class_310.method_1551();
        boolean sp = mc.method_1542();
        ((class_1937)this).method_8525();
        if (sp) {
            mc.method_56134((class_437)new class_424((class_2561)class_2561.method_43471((String)"menu.savingLevel")));
        } else {
            mc.method_56134(null);
        }
    }

    @Override
    public ChunkAccessor getChunk(int x, int z) {
        return (ChunkAccessor)((class_1937)this).method_8497(x, z);
    }

    @Override
    public boolean _hasChunk(int x, int z) {
        return ((class_1937)this).method_8393(x, z);
    }

    @Override
    public int _getDimension() {
        class_5321 key = ((class_1937)this).method_27983();
        if (class_1937.field_25181.equals(key)) {
            return 1;
        }
        if (class_1937.field_25179.equals(key)) {
            return 0;
        }
        if (class_1937.field_25180.equals(key)) {
            return -1;
        }
        return -2;
    }

    @Override
    public BlockState _getBlockState(BlockPosition position) {
        return (BlockState)((class_1937)this).method_8320((class_2338)position);
    }

    @Override
    public <T extends TileEntity> T getTileEntityByReference(class_2586 reference) {
        if (reference != null) {
            return (T)this.emcTileEntities.get(reference);
        }
        return null;
    }

    @Override
    public HashMap<Long, class_2586> getInternalLongToBlockEntity() {
        return this.longTileEntities;
    }

    @Override
    public Biome _getBiome() {
        return _biome.setReference((class_6880<class_1959>)((class_638)this).method_23753(class_310.method_1551().field_1724.method_24515()));
    }

    @Override
    @Unique
    public boolean rayTraceBlocks(Vector3<Double> start, Vector3<Double> end) {
        class_3959 context = new class_3959((class_243)start, (class_243)end, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, class_310.method_1551().method_1560());
        return ((class_1937)this).method_17742(context).method_17783() != class_239.class_240.field_1333;
    }
}

