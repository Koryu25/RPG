package com.github.koryu25.rpg.item.armor;

import com.github.koryu25.rpg.item.Item;
import com.github.koryu25.rpg.item.ItemType;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Armor extends Item {

    // ItemType
    // Name
    // Description
    // ItemStack
    private ArmorType armorType;
    private double defense;
    private double weight;

    public Armor(String name, Material material, List<String> description, ArmorType armorType, double defense, double weight) {
        super(ItemType.ARMOR, name, material, description);
        this.armorType = armorType;
        this.defense = defense;
        this.weight = weight;
    }

    public void updateLore() {
        List<String> lore = new ArrayList<>();
        lore.addAll(description);
        lore.addAll(generateArmorLore());
        itemStack.getItemMeta().setLore(lore);
    }

    public List<String> generateArmorLore() {
        List<String> list = new ArrayList<>();
        list.add("-- 防具の情報 --");
        list.add("防具の種類: " + armorType.getLabel());
        list.add("防御力: " + Math.round(defense * 100) / 100);
        list.add("重量: " + Math.round(weight * 100) / 100);
        return list;
    }

    // Setter
    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }
    public void setDefense(double defense) {
        this.defense = defense;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getter
    public ArmorType getArmorType() {
        return armorType;
    }
    public double getDefense() {
        return defense;
    }
    public double getWeight() {
        return weight;
    }
}
