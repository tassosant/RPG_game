package org.example;

public class Armor extends Item{
    public enum ArmorType{
        Cloth,
        Leather,
        Mail,
        Plate
    }
    HeroAttribute ArmorAttribute;
    ArmorType armorType;
    public Armor(String name, int requiredLevel,ArmorType armorType, HeroAttribute armorAttribute, Slot slot) {
        super(name, requiredLevel, slot);
        this.ArmorAttribute = armorAttribute;
        this.armorType = armorType;
    }
}
