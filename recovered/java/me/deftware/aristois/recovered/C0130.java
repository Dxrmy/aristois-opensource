package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;

public class C0130 implements C0131<AbstractMod> {
   public C0130() {
   }

   public void m_e91a1049(JsonWriter var1, AbstractMod var2) throws IOException {
      var1.name(C0253.m_35cdaa1a());
      var1.value(var2.getModID());
   }

   public AbstractMod m_8e1d39c2(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      String var3 = var1.nextString();
      return C0289.f_85a7343f
         .m_918b7b9e()
         .filter(var1x -> var1x.getModID().equals(var3))
         .findFirst()
         .orElseThrow(() -> new IOException(C0266.m_bdbd5e40() + var3));
   }

   @Override
   public List<Class<? extends AbstractMod>> m_350b5ae0() {
      return Collections.singletonList(AbstractMod.class);
   }
}
