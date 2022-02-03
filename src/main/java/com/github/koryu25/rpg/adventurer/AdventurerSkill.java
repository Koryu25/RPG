package com.github.koryu25.rpg.adventurer;

import com.github.koryu25.rpg.Main;
import com.github.koryu25.rpg.adventurer.skill.*;
import com.github.koryu25.rpg.adventurer.skill.skills.Style;
import com.github.koryu25.rpg.item.weapon.WeaponType;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class AdventurerSkill {

    private final Adventurer adventurer;

    private boolean f = false;// スキル発動宣言
    public ArrayList<SkillAction> actionList = new ArrayList<>();// 入力された情報(スキル内容)
    private boolean input = true;// スキルに入力できるか
    public LearnedSkill learnedSkill;// 習得済みのスキルのリスト
    private ArrayList<Skill> activatingSkill = new ArrayList<>();// 入力結果から実行可能なスキルのリスト
    private boolean styled = false;

    public AdventurerSkill(Adventurer adventurer, LearnedSkill learnedSkill) {
        this.adventurer = adventurer;
        this.learnedSkill = learnedSkill;
    }

    public void onF() {
        if (f) {
            adventurer.getPlayer().sendMessage("スキル宣言解除");
            f = false;
            actionList.clear();
            styled = false;
        } else {
            adventurer.getPlayer().sendMessage("スキル発動宣言");
            f = true;
            input = true;
        }
    }

    public void inputToSkill(SkillAction action) {
        // スキル宣言確認
        if (!f) return;
        // 一回目か二回目以降か
        if (actionList.size() == 0) {
            // 一回目の入力
            // スキルのアクティベート
            // タイマー起動
            new BukkitRunnable() {
                private int count = 0;
                @Override
                public void run() {
                    // スキルがキャンセルされたらタイマーを止める
                    if (!f) cancel();
                    // 時間経過で強制終了(20s)
                    if (count == 400) {
                        onF();
                        cancel();
                    }
                    // 何も入力してないときにNONEを入力
                    if (input) inputToSkill(SkillAction.NONE);
                    count++;
                }
            }.runTaskTimer(Main.getInstance(), 0, 1);
        } else {
            // 二回目以降の入力
            // actionがNONEでなければ
            if (action != SkillAction.NONE) {
                // NONEを入力不可にする
                input = false;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        input = true;
                    }
                }.runTaskLater(Main.getInstance(), 1);
            }
        }
        // 入力
        actionList.add(action);
        // スキル状態確認
        if (actionList.size() == 1) {
            adventurer.getPlayer().playSound(adventurer.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            return;
        }
        // アイテムから武器と流派(スキルツリー)を取得
        Style style;
        // 流派(スキルツリー)が決まっていなかったら実行
        if (!styled) {
            WeaponType weaponType;
            // アイテム(武器)から流派を取得
            style = Style.ONE_HANDED_SWORD＿TEST;
            // 流派(スキルツリー)からスキルを検索
            activatingSkill = learnedSkill.searchStyle(style);
            styled = true;
        }
        if (activatingSkill.size() == 0) onF();
        // スキルを照合、決定
        Skill activated = null;// 発動が決定されたスキル
        // 一つ一つスキルを確認し、発動するスキルを選定する
        for (int i = 0; i < activatingSkill.size(); i++) {
            Skill skill = activatingSkill.get(i);
            // スキルが一致するか
            SkillStatus status = skill.match(actionList);
            // 失敗
            if (status == SkillStatus.FAILED) {
                adventurer.getPlayer().sendMessage("skill:" + skill.getName() + " is failed");
                activatingSkill.remove(i);
                i--;
                if (activatingSkill.size() == 0) {
                    onF();
                    break;
                }
                continue;
            }
            // 入力途中
            else if (status == SkillStatus.NOT_COMPLETED) {
                // 入力があれば
                if (action == SkillAction.NONE) continue;
                // 効果音とログ
                Sound sound = null;
                String msg = null;
                Accuracy accuracy = skill.getLastResult(actionList);
                if (accuracy == Accuracy.NONE) {
                    sound = Sound.ENTITY_IRON_GOLEM_DAMAGE;
                    msg = "Accuracy.NONE";
                } else if (accuracy == Accuracy.SUCCESS) {
                    sound = Sound.ENTITY_PLAYER_ATTACK_KNOCKBACK;
                    msg = "Accuracy.SUCCESS";
                } else if (accuracy == Accuracy.CRITICAL) {
                    sound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
                    msg = "Accuracy.CRITICAL";
                }
                adventurer.getPlayer().sendMessage(msg);
                adventurer.getPlayer().playSound(adventurer.getPlayer().getLocation(), sound, 1, 1);
                continue;
            }
            // 入力完了
            else if (status == SkillStatus.COMPLETED) {
                activated = skill;
                activatingSkill.remove(i);
                i--;
                if (activatingSkill.size() == 0) {
                    onF();
                    break;
                }
            }
        }
        if (activated == null) return;
        adventurer.getPlayer().sendMessage("skill:" + activated.getName() + "発動");
        activated.activate(adventurer, actionList);
    }

    // Getter
    public boolean getF() {
        return f;
    }
}
