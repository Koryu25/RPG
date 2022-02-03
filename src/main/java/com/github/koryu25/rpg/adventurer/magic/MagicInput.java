package com.github.koryu25.rpg.adventurer.magic;

import java.util.ArrayList;

public class MagicInput {

    private ArrayList<MagicAction> actionList = new ArrayList<>();

    public void add(MagicAction action) {
        actionList.add(action);
    }

    public MagicAction getAction(int index) {
        return actionList.get(index);
    }

    public int getSize() {
        return actionList.size();
    }
}
