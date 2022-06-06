package com.nextplugins.report.bungee;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.nextplugins.report.NextReport;
import com.nextplugins.report.api.Report;
import com.nextplugins.report.api.ReportSerializer;
import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;

@Data
public class BungeeMessaging implements PluginMessageListener {

    private final NextReport plugin;
    private final Messenger messenger;

    public void enable() {
        messenger.registerIncomingPluginChannel(plugin, "next:report", this);

        messenger.registerOutgoingPluginChannel(plugin, "next:report");
        messenger.registerOutgoingPluginChannel(plugin, "BungeeCord");
    }

    public void disable() {
        messenger.unregisterIncomingPluginChannel(plugin);
        messenger.unregisterOutgoingPluginChannel(plugin);
    }

    public void teleport(Player player, String server) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();

        output.writeUTF("Connect");
        output.writeUTF(server);

        player.sendPluginMessage(plugin, "BungeeCord", output.toByteArray());
    }

    public void reportToBungee(Report report) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();

        output.writeUTF("ReportDeleteChannel");
        output.writeUTF(ReportSerializer.to(report));

        // TODO: send through a random player to "next:report" channel
    }

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("next:report")) return;

        ByteArrayDataInput input = ByteStreams.newDataInput(message);

        final String subChannel = input.readUTF();

        if (!subChannel.equalsIgnoreCase("NextReport")) return;

        // TODO: save report into report controller
    }

}
