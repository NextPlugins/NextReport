package com.nextplugins.report.menu;

import com.henryfabio.minecraft.inventoryapi.editor.InventoryEditor;
import com.henryfabio.minecraft.inventoryapi.inventory.impl.simple.SimpleInventory;
import com.henryfabio.minecraft.inventoryapi.viewer.Viewer;
import com.nextplugins.report.api.Report;
import com.nextplugins.report.configuration.value.InventoryValue;
import com.nextplugins.report.controller.ReportController;
import org.jetbrains.annotations.NotNull;

public final class ReportMenu extends SimpleInventory {

    private final ReportController controller;

    public ReportMenu() {
        super(
                "report.menu",
                InventoryValue.get(InventoryValue::reportTitle),
                InventoryValue.get(InventoryValue::reportSize) * 3
        );

        controller = ReportController.getInstance();
    }

    @Override
    protected void configureInventory(@NotNull Viewer viewer, @NotNull InventoryEditor editor) {
        final Report report = viewer.getPropertyMap().get("report");

    }

}
