package me.deftware.aristois.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.recovered.C0064;
import me.deftware.aristois.recovered.C0091;
import me.deftware.aristois.recovered.C0092;
import me.deftware.aristois.recovered.C0094;
import me.deftware.aristois.recovered.C0098;
import me.deftware.aristois.recovered.C0100;
import me.deftware.aristois.recovered.C0102;
import me.deftware.aristois.recovered.C0125;
import me.deftware.aristois.recovered.C0217;
import me.deftware.aristois.recovered.C0245;
import me.deftware.aristois.recovered.C0289;
import me.deftware.aristois.recovered.C0290;
import me.deftware.aristois.recovered.C0295;
import me.deftware.aristois.recovered.C0297;
import me.deftware.aristois.recovered.C0420;
import me.deftware.aristois.recovered.C0421;
import me.deftware.aristois.recovered.C0422;
import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.helper.Logger;
import me.deftware.client.framework.message.Message;

public class AbstractMod implements C0217.anonymousthis, C0092 {
   protected final Collection<C0094<?>> fields = new ArrayList<>();
   private JsonObject modProps;
   private C0102<?> mode;
   private final C0290 category;
   private final String name;
   private final String[] description;
   public boolean enabled = false;
   private C0245 keybind = new C0245();
   private boolean pinned = false;
   private String modID;
   private boolean shouldDeRegisterEvent = true;
   private final List<Consumer<Boolean>> toggleWatch = new ArrayList<>();
   private boolean settingOnlyMod;
   private boolean manageBusRegistration = true;
   private boolean betaVersion = false;
   private static final Logger logger = new Logger("Module");
   private final List<String> runOnceKeys = new ArrayList<>();

   public AbstractMod(String name, C0290 category, String... description) {
      this.category = category;
      this.name = name;
      this.description = description;
      this.settingOnlyMod = this.getClass().isAnnotationPresent(C0420.class);
      this.modID = name.toLowerCase().replace(" ", "").trim();

      try {
         this.initCore();
      } catch (Exception var5) {
         var5.printStackTrace();
      }
   }

   public void initCore() {
      this.modProps = Main.getConfig().hasKey(this.modID) ? Main.getConfig().getObject(this.modID) : new JsonObject();
      if (!Main.getConfig().hasKey(this.modID)) {
         C0422 defaultMod = this.getClass().isAnnotationPresent(C0422.class) ? this.getClass().getAnnotation(C0422.class) : null;
         if (defaultMod != null) {
            this.keybind.m_3500412e(defaultMod.value());
            this.keybind.m_4adc9538(defaultMod.modifier());
         }

         this.modProps.add("keyBind", C0125.f_70947d4f.m_77b61bf9(this.keybind, C0245.class));
         this.modProps.addProperty("state", defaultMod != null);
         this.modProps.addProperty("pinned", defaultMod != null && defaultMod.pinned());
         Main.getConfig().putObject(this.modID, this.modProps);
      }

      if (this.modProps.has("keyBind")) {
         try {
            this.keybind = (C0245)C0125.f_70947d4f.m_5f630fc1(this.modProps.get("keyBind").getAsJsonObject(), C0245.class);
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

      this.keybind.m_1990ab66(this::save);
      if (!(this instanceof C0297) && !(this instanceof C0295)) {
         this.enabled = this.modProps.get("state").getAsBoolean()
            && !this.getClass().isAnnotationPresent(C0421.class)
            && !this.getClass().isAnnotationPresent(C0420.class);
      }

      this.pinned = this.modProps.get("pinned").getAsBoolean();
   }

   public void save() {
      try {
         C0091.m_03614e5a(this);
         this.modProps.addProperty("state", this.enabled);
         this.modProps.addProperty("pinned", this.pinned);
         this.modProps.add("keyBind", C0125.f_70947d4f.m_77b61bf9(this.keybind, C0245.class));
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      Main.getConfig().putObject(this.modID, this.modProps);
   }

   public void load() {
      if (this.enabled && this.manageBusRegistration) {
         this.registerEvents(true);
      }

      C0091.m_3e2b7ec9(this);
   }

   public Message m_bdef0f40() {
      for (C0094<?> field : this.fields) {
         field.m_4e85e8f7();
      }

      this.save();
      return Message.of("Reset all settings");
   }

   public AbstractMod toggle() {
      if (this.settingOnlyMod) {
         this.onSettingsOnlyModClick();
         this.setState(false);
      } else {
         this.setState(!this.isEnabled());
      }

      return this;
   }

   public void setState(boolean state) {
      this.enabled = state;
      this.toggleWatch.forEach(t -> t.accept(state));
      this.save();
      if (this.enabled) {
         Class<? extends AbstractMod>[] clashes = this.getClashes();
         if (clashes != null) {
            Arrays.stream(clashes)
               .filter(c -> C0289.m_ded43506((Class<? extends AbstractMod>)c).isEnabled())
               .forEach(c -> C0289.m_ded43506((Class<? extends AbstractMod>)c).toggle());
         }

         this.registerEvents(true);
         this.onEnable();
      } else {
         if (this.shouldDeRegisterEvent) {
            this.registerEvents(false);
         }

         this.onDisable();
      }
   }

   public Class<? extends AbstractMod>[] getClashes() {
      return this.getClass().isAnnotationPresent(C0100.class) ? this.getClass().getAnnotation(C0100.class).value() : null;
   }

   protected void registerEvents(boolean flag) {
      if (this.manageBusRegistration) {
         if (flag) {
            EventBus.registerClass(this.getClass(), this, (event, listener) -> listener.setExceptionHandler(this::onCrash));
         } else {
            EventBus.unRegisterClass(this.getClass());
         }
      }
   }

   protected void onCrash(Throwable cause) {
      logger.error("Module {} in category {} (state: {})", new Object[]{this.m_5aac041f(), this.getCategory().name(), this.enabled ? "enabled" : "disabled"});

      try {
         C0091.m_03614e5a(this);
      } catch (Throwable var4) {
         logger.error("An error occurred when serializing settings in mod \"{}\"", new Object[]{this.m_5aac041f(), var4});
      }

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      String json = gson.toJson(this.modProps);
      logger.info("Properties {}", new Object[]{json});
      C0064.m_c28a0024().m_6b4e8235("An error occurred").m_77a7bc18("See the logs for more information").m_66e721c0();
      C0064.m_c28a0024()
         .m_77a7bc18(
            "An error occurred in " + this.m_5aac041f(),
            "Report this to us in our aristois.net/guilded",
            "More information is available in the latest.log file"
         )
         .m_9d59fbe9();
   }

   public String getDisplayMode() {
      return this.mode != null ? this.mode.m_27694bb2() : null;
   }

   public String getDisplayName() {
      return this.betaVersion ? this.m_5aac041f() + " (Beta)" : this.m_5aac041f();
   }

   protected void runOnce(String key, Runnable action) {
      if (!this.runOnceKeys.contains(key)) {
         this.runOnceKeys.add(key);
         action.run();
      }
   }

   public void onPostLoad() {
   }

   public void onShutdown() {
   }

   public void onEnable() {
   }

   public void onDisable() {
   }

   public void onSettingsOnlyModClick() {
   }

   public void onSettingUpdate(C0098 setting) {
   }

   public void setModProps(JsonObject modProps) {
      this.modProps = modProps;
   }

   public void setMode(C0102<?> mode) {
      this.mode = mode;
   }

   public void setEnabled(boolean enabled) {
      this.enabled = enabled;
   }

   public void setKeybind(C0245 keybind) {
      this.keybind = keybind;
   }

   public void setPinned(boolean pinned) {
      this.pinned = pinned;
   }

   public void setModID(String modID) {
      this.modID = modID;
   }

   public void setShouldDeRegisterEvent(boolean shouldDeRegisterEvent) {
      this.shouldDeRegisterEvent = shouldDeRegisterEvent;
   }

   public void setSettingOnlyMod(boolean settingOnlyMod) {
      this.settingOnlyMod = settingOnlyMod;
   }

   public void setManageBusRegistration(boolean manageBusRegistration) {
      this.manageBusRegistration = manageBusRegistration;
   }

   public void setBetaVersion(boolean betaVersion) {
      this.betaVersion = betaVersion;
   }

   public Collection<C0094<?>> getFields() {
      return this.fields;
   }

   public JsonObject getModProps() {
      return this.modProps;
   }

   public C0102<?> getMode() {
      return this.mode;
   }

   public C0290 getCategory() {
      return this.category;
   }

   public String m_5aac041f() {
      return this.name;
   }

   public String[] getDescription() {
      return this.description;
   }

   public boolean isEnabled() {
      return this.enabled;
   }

   public C0245 getKeybind() {
      return this.keybind;
   }

   public boolean isPinned() {
      return this.pinned;
   }

   public String getModID() {
      return this.modID;
   }

   public boolean isShouldDeRegisterEvent() {
      return this.shouldDeRegisterEvent;
   }

   public List<Consumer<Boolean>> getToggleWatch() {
      return this.toggleWatch;
   }

   public boolean isSettingOnlyMod() {
      return this.settingOnlyMod;
   }

   public boolean isManageBusRegistration() {
      return this.manageBusRegistration;
   }

   public boolean isBetaVersion() {
      return this.betaVersion;
   }

   public List<String> getRunOnceKeys() {
      return this.runOnceKeys;
   }
}
