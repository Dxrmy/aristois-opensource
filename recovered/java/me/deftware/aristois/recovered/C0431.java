package me.deftware.aristois.recovered;

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
   private final List<C0163> f_2e5a2c2e = new CopyOnWriteArrayList<>();
   private ListWidget f_8635fafb;
   private double f_82532c85 = 15.0;
   private C0441 f_75ef786c = (C0441)C0114.bootstrap<"call",0,1>(C0432.class);
   private C0090 f_edf25271 = new C0090(this.f_75ef786c, true);
   private ListWidget f_69d90b11 = null;

   public C0431() {
      super(C0252.bootstrap<"get",34359738469>(), C0290.f_5fe5d165, C0252.bootstrap<"get",34359738470>());
      this.f_edf25271.m_5335192e().add(C0431.class);
      this.f_edf25271.m_644138ac(this);
   }

   public void m_5fbd4bb7(C0163... var1) {
      this.f_2e5a2c2e.addAll(C0114.bootstrap<"call",0,1>(var1));
   }

   private void m_21da19b8() {
      this.f_8635fafb = new ListWidget(this.f_82532c85, this.f_82532c85, 150.0, 0.0, this.f_75ef786c);
      this.f_8635fafb.m_c71b0a3c(true);
      this.f_8635fafb.setRenderShadow(true);
      int var1 = 0;

      for (C0290 var5 : C0114.bootstrap<"call",1,1>()) {
         int var6 = (int)C0289.f_c22b8d7e.m_ea73e1f0().filter(var1x -> var1x.getCategory() == var5).count();
         if (var6 != 0) {
            this.m_5f7841cd(C0114.bootstrap<"call",2,1>(var5.name()), this.m_2657a03d(var5), var1++, this.f_8635fafb);
            if (this.f_69d90b11 == null) {
               this.f_69d90b11 = this.m_2657a03d(var5);
            } else {
               this.f_69d90b11.m_2fe952ac(this.f_edf25271.m_6f8c4366(var5));
            }
         }
      }

      this.f_69d90b11.setFilter(var0 -> var0 instanceof ModButton ? ((ModButton)var0).getMod().isPinned() : false);
      this.f_69d90b11
         .m_a0d63011()
         .m_5078410c(C0114.bootstrap<"call",3,1>(400.0, this.f_69d90b11.getChildrenHeight(this.f_69d90b11.getMaxSelectionIndex() - 2, null)));
      this.m_5f7841cd(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",12884901988>()), this.f_69d90b11, C0114.bootstrap<"call",1,1>().length, this.f_8635fafb);
      this.f_8635fafb.m_a0d63011().m_5078410c(this.f_8635fafb.getChildrenHeight(this.f_8635fafb.m_9562001a().size() - 1, null) + 1.0);
      this.f_2e5a2c2e.add(this.f_8635fafb);
   }

   private ListWidget m_2657a03d(C0290 var1) {
      ListWidget var2 = new ListWidget(
         this.f_8635fafb.m_a0d63011().m_14f8bc2c() + this.f_8635fafb.m_a0d63011().m_830cb294() + this.f_8635fafb.getShadowSize(),
         0.0,
         200.0,
         400.0,
         this.f_75ef786c
      ) {
         public boolean m_934038de(int var1, int var2, int var3) {
            if (var1 == 263) {
               C0114.bootstrap<"call",0,1>(C0431.this).remove(C0114.bootstrap<"call",0,1>(C0431.this).size() - 1);
               return true;
            } else {
               return super.m_f740f834(var1, var2, var3);
            }
         }
      };
      var2.setRenderShadow(true);
      var2.m_c71b0a3c(true);
      var2.setStencil(true);
      var2.m_2fe952ac(this.f_edf25271.m_6f8c4366(var1));
      var2.m_a0d63011().m_5078410c(C0114.bootstrap<"call",3,1>(400.0, var2.getChildrenHeight(var2.getMaxSelectionIndex() - 2, null)));
      return var2;
   }

   private void m_a7f313f7(ListWidget var1) {
      if (var1.equals(this.f_69d90b11)) {
         var1.m_a0d63011().m_5078410c(C0114.bootstrap<"call",3,1>(400.0, var1.getChildrenHeight(var1.getMaxSelectionIndex() - 2, null)));
      }

      this.f_2e5a2c2e.add(var1);
   }

   private void m_5f7841cd(Message var1, final ListWidget var2, int var3, ListWidget var4) {
      ButtonWidget var5 = new ButtonWidget(var1, this.f_75ef786c) {
         @Override
         protected void onClick(int var1) {
            if (var1 == 0) {
               C0114.bootstrap<"call",0,1>(C0431.this, var2);
            }
         }
      };
      var5.updatePadding(this.f_edf25271.m_9492ae24());
      var5.m_e61ee212(new C0426[]{C0426.f_974a55e6});
      var2.m_a0d63011().m_7e0ab7c8(var4.m_a0d63011().m_5a998971() + var5.m_de124a35().m_fc7f45bc() * (double)var3);
      var4.m_2fe952ac(new C0163[]{var5});
   }

   @EventHandler
   public void m_dd7f6ecb(EventKeyAction var1) {
      if (this.m_6efa6127() && !this.f_2e5a2c2e.isEmpty()) {
         this.f_2e5a2c2e.get(this.f_2e5a2c2e.size() - 1).m_fd40ceb2(var1.getKeyCode(), var1.getAction(), var1.getModifiers());
      }
   }

   @EventHandler
   private void m_66d79e2e(EventMatrixRender var1) {
      if (this.m_6efa6127()) {
         this.f_2e5a2c2e.forEach(var1x -> var1x.m_2f338522(-1.0, -1.0, var1.getPartialTicks(), false));
      }
   }

   @EventHandler
   private void m_7e045cd5(EventUpdate var1) {
      if (this.f_2e5a2c2e.isEmpty()) {
         this.m_21da19b8();
         this.f_2e5a2c2e.forEach(C0163::m_6b155392);
      }

      this.f_2e5a2c2e.forEach(C0163::m_e103589e);
   }

   public double m_0e308f8a() {
      return this.f_8635fafb != null ? this.f_82532c85 * 2.0 + this.f_8635fafb.m_a0d63011().m_fc7f45bc() : this.f_82532c85;
   }

   protected boolean m_6efa6127() {
      return !(Boolean)GameSetting.DEBUG_INFO.get() && !((C0297)C0114.bootstrap<"call",0,1>(C0297.class)).m_7458b21f();
   }

   public List<C0163> m_22d90200() {
      return this.f_2e5a2c2e;
   }

   public double m_123f0493() {
      return this.f_82532c85;
   }
}
