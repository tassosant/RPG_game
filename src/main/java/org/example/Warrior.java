package org.example;

public class Warrior extends Hero{
    public Warrior(String name){
        super(name, new HeroAttribute(5,2,1));
        addWeaponTypes(Weapon.WeaponType.Axe, Weapon.WeaponType.Hammer, Weapon.WeaponType.Sword);
        addArmorTypes(Armor.ArmorType.Mail, Armor.ArmorType.Plate);
    }
    public void levelUp() {
        super.levelUp(3, 2, 1);
    }
}
