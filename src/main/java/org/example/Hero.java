package org.example;

import java.util.*;

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
    public Hero(String name) {
        this.name = name;
        this.level = 1;

        this.validWeaponTypes = new ArrayList<Weapon.WeaponType>();
        this.validArmorTypes = new ArrayList<Armor.ArmorType>();
        this.equipment = new HashMap<Item.Slot, Item>(4);
        initEquipmentSlots(this.equipment);

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

    public void setLevelAttributes(HeroAttribute levelAttributes) {
        this.levelAttributes = levelAttributes;
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
        System.out.printf("Weapon holding=%s\n",equipment.get(Item.Slot.Weapon)==null ? "No weapon" : equipment.get(Item.Slot.Weapon).getName());
        System.out.printf("Armor holding=%s\n",equipment.get(Item.Slot.Head)==null ? "No head armor" : equipment.get(Item.Slot.Head).getName());
        System.out.printf("Armor holding=%s\n",equipment.get(Item.Slot.Body)==null ? "No body armor" : equipment.get(Item.Slot.Body).getName());
        System.out.printf("Armor holding=%s\n",equipment.get(Item.Slot.Legs)==null ? "No leg armor" : equipment.get(Item.Slot.Legs).getName());
    }

    public int totalAttributes(){
        return this.levelAttributes.getStrength()+this.levelAttributes.getDexterity()+this.levelAttributes.getIntelligence();
    }


    public void equip(Weapon weapon, Armor armor) throws InvalidWeaponException, InvalidArmorException {
        if(weapon!=null) {
            if (!validWeaponTypes.contains(weapon.getWeaponType())) {
                throw new InvalidWeaponException("Invalid Weapon type");
            } else {
                equipment.replace(Item.Slot.Weapon, weapon);
                System.out.println("Equipped:" + weapon.getName());
            }
        }
        if(armor!=null){
            if (!validArmorTypes.contains(armor.getArmorType())) {
                throw new InvalidArmorException("Invalid Armor type");
            } else {
                equipment.replace(armor.getSlot(), armor);
                System.out.println("Equipped:" + armor.getName());
            }
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

    public void initEquipmentSlots(HashMap<Item.Slot, Item> equipment){
        this.equipment.put(Item.Slot.Weapon, null);
        this.equipment.put(Item.Slot.Head, null);
        this.equipment.put(Item.Slot.Body, null);
        this.equipment.put(Item.Slot.Legs, null);
    }
}
