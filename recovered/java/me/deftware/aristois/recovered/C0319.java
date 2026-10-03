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
   protected C0102<C0319.anonymousabstract> f_4a8e5259 = new C0102<>(C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Outline color",
      id = 2,
      triggerPostChanged = true
   )
   private C0106<Color> f_43d511e1 = new C0106<>(Color.white).m_10caee7d(this.f_4a8e5259, C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Filled color",
      id = 1,
      triggerPostChanged = true
   )
   private C0106<Color> f_4e4d112b = new C0106<>(new Color(1.0F, 1.0F, 1.0F, 0.2F)).m_10caee7d(this.f_4a8e5259, C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Filled",
      id = 3
   )
   private C0106<Boolean> f_a9a67676 = new C0106<>(C0114.bootstrap<"call",0,1>(true)).m_10caee7d(this.f_4a8e5259, C0319.anonymousabstract.f_37020a22);
   protected C0319.anonymousnew<T> f_8c99466c;
   protected boolean f_f0de128c = false;

   public C0319(String var1, C0290 var2, String... var3) {
      super(var1, var2, var3);
      this.setMode(this.f_4a8e5259);
   }

   @EventHandler
   protected void m_9f7a397f(EventUpdate var1) {
      if (this.f_f0de128c && this.f_8c99466c.m_2b35766e()) {
         this.f_f0de128c = false;
         this.m_3e37ea67();
         this.m_c352db74();
      }
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() > 0 && var1.id() <= 3) {
         this.m_3e37ea67();
      } else if (var1.id() == 10) {
         if (this.f_4a8e5259.m_e2691446() != C0319.anonymousabstract.f_37020a22) {
            this.onDisable();
         } else {
            this.onEnable();
         }
      }
   }

   private void m_3e37ea67() {
      this.m_37e642eb(C0252.bootstrap<"get",47244640362>(), this.f_4e4d112b.get());
      this.m_37e642eb(C0252.bootstrap<"get",47244640363>(), this.f_43d511e1.get());
      this.f_8c99466c.m_bf1fc8e9(C0252.bootstrap<"get",47244640364>(), this.f_a9a67676.get() ? 1.0F : 0.0F);
   }

   private void m_37e642eb(String var1, Color var2) {
      this.f_8c99466c
         .m_bf1fc8e9(var1, (float)var2.getRed() / 255.0F, (float)var2.getGreen() / 255.0F, (float)var2.getBlue() / 255.0F, (float)var2.getAlpha() / 255.0F);
   }

   protected boolean m_49641678() {
      return this.f_4a8e5259.m_e2691446() == C0319.anonymousabstract.f_37020a22;
   }

   @Override
   public void onEnable() {
      this.f_f0de128c = true;
   }

   @Override
   public void onDisable() {
      this.f_8c99466c.m_c7ea6a48(false);
   }

   private void m_c352db74() {
      this.f_8c99466c.m_c7ea6a48(this.isEnabled() && this.m_49641678());
   }

   public static enum anonymousabstract {
      f_37020a22,
      f_d569a437,
      f_5ab2c155;

      private anonymousabstract() {
      }
   }

   public interface anonymousnew<T> {
      Supplier<EntityShader> m_74bd4319();

      Class<T> m_4562a7e7();

      boolean m_7173d361(T var1);

      default boolean m_2b35766e() {
         Shader var1 = (Shader)this.m_74bd4319().get();
         return var1 != null && var1.isLoaded();
      }

      default void m_bf1fc8e9(String var1, float... var2) {
         Shader var3 = (Shader)this.m_74bd4319().get();
         if (var3 != null) {
            var3.setUniform(var1, var2);
         }
      }

      default void m_c7ea6a48(boolean var1) {
         EntityShader var2 = this.m_74bd4319().get();
         if (var2 != null) {
            var2.setTargetPredicate(var1x -> var1x != null && this.m_4562a7e7().isAssignableFrom(var1x.getClass()) ? this.m_7173d361((T)var1x) : false);
            var2.setEnabled(var1);
         }
      }
   }
}
