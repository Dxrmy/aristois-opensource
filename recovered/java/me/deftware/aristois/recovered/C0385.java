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
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.client.framework.network.packets.CPacketEntityAction;
import me.deftware.client.framework.network.packets.CPacketPlayer;
import me.deftware.client.framework.network.packets.CPacketPosition;
import me.deftware.client.framework.network.packets.CPacketPositionRotation;
import me.deftware.client.framework.network.packets.CPacketEntityAction.Action;
import me.deftware.client.framework.render.WorldEntityRenderer.Statue;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.camera.GameCamera;

@C0421
public class C0385 extends AbstractMod {
   private Statue f_1e3cefac;
   @C0098("Mode")
   private C0102<C0385.anonymousif> f_50da0db8 = new C0102<>(C0385.anonymousif.f_3326fe3f);
   @C0098(
      value = "Speed",
      description = {"Replay speed, packets per tick"},
      number = @C0096(
         min = 1.0,
         max = 5.0
      )
   )
   private int f_6022f726 = 2;
   @C0098(
      value = "Overlay",
      description = {"Render your original position", "and your current path"}
   )
   private boolean f_e6a53034 = true;
   private final LineRenderStack f_08c31b02 = new LineRenderStack();
   private C0385.anonymousclass f_e5e4ec86 = C0385.anonymousclass.f_b50674f2;
   private final List<C0385.anonymousenum> f_a4e6140b = new ArrayList<>();
   private long f_d2c7101a = System.currentTimeMillis();

   public C0385() {
      super(C0259.m_593ecbab(), C0290.f_829d9b20, C0259.m_17d51275(), C0259.m_00ba16c2());
      this.registerEvents(true);
      this.setManageBusRegistration(false);
   }

   @Override
   public void onEnable() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (this.f_e6a53034) {
         this.f_1e3cefac = new Statue(var1, var1.getPosition()) {
            public Vector3d getPosition() {
               if (!C0385.this.f_a4e6140b.isEmpty()) {
                  this.position = C0385.this.f_a4e6140b.get(0).m_e801be9e();
               }

               return super.getPosition();
            }
         };
         Minecraft.getMinecraftGame().getWorldEntityRenderer().getStatues().add(this.f_1e3cefac);
      }

      this.f_a4e6140b.clear();
      this.f_e5e4ec86 = C0385.anonymousclass.f_7fd12914;
   }

   @Override
   public void onDisable() {
      this.f_e5e4ec86 = C0385.anonymousclass.f_db588857;
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      if (!this.f_a4e6140b.isEmpty() && this.f_e6a53034) {
         RenderStack.setupGl();
         this.f_08c31b02.begin().glColor(Color.GREEN);
         GameCamera var2 = Minecraft.getMinecraftGame().getCamera();

         for (int var3 = 0; var3 < this.f_a4e6140b.size(); var3++) {
            C0385.anonymousenum var4 = this.f_a4e6140b.get(var3);
            Vector3d var5 = var4.m_e801be9e();
            double var6 = var2._getRenderPosX() - var5.getX();
            double var8 = var2._getRenderPosY() - var5.getY();
            double var10 = var2._getRenderPosZ() - var5.getZ();
            this.f_08c31b02.drawPoint(-var6, -var8, -var10);
            if (var3 != 0) {
               this.f_08c31b02.drawPoint(-var6, -var8, -var10);
            }
         }

         this.f_08c31b02.end();
         RenderStack.restoreGl();
      }
   }

   @Override
   public String getDisplayMode() {
      return String.valueOf(this.f_a4e6140b.size());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (!this.isEnabled()) {
         if (!this.f_a4e6140b.isEmpty()) {
            for (int var2 = 0; var2 < this.f_6022f726 && !this.f_a4e6140b.isEmpty(); var2++) {
               C0385.anonymousenum var3 = this.f_a4e6140b.remove(0);
               if (var2 == 0 || this.f_50da0db8.m_284992ec() != C0385.anonymousif.f_3326fe3f) {
                  var3.m_1058ed9a();
               }
            }
         } else if (this.f_1e3cefac != null) {
            Minecraft.getMinecraftGame().getWorldEntityRenderer().getStatues().remove(this.f_1e3cefac);
            this.f_1e3cefac = null;
         } else {
            this.f_e5e4ec86 = C0385.anonymousclass.f_b50674f2;
         }
      }
   }

   @EventHandler
   public void m_2af6dda6(EventPacketSend var1) {
      if (this.f_e5e4ec86 != C0385.anonymousclass.f_b50674f2) {
         PacketWrapper var2 = var1.getIPacket();
         if (var2 instanceof CPacketPlayer) {
            if (this.f_e5e4ec86 == C0385.anonymousclass.f_7fd12914 && var2 instanceof CPacketPosition || var2 instanceof CPacketPositionRotation) {
               long var3 = System.currentTimeMillis() - this.f_d2c7101a;
               C0385.anonymousenum var5 = new C0385.anonymousenum((CPacketPlayer)var2, var3);
               if (this.f_50da0db8.m_284992ec() == C0385.anonymousif.f_3326fe3f || !this.f_a4e6140b.contains(var5)) {
                  this.f_a4e6140b.add(var5);
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
      f_b50674f2,
      f_7fd12914,
      f_db588857;

      private anonymousclass() {
      }
   }

   private static class anonymousenum {
      private CPacketPlayer f_70dddc45;
      private Vector3d f_48bdebaa;
      private long f_110b3bb1;

      public anonymousenum(CPacketPlayer var1, long var2) {
         MainEntityPlayer var4 = Minecraft.getMinecraftGame()._getPlayer();
         this.f_48bdebaa = var4.getPosition();
         this.f_70dddc45 = var1;
         this.f_110b3bb1 = var2;
      }

      public void m_1058ed9a() {
         this.f_70dddc45.sendImmediately();
      }

      @Override
      public boolean equals(Object var1) {
         return var1 instanceof C0385.anonymousenum ? ((C0385.anonymousenum)var1).m_e801be9e().floor().equals(this.f_48bdebaa.floor()) : false;
      }

      public CPacketPlayer m_1301dbc4() {
         return this.f_70dddc45;
      }

      public Vector3d m_e801be9e() {
         return this.f_48bdebaa;
      }

      public long m_59010ffc() {
         return this.f_110b3bb1;
      }
   }

   private static enum anonymousif implements C0102.anonymousthis {
      f_3326fe3f(C0259.m_b526dd3b()),
      f_83c43974(C0259.m_87c16989(), C0259.m_b0896de7());

      private final String[] f_462a0f92;

      private anonymousif(String... var3) {
         this.f_462a0f92 = var3;
      }

      @Override
      public String[] m_8e56a473() {
         return this.f_462a0f92;
      }
   }
}
