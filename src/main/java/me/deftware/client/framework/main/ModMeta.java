/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  lombok.Generated
 */
package me.deftware.client.framework.main;

import com.google.gson.annotations.SerializedName;
import lombok.Generated;

public class ModMeta {
    @SerializedName(value="name")
    private String name;
    @SerializedName(value="website")
    private String website;
    @SerializedName(value="author")
    private String author;
    @SerializedName(value="minVersion")
    private String minVersion;
    @SerializedName(value="version")
    private int version;
    @SerializedName(value="main")
    private String main;
    @SerializedName(value="updateLinkOverride")
    private boolean updateLinkOverride;
    @SerializedName(value="scheme")
    private int scheme;

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getWebsite() {
        return this.website;
    }

    @Generated
    public String getAuthor() {
        return this.author;
    }

    @Generated
    public String getMinVersion() {
        return this.minVersion;
    }

    @Generated
    public int getVersion() {
        return this.version;
    }

    @Generated
    public String getMain() {
        return this.main;
    }

    @Generated
    public boolean isUpdateLinkOverride() {
        return this.updateLinkOverride;
    }

    @Generated
    public int getScheme() {
        return this.scheme;
    }
}

