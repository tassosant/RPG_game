package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public abstract class Hero {
    private String name;
    private int level;
    private HeroAttribute levelAttributes;
    protected ArrayList<Weapon.WeaponType> validWeaponTypes;// = new ArrayList<Weapon.WeaponType>();// = List.of(Weapon.WeaponType.Axes, Weapon.WeaponType.Bows, Weapon.WeaponType.Daggers, Weapon.WeaponType.Hammers, Weapon.WeaponType.Staffs, Weapon.WeaponType.Swords, Weapon.WeaponType.Wands);
    protected ArrayList<Armor.ArmorType> validArmorTypes;// = new ArrayList<Armor.ArmorType>();
    protected HashMap<Item.Slot, Item> equipment;

    //; = new HashMap<Item.Slot, Item>();
    //Equipment: Hashmap <slot:key,Item:value>
    //ValidWeaponTypes : List
    //ValidArmorTypes : List

    //Constructor
    public Hero(String name, HeroAttribute levelAttributes) {
        this.name = name;
        this.level = 1;
        this.levelAttributes = levelAttributes;
        this.validWeaponTypes = new ArrayList<Weapon.WeaponType>();
        this.validArmorTypes = new ArrayList<Armor.ArmorType>();
        this.equipment = new HashMap<Item.Slot, Item>(4);
    }

    /*public Hero(String name,int level, HeroAttribute levelAttributes) {
        this.name = name;
        this.level = level;
        this.levelAttributes = levelAttributes;
    }*/
    //Getters and setters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    //One level up
    public void levelUp(int strength, int dexterity, int intelligence){
        this.levelAttributes.increaseStrength(strength);
        this.levelAttributes.increaseDexterity(dexterity);
        this.levelAttributes.increaseIntelligence(intelligence);
        setLevel(getLevel()+1);
    }
    //Display info
    public void display(){
        System.out.printf("Name=%s\tStrength=%d\tDexterity=%d\tIntelligence=%d\n",getName(),this.levelAttributes.getStrength(), this.levelAttributes.getDexterity(), this.levelAttributes.getIntelligence());
        System.out.printf("Weapon Type=%s\n",validWeaponTypes.get(0));
    }

    public int totalAttributes(){
        return this.levelAttributes.getStrength()+this.levelAttributes.getDexterity()+this.levelAttributes.getIntelligence();
    }


    public void equip(Weapon weapon) throws InvalidWeaponException, InvalidArmorException {
        if (!validWeaponTypes.contains(weapon.getWeaponType())) {
            throw new InvalidWeaponException("Invalid Weapon");
        } else {
            if (equipment.containsKey(Item.Slot.Weapon)) {
                equipment.remove(Item.Slot.Weapon);
            }
            equipment.put(Item.Slot.Weapon, weapon);
        }
    }
    // Add the valid weapon types
    public void addWeaponTypes(Weapon.WeaponType ... types){

        /* Similar to
        *
        * for(Weapon.WeaponType type : types){
        *   this.validWeaponTypes.add(type);
        * }
        *
        * */
        this.validWeaponTypes.addAll(Arrays.asList(types));
    }
    //Add the valid armor types
    public void addArmorTypes(Armor.ArmorType ... types){
        this.validArmorTypes.addAll(Arrays.asList(types));
    }


}
