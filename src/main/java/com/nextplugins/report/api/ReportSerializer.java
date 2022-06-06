package com.nextplugins.report.api;

import static org.bukkit.Bukkit.getOfflinePlayer;
import static java.util.UUID.fromString;

import com.nextplugins.report.configuration.adapter.ReasonAdapter;
import org.bukkit.OfflinePlayer;

public final class ReportSerializer {

    public static String to(Report report) {
        return report.getId() + ";" +
               report.getAuthor().getUniqueId() + ";" +
               report.getPlayer().getUniqueId() + ";" +
               report.getReason().getId() + ";" +
               report.getCreatedAt();
    }

    public static Report from(String data) {
        final String[] array = data.split(";");

        final OfflinePlayer author = getOfflinePlayer(fromString(array[1]));
        final OfflinePlayer player = getOfflinePlayer(fromString(array[2]));

        final ReportReason reason = ReasonAdapter.getReasons()
                .stream()
                .filter(($) -> $.getId().equals(array[3]))
                .findFirst()
                .get();

        final long createdAt = Long.getLong(array[4]);

        return Report.builder()
                .author(author)
                .player(player)
                .reason(reason)
                .createdAt(createdAt)
                .id(fromString(array[0]))
                .build();
    }

}
