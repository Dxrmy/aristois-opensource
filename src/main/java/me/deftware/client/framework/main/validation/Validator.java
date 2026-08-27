/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.main.validation;

import java.io.File;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.util.HashUtils;
import me.deftware.client.framework.util.WebUtils;
import me.deftware.client.framework.util.path.LocationUtil;

public class Validator {
    public static String cachedLocalChecksum;
    public static String cachedRemoteChecksum;

    public static String getLocalChecksum() throws Exception {
        if (cachedLocalChecksum != null && !cachedLocalChecksum.isEmpty()) {
            return cachedLocalChecksum;
        }
        LocationUtil emc = LocationUtil.getEMC();
        File physicalFile = emc.toFile();
        if (physicalFile == null || !physicalFile.exists()) {
            throw new Exception("EMC jar file not found! This should be impossible.");
        }
        cachedLocalChecksum = HashUtils.getSha1(physicalFile).trim().toLowerCase();
        return cachedLocalChecksum;
    }

    public static String getRemoteChecksum() throws Exception {
        if (cachedRemoteChecksum != null && !cachedRemoteChecksum.isEmpty()) {
            return cachedRemoteChecksum;
        }
        cachedRemoteChecksum = WebUtils.get(WebUtils.getMavenUrl(FrameworkConstants.getFrameworkMaven(), FrameworkConstants.FRAMEWORK_MAVEN_URL) + ".sha1").trim().toLowerCase();
        return cachedRemoteChecksum;
    }

    public static boolean isValidInstance() {
        try {
            return Validator.getLocalChecksum().equalsIgnoreCase(Validator.getRemoteChecksum());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

