package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0126 implements C0131<MinecraftIdentifier> {
   public C0126() {
   }

   public void m_d6749dd4(JsonWriter var1, MinecraftIdentifier var2) throws IOException {
      throw new RuntimeException(C0252.bootstrap<"get",12884901998>());
   }

   public MinecraftIdentifier m_fa34b148(JsonReader var1) throws IOException {
      return new MinecraftIdentifier((String)this.m_6b9b1074(var1, JsonReader::nextString));
   }

   public List<Class<? extends MinecraftIdentifier>> m_93a15f68() {
      return C0114.bootstrap<"call",0,1>(MinecraftIdentifier.class);
   }
}
