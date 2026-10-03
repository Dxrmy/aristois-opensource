package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.shader.Shader;

@C0422(344)
public class C0297 extends AbstractMod {
   @C0098(
      value = "Hide Hud",
      description = {"Hide hud when the main UI is open"}
   )
   private boolean f_2aa4dadd = true;
   @C0098(
      value = "Blur Background",
      description = {"Blur the background in the main UI"},
      id = 100
   )
   private boolean f_54cb9600 = true;
   @C0098(
      value = "Blur Strength",
      number = @C0096(
         min = 1.0,
         max = 30.0
      ),
      triggerPostChanged = true,
      id = 99
   )
   private float f_e1b4b443 = 20.0F;
   @C0098(
      value = "Show Keybinds",
      description = {"Show keybinds next to the mod name"}
   )
   private boolean f_908135c9 = false;
   @C0098("Icon Color")
   private Color f_923f7689 = Color.white;
   @C0098("Show Icons")
   private boolean f_4a112c2d = true;
   @C0098(
      value = "Scale",
      description = {"The size of the Aristois UI"},
      triggerPostChanged = true,
      id = 1,
      number = @C0096(
         min = 0.1,
         max = 4.0
      )
   )
   private C0103<Float> f_fc2e0768 = new C0103<>(RenderStack::getScale, RenderStack::setScale);
   private C0203<C0433> f_1aeb6db4 = new C0203<>(C0433::new);

   public C0297() {
      super(C0259.m_6f1f396d(), C0290.f_020f9141, C0259.m_8ced16bd());
   }

   @Override
   public void onEnable() {
      if (!(Minecraft.getMinecraftGame().getScreen() instanceof C0433)) {
         this.m_23674f64();
      }

      this.toggle();
   }

   public void m_23674f64() {
      Minecraft.getMinecraftGame().openScreen((GenericScreen)this.f_1aeb6db4.m_ac6eac3b());
   }

   @Override
   public String getDisplayName() {
      return C0259.m_15ef1a0d();
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() == 99) {
         this.m_d881d3e3(this.f_e1b4b443);
      }

      if (var1.id() == 100 && Minecraft.getMinecraftGame().getScreen() instanceof C0433) {
         C0433 var2 = (C0433)Minecraft.getMinecraftGame().getScreen();
         if (!this.f_54cb9600) {
            WindowHelper.loadShader((Shader)null);
         }

         var2.m_394ecb95(false);
         var2.m_41e83f88();
      }
   }

   public void m_d881d3e3(float var1) {
      Shader var2 = C0242.m_fc1b642c().m_e77ae4a1();
      var2.setUniform(C0259.m_9793dfe2(), new float[]{var1});
   }

   public boolean m_275ab222() {
      return this.f_2aa4dadd && Minecraft.getMinecraftGame().getScreen() instanceof C0433;
   }

   public void m_35150f14(boolean var1) {
      this.f_2aa4dadd = var1;
   }

   public void m_355190e6(boolean var1) {
      this.f_54cb9600 = var1;
   }

   public void m_35bea3d9(float var1) {
      this.f_e1b4b443 = var1;
   }

   public void m_279e21aa(boolean var1) {
      this.f_908135c9 = var1;
   }

   public void m_6e0baed2(Color var1) {
      this.f_923f7689 = var1;
   }

   public void m_1be53b7f(boolean var1) {
      this.f_4a112c2d = var1;
   }

   public void m_ec476b09(C0103<Float> var1) {
      this.f_fc2e0768 = var1;
   }

   public void m_99d6594e(C0203<C0433> var1) {
      this.f_1aeb6db4 = var1;
   }

   public boolean m_f21a055b() {
      return this.f_2aa4dadd;
   }

   public boolean m_6c9f39f9() {
      return this.f_54cb9600;
   }

   public float m_14287929() {
      return this.f_e1b4b443;
   }

   public boolean m_691d9b1d() {
      return this.f_908135c9;
   }

   public Color m_4aac060f() {
      return this.f_923f7689;
   }

   public boolean m_f057b877() {
      return this.f_4a112c2d;
   }

   public C0103<Float> m_42f34113() {
      return this.f_fc2e0768;
   }

   public C0203<C0433> m_c7e6be95() {
      return this.f_1aeb6db4;
   }
}
