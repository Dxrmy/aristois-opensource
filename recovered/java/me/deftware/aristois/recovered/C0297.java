package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.shader.Shader;

@C0422(344)
public class C0297 extends AbstractMod {
   @C0098(
      value = "Hide Hud",
      description = {"Hide hud when the main UI is open"}
   )
   private boolean f_b5e19bca = true;
   @C0098(
      value = "Blur Background",
      description = {"Blur the background in the main UI"},
      id = 100
   )
   private boolean f_13282148 = true;
   @C0098(
      value = "Blur Strength",
      number = @C0096(
         min = 1.0,
         max = 30.0
      ),
      triggerPostChanged = true,
      id = 99
   )
   private float f_dacdac35 = 20.0F;
   @C0098(
      value = "Show Keybinds",
      description = {"Show keybinds next to the mod name"}
   )
   private boolean f_547c095d = false;
   @C0098("Icon Color")
   private Color f_4c819326 = Color.white;
   @C0098("Show Icons")
   private boolean f_83daf926 = true;
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
   private C0103<Float> f_8226538b = new C0103<>(RenderStack::getScale, RenderStack::setScale);
   private C0203<C0433> f_f9d4c95c = new C0203<>(C0433::new);

   public C0297() {
      super(C0252.bootstrap<"get",42949672971>(), C0290.f_5fe5d165, C0252.bootstrap<"get",42949672972>());
   }

   @Override
   public void onEnable() {
      if (!(C0114.bootstrap<"call",0,1>().getScreen() instanceof C0433)) {
         this.m_b76ad674();
      }

      this.toggle();
   }

   public void m_b76ad674() {
      C0114.bootstrap<"call",0,1>().openScreen((GenericScreen)this.f_f9d4c95c.m_1c30b0a8());
   }

   @Override
   public String getDisplayName() {
      return C0252.bootstrap<"get",42949672973>();
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() == 99) {
         this.m_1a27cacf(this.f_dacdac35);
      }

      if (var1.id() == 100 && C0114.bootstrap<"call",0,1>().getScreen() instanceof C0433) {
         C0433 var2 = (C0433)C0114.bootstrap<"call",0,1>().getScreen();
         if (!this.f_13282148) {
            C0114.bootstrap<"call",1,1>((Shader)null);
         }

         var2.m_9ff7c171(false);
         var2.m_55845879();
      }
   }

   public void m_1a27cacf(float var1) {
      Shader var2 = C0114.bootstrap<"call",0,1>().m_26765a8c();
      var2.setUniform(C0252.bootstrap<"get",42949672974>(), new float[]{var1});
   }

   public boolean m_7458b21f() {
      return this.f_b5e19bca && C0114.bootstrap<"call",0,1>().getScreen() instanceof C0433;
   }

   public void m_77c64582(boolean var1) {
      this.f_b5e19bca = var1;
   }

   public void m_eaa5079e(boolean var1) {
      this.f_13282148 = var1;
   }

   public void m_c11b7aab(float var1) {
      this.f_dacdac35 = var1;
   }

   public void m_5d8e13d8(boolean var1) {
      this.f_547c095d = var1;
   }

   public void m_8a12b7e1(Color var1) {
      this.f_4c819326 = var1;
   }

   public void m_f1b374a3(boolean var1) {
      this.f_83daf926 = var1;
   }

   public void m_419b497a(C0103<Float> var1) {
      this.f_8226538b = var1;
   }

   public void m_84627c09(C0203<C0433> var1) {
      this.f_f9d4c95c = var1;
   }

   public boolean m_d9eb1bab() {
      return this.f_b5e19bca;
   }

   public boolean m_0f9961eb() {
      return this.f_13282148;
   }

   public float m_653e01c1() {
      return this.f_dacdac35;
   }

   public boolean m_4e638610() {
      return this.f_547c095d;
   }

   public Color m_0a1415e1() {
      return this.f_4c819326;
   }

   public boolean m_85d9b73d() {
      return this.f_83daf926;
   }

   public C0103<Float> m_31f60b67() {
      return this.f_8226538b;
   }

   public C0203<C0433> m_bd86fc72() {
      return this.f_f9d4c95c;
   }
}
