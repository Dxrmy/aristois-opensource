/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package me.deftware.client.framework.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.Listener;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.event.events.EventRender3D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EventBus {
    public static final EventBus INSTANCE = new EventBus();
    private final Map<Class<? extends Event>, Manager> managers = new HashMap<Class<? extends Event>, Manager>();
    private final Logger logger = LoggerFactory.getLogger(EventBus.class);
    private final Runnable abortRendering = () -> {};
    private final Map<Class<? extends Event>, Runnable> cleanupHandlers = Map.of(EventMatrixRender.class, this.abortRendering, EventRender3D.class, this.abortRendering, EventRender2D.class, this.abortRendering);

    public synchronized Manager getManager(Class<? extends Event> event) {
        if (!this.managers.containsKey(event)) {
            this.managers.put(event, new Manager());
        }
        return this.managers.get(event);
    }

    public void broadcast(Event event) {
        this.getManager(event.getClass()).broadcast(event);
    }

    public void registerClass(Object instance) {
        this.registerClass(instance, null);
    }

    public void registerClass(Object instance, Consumer<Throwable> exceptionHandler) {
        this.walkMethods(instance.getClass(), (event, handler, method) -> {
            Manager manager = this.getManager(event);
            Listener listener = new Listener(method, instance, handler.priority());
            listener.setExceptionHandler(exceptionHandler);
            manager.register(listener);
        });
    }

    public void unRegisterClass(Object instance) {
        this.walkMethods(instance.getClass(), (event, handler, method) -> {
            Manager manager = this.getManager(event);
            manager.unregister(instance, method);
        });
    }

    private void walkMethods(Class<?> clazz, EventMethod consumer) {
        while (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (!method.isAnnotationPresent(EventHandler.class)) continue;
                method.setAccessible(true);
                consumer.accept(method.getParameterTypes()[0].asSubclass(Event.class), method.getAnnotation(EventHandler.class), method);
            }
            clazz = clazz.getSuperclass();
        }
    }

    private final class Manager {
        private final List<Listener> listeners = new ArrayList<Listener>();

        private Manager() {
        }

        public synchronized void register(Listener listener) {
            this.listeners.add(listener);
            this.listeners.sort(Comparator.comparingInt(Listener::getPriority));
        }

        public synchronized void unregister(Object instance, Method method) {
            this.listeners.removeIf(listener -> listener.getClassInstance() == instance && listener.getMethod().equals(method));
        }

        public synchronized void broadcast(Event event) {
            Iterator<Listener> iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                Listener listener = iterator.next();
                try {
                    listener.invoke(event);
                }
                catch (Throwable ex) {
                    this.error(ex.getCause(), listener, event);
                    iterator.remove();
                }
            }
        }

        private void error(Throwable cause, Listener listener, Event event) {
            Class<?> clazz = listener.getClassInstance().getClass();
            EventBus.this.logger.error("\"{}\" occurred whilst dispatching \"{}\" to method \"{}\" in class \"{}\" due to \"{}\"", new Object[]{cause.getClass().getSimpleName(), event.getClass().getSimpleName(), listener.getMethod().getName(), clazz.getSimpleName(), cause.getMessage()});
            Consumer<Throwable> consumer = listener.getExceptionHandler();
            if (consumer != null) {
                consumer.accept(cause);
            }
            cause.printStackTrace();
            Runnable cleanup = EventBus.this.cleanupHandlers.get(event.getClass());
            if (cleanup != null) {
                cleanup.run();
            }
        }
    }

    @FunctionalInterface
    private static interface EventMethod {
        public void accept(Class<? extends Event> var1, EventHandler var2, Method var3);
    }
}

