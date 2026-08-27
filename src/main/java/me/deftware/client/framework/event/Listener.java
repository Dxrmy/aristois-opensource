/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event;

import java.lang.reflect.Method;
import java.util.function.Consumer;
import me.deftware.client.framework.event.Event;

public class Listener {
    private final Method method;
    private final Object classInstance;
    private final int priority;
    private Consumer<Throwable> exceptionHandler;

    public Listener(Method method, Object classInstance, int priority) {
        this.method = method;
        this.classInstance = classInstance;
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

    public Object getClassInstance() {
        return this.classInstance;
    }

    public void invoke(Event event) throws Exception {
        this.method.invoke(this.getClassInstance(), event);
    }

    public Method getMethod() {
        return this.method;
    }

    public Consumer<Throwable> getExceptionHandler() {
        return this.exceptionHandler;
    }

    public void setExceptionHandler(Consumer<Throwable> exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }
}

