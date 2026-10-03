package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketPlayer;
import me.deftware.client.framework.world.EnumFacing;

public class C0382 extends AbstractMod {
   private final C0203<C0309> f_0a8a110f = new C0203<>(() -> C0289.m_c3a8b502(C0309.class));
   @C0098("Mode")
   private C0102<C0382.anonymousconst> f_c8e1c735 = new C0102<>(C0382.anonymousconst.f_ef5c9699);

   public C0382() {
      super(C0259.m_a9b6ecd9(), C0290.f_829d9b20, C0259.m_09052c0b(), C0259.m_023b99d9());
      this.setMode(this.f_c8e1c735);
   }

   @EventHandler
   public void m_2af6dda6(EventPacketSend var1) {
      MainEntityPlayer var2 = Minecraft.getMinecraftGame()._getPlayer();
      if (var2 != null && var1.getIPacket() instanceof CPacketPlayer) {
         boolean var3 = var2.getInventory().hasElytra();
         if (!var3) {
            if (this.f_c8e1c735.m_284992ec() == C0382.anonymousconst.f_ef5c9699) {
               CPacketPlayer var4 = (CPacketPlayer)var1.getIPacket();
               var4.setOnGround(true);
               var1.setPacket(var4);
            } else if (this.f_c8e1c735.m_284992ec() == C0382.anonymousconst.f_d7b6a6e5 && var2.getFallDistance() > 2.0F) {
               int var7 = C0217.m_29c83797(var2.getInventory(), 9, var0 -> var0.instanceOf(ItemType.ItemBlock));
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
   public void m_3072cba8(EventUpdate var1) {
      if (!this.f_0a8a110f.m_ac6eac3b().isEnabled() && this.f_c8e1c735.m_284992ec() == C0382.anonymousconst.f_ef5c9699) {
         Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).setFallDistance(0.0F);
      }
   }

   private static enum anonymousconst implements C0102.anonymousthis {
      f_ef5c9699(C0259.m_e9a52709()),
      f_d7b6a6e5(C0259.m_1472ab32(), C0259.m_a5b24d28());

      private final String[] f_c5b44faf;

      private anonymousconst(String... var3) {
         this.f_c5b44faf = var3;
      }

      @Override
      public String[] m_8e56a473() {
         return this.f_c5b44faf;
      }
   }
}
