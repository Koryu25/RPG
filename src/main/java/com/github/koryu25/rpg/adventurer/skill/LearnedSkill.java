package com.github.koryu25.rpg.adventurer.skill;

import com.github.koryu25.rpg.adventurer.skill.skills.Style;

import java.util.ArrayList;

public class LearnedSkill extends ArrayList<Skill> {

    public ArrayList<Skill> searchStyle(Style style) {
        ArrayList<Skill> searched = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            if (get(i).getStyle() == style) {
                searched.add(get(i));
            }
        }
        return searched;
    }
}