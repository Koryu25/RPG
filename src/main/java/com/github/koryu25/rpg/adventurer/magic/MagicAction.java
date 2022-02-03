package com.github.koryu25.rpg.adventurer.magic;

public enum MagicAction {
    NONE("-"),
    Q("Q"),
    F("F"),
    SHIFT("S"),
    QSHIFT("QS"),
    FSHIFT("FS");

    private String label;

    MagicAction(String label) {
        this.label = label;
    }
}
