/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.handler.proxy.ProxyHandler
 *  io.netty.handler.proxy.Socks4ProxyHandler
 *  io.netty.handler.proxy.Socks5ProxyHandler
 *  org.apache.commons.lang3.StringUtils
 */
package me.deftware.client.framework.network;

import io.netty.handler.proxy.ProxyHandler;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.handler.proxy.Socks5ProxyHandler;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import org.apache.commons.lang3.StringUtils;

public interface SocksProxy {
    public String getUsername();

    public String getPassword();

    public String getAddress();

    default public InetSocketAddress getSocketAddress() {
        if (this.getAddress().contains(":")) {
            String[] data = this.getAddress().split(":");
            return new InetSocketAddress(data[0], Integer.parseInt(data[1]));
        }
        return new InetSocketAddress(this.getAddress(), 1080);
    }

    default public int getVersion() {
        return StringUtils.isEmpty((CharSequence)this.getPassword()) ? 4 : 5;
    }

    default public ProxyHandler getProxyHandler() {
        if (this.getVersion() == 4) {
            return new Socks4ProxyHandler((SocketAddress)this.getSocketAddress(), this.getUsername());
        }
        return new Socks5ProxyHandler((SocketAddress)this.getSocketAddress(), this.getUsername(), this.getPassword());
    }
}

