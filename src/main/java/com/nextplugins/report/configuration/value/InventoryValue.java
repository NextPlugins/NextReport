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
@ConfigFile("menu.yml")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InventoryValue implements ConfigurationInjectable {

    @Getter private static final InventoryValue instance = new InventoryValue();

    @ConfigField("report-list.title") private String reportListTitle;
    @ConfigField("report-list.size") private int reportListSize;

    @ConfigField("report-list.items.player-head.fill-mode") private boolean reportListFillMode;

    @ConfigField("reason-list.title") private String reasonListTile;
    @ConfigField("reason-list.size") private int reasonListTitle;

    @ConfigField("reason-list.items.player-head.fill-mode") private boolean reasonListFillMode;

    @ConfigField("report.title") private String reportTitle;
    @ConfigField("report.size") private int reportSize;

    public static <T> T get(Function<InventoryValue, T> function) {
        return function.apply(instance);
    }

}
