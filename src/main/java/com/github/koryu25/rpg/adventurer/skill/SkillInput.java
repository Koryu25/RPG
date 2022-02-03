package com.github.koryu25.rpg.adventurer.skill;

import java.util.ArrayList;

public class SkillInput extends ArrayList<SkillMoment> {

    private final int firstIndex;

    public final SkillAction action;

    public SkillInput(int firstIndex, SkillAction action) {
        this.firstIndex = firstIndex;
        this.action = action;
    }

    public void add(Accuracy accuracy) {
        add(new SkillMoment(action, accuracy));
    }

    // Getter
    public int getFirstIndex() {
        return firstIndex;
    }
    public int getLastIndex() {
        return firstIndex + size() - 1;
    }
}
