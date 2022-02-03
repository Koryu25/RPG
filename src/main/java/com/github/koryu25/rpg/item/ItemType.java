package com.github.koryu25.rpg.item;

public enum ItemType {
    WEAPON("武器"),
    MAGIC_WEAPON("魔法武器"),
    ARMOR("防具"),
    TOOL("道具"),
    CONSUMPTION("消費"),
    MATERIAL("素材"),
    OTHER("その他");

    private String label;

    ItemType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
