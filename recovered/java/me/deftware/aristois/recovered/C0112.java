package me.deftware.aristois.recovered;

import com.google.gson.JsonElement;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.lang.reflect.Field;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.modules.AbstractMod;

public interface C0112<T> {
   List<Class<? extends T>> m_5193ef3f();

   C0163 m_f0b57b5f(C0094<T> var1, ContainerWidget var2, boolean var3);

   default boolean m_6f890b01(Field var1) {
      return C0114.bootstrap<"call",0,1>(var1.getModifiers());
   }

   default boolean m_d6533f43(Class<?> var1) {
      return this.m_5193ef3f().contains(var1);
   }

   default C0094<T> m_4a9e8100(Field var1, Object var2) throws Exception {
      return new C0094<>(var1, var2, this);
   }

   default C0131<T> m_2ca84ea7() {
      return null;
   }

   default void m_b653ae1c(JsonElement var1, C0094<?> var2, AbstractMod var3) throws Exception {
      var2.m_dfb23874(C0125.f_70947d4f.m_5f630fc1(var1, var2.m_3ed0dd7b()), false);
   }

   default JsonElement m_ef56e17c(C0094<?> var1) throws Exception {
      return C0125.f_70947d4f.m_77b61bf9(var1.m_48b16e97(), var1.m_3ed0dd7b());
   }

   default T m_e0edf214(String var1) {
      return null;
   }

   default void m_6ed4f004(C0094<?> var1) {
   }

   default void m_3c9d7daa(SuggestionsBuilder var1) {
   }
}
