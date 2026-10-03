package me.deftware.aristois.marketplace;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import me.deftware.aristois.recovered.C0139;
import me.deftware.aristois.recovered.C0198;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Marketplace implements Runnable {
   private static final Gson gson = C0198.m_ab13aa72().create();
   public static final Marketplace INSTANCE = new Marketplace();
   protected final List<MarketplaceMod> modMap = new ArrayList<>();
   protected String updated;
   protected String url = "https://gitlab.com/EMC-Framework/maven/-/raw/master/marketplace/index.json";
   public final Logger logger = LogManager.getLogger("Marketplace");

   public Marketplace() {
   }

   @Override
   public void run() {
      this.logger.debug("Fetching marketplace mods");
      new C0139(this.url).m_b24e4acc().thenAccept(response -> {
         try {
            if (response.m_9781181b()) {
               JsonObject json = response.m_fcc066b3();
               this.updated = json.get("updated").getAsString();

               for (MarketplaceMod mod : (MarketplaceMod[])gson.fromJson(json.get("mods"), MarketplaceMod[].class)) {
                  mod.run();
                  if (mod.isSupported() && !mod.isMaintenance()) {
                     this.modMap.add(mod);
                  } else {
                     this.logger.debug("Ignoring unsupported mod {}", new Object[]{mod.getId()});
                  }
               }

               this.logger.debug("Fetched {} marketplace mods", new Object[]{this.modMap.size()});
            } else {
               this.logger.error("Unable to fetch list of mods");
            }
         } catch (Exception var7) {
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
