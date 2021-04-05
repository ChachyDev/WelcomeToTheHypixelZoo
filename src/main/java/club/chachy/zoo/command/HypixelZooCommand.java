package club.chachy.zoo.command;

import club.chachy.zoo.HypixelZooMod;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HypixelZooCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "hypixelzoo";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.RenderTickEvent event) {
        Minecraft.getMinecraft().displayGuiScreen(HypixelZooMod.INSTANCE.getConfig().gui());
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}
