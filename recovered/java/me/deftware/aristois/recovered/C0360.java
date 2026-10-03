package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.box.BoundingBox;
import me.deftware.client.framework.math.box.DoubleBoundingBox;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.world.player.PlayerEntry;

public class C0360 extends AbstractMod {
   private final C0219<C0360.anonymousconst> f_996fc622 = new C0219<>(C0360.anonymousconst.class, C0252.bootstrap<"get",51539607595>());
   @C0098("Toasts")
   private boolean f_9989483f = true;
   @C0098(
      value = "Clear Spots",
      description = {"Clear stored logout spots on the current server"}
   )
   private final Runnable f_c564b111 = () -> {
      this.f_996fc622.removeIf(C0360.anonymousconst::m_c867f20d);
      C0114.bootstrap<"call",0,1>().m_6b4e8235(C0252.bootstrap<"get",51539607593>()).m_77a7bc18(C0252.bootstrap<"get",51539607597>()).m_66e721c0();
   };
   @C0098(
      value = "Render Distance",
      description = {"Distance to render logout spots within"},
      number = @C0096(
         min = 30.0,
         max = 150.0
      )
   )
   private double f_6cd376a3 = 50.0;
   private final Map<UUID, EntityPlayer> f_6a91c9be = new HashMap<>();
   private final List<PlayerEntry> f_c8d1159b = new ArrayList<>();
   private final CubeRenderStack f_f4302eeb = new CubeRenderStack();
   private int f_9ec6112c = 0;

   public C0360() {
      super(C0252.bootstrap<"get",51539607593>(), C0290.f_faada303, C0252.bootstrap<"get",51539607594>());
   }

   @EventHandler
   private void m_cdbc40cc(EventRender3D var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!this.f_996fc622.isEmpty()) {
         C0292 var3 = (C0292)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",2,1>(C0292.class));
         this.f_f4302eeb.begin().glColor(Color.green, 170.0F);

         for (C0360.anonymousconst var5 : this.f_996fc622) {
            if (var5.m_c867f20d() && (double)var5.m_8be276a5().distanceTo(var2.getBlockPosition()) < this.f_6cd376a3) {
               this.f_f4302eeb.draw(var5.m_e51e3c2a(var2.getHeight()));
            }
         }

         this.f_f4302eeb.end();

         for (C0360.anonymousconst var7 : this.f_996fc622) {
            if (var7.m_c867f20d() && (double)var7.m_8be276a5().distanceTo(var2.getBlockPosition()) < this.f_6cd376a3) {
               var3.m_6ab167dd(
                  var7.m_8be276a5(),
                  (Entity)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getCameraEntity()),
                  C0114.bootstrap<"call",3,1>(var7.m_23e66dba())
               );
            }
         }
      }
   }

   @EventHandler
   public void m_a11c700f(EventUpdate var1) {
      if (C0114.bootstrap<"call",4,1>() != null) {
         List var2 = C0114.bootstrap<"call",4,1>()._getPlayerList();
         if (this.f_c8d1159b.size() != var2.size()) {
            for (PlayerEntry var4 : this.f_c8d1159b) {
               if (!var2.contains(var4)) {
                  this.m_da99485c(var4);
               }
            }

            this.f_c8d1159b.clear();
            this.f_c8d1159b.addAll(var2);
         }

         if (this.f_9ec6112c++ > 10) {
            this.f_9ec6112c = 0;
            this.m_13254891();
         }
      }
   }

   private void m_13254891() {
      this.f_6a91c9be.clear();
      C0114.bootstrap<"call",0,1>().getLoadedEntities().filter(var0 -> var0 instanceof EntityPlayer).map(var0 -> (EntityPlayer)var0).forEach(var1 -> {
         EntityPlayer var10000 = this.f_6a91c9be.put(var1.getUUID(), var1);
      });
   }

   private void m_da99485c(PlayerEntry var1) {
      if (this.f_6a91c9be.containsKey(var1._getProfileID())) {
         EntityPlayer var2 = this.f_6a91c9be.get(var1._getProfileID());
         C0360.anonymousconst var3 = C0114.bootstrap<"call",6,1>(var2.getBlockPosition(), var1._getName(), C0114.bootstrap<"call",5,1>());
         this.f_996fc622.add(var3);
         if (this.f_9989483f) {
            C0114.bootstrap<"call",7,1>().m_5de8d0b8(C0252.bootstrap<"get",51539607596>(), var1._getName()).m_66e721c0();
         }
      }
   }

   public C0219<C0360.anonymousconst> m_686a67da() {
      return this.f_996fc622;
   }

   private static class anonymousconst {
      @SerializedName("position")
      private BlockPosition f_2a995654;
      @SerializedName("name")
      private String f_0cb48276;
      @SerializedName("server")
      private String f_37488a2e;
      @SerializedName("date")
      private String f_b4110d9e;
      private BoundingBox f_1d7104a2;

      public static C0360.anonymousconst m_f8e7df94(BlockPosition var0, String var1, String var2) {
         C0360.anonymousconst var3 = new C0360.anonymousconst();
         var3.m_14982d8c(var0);
         var3.m_0479315d(var1);
         var3.m_2adfa9a8(var2);
         var3.m_f4bbc6ee(C0114.bootstrap<"call",0,1>().toString());
         return var3;
      }

      public BoundingBox m_e51e3c2a(float var1) {
         if (this.f_1d7104a2 == null) {
            this.f_1d7104a2 = new DoubleBoundingBox(
               this.f_2a995654.getX(),
               this.f_2a995654.getY(),
               this.f_2a995654.getZ(),
               this.f_2a995654.getX() + 1.0,
               this.f_2a995654.getY() + (double)var1,
               this.f_2a995654.getZ() + 1.0
            );
         }

         return this.f_1d7104a2;
      }

      public boolean m_c867f20d() {
         return this.f_37488a2e.equalsIgnoreCase(C0114.bootstrap<"call",1,1>());
      }

      public anonymousconst() {
      }

      public BlockPosition m_8be276a5() {
         return this.f_2a995654;
      }

      public String m_23e66dba() {
         return this.f_0cb48276;
      }

      public String m_e28289c0() {
         return this.f_37488a2e;
      }

      public String m_9f5b95a1() {
         return this.f_b4110d9e;
      }

      public BoundingBox m_6e6a41ea() {
         return this.f_1d7104a2;
      }

      public void m_14982d8c(BlockPosition var1) {
         this.f_2a995654 = var1;
      }

      public void m_0479315d(String var1) {
         this.f_0cb48276 = var1;
      }

      public void m_2adfa9a8(String var1) {
         this.f_37488a2e = var1;
      }

      public void m_f4bbc6ee(String var1) {
         this.f_b4110d9e = var1;
      }

      public void m_45283acb(BoundingBox var1) {
         this.f_1d7104a2 = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0360.anonymousconst)) {
            return false;
         } else {
            C0360.anonymousconst var2 = (C0360.anonymousconst)var1;
            if (!var2.m_c581d3b2(this)) {
               return false;
            } else {
               BlockPosition var3 = this.m_8be276a5();
               BlockPosition var4 = var2.m_8be276a5();
               if (var3 == null ? var4 == null : var3.equals(var4)) {
                  String var5 = this.m_23e66dba();
                  String var6 = var2.m_23e66dba();
                  if (var5 == null ? var6 == null : var5.equals(var6)) {
                     String var7 = this.m_e28289c0();
                     String var8 = var2.m_e28289c0();
                     if (var7 == null ? var8 == null : var7.equals(var8)) {
                        String var9 = this.m_9f5b95a1();
                        String var10 = var2.m_9f5b95a1();
                        if (var9 == null ? var10 == null : var9.equals(var10)) {
                           BoundingBox var11 = this.m_6e6a41ea();
                           BoundingBox var12 = var2.m_6e6a41ea();
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

      protected boolean m_c581d3b2(Object var1) {
         return var1 instanceof C0360.anonymousconst;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         BlockPosition var3 = this.m_8be276a5();
         var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
         String var4 = this.m_23e66dba();
         var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
         String var5 = this.m_e28289c0();
         var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
         String var6 = this.m_9f5b95a1();
         var2 = var2 * 59 + (var6 == null ? 43 : var6.hashCode());
         BoundingBox var7 = this.m_6e6a41ea();
         return var2 * 59 + (var7 == null ? 43 : var7.hashCode());
      }

      @Override
      public String toString() {
         return C0252.bootstrap<"get",51539607588>()
            + this.m_8be276a5()
            + C0252.bootstrap<"get",51539607589>()
            + this.m_23e66dba()
            + C0252.bootstrap<"get",51539607590>()
            + this.m_e28289c0()
            + C0252.bootstrap<"get",51539607591>()
            + this.m_9f5b95a1()
            + C0252.bootstrap<"get",51539607592>()
            + this.m_6e6a41ea()
            + C0252.bootstrap<"get",59>();
      }
   }
}
