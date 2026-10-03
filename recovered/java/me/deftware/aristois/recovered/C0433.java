package me.deftware.aristois.recovered;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.menu.view.container.CollapsableContainerWidget;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.TitleWidget;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.render.shader.Shader;

public class C0433 extends C0446 {
   private final List<CollapsableContainerWidget> f_029b0342 = new ArrayList<>();
   private final String f_2bd8dde8 = C0252.bootstrap<"get",34359738460>();
   private final C0090 f_44cf4880;
   private boolean f_9e9fa810 = false;
   private float f_6468c0a5 = 0.0F;
   private C0434 f_12529023;

   public C0433() {
      super(null);
      this.f_4c07abdb = (C0441)C0114.bootstrap<"call",0,1>(C0432.class);
      this.f_44cf4880 = new C0090(this.f_4c07abdb, false);
      C0114.bootstrap<"call",1,1>(C0433.class, this);
      this.f_2bd8dde8 = C0252.bootstrap<"get",34359738460>();
   }

   @EventHandler
   private void m_c338e50c(EventMatrixRender var1) {
      if (C0114.bootstrap<"call",0,1>().getScreen() instanceof C0433 || C0114.bootstrap<"call",0,1>().getScreen() instanceof C0429) {
         this.f_65ff87ab.begin().drawRect(0.0F, 0.0F, 1.0F, 1.0F).end();
      }
   }

   public void m_55845879() {
      this.f_6468c0a5 = 0.0F;
      if (((C0297)C0114.bootstrap<"call",0,1>(C0297.class)).m_0f9961eb() && C0114.bootstrap<"call",1,1>() != null && !this.f_9e9fa810) {
         C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>().m_26765a8c());
         ((C0297)C0114.bootstrap<"call",0,1>(C0297.class)).m_1a27cacf(0.0F);
         this.f_9e9fa810 = true;
      }
   }

   public CollapsableContainerWidget m_e2309daa(C0290 var1) {
      CollapsableContainerWidget var2 = new CollapsableContainerWidget(20.0, 20.0, 200.0, 400.0, this.f_4c07abdb);
      var2.setResizable(true);
      var2.setDraggable(true);
      var2.setMinHeight(150.0);
      var2.setRenderShadow(true);
      var2.m_b1d9e3f4(var1.name());
      var2.addTitle(C0114.bootstrap<"call",1,1>(var1.name()), var1x -> {
         if (var1x == 1 && var2.togglePanel(true)) {
            var2.getTitle().getArrow().m_dcc9a738();
         }
      });
      TitleWidget var3 = var2.getTitle();
      C0234 var4 = C0228.f_1a35892e;
      var3.setIconU(var4.m_a41b5737(var1.ordinal()));
      var3.setIconV(var4.m_28584246(var1.ordinal()));
      var3.setDrawIcon(true);
      ListWidget var5 = new ListWidget(this.f_4c07abdb);
      var5.m_a0d63011().m_7e0ab7c8(var2.getTitle().m_cb4e693c().m_fc7f45bc());
      var5.m_43380922(new C0426[]{C0426.f_974a55e6, C0426.f_eabcfd17});
      var5.setRenderBackground(false);
      var2.m_0ae16aec(new C0163[]{var5});
      var5.m_2fe952ac(this.f_44cf4880.m_6f8c4366(var1));
      double var6 = var2.getTitle().m_cb4e693c().m_fc7f45bc();
      double var8 = var5.getChildrenHeight(var5.m_9562001a().size(), null) + var6 + 1.0;
      var2.m_5d4bfead().m_5078410c(C0114.bootstrap<"call",2,1>(400.0, var8));
      var2.setMaxHeight(var8);
      return var2;
   }

   protected void m_aff67899(double var1, double var3) {
      float var5 = 0.1F;
      if (C0114.bootstrap<"call",0,1>().getScreen() == this && C0114.bootstrap<"call",1,1>()) {
         C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>() + (var3 > 0.0 ? var5 : -var5));
      }
   }

   @Override
   protected void onGuiClose() {
      super.onGuiClose();
      JsonObject var1 = new JsonObject();

      for (CollapsableContainerWidget var3 : this.f_029b0342) {
         JsonObject var4 = new JsonObject();
         JsonObject var5 = C0125.f_70947d4f.m_77b61bf9(var3.m_5d4bfead(), C0165.class).getAsJsonObject();
         if (var3.isCollapsed()) {
            var5.addProperty(C0252.bootstrap<"get",34359738461>(), C0114.bootstrap<"call",0,1>(var3.getLastHeight() + var3.getTop()));
         }

         var4.add(C0252.bootstrap<"get",34359738462>(), var5);
         var4.addProperty(C0252.bootstrap<"get",34359738463>(), C0114.bootstrap<"call",1,1>(var3.isCollapsed()));
         var1.add(var3.m_2c419bb0(), var4);
      }

      C0114.bootstrap<"call",2,1>().putObject(C0252.bootstrap<"get",34359738460>(), var1);
      C0114.bootstrap<"call",2,1>().save();
      if (this.f_9e9fa810) {
         C0114.bootstrap<"call",3,1>((Shader)null);
      }

      this.f_9e9fa810 = false;
   }

   private void m_c1444226() {
      JsonObject var1 = C0114.bootstrap<"call",0,1>().getObject(C0252.bootstrap<"get",34359738460>());

      for (CollapsableContainerWidget var3 : this.f_029b0342) {
         if (var1.has(var3.m_2c419bb0())) {
            JsonObject var4 = var1.get(var3.m_2c419bb0()).getAsJsonObject();

            try {
               var3.m_5d4bfead().m_62dcf6b9((C0165)C0125.f_70947d4f.m_5f630fc1(var4.get(C0252.bootstrap<"get",34359738462>()).getAsJsonObject(), C0165.class));
            } catch (Exception var6) {
               var6.printStackTrace();
            }

            if (var4.get(C0252.bootstrap<"get",34359738463>()).getAsBoolean()) {
               var3.togglePanel(false);
               if (var3.m_b7206ffa().get(0) instanceof TitleWidget) {
                  ((TitleWidget)var3.m_b7206ffa().get(0)).getArrow().m_dcc9a738();
               }
            }
         }
      }
   }

   public void m_b66ba0ac() {
      if (C0114.bootstrap<"call",0,1>().hasKey(C0252.bootstrap<"get",34359738460>())) {
         C0114.bootstrap<"call",0,1>().remove(C0252.bootstrap<"get",34359738460>());
         C0114.bootstrap<"call",0,1>().save();
      }

      this.f_029b0342.clear();
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      if (C0114.bootstrap<"call",0,1>() == null) {
         C0223.f_7c6d0315.m_9f85df3c(C0114.bootstrap<"call",1,1>(), C0114.bootstrap<"call",2,1>());
      }

      super.onDraw(var1, var2, var3);
   }

   @Override
   public void onUpdate() {
      super.onUpdate();
      if (this.f_9e9fa810) {
         C0297 var1 = (C0297)C0114.bootstrap<"call",0,1>(C0297.class);
         float var2 = var1.m_653e01c1();
         if (this.f_6468c0a5 < var2) {
            this.f_6468c0a5 += var2 / 4.0F;
            var1.m_1a27cacf(this.f_6468c0a5);
         }
      }

      if (C0114.bootstrap<"call",1,1>() != null) {
         new EventUpdate(0.0, 0.0, 0.0, 0.0F, 0.0F, false).broadcast();
      }
   }

   protected void m_2a178558() {
      this.m_55845879();
      boolean var1 = false;
      if (this.f_029b0342.isEmpty()) {
         C0435 var2 = new C0435(0.0, 0.0, 200.0, 400.0, this.f_4c07abdb);
         var2.m_92a451b9(C0252.bootstrap<"get",34359738464>());
         var2.m_7d5d6794(this);
         C0430 var3 = new C0430(0.0, 0.0, 200.0, 400.0, this.f_4c07abdb);
         var3.m_a931562e(C0252.bootstrap<"get",34359738465>());
         var3.m_d24b6a6b(this);

         for (C0290 var7 : C0114.bootstrap<"call",3,1>()) {
            int var8 = (int)C0289.f_c22b8d7e.m_ea73e1f0().filter(var1x -> var1x.getCategory() == var7).count();
            if (var8 != 0) {
               CollapsableContainerWidget var9 = this.m_e2309daa(var7);
               this.f_029b0342.add(var9);
               var2.m_eaadae0d().m_2fe952ac(this.f_44cf4880.m_6f8c4366(var7));
               var3.m_7a902567().m_2fe952ac(this.f_44cf4880.m_6f8c4366(var7));
            }
         }

         this.f_029b0342.add(var2);
         this.f_029b0342.add(var3);
         this.f_12529023 = new C0434(0.0, 0.0, 500.0, 300.0, this.f_4c07abdb);
         this.f_12529023.setupComponents(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",34359738466>()));
         var1 = true;
      }

      this.m_e8236848(this.f_029b0342.toArray(new CollapsableContainerWidget[0]));
      if (var1) {
         if (C0114.bootstrap<"call",4,1>().hasKey(C0252.bootstrap<"get",34359738460>())) {
            this.m_c1444226();
         } else {
            this.m_7fff713a(10.0);
         }
      }

      if (!C0114.bootstrap<"call",4,1>().hasKey(C0252.bootstrap<"get",8589934610>())) {
         this.f_12529023.open(this);
      }
   }

   public void m_9ff7c171(boolean var1) {
      this.f_9e9fa810 = var1;
   }
}
