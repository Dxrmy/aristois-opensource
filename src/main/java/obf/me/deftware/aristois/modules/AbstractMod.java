/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  me.deftware.client.framework.event.EventBus
 *  me.deftware.client.framework.helper.Logger
 *  me.deftware.client.framework.message.Message
 */
package me.deftware.aristois.modules;

import \u0000nunyaboolean.catch.for.finally.case;
import \u0000nunyaboolean.catch.for.finally.do.native;
import \u0000nunyaboolean.catch.for.finally.enum;
import \u0000nunyaboolean.catch.for.finally.try.finally;
import \u0000nunyaboolean.catch.for.implements.private;
import \u0000nunyaboolean.catch.for.private.break;
import \u0000nunyaboolean.catch.for.short.do;
import \u0000nunyaboolean.catch.for.short.do.boolean.double;
import \u0000nunyaboolean.catch.for.short.do.boolean.implements;
import \u0000nunyaboolean.catch.for.short.enum.boolean;
import \u0000nunyaboolean.catch.for.short.enum.default;
import \u0000nunyaboolean.catch.for.short.enum.this;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.helper.Logger;
import me.deftware.client.framework.message.Message;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AbstractMod
implements private.this,
case {
    protected final Collection<\u0000nunyaboolean.catch.for.finally.case.this<?>> fields = new ArrayList();
    private JsonObject modProps;
    private enum<?> mode;
    final private do category;
    final private String name;
    final private String[] description;
    public boolean enabled = false;
    private break keybind = new break();
    private boolean pinned = false;
    private String modID;
    private boolean shouldDeRegisterEvent = true;
    final private List<Consumer<Boolean>> toggleWatch = new ArrayList<Consumer<Boolean>>();
    private boolean settingOnlyMod;
    private boolean manageBusRegistration = true;
    private boolean betaVersion = false;
    final private static Logger logger = new Logger("Module");
    final private List<String> runOnceKeys = new ArrayList<String>();

    public AbstractMod(String name, do category, String ... description) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.settingOnlyMod = this.getClass().isAnnotationPresent(boolean.class);
        this.modID = name.toLowerCase().replace(" ", "").trim();
        try {
            this.initCore();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void initCore() {
        JsonObject jsonObject = this.modProps = Main.getConfig().hasKey(this.modID) ? Main.getConfig().getObject(this.modID) : new JsonObject();
        if (!Main.getConfig().hasKey(this.modID)) {
            this defaultMod;
            this this_ = defaultMod = this.getClass().isAnnotationPresent(this.class) ? this.getClass().getAnnotation(this.class) : null;
            if (defaultMod != null) {
                this.keybind.implements(defaultMod.value());
                this.keybind.long(defaultMod.modifier());
            }
            this.modProps.add("keyBind", finally.implements\u00a0extends.implements(this.keybind, break.class));
            this.modProps.addProperty("state", Boolean.valueOf(defaultMod != null));
            this.modProps.addProperty("pinned", Boolean.valueOf(defaultMod != null && defaultMod.pinned()));
            Main.getConfig().putObject(this.modID, this.modProps);
        }
        if (this.modProps.has("keyBind")) {
            try {
                this.keybind = (break)finally.implements\u00a0extends.implements((JsonElement)this.modProps.get("keyBind").getAsJsonObject(), break.class);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        this.keybind.implements(this::save);
        if (!(this instanceof implements) && !(this instanceof double)) {
            this.enabled = this.modProps.get("state").getAsBoolean() && !this.getClass().isAnnotationPresent(default.class) && !this.getClass().isAnnotationPresent(boolean.class);
        }
        this.pinned = this.modProps.get("pinned").getAsBoolean();
    }

    public void save() {
        try {
            \u0000nunyaboolean.catch.for.finally.break.this.implements(this);
            this.modProps.addProperty("state", Boolean.valueOf(this.enabled));
            this.modProps.addProperty("pinned", Boolean.valueOf(this.pinned));
            this.modProps.add("keyBind", finally.implements\u00a0extends.implements(this.keybind, break.class));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        Main.getConfig().putObject(this.modID, this.modProps);
    }

    public void load() {
        if (this.enabled && this.manageBusRegistration) {
            this.registerEvents(true);
        }
        \u0000nunyaboolean.catch.for.finally.break.this.long(this);
    }

    @Override
    public Message if() {
        for (\u0000nunyaboolean.catch.for.finally.case.this<?> field : this.fields) {
            field.if();
        }
        this.save();
        return Message.of((String)"Reset all settings");
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
                Arrays.stream(clashes).filter(c -> ((AbstractMod)\u0000nunyaboolean.catch.for.short.break.this.implements(c)).isEnabled()).forEach(c -> ((AbstractMod)\u0000nunyaboolean.catch.for.short.break.this.implements(c)).toggle());
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
        if (this.getClass().isAnnotationPresent(\u0000nunyaboolean.catch.for.finally.do.this.class)) {
            return this.getClass().getAnnotation(\u0000nunyaboolean.catch.for.finally.do.this.class).value();
        }
        return null;
    }

    protected void registerEvents(boolean flag) {
        if (!this.manageBusRegistration) {
            return;
        }
        if (flag) {
            EventBus.registerClass(this.getClass(), (Object)this, (event, listener) -> listener.setExceptionHandler(this::onCrash));
        } else {
            EventBus.unRegisterClass(this.getClass());
        }
    }

    protected void onCrash(Throwable cause) {
        logger.error("Module {} in category {} (state: {})", new Object[]{this.for(), this.getCategory().name(), this.enabled ? "enabled" : "disabled"});
        try {
            \u0000nunyaboolean.catch.for.finally.break.this.implements(this);
        }
        catch (Throwable ex) {
            logger.error("An error occurred when serializing settings in mod \"{}\"", new Object[]{this.for(), ex});
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson((JsonElement)this.modProps);
        logger.info("Properties {}", new Object[]{json});
        \u0000nunyaboolean.catch.for.continue.do.byte().implements("An error occurred").implements(new String[]{"See the logs for more information"}).implements();
        \u0000nunyaboolean.catch.for.continue.do.byte().implements("An error occurred in " + this.for(), "Report this to us in our aristois.net/guilded", "More information is available in the latest.log file").long();
    }

    public String getDisplayMode() {
        if (this.mode != null) {
            return this.mode.static();
        }
        return null;
    }

    public String getDisplayName() {
        if (this.betaVersion) {
            return this.for() + " (Beta)";
        }
        return this.for();
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

    public void onSettingUpdate(native setting) {
    }

    public void setModProps(JsonObject modProps) {
        this.modProps = modProps;
    }

    public void setMode(enum<?> mode) {
        this.mode = mode;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setKeybind(break keybind) {
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

    public Collection<\u0000nunyaboolean.catch.for.finally.case.this<?>> getFields() {
        return this.fields;
    }

    public JsonObject getModProps() {
        return this.modProps;
    }

    public enum<?> getMode() {
        return this.mode;
    }

    public do getCategory() {
        return this.category;
    }

    @Override
    public String for() {
        return this.name;
    }

    public String[] getDescription() {
        return this.description;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public break getKeybind() {
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

