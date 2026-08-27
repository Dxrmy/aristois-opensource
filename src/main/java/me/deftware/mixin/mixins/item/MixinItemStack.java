/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2IntMap$Entry
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792$class_9635
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1844
 *  net.minecraft.class_1887
 *  net.minecraft.class_1890
 *  net.minecraft.class_2561
 *  net.minecraft.class_2680
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 *  net.minecraft.class_9304
 *  net.minecraft.class_9304$class_9305
 *  net.minecraft.class_9334
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.item;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import me.deftware.client.framework.entity.effect.AppliedEffect;
import me.deftware.client.framework.event.events.EventGetItemToolTip;
import me.deftware.client.framework.item.Enchantment;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.EnchantmentRegistry;
import me.deftware.client.framework.world.block.BlockState;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1844;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1799.class})
public class MixinItemStack
implements ItemStack {
    @Unique
    private int enchant$level;
    @Unique
    private class_6880<class_1887> enchant$type;

    @Override
    @Unique
    public int getCount() {
        return ((class_1799)this).method_7947();
    }

    @Override
    @Unique
    public int getMaxCount() {
        return ((class_1799)this).method_7914();
    }

    @Override
    @Unique
    public void setCount(int count) {
        ((class_1799)this).method_7939(count);
    }

    @Override
    @Unique
    public Item getItem() {
        return (Item)((class_1799)this).method_7909();
    }

    @Override
    @Unique
    public void effects(Consumer<AppliedEffect> consumer) {
        ((class_1844)((class_1799)this).method_57825(class_9334.field_49651, (Object)class_1844.field_49274)).method_57397().forEach(effect -> consumer.accept((AppliedEffect)effect));
    }

    @Override
    @Unique
    public void enchantments(BiConsumer<Integer, Enchantment> consumer) {
        class_9304 enchantments = class_1890.method_57532((class_1799)((class_1799)this));
        for (Object2IntMap.Entry entry : enchantments.method_57539()) {
            try {
                Optional key = ((class_6880)entry.getKey()).method_40230();
                if (!key.isPresent()) continue;
                consumer.accept(entry.getIntValue(), EnchantmentRegistry.INSTANCE.lookup((class_5321<class_1887>)((class_5321)key.get()), true));
            }
            catch (IllegalStateException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    @Unique
    public void enchant(Enchantment enchantment, int level) {
        ((class_1799)this).method_7978(enchantment.getEntry(), level);
    }

    @Override
    @Unique
    public Message getName() {
        return (Message)((class_1799)this).method_7964();
    }

    @Override
    @Unique
    public void setName(Message name) {
        ((class_1799)this).method_57379(class_9334.field_49631, (Object)((class_2561)name));
    }

    @Override
    @Unique
    public ItemStack.Rarity getRarity() {
        return ItemStack.Rarity.values()[((class_1799)this).method_7932().ordinal()];
    }

    @Override
    @Unique
    public int getDamage() {
        return ((class_1799)this).method_7919();
    }

    @Override
    @Unique
    public int getMaxDamage() {
        return ((class_1799)this).method_7936();
    }

    @Override
    @Unique
    public boolean isDamaged() {
        return ((class_1799)this).method_7986();
    }

    @Override
    @Unique
    public boolean isDamageable() {
        return ((class_1799)this).method_7963();
    }

    @Override
    @Unique
    public float getMiningSpeed(BlockState state) {
        return ((class_1799)this).method_7924((class_2680)state);
    }

    @Override
    @Unique
    public boolean isEmpty() {
        return ((class_1799)this).method_7960();
    }

    @Override
    @Unique
    public boolean isItemEqual(ItemStack stack) {
        return class_1799.method_7984((class_1799)((class_1799)this), (class_1799)((class_1799)stack));
    }

    @Inject(method={"addEnchantment"}, at={@At(value="HEAD")})
    private void onEnchant(class_6880<class_1887> registryEntry, int level, CallbackInfo ci) {
        this.enchant$level = level;
        this.enchant$type = registryEntry;
    }

    @Redirect(method={"addEnchantment"}, at=@At(value="INVOKE", target="Lnet/minecraft/enchantment/EnchantmentHelper;apply(Lnet/minecraft/item/ItemStack;Ljava/util/function/Consumer;)Lnet/minecraft/component/type/ItemEnchantmentsComponent;"))
    private class_9304 onEnchant$CreateNbt(class_1799 stack, Consumer<class_9304.class_9305> applier) {
        return class_1890.method_57531((class_1799)((class_1799)this), builder -> builder.method_57550(this.enchant$type, this.enchant$level));
    }

    @Inject(method={"getTooltip"}, at={@At(value="TAIL")})
    private void onGetTooltipFromItem(class_1792.class_9635 context, class_1657 player, class_1836 type, CallbackInfoReturnable<List<class_2561>> cir) {
        List list = (List)cir.getReturnValue();
        new EventGetItemToolTip(list, (Item)((class_1799)this).method_7909(), type.method_8035()).broadcast();
    }
}

