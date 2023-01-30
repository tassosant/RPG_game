package rpgGame.Items;

import rpgGame.Heroes.HeroAttribute;

//Item class
interface armorAttributes{
    Armor.ArmorType getArmorType();
    HeroAttribute getArmorAttribute();

    void displayStats();

}
interface weaponAttributes {
    public Weapon.WeaponType getWeaponType();
    public int getWeaponDamage();

    void displayStats();
}
public abstract class Item implements armorAttributes, weaponAttributes {



    //fields
    private String name;
    private int requiredLevel;
    public enum Slot{
        Weapon,
        Head,
        Body,
        Legs
    }
    //declare slot
    Slot slot;
    //Constructor with all the fields
    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        //instantiate slot
        this.slot = slot;

    }
    //Constructor without the slot, I use this when I instantiate a weapon subclass in order to pass automatically the weapon slot to teh equipment
    public Item(String name, int requiredLevel) {
        this.name = name;
        this.requiredLevel = requiredLevel;
    }
    //Getters and setters
    public String getName() {
        return name;
    }

    public Slot getSlot() {
        return slot;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }
    //Not used yet. Maybe it is not necessary this setter
    /*public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }*/
    public void displayStats(){
        System.out.println("Name:"+getName());
        System.out.println("RequiredLevel:"+getRequiredLevel());
        System.out.println("Slot:"+getSlot());


    }
    /*public abstract Armor.ArmorType getArmorType();

    public abstract HeroAttribute getArmorAttribute();

    public abstract int getWeaponDamage();
    public abstract Weapon.WeaponType getWeaponType();*/
}
