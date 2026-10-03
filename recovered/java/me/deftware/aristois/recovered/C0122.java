package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import me.deftware.client.framework.message.Message;

public class C0122 implements C0131<Message> {
   public C0122() {
   }

   public void m_81e8336b(JsonWriter var1, Message var2) throws IOException {
      var1.name(C0266.m_1d87ef21());
      var1.value(var2.toString());
   }

   public Message m_98c5b9c6(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      return Message.of(var1.nextString());
   }

   @Override
   public List<Class<? extends Message>> m_350b5ae0() {
      return Arrays.asList(Message.class);
   }
}
