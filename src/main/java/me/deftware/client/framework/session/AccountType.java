/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_320$class_321
 */
package me.deftware.client.framework.session;

import lombok.Generated;
import net.minecraft.class_320;

public enum AccountType {
    Legacy(class_320.class_321.field_1990),
    Mojang(class_320.class_321.field_1988),
    Microsoft(class_320.class_321.field_34962);

    private final class_320.class_321 type;

    @Generated
    private AccountType(class_320.class_321 type) {
        this.type = type;
    }

    @Generated
    public class_320.class_321 getType() {
        return this.type;
    }
}

