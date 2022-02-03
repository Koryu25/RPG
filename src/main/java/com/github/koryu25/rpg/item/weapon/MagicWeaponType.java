package com.github.koryu25.rpg.item.weapon;

public enum MagicWeaponType {
    STAFF("スタッフ"),
    ROD("ロッド");

    private String label;

    MagicWeaponType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static WeaponType fromLabel(String label) {
        for (WeaponType type : WeaponType.values()) {
            if (type.getLabel().equals(label)) return type;
        }
        return null;
    }
}
