package com.nextplugins.report.controller;

import com.nextplugins.report.api.Report;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReportController {

    @Getter private static final ReportController instance = new ReportController();

    private final List<Report> reports = new ArrayList<>();

    public void add(Report report) {
        reports.add(report);
    }

    public void remove(Report report) {
        reports.remove(report);
    }

    public List<Report> getBy(Predicate<Report> filter) {
        return reports.stream().filter(filter).collect(Collectors.toList());
    }

    public List<Report> getReports() {
        getBy(Report::isExpired).forEach(this::remove);

        return reports;
    }

}
