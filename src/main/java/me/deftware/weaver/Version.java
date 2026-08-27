/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package me.deftware.weaver;

import com.google.gson.annotations.SerializedName;

public class Version {
    @SerializedName(value="id")
    private String id;
    @SerializedName(value="name")
    private String name;
    @SerializedName(value="protocol_version")
    private int protocol;
    @SerializedName(value="stable")
    private boolean stable;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public boolean isStable() {
        return this.stable;
    }
}

