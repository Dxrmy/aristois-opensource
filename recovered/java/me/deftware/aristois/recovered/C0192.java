package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.types.Pair;

public class C0192 extends GuiScreen {
   public static final C0192 f_d072ec73 = new C0192(C0228.f_920c4eab, null)
      .m_8f733a1d(C0252.bootstrap<"get",25769803790>(), () -> C0114.bootstrap<"call",0,1>(C0146.f_c02c60c3 + C0252.bootstrap<"get",25769803789>()))
      .m_f9ed72cc()
      .m_dc6fe91b(5);
   public static final C0192 f_b6110a8d = new C0192(C0228.f_001fe5a0, null)
      .m_8f733a1d(C0252.bootstrap<"get",25769803791>(), () -> C0114.bootstrap<"call",0,1>(C0146.f_c02c60c3 + C0252.bootstrap<"get",25769803788>()))
      .m_f9ed72cc()
      .m_dc6fe91b(5);
   private boolean f_6b368177 = true;
   private Pair<String, Runnable> f_c865e1cb;
   private final Runnable f_79945440;
   private int f_40beb4bf = 0;
   private Button f_aa64b773;

   public C0192(GlTexture var1, Runnable var2) {
      this.f_79945440 = var2;
      this.setBackgroundType(var1);
   }

   public C0192 m_f9ed72cc() {
      this.f_6b368177 = false;
      return this;
   }

   public C0192 m_dc6fe91b(int var1) {
      this.f_40beb4bf = var1 * 20;
      return this;
   }

   public C0192 m_8f733a1d(String var1, Runnable var2) {
      this.f_c865e1cb = new Pair(var1, var2);
      return this;
   }

   public void m_3a40f397() {
      C0114.bootstrap<"call",0,1>().openScreen(this);
   }

   protected boolean goBack() {
      return !this.f_6b368177 ? true : super.goBack();
   }

   protected void onInitGui() {
      Message var1 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803786>());
      this.addComponent(
         this.f_aa64b773 = (new C0154(this.getGuiScreenWidth() - C0114.bootstrap<"call",1,1>(var1) - 25, 10, C0114.bootstrap<"call",1,1>(var1) + 15, 20, var1) {
               public boolean m_7d942538(int var1) {
                  if (C0114.bootstrap<"call",0,1>(C0192.this) != null) {
                     C0114.bootstrap<"call",0,1>(C0192.this).run();
                  } else {
                     C0114.bootstrap<"call",1,1>(C0192.this);
                  }

                  return true;
               }
            })
            .m_28521255()
      );
      if (this.f_c865e1cb != null) {
         var1 = C0114.bootstrap<"call",0,1>((String)this.f_c865e1cb.getLeft());
         this.addComponent(new C0154(10, 10, C0114.bootstrap<"call",1,1>(var1) + 15, 20, var1) {
            public boolean m_dff65665(int var1) {
               ((Runnable)C0114.bootstrap<"call",0,1>(C0192.this).getRight()).run();
               return true;
            }
         });
      }
   }

   protected void onDraw(int var1, int var2, float var3) {
   }

   protected void onUpdate() {
      if (this.f_40beb4bf > 0) {
         this.f_40beb4bf--;
         this.f_aa64b773
            .setComponentLabel(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803787>() + this.f_40beb4bf / 20 + C0252.bootstrap<"get",59>()));
         this.f_aa64b773.setActive(false);
      } else {
         this.f_aa64b773.setComponentLabel(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4>()));
         this.f_aa64b773.setActive(true);
      }
   }
}
