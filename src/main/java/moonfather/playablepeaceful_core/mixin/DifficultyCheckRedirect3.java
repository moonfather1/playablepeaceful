package moonfather.playablepeaceful_core.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WitherBoss.class)
public class DifficultyCheckRedirect3
{
    @Redirect(method = "checkDespawn", at = @At(value = "INVOKE", target = "net/minecraft/world/level/Level.getDifficulty ()Lnet/minecraft/world/Difficulty;"))
    private Difficulty redirectInCheckDespawn(Level level)
    {
        return Difficulty.HARD;
    }
}
