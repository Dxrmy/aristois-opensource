package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.util.types.Pair;

public class C0293 extends AbstractMod {
   @C0098(
      value = "Mode",
      description = {"Render mode"}
   )
   public C0102<C0293.anonymousnew> f_21d0bfbf = new C0102<>(C0293.anonymousnew.f_e90f8ca7);
   @C0098(
      value = "Position",
      description = {"Where to render the armor"}
   )
   public C0102<C0293.anonymousstatic> f_9f546890 = new C0102<>(C0293.anonymousstatic.f_7ea34ac9);
   @C0098(
      value = "Enchant Scale",
      description = {"The scale at which enchants are rendered in"},
      number = @C0096(
         min = 0.25,
         max = 1.0
      )
   )
   private C0106<Float> f_ff193172 = new C0106<>(C0114.bootstrap<"call",0,1>(0.5F)).m_10caee7d(this.f_21d0bfbf, C0293.anonymousnew.f_0cc3c2c9);
   private final C0294 f_cff60019 = new C0294();

   public C0293() {
      super(C0252.bootstrap<"get",38654705790>(), C0290.f_5fe5d165, C0252.bootstrap<"get",38654705791>());
      this.setMode(this.f_21d0bfbf);
   }

   @Override
   public void onPostLoad() {
      this.f_cff60019.m_2b39d85d(this.f_ff193172.get());
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      this.onPostLoad();
   }

   @EventHandler
   public void m_e6b4541f(EventRender2D var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      ArrayList var3 = new ArrayList(var2.getInventory().getArmourInventory());
      var3.removeIf(ItemStack::isEmpty);
      if (!var3.isEmpty()) {
         C0114.bootstrap<"call",2,1>(var3);
         byte var4 = 15;
         int var5 = this.f_9f546890.m_e2691446() == C0293.anonymousstatic.f_f99d4d94
            ? C0114.bootstrap<"call",3,1>() / 2 - var3.size() * var4 / 2 + 50
            : (this.f_9f546890.m_e2691446() == C0293.anonymousstatic.f_35bd8ad0 ? C0114.bootstrap<"call",3,1>() - 20 : 5);
         int var6 = this.f_9f546890.m_e2691446() == C0293.anonymousstatic.f_f99d4d94
            ? C0114.bootstrap<"call",4,1>() - 40 - (!var2.isCreative() ? 20 : 0)
            : C0114.bootstrap<"call",4,1>() / 2 - var3.size() * var4 / 2;

         for (ItemStack var8 : var3) {
            switch ((C0293.anonymousnew)this.f_21d0bfbf.m_e2691446()) {
               case f_0cc3c2c9:
                  this.f_cff60019
                     .m_b84e05f2(
                        var5,
                        var6,
                        var8,
                        new Pair(
                           C0114.bootstrap<"call",5,1>(this.f_9f546890.m_e2691446() == C0293.anonymousstatic.f_f99d4d94),
                           C0114.bootstrap<"call",5,1>(this.f_9f546890.m_e2691446() == C0293.anonymousstatic.f_35bd8ad0)
                        )
                     );
                  break;
               case f_c301c152:
               case f_faccc79d:
                  this.m_dfa3eb4c(var5, var6, var8);
                  break;
               case f_7a8e9aa0:
               default:
                  this.f_cff60019.m_077c1e62(var5, var6, var8, (BiConsumer<ItemStack, Integer>)null);
            }

            if (this.f_9f546890.m_e2691446() == C0293.anonymousstatic.f_f99d4d94) {
               var5 += var4;
            } else {
               var6 += var4;
            }
         }
      }
   }

   public void m_dfa3eb4c(int var1, int var2, ItemStack var3) {
      this.f_cff60019.m_077c1e62(var1, var2, var3, (var1x, var2x) -> {
         int var3x = var1x.getMaxDamage() - var1x.getDamage();
         String var5 = C0114.bootstrap<"call",6,1>(var3x);

         int var4;
         try {
            var4 = var3x * 100 / var1x.getMaxDamage();
         } catch (Exception var8) {
            var4 = 0;
         }

         DefaultColors var6;
         if (var4 > 75) {
            var6 = DefaultColors.DARK_GREEN;
         } else if (var4 > 50) {
            var6 = DefaultColors.GREEN;
         } else if (var4 > 25) {
            var6 = DefaultColors.YELLOW;
         } else {
            var6 = DefaultColors.RED;
         }

         if (this.f_21d0bfbf.m_e2691446() == C0293.anonymousnew.f_faccc79d) {
            var5 = var4 + C0252.bootstrap<"get",30064771112>();
         }

         if (var3x > 0) {
            C0114.bootstrap<"call",9,1>(C0114.bootstrap<"call",7,1>(var5).style(C0114.bootstrap<"call",8,1>(var6)), 0, 0, 16777215);
         }
      });
   }

   public static enum anonymousnew {
      f_faccc79d,
      f_c301c152,
      f_0cc3c2c9,
      f_e90f8ca7,
      f_7a8e9aa0;

      private anonymousnew() {
      }
   }

   public static enum anonymousstatic {
      f_7ea34ac9,
      f_35bd8ad0,
      f_f99d4d94;

      private anonymousstatic() {
      }
   }
}
