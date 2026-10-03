/*
 * Aristois Community Edition — clean-room reimplementation.
 * SPDX-License-Identifier: MIT
 */
package org.aristois.client.setting;

/**
 * A single, typed option belonging to a {@link org.aristois.client.module.Module}.
 *
 * @param <T> value type (Boolean, Double, String, Enum, ...)
 */
public class Setting<T> {

    private final String name;
    private final String description;
    protected T value;

    public Setting(String name, String description, T defaultValue) {
        this.name = name;
        this.description = description;
        this.value = defaultValue;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
