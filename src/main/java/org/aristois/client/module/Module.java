/*
 * Aristois Community Edition — clean-room reimplementation.
 * SPDX-License-Identifier: MIT
 */
package org.aristois.client.module;

import me.deftware.client.framework.event.EventBus;
import org.aristois.client.setting.Setting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.glfw.GLFW;

/**
 * Base class for every feature.
 *
 * <p>Enabling a module subscribes it to the EMC {@link EventBus}; any method
 * annotated with {@code @me.deftware.client.framework.event.EventHandler} then
 * receives events. Disabling unsubscribes it.</p>
 */
public abstract class Module {

    private final String name;
    private final String description;
    private final Category category;
    private final List<Setting<?>> settings = new ArrayList<>();

    private int keyBind = GLFW.GLFW_KEY_UNKNOWN;
    private boolean enabled;

    protected Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    /** Called once when the module is switched on. */
    protected void onEnable() {
    }

    /** Called once when the module is switched off. */
    protected void onDisable() {
    }

    public final void toggle() {
        setEnabled(!enabled);
    }

    public final void setEnabled(boolean value) {
        if (this.enabled == value) {
            return;
        }
        this.enabled = value;
        if (value) {
            EventBus.INSTANCE.registerClass(this);
            onEnable();
        } else {
            EventBus.INSTANCE.unRegisterClass(this);
            onDisable();
        }
    }

    /** Register an option and return it for fluent field initialisation. */
    protected final <S extends Setting<?>> S add(S setting) {
        settings.add(setting);
        return setting;
    }

    public final String getName() {
        return name;
    }

    public final String getDescription() {
        return description;
    }

    public final Category getCategory() {
        return category;
    }

    public final boolean isEnabled() {
        return enabled;
    }

    public final int getKeyBind() {
        return keyBind;
    }

    public final void setKeyBind(int keyBind) {
        this.keyBind = keyBind;
    }

    public final List<Setting<?>> getSettings() {
        return Collections.unmodifiableList(settings);
    }
}
