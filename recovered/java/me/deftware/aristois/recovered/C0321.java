package me.deftware.aristois.recovered;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventStructureLocation;
import me.deftware.client.framework.event.events.EventStructureLocation.StructureType;
import me.deftware.client.framework.math.position.BlockPosition;

public class C0321 extends AbstractMod {
   @C0098(
      value = "Stronghold",
      description = {"Search for stronghold, using triangulation"}
   )
   private boolean f_ec84332d = true;
   @C0098(
      value = "Buried Treasure",
      description = {"Search for buried treasure, using maps"}
   )
   private boolean f_be65aaa2 = true;
   @C0098(
      value = "Ocean Monument",
      description = {"Search for ocean monuments, using maps"}
   )
   private boolean f_0643237b = true;
   @C0098(
      value = "Woodland Mansion",
      description = {"Search for woodland mansions, using maps"}
   )
   private boolean f_b26100df = true;
   @C0098(
      value = "Extra Map Icons",
      description = {"Search for extra map icons, using maps"}
   )
   private boolean f_1c56b4ca = true;
   @C0098(
      value = "Display Mod",
      description = {"What we should do with the position found"}
   )
   private C0102<C0321.anonymousconst> f_45215fa5 = new C0102<>(C0321.anonymousconst.f_497622cd);
   private BlockPosition f_cb0f1449 = null;

   public C0321() {
      super(C0255.m_4626ac74(), C0290.f_3210deb7, C0255.m_c688f8ca());
   }

   @Override
   public void onEnable() {
      if (this.f_ec84332d) {
         C0064.m_13c9ffeb().m_2c2620fc(C0255.m_4626ac74()).m_ee04ba1b(C0255.m_35cdaa1a()).m_1058ed9a();
      }
   }

   @EventHandler
   public void m_02234b31(EventStructureLocation var1) {
      if ((this.f_cb0f1449 == null || !var1.getPos().toString().equalsIgnoreCase(this.f_cb0f1449.toString()))
         && (
            this.f_ec84332d && var1.getType() == StructureType.Stronghold
               || this.f_be65aaa2 && var1.getType() == StructureType.BuriedTreasure
               || this.f_0643237b && var1.getType() == StructureType.OceanMonument
               || this.f_b26100df && var1.getType() == StructureType.WoodlandMansion
               || this.f_1c56b4ca && var1.getType() == StructureType.OtherMapIcon
         )) {
         this.f_cb0f1449 = var1.getPos();
         if (this.f_45215fa5.m_284992ec() == C0321.anonymousconst.f_497622cd || this.f_45215fa5.m_284992ec() == C0321.anonymousconst.f_949d7879) {
            C0064.m_13c9ffeb().m_ecf8e7ae(C0255.m_624b40d8(), var1.getType().name(), this.f_cb0f1449.toString()).m_1058ed9a();
         }

         if (this.f_45215fa5.m_284992ec() == C0321.anonymousconst.f_497622cd || this.f_45215fa5.m_284992ec() == C0321.anonymousconst.f_af28d260) {
            if (C0289.m_c3a8b502(C0333.class) != null) {
               C0244 var2 = new C0244();
               var2.m_46938bdb((int)Math.round(this.f_cb0f1449.getX()));
               var2.m_7c7fe86a((int)Math.round(this.f_cb0f1449.getY()));
               var2.m_8b037516((int)Math.round(this.f_cb0f1449.getZ()));
               Calendar var3 = Calendar.getInstance();
               SimpleDateFormat var4 = new SimpleDateFormat(C0255.m_8d7dbe31());
               var2.m_256015fc(var1.getType().name() + C0264.m_18204724() + var4.format(var3.getTime()));
               var2.m_a11708c5(C0451.m_3855be80());
               var2.m_d6ac7420(true);
               C0244.m_a492b2a7().add(var2);
            } else {
               C0064.m_7853c016().m_ee04ba1b(C0255.m_1d87ef21()).m_1058ed9a();
            }
         }
      }
   }

   private static enum anonymousconst {
      f_949d7879,
      f_af28d260,
      f_497622cd;

      private anonymousconst() {
      }
   }
}
