package com.nextplugins.report.api.event;

import com.nextplugins.report.api.Report;
import lombok.Data;
import org.bukkit.event.Cancellable;

@Data
public abstract class ReportEvent implements Cancellable {

    private final Report report;
    private boolean cancelled;

}
