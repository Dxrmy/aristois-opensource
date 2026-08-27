/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2558
 *  net.minecraft.class_2558$class_2559
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  net.minecraft.class_4068
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_5481
 *  net.minecraft.class_634
 *  net.minecraft.class_637
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.gui;

import java.util.List;
import java.util.stream.Collectors;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.gui.widgets.GenericComponent;
import me.deftware.client.framework.gui.widgets.NativeComponent;
import me.deftware.client.framework.gui.widgets.properties.Tooltipable;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_4068;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_5481;
import net.minecraft.class_634;
import net.minecraft.class_637;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_437.class})
public abstract class MixinGuiScreen
implements MinecraftScreen {
    @Unique
    private final EventScreen event = new EventScreen((class_437)this);
    @Shadow
    @Final
    private List<class_4068> field_33816;
    @Shadow
    @Final
    private List<class_364> field_22786;
    @Shadow
    protected class_310 field_22787;

    @Shadow
    protected abstract void method_37067();

    @Override
    public <T extends GenericComponent> List<T> getChildren(Class<T> clazz) {
        return this.field_22786.stream().filter(clazz::isInstance).map(clazz::cast).collect(Collectors.toList());
    }

    @Override
    public void _clearChildren() {
        this.method_37067();
    }

    @Override
    public void addScreenComponent(GenericComponent component, int index) {
        if (component instanceof NativeComponent) {
            NativeComponent nativeComponent = (NativeComponent)((Object)component);
            component = nativeComponent.getComponent();
        }
        if (component instanceof class_4068) {
            class_4068 drawable = (class_4068)component;
            this.appendArray(this.field_33816, drawable, index);
        }
        if (component instanceof class_364) {
            class_364 element = (class_364)component;
            this.appendArray(this.field_22786, element, index);
        }
    }

    private <T> void appendArray(List<T> list, T object, int index) {
        if (index < 0 || index > list.size()) {
            list.add(object);
        } else {
            list.add(index, object);
        }
    }

    @Override
    public EventScreen getEventScreen() {
        return this.event;
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void onDraw(class_332 context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        this.event.setMouseX(mouseX);
        this.event.setMouseY(mouseY);
        this.event.setType(EventScreen.Type.Draw).setContext(GLX.of(context)).broadcast();
    }

    @Inject(method={"renderWithTooltip"}, at={@At(value="RETURN")})
    private void onPostDraw(class_332 context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (!(this instanceof class_465)) {
            this.onPostDrawEvent(context, mouseX, mouseY, delta);
        }
    }

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void init(class_2561 title, CallbackInfo ci) {
        this.event.setType(EventScreen.Type.Init).broadcast();
    }

    @Inject(method={"init(Lnet/minecraft/client/MinecraftClient;II)V"}, at={@At(value="RETURN")})
    private void init(CallbackInfo ci) {
        this.event.setType(EventScreen.Type.Setup).broadcast();
    }

    @Unique
    protected void onPostDrawEvent(class_332 context, int mouseX, int mouseY, float delta) {
        this.event.setType(EventScreen.Type.PostDraw).setContext(GLX.of(context)).broadcast();
        for (class_364 element : this.field_22786) {
            List<class_5481> list;
            Tooltipable tooltipable;
            if (!(element instanceof Tooltipable) || !(tooltipable = (Tooltipable)element).isMouseOverComponent(mouseX, mouseY) || (list = tooltipable.getTooltipComponents(mouseX, mouseY)) == null || list.isEmpty()) continue;
            this.renderTooltip(GLX.of(context), mouseX, mouseY, list);
            break;
        }
    }

    @Inject(method={"handleTextClick"}, at={@At(value="HEAD")}, cancellable=true)
    private void onTextClick(class_2583 style, CallbackInfoReturnable<Boolean> cir) {
        String trigger;
        String text;
        class_2558 event = style.method_10970();
        if (event != null && event.method_10845() == class_2558.class_2559.field_11750 && (text = event.method_10844()).startsWith(trigger = CommandRegister.getCommandTrigger())) {
            try {
                class_634 networkHandler = class_310.method_1551().method_1562();
                if (networkHandler != null) {
                    class_637 source = networkHandler.method_2875();
                    CommandRegister.getDispatcher().execute(text.substring(trigger.length()), (Object)source);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            cir.setReturnValue((Object)true);
        }
    }
}

