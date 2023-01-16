package org.example;

public class Ranger extends Hero{
    public Ranger(String name) {
        super(name, new HeroAttribute(1,7,1));
        addWeaponTypes(Weapon.WeaponType.Bow);
        addArmorTypes(Armor.ArmorType.Leather, Armor.ArmorType.Cloth);
    }

    public void levelUp() {
        super.levelUp(1, 5, 1);
    }


}
