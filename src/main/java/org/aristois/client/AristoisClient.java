/*
 * Aristois Community Edition — clean-room reimplementation.
 * SPDX-License-Identifier: MIT
 *
 * This is an original client built on top of the MIT-licensed EMC framework.
 * It shares no source code with the proprietary Aristois client.
 */
package org.aristois.client;

import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import org.aristois.client.module.ModuleManager;
import org.aristois.client.module.modules.CoordinatesModule;
import org.aristois.client.module.modules.FastUseModule;
import org.aristois.client.module.modules.SprintModule;

/**
 * EMC mod entry point. The framework instantiates this class after reading the
 * {@code main} field from this jar's {@code client.json}.
 */
public final class AristoisClient extends EMCMod {

    public static final String NAME = "Aristois Community";
    public static final String VERSION = "1.0.0";

    private static AristoisClient instance;

    private ModuleManager moduleManager;

    @Override
    public void initialize() {
        instance = this;
        moduleManager = new ModuleManager();

        moduleManager.register(new SprintModule());
        moduleManager.register(new FastUseModule());
        moduleManager.register(new CoordinatesModule());

        moduleManager.init();
        Bootstrap.logger.info("{} v{} ready ({} modules)",
                NAME, VERSION, moduleManager.getModules().size());
    }

    public static AristoisClient getInstance() {
        return instance;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
