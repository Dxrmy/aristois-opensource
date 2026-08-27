/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.aristois.services;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public interface IStateController {
    final public static Set<IStateController> stateControllers = new HashSet<IStateController>();

    public static IStateController getInstance() {
        return stateControllers.stream().filter(IStateController::isControlling).filter(IStateController::isControllable).findFirst().orElse(null);
    }

    default public boolean isControllable() {
        return true;
    }

    public boolean isPaused();

    public boolean isControlling();

    public void pause();

    public void resume();

    public String getId();

    default public void interrupt() {
        this.interrupt(1500L);
    }

    public void interrupt(long var1);

    public void tick();

    public EnumSet<Capabilities> getCapabilities();

    public static enum Capabilities {
        Walking,
        SlotSwitching,
        Mining;

    }
}

