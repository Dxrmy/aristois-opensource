/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 */
package me.deftware.client.framework.main.bootstrap.discovery;

import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import me.deftware.client.framework.main.EMCMod;

public abstract class AbstractModDiscovery {
    List<AbstractModEntry> entries = new ArrayList<AbstractModEntry>();

    public abstract void discover();

    public Stream<AbstractModEntry> stream() {
        return this.entries.stream();
    }

    public int size() {
        return this.entries.size();
    }

    public static abstract class AbstractModEntry {
        protected JsonObject json;
        private final File file;

        public AbstractModEntry(File file, JsonObject json) {
            this.file = file;
            this.json = json;
        }

        public abstract void init();

        public abstract EMCMod toInstance() throws Exception;

        public File getFile() {
            return this.file;
        }

        public JsonObject getJson() {
            return this.json;
        }
    }
}

