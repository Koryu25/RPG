package com.github.koryu25.rpg.adventurer.skill;

public class SkillMoment {

    public SkillAction action;
    public Accuracy accuracy;

    public SkillMoment(SkillAction action, Accuracy accuracy) {
        this.action = action;
        this.accuracy = accuracy;
    }
}
