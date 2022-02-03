package com.github.koryu25.rpg.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Item {

    protected ItemType itemType;
    protected String name;
    protected List<String> description;
    protected ItemStack itemStack;

    public Item(ItemType itemType, String name, Material material, List<String> description) {
        this.itemType = itemType;
        this.name = name;
        this.description = description;
        itemStack = new ItemStack(material);
        itemStack.getItemMeta().setDisplayName(name);
    }

    // Setter
    public void setDescription(List<String> description) {
        this.description = description;
    }

    // Getter
    public ItemType getItemType() {
        return itemType;
    }
    public String getName() {
        return name;
    }
    public List<String> getDescription() {
        return description;
    }
    public ItemStack getItemStack() {
        return itemStack;
    }
}
