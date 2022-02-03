package com.github.koryu25.rpg.adventurer.skill;

import java.util.ArrayList;

public class SkillTiming {

    private ArrayList<SkillInput> inputList = new ArrayList<>();
    private ArrayList<SkillMoment> momentList = new ArrayList<>();

    public SkillTiming(SkillAction action) {
        SkillInput input = new SkillInput(getNextInputIndex(), action);
        input.add(Accuracy.CRITICAL);
        add(input);
    }

    public void addSkillTiming(SkillTiming timing) {
        timing.getInputList().forEach(input -> add(input));
    }

    public void addSkillInput(SkillAction action, int success, int critical) {
        SkillInput input = new SkillInput(getNextInputIndex(), action);
        for (int i = 0; i < success; i++) input.add(Accuracy.SUCCESS);
        for (int i = 0; i < critical; i++) input.add(Accuracy.CRITICAL);
        for (int i = 0; i < success; i++) input.add(Accuracy.SUCCESS);
        add(input);
    }

    public int getNextInputIndex() {
        return momentList.size();
    }

    public SkillInput getNextInput(int now) {
        for (SkillInput input : inputList) {
            if (input.getFirstIndex() > now) return input;
        }
        return null;
    }

    public int getNextFirstIndex(int now) {
        SkillInput input = getNextInput(now);
        if (input == null) return 0;
        return input.getFirstIndex();
    }
    public int getNextLastIndex(int now) {
        SkillInput input = getNextInput(now);
        if (input == null) return 0;
        return input.getLastIndex();
    }

    public void add(SkillInput input) {
        inputList.add(input);
        momentList.addAll(input);
    }
    public void addSpace(int space) {
        for (int i = 0; i < space; i++) {
            momentList.add(new SkillMoment(SkillAction.NONE, Accuracy.NONE));
        }
    }

    public String visualizeAccuracy() {
        String visualized = "";
        for (SkillMoment moment : momentList) {
            visualized = visualized + moment.accuracy.getSymbol();
        }
        return visualized;
    }

    // Getter
    public ArrayList<SkillInput> getInputList() {
        return inputList;
    }
    public ArrayList<SkillMoment> getMomentList() {
        return momentList;
    }
}