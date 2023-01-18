package rpgGame.Heroes;

import rpgGame.Items.*;

import javax.management.ObjectInstance;
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

    public HeroAttribute getLevelAttributes() {
        return levelAttributes;
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
        StringBuilder name = new StringBuilder(getName());
        StringBuilder Class = new StringBuilder();
        StringBuilder totalStrength = new StringBuilder(totalAttributes().getStrength());
        StringBuilder totalDexterity = new StringBuilder(totalAttributes().getDexterity());
        StringBuilder totalIntelligence = new StringBuilder(totalAttributes().getIntelligence());
        System.out.println("Name="+name);
        System.out.println("Class="+name);
        System.out.println("Total strength="+totalAttributes().getStrength());
        System.out.println("Total Dexterity="+totalAttributes().getDexterity());
        System.out.println("Total intelligence="+totalAttributes().getIntelligence());

        /*System.out.printf("Name=%s\tStrength=%d\tDexterity=%d\tIntelligence=%d\n",getName(),this.levelAttributes.getStrength(), this.levelAttributes.getDexterity(), this.levelAttributes.getIntelligence());
        System.out.printf("Weapon holding=%s\n",equipment.get(Item.Slot.Weapon)==null ? "No weapon" : equipment.get(Item.Slot.Weapon).getName());
        System.out.printf("Armor holding=%s\n",equipment.get(Item.Slot.Head)==null ? "No head armor" : equipment.get(Item.Slot.Head).getName());
        System.out.printf("Armor holding=%s\n",equipment.get(Item.Slot.Body)==null ? "No body armor" : equipment.get(Item.Slot.Body).getName());
        System.out.printf("Armor holding=%s\n",equipment.get(Item.Slot.Legs)==null ? "No leg armor" : equipment.get(Item.Slot.Legs).getName());*/
    }

    public HeroAttribute totalAttributes(){
        HeroAttribute TotalHeroAttributes = new HeroAttribute();
        boolean isEmpty = true;
        //iterate through equipment ARMOR slots
        for(Map.Entry<Item.Slot, Item> set : this.equipment.entrySet()){
            if(set.getKey() != Item.Slot.Weapon && set.getValue()!=null) {
                isEmpty = false;
                TotalHeroAttributes.setStrength(getLevelAttributes().getStrength()+TotalHeroAttributes.getStrength() + ((Armor) set.getValue()).getArmorAttribute().getStrength());
                TotalHeroAttributes.setDexterity(levelAttributes.getDexterity()+TotalHeroAttributes.getDexterity() + ((Armor) set.getValue()).getArmorAttribute().getDexterity());
                TotalHeroAttributes.setIntelligence(this.levelAttributes.getIntelligence()+TotalHeroAttributes.getIntelligence() + ((Armor) set.getValue()).getArmorAttribute().getIntelligence());
            }

        }
        //if it is empty we must return the levelattributes
        if(isEmpty){
            TotalHeroAttributes = getLevelAttributes();
        }
        return TotalHeroAttributes;
    }



    public void equipArmor(Armor armor) throws InvalidArmorException{
        if (!validArmorTypes.contains(armor.getArmorType())) {
            throw new InvalidArmorException("Invalid Armor type");
        }else if(armor.getRequiredLevel()>getLevel()) {
            throw new InvalidArmorException("Not yet at level:"+armor.getRequiredLevel());
        }
        else{
            this.equipment.replace(armor.getSlot(), armor);
            System.out.println("Equipped:" + armor.getName());
        }
    }

    public void equipWeapon(Weapon weapon) throws InvalidWeaponException{
        if (!validWeaponTypes.contains(weapon.getWeaponType())) {
            throw new InvalidWeaponException("Invalid Armor type");
        }else if(weapon.getRequiredLevel()>getLevel()) {
            throw new InvalidWeaponException("Not yet at level:"+weapon.getRequiredLevel());
        }
        else {
            this.equipment.replace(weapon.getSlot(), weapon);
            System.out.println("Equipped:" + weapon.getName());
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
    public double damage(int attribute){
        int dmg = 0 ;
        int weapondmg = 1;
            Weapon weapon = (Weapon) this.equipment.get(Item.Slot.Weapon);
        if(this.equipment.get(Item.Slot.Weapon)!=null){
            weapondmg = weapon.getWeaponDamage();
        }
        return weapondmg * (1+ attribute/100);
    }
    /*private HeroAttribute getArmorPieceFromEquipment(Armor armor){
        HeroAttribute
    }*/
}
