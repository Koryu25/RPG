package com.github.koryu25.rpg.adventurer.skill.skills;

import com.github.koryu25.rpg.adventurer.skill.Skill;

import java.util.ArrayList;

public class SkillList extends ArrayList<Skill> {

    protected final Style style;

    protected SkillList(Style style) {
        this.style = style;
    }

    public Skill fromName(String name) {
        for (Skill skill : this) {
            if (skill.getName().equals(name)) return skill;
        }
        return null;
    }

    public Style getStyle() {
        return style;
    }
}