package me.deftware.aristois.recovered;

import java.util.function.Predicate;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.item.Item;

public class C0279 extends C0270<C0279> {
   protected boolean f_eefffdd8 = false;
   protected boolean f_3ed0c70a = false;
   protected boolean f_40c47446 = false;
   protected boolean f_e79d04e4 = true;
   protected int f_0c2c5e33;
   protected int f_6d5850aa = -1;
   protected final EntityPlayer f_f36bb679;
   private final Item f_dca3318d;
   protected Predicate<EntityPlayer> f_7946c088 = EntityPlayer::isUsingItem;

   public C0279(int var1, EntityPlayer var2) {
      this.f_40c47446 = var1 == 45;
      if (var1 > 8 && !this.f_40c47446) {
         throw new IllegalArgumentException(C0252.bootstrap<"get",55834574893>());
      } else {
         this.f_0c2c5e33 = var1;
         this.f_dca3318d = var2.getInventory().getStackInSlot(var1).getItem();
         this.f_f36bb679 = var2;
         if (var2.getInventory().getCurrentItem() != this.f_0c2c5e33) {
            this.f_6d5850aa = var2.getInventory().getCurrentItem();
         }
      }
   }

   public C0279 m_6a09bc9a() {
      this.f_eefffdd8 = true;
      return this;
   }

   public C0279 m_fb884086() {
      this.f_1ef3462c = C0114.bootstrap<"call",0,1>();
      this.m_2df7cd92();
      this.f_3ed0c70a = true;
      return this;
   }

   protected boolean m_d9d784d8() {
      return this.f_f36bb679.getInventory().getStackInSlot(this.f_0c2c5e33).getItem().equals(this.f_dca3318d);
   }

   public void m_b17a6134() {
      if (this.f_6d5850aa != -1 && !this.f_40c47446) {
         this.f_f36bb679.getInventory().setCurrentItem(this.f_6d5850aa);
      }
   }

   public void m_2df7cd92() {
      if (this.f_f36bb679.getInventory().getCurrentItem() != this.f_0c2c5e33 && !this.f_40c47446) {
         this.f_6d5850aa = this.f_f36bb679.getInventory().getCurrentItem();
         this.f_f36bb679.getInventory().setCurrentItem(this.f_0c2c5e33);
      }
   }

   protected void m_d53e3d65() {
      if (this.f_e79d04e4) {
         this.m_b17a6134();
      }

      this.f_eefffdd8 = true;
      this.m_ed1851e3();
   }

   public C0279 m_7b565b67() {
      if (!this.f_7946c088.test(this.f_f36bb679)) {
         this.m_d53e3d65();
      }

      return this;
   }

   public boolean m_01d052b2() {
      return this.f_eefffdd8;
   }

   public boolean m_7358cd72() {
      return this.f_3ed0c70a;
   }

   public boolean m_2f112b6c() {
      return this.f_40c47446;
   }

   public void m_3aaed7fd(boolean var1) {
      this.f_e79d04e4 = var1;
   }

   public void m_0f594ee6(Predicate<EntityPlayer> var1) {
      this.f_7946c088 = var1;
   }
}
