package org.example;

public class Rogue extends Hero{
    public Rogue(String name){
        super(name, new HeroAttribute(2,6,1));
        addWeaponTypes(Weapon.WeaponType.Dagger, Weapon.WeaponType.Sword);
        addArmorTypes(Armor.ArmorType.Leather, Armor.ArmorType.Mail);
    }
    public void levelUp() {
        super.levelUp(1, 4, 1);
    }
}
