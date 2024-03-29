package com.nextplugins.report.api;

import com.nextplugins.report.configuration.value.ConfigValue;
import lombok.Builder;
import lombok.Getter;
import org.bukkit.OfflinePlayer;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Builder
@Getter
public class Report {

    @Builder.Default private final UUID id = UUID.randomUUID();

    private final OfflinePlayer author;
    private final OfflinePlayer player;
    private final ReportReason reason;
    private final long createdAt;

    public boolean isExpired() {
        final boolean canExpire = ConfigValue.get(ConfigValue::canExpire);

        if (!canExpire) return false;

        final int expireTime = ConfigValue.get(ConfigValue::expireTime);
        final TimeUnit expireUnit = TimeUnit.valueOf(ConfigValue.get(ConfigValue::expireUnit));

        return (getCreatedAt() + expireUnit.toMillis(expireTime)) < System.currentTimeMillis();
    }

}
