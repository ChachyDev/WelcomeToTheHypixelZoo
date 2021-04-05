package club.chachy.zoo.handler;

import club.chachy.zoo.HypixelZooMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class HypixelJoinHandler {
    public ServerData currentlyConnected;

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (HypixelZooMod.INSTANCE.getConfig().isModEnabled()) {
            EntityPlayer thePlayer = Minecraft.getMinecraft().thePlayer;
            if (thePlayer == null || event.entity != thePlayer) return;

            ServerData serverData = Minecraft.getMinecraft().getCurrentServerData();

            if (serverData != null) {
                boolean isNewServer = currentlyConnected == null || !currentlyConnected.serverIP.equals(serverData.serverIP);

                if (currentlyConnected == null) {
                    currentlyConnected = serverData;
                }

                if (isNewServer && serverData.serverIP.endsWith("hypixel.net")) {
                    Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("zoomod:zoo"), 1.0f));
                }
            }
        }
    }

    @SubscribeEvent
    public void onClientDisconnectFromServer(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        currentlyConnected = null;
    }
}
