package me.deftware.aristois.recovered;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import me.deftware.aristois.services.IStateController;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;

public class C0073 {
   public static final int f_0ded9313 = 45;
   public static final int f_82a0ecb2 = 0;
   public static final C0073 f_021c3a01 = new C0073();
   private final Map<String, Supplier<Boolean>> f_4873add4 = new HashMap<>();

   private C0073() {
      C0114.bootstrap<"call",0,1>(this.getClass(), this);
   }

   @EventHandler
   private void m_4e99d40e(EventUpdate var1) {
      this.f_4873add4.entrySet().removeIf(var0 -> var0.getValue().get());
   }

   private void m_75575049(String var1, Supplier<Boolean> var2) {
      this.f_4873add4.put(var1, var2);
   }

   private boolean m_7c2e2ce5(String var1) {
      return this.f_4873add4.containsKey(var1);
   }

   public static void m_29b7afc5(MainEntityPlayer var0, int var1) {
      var0.windowClick(0, var1, 1, WindowClickAction.THROW);
   }

   public static C0073.anonymousdefault m_1f006740() {
      return new C0073.anonymousdefault(WindowClickAction.PICKUP);
   }

   public static C0073.anonymousdefault m_7bb9d6a5() {
      return new C0073.anonymousdefault(WindowClickAction.QUICK_MOVE);
   }

   public static C0073.anonymousboolean m_2fb75dc8() {
      return new C0073.anonymousboolean();
   }

   public static C0073.anonymoustransient m_a5b3969c() {
      return new C0073.anonymoustransient();
   }

   public static int m_683053e7(int var0) {
      if (var0 == -1) {
         return -1;
      } else {
         if (var0 <= 8) {
            var0 += 36;
         } else if (var0 == 100) {
            var0 = 8;
         } else if (var0 == 101) {
            var0 = 7;
         } else if (var0 == 102) {
            var0 = 6;
         } else if (var0 == 103) {
            var0 = 5;
         } else if (var0 >= 80 && var0 <= 83) {
            var0 -= 79;
         }

         return var0;
      }
   }

   public static boolean m_d4923932(MainEntityPlayer var0, int var1) {
      if (var1 > 8) {
         var1 -= 36;
      }

      return var0.getInventory().getCurrentItem() == var1;
   }

   public static boolean m_7910452e(int var0) {
      return var0 <= 35;
   }

   public static boolean m_bfeb26ed(int var0) {
      return var0 <= 8 || var0 >= 36 && var0 <= 44 || var0 == 45;
   }

   public static ItemStack m_11453784(int var0) {
      if (var0 == -1) {
         return null;
      } else {
         if (var0 >= 36 && var0 <= 44) {
            var0 -= 36;
         }

         MainEntityPlayer var1 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
         ItemStack var2 = var0 != 45 ? var1.getInventory().getStackInSlot(var0) : var1.getInventory().getHeldItem(true);
         return var2.isEmpty() ? null : var2;
      }
   }

   public static boolean m_77eac350(Item var0) {
      return ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer()))
         .getInventory()
         .getHeldItem(true)
         .getItem()
         .equals(var0);
   }

   public static boolean m_85c25087(Item var0) {
      return ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer()))
         .getInventory()
         .getHeldItem(false)
         .getItem()
         .equals(var0);
   }

   public static boolean m_7bd36e66(Item var0) {
      return C0114.bootstrap<"call",0,1>(var0) || C0114.bootstrap<"call",1,1>(var0);
   }

   public static class anonymousboolean extends C0073.anonymousthis<C0073.anonymousboolean> {
      public anonymousboolean() {
      }

      public C0073.anonymousboolean m_b6c3bffd(boolean var1) {
         if (!this.m_854ff3ba() || var1) {
            if (this.f_77200b31 == -1 || this.f_77200b31 == 45) {
               return this;
            }

            if (this.f_77200b31 > 9) {
               this.f_77200b31 -= 36;
            }

            if (this.f_2164e2e0.getInventory().getCurrentItem() != this.f_77200b31) {
               this.f_2164e2e0.getInventory().setCurrentItem(this.f_77200b31);
            }
         }

         return this;
      }
   }

   public static class anonymousdefault extends C0073.anonymousthis<C0073.anonymousdefault> {
      protected final WindowClickAction f_5161ee06;
      private int f_f09580d9 = 0;
      private int f_ade3480c = 0;

      public anonymousdefault(WindowClickAction var1) {
         this.f_5161ee06 = var1;
      }

      public C0073.anonymousdefault m_7c2aa904(int var1) {
         this.f_ade3480c = var1;
         return this;
      }

      public C0073.anonymousdefault m_b3e81d93(boolean var1) {
         if ((!this.m_3a7901e9() || var1) && this.f_17a099d3 != -1) {
            boolean var2 = C0114.bootstrap<"call",0,1>(this.f_17a099d3) != null && C0114.bootstrap<"call",0,1>(this.f_7c90ec4b) != null;
            this.f_530c5025.windowClick(this.f_f09580d9, this.f_17a099d3, this.f_ade3480c, this.f_5161ee06);
            if (this.f_7c90ec4b != -1) {
               this.f_530c5025.windowClick(this.f_f09580d9, this.f_7c90ec4b, this.f_ade3480c, this.f_5161ee06);
               if (this.f_5161ee06 == WindowClickAction.PICKUP && var2) {
                  this.f_530c5025.windowClick(this.f_f09580d9, this.f_17a099d3, this.f_ade3480c, this.f_5161ee06);
               }
            }
         }

         return this;
      }

      public WindowClickAction m_77fb233e() {
         return this.f_5161ee06;
      }

      public int m_c61279d0() {
         return this.f_f09580d9;
      }

      public int m_44e76b30() {
         return this.f_ade3480c;
      }
   }

   public abstract static class anonymousthis<T> {
      protected final MainEntityPlayer f_886da0eb = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      protected int f_597131a6 = C0114.bootstrap<"call",2,1>(this.f_886da0eb.getInventory().getCurrentItem());
      protected int f_e7560fbe;
      protected String f_e3417492 = C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>() * 1000.0);
      protected int f_7adf340d = 9;
      protected int f_1835a908 = 44;
      protected int f_a23869ee = 5;
      protected int f_29cfc9a3;
      private long f_78180afb;

      public anonymousthis() {
         if (C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen) {
            Inventory var1 = ((ContainerScreen)C0114.bootstrap<"call",0,1>().getScreen()).getContainerInventory();
            this.f_7adf340d = 27;
            this.f_1835a908 = 62;
            if (var1 != null && var1.isDouble()) {
               this.f_7adf340d = 54;
               this.f_1835a908 = 89;
            }
         }

         this.f_29cfc9a3 = this.f_1835a908 - this.f_7adf340d;
      }

      public abstract T m_a4f37b43(boolean var1);

      public T m_9c44985b() {
         return this.m_a4f37b43(false);
      }

      public T m_02202a91(Object var1) {
         this.f_e3417492 = var1.getClass().getCanonicalName();
         return (T)this;
      }

      public T m_cae968c1(int var1) {
         this.f_597131a6 = var1;
         return (T)this;
      }

      public T m_2519e991(Item var1) {
         this.f_597131a6 = C0114.bootstrap<"call",0,1>(this.f_886da0eb.getInventory().findItem(var1));
         return (T)this;
      }

      public T m_24a9779c(Item var1) {
         this.f_e7560fbe = C0114.bootstrap<"call",0,1>(this.f_886da0eb.getInventory().findItem(var1));
         return (T)this;
      }

      public T m_be4cca91(int var1) {
         this.f_e7560fbe = var1;
         return (T)this;
      }

      public T m_da1aa1e7(int var1) {
         this.f_597131a6 = 8 - var1;
         return (T)this;
      }

      public T m_9d27daf1(int var1) {
         this.f_e7560fbe = 8 - var1;
         return (T)this;
      }

      public T m_f60926af() {
         return this.m_f53c4cf9(0, 9);
      }

      public T m_45f1651c() {
         return this.m_f53c4cf9(0, 36);
      }

      public T m_f53c4cf9(int var1, int var2) {
         for (int var3 = var1; var3 < var2; var3++) {
            this.f_e7560fbe = C0114.bootstrap<"call",0,1>(var3);
            if (this.f_886da0eb.getInventory().getStackInSlot(var3).isEmpty()) {
               break;
            }
         }

         return (T)this;
      }

      public T m_969af740() {
         this.f_e7560fbe = C0114.bootstrap<"call",0,1>(this.f_886da0eb.getInventory().getCurrentItem());
         return (T)this;
      }

      public T m_ae915c73() {
         this.f_e7560fbe = 45;
         return (T)this;
      }

      public T m_a805f849(long var1) {
         this.f_78180afb = C0114.bootstrap<"call",1,1>() + var1;
         return this.m_26ea2984(() -> C0114.bootstrap<"call",1,1>(this.f_78180afb < C0114.bootstrap<"call",0,1>()));
      }

      public boolean m_f3aeb46a() {
         return C0114.bootstrap<"call",0,1>(C0073.f_021c3a01, this.f_e3417492);
      }

      public T m_26ea2984(Supplier<Boolean> var1) {
         if (this.f_597131a6 != -1 && this.f_e7560fbe != -1 && !this.m_f3aeb46a()) {
            C0114.bootstrap<"call",2,1>(C0073.f_021c3a01, this.f_e3417492, () -> {
               if ((Boolean)var1.get()) {
                  this.m_a9b23bdd();
                  return C0114.bootstrap<"call",1,1>(true);
               } else {
                  return C0114.bootstrap<"call",1,1>(false);
               }
            });
         }

         return (T)this;
      }

      public T m_a9b23bdd() {
         this.f_597131a6 = this.f_597131a6 ^ this.f_e7560fbe ^ (this.f_e7560fbe = this.f_597131a6);
         this.m_a4f37b43(true);
         return (T)this;
      }

      public T m_d8426a02() {
         this.f_597131a6 = C0114.bootstrap<"call",0,1>(this.f_597131a6);
         this.f_e7560fbe = C0114.bootstrap<"call",0,1>(this.f_e7560fbe);
         return (T)this;
      }

      public MainEntityPlayer m_5f3e9d40() {
         return this.f_886da0eb;
      }

      public int m_457df919() {
         return this.f_597131a6;
      }

      public int m_91941414() {
         return this.f_e7560fbe;
      }

      public String m_ffd70b30() {
         return this.f_e3417492;
      }

      public int m_b9185c03() {
         return this.f_7adf340d;
      }

      public int m_587fe280() {
         return this.f_1835a908;
      }

      public int m_d5c84760() {
         return this.f_a23869ee;
      }

      public int m_905b82a8() {
         return this.f_29cfc9a3;
      }

      public long m_0fad3a68() {
         return this.f_78180afb;
      }

      public void m_cb99593a(long var1) {
         this.f_78180afb = var1;
      }
   }

   public static class anonymoustransient extends C0073.anonymousthis<C0073.anonymoustransient> {
      private Function<ItemStack, Boolean> f_b2d1f014 = var0 -> C0114.bootstrap<"call",1,1>(true);
      private Runnable f_78a3c0d8;

      public anonymoustransient() {
      }

      public C0073.anonymoustransient m_10ff8762(int var1) {
         this.f_b2d1f014 = var2 -> C0114.bootstrap<"call",1,1>(this.f_b3bea76d.getFoodLevel() >= var1);
         return this;
      }

      public C0073.anonymoustransient m_ea02cddd() {
         IStateController var1 = C0114.bootstrap<"call",0,1>();
         if (var1 != null && var1.isControlling()) {
            var1.pause();
            this.f_78a3c0d8 = var1::resume;
         }

         return this;
      }

      public C0073.anonymoustransient m_8f1104ef(boolean var1) {
         if (!this.m_55d1c48f() || var1) {
            if (this.f_596c008e > 9) {
               this.f_596c008e -= 36;
            }

            if (this.f_58d049fa > 9) {
               this.f_58d049fa -= 36;
            }

            this.f_b3bea76d.getInventory().setCurrentItem(this.f_58d049fa);
            C0114.bootstrap<"call",0,1>(C0073.f_021c3a01, this.f_d9917285, () -> {
               boolean var1x = this.f_b3bea76d.getInventory().getCurrentItem() != this.f_58d049fa;
               ItemStack var2 = C0114.bootstrap<"call",0,1>(this.f_58d049fa);
               if (!var1x && var2 != null && !var2.isEmpty() && !this.f_b2d1f014.apply(var2)) {
                  if (!C0114.bootstrap<"call",2,1>()) {
                     if (ScreenRegistry.Chat.isOpen()) {
                        C0114.bootstrap<"call",3,1>(1);
                     } else {
                        MinecraftKeyBind.USE_ITEM.setPressed(true);
                     }
                  }

                  return C0114.bootstrap<"call",1,1>(false);
               } else {
                  MinecraftKeyBind.USE_ITEM.setPressed(false);
                  this.f_b3bea76d.getInventory().setCurrentItem(this.f_596c008e);
                  if (this.f_78a3c0d8 != null) {
                     this.f_78a3c0d8.run();
                  }

                  return C0114.bootstrap<"call",1,1>(true);
               }
            });
         }

         return this;
      }

      public void m_01f041a7(Runnable var1) {
         this.f_78a3c0d8 = var1;
      }
   }
}
