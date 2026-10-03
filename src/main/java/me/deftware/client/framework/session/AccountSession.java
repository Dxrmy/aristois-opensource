/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.Environment
 *  com.mojang.authlib.minecraft.MinecraftSessionService
 *  com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService
 *  com.mojang.authlib.yggdrasil.YggdrasilEnvironment
 *  lombok.Generated
 *  net.minecraft.client.session.Session
 *  net.minecraft.client.session.Session$AccountType
 *  org.apache.commons.lang3.NotImplementedException
 */
package me.deftware.client.framework.session;

import com.mojang.authlib.Environment;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilEnvironment;
import java.net.Proxy;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.Generated;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.session.AccountType;
import me.deftware.client.framework.session.AuthEnvironment;
import net.minecraft.client.session.Session;
import org.apache.commons.lang3.NotImplementedException;

public class AccountSession {
    private class_320.class_321 type = class_320.class_321.field_1988;
    private final Environment environment;
    private final String clientId = UUID.randomUUID().toString();
    private class_320 session;
    private final YggdrasilAuthenticationService authenticationService;

    private AccountSession(Environment environment) {
        this.environment = environment;
        this.authenticationService = new YggdrasilAuthenticationService(Proxy.NO_PROXY, environment);
    }

    public AccountSession(AuthEnvironment environment) {
        this(environment == null ? YggdrasilEnvironment.PROD.getEnvironment() : environment.build());
    }

    public AccountSession withCredentials(String username, String password) throws Exception {
        throw new NotImplementedException("Credentials are no longer supported");
    }

    public AccountSession withOfflineUsername(String username) {
        this.type = class_320.class_321.field_1990;
        UUID uuid = UUID.randomUUID();
        this.session = new class_320(username, uuid, "0", Optional.empty(), Optional.of(this.clientId), this.type);
        System.out.println("Assigning UUID " + String.valueOf(uuid));
        return this;
    }

    public AccountSession withSession(Map<String, Object> map, AccountType accountType) {
        this.type = accountType.getType();
        this.session = new class_320(map.get("username").toString(), AccountSession.uuidFromString(map.get("uuid").toString()), map.get("accessToken").toString(), Optional.of(map.getOrDefault("xuid", "").toString()), Optional.of(this.clientId), this.type);
        return this;
    }

    public boolean isSessionAvailable() {
        return this.session != null;
    }

    public String getSessionUsername() {
        return this.session.method_1676();
    }

    public UUID getSessionUUID() {
        return this.session.method_44717();
    }

    public MinecraftSessionService getSessionService() {
        return this.authenticationService.createMinecraftSessionService();
    }

    public YggdrasilAuthenticationService getAuthenticationService() {
        return this.authenticationService;
    }

    @Deprecated
    public AccountSession setSession() {
        Minecraft.getMinecraftGame().setSession(this);
        return this;
    }

    public static UUID uuidFromString(String uuid) {
        if (uuid.contains("-")) {
            return UUID.fromString(uuid);
        }
        return UUID.fromString(uuid.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
    }

    @Generated
    public class_320 getSession() {
        return this.session;
    }
}

