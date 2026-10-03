package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0409 extends AbstractMod {
   private C0219<C0246> f_114ef450 = new C0219<>(C0246.class, C0263.m_bec91365());
   @C0098(
      value = "Delay",
      description = {"Delay between each command"},
      number = @C0096(
         max = 100.0
      )
   )
   private int f_a91107c5 = 20;
   @C0098(
      value = "Interval",
      description = {"Delay type between each command"}
   )
   private C0102<C0409.anonymousconst> f_e39ee846 = new C0102<>(C0409.anonymousconst.f_b8eb9f1c);
   @C0098(
      value = "Commands",
      description = {"List of commands to execute"}
   )
   private final GuiScreen f_ed00db3d = new C0174<>(null, this.f_114ef450, C0263.m_b48a8bc4());
   private int f_b164df1e = 0;

   public C0409() {
      super(C0263.m_b48a8bc4(), C0290.f_dbc16475, C0263.m_b886ae1c());
      this.setMode(this.f_e39ee846);
   }

   @Override
   public void onEnable() {
      this.f_b164df1e = 0;
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      int var3 = this.f_e39ee846.m_284992ec() == C0409.anonymousconst.f_c6a759f7
         ? this.f_a91107c5
         : (this.f_e39ee846.m_284992ec() == C0409.anonymousconst.f_f5ac7a00 ? this.f_a91107c5 * 60 : this.f_a91107c5) * 20;
      if (this.f_b164df1e == var3) {
         this.f_114ef450.forEach(var2x -> var2.sendMessage(var2x.m_8d7dbe31(), this.getClass()));
         this.f_b164df1e = 0;
      }

      this.f_b164df1e++;
   }

   public static enum anonymousconst {
      f_f5ac7a00,
      f_b8eb9f1c,
      f_c6a759f7;

      private anonymousconst() {
      }
   }
}
