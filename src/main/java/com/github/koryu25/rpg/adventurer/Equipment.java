package com.github.koryu25.rpg.adventurer;

import com.github.koryu25.rpg.item.armor.Armor;
import com.github.koryu25.rpg.item.weapon.Weapon;

public class Equipment {

    private Weapon weapon1;
    private int weapon1Slot;
    private Weapon weapon2;
    private int weapon2Slot;
    private int hand;

    private Armor head;
    private Armor chest;
    private Armor leggings;
    private Armor boots;

    public Equipment(Weapon weapon1, int weapon1Slot, Weapon weapon2, int weapon2Slot, int hand, Armor head, Armor chest, Armor leggings, Armor boots) {
        this.weapon1 = weapon1;
        this.weapon1Slot = weapon1Slot;
        this.weapon2 = weapon2;
        this.weapon2Slot = weapon2Slot;
        this.hand = hand;
        this.head = head;
        this.chest = chest;
        this.leggings = leggings;
        this.boots = boots;
    }
    public Equipment() {
        this.weapon1 = null;
        this.weapon1Slot = 9;
        this.weapon2 = null;
        this.weapon2Slot = 9;
        this.hand = 9;
        this.head = null;
        this.chest = null;
        this.leggings = null;
        this.boots = null;
    }

    // Getter, Setter
    public Weapon getWeapon1() {
        return weapon1;
    }

    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    public int getWeapon1Slot() {
        return weapon1Slot;
    }

    public void setWeapon1Slot(int weapon1Slot) {
        this.weapon1Slot = weapon1Slot;
    }

    public Weapon getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }

    public int getWeapon2Slot() {
        return weapon2Slot;
    }

    public void setWeapon2Slot(int weapon2Slot) {
        this.weapon2Slot = weapon2Slot;
    }

    public int getHand() {
        return hand;
    }

    public void setHand(int hand) {
        this.hand = hand;
    }

    public Armor getHead() {
        return head;
    }

    public void setHead(Armor head) {
        this.head = head;
    }

    public Armor getChest() {
        return chest;
    }

    public void setChest(Armor chest) {
        this.chest = chest;
    }

    public Armor getLeggings() {
        return leggings;
    }

    public void setLeggings(Armor leggings) {
        this.leggings = leggings;
    }

    public Armor getBoots() {
        return boots;
    }

    public void setBoots(Armor boots) {
        this.boots = boots;
    }
}
