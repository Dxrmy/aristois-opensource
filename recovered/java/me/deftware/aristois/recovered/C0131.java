package me.deftware.aristois.recovered;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

public interface C0131<T> {
   void m_1d7f9f2e(JsonWriter var1, T var2) throws IOException;

   T m_f4682dd5(JsonReader var1) throws IOException;

   List<Class<? extends T>> m_350b5ae0();

   default <E> E m_17c69234(JsonReader var1, C0131.anonymousgoto<JsonReader, E> var2) throws IOException {
      var1.nextName();
      return (E)var2.m_8c218980(var1);
   }

   default <E> void m_591bd658(JsonWriter var1, String var2, E var3, C0131.anonymousimplements<JsonWriter, E> var4) throws IOException {
      var1.name(var2);
      var4.m_9e3f3b44(var1, var3);
   }

   default TypeAdapter<T> m_0d09ee39() {
      return new TypeAdapter<T>() {
         public void write(JsonWriter var1, T var2) throws IOException {
            var1.beginObject();
            C0131.this.m_1d7f9f2e(var1, var2);
            var1.endObject();
         }

         public T read(JsonReader var1) throws IOException {
            var1.beginObject();
            Object var2 = C0131.this.m_f4682dd5(var1);
            var1.endObject();
            return (T)var2;
         }
      };
   }

   @FunctionalInterface
   public interface anonymousgoto<T, R> {
      R m_8c218980(T var1) throws IOException;
   }

   @FunctionalInterface
   public interface anonymousimplements<T, U> {
      void m_9e3f3b44(T var1, U var2) throws IOException;
   }
}
