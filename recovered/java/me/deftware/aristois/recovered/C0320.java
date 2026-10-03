package me.deftware.aristois.recovered;

import com.google.common.collect.EvictingQueue;
import com.google.common.collect.Queues;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChunkDataReceive;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.position.ChunkBlockPosition;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.camera.GameCamera;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.world.ClientWorld;

public class C0320 extends AbstractMod {
   @C0098(
      value = "Render Chunks",
      description = {"Render the chunks"}
   )
   private boolean f_2fabb676 = true;
   @C0098(
      value = "Logging mode",
      description = {"Log the chunks in client-side chat"}
   )
   private C0102<C0320.anonymousconst> f_6b688984 = new C0102<>(C0320.anonymousconst.f_0142c840);
   @C0098(
      value = "Toggle Clear",
      description = {"Clear chunk render caches on toggle"}
   )
   private boolean f_2819f289 = true;
   @C0098(
      value = "Max Chunks",
      description = {"Maximum chunks to render at once (0 for infinite)"},
      number = @C0096(
         min = 0.0,
         max = 5120.0
      )
   )
   private int f_ac164984 = 5120;
   @C0098(
      value = "View Distance",
      description = {"Maximum view distance for rendered chunks"},
      number = @C0096(
         min = 0.0,
         max = 1024.0
      )
   )
   private int f_41709759 = 180;
   @C0098(
      value = "Show Old",
      description = {"Show previously seen chunks"}
   )
   private boolean f_1d545d71 = false;
   @C0098(
      value = "Show New",
      description = {"Show new chunks"}
   )
   private boolean f_f6ae387f = true;
   @C0098(
      value = "FullChunk",
      description = {"Detect by full chunk method (recommended)"}
   )
   private boolean f_3cef98bc = true;
   @C0098(
      value = "Timings",
      description = {"Detect by chunk timings method (do not use in low TPS)"}
   )
   private boolean f_c1186198 = true;
   @C0098(
      value = "Max Timings",
      description = {"Maximum time a second chunk load should occur"},
      number = @C0096(
         max = 60000.0
      )
   )
   private int f_1e49fdc5 = 1000;
   @C0098("Render Color")
   private Color f_ce5f1480 = Color.white;
   private long f_90a53d87 = -1L;
   private long f_89e7416c;
   private Queue<ChunkBlockPosition> f_1c8881b0 = null;
   private ArrayList<ChunkBlockPosition> f_87fddd1b = new ArrayList<>();
   private final CubeRenderStack f_648bb3f4 = new CubeRenderStack();
   private final Lock f_01c7f7fd = new ReentrantLock();

   public C0320() {
      super(C0260.m_0425f2ec(), C0290.f_3210deb7, C0260.m_1b17f04f());
   }

   @Override
   public void onEnable() {
      this.f_01c7f7fd.lock();

      try {
         if (this.f_ac164984 <= 0) {
            this.f_1c8881b0 = Queues.newArrayDeque();
         } else {
            this.f_1c8881b0 = EvictingQueue.create(this.f_ac164984);
         }
      } finally {
         this.f_01c7f7fd.unlock();
      }
   }

   @Override
   public void onDisable() {
      if (this.f_2819f289 && this.f_1c8881b0 != null) {
         this.f_01c7f7fd.lock();

         try {
            this.f_1c8881b0.clear();
            this.f_1c8881b0 = null;
         } finally {
            this.f_01c7f7fd.unlock();
         }
      }
   }

   @EventHandler
   public void m_b5519d5e(EventChunkDataReceive var1) {
      if (this.f_2fabb676 || this.f_6b688984.m_284992ec() != C0320.anonymousconst.f_0142c840) {
         boolean var2 = !var1.updatedIsFullChunk;
         this.f_89e7416c = this.f_90a53d87;
         this.f_90a53d87 = System.currentTimeMillis();
         boolean var3 = this.m_ed528171() != -1L && this.m_ed528171() <= (long)this.f_1e49fdc5;
         if (this.f_1c8881b0 != null) {
            this.f_01c7f7fd.lock();

            try {
               if ((!this.f_f6ae387f || (!var2 || !this.f_3cef98bc) && (!var3 || !this.f_c1186198)) && !this.f_1d545d71) {
                  if (this.f_6b688984.m_284992ec() != C0320.anonymousconst.f_c21ee658 && this.f_6b688984.m_284992ec() == C0320.anonymousconst.f_7da49243) {
                  }

                  this.f_1c8881b0.remove(var1.getPos());
               } else {
                  ChunkBlockPosition var4 = var1.getPos();
                  ChunkBlockPosition var5 = this.f_1c8881b0.stream().filter(var4::equals).findAny().orElse(null);
                  if (var5 != null) {
                     this.f_1c8881b0.remove(var5);
                     this.f_1c8881b0.add(var4);
                     if (this.f_6b688984.m_284992ec() != C0320.anonymousconst.f_70dad0e9 && this.f_6b688984.m_284992ec() == C0320.anonymousconst.f_7da49243) {
                     }
                  } else {
                     this.f_1c8881b0.add(var4);
                     if (this.f_6b688984.m_284992ec() != C0320.anonymousconst.f_70dad0e9 && this.f_6b688984.m_284992ec() == C0320.anonymousconst.f_7da49243) {
                     }
                  }
               }
            } finally {
               this.f_01c7f7fd.unlock();
            }
         }
      }
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      this.f_87fddd1b = new ArrayList<>(this.f_1c8881b0);
      this.f_87fddd1b.removeIf(var2x -> var2x.getCenterBlockPos().getVector().squareDistanceTo(var2.getBlockPosition().getVector()) >= (double)this.f_41709759);
      ClientWorld.getClientWorld()
         .getLoadedEntities()
         .forEach(var1x -> this.f_87fddd1b.removeIf(var1xx -> var1x instanceof EntityPlayer && var1x.isWithinChunk(var1xx)));
      if (this.f_87fddd1b.size() != this.f_1c8881b0.size()) {
         this.f_01c7f7fd.lock();
         this.f_1c8881b0.clear();
         this.f_1c8881b0.addAll(this.f_87fddd1b);
         this.f_01c7f7fd.unlock();
      }
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (this.f_2fabb676 && !this.f_87fddd1b.isEmpty()) {
         RenderStack.setupGl();
         GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
         ((CubeRenderStack)this.f_648bb3f4.lineWidth(3.0F)).glColor(this.f_ce5f1480);
         GameCamera var3 = Minecraft.getMinecraftGame().getCamera();
         GLX.INSTANCE.translate(-var3._getRenderPosX(), -var3._getRenderPosY(), -var3._getRenderPosZ());
         double var4 = Math.floor(var2.getBoundingBox().getMinY()) + 0.05 - var3._getRenderPosY();

         for (ChunkBlockPosition var7 : this.f_87fddd1b) {
            if (var7 != null) {
               Vector3d var8 = var7.getVector();
               this.f_648bb3f4.begin(3);
               this.f_648bb3f4.vertex(var8.getX(), var4, var8.getZ()).next();
               this.f_648bb3f4.vertex(var8.getX() + 16.0, var4, var8.getZ()).next();
               this.f_648bb3f4.vertex(var8.getX() + 16.0, var4, var8.getZ() + 16.0).next();
               this.f_648bb3f4.vertex(var8.getX(), var4, var8.getZ() + 16.0).next();
               this.f_648bb3f4.end();
            }
         }

         RenderStack.restoreGl();
      }
   }

   private long m_ed528171() {
      return this.f_89e7416c == -1L ? -1L : this.f_89e7416c - this.f_90a53d87;
   }

   private static enum anonymousconst {
      f_0142c840,
      f_c21ee658,
      f_70dad0e9,
      f_7da49243;

      private anonymousconst() {
      }
   }
}
