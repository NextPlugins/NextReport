package com.nextplugins.report;

import org.bukkit.plugin.java.JavaPlugin;

public final class NextReport extends JavaPlugin {

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public static NextReport getInstance() {
        return getPlugin(NextReport.class);
    }

}
