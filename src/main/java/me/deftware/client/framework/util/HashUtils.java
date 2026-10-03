/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 */
package me.deftware.client.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import net.minecraft.client.MinecraftClient;

public class HashUtils {
    private static final char[] hexCode = "0123456789ABCDEF".toCharArray();

    public static String getSHA(String string) throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-512");
        sha1.update(string.getBytes());
        return HashUtils.printHexBinary(sha1.digest());
    }

    public static String calcSHA(File file) throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-512");
        FileInputStream input = new FileInputStream(file);
        try {
            byte[] buffer = new byte[8192];
            int len = ((InputStream)input).read(buffer);
            while (len != -1) {
                sha1.update(buffer, 0, len);
                len = ((InputStream)input).read(buffer);
            }
            ((InputStream)input).close();
            return HashUtils.printHexBinary(sha1.digest());
        }
        catch (Exception ex) {
            return "";
        }
    }

    public static String getSha1(File file) throws IOException {
        String sha1;
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        }
        catch (NoSuchAlgorithmException e1) {
            throw new IOException("Impossible to get SHA-1 digester", e1);
        }
        try (FileInputStream input = new FileInputStream(file);
             DigestInputStream digestStream = new DigestInputStream(input, digest);){
            while (digestStream.read() != -1) {
            }
            MessageDigest msgDigest = digestStream.getMessageDigest();
            sha1 = HashUtils.printHexBinary(msgDigest.digest());
        }
        return sha1;
    }

    public static String getClientHash() {
        try {
            File f = new File(class_310.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            return HashUtils.calcSHA(f);
        }
        catch (Exception ex) {
            return "";
        }
    }

    public static String printHexBinary(byte[] data) {
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[b >> 4 & 0xF]);
            r.append(hexCode[b & 0xF]);
        }
        return r.toString();
    }
}

