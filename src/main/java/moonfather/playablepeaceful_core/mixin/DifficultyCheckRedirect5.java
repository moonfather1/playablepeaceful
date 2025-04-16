package moonfather.playablepeaceful_core.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class DifficultyCheckRedirect5
{
    @Redirect(method = "canAttack(Lnet/minecraft/world/entity/LivingEntity;)Z", at = @At(value = "INVOKE", target = "net/minecraft/world/level/Level.getDifficulty ()Lnet/minecraft/world/Difficulty;"))
    private Difficulty redirectCanAttack(Level level)
    {
        return Difficulty.HARD;
    }
    // really not sure about this one. could cause problem with 3rd party modded entities
}
