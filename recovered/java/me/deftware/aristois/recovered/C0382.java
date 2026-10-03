package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.network.packets.CPacketPlayer;
import me.deftware.client.framework.world.EnumFacing;

public class C0382 extends AbstractMod {
   private final C0203<C0309> f_a566a15d = new C0203<>(() -> (C0309)C0114.bootstrap<"call",0,1>(C0309.class));
   @C0098("Mode")
   private C0102<C0382.anonymousconst> f_0adac1d1 = new C0102<>(C0382.anonymousconst.f_3ec8d9cb);

   public C0382() {
      super(C0252.bootstrap<"get",42949673072>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673073>(), C0252.bootstrap<"get",42949673074>());
      this.setMode(this.f_0adac1d1);
   }

   @EventHandler
   public void m_35a27f44(EventPacketSend var1) {
      MainEntityPlayer var2 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var2 != null && var1.getIPacket() instanceof CPacketPlayer) {
         boolean var3 = var2.getInventory().hasElytra();
         if (!var3) {
            if (this.f_0adac1d1.m_e2691446() == C0382.anonymousconst.f_3ec8d9cb) {
               CPacketPlayer var4 = (CPacketPlayer)var1.getIPacket();
               var4.setOnGround(true);
               var1.setPacket(var4);
            } else if (this.f_0adac1d1.m_e2691446() == C0382.anonymousconst.f_580694e2 && var2.getFallDistance() > 2.0F) {
               int var7 = C0114.bootstrap<"call",1,1>(var2.getInventory(), 9, var0 -> var0.instanceOf(ItemType.ItemBlock));
               if (var7 != -1) {
                  int var5 = var2.getInventory().getCurrentItem();
                  var2.getInventory().setCurrentItem(var7);
                  BlockPosition var6 = var2.getBlockPosition().offset(0.0, -1.0, 0.0);
                  var2.processRightClickBlock(var6, EnumFacing.UP, var6.getVector(), EntityHand.MainHand);
                  var2.getInventory().setCurrentItem(var5);
               }
            }
         }
      }
   }

   @EventHandler
   public void m_cbc3c2aa(EventUpdate var1) {
      if (!this.f_a566a15d.m_1c30b0a8().isEnabled() && this.f_0adac1d1.m_e2691446() == C0382.anonymousconst.f_3ec8d9cb) {
         ((MainEntityPlayer)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).setFallDistance(0.0F);
      }
   }

   private static enum anonymousconst implements C0102.anonymousthis {
      f_3ec8d9cb(C0252.bootstrap<"get",42949673068>()),
      f_580694e2(C0252.bootstrap<"get",42949673070>(), C0252.bootstrap<"get",42949673071>());

      private final String[] f_0607b199;

      private anonymousconst(String... var3) {
         this.f_0607b199 = var3;
      }

      public String[] m_d330794e() {
         return this.f_0607b199;
      }
   }
}
