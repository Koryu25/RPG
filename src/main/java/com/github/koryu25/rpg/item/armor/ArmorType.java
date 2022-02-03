package com.github.koryu25.rpg.item.armor;

public enum ArmorType {
    HEAD("頭"),
    CHEST("胸"),
    LEGGINGS("脚"),
    BOOTS("足");

    private String label;

    ArmorType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
