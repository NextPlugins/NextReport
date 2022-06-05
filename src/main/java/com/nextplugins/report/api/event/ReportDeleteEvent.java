package com.nextplugins.report.api.event;

import com.nextplugins.report.api.Report;

public final class ReportDeleteEvent extends ReportEvent {

    public ReportDeleteEvent(Report report) {
        super(report);
    }

}
