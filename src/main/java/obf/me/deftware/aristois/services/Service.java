/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.aristois.services;

import \u0000nunyaboolean.catch.for.implements.private;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface Service {
    public String[] value();

    public String name() default "Unknown";

    public String[] description() default {"Service"};

    public String[] source() default {"Unknown"};

    public private.default os() default private.default.All;

    public boolean preRun() default false;

    public boolean module() default false;
}

