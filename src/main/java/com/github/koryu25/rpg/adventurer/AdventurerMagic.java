package com.github.koryu25.rpg.adventurer;

import com.github.koryu25.rpg.adventurer.magic.LearnedMagic;
import com.github.koryu25.rpg.adventurer.magic.Magic;
import com.github.koryu25.rpg.adventurer.magic.MagicInput;

import java.util.ArrayList;

public class AdventurerMagic {

    private final Adventurer adventurer;

    public ArrayList<MagicInput> inputList = new ArrayList<>();// 入力された情報
    public LearnedMagic learnedMagic;// 習得済みの魔法のリスト
    private ArrayList<Magic> activatingMagic = new ArrayList<>();// 入力結果から予想される魔法のリスト
    // 流派、属性、系統を検索したかどうか

    public AdventurerMagic(Adventurer adventurer, LearnedMagic learnedMagic) {
        this.adventurer = adventurer;
        this.learnedMagic = learnedMagic;
    }

    // 左クリックで入力情報の初期化と通常攻撃

    // 右クリックで魔法発動

    // 魔法へ入力
}
