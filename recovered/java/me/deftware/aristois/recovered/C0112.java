package me.deftware.aristois.recovered;

import com.google.gson.JsonElement;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.modules.AbstractMod;

public interface C0112<T> {
   List<Class<? extends T>> m_350b5ae0();

   C0163 m_5f0a4ee5(C0094<T> var1, ContainerWidget var2, boolean var3);

   default boolean m_986d2323(Field var1) {
      return Modifier.isFinal(var1.getModifiers());
   }

   default boolean m_210285cc(Class<?> var1) {
      return this.m_350b5ae0().contains(var1);
   }

   default C0094<T> m_6ba94131(Field var1, Object var2) throws Exception {
      return new C0094<>(var1, var2, this);
   }

   default C0131<T> m_99099edb() {
      return null;
   }

   default void m_6588d9db(JsonElement var1, C0094<?> var2, AbstractMod var3) throws Exception {
      var2.m_9660fce8(C0125.f_94eb86f7.m_b3b664ad(var1, var2.m_01d9ec36()), false);
   }

   default JsonElement m_695e59d3(C0094<?> var1) throws Exception {
      return C0125.f_94eb86f7.m_a7c6d791(var1.m_50ca8f08(), var1.m_01d9ec36());
   }

   default T m_b612bf41(String var1) {
      return null;
   }

   default void m_b9cf1f73(C0094<?> var1) {
   }

   default void m_44a89f72(SuggestionsBuilder var1) {
   }
}
