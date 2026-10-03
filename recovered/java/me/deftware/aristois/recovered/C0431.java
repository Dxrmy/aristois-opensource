package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.aristois.menu.widgets.ModButton;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.GameSetting;

@C0422
@C0099
public class C0431 extends AbstractMod implements C0440 {
   private final List<C0163> f_00044f8c = new CopyOnWriteArrayList<>();
   private ListWidget f_0c923a3a;
   private double f_7547785a = 15.0;
   private C0441 f_946d5b87 = C0289.m_c3a8b502(C0432.class);
   private C0090 f_4359a72d = new C0090(this.f_946d5b87, true);
   private ListWidget f_59a440d8 = null;

   public C0431() {
      super(C0262.m_0223faff(), C0290.f_020f9141, C0262.m_bdbd5e40());
      this.f_4359a72d.m_ed46fa58().add(C0431.class);
      this.f_4359a72d.m_8d86689a(this);
   }

   @Override
   public void m_cb54a800(C0163... var1) {
      this.f_00044f8c.addAll(Arrays.asList(var1));
   }

   private void m_1058ed9a() {
      this.f_0c923a3a = new ListWidget(this.f_7547785a, this.f_7547785a, 150.0, 0.0, this.f_946d5b87);
      this.f_0c923a3a.m_d6ac7420(true);
      this.f_0c923a3a.setRenderShadow(true);
      int var1 = 0;

      for (C0290 var5 : C0290.values()) {
         int var6 = (int)C0289.f_85a7343f.m_918b7b9e().filter(var1x -> var1x.getCategory() == var5).count();
         if (var6 != 0) {
            this.m_6c3bf086(Message.of(var5.name()), this.m_4b1d3ef6(var5), var1++, this.f_0c923a3a);
            if (this.f_59a440d8 == null) {
               this.f_59a440d8 = this.m_4b1d3ef6(var5);
            } else {
               this.f_59a440d8.m_cb54a800(this.f_4359a72d.m_e0d7439c(var5));
            }
         }
      }

      this.f_59a440d8.setFilter(var0 -> var0 instanceof ModButton ? ((ModButton)var0).getMod().isPinned() : false);
      this.f_59a440d8.m_44bb072f().m_61ade8f3(Math.min(400.0, this.f_59a440d8.getChildrenHeight(this.f_59a440d8.getMaxSelectionIndex() - 2, null)));
      this.m_6c3bf086(Message.of(C0266.m_8ccfdf29()), this.f_59a440d8, C0290.values().length, this.f_0c923a3a);
      this.f_0c923a3a.m_44bb072f().m_61ade8f3(this.f_0c923a3a.getChildrenHeight(this.f_0c923a3a.m_98dc1191().size() - 1, null) + 1.0);
      this.f_00044f8c.add(this.f_0c923a3a);
   }

   private ListWidget m_4b1d3ef6(C0290 var1) {
      ListWidget var2 = new ListWidget(
         this.f_0c923a3a.m_44bb072f().m_a005efae() + this.f_0c923a3a.m_44bb072f().m_4388ac29() + this.f_0c923a3a.getShadowSize(),
         0.0,
         200.0,
         400.0,
         this.f_946d5b87
      ) {
         @Override
         public boolean m_82e0832a(int var1, int var2, int var3) {
            if (var1 == 263) {
               C0431.this.f_00044f8c.remove(C0431.this.f_00044f8c.size() - 1);
               return true;
            } else {
               return super.m_82e0832a(var1, var2, var3);
            }
         }
      };
      var2.setRenderShadow(true);
      var2.m_d6ac7420(true);
      var2.setStencil(true);
      var2.m_cb54a800(this.f_4359a72d.m_e0d7439c(var1));
      var2.m_44bb072f().m_61ade8f3(Math.min(400.0, var2.getChildrenHeight(var2.getMaxSelectionIndex() - 2, null)));
      return var2;
   }

   private void m_ce457887(ListWidget var1) {
      if (var1.equals(this.f_59a440d8)) {
         var1.m_44bb072f().m_61ade8f3(Math.min(400.0, var1.getChildrenHeight(var1.getMaxSelectionIndex() - 2, null)));
      }

      this.f_00044f8c.add(var1);
   }

   private void m_6c3bf086(Message var1, final ListWidget var2, int var3, ListWidget var4) {
      ButtonWidget var5 = new ButtonWidget(var1, this.f_946d5b87) {
         @Override
         protected void onClick(int var1) {
            if (var1 == 0) {
               C0431.this.m_ce457887(var2);
            }
         }
      };
      var5.updatePadding(this.f_4359a72d.m_a005efae());
      var5.m_ec141b95(new C0426[]{C0426.f_c285454f});
      var2.m_44bb072f().m_01fed791(var4.m_44bb072f().m_84808068() + var5.m_44bb072f().m_d42f3372() * (double)var3);
      var4.m_cb54a800(new C0163[]{var5});
   }

   @EventHandler
   public void m_1e0a909c(EventKeyAction var1) {
      if (this.m_89e0519f() && !this.f_00044f8c.isEmpty()) {
         this.f_00044f8c.get(this.f_00044f8c.size() - 1).m_82e0832a(var1.getKeyCode(), var1.getAction(), var1.getModifiers());
      }
   }

   @EventHandler
   private void m_5d3a4d80(EventMatrixRender var1) {
      if (this.m_89e0519f()) {
         this.f_00044f8c.forEach(var1x -> var1x.m_572d14e6(-1.0, -1.0, var1.getPartialTicks(), false));
      }
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      if (this.f_00044f8c.isEmpty()) {
         this.m_1058ed9a();
         this.f_00044f8c.forEach(C0163::m_1058ed9a);
      }

      this.f_00044f8c.forEach(C0163::m_0e265701);
   }

   public double m_84808068() {
      return this.f_0c923a3a != null ? this.f_7547785a * 2.0 + this.f_0c923a3a.m_44bb072f().m_d42f3372() : this.f_7547785a;
   }

   protected boolean m_89e0519f() {
      return !(Boolean)GameSetting.DEBUG_INFO.get() && !C0289.m_c3a8b502(C0297.class).m_275ab222();
   }

   @Override
   public List<C0163> m_98dc1191() {
      return this.f_00044f8c;
   }

   public double m_d42f3372() {
      return this.f_7547785a;
   }
}
