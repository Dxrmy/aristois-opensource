package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.box.BoundingBox;
import me.deftware.client.framework.math.box.DoubleBoundingBox;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.NetworkHandler;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.player.PlayerEntry;

public class C0360 extends AbstractMod {
   private final C0219<C0360.anonymousconst> f_a094f787 = new C0219<>(C0360.anonymousconst.class, C0255.m_022da1b4());
   @C0098("Toasts")
   private boolean f_9646f123 = true;
   @C0098(
      value = "Clear Spots",
      description = {"Clear stored logout spots on the current server"}
   )
   private final Runnable f_240f1d53 = () -> {
      this.f_a094f787.removeIf(C0360.anonymousconst::m_efa7610e);
      C0064.m_13c9ffeb().m_2c2620fc(C0255.m_3d3a8736()).m_ee04ba1b(C0255.m_760db7bb()).m_1058ed9a();
   };
   @C0098(
      value = "Render Distance",
      description = {"Distance to render logout spots within"},
      number = @C0096(
         min = 30.0,
         max = 150.0
      )
   )
   private double f_bc2bb72c = 50.0;
   private final Map<UUID, EntityPlayer> f_828f3e09 = new HashMap<>();
   private final List<PlayerEntry> f_094648ca = new ArrayList<>();
   private final CubeRenderStack f_d5aab777 = new CubeRenderStack();
   private int f_98ed4e54 = 0;

   public C0360() {
      super(C0255.m_3d3a8736(), C0290.f_516f3c47, C0255.m_94acbdac());
   }

   @EventHandler
   private void m_c738343e(EventRender3D var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!this.f_a094f787.isEmpty()) {
         C0292 var3 = Objects.requireNonNull(C0289.m_c3a8b502(C0292.class));
         this.f_d5aab777.begin().glColor(Color.green, 170.0F);

         for (C0360.anonymousconst var5 : this.f_a094f787) {
            if (var5.m_efa7610e() && (double)var5.m_e8f7735c().distanceTo(var2.getBlockPosition()) < this.f_bc2bb72c) {
               this.f_d5aab777.draw(var5.m_0dd987af(var2.getHeight()));
            }
         }

         this.f_d5aab777.end();

         for (C0360.anonymousconst var7 : this.f_a094f787) {
            if (var7.m_efa7610e() && (double)var7.m_e8f7735c().distanceTo(var2.getBlockPosition()) < this.f_bc2bb72c) {
               var3.m_5e10679a(var7.m_e8f7735c(), Objects.requireNonNull(Minecraft.getMinecraftGame()._getCameraEntity()), Message.of(var7.m_e07cee76()));
            }
         }
      }
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (NetworkHandler.getNetworkHandler() != null) {
         List var2 = NetworkHandler.getNetworkHandler()._getPlayerList();
         if (this.f_094648ca.size() != var2.size()) {
            for (PlayerEntry var4 : this.f_094648ca) {
               if (!var2.contains(var4)) {
                  this.m_adf53b02(var4);
               }
            }

            this.f_094648ca.clear();
            this.f_094648ca.addAll(var2);
         }

         if (this.f_98ed4e54++ > 10) {
            this.f_98ed4e54 = 0;
            this.m_23674f64();
         }
      }
   }

   private void m_23674f64() {
      this.f_828f3e09.clear();
      ClientWorld.getClientWorld().getLoadedEntities().filter(var0 -> var0 instanceof EntityPlayer).map(var0 -> (EntityPlayer)var0).forEach(var1 -> {
         EntityPlayer var10000 = this.f_828f3e09.put(var1.getUUID(), var1);
      });
   }

   private void m_adf53b02(PlayerEntry var1) {
      if (this.f_828f3e09.containsKey(var1._getProfileID())) {
         EntityPlayer var2 = this.f_828f3e09.get(var1._getProfileID());
         C0360.anonymousconst var3 = C0360.anonymousconst.m_84d644e6(var2.getBlockPosition(), var1._getName(), C0451.m_3855be80());
         this.f_a094f787.add(var3);
         if (this.f_9646f123) {
            C0064.m_13c9ffeb().m_ecf8e7ae(C0255.m_6e2d03c3(), var1._getName()).m_1058ed9a();
         }
      }
   }

   public C0219<C0360.anonymousconst> m_3e9a41cb() {
      return this.f_a094f787;
   }

   private static class anonymousconst {
      @SerializedName("position")
      private BlockPosition f_2c50b32f;
      @SerializedName("name")
      private String f_570d6ea3;
      @SerializedName("server")
      private String f_1b454997;
      @SerializedName("date")
      private String f_2d4c756b;
      private BoundingBox f_b468f565;

      public static C0360.anonymousconst m_84d644e6(BlockPosition var0, String var1, String var2) {
         C0360.anonymousconst var3 = new C0360.anonymousconst();
         var3.m_2405ca7d(var0);
         var3.m_256015fc(var1);
         var3.m_a11708c5(var2);
         var3.m_333019c8(LocalDate.now().toString());
         return var3;
      }

      public BoundingBox m_0dd987af(float var1) {
         if (this.f_b468f565 == null) {
            this.f_b468f565 = new DoubleBoundingBox(
               this.f_2c50b32f.getX(),
               this.f_2c50b32f.getY(),
               this.f_2c50b32f.getZ(),
               this.f_2c50b32f.getX() + 1.0,
               this.f_2c50b32f.getY() + (double)var1,
               this.f_2c50b32f.getZ() + 1.0
            );
         }

         return this.f_b468f565;
      }

      public boolean m_efa7610e() {
         return this.f_1b454997.equalsIgnoreCase(C0451.m_3855be80());
      }

      public anonymousconst() {
      }

      public BlockPosition m_e8f7735c() {
         return this.f_2c50b32f;
      }

      public String m_e07cee76() {
         return this.f_570d6ea3;
      }

      public String m_d32ebe65() {
         return this.f_1b454997;
      }

      public String m_3855be80() {
         return this.f_2d4c756b;
      }

      public BoundingBox m_b3c2cd29() {
         return this.f_b468f565;
      }

      public void m_2405ca7d(BlockPosition var1) {
         this.f_2c50b32f = var1;
      }

      public void m_256015fc(String var1) {
         this.f_570d6ea3 = var1;
      }

      public void m_a11708c5(String var1) {
         this.f_1b454997 = var1;
      }

      public void m_333019c8(String var1) {
         this.f_2d4c756b = var1;
      }

      public void m_e603a06c(BoundingBox var1) {
         this.f_b468f565 = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0360.anonymousconst)) {
            return false;
         } else {
            C0360.anonymousconst var2 = (C0360.anonymousconst)var1;
            if (!var2.m_22ad6203(this)) {
               return false;
            } else {
               BlockPosition var3 = this.m_e8f7735c();
               BlockPosition var4 = var2.m_e8f7735c();
               if (var3 == null ? var4 == null : var3.equals(var4)) {
                  String var5 = this.m_e07cee76();
                  String var6 = var2.m_e07cee76();
                  if (var5 == null ? var6 == null : var5.equals(var6)) {
                     String var7 = this.m_d32ebe65();
                     String var8 = var2.m_d32ebe65();
                     if (var7 == null ? var8 == null : var7.equals(var8)) {
                        String var9 = this.m_3855be80();
                        String var10 = var2.m_3855be80();
                        if (var9 == null ? var10 == null : var9.equals(var10)) {
                           BoundingBox var11 = this.m_b3c2cd29();
                           BoundingBox var12 = var2.m_b3c2cd29();
                           return var11 == null ? var12 == null : var11.equals(var12);
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            }
         }
      }

      protected boolean m_22ad6203(Object var1) {
         return var1 instanceof C0360.anonymousconst;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         BlockPosition var3 = this.m_e8f7735c();
         var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
         String var4 = this.m_e07cee76();
         var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
         String var5 = this.m_d32ebe65();
         var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
         String var6 = this.m_3855be80();
         var2 = var2 * 59 + (var6 == null ? 43 : var6.hashCode());
         BoundingBox var7 = this.m_b3c2cd29();
         return var2 * 59 + (var7 == null ? 43 : var7.hashCode());
      }

      @Override
      public String toString() {
         return C0255.m_818e6498()
            + this.m_e8f7735c()
            + C0255.m_56d4c1c7()
            + this.m_e07cee76()
            + C0255.m_d32ebe65()
            + this.m_d32ebe65()
            + C0255.m_afb31f66()
            + this.m_3855be80()
            + C0255.m_c254a253()
            + this.m_b3c2cd29()
            + C0257.m_9e27f038();
      }
   }
}
