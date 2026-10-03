package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.awt.Color;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class C0132 implements C0131<Color> {
   public C0132() {
   }

   public void m_cc6e2bf7(JsonWriter var1, Color var2) throws IOException {
      var1.name(C0266.m_e07cee76());
      var1.value((long)var2.getRGB());
      var1.name(C0266.m_4cbaf16f());
      var1.value(0.0);
   }

   public Color m_66c2b984(JsonReader var1) throws IOException {
      var1.nextName();
      Color var2 = new Color(var1.nextInt(), true);

      while (var1.hasNext()) {
         String var3 = var1.nextName();
         if (var3.equalsIgnoreCase(C0266.m_4cbaf16f())) {
            var1.nextDouble();
         }

         if (var3.equalsIgnoreCase(C0266.m_678c4ddb()) || var3.equalsIgnoreCase(C0266.m_1672ac4d())) {
            var1.beginArray();
            var1.nextDouble();
            var1.nextDouble();
            var1.nextDouble();
            var1.endArray();
         }
      }

      return var2;
   }

   @Override
   public List<Class<? extends Color>> m_350b5ae0() {
      return Collections.singletonList(Color.class);
   }
}
