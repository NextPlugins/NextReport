package com.nextplugins.report;

import com.nextplugins.report.bungee.BungeeMessaging;
import com.nextplugins.report.configuration.ConfigurationRegistry;
import com.nextplugins.report.configuration.value.ConfigValue;
import com.nextplugins.report.menu.registry.MenuRegistry;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class NextReport extends JavaPlugin {

    @Getter private MenuRegistry menuRegistry;
    @Getter private ConfigurationRegistry configurationRegistry;
    @Getter private BungeeMessaging bungeeMessaging;

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {

        this.menuRegistry = new MenuRegistry();
        this.bungeeMessaging = new BungeeMessaging(this, getServer().getMessenger());
        this.configurationRegistry = new ConfigurationRegistry(this);

        if (ConfigValue.get(ConfigValue::bungeeEnabled)) {
            getLogger().info("Plugin em modo bungee.");

            this.bungeeMessaging.enable();
        }
    }

    @Override
    public void onDisable() {
        this.bungeeMessaging.disable();
    }

    public static NextReport getInstance() {
        return getPlugin(NextReport.class);
    }

}
