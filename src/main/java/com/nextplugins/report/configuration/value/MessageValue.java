package com.nextplugins.report.configuration.value;

import com.henryfabio.minecraft.configinjector.common.annotations.ConfigField;
import com.henryfabio.minecraft.configinjector.common.annotations.ConfigFile;
import com.henryfabio.minecraft.configinjector.common.annotations.TranslateColors;
import com.henryfabio.minecraft.configinjector.common.injector.ConfigurationInjectable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.function.Function;

@Getter
@TranslateColors
@Accessors(fluent = true)
@ConfigFile("messages.yml")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageValue implements ConfigurationInjectable {

    @Getter private static final MessageValue instance = new MessageValue();

    @ConfigField("player.success") private String reportSuccess;
    @ConfigField("player.already") private String alreadyReported;
    @ConfigField("player.not-found") private String playerNotFound;
    @ConfigField("player.himself") private String cantReportHimself;

    @ConfigField("admin.alert") private List<String> alert;
    @ConfigField("admin.bungee-teleport") private String bungeeTeleport;
    @ConfigField("admin.offline") private String targetOffline;
    @ConfigField("admin.success") private String teleportSuccess;
    @ConfigField("admin.delete") private String reportDeleted;

    public static <T> T get(Function<MessageValue, T> function) {
       return function.apply(instance);
    }

}
