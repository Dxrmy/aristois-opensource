package me.deftware.aristois.recovered;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.menu.view.container.CollapsableContainerWidget;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.TitleWidget;
import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.shader.Shader;
import me.deftware.client.framework.world.ClientWorld;

public class C0433 extends C0446 {
   private final List<CollapsableContainerWidget> f_e8e6217a = new ArrayList<>();
   private final String f_3ed8aec4 = C0262.m_fac478b2();
   private final C0090 f_c1095bf7;
   private boolean f_b834bc72 = false;
   private float f_d86e508c = 0.0F;
   private C0434 f_e65f905a;

   public C0433() {
      super(null);
      this.f_b48b1555 = C0289.m_c3a8b502(C0432.class);
      this.f_c1095bf7 = new C0090(this.f_b48b1555, false);
      EventBus.registerClass(C0433.class, this);
      this.f_3ed8aec4 = C0262.m_fac478b2();
   }

   @EventHandler
   private void m_5d3a4d80(EventMatrixRender var1) {
      if (Minecraft.getMinecraftGame().getScreen() instanceof C0433 || Minecraft.getMinecraftGame().getScreen() instanceof C0429) {
         this.f_5cd8cdfe.begin().drawRect(0.0F, 0.0F, 1.0F, 1.0F).end();
      }
   }

   public void m_41e83f88() {
      this.f_d86e508c = 0.0F;
      if (C0289.m_c3a8b502(C0297.class).m_6c9f39f9() && ClientWorld.getClientWorld() != null && !this.f_b834bc72) {
         WindowHelper.loadShader(C0242.m_fc1b642c().m_e77ae4a1());
         C0289.m_c3a8b502(C0297.class).m_d881d3e3(0.0F);
         this.f_b834bc72 = true;
      }
   }

   public CollapsableContainerWidget m_a3336c6b(C0290 var1) {
      CollapsableContainerWidget var2 = new CollapsableContainerWidget(20.0, 20.0, 200.0, 400.0, this.f_b48b1555);
      var2.setResizable(true);
      var2.setDraggable(true);
      var2.setMinHeight(150.0);
      var2.setRenderShadow(true);
      var2.m_a11708c5(var1.name());
      var2.addTitle(Message.of(var1.name()), var1x -> {
         if (var1x == 1 && var2.togglePanel(true)) {
            var2.getTitle().getArrow().m_1058ed9a();
         }
      });
      TitleWidget var3 = var2.getTitle();
      C0234 var4 = C0228.f_12b529e0;
      var3.setIconU(var4.m_a73ee2be(var1.ordinal()));
      var3.setIconV(var4.m_8cb6f232(var1.ordinal()));
      var3.setDrawIcon(true);
      ListWidget var5 = new ListWidget(this.f_b48b1555);
      var5.m_44bb072f().m_01fed791(var2.getTitle().m_44bb072f().m_d42f3372());
      var5.m_ec141b95(new C0426[]{C0426.f_c285454f, C0426.f_f7a0f908});
      var5.setRenderBackground(false);
      var2.m_cb54a800(new C0163[]{var5});
      var5.m_cb54a800(this.f_c1095bf7.m_e0d7439c(var1));
      double var6 = var2.getTitle().m_44bb072f().m_d42f3372();
      double var8 = var5.getChildrenHeight(var5.m_98dc1191().size(), null) + var6 + 1.0;
      var2.m_44bb072f().m_61ade8f3(Math.min(400.0, var8));
      var2.setMaxHeight(var8);
      return var2;
   }

   @Override
   protected void m_0eebc025(double var1, double var3) {
      float var5 = 0.1F;
      if (Minecraft.getMinecraftGame().getScreen() == this && Keyboard.isCtrlPressed()) {
         RenderStack.setScale(RenderStack.getScale() + (var3 > 0.0 ? var5 : -var5));
      }
   }

   @Override
   protected void onGuiClose() {
      super.onGuiClose();
      JsonObject var1 = new JsonObject();

      for (CollapsableContainerWidget var3 : this.f_e8e6217a) {
         JsonObject var4 = new JsonObject();
         JsonObject var5 = C0125.f_94eb86f7.m_a7c6d791(var3.m_44bb072f(), C0165.class).getAsJsonObject();
         if (var3.isCollapsed()) {
            var5.addProperty(C0262.m_9bf0a29a(), var3.getLastHeight() + var3.getTop());
         }

         var4.add(C0262.m_85cd13b4(), var5);
         var4.addProperty(C0262.m_65c7e6e6(), var3.isCollapsed());
         var1.add(var3.m_3d3a8736(), var4);
      }

      Main.getConfig().putObject(C0262.m_fac478b2(), var1);
      Main.getConfig().save();
      if (this.f_b834bc72) {
         WindowHelper.loadShader((Shader)null);
      }

      this.f_b834bc72 = false;
   }

   private void m_23674f64() {
      JsonObject var1 = Main.getConfig().getObject(C0262.m_fac478b2());

      for (CollapsableContainerWidget var3 : this.f_e8e6217a) {
         if (var1.has(var3.m_3d3a8736())) {
            JsonObject var4 = var1.get(var3.m_3d3a8736()).getAsJsonObject();

            try {
               var3.m_44bb072f().m_9ee17df4((C0165)C0125.f_94eb86f7.m_b3b664ad(var4.get(C0262.m_85cd13b4()).getAsJsonObject(), C0165.class));
            } catch (Exception var6) {
               var6.printStackTrace();
            }

            if (var4.get(C0262.m_65c7e6e6()).getAsBoolean()) {
               var3.togglePanel(false);
               if (var3.m_98dc1191().get(0) instanceof TitleWidget) {
                  ((TitleWidget)var3.m_98dc1191().get(0)).getArrow().m_1058ed9a();
               }
            }
         }
      }
   }

   public void m_f1ec3ae8() {
      if (Main.getConfig().hasKey(C0262.m_fac478b2())) {
         Main.getConfig().remove(C0262.m_fac478b2());
         Main.getConfig().save();
      }

      this.f_e8e6217a.clear();
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      if (ClientWorld.getClientWorld() == null) {
         C0223.f_a04019fa.m_d7db8b4a(GuiScreen.getScaledWidth(), GuiScreen.getScaledHeight());
      }

      super.onDraw(var1, var2, var3);
   }

   @Override
   public void onUpdate() {
      super.onUpdate();
      if (this.f_b834bc72) {
         C0297 var1 = C0289.m_c3a8b502(C0297.class);
         float var2 = var1.m_14287929();
         if (this.f_d86e508c < var2) {
            this.f_d86e508c += var2 / 4.0F;
            var1.m_d881d3e3(this.f_d86e508c);
         }
      }

      if (ClientWorld.getClientWorld() != null) {
         new EventUpdate(0.0, 0.0, 0.0, 0.0F, 0.0F, false).broadcast();
      }
   }

   @Override
   protected void m_1058ed9a() {
      this.m_41e83f88();
      boolean var1 = false;
      if (this.f_e8e6217a.isEmpty()) {
         C0435 var2 = new C0435(0.0, 0.0, 200.0, 400.0, this.f_b48b1555);
         var2.m_a11708c5(C0262.m_a19a564f());
         var2.m_992e0c64(this);
         C0430 var3 = new C0430(0.0, 0.0, 200.0, 400.0, this.f_b48b1555);
         var3.m_a11708c5(C0262.m_03430357());
         var3.m_992e0c64(this);

         for (C0290 var7 : C0290.values()) {
            int var8 = (int)C0289.f_85a7343f.m_918b7b9e().filter(var1x -> var1x.getCategory() == var7).count();
            if (var8 != 0) {
               CollapsableContainerWidget var9 = this.m_a3336c6b(var7);
               this.f_e8e6217a.add(var9);
               var2.m_1375bd37().m_cb54a800(this.f_c1095bf7.m_e0d7439c(var7));
               var3.m_1375bd37().m_cb54a800(this.f_c1095bf7.m_e0d7439c(var7));
            }
         }

         this.f_e8e6217a.add(var2);
         this.f_e8e6217a.add(var3);
         this.f_e65f905a = new C0434(0.0, 0.0, 500.0, 300.0, this.f_b48b1555);
         this.f_e65f905a.setupComponents(Message.of(C0262.m_ec329d2e()));
         var1 = true;
      }

      this.m_4f7d4126(this.f_e8e6217a.toArray(new CollapsableContainerWidget[0]));
      if (var1) {
         if (Main.getConfig().hasKey(C0262.m_fac478b2())) {
            this.m_23674f64();
         } else {
            this.m_ddfd9367(10.0);
         }
      }

      if (!Main.getConfig().hasKey(C0253.m_cf4f91f1())) {
         this.f_e65f905a.open(this);
      }
   }

   public void m_394ecb95(boolean var1) {
      this.f_b834bc72 = var1;
   }
}
