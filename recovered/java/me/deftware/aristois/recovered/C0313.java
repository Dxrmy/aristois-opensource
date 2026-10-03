package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.types.BlockProperty;
import me.deftware.client.framework.global.types.PropertyManager;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.helper.RenderHelper;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.block.Block;

@C0421
public class C0313 extends AbstractMod {
   private static final PropertyManager<BlockProperty> f_3a4e3dce = Bootstrap.blockProperties;
   private static final C0219<Block> f_d14a8081 = new C0219<Block>(Block.class, C0255.m_b886ae1c(), C0217.m_1bf3a42e()) {
      protected void m_63a72a13(Block var1, boolean var2) {
         super.m_cef1a7b6(var1, var2);
         if (var2) {
            C0313.f_3a4e3dce.remove(var1.getID());
         }

         C0289.m_24841a60(C0313.class, C0313::m_23674f64);
      }
   };
   @C0098("Blocks")
   private static final GuiScreen f_dcbc8714 = C0217.m_20baf8c9(null, f_d14a8081);
   @C0098(
      value = "Fluids",
      description = {"Render fluids"}
   )
   private C0104<Boolean> f_aa1e241b = new C0104<>(GameKeys.RENDER_FLUIDS, true).m_43d84283(this);
   @C0098(
      value = "Opacity",
      number = @C0096(
         min = 1.0,
         max = 255.0
      ),
      triggerPostChanged = true
   )
   private C0103<Float> f_361f162a = new C0103<Float>(Bootstrap.blockProperties::getOpacity, Bootstrap.blockProperties::setOpacity).m_01388fcf();
   @C0098(
      value = "Enable Opacity",
      description = {"Show non xray ores with the selected opacity", "", "Note: Opacity mode does not currently", "work with Fabric API or Sodium."}
   )
   private C0103<Boolean> f_3235184f = new C0103<Boolean>(Bootstrap.blockProperties::isOpacityMode, Bootstrap.blockProperties::setOpacityMode)
      .m_34ef27b9(false);
   @C0098(
      value = "Legit Mode",
      description = {"Only show ores that are visible"}
   )
   private C0103<Boolean> f_eb620fb6 = new C0103<Boolean>(Bootstrap.blockProperties::isExposedOnly, Bootstrap.blockProperties::setExposedOnly).m_01388fcf();
   @C0098(
      value = "Disable Caves",
      description = {"Render caves"}
   )
   private C0103<Boolean> f_ee5b4c9f = new C0103<Boolean>(Bootstrap.blockProperties::isDisableCaveRendering, Bootstrap.blockProperties::setDisableCaveRendering)
      .m_01388fcf();

   public C0313() {
      super(C0255.m_b251ca51(), C0290.f_3210deb7, C0255.m_b48a8bc4());
   }

   @Override
   public void onEnable() {
      f_3a4e3dce.setActive(true);
      this.m_23674f64();
   }

   public void m_23674f64() {
      for (Block var2 : f_d14a8081) {
         if (!f_3a4e3dce.contains(var2.getID())) {
            f_3a4e3dce.register(new BlockProperty(var2).setLuminance(15).setRender(true).setTranslucent(true));
         }
      }

      if (this.isEnabled()) {
         this.m_f1ec3ae8();
      }
   }

   @Override
   public void onDisable() {
      f_3a4e3dce.setActive(false);
      this.m_f1ec3ae8();
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (this.isEnabled()) {
         this.m_f1ec3ae8();
      }
   }

   private void m_f1ec3ae8() {
      if (ClientWorld.getClientWorld() != null) {
         Minecraft.getMinecraftGame().runOnRenderThread(RenderHelper::reloadRenderers);
      }
   }

   public static C0219<Block> m_001ab21f() {
      return f_d14a8081;
   }

   public static GuiScreen m_1ebb9a23() {
      return f_dcbc8714;
   }

   public C0103<Float> m_540bd8b4() {
      return this.f_361f162a;
   }
}
