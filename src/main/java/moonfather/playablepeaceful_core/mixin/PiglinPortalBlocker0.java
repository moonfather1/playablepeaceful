package moonfather.playablepeaceful_core.mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class PiglinPortalBlocker0
{
    @Inject(method = "canChangeDimensions", at = @At(value = "HEAD"), cancellable = true)
    public void introInCanChangeDimensions(CallbackInfoReturnable<Boolean> cir)
    {
        // marker for override
    }
}
