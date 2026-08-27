/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.main.preprocessor;

import me.deftware.client.framework.main.preprocessor.PreProcessorMan;

public abstract class ModPreProcessor
implements Runnable {
    public PreProcessorMan preProcessor;

    public abstract String getName();

    public void log(String line) {
    }
}

