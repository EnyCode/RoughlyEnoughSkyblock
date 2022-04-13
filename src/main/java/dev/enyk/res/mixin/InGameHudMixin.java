package dev.enyk.res.mixin;

import dev.enyk.res.skyblock.FancyStatusBars.RenderStatusBars;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(InGameHud.class)
public class InGameHudMixin {

	@Shadow @Nullable private Text overlayMessage;

    private RenderStatusBars statusBars = new RenderStatusBars();

	// Remove the health bar
	@ModifyArg(method="renderHealthBar", at=@At(value="INVOKE", target="Lnet/minecraft/util/math/MathHelper;ceil(D)I"), index=0)
    private double injected(double value) {
        return 0;
    }

	// Remove the hunger bar
	@ModifyArgs(method="renderStatusBars", at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void injected(Args args) {
        args.set(5, 0);
    }

	// Render status bars
	@Inject(method="render", at=@At("HEAD"))
    public void render(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        statusBars.renderAll(matrices);
    }

    // Update and cancel the action bar
    @Inject(method = "setOverlayMessage(Lnet/minecraft/text/Text;Z)V", at = @At("HEAD"), cancellable = true)
    private void onSetOverlayMessage(Text message, boolean tinted, CallbackInfo ci) {
        statusBars.update(message.getString());
        ci.cancel();
    }
}
