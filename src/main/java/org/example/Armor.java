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
    public Armor(String name, int requiredLevel, HeroAttribute armorAttribute, ArmorType armorType) {
        super(name, requiredLevel);
        this.ArmorAttribute = armorAttribute;
        this.armorType = armorType;
    }
}
