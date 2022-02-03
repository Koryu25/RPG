package com.github.koryu25.rpg.adventurer.skill;

import com.github.koryu25.rpg.adventurer.Adventurer;
import com.github.koryu25.rpg.adventurer.skill.skills.Style;

import java.util.ArrayList;

public abstract class Skill {

    private String name;// スキル名
    private Style style;// 流派
    private ArrayList<Skill> requiredSkillList = new ArrayList<>();// 必要スキル
    private SkillTiming skillTiming;// 入力内容

    public Skill(String name, Style style, SkillTiming skillTiming) {
        this.name = name;
        this.style = style;
        this.skillTiming = skillTiming;
    }

    // 入力結果がスキルと一致するか
    public SkillStatus match(ArrayList<SkillAction> input) {
        int first = 0;
        int last = 0;
        boolean inInput;
        boolean isCompletedInput = false;
        for (int i = 0; i < input.size(); i++) {
            // 完了値を初期化
            if (i == first) isCompletedInput = false;
            // input内だったらtrue
            if (i >= first && i <= last) inInput = true;
            else inInput = false;
            // inputがnoneのとき
            if (input.get(i) == SkillAction.NONE) {
                // skillのinput外ならば続行
                if (!inInput) continue;
                // skillのinput内ならば
                // inputが完了していたら続行
                if (isCompletedInput) continue;
                // inputが完了していないとき
                // 最後まで経過したら失敗
                if (i == last) return SkillStatus.FAILED;
                // 最後まで経過していなかったら続行
                continue;
            }
            // inputがnone以外のとき
            // skillのinput外ならば失敗
            if (!inInput) return SkillStatus.FAILED;
            // 入力内容が一致しなかったら失敗
            if (input.get(i) != skillTiming.getMomentList().get(i).action) return SkillStatus.FAILED;
            // inputの完了
            isCompletedInput = true;
            // firstとlastを更新
            first = skillTiming.getNextFirstIndex(i);
            last = skillTiming.getNextLastIndex(i);
            // 次がなかったらスキル完了
            if (first == 0) return SkillStatus.COMPLETED;
        }
        return SkillStatus.NOT_COMPLETED;
    }

    // スキル発動
    public abstract void activate(Adventurer adventurer, ArrayList<SkillAction> actionList);

    // 最後の入力精度を取得するメソッド
    public Accuracy getLastResult(ArrayList<SkillAction> input) {
        if (skillTiming.getMomentList().size() < input.size()) return Accuracy.NONE;
        return skillTiming.getMomentList().get(input.size() - 1).accuracy;
    }

    // 入力結果から入力精度を計算するメソッド
    public ArrayList<Accuracy> getResult(ArrayList<SkillAction> input) {
        ArrayList<Accuracy> accuracyList = new ArrayList<>();
        return accuracyList;
    }

    // Getter
    public String getName() {
        return name;
    }
    public Style getStyle() {
        return style;
    }
    public ArrayList<Skill> getRequiredSkillList() {
        return requiredSkillList;
    }
    public SkillTiming getSkillTiming() {
        return skillTiming;
    }
}