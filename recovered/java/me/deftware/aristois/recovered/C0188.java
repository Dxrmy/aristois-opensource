package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Label;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.Message;

public abstract class C0188<T extends ListItem> extends C0150 {
   protected final List<T> f_18c6e06f;
   protected C0161<T> f_1d8ec2c9;
   protected int f_15585be0 = 300;
   protected int f_751e4f27 = 30;
   protected int f_b28b243a = 220;
   protected int f_ca02e04a = -1;
   protected int f_cb8ccdd5 = 36;
   private Function<T, Boolean> f_0d4a9be3;
   protected boolean f_6721fec9 = false;
   protected boolean f_a451d159 = true;
   protected String f_3dd96e1d;

   public C0188(GenericScreen var1, List<T> var2) {
      super(var1);
      this.f_18c6e06f = var2;
   }

   @Override
   protected void m_1058ed9a() {
      C0155[] var1 = this.m_da527608();
      byte var2 = 5;
      int var3 = Arrays.stream(var1).mapToInt(var0 -> (int)var0.m_44bb072f().m_d42f3372()).sum() + var2 * var1.length;
      this.getMinecraftScreen()
         .addScreenComponent(
            this.f_1d8ec2c9 = new C0161<T>(
               this.f_18c6e06f, this.getGuiScreenWidth(), this.getGuiScreenHeight(), this.f_cb8ccdd5, this.getGuiScreenHeight() - var3 - var2, this.f_751e4f27
            ) {
               @Override
               protected void m_21355db3(T var1) {
                  C0188.this.m_28f4b7eb(this.getSelectedItem());
               }

               protected void onDrawItem(T var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9) {
                  C0188.this.m_9dfc6493(var1, var2, var3, var4, var5, var6, var7, var8, var9);
               }
            },
            0
         );
      this.f_3a3757f5.add(0, this.f_1d8ec2c9);
      if (this.f_6721fec9) {
         this.f_1d8ec2c9.setExtended(true);
      }

      int var4 = var2;

      for (C0155 var8 : var1) {
         var8.m_44bb072f().m_6fd9bdae((double)this.f_15585be0);
         var8.m_44bb072f().m_f8b16cfb((double)((float)getScaledWidth() / 2.0F), (double)(getScaledHeight() - var4) - var8.m_44bb072f().m_d42f3372());
         this.m_4f7d4126(new C0163[]{var8});
         var4 = (int)((double)var4 + (double)var2 + var8.m_44bb072f().m_d42f3372());
      }

      if (var1.length == 0) {
         this.m_fd4438d8();
      }

      if (this.f_a451d159) {
         C0154 var9 = this.m_79273652(getScaledWidth() - 30, 10, 20.0F, Message.of(C0253.m_b0896de7()), () -> {
            this.m_f83a21aa().clear();
            this.m_e02771ba();
         }).m_798462fc(() -> !this.m_f83a21aa().isEmpty());
         var9.m_c7a3618c(new C0153(var9, Message.of(C0261.m_a004d745())));
         this.m_4f7d4126(new C0163[]{var9});
         List var11 = this.m_f83a21aa();
         if (var11 instanceof C0219 && !((C0219)var11).m_a2a4e197().isEmpty()) {
            C0154 var12 = this.m_79273652(getScaledWidth() - 55, 10, 20.0F, Message.of(C0261.m_3c19a819()), () -> {
               ((C0219)var11).m_41e83f88();
               this.m_e02771ba();
            });
            var12.m_c7a3618c(new C0153(var12, Message.of(C0261.m_f599ae93())));
            this.m_4f7d4126(new C0163[]{var12});
         }
      }

      Label var10 = new Label(getScaledWidth() / 2 - FontRenderer.getStringWidth(this.f_3dd96e1d) / 2, 15, new Message[]{Message.of(this.f_3dd96e1d)});
      var10._setTooltip(new Message[]{Message.of(C0261.m_5b2d5cb2())});
      this.addComponent(var10);
   }

   @Override
   protected void m_fd4438d8() {
      this.m_4f7d4126(new C0163[]{this.m_79273652(10, 10, 20.0F, Message.of(C0261.m_56cd5284()), this::goBack)});
   }

   protected void m_e02771ba() {
   }

   protected List<T> m_f83a21aa() {
      return this.f_18c6e06f;
   }

   @Override
   protected boolean onKeyPressed(int var1, int var2, int var3) {
      if (var1 == 261) {
         this.m_1764cd79(null);
         return true;
      } else if (var1 == 257 && this.m_51ce03a5()) {
         this.m_28f4b7eb(this.m_cee5fd5a());
         return true;
      } else {
         return super.onKeyPressed(var1, var2, var3);
      }
   }

   protected T m_1764cd79(C0154 var1) {
      if (!this.m_51ce03a5()) {
         return null;
      } else {
         ListItem var2 = this.m_cee5fd5a();
         this.m_f83a21aa().remove(var2);
         return (T)var2;
      }
   }

   protected void m_28f4b7eb(T var1) {
      if (this.f_0d4a9be3 != null && this.f_0d4a9be3.apply((T)var1)) {
         this.goBack();
      }
   }

   protected boolean m_51ce03a5() {
      return this.f_1d8ec2c9 != null && this.f_1d8ec2c9.getSelectedItem() != null;
   }

   protected T m_cee5fd5a() {
      return (T)this.f_1d8ec2c9.getSelectedItem();
   }

   protected C0155[] m_da527608() {
      return new C0155[0];
   }

   public C0188<T> m_173e187f(Function<T, Boolean> var1) {
      this.f_0d4a9be3 = var1;
      return this;
   }

   protected void m_9dfc6493(T var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9) {
   }

   public List<T> m_a2a4e197() {
      return this.f_18c6e06f;
   }

   public C0161<T> m_45ccaa2b() {
      return this.f_1d8ec2c9;
   }

   public int m_d612baa8() {
      return this.f_15585be0;
   }

   public int m_eb304949() {
      return this.f_751e4f27;
   }

   public int m_b8bdb7ac() {
      return this.f_b28b243a;
   }

   public int m_4a4817b8() {
      return this.f_ca02e04a;
   }

   public int m_32f05cf1() {
      return this.f_cb8ccdd5;
   }

   @Override
   public void m_d6ac7420(boolean var1) {
      this.f_6721fec9 = var1;
   }

   public void m_394ecb95(boolean var1) {
      this.f_a451d159 = var1;
   }
}
