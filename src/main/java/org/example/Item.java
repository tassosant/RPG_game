package org.example;

public abstract class Item {
    private String name;
    private int requiredLevel;
    public enum Slot{
        Weapon,
        Head,
        Body,
        Legs
    }

    Slot slot;

    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;

    }

    public String getName() {
        return name;
    }



    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
