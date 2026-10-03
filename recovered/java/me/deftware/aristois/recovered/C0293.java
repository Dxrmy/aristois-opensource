package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.function.BiConsumer;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.types.Pair;

public class C0293 extends AbstractMod {
   @C0098(
      value = "Mode",
      description = {"Render mode"}
   )
   public C0102<C0293.anonymousnew> f_0e10c7b3 = new C0102<>(C0293.anonymousnew.f_05df532a);
   @C0098(
      value = "Position",
      description = {"Where to render the armor"}
   )
   public C0102<C0293.anonymousstatic> f_709af31e = new C0102<>(C0293.anonymousstatic.f_0f01dce5);
   @C0098(
      value = "Enchant Scale",
      description = {"The scale at which enchants are rendered in"},
      number = @C0096(
         min = 0.25,
         max = 1.0
      )
   )
   private C0106<Float> f_ec257969 = new C0106<>(0.5F).m_2d6ca2bd(this.f_0e10c7b3, C0293.anonymousnew.f_eb6b5d7f);
   private final C0294 f_18011569 = new C0294();

   public C0293() {
      super(C0263.m_56c1229f(), C0290.f_020f9141, C0263.m_0d6ae39b());
      this.setMode(this.f_0e10c7b3);
   }

   @Override
   public void onPostLoad() {
      this.f_18011569.m_d881d3e3(this.f_ec257969.get());
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      this.onPostLoad();
   }

   @EventHandler
   public void m_84072c65(EventRender2D var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      ArrayList var3 = new ArrayList(var2.getInventory().getArmourInventory());
      var3.removeIf(ItemStack::isEmpty);
      if (!var3.isEmpty()) {
         Collections.reverse(var3);
         byte var4 = 15;
         int var5 = this.f_709af31e.m_284992ec() == C0293.anonymousstatic.f_26d4ddfe
            ? GuiScreen.getScaledWidth() / 2 - var3.size() * var4 / 2 + 50
            : (this.f_709af31e.m_284992ec() == C0293.anonymousstatic.f_d70623b6 ? GuiScreen.getScaledWidth() - 20 : 5);
         int var6 = this.f_709af31e.m_284992ec() == C0293.anonymousstatic.f_26d4ddfe
            ? GuiScreen.getScaledHeight() - 40 - (!var2.isCreative() ? 20 : 0)
            : GuiScreen.getScaledHeight() / 2 - var3.size() * var4 / 2;

         for (ItemStack var8 : var3) {
            switch ((C0293.anonymousnew)this.f_0e10c7b3.m_284992ec()) {
               case f_eb6b5d7f:
                  this.f_18011569
                     .m_9e369680(
                        var5,
                        var6,
                        var8,
                        new Pair(
                           this.f_709af31e.m_284992ec() == C0293.anonymousstatic.f_26d4ddfe, this.f_709af31e.m_284992ec() == C0293.anonymousstatic.f_d70623b6
                        )
                     );
                  break;
               case f_2c24be5c:
               case f_a1a6118b:
                  this.m_43241c7a(var5, var6, var8);
                  break;
               case f_d960805e:
               default:
                  this.f_18011569.m_ad57b8bb(var5, var6, var8, (BiConsumer<ItemStack, Integer>)null);
            }

            if (this.f_709af31e.m_284992ec() == C0293.anonymousstatic.f_26d4ddfe) {
               var5 += var4;
            } else {
               var6 += var4;
            }
         }
      }
   }

   public void m_43241c7a(int var1, int var2, ItemStack var3) {
      this.f_18011569.m_ad57b8bb(var1, var2, var3, (var1x, var2x) -> {
         int var3x = var1x.getMaxDamage() - var1x.getDamage();
         String var5 = Integer.toString(var3x);

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

         if (this.f_0e10c7b3.m_284992ec() == C0293.anonymousnew.f_a1a6118b) {
            var5 = var4 + C0265.m_c254a253();
         }

         if (var3x > 0) {
            FontRenderer.drawStringWithShadow(Message.of(var5).style(Appearance.of(var6)), 0, 0, 16777215);
         }
      });
   }

   public static enum anonymousnew {
      f_a1a6118b,
      f_2c24be5c,
      f_eb6b5d7f,
      f_05df532a,
      f_d960805e;

      private anonymousnew() {
      }
   }

   public static enum anonymousstatic {
      f_0f01dce5,
      f_d70623b6,
      f_26d4ddfe;

      private anonymousstatic() {
      }
   }
}
