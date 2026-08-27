/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_1300
 *  net.minecraft.class_5321
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.entity;

import me.deftware.client.framework.registry.EntityRegistry;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_5321;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_1299.class})
public class MixinEntityType {
    @Redirect(method={"register(Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/entity/EntityType$Builder;)Lnet/minecraft/entity/EntityType;"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/EntityType$Builder;build(Lnet/minecraft/registry/RegistryKey;)Lnet/minecraft/entity/EntityType;", opcode=182))
    private static <T extends class_1297> class_1299<T> registerRedirect(class_1299.class_1300<T> instance, class_5321<class_1299<?>> registryKey) {
        class_1299 type = instance.method_5905(registryKey);
        String id = registryKey.method_29177().method_12832();
        EntityRegistry.INSTANCE.register(id, (class_1299<? extends class_1297>)type);
        return type;
    }
}

