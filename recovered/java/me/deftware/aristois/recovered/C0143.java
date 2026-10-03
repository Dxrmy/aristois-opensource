package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.network.PacketRegistry;

public class C0143 {
   private static List<C0144> f_7090d8c0 = new ArrayList<>();

   public C0143() {
   }

   public static void m_31e73578() {
      C0140 var0 = new C0139(C0252.bootstrap<"get",51539607665>()).m_244f5552();
      if (var0.m_9781181b()) {
         f_7090d8c0 = new ArrayList<>(
            C0114.bootstrap<"call",1,1>(
               (Object[])C0114.bootstrap<"call",0,1>().create().fromJson(var0.m_fcc066b3().getAsJsonArray(C0252.bootstrap<"get",12884901996>()), C0145[].class)
            )
         );
      }
   }

   public static C0208<C0144> m_d45d8e48() {
      return new C0208<>(f_7090d8c0, C0144::m_7a7c753e).m_bb9d1924((var0, var1) -> (int)(var0.m_32de56e9() - var1.m_32de56e9()));
   }

   public static void m_d1885657(GenericScreen var0) {
      C0114.bootstrap<"call",2,1>()
         .runOnRenderThread(
            () -> {
               f_7090d8c0.forEach(C0144::m_4a859b77);
               C0114.bootstrap<"call",0,1>()
                  .openScreen(
                     (new C0174<C0144>(var0, C0114.bootstrap<"call",1,1>(), C0144.class, C0252.bootstrap<"get",51539607666>()) {
                           protected void m_b42bfd79() {
                              this.m_3429c32f(true);
                              super.m_4a76dabf();
                              this.m_49a08a8c();
                              this.m_269e478d(
                                 new C0163[]{
                                    (new C0154(
                                          this.getGuiScreenWidth() - 80 - 10, 10, 80, 20, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",51539607664>())
                                       ) {
                                          public boolean m_bb0f3387(int var1) {
                                             PacketRegistry.INSTANCE.setProxy(null);
                                             return true;
                                          }
                                       })
                                       .m_50c55ed9(() -> C0114.bootstrap<"call",0,1>(PacketRegistry.INSTANCE.getProxy() != null))
                                 }
                              );
                           }

                           protected void m_a090e3b5(C0144 var1) {
                              C0114.bootstrap<"call",1,1>(var1::m_ef4d96d1);
                           }

                           protected C0155[] m_565ab66f() {
                              return new C0155[0];
                           }
                        })
                        .m_2815ab43(false)
                  );
            }
         );
   }

   public static List<C0144> m_fa72ce65() {
      return f_7090d8c0;
   }
}
