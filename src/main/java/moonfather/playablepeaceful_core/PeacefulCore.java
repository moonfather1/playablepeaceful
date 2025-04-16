package moonfather.playablepeaceful_core;

import moonfather.playablepeaceful.Constants;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class PeacefulCore
{
    public static void initialize(ModLoadingContext context)
    {
        context.registerConfig(ModConfig.Type.COMMON, OptionsHolder.COMMON_SPEC, Constants.MODID_MERGED + "_core.toml");
    }
}
