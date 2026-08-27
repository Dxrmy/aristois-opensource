/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  org.apache.commons.io.IOUtils
 */
package me.deftware.weaver;

import com.google.gson.annotations.SerializedName;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import me.deftware.weaver.Marketplace;
import org.apache.commons.io.IOUtils;

public class Download {
    @SerializedName(value="url")
    public String url;
    @SerializedName(value="loader")
    private String loader = "Fabric";
    @SerializedName(value="redirect")
    private Redirection redirection;
    @SerializedName(value="path")
    public FilePath path;
    @SerializedName(value="sha1")
    public String sha1;
    @SerializedName(value="regenerate")
    public boolean regenerate = true;

    public boolean isCompatible() {
        return this.loader.equalsIgnoreCase("fabric");
    }

    public boolean isInstalled() {
        return Files.exists(this.path.getPath(), new LinkOption[0]);
    }

    public void download() throws Exception {
        String url = this.url;
        if (this.redirection != null) {
            String contents = Download.fetch(url);
            for (Instruction instruction : this.redirection.inst) {
                if (instruction.getType().equalsIgnoreCase("split")) {
                    contents = contents.split(instruction.getKeyword())[instruction.getIndex()];
                    continue;
                }
                throw new RuntimeException("Unknown inst type " + instruction.getType());
            }
            url = this.redirection.getUrl() + contents;
        }
        Path file = this.path.getPath();
        try (InputStream stream = new URL(url).openStream();
             BufferedInputStream buffer = new BufferedInputStream(stream);){
            Files.copy(buffer, file, new CopyOption[0]);
        }
    }

    public static String fetch(String url) throws Exception {
        try (InputStream stream = new URL(url).openStream();){
            String string;
            try (BufferedInputStream buffer = new BufferedInputStream(stream);){
                string = IOUtils.toString((InputStream)buffer, (Charset)StandardCharsets.UTF_8);
            }
            return string;
        }
    }

    public static class FilePath {
        @SerializedName(value="type")
        private String type;
        @SerializedName(value="name")
        private String name;

        public String getName() {
            return this.name.replace("%mc%", Marketplace.INSTANCE.getVersion().getId());
        }

        public Path getParent() {
            return Marketplace.INSTANCE.getPaths().get(this.type);
        }

        public Path getPath() {
            return this.getParent().resolve(this.getName());
        }
    }

    public static class Redirection {
        @SerializedName(value="url")
        private String url;
        @SerializedName(value="inst")
        private List<Instruction> inst;

        public String getUrl() {
            return this.url;
        }

        public List<Instruction> getInst() {
            return this.inst;
        }
    }

    public static class Instruction {
        @SerializedName(value="type")
        private String type;
        @SerializedName(value="keyword")
        private String keyword;
        @SerializedName(value="index")
        private int index;

        public String getType() {
            return this.type;
        }

        public String getKeyword() {
            return this.keyword;
        }

        public int getIndex() {
            return this.index;
        }
    }
}

