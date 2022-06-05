package com.nextplugins.report.configuration.adapter;

import com.nextplugins.report.NextReport;
import com.nextplugins.report.api.ReportReason;
import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
public class ReasonAdapter {

    @Getter private static final List<ReportReason> reasons = new ArrayList<>();

    private final NextReport plugin;

    @SneakyThrows
    public void load() {
        final FileConfiguration configuration = YamlConfiguration.loadConfiguration(
                new File(plugin.getDataFolder(), "reasons.yml")
        );

        final ConfigurationSection section = configuration.getConfigurationSection("reasons");

        if (section == null) {
            plugin.getLogger().severe("Nenhum motivo foi encontrado.");

            return;
        }

        for (String key : section.getKeys(false)) {
            final String displayName = section.getString(key);

            if (displayName == null) continue;

            reasons.add(new ReportReason(key, ChatColor.translateAlternateColorCodes('&', displayName)));
        }
    }

}
