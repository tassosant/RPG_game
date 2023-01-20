package rpgGame.Heroes;

import rpgGame.Items.*;

import javax.management.ObjectInstance;
import java.util.*;
interface heroActions{
    void levelUp();
    double damage();
}
public abstract class Hero implements heroActions{
    //fields
    private String name;
    private int level;
    private HeroAttribute levelAttributes;
    protected HashMap<Item.Slot, Item> equipment;
    protected ArrayList<Weapon.WeaponType> validWeaponTypes;
    protected ArrayList<Armor.ArmorType> validArmorTypes;


    //Constructor
    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.validWeaponTypes = new ArrayList<Weapon.WeaponType>();
        this.validArmorTypes = new ArrayList<Armor.ArmorType>();
        this.equipment = new HashMap<Item.Slot, Item>(4);
        initEquipmentSlots(this.equipment);

    }


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

    protected void levelUp(int str, int dex, int intel){
        //
        this.levelAttributes.increaseStrength(str);
        this.levelAttributes.increaseDexterity(dex);
        this.levelAttributes.increaseIntelligence(intel);
        setLevel(getLevel()+1);
    }

    /*public void levelUp() {

    }*/

    //Display info
    public void display(){
        StringBuilder name = new StringBuilder(getName());
        StringBuilder Class = new StringBuilder();
        StringBuilder totalStrength = new StringBuilder(String.valueOf(totalAttributes().getStrength()));
        StringBuilder totalDexterity = new StringBuilder(String.valueOf(totalAttributes().getDexterity()));
        StringBuilder totalIntelligence = new StringBuilder(String.valueOf(totalAttributes().getIntelligence()));
        StringBuilder weapon = new StringBuilder(String.valueOf(this.equipment.get(Item.Slot.Weapon)==null?"Empty":this.equipment.get(Item.Slot.Weapon).getName()));
        StringBuilder head = new StringBuilder(String.valueOf(this.equipment.get(Item.Slot.Head)==null?"Empty":this.equipment.get(Item.Slot.Head).getName()));
        StringBuilder body = new StringBuilder(String.valueOf(this.equipment.get(Item.Slot.Body)==null?"Empty":this.equipment.get(Item.Slot.Body).getName()));
        StringBuilder legs = new StringBuilder(String.valueOf(this.equipment.get(Item.Slot.Legs)==null?"Empty":this.equipment.get(Item.Slot.Legs).getName()));
        StringBuilder dmg= new StringBuilder(String.valueOf(this.damage()));

        System.out.println("**************************************");
        System.out.println("Name="+name);
        System.out.println("Class="+this.getClass().getSimpleName());
        System.out.println("Equipment************");
        System.out.println("Weapon=" + weapon);
        System.out.println("Head=" + head);
        System.out.println("Body=" + body);
        System.out.println("Legs=" + legs);
        System.out.println("Total strength="+totalStrength);//totalAttributes().getStrength());
        System.out.println("Total Dexterity="+totalDexterity);//totalAttributes().getDexterity());
        System.out.println("Total intelligence="+totalIntelligence);//totalAttributes().getIntelligence());
        System.out.println("Total damage:"+dmg);
        System.out.println("**************************************");
        /*System.out.printf("Name=%s\tStrength=%d\tDexterity=%d\tIntelligence=%d\n",getName(),this.levelAttributes.getStrength(), this.levelAttributes.getDexterity(), this.levelAttributes.getIntelligence());
        System.out.printf("Weapon holding=%s\n",equipment.get(Item.Slot.Weapon)==null ? "No weapon" : equipment.get(Item.Slot.Weapon).getName());
        System.out.printf("Armor holding=%s\n",equipment.get(Item.Slot.Head)==null ? "No head armor" : equipment.get(Item.Slot.Head).getName());
        System.out.printf("Armor holding=%s\n",equipment.get(Item.Slot.Body)==null ? "No body armor" : equipment.get(Item.Slot.Body).getName());
        System.out.printf("Armor holding=%s\n",equipment.get(Item.Slot.Legs)==null ? "No leg armor" : equipment.get(Item.Slot.Legs).getName());*/
    }

    public HeroAttribute totalAttributes(){
        HeroAttribute TotalHeroAttributes = new HeroAttribute();

        TotalHeroAttributes.setStrength(getLevelAttributes().getStrength());
        TotalHeroAttributes.setDexterity(getLevelAttributes().getDexterity());
        TotalHeroAttributes.setIntelligence(getLevelAttributes().getIntelligence());
        //iterate through equipment ARMOR slots
        for(Map.Entry<Item.Slot, Item> set : this.equipment.entrySet()){
            if(set.getKey() != Item.Slot.Weapon && set.getValue()!=null) {

                TotalHeroAttributes.setStrength(TotalHeroAttributes.getStrength() + ((Armor) set.getValue()).getArmorAttribute().getStrength());
                TotalHeroAttributes.setDexterity(TotalHeroAttributes.getDexterity() + ((Armor) set.getValue()).getArmorAttribute().getDexterity());
                TotalHeroAttributes.setIntelligence(TotalHeroAttributes.getIntelligence() + ((Armor) set.getValue()).getArmorAttribute().getIntelligence());
            }

        }
        //if it is empty we must return the levelattributes

        return TotalHeroAttributes;
    }


    //Method for equipping the armor
    public void equipArmor(Item armor) throws InvalidArmorException{
        //if null value assigned as an argument then do nothing
        if(armor==null){
            return;
        }
        //if the type of armor is not the type of the hero can equip, throw a custom exception
        if (!validArmorTypes.contains(armor.getArmorType())) {
            throw new InvalidArmorException("Invalid Armor type");
        }else if(armor.getRequiredLevel()>getLevel()) {
            //if the required level of armor to equip is higher than the hero's level, throw a custom exception
            throw new InvalidArmorException("Not yet at level:"+armor.getRequiredLevel());
        }
        else{
            //equip the armor
            this.equipment.replace(armor.getSlot(), armor);
            System.out.println("Equipped:" + armor.getName());
        }
    }

    // Equip the weapon
    public void equipWeapon(Item weapon) throws InvalidWeaponException{
        //Same logic as equipArmor
        if(weapon==null){
            return;
        }
        if (!validWeaponTypes.contains(weapon.getWeaponType())) {
            throw new InvalidWeaponException("Invalid Weapon type");
        }else if(weapon.getRequiredLevel()>getLevel()) {
            throw new InvalidWeaponException("Not yet at level:"+weapon.getRequiredLevel());
        }
        else {
            this.equipment.replace(weapon.getSlot(), weapon);
            System.out.println("Equipped:" + weapon.getName());
        }
    }

    //Method which returns the damage that hero can make
    //Passing the special attribute of the hero subclass to this method
    protected double damage(int attribute){
        int dmg = 0 ;
        int weapondmg = 1;
        Weapon weapon = (Weapon) this.equipment.get(Item.Slot.Weapon);
        if(this.equipment.get(Item.Slot.Weapon)!=null){
            weapondmg = weapon.getWeaponDamage();
        }

        return weapondmg * (1+ (double) attribute/100);
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
        //add all the valid item types in an arraylist
        this.validWeaponTypes.addAll(Arrays.asList(types));
    }
    //Add the valid armor types
    //Same logic to addWeaponTypes method
    public void addArmorTypes(Armor.ArmorType ... types){

        this.validArmorTypes.addAll(Arrays.asList(types));
    }
    //Initialize the equipment slots with null values
    public void initEquipmentSlots(HashMap<Item.Slot, Item> equipment){
        this.equipment.put(Item.Slot.Weapon, null);
        this.equipment.put(Item.Slot.Head, null);
        this.equipment.put(Item.Slot.Body, null);
        this.equipment.put(Item.Slot.Legs, null);
    }
    //Helper method which makes the values of equipemnt slot to null
    // This is to test the attributes and damage of the hero after dropping the item
    public void dropWeapon(){
        this.equipment.replace(Item.Slot.Weapon, null);
        System.out.println("Weapon dropped");
    }

    //Helper method which makes the values of equipemnt slot to null
    // This is to test the attributes and damage of the hero after dropping the item
    public void dropArmor(Item item){
        if(item==null)
            return;
        if(Item.Slot.Weapon == item.getSlot()){
            System.out.println("Can't drop weapon, call the proper method (dropWeapon)");
            return;
        };
        String slot = String.valueOf(item.getSlot());
        this.equipment.replace(item.getSlot(),null);
        System.out.println("Armor in "+slot+" dropped");
    }
    /*private HeroAttribute getArmorPieceFromEquipment(Armor armor){
        HeroAttribute
    }*/
}
