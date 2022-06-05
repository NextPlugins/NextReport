package com.nextplugins.report.configuration.value;

import com.henryfabio.minecraft.configinjector.common.annotations.ConfigField;
import com.henryfabio.minecraft.configinjector.common.annotations.ConfigFile;
import com.henryfabio.minecraft.configinjector.common.annotations.TranslateColors;
import com.henryfabio.minecraft.configinjector.common.injector.ConfigurationInjectable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.function.Function;

@Getter
@TranslateColors
@Accessors(fluent = true)
@ConfigFile("config.yml")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigValue implements ConfigurationInjectable {

    @Getter private static final ConfigValue instance = new ConfigValue();

    @ConfigField("bungee.enabled") private boolean bungeeEnabled;
    @ConfigField("bungee.server-name.bungee") private String bungeeServerName;
    @ConfigField("bungee.server-name.display") private String bungeeServerDisplayName;

    @ConfigField("expire.enabled") private boolean canExpire;
    @ConfigField("expire.time.in") private int expireTime;
    @ConfigField("expire.time.unit") private String expireUnit;


    public static <T> T get(Function<ConfigValue, T> function) {
        return function.apply(instance);
    }


}
