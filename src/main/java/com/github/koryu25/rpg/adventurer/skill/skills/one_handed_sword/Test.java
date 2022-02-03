package com.github.koryu25.rpg.adventurer.skill.skills.one_handed_sword;

import com.github.koryu25.rpg.adventurer.Adventurer;
import com.github.koryu25.rpg.adventurer.skill.Skill;
import com.github.koryu25.rpg.adventurer.skill.SkillAction;
import com.github.koryu25.rpg.adventurer.skill.SkillTiming;
import com.github.koryu25.rpg.adventurer.skill.skills.SkillList;
import com.github.koryu25.rpg.adventurer.skill.skills.Style;
import org.bukkit.Sound;

import java.util.ArrayList;

public class Test extends SkillList {

    public Test() {
        super(Style.ONE_HANDED_SWORD＿TEST);
        add(test());
    }

    public Skill test() {
        SkillTiming skillTiming = new SkillTiming(SkillAction.LEFT_CLICK);
        skillTiming.addSpace(6);
        skillTiming.addSkillInput(SkillAction.LEFT_CLICK, 1, 1);
        skillTiming.addSpace(5);
        skillTiming.addSkillInput(SkillAction.LEFT_CLICK, 1, 1);
        return new Skill("剣技テスト", style, skillTiming) {
            @Override
            public void activate(Adventurer adventurer, ArrayList<SkillAction> actionList) {
                adventurer.getPlayer().playSound(adventurer.getPlayer().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            }
        };
    }
}