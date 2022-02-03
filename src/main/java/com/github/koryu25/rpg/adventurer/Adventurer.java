package com.github.koryu25.rpg.adventurer;

import com.github.koryu25.rpg.Main;
import com.github.koryu25.rpg.adventurer.skill.LearnedSkill;
import com.github.koryu25.rpg.adventurer.skill.Skill;
import com.github.koryu25.rpg.adventurer.skill.SkillAction;
import com.github.koryu25.rpg.adventurer.skill.skills.Style;
import com.github.koryu25.rpg.item.weapon.Weapon;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Adventurer {

    private Player player;

    private Rank rank;// ランク
    private int level;// レベル
    private Status status;// ステータスまとめ
    // バフ、デバフの状態
    // 選択されている武器
    private AdventurerSkill adventurerSkill;// スキル情報まとめ
    private AdventurerMagic adventurerMagic;// 魔法情報まとめ
    private Equipment equipment;// 装備

    public Adventurer(Player player) {
        // DBにデータが存在するか確認する
        // テスト用
        this(player, Rank.F, 0, new Status(), new LearnedSkill());
        addSkill(Main.getInstance().getSkillListManager().fromStyle(Style.ONE_HANDED_SWORD＿TEST).fromName("剣技テスト"), false);
    }
    public Adventurer(Player player, Rank rank, int level, Status status, LearnedSkill learnedSkill) {
        this.player = player;
        this.rank = rank;
        this.level = level;
        this.status = status;
        adventurerSkill = new AdventurerSkill(this, learnedSkill);
        equipment = new Equipment();
    }

    // in the battle
    public void onF() {
        adventurerSkill.onF();
    }
    public void inputToSkill(SkillAction skillAction) {
        adventurerSkill.inputToSkill(skillAction);
    }

    public void normalAttack() {

    }
    public void normalDefense() {

    }

    // LevelUp
    public void LevelUp() {

    }

    // calculated status
    // todo すべてにバフ、デバフの影響の追加
    public int getHitPoint() {
        return 20 + status.getHitPoint() + level * 2;
    }

    // Skill
    public void addSkill(Skill skill, boolean sendMessage) {
        if (sendMessage) {
            sendMessage("Skill: " + skill.getName() + "を習得しました！");
        }
        adventurerSkill.learnedSkill.add(skill);
    }

    // Utility
    public void sendMessage(String message) {
        player.sendMessage(message);
    }
    public void playSound(Sound sound) {
        playSound(sound, 1, 1);
    }
    public void playSound(Sound sound, float volume, float pitch) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

    // Getter
    public Player getPlayer() {
        return player;
    }
    public String getUUID() {
        return player.getUniqueId().toString();
    }
    public Rank getRank() {
        return rank;
    }
    public int getLevel() {
        return level;
    }
    public Status getStatus() {
        return status;
    }
    public AdventurerSkill getAdventurerSkill() {
        return adventurerSkill;
    }
    public Equipment getEquipment() {
        return equipment;
    }
}
