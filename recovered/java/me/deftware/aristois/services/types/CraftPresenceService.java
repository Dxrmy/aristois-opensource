package me.deftware.aristois.services.types;

import com.gitlab.cdagaming.craftpresence.CraftPresence;
import com.gitlab.cdagaming.craftpresence.config.ConfigUtils;
import com.gitlab.cdagaming.craftpresence.utils.discord.assets.DiscordAssetUtils;
import me.deftware.aristois.recovered.C0098;
import me.deftware.aristois.services.Service;

@Service(
   value = {"com.gitlab.cdagaming.craftpresence.CraftPresence"},
   source = {"https://gitlab.com/CDAGaming/CraftPresence"},
   name = "CraftPresence",
   module = true,
   description = {"CraftPresence integration"},
   preRun = true
)
public class CraftPresenceService implements Runnable {
   private final String LOGO_ASSET_NAME = "aristois_big";
   private final String CLIENT_ID = "820291086295629834";
   private String defaultId;
   private String current;
   @C0098(
      value = "Presence",
      description = {"Show playing Aristois", "requires restart to apply"}
   )
   private boolean active = true;

   public CraftPresenceService() {
   }

   public ConfigUtils getConfig() {
      return CraftPresence.CONFIG;
   }

   @Override
   public void run() {
      try {
         this.defaultId = this.current = this.getConfig().clientId;
         if (this.active) {
            this.setPresence("820291086295629834");
         }
      } catch (Throwable var2) {
      }
   }

   public boolean setPresence(String id) {
      try {
         if (this.current.equalsIgnoreCase(id)) {
            return false;
         } else {
            this.current = id;
            CraftPresence.CLIENT.shutDown();
            this.getConfig().defaultIcon = "aristois_big";
            this.getConfig().clientId = id;
            DiscordAssetUtils.emptyData();
            CraftPresence.CLIENT.CLIENT_ID = id;
            DiscordAssetUtils.loadAssets(id, true);
            CraftPresence.CLIENT.init(CraftPresence.CONFIG.resetTimeOnInit);
            CraftPresence.CLIENT.syncArgument("&MAINMENU&", CraftPresence.CLIENT.imageOf(CraftPresence.CONFIG.defaultIcon, "", false), true);
            return true;
         }
      } catch (Throwable var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public String getLOGO_ASSET_NAME() {
      return "aristois_big";
   }

   public String getCLIENT_ID() {
      return "820291086295629834";
   }

   public String getDefaultId() {
      return this.defaultId;
   }

   public String getCurrent() {
      return this.current;
   }
}
