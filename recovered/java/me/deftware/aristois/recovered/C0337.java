package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.types.BowItem;
import me.deftware.client.framework.item.types.CrossbowItem;
import me.deftware.client.framework.item.types.FishingRodItem;
import me.deftware.client.framework.item.types.PotionItem;
import me.deftware.client.framework.item.types.RangedWeaponItem;
import me.deftware.client.framework.item.types.TridentItem;
import me.deftware.client.framework.math.box.DoubleBoundingBox;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;

public class C0337 extends AbstractMod {
   private final LineRenderStack f_d2184f82 = new LineRenderStack();
   private final CubeRenderStack f_d7278a20 = new CubeRenderStack();
   @C0098(
      value = "Line color",
      description = {"The line color"}
   )
   private Color f_33d63b85 = Color.cyan;
   @C0098(
      value = "Box color",
      description = {"The color where the arrow will land"}
   )
   private Color f_e4d9dfae = new Color(1, 1, 255, 50);

   public C0337() {
      super(C0255.m_9793dfe2(), C0290.f_3210deb7, C0255.m_1635bc47());
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      RenderStack.setupGl();
      ((LineRenderStack)this.f_d2184f82.glColor(this.f_33d63b85)).begin(3);
      ArrayList var2 = this.m_605ee793(var1.getPartialTicks());
      Vector3d var3 = Minecraft.getMinecraftGame().getCamera().getCameraPosition();
      this.m_b99bcdd9(var2, var3);
      this.f_d2184f82.end();
      if (!var2.isEmpty()) {
         Vector3d var4 = (Vector3d)var2.get(var2.size() - 1);
         this.m_ec5cd955(var4);
      }

      RenderStack.restoreGl();
   }

   private void m_b99bcdd9(ArrayList<Vector3d> var1, Vector3d var2) {
      for (Vector3d var4 : var1) {
         this.f_d2184f82.drawPoint(var4.getX() - var2.getX(), var4.getY() - var2.getY(), var4.getZ() - var2.getZ());
      }
   }

   private void m_ec5cd955(Vector3d var1) {
      double var2 = var1.getX() - 0.5;
      double var4 = var1.getY() - 0.5;
      double var6 = var1.getZ() - 0.5;
      ((CubeRenderStack)this.f_d7278a20.glColor(this.f_e4d9dfae))
         .begin()
         .draw(new DoubleBoundingBox(var2, var4, var6, var2 + 1.0, var4 + 1.0, var6 + 1.0))
         .end();
   }

   private ArrayList<Vector3d> m_605ee793(float var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      ArrayList var3 = new ArrayList();
      ItemStack var4 = var2.getInventory().getHeldItem(false);
      Item var5 = var4.getItem();
      if (!var4.isEmpty() && var5.isThrowable()) {
         double var6 = var2.getLastTickPosX()
            + (var2.getPosX() - var2.getLastTickPosX()) * (double)var1
            - Math.cos(Math.toRadians((double)var2.getRotationYaw())) * 0.16;
         double var8 = var2.getLastTickPosY() + (var2.getPosY() - var2.getLastTickPosY()) * (double)var1 + var2.getStandingEyeHeight() - 0.1;
         double var10 = var2.getLastTickPosZ()
            + (var2.getPosZ() - var2.getLastTickPosZ()) * (double)var1
            - Math.sin(Math.toRadians((double)var2.getRotationYaw())) * 0.16;
         double var12 = var5 instanceof RangedWeaponItem ? 1.0 : 0.4;
         double var14 = Math.toRadians((double)var2.getRotationYaw());
         double var16 = Math.toRadians((double)var2.getRotationPitch());
         double var18 = -Math.sin(var14) * Math.cos(var16) * var12;
         double var20 = -Math.sin(var16) * var12;
         double var22 = Math.cos(var14) * Math.cos(var16) * var12;
         double var24 = Math.sqrt(var18 * var18 + var20 * var20 + var22 * var22);
         var18 /= var24;
         var20 /= var24;
         var22 /= var24;
         if (var5 instanceof RangedWeaponItem) {
            float var26 = (float)(72000 - var2.getItemInUseMaxCount()) / 20.0F;
            var26 = (var26 * var26 + var26 * 2.0F) / 3.0F;
            if (var26 > 1.0F || var26 <= 0.1F) {
               var26 = 1.0F;
            }

            var26 *= 3.0F;
            var18 *= (double)var26;
            var20 *= (double)var26;
            var22 *= (double)var26;
         } else {
            var18 *= 1.5;
            var20 *= 1.5;
            var22 *= 1.5;
         }

         double var40 = this.m_d00451e8(var5);
         Vector3d var28 = new Vector3d(var2.getPosX(), var2.getPosY() + var2.getEyeHeight(), var2.getPosZ());

         for (int var29 = 0; var29 < 1000; var29++) {
            Vector3d var30 = new Vector3d(var6, var8, var10);
            var3.add(var30);
            var6 += var18 * 0.1;
            var8 += var20 * 0.1;
            var10 += var22 * 0.1;
            var18 *= 0.999;
            var20 *= 0.999;
            var22 *= 0.999;
            var20 -= var40 * 0.1;
            if (Vector3d.rayTraceBlocks(var28, var30)) {
               break;
            }
         }

         return var3;
      } else {
         return var3;
      }
   }

   private double m_d00451e8(Item var1) {
      if (var1 instanceof BowItem || var1 instanceof CrossbowItem) {
         return 0.05;
      } else if (var1 instanceof PotionItem) {
         return 0.4;
      } else if (var1 instanceof FishingRodItem) {
         return 0.15;
      } else {
         return var1 instanceof TridentItem ? 0.015 : 0.03;
      }
   }
}
