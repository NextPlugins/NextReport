package com.nextplugins.report.api.event;

import com.nextplugins.report.api.Report;

public final class ReportCreateEvent extends ReportEvent {

    public ReportCreateEvent(Report report) {
        super(report);
    }

}
