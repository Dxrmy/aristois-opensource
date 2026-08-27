/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2791
 *  net.minecraft.class_310
 *  net.minecraft.class_5539
 *  net.minecraft.class_5868
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package me.deftware.client.framework.world.gen;

import net.minecraft.class_2791;
import net.minecraft.class_310;
import net.minecraft.class_5539;
import net.minecraft.class_5868;
import org.jetbrains.annotations.ApiStatus;

public interface DecoratorContext {
    @ApiStatus.Internal
    public class_5868 getHeightContext();

    public static DecoratorContext create() {
        class_2791 chunk = class_310.method_1551().field_1687.method_22350(class_310.method_1551().field_1724.method_24515());
        class_5868 heightContext = new class_5868(null, (class_5539)chunk);
        return () -> heightContext;
    }
}

