package me.deftware.aristois.recovered;

import java.util.concurrent.Callable;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.network.PacketRegistry;
import me.deftware.client.framework.network.SocksProxy;

public abstract class C0144 implements SocksProxy, ListItem {
   private C0144.anonymouscatch f_000ee492 = C0144.anonymouscatch.f_95e9f7f0;
   protected Message f_c1a51e3e = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",51539607654>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GRAY));
   private boolean f_56543fe3;
   private boolean f_3e5a89e9;
   private long f_aac0489e;
   private Message[] f_ba00399b;

   public C0144() {
   }

   public synchronized void m_4a859b77() {
      if (!this.f_56543fe3) {
         this.f_56543fe3 = true;
         if (C0213.f_57699eb8.m_093ae25a()) {
            C0114.bootstrap<"call",0,1>(
               () -> {
                  try {
                     this.m_280fdfbd(
                        () -> C0114.bootstrap<"call",0,1>(this.getSocketAddress().getAddress().isReachable(1000)),
                        C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",51539607662>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.RED))
                     );
                  } catch (Exception var2) {
                     this.f_c1a51e3e = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",51539607663>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.RED));
                  }
               }
            );
         } else {
            this.f_3e5a89e9 = true;
            this.f_c1a51e3e = C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",51539607655>()).style(C0114.bootstrap<"call",2,1>(DefaultColors.LIGHT_PURPLE));
         }
      }
   }

   public FormattingColor m_ff08f2fd(int var1) {
      DefaultColors var2;
      if (var1 <= 75) {
         var2 = DefaultColors.DARK_GREEN;
      } else if (var1 <= 120) {
         var2 = DefaultColors.GREEN;
      } else if (var1 <= 200) {
         var2 = DefaultColors.YELLOW;
      } else {
         var2 = DefaultColors.GOLD;
      }

      return var2;
   }

   public boolean m_1d4a5421() {
      SocksProxy var1 = PacketRegistry.INSTANCE.getProxy();
      return var1 != null && var1.equals(this);
   }

   public FormattingColor m_cb738fbb() {
      return this.m_1d4a5421() ? DefaultColors.GREEN : DefaultColors.WHITE;
   }

   public boolean m_ef4d96d1() {
      try {
         if (this.m_7a7c753e()) {
            if (C0114.bootstrap<"call",0,1>()) {
               this.f_000ee492 = C0144.anonymouscatch.f_cb43324d;
            }

            if (this.f_000ee492 == C0144.anonymouscatch.f_95e9f7f0) {
               this.f_c1a51e3e = C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836506>()).style(C0114.bootstrap<"call",2,1>(DefaultColors.YELLOW));
               this.m_280fdfbd(
                  () -> {
                     C0140 var1 = new C0139(C0252.bootstrap<"get",51539607659>()).m_5d950b0b(this).m_244f5552();
                     if (var1.m_9781181b()) {
                        this.f_000ee492 = C0144.anonymouscatch.f_cb43324d;
                        return C0114.bootstrap<"call",0,1>(true);
                     } else {
                        this.f_000ee492 = C0144.anonymouscatch.f_72be8fc5;
                        this.f_ba00399b = new Message[]{
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",51539607660>()), C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",51539607661>())
                        };
                        return C0114.bootstrap<"call",0,1>(false);
                     }
                  },
                  C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",51539607656>()).style(C0114.bootstrap<"call",2,1>(DefaultColors.RED))
               );
            }

            if (this.f_000ee492 == C0144.anonymouscatch.f_cb43324d) {
               PacketRegistry.INSTANCE.setProxy(this);
               return true;
            }
         }

         return false;
      } catch (Throwable var2) {
         throw var2;
      }
   }

   private void m_280fdfbd(Callable<Boolean> var1, Message var2) throws Exception {
      long var3 = C0114.bootstrap<"call",0,1>();
      boolean var5 = (Boolean)var1.call();
      this.f_aac0489e = C0114.bootstrap<"call",0,1>() - var3;
      if (var5) {
         this.f_c1a51e3e = C0114.bootstrap<"call",3,1>(
               C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",51539607657>(), new Object[]{C0114.bootstrap<"call",1,1>(this.f_aac0489e)})
            )
            .style(C0114.bootstrap<"call",4,1>(this.m_ff08f2fd((int)this.f_aac0489e)));
         this.f_3e5a89e9 = true;
      } else {
         this.f_c1a51e3e = var2;
      }
   }

   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      var3 += 4;
      this.m_6ca3d1b3(
         true,
         var2 + var4 - 18,
         var3,
         this.f_c1a51e3e,
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",51539607658>() + this.getVersion()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GRAY))
      );
      this.m_6ca3d1b3(false, var2 - 4, var3, this.m_70bc12d7());
   }

   protected void m_6ca3d1b3(boolean var1, int var2, int var3, Message... var4) {
      for (Message var8 : var4) {
         int var9 = var2;
         if (var1) {
            var9 = var2 - C0114.bootstrap<"call",5,1>(var8);
         }

         C0114.bootstrap<"call",6,1>(var8, var9, var3, 16777215);
         var3 += C0114.bootstrap<"call",7,1>();
      }
   }

   public Message[] getTooltip() {
      return this.f_ba00399b;
   }

   protected Message[] m_70bc12d7() {
      return new Message[]{C0114.bootstrap<"call",3,1>(this.getAddress())};
   }

   public C0144.anonymouscatch m_c549f31b() {
      return this.f_000ee492;
   }

   public Message m_a4c3163e() {
      return this.f_c1a51e3e;
   }

   public boolean m_d7729356() {
      return this.f_56543fe3;
   }

   public boolean m_7a7c753e() {
      return this.f_3e5a89e9;
   }

   public long m_32de56e9() {
      return this.f_aac0489e;
   }

   public void m_d851d56e(C0144.anonymouscatch var1) {
      this.f_000ee492 = var1;
   }

   public void m_269116b4(Message var1) {
      this.f_c1a51e3e = var1;
   }

   public void m_d9b33be5(boolean var1) {
      this.f_56543fe3 = var1;
   }

   public void m_4603032c(boolean var1) {
      this.f_3e5a89e9 = var1;
   }

   public void m_c4fe65eb(long var1) {
      this.f_aac0489e = var1;
   }

   public void m_e4840076(Message[] var1) {
      this.f_ba00399b = var1;
   }

   public static enum anonymouscatch {
      f_95e9f7f0,
      f_72be8fc5,
      f_cb43324d;

      private anonymouscatch() {
      }
   }
}
