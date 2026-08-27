/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package me.deftware.client.framework.helper;

import org.slf4j.LoggerFactory;

public class Logger {
    private final org.slf4j.Logger delegate;

    public Logger(Class<?> clazz) {
        this(clazz.getSimpleName());
    }

    public Logger(String name) {
        this.delegate = LoggerFactory.getLogger((String)name);
    }

    public void info(String text, Object ... args) {
        this.delegate.info(text, args);
    }

    public void debug(String text, Object ... args) {
        this.delegate.debug(text, args);
    }

    public void warn(String text, Object ... args) {
        this.delegate.warn(text, args);
    }

    public void error(String text, Object ... args) {
        this.delegate.error(text, args);
    }
}

