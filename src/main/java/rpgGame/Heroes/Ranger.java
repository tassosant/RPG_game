package rpgGame.Heroes;

import rpgGame.Items.Armor;
import rpgGame.Items.Weapon;

public class Ranger extends Hero{
    public Ranger(String name) {
        super(name);
        HeroAttribute RangerAttributes =  new HeroAttribute(1,7,1);
        setLevelAttributes(RangerAttributes);
        addWeaponTypes(Weapon.WeaponType.Bow);
        addArmorTypes(Armor.ArmorType.Leather, Armor.ArmorType.Cloth);
    }

    public void levelUp() {
        super.levelUp(1, 5, 1);
    }




}
