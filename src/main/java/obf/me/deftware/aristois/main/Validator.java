/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  me.deftware.client.framework.FrameworkConstants
 *  me.deftware.client.framework.FrameworkConstants$MappingsLoader
 *  me.deftware.client.framework.helper.Logger
 *  me.deftware.client.framework.minecraft.Minecraft
 *  me.deftware.client.framework.util.path.LocationUtil
 *  org.apache.commons.lang3.StringUtils
 */
package me.deftware.aristois.main;

import \u0000nunyaboolean.catch.for.implements.case;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.helper.Logger;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.path.LocationUtil;
import org.apache.commons.lang3.StringUtils;

public class Validator {
    final private static Logger LOGGER = new Logger("Validator");
    final private static String MAVEN_REPO = "https://gitlab.com/EMC-Framework/maven/-/raw/master";
    final private static case<String> remoteChecksum = new case<String>(() -> {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    });
    final private static case<String> localChecksum = new case<String>(() -> {
        try {
            Path path;
            if (FrameworkConstants.MAPPING_LOADER == FrameworkConstants.MappingsLoader.Forge) {
                Path gameDir = Paths.get(Minecraft.getMinecraftGame()._getGameDir().getAbsolutePath(), new String[0]);
                Path mods = gameDir.resolve("mods");
                if (Minecraft.getMinecraftProtocolVersion() <= 340) {
                    mods = mods.resolve(Minecraft.getMinecraftVersion());
                }
                path = mods.resolve("EMC.jar");
            } else {
                path = Paths.get(LocationUtil.getEMC().toFile().getAbsolutePath(), new String[0]);
            }
            if (!Files.exists(path, new LinkOption[0])) {
                throw new IOException("Unable to find EMC jar file");
            }
            return Validator.SHA1(path);
        }
        catch (Exception ex) {
            LOGGER.error("Unable to retrieve local checksum of EMC jar", new Object[0]);
            LOGGER.debug("Caused by {}", new Object[]{ex.getMessage()});
            return null;
        }
    });

    public static boolean isRuntimeValid() {
        return StringUtils.equalsIgnoreCase((CharSequence)Validator.getRemoteChecksum(), (CharSequence)Validator.getLocalChecksum());
    }

    public static synchronized String getRemoteChecksum() {
        return remoteChecksum.implements();
    }

    public static synchronized String getLocalChecksum() {
        return localChecksum.implements();
    }

    private static String SHA1(Path path) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] bytes = Files.readAllBytes(path);
        byte[] digested = messageDigest.digest(bytes);
        StringBuilder builder = new StringBuilder();
        for (byte b : digested) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    /*
     * Exception decompiling
     */
    public static Version[] getVersions() throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static class Version {
        @SerializedName(value="id")
        public String id;
        @SerializedName(value="protocol")
        public int protocol;
    }
}

