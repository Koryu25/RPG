package com.github.koryu25.rpg.adventurer.skill.skills;

import com.github.koryu25.rpg.adventurer.skill.skills.one_handed_sword.Test;
import com.github.koryu25.rpg.item.weapon.WeaponType;

import java.util.ArrayList;
import java.util.List;

public class SkillListManager extends ArrayList<SkillList> {

    public SkillListManager() {
        add(new Test());
    }

    // 流派からスキルリストを検索
    public SkillList fromStyle(Style style) {
        for (SkillList skillList : this) {
            if (skillList.getStyle() == style) return skillList;
        }
        return null;
    }

    // 武器の種類から流派を検索
    public List<SkillList> fromWeapon(WeaponType type) {
        List<SkillList> list = new ArrayList<>();
        for (SkillList skillList : this) {
            if (skillList.getStyle().getWeaponType() != type) continue;
            list.add(skillList);
        }
        return list;
    }
}
