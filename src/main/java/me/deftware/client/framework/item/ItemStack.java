/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.registry.DynamicRegistryManager
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 */
package me.deftware.client.framework.item;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import me.deftware.client.framework.entity.effect.AppliedEffect;
import me.deftware.client.framework.item.Enchantment;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.nbt.NbtCompound;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryWrapper;

public interface ItemStack {
    public static final ItemStack EMPTY = (ItemStack)class_1799.field_8037;

    public int getCount();

    public int getMaxCount();

    public void setCount(int var1);

    public Item getItem();

    public void effects(Consumer<AppliedEffect> var1);

    public void enchantments(BiConsumer<Integer, Enchantment> var1);

    public void enchant(Enchantment var1, int var2);

    public Message getName();

    public void setName(Message var1);

    public Rarity getRarity();

    public int getDamage();

    public int getMaxDamage();

    public boolean isDamaged();

    public boolean isDamageable();

    public float getMiningSpeed(BlockState var1);

    public boolean isEmpty();

    public boolean isItemEqual(ItemStack var1);

    public static ItemStack of(Block block, int count) {
        return ItemStack.of(block.getItem(), count);
    }

    public static ItemStack of(Item item, int count) {
        return (ItemStack)new class_1799((class_1935)((class_1792)item), count);
    }

    public static ItemStack of(NbtCompound compound) {
        class_5455 registry = class_310.method_1551().field_1724.method_56673();
        return (ItemStack)class_1799.method_57359((class_7225.class_7874)registry, (class_2487)((class_2487)compound));
    }

    public static enum Rarity {
        Common,
        Uncommon,
        Rare,
        Epic;

    }
}

