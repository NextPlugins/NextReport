package com.nextplugins.report.menu;

import com.henryfabio.minecraft.inventoryapi.editor.InventoryEditor;
import com.henryfabio.minecraft.inventoryapi.inventory.impl.global.GlobalInventory;
import com.nextplugins.report.api.Report;
import com.nextplugins.report.configuration.value.InventoryValue;
import com.nextplugins.report.controller.ReportController;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class ReportListMenu extends GlobalInventory {

    private final List<Report> reports;

    public ReportListMenu() {
        super(
                "report.list.menu",
                InventoryValue.get(InventoryValue::reportListTitle),
                InventoryValue.get(InventoryValue::reportListSize) * 3
        );

        this.reports = ReportController.getInstance().getReports();
    }

    @Override
    protected void configureInventory(@NotNull InventoryEditor editor) {

    }

}
