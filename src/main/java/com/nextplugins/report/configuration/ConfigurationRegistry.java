package com.nextplugins.report.configuration;

import com.henryfabio.minecraft.configinjector.bukkit.injector.BukkitConfigurationInjector;
import com.nextplugins.report.NextReport;
import com.nextplugins.report.configuration.value.ConfigValue;
import com.nextplugins.report.configuration.value.InventoryValue;
import com.nextplugins.report.configuration.value.MessageValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ConfigurationRegistry {

    private final NextReport plugin;

    public void load() {
        final BukkitConfigurationInjector injector = new BukkitConfigurationInjector(plugin);

        injector.saveDefaultConfiguration(
                plugin,
                "config.yml",
                "menu.yml",
                "reasons.yml",
                "messages.yml"
        );

        injector.injectConfiguration(
                ConfigValue.instance(),
                MessageValue.instance(),
                InventoryValue.instance()
        );
    }

}
