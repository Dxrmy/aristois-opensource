package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.types.BlockProperty;
import me.deftware.client.framework.global.types.PropertyManager;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.helper.RenderHelper;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.world.block.Block;

@C0421
public class C0313 extends AbstractMod {
   private static final PropertyManager<BlockProperty> f_0d1b320d = Bootstrap.blockProperties;
   private static final C0219<Block> f_af89ca2d = new C0219<Block>(Block.class, C0252.bootstrap<"get",51539607573>(), C0114.bootstrap<"call",0,1>()) {
      protected void m_53036258(Block var1, boolean var2) {
         super.m_2bf95354(var1, var2);
         if (var2) {
            C0114.bootstrap<"call",0,1>().remove(var1.getID());
         }

         C0114.bootstrap<"call",1,1>(C0313.class, C0313::m_bf6ca082);
      }
   };
   @C0098("Blocks")
   private static final GuiScreen f_a6b2a1a2 = C0114.bootstrap<"call",1,1>(null, f_af89ca2d);
   @C0098(
      value = "Fluids",
      description = {"Render fluids"}
   )
   private C0104<Boolean> f_592b8ebb = new C0104<>(GameKeys.RENDER_FLUIDS, C0114.bootstrap<"call",0,1>(true)).m_958520b0(this);
   @C0098(
      value = "Opacity",
      number = @C0096(
         min = 1.0,
         max = 255.0
      ),
      triggerPostChanged = true
   )
   private C0103<Float> f_5b6ac69f = new C0103<Float>(Bootstrap.blockProperties::getOpacity, Bootstrap.blockProperties::setOpacity).m_d66ab8dc();
   @C0098(
      value = "Enable Opacity",
      description = {"Show non xray ores with the selected opacity", "", "Note: Opacity mode does not currently", "work with Fabric API or Sodium."}
   )
   private C0103<Boolean> f_21f734f6 = new C0103<Boolean>(Bootstrap.blockProperties::isOpacityMode, Bootstrap.blockProperties::setOpacityMode)
      .m_7c5d8048(false);
   @C0098(
      value = "Legit Mode",
      description = {"Only show ores that are visible"}
   )
   private C0103<Boolean> f_d978d0c3 = new C0103<Boolean>(Bootstrap.blockProperties::isExposedOnly, Bootstrap.blockProperties::setExposedOnly).m_d66ab8dc();
   @C0098(
      value = "Disable Caves",
      description = {"Render caves"}
   )
   private C0103<Boolean> f_1f71b9e4 = new C0103<Boolean>(Bootstrap.blockProperties::isDisableCaveRendering, Bootstrap.blockProperties::setDisableCaveRendering)
      .m_d66ab8dc();

   public C0313() {
      super(C0252.bootstrap<"get",51539607571>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",51539607572>());
   }

   @Override
   public void onEnable() {
      f_0d1b320d.setActive(true);
      this.m_bf6ca082();
   }

   public void m_bf6ca082() {
      for (Block var2 : f_af89ca2d) {
         if (!f_0d1b320d.contains(var2.getID())) {
            f_0d1b320d.register(new BlockProperty(var2).setLuminance(15).setRender(true).setTranslucent(true));
         }
      }

      if (this.isEnabled()) {
         this.m_35525e1b();
      }
   }

   @Override
   public void onDisable() {
      f_0d1b320d.setActive(false);
      this.m_35525e1b();
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (this.isEnabled()) {
         this.m_35525e1b();
      }
   }

   private void m_35525e1b() {
      if (C0114.bootstrap<"call",0,1>() != null) {
         C0114.bootstrap<"call",1,1>().runOnRenderThread(RenderHelper::reloadRenderers);
      }
   }

   public static C0219<Block> m_600f6c27() {
      return f_af89ca2d;
   }

   public static GuiScreen m_ed400096() {
      return f_a6b2a1a2;
   }

   public C0103<Float> m_75787c14() {
      return this.f_5b6ac69f;
   }
}
