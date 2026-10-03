package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;

public class C0120 implements C0112<File> {
   public C0120() {
   }

   @Override
   public List<Class<? extends File>> m_350b5ae0() {
      return Collections.singletonList(File.class);
   }

   @Override
   public C0163 m_5f0a4ee5(final C0094<File> var1, ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(Message.of(var1.m_6f1f396d()), var2.m_519f75ae()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               C0120.this.m_b9cf1f73(var1);
            }
         }
      };
      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      return var4;
   }

   @Override
   public C0131<File> m_99099edb() {
      return new C0131<File>() {
         public void m_38bd4c02(JsonWriter var1, File var2) throws IOException {
            this.m_591bd658(var1, C0266.m_56c1229f(), var2.getAbsolutePath(), JsonWriter::value);
         }

         public File m_e4316175(JsonReader var1) throws IOException {
            return new File(this.m_17c69234(var1, JsonReader::nextString));
         }

         @Override
         public List<Class<? extends File>> m_350b5ae0() {
            return C0120.this.m_350b5ae0();
         }
      };
   }

   public File m_77add0fa(String var1) {
      return new File(var1);
   }

   @Override
   public void m_b9cf1f73(C0094<?> var1) {
      C0097 var2 = var1.m_04b86251(C0097.class);
      C0216 var3 = new C0216(var2.title(), var2.description(), var2.filters());
      var3.m_2684dcf7().ifPresent(var1x -> var1.m_9660fce8(var1x.toFile(), true));
   }
}
