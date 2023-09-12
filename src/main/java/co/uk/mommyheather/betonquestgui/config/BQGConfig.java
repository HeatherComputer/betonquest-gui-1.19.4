package co.uk.mommyheather.betonquestgui.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class BQGConfig
{
    public static final ForgeConfigSpec clientSpec;
    public static final Config CONFIG;

    static {
        final Pair<Config, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Config::new);
        clientSpec = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    public static void register() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, clientSpec);
    }

    public static class Config
    {
        public final ForgeConfigSpec.BooleanValue showCompass;
        public final ForgeConfigSpec.BooleanValue showDistance;

        
        public final ForgeConfigSpec.BooleanValue dimGame;

        Config(ForgeConfigSpec.Builder builder)
        {
            builder.push("BetonQuestGui");
            this.showCompass = builder
                    .comment("If true show the compass on screen")
                    .define("showCompass", true);
            this.showDistance = builder
                    .comment("If true show the distance from the quest marker")
                    .define("showDistance", true);


            
            this.dimGame = builder
                    .comment("Whether to dim the rest of the screen whilst in a conversation")
                    .define("dimScreen", false);
            builder.pop();
        }
    }

}
