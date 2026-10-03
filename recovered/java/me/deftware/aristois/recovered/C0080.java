package me.deftware.aristois.recovered;

import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
   private boolean f_c8ff1dbf = true;
   private List<C0086.anonymousdefault> f_2bd81995;
   private final C0219<AbstractMod> f_ebbf7d1e = new C0219<AbstractMod>(AbstractMod.class, C0267.m_3c19a819()) {
      protected void m_8a65f8b0(AbstractMod var1, boolean var2) {
         super.m_cef1a7b6(var1, var2);
         if (C0289.m_81a25567(C0080.class)) {
            C0080.this.m_083b6d08();
         }
      }

      @Override
      public JsonArray m_d788a065() {
         JsonArray var1 = new JsonArray();
         this.f_2acc0bd9.forEach(var1x -> var1.add(new JsonPrimitive(var1x.m_6f1f396d())));
         return var1;
      }

      @Override
      public C0219<AbstractMod> m_50cef0e3(JsonArray var1) {
         var1.forEach(
            var1x -> C0289.f_85a7343f
                  .m_4cdd6a26()
                  .values()
                  .stream()
                  .filter(var1xx -> var1xx.m_6f1f396d().equalsIgnoreCase(var1x.getAsString()))
                  .forEach(this::add)
         );
         return this;
      }
   };
   @C0098(
      value = "Excluded",
      description = {"Select mods to exclude in the list"}
   )
   private final GuiScreen f_e9c1911f;

   public C0080() {
      super(C0267.m_8870d2c1(), C0087.f_993458d0, C0267.m_a004d745());
      this.f_676ae6d0 = true;
      C0205.anonymouscatch var1 = new C0205.anonymouscatch<>(
         AbstractMod.class, new ArrayList<>(C0289.f_85a7343f.m_4cdd6a26().values()), AbstractMod::m_6f1f396d
      );
      this.f_e9c1911f = new C0196<>(null, AbstractMod.class, this.f_ebbf7d1e, var1, C0267.m_f599ae93());
   }

   @Override
   protected Stream<C0086.anonymousdefault> m_cb07f77b() {
      if (this.f_2bd81995 == null) {
         this.f_2bd81995 = C0289.f_85a7343f
            .m_918b7b9e()
            .filter(var0 -> !var0.getClass().isAnnotationPresent(C0099.class))
            .map(this::m_5493a2db)
            .collect(Collectors.toList());
      }

      return this.f_2bd81995.stream().sorted((var0, var1) -> (int)(var1.m_4388ac29() - var0.m_4388ac29()));
   }

   private C0086.anonymousdefault m_5493a2db(final AbstractMod var1) {
      C0080.anonymousgoto var2 = (new C0080.anonymousgoto() {
         @Override
         public boolean m_efa7610e() {
            return C0080.this.f_ebbf7d1e.contains(var1) ? false : super.m_efa7610e();
         }
      }).m_3bfb1085(var1);
      var2.m_c162d659(this::m_083b6d08);
      var2.m_d6ac7420(false);
      this.m_e40027c5(var2);
      C0202.f_75b1ba31.m_35a6ad75(var1::isEnabled, var2x -> {
         var2.m_d6ac7420(var2x);
         this.m_083b6d08();
      });
      return var2;
   }

   private void m_e40027c5(C0080.anonymousgoto var1) {
      AbstractMod var2 = var1.m_3adecb58();
      if (var2.getDisplayMode() != null && this.f_c8ff1dbf) {
         var1.m_42140133(new String[]{var2.m_6f1f396d(), C0267.m_5b2d5cb2()}).m_b4a5d70c(var2::getDisplayMode);
      } else {
         var1.m_42140133(new String[]{var2.m_6f1f396d()});
      }
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      super.onSettingUpdate(var1);
      if (var1.id() == 2 && this.f_2bd81995 != null) {
         this.f_2bd81995.stream().map(C0080.anonymousgoto.class::cast).forEach(this::m_e40027c5);
         this.m_083b6d08();
      }
   }

   private static class anonymousgoto extends C0086.anonymousdefault {
      private AbstractMod f_88c92335;
      private Runnable f_e90d8e73;

      private anonymousgoto() {
      }

      public C0080.anonymousgoto m_3bfb1085(AbstractMod var1) {
         this.f_88c92335 = var1;
         return this;
      }

      @Override
      public void m_b728afce() {
         super.m_b728afce();
         if (this.f_e90d8e73 != null) {
            this.f_e90d8e73.run();
         }
      }

      public AbstractMod m_3adecb58() {
         return this.f_88c92335;
      }

      public void m_c162d659(Runnable var1) {
         this.f_e90d8e73 = var1;
      }
   }
}
