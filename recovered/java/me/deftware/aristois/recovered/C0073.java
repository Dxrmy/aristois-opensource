package me.deftware.aristois.recovered;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import me.deftware.aristois.services.IStateController;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;
import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.input.Mouse;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0073 {
   public static final int f_8dddc863 = 45;
   public static final int f_be706ebd = 0;
   public static final C0073 f_98de3227 = new C0073();
   private final Map<String, Supplier<Boolean>> f_e3acc1cd = new HashMap<>();

   private C0073() {
      EventBus.registerClass(this.getClass(), this);
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      this.f_e3acc1cd.entrySet().removeIf(var0 -> var0.getValue().get());
   }

   private void m_dbe875a5(String var1, Supplier<Boolean> var2) {
      this.f_e3acc1cd.put(var1, var2);
   }

   private boolean m_828a75ae(String var1) {
      return this.f_e3acc1cd.containsKey(var1);
   }

   public static void m_3907084c(MainEntityPlayer var0, int var1) {
      var0.windowClick(0, var1, 1, WindowClickAction.THROW);
   }

   public static C0073.anonymousdefault m_f76a4979() {
      return new C0073.anonymousdefault(WindowClickAction.PICKUP);
   }

   public static C0073.anonymousdefault m_a796c7da() {
      return new C0073.anonymousdefault(WindowClickAction.QUICK_MOVE);
   }

   public static C0073.anonymousboolean m_72cafc8a() {
      return new C0073.anonymousboolean();
   }

   public static C0073.anonymoustransient m_24e329e8() {
      return new C0073.anonymoustransient();
   }

   public static int m_a73ee2be(int var0) {
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

   public static boolean m_9c54ac1f(MainEntityPlayer var0, int var1) {
      if (var1 > 8) {
         var1 -= 36;
      }

      return var0.getInventory().getCurrentItem() == var1;
   }

   public static boolean m_b4168121(int var0) {
      return var0 <= 35;
   }

   public static boolean m_aa45d95d(int var0) {
      return var0 <= 8 || var0 >= 36 && var0 <= 44 || var0 == 45;
   }

   public static ItemStack m_8ae0fd29(int var0) {
      if (var0 == -1) {
         return null;
      } else {
         if (var0 >= 36 && var0 <= 44) {
            var0 -= 36;
         }

         MainEntityPlayer var1 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
         ItemStack var2 = var0 != 45 ? var1.getInventory().getStackInSlot(var0) : var1.getInventory().getHeldItem(true);
         return var2.isEmpty() ? null : var2;
      }
   }

   public static boolean m_376d1241(Item var0) {
      return Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).getInventory().getHeldItem(true).getItem().equals(var0);
   }

   public static boolean m_3ef6130a(Item var0) {
      return Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).getInventory().getHeldItem(false).getItem().equals(var0);
   }

   public static boolean m_d3d286e7(Item var0) {
      return m_3ef6130a(var0) || m_376d1241(var0);
   }

   public static class anonymousboolean extends C0073.anonymousthis<C0073.anonymousboolean> {
      public anonymousboolean() {
      }

      public C0073.anonymousboolean m_f55354b6(boolean var1) {
         if (!this.m_e0f7c666() || var1) {
            if (this.f_e2c62c1d == -1 || this.f_e2c62c1d == 45) {
               return this;
            }

            if (this.f_e2c62c1d > 9) {
               this.f_e2c62c1d -= 36;
            }

            if (this.f_39772c86.getInventory().getCurrentItem() != this.f_e2c62c1d) {
               this.f_39772c86.getInventory().setCurrentItem(this.f_e2c62c1d);
            }
         }

         return this;
      }
   }

   public static class anonymousdefault extends C0073.anonymousthis<C0073.anonymousdefault> {
      protected final WindowClickAction f_58cd51bf;
      private int f_d8c61f32 = 0;
      private int f_a3309b3a = 0;

      public anonymousdefault(WindowClickAction var1) {
         this.f_58cd51bf = var1;
      }

      public C0073.anonymousdefault m_5f9623c5(int var1) {
         this.f_a3309b3a = var1;
         return this;
      }

      public C0073.anonymousdefault m_81af56ff(boolean var1) {
         if ((!this.m_e0f7c666() || var1) && this.f_ba693ef2 != -1) {
            boolean var2 = C0073.m_8ae0fd29(this.f_ba693ef2) != null && C0073.m_8ae0fd29(this.f_e2c62c1d) != null;
            this.f_39772c86.windowClick(this.f_d8c61f32, this.f_ba693ef2, this.f_a3309b3a, this.f_58cd51bf);
            if (this.f_e2c62c1d != -1) {
               this.f_39772c86.windowClick(this.f_d8c61f32, this.f_e2c62c1d, this.f_a3309b3a, this.f_58cd51bf);
               if (this.f_58cd51bf == WindowClickAction.PICKUP && var2) {
                  this.f_39772c86.windowClick(this.f_d8c61f32, this.f_ba693ef2, this.f_a3309b3a, this.f_58cd51bf);
               }
            }
         }

         return this;
      }

      public WindowClickAction m_22b60cb0() {
         return this.f_58cd51bf;
      }

      public int m_f065f6c5() {
         return this.f_d8c61f32;
      }

      public int m_9274e178() {
         return this.f_a3309b3a;
      }
   }

   public abstract static class anonymousthis<T> {
      protected final MainEntityPlayer f_39772c86 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      protected int f_ba693ef2 = C0073.m_a73ee2be(this.f_39772c86.getInventory().getCurrentItem());
      protected int f_e2c62c1d;
      protected String f_fe036814 = String.valueOf(Math.random() * 1000.0);
      protected int f_c84c0824 = 9;
      protected int f_f689e46e = 44;
      protected int f_0faefd7a = 5;
      protected int f_579c779f;
      private long f_2f8ddeca;

      public anonymousthis() {
         if (Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen) {
            Inventory var1 = ((ContainerScreen)Minecraft.getMinecraftGame().getScreen()).getContainerInventory();
            this.f_c84c0824 = 27;
            this.f_f689e46e = 62;
            if (var1 != null && var1.isDouble()) {
               this.f_c84c0824 = 54;
               this.f_f689e46e = 89;
            }
         }

         this.f_579c779f = this.f_f689e46e - this.f_c84c0824;
      }

      public abstract T m_68cf8155(boolean var1);

      public T m_ac6eac3b() {
         return this.m_68cf8155(false);
      }

      public T m_8c218980(Object var1) {
         this.f_fe036814 = var1.getClass().getCanonicalName();
         return (T)this;
      }

      public T m_e1463257(int var1) {
         this.f_ba693ef2 = var1;
         return (T)this;
      }

      public T m_887f6e69(Item var1) {
         this.f_ba693ef2 = C0073.m_a73ee2be(this.f_39772c86.getInventory().findItem(var1));
         return (T)this;
      }

      public T m_6a1482b0(Item var1) {
         this.f_e2c62c1d = C0073.m_a73ee2be(this.f_39772c86.getInventory().findItem(var1));
         return (T)this;
      }

      public T m_7c42e94f(int var1) {
         this.f_e2c62c1d = var1;
         return (T)this;
      }

      public T m_9f5846d4(int var1) {
         this.f_ba693ef2 = 8 - var1;
         return (T)this;
      }

      public T m_68351bcd(int var1) {
         this.f_e2c62c1d = 8 - var1;
         return (T)this;
      }

      public T m_b252dc95() {
         return this.m_c71879c9(0, 9);
      }

      public T m_298196c7() {
         return this.m_c71879c9(0, 36);
      }

      public T m_c71879c9(int var1, int var2) {
         for (int var3 = var1; var3 < var2; var3++) {
            this.f_e2c62c1d = C0073.m_a73ee2be(var3);
            if (this.f_39772c86.getInventory().getStackInSlot(var3).isEmpty()) {
               break;
            }
         }

         return (T)this;
      }

      public T m_50ca8f08() {
         this.f_e2c62c1d = C0073.m_a73ee2be(this.f_39772c86.getInventory().getCurrentItem());
         return (T)this;
      }

      public T m_6a5ac614() {
         this.f_e2c62c1d = 45;
         return (T)this;
      }

      public T m_110eee12(long var1) {
         this.f_2f8ddeca = System.currentTimeMillis() + var1;
         return this.m_924c66cb(() -> this.f_2f8ddeca < System.currentTimeMillis());
      }

      public boolean m_e0f7c666() {
         return C0073.f_98de3227.m_828a75ae(this.f_fe036814);
      }

      public T m_924c66cb(Supplier<Boolean> var1) {
         if (this.f_ba693ef2 != -1 && this.f_e2c62c1d != -1 && !this.m_e0f7c666()) {
            C0073.f_98de3227.m_dbe875a5(this.f_fe036814, () -> {
               if ((Boolean)var1.get()) {
                  this.m_743d7fa3();
                  return true;
               } else {
                  return false;
               }
            });
         }

         return (T)this;
      }

      public T m_743d7fa3() {
         this.f_ba693ef2 = this.f_ba693ef2 ^ this.f_e2c62c1d ^ (this.f_e2c62c1d = this.f_ba693ef2);
         this.m_68cf8155(true);
         return (T)this;
      }

      public T m_7fca7b89() {
         this.f_ba693ef2 = C0073.m_a73ee2be(this.f_ba693ef2);
         this.f_e2c62c1d = C0073.m_a73ee2be(this.f_e2c62c1d);
         return (T)this;
      }

      public MainEntityPlayer m_f8aa77c5() {
         return this.f_39772c86;
      }

      public int m_d612baa8() {
         return this.f_ba693ef2;
      }

      public int m_eb304949() {
         return this.f_e2c62c1d;
      }

      public String m_6f1f396d() {
         return this.f_fe036814;
      }

      public int m_4a4817b8() {
         return this.f_c84c0824;
      }

      public int m_32f05cf1() {
         return this.f_f689e46e;
      }

      public int m_197b2fc8() {
         return this.f_0faefd7a;
      }

      public int m_0fe70f31() {
         return this.f_579c779f;
      }

      public long m_c7c6e660() {
         return this.f_2f8ddeca;
      }

      public void m_e12f1e31(long var1) {
         this.f_2f8ddeca = var1;
      }
   }

   public static class anonymoustransient extends C0073.anonymousthis<C0073.anonymoustransient> {
      private Function<ItemStack, Boolean> f_5110fc65 = var0 -> true;
      private Runnable f_fb1ab51c;

      public anonymoustransient() {
      }

      public C0073.anonymoustransient m_fb3f041e(int var1) {
         this.f_5110fc65 = var2 -> this.f_39772c86.getFoodLevel() >= var1;
         return this;
      }

      public C0073.anonymoustransient m_eb3bce89() {
         IStateController var1 = IStateController.getInstance();
         if (var1 != null && var1.isControlling()) {
            var1.pause();
            this.f_fb1ab51c = var1::resume;
         }

         return this;
      }

      public C0073.anonymoustransient m_a7413d75(boolean var1) {
         if (!this.m_e0f7c666() || var1) {
            if (this.f_ba693ef2 > 9) {
               this.f_ba693ef2 -= 36;
            }

            if (this.f_e2c62c1d > 9) {
               this.f_e2c62c1d -= 36;
            }

            this.f_39772c86.getInventory().setCurrentItem(this.f_e2c62c1d);
            C0073.f_98de3227.m_dbe875a5(this.f_fe036814, () -> {
               boolean var1x = this.f_39772c86.getInventory().getCurrentItem() != this.f_e2c62c1d;
               ItemStack var2 = C0073.m_8ae0fd29(this.f_e2c62c1d);
               if (!var1x && var2 != null && !var2.isEmpty() && !this.f_5110fc65.apply(var2)) {
                  if (!C0217.m_51ce03a5()) {
                     if (ScreenRegistry.Chat.isOpen()) {
                        Mouse.clickMouse(1);
                     } else {
                        MinecraftKeyBind.USE_ITEM.setPressed(true);
                     }
                  }

                  return false;
               } else {
                  MinecraftKeyBind.USE_ITEM.setPressed(false);
                  this.f_39772c86.getInventory().setCurrentItem(this.f_ba693ef2);
                  if (this.f_fb1ab51c != null) {
                     this.f_fb1ab51c.run();
                  }

                  return true;
               }
            });
         }

         return this;
      }

      public void m_c162d659(Runnable var1) {
         this.f_fb1ab51c = var1;
      }
   }
}
