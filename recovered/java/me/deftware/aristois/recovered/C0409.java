package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;

public class C0409 extends AbstractMod {
   private C0219<C0246> f_7d2789ac = new C0219<>(C0246.class, C0252.bootstrap<"get",38654705686>());
   @C0098(
      value = "Delay",
      description = {"Delay between each command"},
      number = @C0096(
         max = 100.0
      )
   )
   private int f_57dce2ac = 20;
   @C0098(
      value = "Interval",
      description = {"Delay type between each command"}
   )
   private C0102<C0409.anonymousconst> f_62efa0a1 = new C0102<>(C0409.anonymousconst.f_70dd2e0d);
   @C0098(
      value = "Commands",
      description = {"List of commands to execute"}
   )
   private final GuiScreen f_0caa8ec4 = new C0174<>(null, this.f_7d2789ac, C0252.bootstrap<"get",38654705684>());
   private int f_a2f0eea4 = 0;

   public C0409() {
      super(C0252.bootstrap<"get",38654705684>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705685>());
      this.setMode(this.f_62efa0a1);
   }

   @Override
   public void onEnable() {
      this.f_a2f0eea4 = 0;
   }

   @EventHandler
   public void m_84252ce9(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      int var3 = this.f_62efa0a1.m_e2691446() == C0409.anonymousconst.f_9ff7d0fc
         ? this.f_57dce2ac
         : (this.f_62efa0a1.m_e2691446() == C0409.anonymousconst.f_a365529c ? this.f_57dce2ac * 60 : this.f_57dce2ac) * 20;
      if (this.f_a2f0eea4 == var3) {
         this.f_7d2789ac.forEach(var2x -> var2.sendMessage(var2x.m_4dd2758c(), this.getClass()));
         this.f_a2f0eea4 = 0;
      }

      this.f_a2f0eea4++;
   }

   public static enum anonymousconst {
      f_a365529c,
      f_70dd2e0d,
      f_9ff7d0fc;

      private anonymousconst() {
      }
   }
}
