package me.deftware.aristois.recovered;

import java.util.List;
import java.util.function.Function;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Label;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.Message;

public abstract class C0188<T extends ListItem> extends C0150 {
   protected final List<T> f_c7cdd49e;
   protected C0161<T> f_52eda0c6;
   protected int f_1273229b = 300;
   protected int f_b44be940 = 30;
   protected int f_9b9f0cdd = 220;
   protected int f_d665c955 = -1;
   protected int f_7535ce64 = 36;
   private Function<T, Boolean> f_efe9d2fd;
   protected boolean f_60c2062d = false;
   protected boolean f_e0e0e5bf = true;
   protected String f_4e844a98;

   public C0188(GenericScreen var1, List<T> var2) {
      super(var1);
      this.f_c7cdd49e = var2;
   }

   protected void m_295487ee() {
      C0155[] var1 = this.m_1aa7f5b0();
      byte var2 = 5;
      int var3 = C0114.bootstrap<"call",0,1>(var1).mapToInt(var0 -> (int)var0.m_37294eec().m_fc7f45bc()).sum() + var2 * var1.length;
      this.getMinecraftScreen()
         .addScreenComponent(
            this.f_52eda0c6 = new C0161<T>(
               this.f_c7cdd49e, this.getGuiScreenWidth(), this.getGuiScreenHeight(), this.f_7535ce64, this.getGuiScreenHeight() - var3 - var2, this.f_b44be940
            ) {
               protected void m_cb1ef5ac(T var1) {
                  C0188.this.m_38783977(this.getSelectedItem());
               }

               protected void onDrawItem(T var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9) {
                  C0188.this.m_8d215945(var1, var2, var3, var4, var5, var6, var7, var8, var9);
               }
            },
            0
         );
      this.f_015ea338.add(0, this.f_52eda0c6);
      if (this.f_60c2062d) {
         this.f_52eda0c6.setExtended(true);
      }

      int var4 = var2;

      for (C0155 var8 : var1) {
         var8.m_37294eec().m_b9e3750e((double)this.f_1273229b);
         var8.m_37294eec()
            .m_1e49f000((double)((float)C0114.bootstrap<"call",1,1>() / 2.0F), (double)(C0114.bootstrap<"call",2,1>() - var4) - var8.m_37294eec().m_fc7f45bc());
         this.m_8a1648be(new C0163[]{var8});
         var4 = (int)((double)var4 + (double)var2 + var8.m_37294eec().m_fc7f45bc());
      }

      if (var1.length == 0) {
         this.m_0b3aacd7();
      }

      if (this.f_e0e0e5bf) {
         C0154 var9 = this.m_2ecd54a0(C0114.bootstrap<"call",1,1>() - 30, 10, 20.0F, C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",8589934661>()), () -> {
            this.m_fb7fc376().clear();
            this.m_0293fd8c();
         }).m_dc08502f(() -> C0114.bootstrap<"call",0,1>(!this.m_fb7fc376().isEmpty()));
         var9.m_ca06ea23(new C0153(var9, C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",17179869302>())));
         this.m_8a1648be(new C0163[]{var9});
         List var11 = this.m_fb7fc376();
         if (var11 instanceof C0219 && !((C0219)var11).m_c831055d().isEmpty()) {
            C0154 var12 = this.m_2ecd54a0(
               C0114.bootstrap<"call",1,1>() - 55, 10, 20.0F, C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",17179869303>()), () -> {
                  ((C0219)var11).m_62c96cfe();
                  this.m_0293fd8c();
               }
            );
            var12.m_ca06ea23(new C0153(var12, C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",17179869304>())));
            this.m_8a1648be(new C0163[]{var12});
         }
      }

      Label var10 = new Label(
         C0114.bootstrap<"call",1,1>() / 2 - C0114.bootstrap<"call",4,1>(this.f_4e844a98) / 2, 15, new Message[]{C0114.bootstrap<"call",3,1>(this.f_4e844a98)}
      );
      var10._setTooltip(new Message[]{C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",17179869305>())});
      this.addComponent(var10);
   }

   protected void m_0b3aacd7() {
      this.m_8a1648be(new C0163[]{this.m_2ecd54a0(10, 10, 20.0F, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869306>()), this::goBack)});
   }

   protected void m_0293fd8c() {
   }

   protected List<T> m_fb7fc376() {
      return this.f_c7cdd49e;
   }

   @Override
   protected boolean onKeyPressed(int var1, int var2, int var3) {
      if (var1 == 261) {
         this.m_e0dbe97c(null);
         return true;
      } else if (var1 == 257 && this.m_3c15851a()) {
         this.m_38783977(this.m_6a131d4d());
         return true;
      } else {
         return super.onKeyPressed(var1, var2, var3);
      }
   }

   protected T m_e0dbe97c(C0154 var1) {
      if (!this.m_3c15851a()) {
         return null;
      } else {
         ListItem var2 = this.m_6a131d4d();
         this.m_fb7fc376().remove(var2);
         return (T)var2;
      }
   }

   protected void m_38783977(T var1) {
      if (this.f_efe9d2fd != null && this.f_efe9d2fd.apply((T)var1)) {
         this.goBack();
      }
   }

   protected boolean m_3c15851a() {
      return this.f_52eda0c6 != null && this.f_52eda0c6.getSelectedItem() != null;
   }

   protected T m_6a131d4d() {
      return (T)this.f_52eda0c6.getSelectedItem();
   }

   protected C0155[] m_1aa7f5b0() {
      return new C0155[0];
   }

   public C0188<T> m_8f78f9ba(Function<T, Boolean> var1) {
      this.f_efe9d2fd = var1;
      return this;
   }

   protected void m_8d215945(T var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9) {
   }

   public List<T> m_d29dfa3d() {
      return this.f_c7cdd49e;
   }

   public C0161<T> m_870af1ab() {
      return this.f_52eda0c6;
   }

   public int m_3eff62c1() {
      return this.f_1273229b;
   }

   public int m_317c671d() {
      return this.f_b44be940;
   }

   public int m_bf9186eb() {
      return this.f_9b9f0cdd;
   }

   public int m_b04bff0c() {
      return this.f_d665c955;
   }

   public int m_02e6ce86() {
      return this.f_7535ce64;
   }

   public void m_32fa6fd5(boolean var1) {
      this.f_60c2062d = var1;
   }

   public void m_5b15fb3c(boolean var1) {
      this.f_e0e0e5bf = var1;
   }
}
