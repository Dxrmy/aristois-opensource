/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventWeather
extends Event {
    private WeatherType type;

    public EventWeather(WeatherType type) {
        this.type = type;
    }

    public WeatherType getType() {
        return this.type;
    }

    public static enum WeatherType {
        Rain,
        RainSnow;

    }
}

