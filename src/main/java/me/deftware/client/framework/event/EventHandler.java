/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface EventHandler {
    public int priority() default 1;
}

