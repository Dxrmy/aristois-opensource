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
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.types.Pair;
import me.deftware.client.framework.world.block.Block;

public class C0072 {
   public static final int f_3bb18f24 = 2;
   private final Function<ItemStack, Boolean> f_c83a91a4;
   private final Function<ItemStack, Float> f_d77d7cb3;
   private Function<ItemStack, Boolean> f_8664bff9 = var0 -> true;
   private int f_9a43f0e9 = 0;
   private BiFunction<Float, Float, Boolean> f_aea7a456 = (var0, var1x) -> var0 < var1x;
   private Pair<Item, Float> f_0e43e0a7;

   private MainEntityPlayer m_6061955d() {
      return Minecraft.getMinecraftGame()._getPlayer();
   }

   public static C0072 m_5143fd15(Item var0) {
      return new C0072(var1 -> var1.getItem().equals(var0), var0x -> (float)var0x.getDamage());
   }

   public static C0072 m_1c5da965() {
      return new C0072(var0 -> true, var0 -> 1.0F).m_e0ca1f51();
   }

   public static C0072 m_17e298ea(Item var0) {
      return new C0072(var1 -> var1.getItem().equals(var0), var0x -> 1.0F).m_e0ca1f51();
   }

   public static C0072 m_c6050a72() {
      return new C0072(var0 -> var0.getItem() instanceof WeaponItem, ItemStack::getStackAttackDamage);
   }

   public static C0072 m_11e5d51a() {
      return new C0072(var0 -> var0.getItem() instanceof FoodItem, var0 -> (float)((FoodItem)var0.getItem()).getHunger());
   }

   public static C0072 m_9a0150ee() {
      return new C0072(var0 -> var0.getItem() instanceof ArmourItem || var0.getItem().equals(C0070.f_88717b71), var0 -> (float)var0.getStackProtectionAmount());
   }

   public static C0072.anonymousboolean m_48cf3e49() {
      return new C0072.anonymousboolean();
   }

   public C0072 m_2b5aea64(Function<ItemStack, Boolean> var1) {
      this.f_8664bff9 = var1;
      return this;
   }

   public C0072 m_f26b74b3(int var1) {
      this.f_9a43f0e9 = var1;
      return this;
   }

   public C0072 m_6b100e6c(Item var1, float var2) {
      this.f_0e43e0a7 = new Pair(var1, var2);
      return this;
   }

   protected float m_2f2b24b9(ItemStack var1) {
      return this.f_d77d7cb3.apply(var1);
   }

   public C0072 m_e0ca1f51() {
      this.f_aea7a456 = (var0, var1) -> true;
      return this;
   }

   public C0072 m_8391f334() {
      this.f_aea7a456 = (var0, var1) -> var0 > var1;
      return this;
   }

   public Collection<C0072.anonymousdefault> m_a9cd4609() {
      MainEntityPlayer var1 = this.m_6061955d();
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < var1.getInventory().getSize(); var3++) {
         final int var4 = C0073.m_a73ee2be(var3);
         final ItemStack var5 = var1.getInventory().getStackInSlot(var3);
         if (!var5.isEmpty() && this.f_c83a91a4.apply(var5)) {
            var2.add(new C0072.anonymousdefault() {
               @Override
               public int m_5b3d3148() {
                  return var4;
               }

               @Override
               public ItemStack m_7b08e12a() {
                  return var5;
               }
            });
         }
      }

      return var2;
   }

   public Stream<C0072.anonymousdefault> m_b3d23b7d() {
      return this.m_a9cd4609().stream();
   }

   public int m_eb304949() {
      return this.m_ceb42ce2(0, this.m_6061955d().getInventory().getSize(), -1, -1.0F);
   }

   public int m_b8bdb7ac() {
      return this.m_ceb42ce2(0, 8, -1, -1.0F);
   }

   public int m_ceb42ce2(int var1, int var2, int var3, float var4) {
      int var5 = var3;

      for (int var6 = var1; var6 <= var2 + 1; var6++) {
         ItemStack var7;
         if (var6 == var2 + 1) {
            var7 = this.m_6061955d().getInventory().getHeldItem(true);
         } else {
            var7 = this.m_6061955d().getInventory().getStackInSlot(var6);
         }

         if (this.f_c83a91a4.apply(var7) && this.f_8664bff9.apply(var7)) {
            float var8 = this.m_2f2b24b9(var7);
            if (var7.getItem() instanceof ArmourItem || var7.getItem().equals(C0070.f_88717b71)) {
               int var9 = var7.getItem() instanceof ArmourItem ? ((ArmourItem)var7.getItem()).getTypeOrdinal() - 2 : 2;
               if (var9 != this.f_9a43f0e9) {
                  continue;
               }
            }

            if (this.f_0e43e0a7 != null && ((Item)this.f_0e43e0a7.getLeft()).equals(var7.getItem())) {
               var8 = (Float)this.f_0e43e0a7.getRight();
            }

            if (this.f_aea7a456.apply(var4, var8)) {
               var4 = var8;
               var3 = var6;
            }
         }
      }

      if (var3 == var2 + 1) {
         var3 = 45;
      }

      if (var3 != var5) {
         var3 = C0073.m_a73ee2be(var3);
      }

      return var3;
   }

   public C0072(Function<ItemStack, Boolean> var1, Function<ItemStack, Float> var2) {
      this.f_c83a91a4 = var1;
      this.f_d77d7cb3 = var2;
   }

   public static class anonymousboolean extends C0072 {
      private Block f_0cdc217a;

      public anonymousboolean() {
         super(var0 -> true, null);
      }

      public C0072.anonymousboolean m_ef8c78c7(Block var1) {
         this.f_0cdc217a = var1;
         return this;
      }

      @Override
      protected float m_2f2b24b9(ItemStack var1) {
         return var1.getStrVsBlock(this.f_0cdc217a.getBlockPosition());
      }
   }

   public interface anonymousdefault {
      int m_5b3d3148();

      ItemStack m_7b08e12a();
   }
}
