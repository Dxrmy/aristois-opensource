/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.Environment
 */
package me.deftware.client.framework.session;

import com.mojang.authlib.Environment;
import java.util.StringJoiner;

public class AuthEnvironment {
    String authHost;
    String accountsHost;
    String sessionHost;

    public AuthEnvironment(String authHost, String accountsHost, String sessionHost) {
        this.authHost = authHost;
        this.accountsHost = accountsHost;
        this.sessionHost = sessionHost;
    }

    public String getServicesHost() {
        return "https://api.minecraftservices.com";
    }

    public String getAuthHost() {
        return this.authHost;
    }

    public String getAccountsHost() {
        return this.accountsHost;
    }

    public String getSessionHost() {
        return this.sessionHost;
    }

    public String getName() {
        return "PROD";
    }

    public String toString() {
        return new StringJoiner(", ", "", "").add("authHost='" + this.authHost + "'").add("accountsHost='" + this.accountsHost + "'").add("sessionHost='" + this.sessionHost + "'").add("servicesHost='" + this.getServicesHost() + "'").add("name='" + this.getName() + "'").toString();
    }

    public Environment build() {
        return new Environment(this.getSessionHost(), this.getServicesHost(), this.getName());
    }
}

