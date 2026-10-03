package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.registry.ItemRegistry;
import me.deftware.client.framework.world.ClientWorld;

public class C0408 extends AbstractMod {
   private final C0219<Item> f_97d9aa44 = new C0219<>(
      Item.class,
      C0252.bootstrap<"get",38654705689>(),
      C0114.bootstrap<"call",0,1>(ItemRegistry.INSTANCE, new String[]{C0252.bootstrap<"get",30064771139>(), C0252.bootstrap<"get",30064771138>()})
         .toArray(new Item[0])
   );
   @C0098(
      value = "Eat Near Hostile",
      description = {"Eat when near hostile entities"}
   )
   private boolean f_51d67a66 = false;
   @C0098(
      value = "Trigger",
      description = {"At what hunger it should trigger"}
   )
   private float f_99db4db7 = 16.0F;
   @C0098(
      value = "Swap",
      description = {"Swap food to the hotbar when there is none"}
   )
   private boolean f_01dbd353 = true;
   @C0098(
      value = "Eat Raw",
      description = {"Allow AutoEat to eat raw food"}
   )
   private boolean f_eb3b23c1 = false;
   @C0098("Select Food")
   private final GuiScreen f_f5cdce3b = new C0196(
      null,
      this.f_97d9aa44,
      new C0206(ItemRegistry.INSTANCE, C0114.bootstrap<"call",1,1>()),
      C0252.bootstrap<"get",38654705690>(),
      var0 -> var0.getName().string()
   );
   @C0098("Mode")
   private C0102<C0408.anonymousconst> f_0edcb320 = new C0102<>(C0408.anonymousconst.f_41673f91);
   private final C0072 f_8fd0e789 = C0114.bootstrap<"call",2,1>().m_7ecd94e5(this::m_fd89b255);
   private C0073.anonymoustransient f_4110cef9;

   public C0408() {
      super(C0252.bootstrap<"get",38654705687>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705688>());
   }

   @Override
   public void onDisable() {
      this.f_4110cef9 = null;
   }

   @EventHandler
   public void m_143c5d1c(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      ClientWorld var3 = (ClientWorld)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",2,1>());
      boolean var4 = var3.getLoadedEntities().filter(Entity::isHostile).noneMatch(var1x -> var1x.distanceToEntity(var2) <= 6.0F);
      boolean var5 = C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen;
      if (!var2.isCreative() && (var4 || this.f_51d67a66) && !var5 && !this.m_a0240561() && (float)var2.getFoodLevel() < this.f_99db4db7) {
         int var6 = this.f_8fd0e789.m_a0aa8556();
         if (!C0114.bootstrap<"call",3,1>(var6) && !this.f_01dbd353) {
            var6 = this.f_8fd0e789.m_e05ba629();
         }

         if (var6 != -1) {
            if (!C0114.bootstrap<"call",3,1>(var6)) {
               C0073.anonymousdefault var7 = (C0073.anonymousdefault)((C0073.anonymousdefault)((C0073.anonymousdefault)C0114.bootstrap<"call",4,1>()
                        .m_44d897bb(var6))
                     .m_6a6e19f6())
                  .m_08fa2bad();
               var6 = var7.m_514a3e72();
            }

            this.f_4110cef9 = (C0073.anonymoustransient)((C0073.anonymoustransient)((C0073.anonymoustransient)C0114.bootstrap<"call",5,1>().m_0b9465d7(this))
                  .m_7f2aa0d0(var6))
               .m_10ff8762((int)this.f_99db4db7)
               .m_ea02cddd()
               .m_1d57acd4();
         }
      }
   }

   public boolean m_a0240561() {
      return this.f_4110cef9 != null && this.f_4110cef9.m_55d1c48f();
   }

   private boolean m_fd89b255(ItemStack var1) {
      Item var2 = var1.getItem();
      if (C0217.f_596d6937.contains(var2)) {
         return false;
      } else if (var2.getName().string().toLowerCase().contains(C0252.bootstrap<"get",38654705691>()) && !this.f_eb3b23c1) {
         return false;
      } else if (this.f_0edcb320.m_e2691446() == C0408.anonymousconst.f_8ecb8129) {
         return this.f_97d9aa44.contains(var2);
      } else {
         return this.f_0edcb320.m_e2691446() == C0408.anonymousconst.f_41673f91 ? !this.f_97d9aa44.contains(var2) : true;
      }
   }

   public static enum anonymousconst {
      f_dac01f07,
      f_8ecb8129,
      f_41673f91;

      private anonymousconst() {
      }
   }
}
