package me.deftware.aristois.recovered;

import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.gui.GuiScreen;

@C0099
@C0422
public class C0080 extends C0086 {
   @C0098(
      value = "Show modes",
      description = {"Show mod modes"},
      id = 2
   )
   private boolean f_5c312ec2 = true;
   private List<C0086.anonymousdefault> f_af4230c0;
   private final C0219<AbstractMod> f_16ad1258 = new C0219<AbstractMod>(AbstractMod.class, C0252.bootstrap<"get",25769803895>()) {
      protected void m_a3204484(AbstractMod var1, boolean var2) {
         super.m_2bf95354(var1, var2);
         if (C0114.bootstrap<"call",0,1>(C0080.class)) {
            C0080.this.m_0a9e88bc();
         }
      }

      public JsonArray m_b2ef7afc() {
         JsonArray var1 = new JsonArray();
         this.f_e822d7f3.forEach(var1x -> var1.add(new JsonPrimitive(var1x.m_5aac041f())));
         return var1;
      }

      public C0219<AbstractMod> m_24a9f022(JsonArray var1) {
         var1.forEach(
            var1x -> C0289.f_c22b8d7e
                  .m_dace8a1f()
                  .values()
                  .stream()
                  .filter(var1xx -> var1xx.m_5aac041f().equalsIgnoreCase(var1x.getAsString()))
                  .forEach(this::add)
         );
         return this;
      }
   };
   @C0098(
      value = "Excluded",
      description = {"Select mods to exclude in the list"}
   )
   private final GuiScreen f_4ad7f2ee;

   public C0080() {
      super(C0252.bootstrap<"get",25769803893>(), C0087.f_a2a770a2, C0252.bootstrap<"get",25769803894>());
      this.f_f86fb5ab = true;
      C0205.anonymouscatch var1 = new C0205.anonymouscatch<>(
         AbstractMod.class, new ArrayList<>(C0289.f_c22b8d7e.m_dace8a1f().values()), AbstractMod::m_5aac041f
      );
      this.f_4ad7f2ee = new C0196<>(null, AbstractMod.class, this.f_16ad1258, var1, C0252.bootstrap<"get",25769803896>());
   }

   protected Stream<C0086.anonymousdefault> m_38ca69a8() {
      if (this.f_af4230c0 == null) {
         this.f_af4230c0 = C0289.f_c22b8d7e
            .m_ea73e1f0()
            .filter(var0 -> !var0.getClass().isAnnotationPresent(C0099.class))
            .map(this::m_29879b1e)
            .collect(C0114.bootstrap<"call",0,1>());
      }

      return this.f_af4230c0.stream().sorted((var0, var1) -> (int)(var1.m_7c2d1617() - var0.m_7c2d1617()));
   }

   private C0086.anonymousdefault m_29879b1e(final AbstractMod var1) {
      C0080.anonymousgoto var2 = (new C0080.anonymousgoto() {
         public boolean m_fe8573fd() {
            return C0114.bootstrap<"call",0,1>(C0080.this).contains(var1) ? false : super.m_aa3c193f();
         }
      }).m_abe7c720(var1);
      var2.m_55f47c53(this::m_998ee231);
      var2.m_abdea523(false);
      this.m_c21ec466(var2);
      C0202.f_b9f4c1a2.m_5a200d53(var1::isEnabled, var2x -> {
         var2.m_abdea523(var2x);
         this.m_0a9e88bc();
      });
      return var2;
   }

   private void m_c21ec466(C0080.anonymousgoto var1) {
      AbstractMod var2 = var1.m_62f8e1b2();
      if (var2.getDisplayMode() != null && this.f_5c312ec2) {
         var1.m_13be1baa(new String[]{var2.m_5aac041f(), C0252.bootstrap<"get",25769803897>()}).m_a514188a(var2::getDisplayMode);
      } else {
         var1.m_13be1baa(new String[]{var2.m_5aac041f()});
      }
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      super.onSettingUpdate(var1);
      if (var1.id() == 2 && this.f_af4230c0 != null) {
         this.f_af4230c0.stream().map(C0080.anonymousgoto.class::cast).forEach(this::m_c21ec466);
         this.m_0a9e88bc();
      }
   }

   private static class anonymousgoto extends C0086.anonymousdefault {
      private AbstractMod f_b89bcbb8;
      private Runnable f_405dd9dd;

      private anonymousgoto() {
      }

      public C0080.anonymousgoto m_5a26bb3b(AbstractMod var1) {
         this.f_b89bcbb8 = var1;
         return this;
      }

      public void m_b0534c7f() {
         super.m_44909575();
         if (this.f_405dd9dd != null) {
            this.f_405dd9dd.run();
         }
      }

      public AbstractMod m_62f8e1b2() {
         return this.f_b89bcbb8;
      }

      public void m_55f47c53(Runnable var1) {
         this.f_405dd9dd = var1;
      }
   }
}
