/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonObject
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package me.deftware.aristois.marketplace;

import \u0000nunyaboolean.catch.for.for.boolean;
import \u0000nunyaboolean.catch.for.implements.break;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import me.deftware.aristois.marketplace.MarketplaceMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Marketplace
implements Runnable {
    final private static Gson gson = break.implements().create();
    final public static Marketplace INSTANCE = new Marketplace();
    protected final List<MarketplaceMod> modMap = new ArrayList<MarketplaceMod>();
    protected String updated;
    protected String url = "https://gitlab.com/EMC-Framework/maven/-/raw/master/marketplace/index.json";
    final public Logger logger = LogManager.getLogger((String)"Marketplace");

    @Override
    public void run() {
        this.logger.debug("Fetching marketplace mods");
        new boolean(this.url).switch().thenAccept(response -> {
            try {
                if (response.long()) {
                    JsonObject json = response.implements();
                    this.updated = json.get("updated").getAsString();
                    for (MarketplaceMod mod : (MarketplaceMod[])gson.fromJson(json.get("mods"), MarketplaceMod[].class)) {
                        mod.run();
                        if (mod.isSupported() && !mod.isMaintenance()) {
                            this.modMap.add(mod);
                            continue;
                        }
                        this.logger.debug("Ignoring unsupported mod {}", new Object[]{mod.getId()});
                    }
                    this.logger.debug("Fetched {} marketplace mods", new Object[]{this.modMap.size()});
                } else {
                    this.logger.error("Unable to fetch list of mods");
                }
            }
            catch (Exception ex) {
                this.logger.error("Failed to serialize mods due to invalid json");
            }
        });
    }

    public boolean isInstalled(String id) {
        Optional<MarketplaceMod> mod = this.stream().filter(m -> m.getId().equalsIgnoreCase(id)).findAny();
        return mod.map(MarketplaceMod::isInstalled).orElse(false);
    }

    public int size() {
        return this.modMap.size();
    }

    public Stream<MarketplaceMod> stream() {
        return this.modMap.stream();
    }

    public List<MarketplaceMod> getModMap() {
        return this.modMap;
    }

    public String getUpdated() {
        return this.updated;
    }

    public String getUrl() {
        return this.url;
    }
}

