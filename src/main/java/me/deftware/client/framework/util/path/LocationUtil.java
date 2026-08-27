/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 */
package me.deftware.client.framework.util.path;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.util.path.OSUtils;

public class LocationUtil {
    @Nullable
    private URL url;
    @Nullable
    private File file;

    private LocationUtil(URL url) {
        this.url = url;
    }

    private LocationUtil(File file) {
        this.file = file;
    }

    private static File getModFileById(String id) throws Exception {
        Class<?> clazz = Class.forName("net.minecraftforge.fml.ModList");
        Class<?> fileInfoClass = Class.forName("net.minecraftforge.forgespi.language.IModFileInfo");
        Class<?> modFileClass = Class.forName("net.minecraftforge.forgespi.locating.IModFile");
        Method getInstance = clazz.getDeclaredMethod("get", new Class[0]);
        Method getModFileById = clazz.getDeclaredMethod("getModFileById", String.class);
        Method getFile = fileInfoClass.getDeclaredMethod("getFile", new Class[0]);
        Method getFilePath = modFileClass.getDeclaredMethod("getFilePath", new Class[0]);
        Object modList = getInstance.invoke(null, new Object[0]);
        Object fileInfo = getModFileById.invoke(modList, id);
        Object modFile = getFile.invoke(fileInfo, new Object[0]);
        Path path = (Path)getFilePath.invoke(modFile, new Object[0]);
        return path.toFile();
    }

    @Nonnull
    public static LocationUtil getClassPhysicalLocation(@Nonnull Class<?> c) {
        String suffix;
        try {
            URL codeSourceLocation = c.getProtectionDomain().getCodeSource().getLocation();
            if (codeSourceLocation != null) {
                return new LocationUtil(codeSourceLocation);
            }
        }
        catch (NullPointerException | SecurityException codeSourceLocation) {
            // empty catch block
        }
        URL classResource = c.getResource(c.getSimpleName() + ".class");
        if (classResource == null) {
            return new LocationUtil((URL)null);
        }
        String url = classResource.toString();
        if (!url.endsWith(suffix = c.getCanonicalName().replace('.', '/') + ".class")) {
            return new LocationUtil((URL)null);
        }
        String base = url.substring(0, url.length() - suffix.length());
        String path = base;
        if (path.startsWith("jar:")) {
            path = path.substring(4, path.length() - 2);
        }
        try {
            return new LocationUtil(new URL(path));
        }
        catch (MalformedURLException e) {
            return new LocationUtil((URL)null);
        }
    }

    @Nonnull
    public static LocationUtil getEMC() {
        if (FrameworkConstants.MAPPING_LOADER == FrameworkConstants.MappingsLoader.Forge) {
            try {
                return new LocationUtil(LocationUtil.getModFileById("emc"));
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return LocationUtil.getClassPhysicalLocation(Bootstrap.class);
    }

    @Nullable
    public File toFile() {
        block6: {
            if (this.file != null) {
                return this.file;
            }
            if (this.url != null) {
                Object path = this.url.toString();
                if (((String)path).startsWith("jar:")) {
                    path = ((String)path).substring(4, ((String)path).indexOf("!/"));
                }
                try {
                    if (OSUtils.isWindows() && ((String)path).matches("file:[A-Za-z]:.*")) {
                        path = "file:/" + ((String)path).substring(5);
                    }
                    return new File(new URL((String)path).toURI());
                }
                catch (Throwable throwable) {
                    if (!((String)path).startsWith("file:")) break block6;
                    return new File(((String)path).substring(5));
                }
            }
        }
        return null;
    }
}

