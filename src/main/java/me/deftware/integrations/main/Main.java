/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package me.deftware.integrations.main;

import me.deftware.integrations.main.EarlyRiser;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
implements ClientModInitializer {
    private final Logger logger = LoggerFactory.getLogger((String)"EMC/Integrations");

    public void onInitializeClient() {
        for (String patch : EarlyRiser.APPLIED_PATCHES) {
            this.logger.info("Applied patch {}", (Object)patch);
        }
    }
}

