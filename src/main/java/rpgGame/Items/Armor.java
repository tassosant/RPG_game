package rpgGame.Items;

import rpgGame.Heroes.HeroAttribute;

//subclass armor
public class Armor extends Item{
    //fields
    public enum ArmorType{
        Cloth,
        Leather,
        Mail,
        Plate
    }
    HeroAttribute ArmorAttribute;
    ArmorType armorType;
    //constructor
    public Armor(String name, int requiredLevel,ArmorType armorType, int str, int dex, int intel, Slot slot) {
        super(name, requiredLevel, slot);
        this.ArmorAttribute = new HeroAttribute(str, dex, intel);
        this.armorType = armorType;
    }
    //getters and setters
    @Override
    public ArmorType getArmorType() {
        return armorType;
    }
    @Override
    public HeroAttribute getArmorAttribute(){
        return ArmorAttribute;
    }

    @Override
    public int getWeaponDamage() {
        return 0;
    }

    @Override
    public Weapon.WeaponType getWeaponType() {
        return null;
    }
}
