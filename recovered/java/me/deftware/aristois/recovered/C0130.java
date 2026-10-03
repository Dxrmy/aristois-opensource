package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;

public class C0130 implements C0131<AbstractMod> {
   public C0130() {
   }

   public void m_7760b2de(JsonWriter var1, AbstractMod var2) throws IOException {
      var1.name(C0252.bootstrap<"get",8589934598>());
      var1.value(var2.getModID());
   }

   public AbstractMod m_23597a93(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      String var3 = var1.nextString();
      return C0289.f_c22b8d7e
         .m_ea73e1f0()
         .filter(var1x -> var1x.getModID().equals(var3))
         .findFirst()
         .orElseThrow(() -> new IOException(C0252.bootstrap<"get",12884901990>() + var3));
   }

   public List<Class<? extends AbstractMod>> m_dd02b404() {
      return C0114.bootstrap<"call",0,1>(AbstractMod.class);
   }
}
