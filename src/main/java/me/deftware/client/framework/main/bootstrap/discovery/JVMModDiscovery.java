/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.main.bootstrap.discovery;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.main.bootstrap.discovery.AbstractModDiscovery;
import me.deftware.client.framework.util.HashUtils;
import me.deftware.client.framework.util.WebUtils;

public class JVMModDiscovery
extends AbstractModDiscovery {
    @Override
    public void discover() {
        for (int i = 0; i < 100; ++i) {
            if (System.getProperty("emcMod" + i) == null) continue;
            String[] mod = System.getProperty("emcMod" + i).split(",");
            File jar = new File(Bootstrap.EMC_ROOT.getAbsolutePath() + File.separator + mod[0] + ".jar");
            File delete = new File(Bootstrap.EMC_ROOT.getAbsolutePath() + File.separator + mod[0] + ".jar.delete");
            if (!delete.exists()) {
                Bootstrap.logger.debug("Discovered {} with JVMModDiscovery", (Object)jar.getName());
                this.entries.add(new JVMModEntry(jar, mod));
                continue;
            }
            if (delete.delete() && jar.delete()) continue;
            Bootstrap.logger.error("Failed to delete mod {}", (Object)jar.getName());
        }
    }

    public static class JVMModEntry
    extends AbstractModDiscovery.AbstractModEntry {
        private final String[] data;

        JVMModEntry(File file, String ... data) {
            super(file, null);
            this.data = data;
        }

        @Override
        public void init() {
            block8: {
                String[] maven = this.data[1].split(":");
                String url = this.data[2] + maven[0].replace(".", "/") + "/" + maven[1] + "/" + maven[2] + "/" + maven[1] + "-" + maven[2] + ".jar";
                String sha1 = url + ".sha1";
                try {
                    if (!this.getFile().exists()) {
                        this.install(url);
                        Bootstrap.logger.info("Installed {}", (Object)this.getFile().getName());
                        break block8;
                    }
                    String remoteSHA1 = WebUtils.get(sha1);
                    try {
                        String hash = HashUtils.getSha1(this.getFile());
                        if (!remoteSHA1.equalsIgnoreCase(hash)) {
                            Bootstrap.logger.warn("SHA-1 not matching for {}, expected {} but got {}!", new Object[]{this.getFile().getName(), remoteSHA1, hash});
                            if (!this.getFile().delete()) {
                                Bootstrap.logger.error("Failed to delete {}", (Object)this.getFile().getName());
                            } else {
                                this.install(url);
                                Bootstrap.logger.info("Reinstalled {}", (Object)this.getFile().getName());
                            }
                            break block8;
                        }
                        Bootstrap.logger.info("SHA-1 matching for {}", (Object)this.getFile().getName());
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                        Bootstrap.logger.error("Unable to compute SHA-1 of {}", (Object)this.getFile().getName());
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    Bootstrap.logger.error("Unable to install/verify {}", (Object)this.getFile().getName());
                }
            }
        }

        @Override
        public EMCMod toInstance() {
            return null;
        }

        private void install(String link) {
            try {
                int read;
                HttpsURLConnection connection = (HttpsURLConnection)new URL(link).openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
                connection.setRequestMethod("GET");
                FileOutputStream out = new FileOutputStream(this.getFile().getAbsolutePath());
                InputStream in = connection.getInputStream();
                byte[] buffer = new byte[4096];
                while ((read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                in.close();
                out.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
                Bootstrap.logger.error("Failed to download {}", (Object)this.getFile().getName());
            }
        }
    }
}

