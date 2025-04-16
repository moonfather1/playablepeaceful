package moonfather.playablepeaceful_core.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.monster.piglin.Piglin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Piglin.class)
public abstract class PiglinPortalBlocker1 extends PiglinPortalBlocker0
{
    @Override
    public void introInCanChangeDimensions(CallbackInfoReturnable<Boolean> cir)
    {
        Piglin thisObject = (Piglin)(Object)this;
        if (thisObject.getLevel().getDifficulty() == Difficulty.PEACEFUL)
        {
            cir.setReturnValue(false);
        }
    }
}
