package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.client.framework.network.packets.CPacketEntityAction;
import me.deftware.client.framework.network.packets.CPacketPlayer;
import me.deftware.client.framework.network.packets.CPacketPosition;
import me.deftware.client.framework.network.packets.CPacketPositionRotation;
import me.deftware.client.framework.network.packets.CPacketEntityAction.Action;
import me.deftware.client.framework.render.WorldEntityRenderer.Statue;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.camera.GameCamera;

@C0421
public class C0385 extends AbstractMod {
   private Statue f_6c6f3061;
   @C0098("Mode")
   private C0102<C0385.anonymousif> f_a75778d0 = new C0102<>(C0385.anonymousif.f_f5eab9e6);
   @C0098(
      value = "Speed",
      description = {"Replay speed, packets per tick"},
      number = @C0096(
         min = 1.0,
         max = 5.0
      )
   )
   private int f_c42cd83a = 2;
   @C0098(
      value = "Overlay",
      description = {"Render your original position", "and your current path"}
   )
   private boolean f_7be669e9 = true;
   private final LineRenderStack f_77bd936e = new LineRenderStack();
   private C0385.anonymousclass f_fc8e2caf = C0385.anonymousclass.f_1c4dd253;
   private final List<C0385.anonymousenum> f_f20fd31b = new ArrayList<>();
   private long f_87e9eef3 = C0114.bootstrap<"call",0,1>();

   public C0385() {
      super(C0252.bootstrap<"get",42949673030>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673031>(), C0252.bootstrap<"get",42949673032>());
      this.registerEvents(true);
      this.setManageBusRegistration(false);
   }

   @Override
   public void onEnable() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (this.f_7be669e9) {
         this.f_6c6f3061 = new Statue(var1, var1.getPosition()) {
            public Vector3d getPosition() {
               if (!C0114.bootstrap<"call",0,1>(C0385.this).isEmpty()) {
                  this.position = ((C0385.anonymousenum)C0114.bootstrap<"call",0,1>(C0385.this).get(0)).m_1f7a0489();
               }

               return super.getPosition();
            }
         };
         C0114.bootstrap<"call",0,1>().getWorldEntityRenderer().getStatues().add(this.f_6c6f3061);
      }

      this.f_f20fd31b.clear();
      this.f_fc8e2caf = C0385.anonymousclass.f_f04fdc1c;
   }

   @Override
   public void onDisable() {
      this.f_fc8e2caf = C0385.anonymousclass.f_0ea0369d;
   }

   @EventHandler
   public void m_1b0aa194(EventRender3D var1) {
      if (!this.f_f20fd31b.isEmpty() && this.f_7be669e9) {
         C0114.bootstrap<"call",0,1>();
         this.f_77bd936e.begin().glColor(Color.GREEN);
         GameCamera var2 = C0114.bootstrap<"call",1,1>().getCamera();

         for (int var3 = 0; var3 < this.f_f20fd31b.size(); var3++) {
            C0385.anonymousenum var4 = this.f_f20fd31b.get(var3);
            Vector3d var5 = var4.m_1f7a0489();
            double var6 = var2._getRenderPosX() - var5.getX();
            double var8 = var2._getRenderPosY() - var5.getY();
            double var10 = var2._getRenderPosZ() - var5.getZ();
            this.f_77bd936e.drawPoint(-var6, -var8, -var10);
            if (var3 != 0) {
               this.f_77bd936e.drawPoint(-var6, -var8, -var10);
            }
         }

         this.f_77bd936e.end();
         C0114.bootstrap<"call",2,1>();
      }
   }

   @Override
   public String getDisplayMode() {
      return C0114.bootstrap<"call",0,1>(this.f_f20fd31b.size());
   }

   @EventHandler
   public void m_2d5de130(EventUpdate var1) {
      if (!this.isEnabled()) {
         if (!this.f_f20fd31b.isEmpty()) {
            for (int var2 = 0; var2 < this.f_c42cd83a && !this.f_f20fd31b.isEmpty(); var2++) {
               C0385.anonymousenum var3 = this.f_f20fd31b.remove(0);
               if (var2 == 0 || this.f_a75778d0.m_e2691446() != C0385.anonymousif.f_f5eab9e6) {
                  var3.m_d26db006();
               }
            }
         } else if (this.f_6c6f3061 != null) {
            C0114.bootstrap<"call",1,1>().getWorldEntityRenderer().getStatues().remove(this.f_6c6f3061);
            this.f_6c6f3061 = null;
         } else {
            this.f_fc8e2caf = C0385.anonymousclass.f_1c4dd253;
         }
      }
   }

   @EventHandler
   public void m_44d44076(EventPacketSend var1) {
      if (this.f_fc8e2caf != C0385.anonymousclass.f_1c4dd253) {
         PacketWrapper var2 = var1.getIPacket();
         if (var2 instanceof CPacketPlayer) {
            if (this.f_fc8e2caf == C0385.anonymousclass.f_f04fdc1c && var2 instanceof CPacketPosition || var2 instanceof CPacketPositionRotation) {
               long var3 = C0114.bootstrap<"call",3,1>() - this.f_87e9eef3;
               C0385.anonymousenum var5 = new C0385.anonymousenum((CPacketPlayer)var2, var3);
               if (this.f_a75778d0.m_e2691446() == C0385.anonymousif.f_f5eab9e6 || !this.f_f20fd31b.contains(var5)) {
                  this.f_f20fd31b.add(var5);
               }
            }

            var1.setCanceled(true);
         } else if (var2 instanceof CPacketEntityAction) {
            CPacketEntityAction var6 = (CPacketEntityAction)var2;
            if (var6.getAction() == Action.START_SPRINT) {
               var1.setCanceled(true);
            }
         }
      }
   }

   private static enum anonymousclass {
      f_1c4dd253,
      f_f04fdc1c,
      f_0ea0369d;

      private anonymousclass() {
      }
   }

   private static class anonymousenum {
      private CPacketPlayer f_a981079a;
      private Vector3d f_6c5b82fc;
      private long f_9fcb956b;

      public anonymousenum(CPacketPlayer var1, long var2) {
         MainEntityPlayer var4 = C0114.bootstrap<"call",0,1>()._getPlayer();
         this.f_6c5b82fc = var4.getPosition();
         this.f_a981079a = var1;
         this.f_9fcb956b = var2;
      }

      public void m_d26db006() {
         this.f_a981079a.sendImmediately();
      }

      @Override
      public boolean equals(Object var1) {
         return var1 instanceof C0385.anonymousenum ? ((C0385.anonymousenum)var1).m_1f7a0489().floor().equals(this.f_6c5b82fc.floor()) : false;
      }

      public CPacketPlayer m_e50ddd41() {
         return this.f_a981079a;
      }

      public Vector3d m_1f7a0489() {
         return this.f_6c5b82fc;
      }

      public long m_1468e363() {
         return this.f_9fcb956b;
      }
   }

   private static enum anonymousif implements C0102.anonymousthis {
      f_f5eab9e6(C0252.bootstrap<"get",42949673026>()),
      f_71698a48(C0252.bootstrap<"get",42949673028>(), C0252.bootstrap<"get",42949673029>());

      private final String[] f_8909c1c8;

      private anonymousif(String... var3) {
         this.f_8909c1c8 = var3;
      }

      public String[] m_2ecb355b() {
         return this.f_8909c1c8;
      }
   }
}
