/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.item.HeldItemRenderer
 *  net.minecraft.client.render.entity.EntityRenderDispatcher
 *  net.minecraft.component.type.MapDecorationsComponent
 *  net.minecraft.component.type.MapDecorationsComponent$Decoration
 *  net.minecraft.component.DataComponentTypes
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.render;

import java.util.Map;
import me.deftware.client.framework.event.events.EventStructureLocation;
import me.deftware.client.framework.math.Vector3;
import net.minecraft.item.ItemStack;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.component.type.MapDecorationsComponent;
import net.minecraft.component.DataComponentTypes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_759.class})
public class MixinHeldItemRenderer {
    @Shadow
    @Final
    private class_898 field_4046;
    @Unique
    private static class_1799 copiedStack = null;

    @Unique
    private static EventStructureLocation.StructureType getStructure(String name) {
        if (name.equals("{\"translate\":\"filled_map.buried_treasure\"}")) {
            return EventStructureLocation.StructureType.BuriedTreasure;
        }
        if (name.equals("{\"translate\":\"filled_map.monument\"}")) {
            return EventStructureLocation.StructureType.OceanMonument;
        }
        if (name.equals("{\"translate\":\"filled_map.mansion\"}")) {
            return EventStructureLocation.StructureType.WoodlandMansion;
        }
        return EventStructureLocation.StructureType.OtherMapIcon;
    }

    @Inject(method={"renderFirstPersonMap"}, at={@At(value="HEAD")})
    private void renderFirstPersonMap(class_4587 matrices, class_4597 vertexConsumers, int swingProgress, class_1799 stack, CallbackInfo info) {
        if (copiedStack != null && class_1799.method_7973((class_1799)copiedStack, (class_1799)stack)) {
            return;
        }
        copiedStack = stack.method_7972();
        class_9292 data = (class_9292)stack.method_57824(class_9334.field_49647);
        if (data != null) {
            for (Map.Entry entry : data.comp_2404().entrySet()) {
                EventStructureLocation.StructureType structure = MixinHeldItemRenderer.getStructure((String)entry.getKey());
                class_9292.class_9293 decoration = (class_9292.class_9293)entry.getValue();
                new EventStructureLocation(Vector3.ofDouble(decoration.comp_2406(), 0.0, decoration.comp_2407()), structure).broadcast();
            }
        }
    }
}

