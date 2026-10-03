package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
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
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.camera.GameCamera;
import me.deftware.client.framework.render.gl.GLX;

public class C0320 extends AbstractMod {
   @C0098(
      value = "Render Chunks",
      description = {"Render the chunks"}
   )
   private boolean f_43aed040 = true;
   @C0098(
      value = "Logging mode",
      description = {"Log the chunks in client-side chat"}
   )
   private C0102<C0320.anonymousconst> f_ae42eedb = new C0102<>(C0320.anonymousconst.f_8b794f04);
   @C0098(
      value = "Toggle Clear",
      description = {"Clear chunk render caches on toggle"}
   )
   private boolean f_4f80cf3d = true;
   @C0098(
      value = "Max Chunks",
      description = {"Maximum chunks to render at once (0 for infinite)"},
      number = @C0096(
         min = 0.0,
         max = 5120.0
      )
   )
   private int f_dabf3883 = 5120;
   @C0098(
      value = "View Distance",
      description = {"Maximum view distance for rendered chunks"},
      number = @C0096(
         min = 0.0,
         max = 1024.0
      )
   )
   private int f_71d952ba = 180;
   @C0098(
      value = "Show Old",
      description = {"Show previously seen chunks"}
   )
   private boolean f_8893b095 = false;
   @C0098(
      value = "Show New",
      description = {"Show new chunks"}
   )
   private boolean f_ab6d3fa8 = true;
   @C0098(
      value = "FullChunk",
      description = {"Detect by full chunk method (recommended)"}
   )
   private boolean f_6fafbd3f = true;
   @C0098(
      value = "Timings",
      description = {"Detect by chunk timings method (do not use in low TPS)"}
   )
   private boolean f_bef6369c = true;
   @C0098(
      value = "Max Timings",
      description = {"Maximum time a second chunk load should occur"},
      number = @C0096(
         max = 60000.0
      )
   )
   private int f_4b95c756 = 1000;
   @C0098("Render Color")
   private Color f_d04aa795 = Color.white;
   private long f_497be7ad = -1L;
   private long f_a586db92;
   private Queue<ChunkBlockPosition> f_7127050d = null;
   private ArrayList<ChunkBlockPosition> f_747ad49d = new ArrayList<>();
   private final CubeRenderStack f_532cd9cf = new CubeRenderStack();
   private final Lock f_3ac4f37e = new ReentrantLock();

   public C0320() {
      super(C0252.bootstrap<"get",47244640344>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640345>());
   }

   @Override
   public void onEnable() {
      this.f_3ac4f37e.lock();

      try {
         if (this.f_dabf3883 <= 0) {
            this.f_7127050d = C0114.bootstrap<"call",0,1>();
         } else {
            this.f_7127050d = C0114.bootstrap<"call",1,1>(this.f_dabf3883);
         }
      } finally {
         this.f_3ac4f37e.unlock();
      }
   }

   @Override
   public void onDisable() {
      if (this.f_4f80cf3d && this.f_7127050d != null) {
         this.f_3ac4f37e.lock();

         try {
            this.f_7127050d.clear();
            this.f_7127050d = null;
         } finally {
            this.f_3ac4f37e.unlock();
         }
      }
   }

   @EventHandler
   public void m_4ecf7a0a(EventChunkDataReceive var1) {
      if (this.f_43aed040 || this.f_ae42eedb.m_e2691446() != C0320.anonymousconst.f_8b794f04) {
         boolean var2 = !var1.updatedIsFullChunk;
         this.f_a586db92 = this.f_497be7ad;
         this.f_497be7ad = C0114.bootstrap<"call",0,1>();
         boolean var3 = this.m_a53d9052() != -1L && this.m_a53d9052() <= (long)this.f_4b95c756;
         if (this.f_7127050d != null) {
            this.f_3ac4f37e.lock();

            try {
               if ((!this.f_ab6d3fa8 || (!var2 || !this.f_6fafbd3f) && (!var3 || !this.f_bef6369c)) && !this.f_8893b095) {
                  if (this.f_ae42eedb.m_e2691446() != C0320.anonymousconst.f_06473b6f && this.f_ae42eedb.m_e2691446() == C0320.anonymousconst.f_9df55c04) {
                  }

                  this.f_7127050d.remove(var1.getPos());
               } else {
                  ChunkBlockPosition var4 = var1.getPos();
                  ChunkBlockPosition var5 = this.f_7127050d.stream().filter(var4::equals).findAny().orElse(null);
                  if (var5 != null) {
                     this.f_7127050d.remove(var5);
                     this.f_7127050d.add(var4);
                     if (this.f_ae42eedb.m_e2691446() != C0320.anonymousconst.f_d631836b && this.f_ae42eedb.m_e2691446() == C0320.anonymousconst.f_9df55c04) {
                     }
                  } else {
                     this.f_7127050d.add(var4);
                     if (this.f_ae42eedb.m_e2691446() != C0320.anonymousconst.f_d631836b && this.f_ae42eedb.m_e2691446() == C0320.anonymousconst.f_9df55c04) {
                     }
                  }
               }
            } finally {
               this.f_3ac4f37e.unlock();
            }
         }
      }
   }

   @EventHandler
   public void m_5286ebe0(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()._getPlayer());
      this.f_747ad49d = new ArrayList<>(this.f_7127050d);
      this.f_747ad49d.removeIf(var2x -> var2x.getCenterBlockPos().getVector().squareDistanceTo(var2.getBlockPosition().getVector()) >= (double)this.f_71d952ba);
      C0114.bootstrap<"call",3,1>()
         .getLoadedEntities()
         .forEach(var1x -> this.f_747ad49d.removeIf(var1xx -> var1x instanceof EntityPlayer && var1x.isWithinChunk(var1xx)));
      if (this.f_747ad49d.size() != this.f_7127050d.size()) {
         this.f_3ac4f37e.lock();
         this.f_7127050d.clear();
         this.f_7127050d.addAll(this.f_747ad49d);
         this.f_3ac4f37e.unlock();
      }
   }

   @EventHandler
   public void m_4301a75d(EventRender3D var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()._getPlayer());
      if (this.f_43aed040 && !this.f_747ad49d.isEmpty()) {
         C0114.bootstrap<"call",4,1>();
         GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
         ((CubeRenderStack)this.f_532cd9cf.lineWidth(3.0F)).glColor(this.f_d04aa795);
         GameCamera var3 = C0114.bootstrap<"call",1,1>().getCamera();
         GLX.INSTANCE.translate(-var3._getRenderPosX(), -var3._getRenderPosY(), -var3._getRenderPosZ());
         double var4 = C0114.bootstrap<"call",5,1>(var2.getBoundingBox().getMinY()) + 0.05 - var3._getRenderPosY();

         for (ChunkBlockPosition var7 : this.f_747ad49d) {
            if (var7 != null) {
               Vector3d var8 = var7.getVector();
               this.f_532cd9cf.begin(3);
               this.f_532cd9cf.vertex(var8.getX(), var4, var8.getZ()).next();
               this.f_532cd9cf.vertex(var8.getX() + 16.0, var4, var8.getZ()).next();
               this.f_532cd9cf.vertex(var8.getX() + 16.0, var4, var8.getZ() + 16.0).next();
               this.f_532cd9cf.vertex(var8.getX(), var4, var8.getZ() + 16.0).next();
               this.f_532cd9cf.end();
            }
         }

         C0114.bootstrap<"call",6,1>();
      }
   }

   private long m_a53d9052() {
      return this.f_a586db92 == -1L ? -1L : this.f_a586db92 - this.f_497be7ad;
   }

   private static enum anonymousconst {
      f_8b794f04,
      f_06473b6f,
      f_d631836b,
      f_9df55c04;

      private anonymousconst() {
      }
   }
}
