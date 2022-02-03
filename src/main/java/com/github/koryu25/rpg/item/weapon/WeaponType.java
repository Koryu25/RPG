package com.github.koryu25.rpg.item.weapon;

public enum WeaponType {
    ONE_HANDED_SWORD("片手剣"),
    DOUBLE_HANDED_SWORD("両手剣"),
    RAPIER("レイピア"),
    KNIFE("ナイフ"),
    KATANA("刀"),
    SPEAR("槍"),
    AXE("斧"),
    KNUCKLE("ナックル");

    private String label;

    WeaponType(String label) {
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