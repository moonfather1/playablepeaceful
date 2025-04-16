package moonfather.playablepeaceful_core;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.FORGE)
public class RevivalEvents
{
	@SubscribeEvent
	public static void onPlayerClone(PlayerEvent.Clone event)
	{
		if (event.isWasDeath())
		{
			if (OptionsHolder.COMMON.RestoreFoodLevelOnRevive.get())
			{
				int food = Math.max(event.getOriginal().getFoodData().getFoodLevel(), OptionsHolder.COMMON.MinimumFoodLevelOnRevive.get());
				event.getPlayer().getFoodData().setFoodLevel(food);
			}
		}
	}
}
