/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_5498
 */
package me.deftware.client.framework.minecraft;

import net.minecraft.class_5498;

public enum PlayerPerspective {
    FIRST_PERSON(class_5498.field_26664),
    THIRD_PERSON_BACK(class_5498.field_26665),
    THIRD_PERSON_FRONT(class_5498.field_26666);

    private final class_5498 perspective;

    private PlayerPerspective(class_5498 perspective) {
        this.perspective = perspective;
    }

    public class_5498 getMinecraftPerspective() {
        return this.perspective;
    }

    public boolean isThirdPerson() {
        return this == THIRD_PERSON_BACK || this == THIRD_PERSON_FRONT;
    }
}

