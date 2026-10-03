package me.deftware.aristois.recovered;

import java.util.function.Predicate;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.item.Item;

public class C0279 extends C0270<C0279> {
   protected boolean f_d5801aab = false;
   protected boolean f_014b3824 = false;
   protected boolean f_3baca66d = false;
   protected boolean f_9bf6b813 = true;
   protected int f_4d02db88;
   protected int f_6bc53d7f = -1;
   protected final EntityPlayer f_35114e14;
   private final Item f_2b86d1c6;
   protected Predicate<EntityPlayer> f_06024348 = EntityPlayer::isUsingItem;

   public C0279(int var1, EntityPlayer var2) {
      this.f_3baca66d = var1 == 45;
      if (var1 > 8 && !this.f_3baca66d) {
         throw new IllegalArgumentException(C0256.m_760db7bb());
      } else {
         this.f_4d02db88 = var1;
         this.f_2b86d1c6 = var2.getInventory().getStackInSlot(var1).getItem();
         this.f_35114e14 = var2;
         if (var2.getInventory().getCurrentItem() != this.f_4d02db88) {
            this.f_6bc53d7f = var2.getInventory().getCurrentItem();
         }
      }
   }

   public C0279 m_06418dd7() {
      this.f_d5801aab = true;
      return this;
   }

   public C0279 m_30bfe4e5() {
      this.f_ae2cc37b = System.currentTimeMillis();
      this.m_e4dddc57();
      this.f_014b3824 = true;
      return this;
   }

   protected boolean m_5d7ada2f() {
      return this.f_35114e14.getInventory().getStackInSlot(this.f_4d02db88).getItem().equals(this.f_2b86d1c6);
   }

   public void m_37118aff() {
      if (this.f_6bc53d7f != -1 && !this.f_3baca66d) {
         this.f_35114e14.getInventory().setCurrentItem(this.f_6bc53d7f);
      }
   }

   public void m_e4dddc57() {
      if (this.f_35114e14.getInventory().getCurrentItem() != this.f_4d02db88 && !this.f_3baca66d) {
         this.f_6bc53d7f = this.f_35114e14.getInventory().getCurrentItem();
         this.f_35114e14.getInventory().setCurrentItem(this.f_4d02db88);
      }
   }

   protected void m_476256a8() {
      if (this.f_9bf6b813) {
         this.m_37118aff();
      }

      this.f_d5801aab = true;
      this.m_23674f64();
   }

   public C0279 m_e3ec0ce5() {
      if (!this.f_06024348.test(this.f_35114e14)) {
         this.m_476256a8();
      }

      return this;
   }

   @Override
   public boolean m_f7b07982() {
      return this.f_d5801aab;
   }

   @Override
   public boolean m_9362a920() {
      return this.f_014b3824;
   }

   public boolean m_8d50206e() {
      return this.f_3baca66d;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_9bf6b813 = var1;
   }

   public void m_da1753cf(Predicate<EntityPlayer> var1) {
      this.f_06024348 = var1;
   }
}
