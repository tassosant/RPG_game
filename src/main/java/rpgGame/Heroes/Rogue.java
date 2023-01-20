package rpgGame.Heroes;

import rpgGame.Items.Armor;
import rpgGame.Items.Weapon;

public class Rogue extends Hero{
    public Rogue(String name){
        super(name);
        HeroAttribute RogueAttributes =  new HeroAttribute(2,6,1);
        setLevelAttributes(RogueAttributes);
        addWeaponTypes(Weapon.WeaponType.Dagger, Weapon.WeaponType.Sword);
        addArmorTypes(Armor.ArmorType.Leather, Armor.ArmorType.Mail);
    }
    @Override
    public void levelUp() {
        super.levelUp(1, 4, 1);
    }


    @Override
    public double damage(){
        return super.damage(totalAttributes().getDexterity());
    }
}
