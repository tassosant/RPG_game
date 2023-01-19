package rpgGame.Heroes;

import rpgGame.Items.Armor;
import rpgGame.Items.Weapon;

public class Warrior extends Hero{
    public Warrior(String name){
        super(name);
        HeroAttribute WarriorAttributes = new HeroAttribute(5,2,1);
        setLevelAttributes(WarriorAttributes);
        addWeaponTypes(Weapon.WeaponType.Axe, Weapon.WeaponType.Hammer, Weapon.WeaponType.Sword);
        addArmorTypes(Armor.ArmorType.Mail, Armor.ArmorType.Plate);
    }
    @Override
    public void levelUp() {
        super.levelUp(3, 2, 1);
    }

    @Override
    public double damage() {
        return super.damage(totalAttributes().getStrength());
    }
}
