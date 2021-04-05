package club.chachy.zoo;

import club.chachy.zoo.command.HypixelZooCommand;
import club.chachy.zoo.config.ZooModConfig;
import club.chachy.zoo.handler.HypixelJoinHandler;
import club.sk1er.mods.core.ModCoreInstaller;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = HypixelZooMod.MODID, version = HypixelZooMod.VERSION)
public class HypixelZooMod {
    public static final String MODID = "hypixelzoo";
    public static final String VERSION = "1.0.0";

    @Mod.Instance
    public static HypixelZooMod INSTANCE;

    private final ZooModConfig config = new ZooModConfig();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        config.preload();
        ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);
        ClientCommandHandler.instance.registerCommand(new HypixelZooCommand());
        MinecraftForge.EVENT_BUS.register(new HypixelJoinHandler());
    }

    public ZooModConfig getConfig() {
        return config;
    }
}
