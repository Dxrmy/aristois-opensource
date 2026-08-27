/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2189
 *  net.minecraft.class_2199
 *  net.minecraft.class_2237
 *  net.minecraft.class_2244
 *  net.minecraft.class_2272
 *  net.minecraft.class_2281
 *  net.minecraft.class_2302
 *  net.minecraft.class_2304
 *  net.minecraft.class_2312
 *  net.minecraft.class_2323
 *  net.minecraft.class_2328
 *  net.minecraft.class_2336
 *  net.minecraft.class_2349
 *  net.minecraft.class_2354
 *  net.minecraft.class_2362
 *  net.minecraft.class_2401
 *  net.minecraft.class_2404
 *  net.minecraft.class_2406
 *  net.minecraft.class_2428
 *  net.minecraft.class_2480
 *  net.minecraft.class_2533
 *  net.minecraft.class_3708
 *  net.minecraft.class_3711
 *  net.minecraft.class_3713
 *  net.minecraft.class_3718
 *  net.minecraft.class_3748
 *  net.minecraft.class_3962
 *  net.minecraft.class_4969
 *  net.minecraft.class_5546
 */
package me.deftware.client.framework.world.block;

import java.util.function.Predicate;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.class_2189;
import net.minecraft.class_2199;
import net.minecraft.class_2237;
import net.minecraft.class_2244;
import net.minecraft.class_2272;
import net.minecraft.class_2281;
import net.minecraft.class_2302;
import net.minecraft.class_2304;
import net.minecraft.class_2312;
import net.minecraft.class_2323;
import net.minecraft.class_2328;
import net.minecraft.class_2336;
import net.minecraft.class_2349;
import net.minecraft.class_2354;
import net.minecraft.class_2362;
import net.minecraft.class_2401;
import net.minecraft.class_2404;
import net.minecraft.class_2406;
import net.minecraft.class_2428;
import net.minecraft.class_2480;
import net.minecraft.class_2533;
import net.minecraft.class_3708;
import net.minecraft.class_3711;
import net.minecraft.class_3713;
import net.minecraft.class_3718;
import net.minecraft.class_3748;
import net.minecraft.class_3962;
import net.minecraft.class_4969;
import net.minecraft.class_5546;

public enum BlockTypes {
    AIR(block -> block instanceof class_2189),
    FLUID(block -> block instanceof class_2404),
    CROPS(block -> block instanceof class_2302),
    ShulkerBox(block -> block instanceof class_2480),
    Storage(block -> block instanceof class_2281 || block instanceof class_3708 || block instanceof class_2336),
    Interactable(block -> block instanceof class_2237 || block instanceof class_2199 || block instanceof class_2244 || block instanceof class_2272 || block instanceof class_3711 || block instanceof class_5546 || block instanceof class_2312 || block instanceof class_3962 || block instanceof class_2304 || block instanceof class_2323 || block instanceof class_2328 || block instanceof class_2354 || block instanceof class_2349 || block instanceof class_2362 || block instanceof class_3713 || block instanceof class_3748 || block instanceof class_2401 || block instanceof class_2406 || block instanceof class_2428 || block instanceof class_4969 || block instanceof class_3718 || block instanceof class_2533);

    private final Predicate<Block> predicate;

    private BlockTypes(Predicate<Block> predicate) {
        this.predicate = predicate;
    }

    public boolean is(Block block) {
        return this.predicate.test(block);
    }
}

