package moonfather.playablepeaceful_core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WitherRoseBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherRoseBlock.class)
public class DifficultyCheckRedirect1
{
    @Redirect(method = "entityInside", at = @At(value = "INVOKE", target = "net/minecraft/world/level/Level.getDifficulty ()Lnet/minecraft/world/Difficulty;"))
    private Difficulty redirectInEntityInside(Level level)
    {
        // could check  if (level.getLevelData().getDifficulty() == Difficulty.PEACEFUL),   but i don't care, except in FoodStats class
        return Difficulty.HARD;  // do wither roses hurt
    }

//    @Inject(method = "entityInside(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/Entity;)V", at = @At(value = "HEAD"), cancellable = true)
//    private void head(BlockState p_58238_, Level p_58239_, BlockPos p_58240_, Entity entity, CallbackInfo ci)
//    {
//        if (entity instanceof LivingEntity le)
//        {
//            le.addEffect(new MobEffectInstance(MobEffects.HUNGER, 10*20, 3));
//        }
//        ci.cancel();
//        //System.out.println("~~~head");
//    }
}
