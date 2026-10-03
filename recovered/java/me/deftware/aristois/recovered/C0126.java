package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0126 implements C0131<MinecraftIdentifier> {
   public C0126() {
   }

   public void m_f3a9d6b8(JsonWriter var1, MinecraftIdentifier var2) throws IOException {
      throw new RuntimeException(C0266.m_1472ab32());
   }

   public MinecraftIdentifier m_7c04d7f4(JsonReader var1) throws IOException {
      return new MinecraftIdentifier(this.m_17c69234(var1, JsonReader::nextString));
   }

   @Override
   public List<Class<? extends MinecraftIdentifier>> m_350b5ae0() {
      return Collections.singletonList(MinecraftIdentifier.class);
   }
}
