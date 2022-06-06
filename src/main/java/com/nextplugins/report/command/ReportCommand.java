package com.nextplugins.report.command;

import com.nextplugins.report.configuration.value.MessageValue;
import com.nextplugins.report.controller.ReportController;
import com.nextplugins.report.menu.ReportMenu;
import com.nextplugins.report.menu.ReportReasonMenu;
import com.nextplugins.report.menu.registry.MenuRegistry;
import lombok.Data;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Data
public class ReportCommand {

    private final ReportController controller;
    private final MenuRegistry menuRegistry;

    @Command(
            name = "report",
            aliases = {"denunciar"},
            target = CommandTarget.PLAYER
    )
    public void onReport(Context<CommandSender> context, @Optional OfflinePlayer target) {
        if (target == null) {
            context.sendMessage(MessageValue.get(MessageValue::playerNotFound));

            return;
        }

        final Player sender = (Player) context.getSender();

        if (target.getUniqueId().compareTo(sender.getUniqueId()) == 0) {
            sender.sendMessage(MessageValue.get(MessageValue::cantReportHimself));

            return;
        }

        menuRegistry.getReportReasonMenu().openInventory(sender, (viewer -> {
            viewer.getPropertyMap().set("target", target);
        }));
    }

    @Command(
            name = "reports",
            aliases = {"denuncias"},
            permission = "report.list",
            target = CommandTarget.PLAYER
    )
    public void onReportList(Context<CommandSender> context) {
        menuRegistry.getReportListMenu().openInventory((Player) context.getSender());
    }

}
