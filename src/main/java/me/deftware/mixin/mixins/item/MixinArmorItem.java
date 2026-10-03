/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ArmorItem
 *  net.minecraft.item.equipment.ArmorMaterial
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.equipment.EquipmentType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.item;

import me.deftware.client.framework.item.items.ArmorItem;
import me.deftware.mixin.mixins.item.MixinItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1738.class})
public class MixinArmorItem
extends MixinItem
implements ArmorItem {
    @Unique
    private class_1741 armorMaterial;
    @Unique
    private class_8051 type;

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void onInit(class_1741 armorMaterial, class_8051 type, class_1792.class_1793 settings, CallbackInfo ci) {
        this.armorMaterial = armorMaterial;
        this.type = type;
    }

    @Override
    @Unique
    public int getDamageReduceAmount() {
        return this.armorMaterial.comp_2298().getOrDefault(this.type, 0);
    }

    @Override
    @Unique
    public float getToughness() {
        return this.armorMaterial.comp_2303();
    }

    @Override
    @Unique
    public int getTypeOrdinal() {
        return this.type.method_48399().ordinal();
    }
}

