package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;

public class C0174<T extends ListItem> extends C0188<T> {
   private final Class<T> f_a2ea9951;

   public C0174(GenericScreen var1, C0219<T> var2, String var3) {
      this(var1, var2, var2.m_87bd75a8(), var3);
   }

   public C0174(GenericScreen var1, List<T> var2, Class<T> var3, String var4) {
      super(var1, var2);
      this.f_6524b797 = var4;
      this.f_a2ea9951 = var3;
   }

   protected void m_4a76dabf() {
      this.f_415254b5 = 400;
      super.m_295487ee();
   }

   protected void m_a72a08ee() {
      C0114.bootstrap<"call",0,1>().openScreen(new C0176<T>(this, this.f_a2ea9951));
   }

   protected void m_9b131548() {
      C0114.bootstrap<"call",0,1>().openScreen(new C0175<T>(this, (T)this.m_69b60f7a()));
   }

   public List<T> m_6346fae0() {
      return this.f_886562b6;
   }

   public C0174<T> m_1ee316ae(boolean var1) {
      this.f_d379c63f = var1;
      return this;
   }

   protected C0155[] m_3d14f40b() {
      byte var1 = 95;
      return new C0155[]{
         new C0155((float)var1, this)
            .m_5d3ed1f2(
               this.m_115c14fe(0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836558>()), this::m_a72a08ee),
               this.m_45a5cc7d(0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836559>()), this::m_e0dbe97c)
                  .m_dc08502f(this::m_3c15851a),
               this.m_115c14fe(0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836560>()), this::m_9b131548)
                  .m_dc08502f(this::m_3c15851a),
               this.m_115c14fe(0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",10>()), this::goBack)
            )
      };
   }
}
