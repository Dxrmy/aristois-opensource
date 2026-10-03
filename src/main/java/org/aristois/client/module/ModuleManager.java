/*
 * Aristois Community Edition — clean-room reimplementation.
 * SPDX-License-Identifier: MIT
 */
package org.aristois.client.module;

import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventKeyAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.lwjgl.glfw.GLFW;

/** Owns every module and dispatches key bindings. */
public final class ModuleManager {

    private final List<Module> modules = new ArrayList<>();

    /** Subscribe the manager itself so key presses reach modules. */
    public void init() {
        EventBus.INSTANCE.registerClass(this);
    }

    public <M extends Module> M register(M module) {
        modules.add(module);
        return module;
    }

    @EventHandler
    public void onKeyAction(EventKeyAction event) {
        if (event.getAction() != GLFW.GLFW_PRESS) {
            return;
        }
        for (Module module : modules) {
            int bind = module.getKeyBind();
            if (bind != GLFW.GLFW_KEY_UNKNOWN && bind == event.getKeyCode()) {
                module.toggle();
            }
        }
    }

    public List<Module> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public Optional<Module> byName(String name) {
        return modules.stream().filter(m -> m.getName().equalsIgnoreCase(name)).findFirst();
    }
}
