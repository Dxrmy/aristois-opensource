package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;
import me.deftware.client.framework.message.Message;

public class C0122 implements C0131<Message> {
   public C0122() {
   }

   public void m_26841e76(JsonWriter var1, Message var2) throws IOException {
      var1.name(C0252.bootstrap<"get",12884901897>());
      var1.value(var2.toString());
   }

   public Message m_9ba85395(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      return C0114.bootstrap<"call",0,1>(var1.nextString());
   }

   public List<Class<? extends Message>> m_6584c80e() {
      return C0114.bootstrap<"call",1,1>(new Class[]{Message.class});
   }
}
