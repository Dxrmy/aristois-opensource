package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.function.Supplier;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.ItemEntity;
import me.deftware.client.framework.entity.types.objects.ProjectileEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.shader.EntityShader;

public class C0317 extends C0319<Entity> {
   private static final C0201 f_38321984 = new C0201(C0252.bootstrap<"get",47244640356>());
   @C0098("Players")
   private boolean f_723bf340 = true;
   @C0098(
      value = "Distance",
      description = {"Maximum distance to render ESP"},
      number = @C0096(
         min = 5.0,
         max = 300.0
      )
   )
   private C0106<Integer> f_dc8341d5 = new C0106<>(C0114.bootstrap<"call",0,1>(50)).m_6da46a9c(this.f_17354753, C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Line thickness",
      description = {"Thickness of the BoundaryBox line thickness"},
      number = @C0096(
         max = 8.0
      )
   )
   private C0106<Integer> f_8e107858 = new C0106<>(C0114.bootstrap<"call",0,1>(2)).m_10caee7d(this.f_17354753, C0319.anonymousabstract.f_5ab2c155);
   @C0098(
      value = "Render",
      description = {"Render all entities, or those selected"}
   )
   private C0102<C0317.anonymousnew> f_8e153a91 = new C0102<>(C0317.anonymousnew.f_fcba85a3);
   @C0098("Entities")
   private final GuiScreen f_dbff3b3d = C0114.bootstrap<"call",1,1>(null, f_38321984);
   @C0098(
      value = "Friend",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_5a39101c = new C0106<>(new Color(255, 215, 20, 30)).m_6da46a9c(this.f_17354753, C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Player",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_18b15b0d = new C0106<>(new Color(0, 0, 255, 30)).m_6da46a9c(this.f_17354753, C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Hostile",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_ccd88434 = new C0106<>(new Color(255, 0, 0, 30)).m_6da46a9c(this.f_17354753, C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Neutral",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_4e33c51c = new C0106<>(new Color(0, 255, 0, 30)).m_6da46a9c(this.f_17354753, C0319.anonymousabstract.f_37020a22);
   private final CubeRenderStack f_0b2cd089 = new CubeRenderStack();

   public C0317() {
      super(C0252.bootstrap<"get",47244640354>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640355>());
      this.f_0b507bcd = new C0319.anonymousnew<Entity>() {
         public Supplier<EntityShader> m_fd5a46a7() {
            return C0114.bootstrap<"call",0,1>()::m_c347dc8a;
         }

         public Class<Entity> m_285f6c6b() {
            return Entity.class;
         }

         public boolean m_85c2a289(Entity var1) {
            if (var1 instanceof ItemEntity || var1 instanceof ProjectileEntity) {
               return false;
            } else {
               return var1 instanceof EntityPlayer
                  ? C0114.bootstrap<"call",1,1>(C0317.this) && !var1.isSelf()
                  : C0114.bootstrap<"call",2,1>().m_4fb0d5ef(var1) || C0114.bootstrap<"call",3,1>(C0317.this).m_e2691446() == C0317.anonymousnew.f_fcba85a3;
            }
         }
      };
   }

   private void m_c65d21d7(Entity var1) {
      Color var2 = var1.isHostile() ? this.f_ccd88434.get() : this.f_4e33c51c.get();
      if (var1 instanceof EntityPlayer) {
         EntityPlayer var3 = (EntityPlayer)var1;
         if (C0114.bootstrap<"call",0,1>().stream().anyMatch(var1x -> var1x.m_cd751ed2().equalsIgnoreCase(var3.getUsername()))) {
            var2 = this.f_5a39101c.get();
         } else {
            var2 = this.f_18b15b0d.get();
         }
      }

      ((CubeRenderStack)this.f_0b2cd089.glColor(var2)).draw(var1.getBoundingBox());
   }

   @EventHandler
   public void m_b4abea79(EventRender3D var1) {
      MainEntityPlayer var2 = C0114.bootstrap<"call",1,1>()._getPlayer();
      if (var2 != null && !this.m_bdc5a86f()) {
         C0114.bootstrap<"call",2,1>();
         ((CubeRenderStack)this.f_0b2cd089.lineWidth((float)this.f_8e107858.get().intValue()))
            .begin(this.f_17354753.m_e2691446() == C0319.anonymousabstract.f_5ab2c155);
         C0114.bootstrap<"call",3,1>()
            .getLoadedEntities()
            .filter(var0 -> !var0.isSelf())
            .filter(var2x -> var2x.distanceToEntity(var2) < (float)this.f_dc8341d5.get().intValue())
            .filter(var1x -> {
               if (var1x instanceof LivingEntity && !(var1x instanceof EntityPlayer)) {
                  return this.f_8e153a91.m_e2691446() == C0317.anonymousnew.f_0985b827 ? f_38321984.m_4fb0d5ef(var1x) : true;
               } else {
                  return var1x instanceof EntityPlayer && this.f_723bf340;
               }
            })
            .forEach(this::m_c65d21d7);
         this.f_0b2cd089.end();
         C0114.bootstrap<"call",4,1>();
      }
   }

   public static C0201 m_4822dfb6() {
      return f_38321984;
   }

   public static enum anonymousnew {
      f_fcba85a3,
      f_0985b827;

      private anonymousnew() {
      }
   }
}
