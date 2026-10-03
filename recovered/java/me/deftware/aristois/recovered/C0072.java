package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.types.ArmourItem;
import me.deftware.client.framework.item.types.FoodItem;
import me.deftware.client.framework.item.types.WeaponItem;
import me.deftware.client.framework.util.types.Pair;
import me.deftware.client.framework.world.block.Block;

public class C0072 {
   public static final int f_7ba2351f = 2;
   private final Function<ItemStack, Boolean> f_dca1dc7c;
   private final Function<ItemStack, Float> f_7c80efec;
   private Function<ItemStack, Boolean> f_7576f7f0 = var0 -> C0114.bootstrap<"call",0,1>(true);
   private int f_1e4633ef = 0;
   private BiFunction<Float, Float, Boolean> f_0d9091de = (var0, var1x) -> C0114.bootstrap<"call",0,1>(var0 < var1x);
   private Pair<Item, Float> f_dea6e4c1;

   private MainEntityPlayer m_2db07a6a() {
      return C0114.bootstrap<"call",0,1>()._getPlayer();
   }

   public static C0072 m_2901632c(Item var0) {
      return new C0072(var1 -> C0114.bootstrap<"call",0,1>(var1.getItem().equals(var0)), var0x -> C0114.bootstrap<"call",0,1>((float)var0x.getDamage()));
   }

   public static C0072 m_4c6e9701() {
      return new C0072(var0 -> C0114.bootstrap<"call",1,1>(true), var0 -> C0114.bootstrap<"call",0,1>(1.0F)).m_99d657df();
   }

   public static C0072 m_718dc3ed(Item var0) {
      return new C0072(var1 -> C0114.bootstrap<"call",3,1>(var1.getItem().equals(var0)), var0x -> C0114.bootstrap<"call",0,1>(1.0F)).m_99d657df();
   }

   public static C0072 m_e64c1ee8() {
      return new C0072(var0 -> C0114.bootstrap<"call",0,1>(var0.getItem() instanceof WeaponItem), ItemStack::getStackAttackDamage);
   }

   public static C0072 m_8036c7e4() {
      return new C0072(
         var0 -> C0114.bootstrap<"call",0,1>(var0.getItem() instanceof FoodItem),
         var0 -> C0114.bootstrap<"call",0,1>((float)((FoodItem)var0.getItem()).getHunger())
      );
   }

   public static C0072 m_ecb8c315() {
      return new C0072(
         var0 -> C0114.bootstrap<"call",0,1>(var0.getItem() instanceof ArmourItem || var0.getItem().equals(C0070.f_a049faba)),
         var0 -> C0114.bootstrap<"call",1,1>((float)var0.getStackProtectionAmount())
      );
   }

   public static C0072.anonymousboolean m_9b399593() {
      return new C0072.anonymousboolean();
   }

   public C0072 m_7ecd94e5(Function<ItemStack, Boolean> var1) {
      this.f_7576f7f0 = var1;
      return this;
   }

   public C0072 m_d5fce8ed(int var1) {
      this.f_1e4633ef = var1;
      return this;
   }

   public C0072 m_82117449(Item var1, float var2) {
      this.f_dea6e4c1 = new Pair(var1, C0114.bootstrap<"call",1,1>(var2));
      return this;
   }

   protected float m_d837e959(ItemStack var1) {
      return this.f_7c80efec.apply(var1);
   }

   public C0072 m_99d657df() {
      this.f_0d9091de = (var0, var1) -> C0114.bootstrap<"call",0,1>(true);
      return this;
   }

   public C0072 m_c809d082() {
      this.f_0d9091de = (var0, var1) -> C0114.bootstrap<"call",3,1>(var0 > var1);
      return this;
   }

   public Collection<C0072.anonymousdefault> m_905f1534() {
      MainEntityPlayer var1 = this.m_2db07a6a();
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < var1.getInventory().getSize(); var3++) {
         final int var4 = C0114.bootstrap<"call",0,1>(var3);
         final ItemStack var5 = var1.getInventory().getStackInSlot(var3);
         if (!var5.isEmpty() && this.f_dca1dc7c.apply(var5)) {
            var2.add(new C0072.anonymousdefault() {
               public int m_ddf7005f() {
                  return var4;
               }

               public ItemStack m_171317b0() {
                  return var5;
               }
            });
         }
      }

      return var2;
   }

   public Stream<C0072.anonymousdefault> m_ad163406() {
      return this.m_905f1534().stream();
   }

   public int m_a0aa8556() {
      return this.m_b359a24a(0, this.m_2db07a6a().getInventory().getSize(), -1, -1.0F);
   }

   public int m_e05ba629() {
      return this.m_b359a24a(0, 8, -1, -1.0F);
   }

   public int m_b359a24a(int var1, int var2, int var3, float var4) {
      int var5 = var3;

      for (int var6 = var1; var6 <= var2 + 1; var6++) {
         ItemStack var7;
         if (var6 == var2 + 1) {
            var7 = this.m_2db07a6a().getInventory().getHeldItem(true);
         } else {
            var7 = this.m_2db07a6a().getInventory().getStackInSlot(var6);
         }

         if (this.f_dca1dc7c.apply(var7) && this.f_7576f7f0.apply(var7)) {
            float var8 = this.m_d837e959(var7);
            if (var7.getItem() instanceof ArmourItem || var7.getItem().equals(C0070.f_a049faba)) {
               int var9 = var7.getItem() instanceof ArmourItem ? ((ArmourItem)var7.getItem()).getTypeOrdinal() - 2 : 2;
               if (var9 != this.f_1e4633ef) {
                  continue;
               }
            }

            if (this.f_dea6e4c1 != null && ((Item)this.f_dea6e4c1.getLeft()).equals(var7.getItem())) {
               var8 = (Float)this.f_dea6e4c1.getRight();
            }

            if (this.f_0d9091de.apply(C0114.bootstrap<"call",1,1>(var4), C0114.bootstrap<"call",1,1>(var8))) {
               var4 = var8;
               var3 = var6;
            }
         }
      }

      if (var3 == var2 + 1) {
         var3 = 45;
      }

      if (var3 != var5) {
         var3 = C0114.bootstrap<"call",2,1>(var3);
      }

      return var3;
   }

   public C0072(Function<ItemStack, Boolean> var1, Function<ItemStack, Float> var2) {
      this.f_dca1dc7c = var1;
      this.f_7c80efec = var2;
   }

   public static class anonymousboolean extends C0072 {
      private Block f_739fe722;

      public anonymousboolean() {
         super(var0 -> C0114.bootstrap<"call",0,1>(true), null);
      }

      public C0072.anonymousboolean m_586dbaa6(Block var1) {
         this.f_739fe722 = var1;
         return this;
      }

      protected float m_a189df29(ItemStack var1) {
         return var1.getStrVsBlock(this.f_739fe722.getBlockPosition());
      }
   }

   public interface anonymousdefault {
      int m_0ea37aad();

      ItemStack m_17485ebf();
   }
}
