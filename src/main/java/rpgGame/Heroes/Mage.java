package rpgGame.Heroes;

import rpgGame.Items.Armor;
import rpgGame.Items.Weapon;
//subclass of hero
public class Mage extends Hero{

    //constructor, passing one argument only
    //
    public Mage(String name) {
        super(name);
        //after the super constructor I instantiate this subclass's hero attribute with the given arguments of the task
        HeroAttribute MageAttributes = new HeroAttribute(1,1,8);
        //I pass the MageAttributes to levelattributes in superclass Hero because it is private
        setLevelAttributes(MageAttributes);
        //In order not writing lots of lines I've created methods in Hero's class to pass as arguments the valid Weapon.WeaponType and Armor.ArmorType
        //In this case Mage can carry Wands, staffs, mails and plates
        addWeaponTypes(Weapon.WeaponType.Staff, Weapon.WeaponType.Wand);
        addArmorTypes(Armor.ArmorType.Cloth);
    }
    //call the super function levelUp and pass the Mage attributes
    @Override
    public void levelUp() {
        super.levelUp(1, 1, 5);
    }
    //call the super class's function and pass the Hero's special attribute
    @Override
    public double damage(){
        return super.damage(totalAttributes().getIntelligence());
    }

//    List<Weapon.WeaponType> MageWeaponTypes = List.of(Weapon.WeaponType.Staffs, Weapon.WeaponType.Wands);
    /*@Override
    public void setValidWeaponTypes(List<Weapon.WeaponType> MageWeaponTypes) {

        super.setValidWeaponTypes(MageWeaponTypes);
    }

*/




}
