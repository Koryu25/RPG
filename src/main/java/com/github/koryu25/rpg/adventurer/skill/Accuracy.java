package com.github.koryu25.rpg.adventurer.skill;

public enum Accuracy {
    NONE("-", "入力不可"),
    SUCCESS("○", "成功"),
    CRITICAL("◎", "クリティカル");

    private String symbol;
    private String label;

    Accuracy(String symbol, String label) {
        this.symbol = symbol;
        this.label = label;
    }

    // Getter
    public String getSymbol() {
        return symbol;
    }
    public String getLabel() {
        return label;
    }
}
