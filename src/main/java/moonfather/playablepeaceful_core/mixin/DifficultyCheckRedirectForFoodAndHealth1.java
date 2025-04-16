package moonfather.playablepeaceful_core.mixin;

import moonfather.playablepeaceful_core.OptionsHolder;
import net.minecraft.world.Difficulty;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FoodData.class)
public class DifficultyCheckRedirectForFoodAndHealth1
{
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "net/minecraft/world/level/Level.getDifficulty ()Lnet/minecraft/world/Difficulty;"))
    private Difficulty redirectInTick(Level level)
    {
        if (level.getLevelData().getDifficulty() == Difficulty.PEACEFUL)
        {
            // nutrition decreasing
            if (OptionsHolder.COMMON.HealthAtWhichStarvationDamageStops.get() == 0)
            {
                return Difficulty.HARD;
            }
            else if (OptionsHolder.COMMON.HealthAtWhichStarvationDamageStops.get() == 1)
            {
                return Difficulty.NORMAL;
            }
            else
            {
                return Difficulty.EASY;
            }
        }
        return level.getLevelData().getDifficulty();
    }

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 18))
    private int modify18(int value)
    {
        return OptionsHolder.COMMON.MinimumFoodLevelForHealing.get();  // by default healing is at 18+
    }

    @ModifyConstant(method = "tick", constant = @Constant(floatValue = 10f))
    private float modify10(float value)
    {
        return OptionsHolder.COMMON.HealthAtWhichStarvationDamageStops.get();  // by default starvation stops at 0 on peaceful now
    }
}
