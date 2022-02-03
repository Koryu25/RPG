package com.github.koryu25.rpg.adventurer.magic;

import com.github.koryu25.rpg.adventurer.Adventurer;

import java.util.ArrayList;

public abstract class Magic {

    private String name;// 名前
    // 流派、属性、系統
    private ArrayList<Magic> requiredMagic = new ArrayList<>();
    private MagicInput magicInput;// 入力内容

    public Magic(String name, MagicInput magicInput) {
        this.name = name;
        this.magicInput = magicInput;
    }

    // 入力結果が魔法と一致するか
    public boolean match(MagicInput magicInput) {
        return true;
    }

    // 魔法発動
    public abstract void activate(Adventurer adventurer);

    // Getter
    public String getName() {
        return name;
    }
    public ArrayList<Magic> getRequiredMagic() {
        return requiredMagic;
    }
    public MagicInput getMagicInput() {
        return magicInput;
    }
}
