package com.nextplugins.report.menu.registry;

import com.nextplugins.report.menu.ReportListMenu;
import com.nextplugins.report.menu.ReportMenu;
import com.nextplugins.report.menu.ReportReasonMenu;
import lombok.Getter;

@Getter
public final class MenuRegistry {

    private final ReportMenu reportMenu;
    private final ReportListMenu reportListMenu;
    private final ReportReasonMenu reportReasonMenu;

    public MenuRegistry() {
        this.reportReasonMenu = new ReportReasonMenu().init();
        this.reportMenu = new ReportMenu().init();
        this.reportListMenu = new ReportMenu().init();
    }

}
