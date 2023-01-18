package rpgGame.Items;

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

    public Item(String name, int requiredLevel) {
        this.name = name;
        this.requiredLevel = requiredLevel;
    }

    public String getName() {
        return name;
    }

    public Slot getSlot() {
        return slot;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
