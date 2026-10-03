package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;

public class C0120 implements C0112<File> {
   public C0120() {
   }

   public List<Class<? extends File>> m_63bfd1b2() {
      return C0114.bootstrap<"call",0,1>(File.class);
   }

   public C0163 m_8326241f(final C0094<File> var1, ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(C0114.bootstrap<"call",1,1>(var1.m_b5ae4ee3()), var2.m_0826645c()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               C0120.this.m_1ee30e83(var1);
            }
         }
      };
      var4.m_e61ee212(new C0426[]{C0426.f_974a55e6});
      return var4;
   }

   public C0131<File> m_5436514f() {
      return new C0131<File>() {
         public void m_7e3598c9(JsonWriter var1, File var2) throws IOException {
            this.m_c8e91f87(var1, C0252.bootstrap<"get",12884902014>(), var2.getAbsolutePath(), JsonWriter::value);
         }

         public File m_2f01b150(JsonReader var1) throws IOException {
            return new File((String)this.m_fe52f04f(var1, JsonReader::nextString));
         }

         public List<Class<? extends File>> m_a63de11b() {
            return C0120.this.m_63bfd1b2();
         }
      };
   }

   public File m_50c9866d(String var1) {
      return new File(var1);
   }

   public void m_1ee30e83(C0094<?> var1) {
      C0097 var2 = var1.m_d69df528(C0097.class);
      C0216 var3 = new C0216(var2.title(), var2.description(), var2.filters());
      var3.m_b8b58442().ifPresent(var1x -> var1.m_dfb23874(var1x.toFile(), true));
   }
}
