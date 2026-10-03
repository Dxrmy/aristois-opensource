package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.PacketRegistry;

public class C0143 {
   private static List<C0144> f_3038bea7 = new ArrayList<>();

   public C0143() {
   }

   public static void m_1058ed9a() {
      C0140 var0 = new C0139(C0255.m_09052c0b()).m_0017133f();
      if (var0.m_9362a920()) {
         f_3038bea7 = new ArrayList<>(
            Arrays.asList((Object[])C0198.m_cde2d310().create().fromJson(var0.m_f7ec0040().getAsJsonArray(C0266.m_e9a52709()), C0145[].class))
         );
      }
   }

   public static C0208<C0144> m_d8f834ee() {
      return new C0208<>(f_3038bea7, C0144::m_f21a055b).m_e9d9653a((var0, var1) -> (int)(var0.m_c495d695() - var1.m_c495d695()));
   }

   public static void m_a4e18580(GenericScreen var0) {
      Minecraft.getMinecraftGame().runOnRenderThread(() -> {
         f_3038bea7.forEach(C0144::m_b728afce);
         Minecraft.getMinecraftGame().openScreen((new C0174<C0144>(var0, m_d8f834ee(), C0144.class, C0255.m_023b99d9()) {
            @Override
            protected void m_1058ed9a() {
               this.m_d6ac7420(true);
               super.m_1058ed9a();
               this.m_fd4438d8();
               this.m_4f7d4126(new C0163[]{(new C0154(this.getGuiScreenWidth() - 80 - 10, 10, 80, 20, Message.of(C0255.m_a9b6ecd9())) {
                  @Override
                  public boolean m_1521b1fa(int var1) {
                     PacketRegistry.INSTANCE.setProxy(null);
                     return true;
                  }
               }).m_798462fc(() -> PacketRegistry.INSTANCE.getProxy() != null)});
            }

            protected void m_82b08f48(C0144 var1) {
               C0217.m_c162d659(var1::m_e606d819);
            }

            @Override
            protected C0155[] m_da527608() {
               return new C0155[0];
            }
         }).m_91e3b8ed(false));
      });
   }

   public static List<C0144> m_39057c01() {
      return f_3038bea7;
   }
}
