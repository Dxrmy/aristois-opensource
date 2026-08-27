/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1747
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.item;

import me.deftware.client.framework.item.items.BlockItem;
import me.deftware.client.framework.world.block.Block;
import me.deftware.mixin.mixins.item.MixinItem;
import net.minecraft.class_1747;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_1747.class})
public class MixinItemBlock
extends MixinItem
implements BlockItem {
    @Override
    @Unique
    public Block getBlock() {
        return (Block)((class_1747)this).method_7711();
    }
}

