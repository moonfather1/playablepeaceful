package moonfather.playablepeaceful_core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class OptionsHolder
{
	public static class Common
	{
		private static final int defaultHealthAtWhichStarvationDamageStops = 0;
		private static final int defaultMinimumFoodLevelForHealing = 18;
		private static final int defaultMinimumFoodLevelOnRevive = 8;
		private static final boolean defaultRestoreFoodLevelOnRevive = true;

		public final ConfigValue<Integer> HealthAtWhichStarvationDamageStops;
		public final ConfigValue<Boolean> RestoreFoodLevelOnRevive;
		public final ConfigValue<Integer> MinimumFoodLevelOnRevive;
		public final ConfigValue<Integer> MinimumFoodLevelForHealing;

		public final ConfigValue<Boolean> PiglinsGetPissyIfNoGold;



		public Common(ForgeConfigSpec.Builder builder)
		{
			builder.push("main");
			this.HealthAtWhichStarvationDamageStops = builder.comment("When the player is at zero food shanks, he starts taking starvation damage. This value controls how far this damage goes on peaceful difficulty. Default is 0, meaning you can actually die of starvation, like on hard difficulty. If you're a chicken, set it to 1 to stop just short of dying (half-a-heart, like on normal difficulty) or set it to 10 to stop at 5 hearts, like on easy difficulty.")
					.defineInRange("Health at which starvation damage stops", defaultHealthAtWhichStarvationDamageStops, 0, 10);
			this.RestoreFoodLevelOnRevive = builder.comment("This controls whether player's hunger level is preserved on death/revival or reset to full. Use a separate setting to set a minimum hunger level. This feature works for all difficulty modes, not just peaceful.")
					.define("Restore food level on revive", defaultRestoreFoodLevelOnRevive);
			this.MinimumFoodLevelOnRevive = builder.comment("If you set this mod to restore players hunger level on revival (separate setting here), this is a minimum value for food level. This only matters if the player died of starvation or was very very hungry when the creeper got him/her; here you set with how many food shanks player continues. To disable, use a separate option.")
					.defineInRange("Minimum food level on revive", defaultMinimumFoodLevelOnRevive, 2, 20);
			this.MinimumFoodLevelForHealing = builder.comment("This is a minimum food value that triggers healing. 18 by default, as in vanilla, means 18-20 heals the player by 1 point and reduces food level. You can set this to 11 for example to heal players when food is above half, or to 20 to only heal when food level is maxed. Affects easy and peaceful difficulties.")
					.defineInRange("Minimum food level to regenerate health", defaultMinimumFoodLevelForHealing, 2, 20);
			builder.pop();
			builder.push("mobs");
			this.PiglinsGetPissyIfNoGold = builder.comment("Turn this off to have piglins ignore your armor. By default they act the same as on other difficulty modes and will attack.")
												   .define("Piglins get pissy if you are not wearing gold armor", true);
			builder.pop();
		}
	}

	public static final Common COMMON;
	public static final ForgeConfigSpec COMMON_SPEC;

	static //constructor
	{
		Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON = commonSpecPair.getLeft();
		COMMON_SPEC = commonSpecPair.getRight();
	}
}
