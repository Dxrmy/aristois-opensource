package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.function.Supplier;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.render.shader.EntityShader;
import me.deftware.client.framework.render.shader.Shader;

public class C0319<T> extends AbstractMod {
   @C0098(
      value = "Mode",
      id = 10
   )
   protected C0102<C0319.anonymousabstract> f_e1d988aa = new C0102<>(C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Outline color",
      id = 2,
      triggerPostChanged = true
   )
   private C0106<Color> f_328d0c0d = new C0106<>(Color.white).m_2d6ca2bd(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Filled color",
      id = 1,
      triggerPostChanged = true
   )
   private C0106<Color> f_cfe89b43 = new C0106<>(new Color(1.0F, 1.0F, 1.0F, 0.2F)).m_2d6ca2bd(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Filled",
      id = 3
   )
   private C0106<Boolean> f_cf6db75a = new C0106<>(true).m_2d6ca2bd(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   protected C0319.anonymousnew<T> f_c7894f51;
   protected boolean f_99d3ef77 = false;

   public C0319(String var1, C0290 var2, String... var3) {
      super(var1, var2, var3);
      this.setMode(this.f_e1d988aa);
   }

   @EventHandler
   protected void m_3072cba8(EventUpdate var1) {
      if (this.f_99d3ef77 && this.f_c7894f51.m_89e0519f()) {
         this.f_99d3ef77 = false;
         this.m_23674f64();
         this.m_0e389a72();
      }
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() > 0 && var1.id() <= 3) {
         this.m_23674f64();
      } else if (var1.id() == 10) {
         if (this.f_e1d988aa.m_284992ec() != C0319.anonymousabstract.f_40f68e21) {
            this.onDisable();
         } else {
            this.onEnable();
         }
      }
   }

   private void m_23674f64() {
      this.m_2971682b(C0260.m_678c4ddb(), this.f_cfe89b43.get());
      this.m_2971682b(C0260.m_1672ac4d(), this.f_328d0c0d.get());
      this.f_c7894f51.m_1c802207(C0260.m_e9a52709(), this.f_cf6db75a.get() ? 1.0F : 0.0F);
   }

   private void m_2971682b(String var1, Color var2) {
      this.f_c7894f51
         .m_1c802207(var1, (float)var2.getRed() / 255.0F, (float)var2.getGreen() / 255.0F, (float)var2.getBlue() / 255.0F, (float)var2.getAlpha() / 255.0F);
   }

   protected boolean m_297cfef6() {
      return this.f_e1d988aa.m_284992ec() == C0319.anonymousabstract.f_40f68e21;
   }

   @Override
   public void onEnable() {
      this.f_99d3ef77 = true;
   }

   @Override
   public void onDisable() {
      this.f_c7894f51.m_d6ac7420(false);
   }

   private void m_0e389a72() {
      this.f_c7894f51.m_d6ac7420(this.isEnabled() && this.m_297cfef6());
   }

   public static enum anonymousabstract {
      f_40f68e21,
      f_e6ef46e1,
      f_cf065721;

      private anonymousabstract() {
      }
   }

   public interface anonymousnew<T> {
      Supplier<EntityShader> m_5219c421();

      Class<T> m_6305e767();

      boolean m_22ad6203(T var1);

      default boolean m_89e0519f() {
         Shader var1 = (Shader)this.m_5219c421().get();
         return var1 != null && var1.isLoaded();
      }

      default void m_1c802207(String var1, float... var2) {
         Shader var3 = (Shader)this.m_5219c421().get();
         if (var3 != null) {
            var3.setUniform(var1, var2);
         }
      }

      default void m_d6ac7420(boolean var1) {
         EntityShader var2 = this.m_5219c421().get();
         if (var2 != null) {
            var2.setTargetPredicate(var1x -> var1x != null && this.m_6305e767().isAssignableFrom(var1x.getClass()) ? this.m_22ad6203((T)var1x) : false);
            var2.setEnabled(var1);
         }
      }
   }
}
