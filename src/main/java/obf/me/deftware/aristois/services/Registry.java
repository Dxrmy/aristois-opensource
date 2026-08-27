/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.aristois.services;

import \u0000nunyaboolean.catch.for.implements.private;
import \u0000nunyaboolean.catch.for.short.break.this;
import \u0000nunyaboolean.catch.for.short.do;
import java.util.Arrays;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.aristois.services.Service;
import me.deftware.aristois.services.types.CraftPresenceService;
import me.deftware.aristois.services.types.SeedCrackerService;
import me.deftware.aristois.services.types.baritone.BaritoneService;

public enum Registry implements Runnable
{
    CraftPresence(CraftPresenceService.class),
    SeedCracker(SeedCrackerService.class),
    Baritone(BaritoneService.class);

    final private Class<? extends Runnable> clazz;
    final private Service data;
    private Object object;

    private Registry(Class<? extends Runnable> clazz) {
        if (!clazz.isAnnotationPresent(Service.class)) {
            throw new RuntimeException("Invalid service!");
        }
        this.data = clazz.getAnnotation(Service.class);
        this.clazz = clazz;
    }

    @Override
    public void run() {
        try {
            if (!this.isAnyClassPresent(this.data.value())) {
                throw new Exception("Service class not found");
            }
            if (!this.canRunOnOS(this.data.os())) {
                throw new Exception("Unsupported OS!");
            }
            this.object = this.clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (this.data.module()) {
                this.register();
            }
            ((Runnable)this.object).run();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void register() {
        AbstractMod mod = new AbstractMod(this.data.name(), do.else\u00a0byte, this.data.description());
        this.else\u00a0switch.implements(this.clazz, mod, \u0000nunyaboolean.catch.for.finally.break.this.implements(this.object));
        mod.setSettingOnlyMod(true);
    }

    private boolean isAnyClassPresent(String[] classes) {
        for (String clazz : classes) {
            try {
                Class<?> serviceClass = Class.forName(clazz);
                return true;
            }
            catch (Throwable throwable) {
            }
        }
        return false;
    }

    private boolean canRunOnOS(private.default os) {
        if (os != private.default.static\u00a0boolean) {
            if (os == private.default.static\u00a0interface) {
                return os == private.static\u00a0int && private.implements();
            }
            return os == private.static\u00a0int;
        }
        return true;
    }

    public String getName() {
        return this.data.name();
    }

    public boolean isAvailable() {
        return this.object != null;
    }

    public <T> T getService() {
        return (T)this.object;
    }

    public static int size() {
        return (int)Arrays.stream(Registry.values()).filter(Registry::isAvailable).count();
    }

    public Class<? extends Runnable> getClazz() {
        return this.clazz;
    }

    public Service getData() {
        return this.data;
    }
}

