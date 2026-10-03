/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.item.ItemRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package me.deftware.mixin.mixins.render;

import com.mojang.blaze3d.systems.RenderSystem;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value={RenderSystem.class})
public class MixinTextureManager {
    private static int syncedCount = 0;

    @ModifyVariable(method={"setShaderTexture(ILnet/minecraft/util/Identifier;)V"}, remap=false, at=@At(value="HEAD"))
    private static class_2960 setShaderTexture(class_2960 resource) {
        if (GameMap.INSTANCE.get(GameKeys.RAINBOW_ITEM_GLINT, false).booleanValue() && resource.equals((Object)class_918.field_43087)) {
            if (syncedCount > 50) {
                resource = class_2960.method_60654((String)"emc/enchanted_item_glint_rainbow.png");
            } else {
                ++syncedCount;
            }
        }
        return resource;
    }
}

