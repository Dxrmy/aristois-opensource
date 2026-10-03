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
   private boolean f_1e76eb54 = true;
   @C0098(
      value = "Buried Treasure",
      description = {"Search for buried treasure, using maps"}
   )
   private boolean f_201aa510 = true;
   @C0098(
      value = "Ocean Monument",
      description = {"Search for ocean monuments, using maps"}
   )
   private boolean f_b809a00a = true;
   @C0098(
      value = "Woodland Mansion",
      description = {"Search for woodland mansions, using maps"}
   )
   private boolean f_c1a0cb3e = true;
   @C0098(
      value = "Extra Map Icons",
      description = {"Search for extra map icons, using maps"}
   )
   private boolean f_44a9ea3e = true;
   @C0098(
      value = "Display Mod",
      description = {"What we should do with the position found"}
   )
   private C0102<C0321.anonymousconst> f_845a440b = new C0102<>(C0321.anonymousconst.f_37239400);
   private BlockPosition f_150971b5 = null;

   public C0321() {
      super(C0252.bootstrap<"get",51539607556>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",51539607557>());
   }

   @Override
   public void onEnable() {
      if (this.f_1e76eb54) {
         C0114.bootstrap<"call",0,1>().m_6b4e8235(C0252.bootstrap<"get",51539607556>()).m_77a7bc18(C0252.bootstrap<"get",51539607558>()).m_66e721c0();
      }
   }

   @EventHandler
   public void m_10eeb776(EventStructureLocation var1) {
      if ((this.f_150971b5 == null || !var1.getPos().toString().equalsIgnoreCase(this.f_150971b5.toString()))
         && (
            this.f_1e76eb54 && var1.getType() == StructureType.Stronghold
               || this.f_201aa510 && var1.getType() == StructureType.BuriedTreasure
               || this.f_b809a00a && var1.getType() == StructureType.OceanMonument
               || this.f_c1a0cb3e && var1.getType() == StructureType.WoodlandMansion
               || this.f_44a9ea3e && var1.getType() == StructureType.OtherMapIcon
         )) {
         this.f_150971b5 = var1.getPos();
         if (this.f_845a440b.m_e2691446() == C0321.anonymousconst.f_37239400 || this.f_845a440b.m_e2691446() == C0321.anonymousconst.f_b4ea19e4) {
            C0114.bootstrap<"call",0,1>().m_5de8d0b8(C0252.bootstrap<"get",51539607559>(), var1.getType().name(), this.f_150971b5.toString()).m_66e721c0();
         }

         if (this.f_845a440b.m_e2691446() == C0321.anonymousconst.f_37239400 || this.f_845a440b.m_e2691446() == C0321.anonymousconst.f_02c2af40) {
            if (C0114.bootstrap<"call",1,1>(C0333.class) != null) {
               C0244 var2 = new C0244();
               var2.m_5e296171((int)C0114.bootstrap<"call",2,1>(this.f_150971b5.getX()));
               var2.m_989d0d43((int)C0114.bootstrap<"call",2,1>(this.f_150971b5.getY()));
               var2.m_0faa1ebc((int)C0114.bootstrap<"call",2,1>(this.f_150971b5.getZ()));
               Calendar var3 = C0114.bootstrap<"call",3,1>();
               SimpleDateFormat var4 = new SimpleDateFormat(C0252.bootstrap<"get",51539607560>());
               var2.m_efd8b5f8(var1.getType().name() + C0252.bootstrap<"get",4294967313>() + var4.format(var3.getTime()));
               var2.m_6162e4ac(C0114.bootstrap<"call",4,1>());
               var2.m_9d941243(true);
               C0114.bootstrap<"call",5,1>().add(var2);
            } else {
               C0114.bootstrap<"call",6,1>().m_77a7bc18(C0252.bootstrap<"get",51539607561>()).m_66e721c0();
            }
         }
      }
   }

   private static enum anonymousconst {
      f_b4ea19e4,
      f_02c2af40,
      f_37239400;

      private anonymousconst() {
      }
   }
}
