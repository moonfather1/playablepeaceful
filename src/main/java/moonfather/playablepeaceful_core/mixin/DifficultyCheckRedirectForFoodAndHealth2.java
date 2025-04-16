package moonfather.playablepeaceful_core.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public class DifficultyCheckRedirectForFoodAndHealth2
{
    @Redirect(method = "aiStep", at = @At(value = "INVOKE", target = "net/minecraft/world/level/Level.getDifficulty ()Lnet/minecraft/world/Difficulty;"))
    private Difficulty redirectInAIStep(Level level)
    {
        return Difficulty.HARD;  // permanent health and saturation regeneration
    }

    @Redirect(method = "hurt", at = @At(value = "INVOKE", target = "net/minecraft/world/level/Level.getDifficulty ()Lnet/minecraft/world/Difficulty;"))
    private Difficulty redirectInHurt(Level level)
    {
        return Difficulty.NORMAL; // multiplier for damage that scales with difficulty
    }
}
