/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.registry;

import java.util.Optional;
import java.util.stream.Stream;
import me.deftware.client.framework.registry.Identifiable;

public interface IRegistry<Type, InternalType> {
    public Optional<Type> find(String var1);

    public Stream<Type> stream();

    default public void register(String id, InternalType object) {
        throw new RuntimeException("Not implemented");
    }

    public static interface IdentifiableRegistry<T extends Identifiable, I>
    extends IRegistry<T, I> {
        @Override
        default public Optional<T> find(String id) {
            return this.stream().filter(i -> i.getTranslationKey().equalsIgnoreCase(id) || i.getIdentifierKey().equalsIgnoreCase(id)).findFirst();
        }
    }
}

