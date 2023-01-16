package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mage extends Hero{


    public Mage(String name) {
        super(name, new HeroAttribute(1,1,8));
        addWeaponTypes(Weapon.WeaponType.Staff, Weapon.WeaponType.Wand);
        addArmorTypes(Armor.ArmorType.Mail, Armor.ArmorType.Plate);
    }

    public void levelUp() {
        super.levelUp(1, 1, 5);
    }
//    List<Weapon.WeaponType> MageWeaponTypes = List.of(Weapon.WeaponType.Staffs, Weapon.WeaponType.Wands);
    /*@Override
    public void setValidWeaponTypes(List<Weapon.WeaponType> MageWeaponTypes) {

        super.setValidWeaponTypes(MageWeaponTypes);
    }

*/




}
