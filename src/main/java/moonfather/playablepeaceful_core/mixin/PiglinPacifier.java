package moonfather.playablepeaceful_core.mixin;

import moonfather.playablepeaceful_core.OptionsHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public class PiglinPacifier
{
    @Inject(method = "isWearingGold", at = @At(value = "HEAD"), cancellable = true)
    private static void introInIsWearingGold(LivingEntity p_34809_, CallbackInfoReturnable<Boolean> cir)
    {
        if (! OptionsHolder.COMMON.PiglinsGetPissyIfNoGold.get())
        {
            cir.setReturnValue(true);
        }
    }
}
