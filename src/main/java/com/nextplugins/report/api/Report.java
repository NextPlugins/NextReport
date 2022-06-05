package com.nextplugins.report.api;

import com.nextplugins.report.configuration.value.ConfigValue;
import lombok.Builder;
import lombok.Getter;
import org.bukkit.entity.Player;
import sun.security.krb5.Config;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Builder
@Getter
public class Report {

    private final UUID id;
    private final Player author;
    private final Player player;
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
