package rpgGame.Heroes;

import rpgGame.Items.Armor;
import rpgGame.Items.Weapon;

public class Mage extends Hero{


    public Mage(String name) {
        super(name);
        HeroAttribute MageAttributes = new HeroAttribute(1,1,8);
        setLevelAttributes(MageAttributes);
        addWeaponTypes(Weapon.WeaponType.Staff, Weapon.WeaponType.Wand);
        addArmorTypes(Armor.ArmorType.Mail, Armor.ArmorType.Plate);
    }

    public void levelUp() {
        super.levelUp(1, 1, 5);
    }

    public double damage(){
        return super.damage(totalAttributes().getIntelligence());
    }
    public void display(){
        super.display();
    }
//    List<Weapon.WeaponType> MageWeaponTypes = List.of(Weapon.WeaponType.Staffs, Weapon.WeaponType.Wands);
    /*@Override
    public void setValidWeaponTypes(List<Weapon.WeaponType> MageWeaponTypes) {

        super.setValidWeaponTypes(MageWeaponTypes);
    }

*/




}
