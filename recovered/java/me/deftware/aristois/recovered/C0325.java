package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.block.StorageEntity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.objects.ItemEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.minecraft.GameSetting;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.world.ClientWorld;

public class C0325 extends AbstractMod {
   private static final C0201 f_05af9c62 = new C0201(C0255.m_8ced16bd());
   private static final C0219<Item> f_bd4d6972 = new C0219<>(Item.class, C0255.m_15ef1a0d());
   @C0098("Players")
   private boolean f_5f4c12c7 = true;
   @C0098(
      value = "Storage",
      description = {"Chests/ShulkerBoxes/Barrels/etc"}
   )
   private boolean f_832ffbbd = false;
   @C0098(
      value = "Hidden",
      description = {"Draw tracers to hidden entities"}
   )
   private boolean f_d870492b = false;
   @C0098("Selected Entities")
   private final GuiScreen f_564b47b2 = C0217.m_c1fb6c03(null, f_05af9c62);
   @C0098("Selected Items")
   private final GuiScreen f_4d8803dc = C0217.m_81b76da4(null, f_bd4d6972);
   private final LineRenderStack f_c1206ba0 = new LineRenderStack();

   public C0325() {
      super(C0255.m_c42f1c7e(), C0290.f_3210deb7, C0255.m_6f1f396d());
   }

   @EventHandler
   public void m_4f06bdb8(EventRender3DNoBobbing var1) {
      if (ClientWorld.getClientWorld() != null && !(Boolean)GameSetting.DEBUG_INFO.get()) {
         Entity var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getCameraEntity());
         Entity var3 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
         RenderStack.setupGl();
         GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
         this.f_c1206ba0.begin();
         if (this.f_832ffbbd) {
            ClientWorld.getClientWorld()
               .getLoadedTileEntities()
               .filter(var0 -> var0 instanceof StorageEntity)
               .map(StorageEntity.class::cast)
               .forEach(var1x -> ((LineRenderStack)this.f_c1206ba0.glColor(C0071.m_b9636182(var1x.getBlock()), 190.0F)).lineToEntity(var1x));
         }

         ClientWorld.getClientWorld()
            .getLoadedEntities()
            .filter(var1x -> !var1x.isInvisible() || this.f_d870492b)
            .filter(var0 -> CameraEntityMan.isActive() ? !CameraEntityMan.isCameraEntity(var0) : !var0.isSelf())
            .filter(var1x -> !var3.isRiding() || var3.getVehicle().getEntityId() != var1x.getEntityId())
            .filter(
               var1x -> {
                  if (var1x instanceof ItemEntity) {
                     return f_bd4d6972.contains(((ItemEntity)var1x).getStack().getItem());
                  } else {
                     return var1x instanceof LivingEntity && !(var1x instanceof EntityPlayer)
                        ? f_05af9c62.m_97a0a4cb(var1x)
                        : var1x instanceof EntityPlayer && this.f_5f4c12c7;
                  }
               }
            )
            .forEach(var2x -> ((LineRenderStack)this.f_c1206ba0.glColor(m_489b12b4(var2x, var2), 190.0F)).lineToEntity(var2x));
         this.f_c1206ba0.end();
         RenderStack.restoreGl();
      }
   }

   public static Color m_489b12b4(Entity var0, Entity var1) {
      float var2 = Math.min(1.0F, Math.max(var0.distanceToEntity(var1) / 48.0F, 0.0F));
      return C0217.m_4771a9db((double)var2, Color.green, Color.red);
   }

   public static C0201 m_95db1db3() {
      return f_05af9c62;
   }

   public static C0219<Item> m_3e9a41cb() {
      return f_bd4d6972;
   }
}
