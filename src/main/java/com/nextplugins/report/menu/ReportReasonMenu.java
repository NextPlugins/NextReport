package com.nextplugins.report.menu;

import com.henryfabio.minecraft.inventoryapi.editor.InventoryEditor;
import com.henryfabio.minecraft.inventoryapi.inventory.impl.simple.SimpleInventory;
import com.henryfabio.minecraft.inventoryapi.viewer.Viewer;
import com.nextplugins.report.api.ReportReason;
import com.nextplugins.report.configuration.adapter.ReasonAdapter;
import com.nextplugins.report.configuration.value.InventoryValue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class ReportReasonMenu extends SimpleInventory {

    private final List<ReportReason> reasons;

    public ReportReasonMenu() {
        super(
              "reason.menu",
              InventoryValue.get(InventoryValue::reasonListTile),
              InventoryValue.get(InventoryValue::reasonListSize) * 9
        );

        this.reasons = ReasonAdapter.getReasons();
    }

    @Override
    protected void configureInventory(@NotNull Viewer viewer, @NotNull InventoryEditor editor) {
        final Player target = viewer.getPropertyMap().get("target");


    }

}
