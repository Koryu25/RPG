package com.github.koryu25.rpg.adventurer;

public class Status {

    private int hitPoint;// 体力
    private int magicPoint;// 魔力
    private int youPower;// 妖力
    private int cursePower;// 呪力
    private int strength;// 筋力
    private int attack;// 攻撃力
    private int defense;// 防御力
    private int resist;// 抵抗力
    private int speed;// 素早さ
    private int evasion;// 回避力
    private int dexterity;// 器用さ
    private int intelligence;// 知力
    private int analysis;// 分析力
    private int Intuition;// 勘
    private int luck;// 運

    public Status() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public Status(
            int hitPoint,
            int magicPoint,
            int youPower,
            int cursePower,
            int strength,
            int attack,
            int defense,
            int resist,
            int speed,
            int evasion,
            int dexterity,
            int intelligence,
            int analysis,
            int intuition,
            int luck
    ) {
        this.hitPoint = hitPoint;
        this.magicPoint = magicPoint;
        this.youPower = youPower;
        this.cursePower = cursePower;
        this.strength = strength;
        this.attack = attack;
        this.defense = defense;
        this.resist = resist;
        this.speed = speed;
        this.evasion = evasion;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.analysis = analysis;
        this.Intuition = intuition;
        this.luck = luck;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getMagicPoint() {
        return magicPoint;
    }

    public void setMagicPoint(int magicPoint) {
        this.magicPoint = magicPoint;
    }

    public int getYouPower() {
        return youPower;
    }

    public void setYouPower(int youPower) {
        this.youPower = youPower;
    }

    public int getCursePower() {
        return cursePower;
    }

    public void setCursePower(int cursePower) {
        this.cursePower = cursePower;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getResist() {
        return resist;
    }

    public void setResist(int resist) {
        this.resist = resist;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAnalysis() {
        return analysis;
    }

    public void setAnalysis(int analysis) {
        this.analysis = analysis;
    }

    public int getIntuition() {
        return Intuition;
    }

    public void setIntuition(int intuition) {
        Intuition = intuition;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}