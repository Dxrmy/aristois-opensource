/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.weaver;

import java.io.File;
import java.io.PrintStream;

public class Logger {
    private static PrintStream writer;
    private final String name;

    public static void init(File output) {
        writer = new PrintStream(output);
    }

    public Logger(String name) {
        this.name = name;
    }

    private void log(String level, String text, Object ... args) {
        writer.printf("[" + level + "/" + this.name + "] " + text + System.lineSeparator(), args);
    }

    public void info(String text, Object ... args) {
        this.log("INFO", text, args);
    }

    public void warn(String text, Object ... args) {
        this.log("WARNING", text, args);
    }

    public void error(String error, Throwable exception) {
        writer.print(error);
        exception.printStackTrace(writer);
    }

    public static void close() {
        writer.close();
    }
}

