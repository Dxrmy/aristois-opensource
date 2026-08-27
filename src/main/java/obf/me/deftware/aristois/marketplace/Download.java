/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  me.deftware.client.framework.FrameworkConstants
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package me.deftware.aristois.marketplace;

import \u0000nunyaboolean.catch.for.for.boolean;
import \u0000nunyaboolean.catch.for.for.break;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.List;
import me.deftware.aristois.marketplace.FilePaths;
import me.deftware.aristois.marketplace.MarketplaceMod;
import me.deftware.client.framework.FrameworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Download {
    final private static Logger logger = LogManager.getLogger((String)"Download");
    @SerializedName(value="url")
    private String url;
    @SerializedName(value="loader")
    private String loader = "Fabric";
    @SerializedName(value="redirect")
    private Redirection redirection;
    @SerializedName(value="path")
    private FilePath path;
    @SerializedName(value="sha1")
    private String sha1;
    @SerializedName(value="version")
    private String version;
    @SerializedName(value="regenerate")
    public boolean regenerate = true;

    public boolean isCompatible() {
        return FrameworkConstants.MAPPING_LOADER.name().equalsIgnoreCase(this.loader);
    }

    public void run() throws Exception {
        File file;
        File parent;
        boolean request = new boolean(this.url);
        if (this.redirection != null) {
            String contents = request.long().switch();
            for (Instruction instruction : this.redirection.inst) {
                logger.debug("Executing instruction {}", new Object[]{instruction.getType()});
                if (instruction.getType().equalsIgnoreCase("split")) {
                    contents = contents.split(instruction.getKeyword())[instruction.getIndex()];
                    continue;
                }
                throw new RuntimeException("Unknown inst type " + instruction.getType());
            }
            request = new boolean(this.redirection.getUrl() + contents);
        }
        if (!(parent = (file = this.path.toFile()).getParentFile()).exists() && !parent.mkdirs()) {
            throw new Exception("Unable to create download directory");
        }
        break response = request.implements(this.path.toFile());
        if (!response.long()) {
            logger.error(response.abstract());
            throw new Exception(String.format("%s returned non OK status code %s", request.implements().getHost(), response.static()));
        }
    }

    public String getUrl() {
        return this.url;
    }

    public String getLoader() {
        return this.loader;
    }

    public Redirection getRedirection() {
        return this.redirection;
    }

    public FilePath getPath() {
        return this.path;
    }

    public String getSha1() {
        return this.sha1;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isRegenerate() {
        return this.regenerate;
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

    public static class FilePath {
        @SerializedName(value="type")
        private String type;
        @SerializedName(value="name")
        private String name;

        public File toFile() {
            return FilePaths.valueOf(this.type).resolve(MarketplaceMod.format(this.name));
        }

        public String getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }
    }
}

