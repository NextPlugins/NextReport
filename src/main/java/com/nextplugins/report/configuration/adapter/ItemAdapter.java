package com.nextplugins.report.configuration.adapter;

import com.nextplugins.report.utils.ItemBuilder;
import lombok.Data;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

@Data
public class ItemAdapter {

    public static ItemStack of(ConfigurationSection section) {
        final Material material = Material.getMaterial(section.getString("item"));

        return new ItemBuilder(material)
                .lore(section.getStringList("lore"))
                .name(section.getString("display-name"))
                .result();
    }

}
