/*
 * Aristois Community Edition — clean-room reimplementation.
 * SPDX-License-Identifier: MIT
 */
package org.aristois.client.module;

/** Logical grouping used by the module list / click GUI. */
public enum Category {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER("Player"),
    RENDER("Render"),
    WORLD("World"),
    MISC("Misc"),
    CLIENT("Client");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
