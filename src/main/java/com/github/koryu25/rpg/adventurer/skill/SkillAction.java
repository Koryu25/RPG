package com.github.koryu25.rpg.adventurer.skill;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

public enum SkillAction {
    NONE("-", "入力なし"),
    LEFT_CLICK("●", "左クリック"),
    RIGHT_CLICK("○", "右クリック"),
    SHIFT_LEFT_CLICK("●", "シフト左クリック"),
    SHIFT_RIGHT_CLICK("○", "シフト右クリック");

    private String symbol;
    private String label;

    SkillAction(String symbol, String label) {
        this.symbol = symbol;
        this.label = label;
    }

    public static SkillAction fromPlayerAction(Player player, Action action) {
        switch (action) {
            case LEFT_CLICK_AIR:
            case LEFT_CLICK_BLOCK:
                if (player.isSneaking()) return SHIFT_LEFT_CLICK;
                else return LEFT_CLICK;
            case RIGHT_CLICK_AIR:
            case RIGHT_CLICK_BLOCK:
                if (player.isSneaking()) return SHIFT_RIGHT_CLICK;
                else return RIGHT_CLICK;
        }
        return null;
    }

    // Getter
    public String getSymbol() {
        return symbol;
    }
    public String getLabel() {
        return label;
    }
}