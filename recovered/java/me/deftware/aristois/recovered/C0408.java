package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.registry.ItemRegistry;
import me.deftware.client.framework.world.ClientWorld;

public class C0408 extends AbstractMod {
   private final C0219<Item> f_8b5675bd = new C0219<>(
      Item.class, C0263.m_e07cee76(), C0207.m_2290cbf8(ItemRegistry.INSTANCE, C0265.m_9d6ca6d0(), C0265.m_b526dd3b()).toArray(new Item[0])
   );
   @C0098(
      value = "Eat Near Hostile",
      description = {"Eat when near hostile entities"}
   )
   private boolean f_dc3c81b8 = false;
   @C0098(
      value = "Trigger",
      description = {"At what hunger it should trigger"}
   )
   private float f_c33f4337 = 16.0F;
   @C0098(
      value = "Swap",
      description = {"Swap food to the hotbar when there is none"}
   )
   private boolean f_3a1c7170 = true;
   @C0098(
      value = "Eat Raw",
      description = {"Allow AutoEat to eat raw food"}
   )
   private boolean f_3dcbfe95 = false;
   @C0098("Select Food")
   private final GuiScreen f_be6c259e = new C0196(
      null, this.f_8b5675bd, new C0206<>(ItemRegistry.INSTANCE, C0217.m_cba00437()), C0263.m_7b0db73e(), var0 -> var0.getName().string()
   );
   @C0098("Mode")
   private C0102<C0408.anonymousconst> f_564a8764 = new C0102<>(C0408.anonymousconst.f_da97df3b);
   private final C0072 f_9565ac30 = C0072.m_11e5d51a().m_2b5aea64(this::m_0ef10883);
   private C0073.anonymoustransient f_202aa379;

   public C0408() {
      super(C0263.m_79bfaec2(), C0290.f_dbc16475, C0263.m_2e834348());
   }

   @Override
   public void onDisable() {
      this.f_202aa379 = null;
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      ClientWorld var3 = Objects.requireNonNull(ClientWorld.getClientWorld());
      boolean var4 = var3.getLoadedEntities().filter(Entity::isHostile).noneMatch(var1x -> var1x.distanceToEntity(var2) <= 6.0F);
      boolean var5 = Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen;
      if (!var2.isCreative() && (var4 || this.f_dc3c81b8) && !var5 && !this.m_275ab222() && (float)var2.getFoodLevel() < this.f_c33f4337) {
         int var6 = this.f_9565ac30.m_eb304949();
         if (!C0073.m_aa45d95d(var6) && !this.f_3a1c7170) {
            var6 = this.f_9565ac30.m_b8bdb7ac();
         }

         if (var6 != -1) {
            if (!C0073.m_aa45d95d(var6)) {
               C0073.anonymousdefault var7 = C0073.m_f76a4979().m_e1463257(var6).m_b252dc95().m_ac6eac3b();
               var6 = var7.m_eb304949();
            }

            this.f_202aa379 = C0073.m_24e329e8().m_8c218980(this).m_7c42e94f(var6).m_fb3f041e((int)this.f_c33f4337).m_eb3bce89().m_ac6eac3b();
         }
      }
   }

   public boolean m_275ab222() {
      return this.f_202aa379 != null && this.f_202aa379.m_e0f7c666();
   }

   private boolean m_0ef10883(ItemStack var1) {
      Item var2 = var1.getItem();
      if (C0217.f_e8d94395.contains(var2)) {
         return false;
      } else if (var2.getName().string().toLowerCase().contains(C0263.m_056a389d()) && !this.f_3dcbfe95) {
         return false;
      } else if (this.f_564a8764.m_284992ec() == C0408.anonymousconst.f_52516b0e) {
         return this.f_8b5675bd.contains(var2);
      } else {
         return this.f_564a8764.m_284992ec() == C0408.anonymousconst.f_da97df3b ? !this.f_8b5675bd.contains(var2) : true;
      }
   }

   public static enum anonymousconst {
      f_fbdd07a7,
      f_52516b0e,
      f_da97df3b;

      private anonymousconst() {
      }
   }
}
