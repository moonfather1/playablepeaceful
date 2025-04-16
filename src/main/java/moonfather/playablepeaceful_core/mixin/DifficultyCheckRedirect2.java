package moonfather.playablepeaceful_core.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WitherSkullBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WitherSkullBlock.class)
public class DifficultyCheckRedirect2
{
    @Redirect(method = "canSpawnMob", at = @At(value = "INVOKE", target = "net/minecraft/world/level/Level.getDifficulty ()Lnet/minecraft/world/Difficulty;"))
    private static Difficulty redirectInCanSpawnMob(Level level)
    {
        return Difficulty.HARD;
    }

    @Redirect(method = "checkSpawn", at = @At(value = "INVOKE", target = "net/minecraft/world/level/Level.getDifficulty ()Lnet/minecraft/world/Difficulty;"))
    private static Difficulty redirectInCheckSpawn(Level level)
    {
        return Difficulty.HARD;
    }
}
