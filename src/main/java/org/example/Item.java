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

    public Item(String name, int requiredLevel) {
        this.name = name;
        this.requiredLevel = requiredLevel;
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
