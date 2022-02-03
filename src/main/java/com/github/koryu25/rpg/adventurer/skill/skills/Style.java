package com.github.koryu25.rpg.adventurer.skill.skills;

import com.github.koryu25.rpg.item.weapon.WeaponType;

public enum Style {
    ONE_HANDED_SWORD＿TEST(WeaponType.ONE_HANDED_SWORD, "テスト流片手剣術"),
    ;

    private WeaponType weaponType;
    private String label;

    Style(WeaponType weaponType, String label) {
        this.weaponType = weaponType;
        this.label = label;
    }

    // Getter
    public WeaponType getWeaponType() {
        return weaponType;
    }
    public String getLabel() {
        return label;
    }
}