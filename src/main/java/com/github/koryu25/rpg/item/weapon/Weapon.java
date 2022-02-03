package com.github.koryu25.rpg.item.weapon;

import com.github.koryu25.rpg.item.Item;
import com.github.koryu25.rpg.item.ItemType;
import com.github.koryu25.rpg.item.weapon.WeaponType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Weapon extends Item {

    // ItemType
    // Name
    // Description
    // ItemStack
    private WeaponType weaponType;// 武器の種類
    private double attack;// 武器の攻撃力
    private double weight;// 武器の重さ

    public Weapon(String name, Material material, List<String> description, WeaponType weaponType, double attack, int weight) {
        super(ItemType.WEAPON, name, material, description);
        this.weaponType = weaponType;
        this.attack = attack;
        this.weight = weight;
        updateLore();
    }

    public void updateLore() {
        List<String> lore = new ArrayList<>();
        lore.addAll(description);
        lore.addAll(generateWeaponLore());
        itemStack.getItemMeta().setLore(lore);
    }

    public List<String> generateWeaponLore() {
        List<String> list = new ArrayList<>();
        list.add("-- 武器の情報 --");
        list.add("武器の種類: " + weaponType.getLabel());
        list.add("攻撃力: " + Math.round(attack * 100) / 100);
        list.add("重量: " + Math.round(weight * 100) / 100);
        return list;
    }

    // Setter
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
    public void setAttack(double attack) {
        this.attack = attack;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getter
    public WeaponType getWeaponType() {
        return weaponType;
    }
    public double getAttack() {
        return attack;
    }
    public double getWeight() {
        return weight;
    }
}
