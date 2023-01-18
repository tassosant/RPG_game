package rpgGame;

import java.util.Random;
import rpgGame.Heroes.HeroAttribute;
import rpgGame.Heroes.Mage;
import rpgGame.Heroes.Ranger;
import rpgGame.Items.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {

        Mage tasos = new Mage("soulis");
        /*tasos.display();
        tasos.levelUp();
        tasos.display();*/
        Weapon bow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        Armor leatherBody = new Armor("Common leather Body", 1, Armor.ArmorType.Leather,1,10,1, Item.Slot.Body);
        Weapon bow2 = new Weapon("Legendary Bow2", 1,10, Weapon.WeaponType.Bow);
        Ranger tasosRanger = new Ranger("tasoss");
        Ranger tasosRanger2 = new Ranger("tasos2");

        //tasos.display();

        /*Weapon bow2 = new Weapon("Legendary Bow2", 1,10, Weapon.WeaponType.Bow);
        tasosRanger.equipWeapon(bow2);
        tasosRanger.display();
        Weapon sword = new Weapon("common sword", 1, 2, Weapon.WeaponType.Sword);

        tasosRanger.equipArmor(leatherBody);
        tasosRanger.levelUp();
        tasosRanger.display();*/
        ArrayList<Armor> armorItems = new ArrayList<Armor>();
        ArrayList<Weapon> weaponItems = new ArrayList<Weapon>();
    }

    public static ArrayList<Armor> createArmorItems(ArrayList<Armor> armorItem){

        return armorItem;
    }

    public static void addRandomItem(ArrayList<Item> armorItem){
        Random random = new Random();
        int upperLegendaryLimit = 10;
        int upperCommonLimit = 2;
        int upperUncommonLimit = 6;
        int upperRareLimit = 8;
//        int lowerLimit = random.nextInt(1);
        int strength = random.nextInt();
        int dexterity = 0;
        int intelligence = 0;
        HeroAttribute randomAttributes = new HeroAttribute(strength,dexterity,intelligence);
        String name = nameGenerator(randomAttributes);

    }

    public static int validateAttribute(int attribute, int lowerLimit){
        if(attribute==lowerLimit){
            return attribute+1;
        }
        return attribute;
    }

    public static String nameGenerator(HeroAttribute attributes){
        String name = "";
        if(attributes.getStrength()>8||attributes.getDexterity()>8||attributes.getIntelligence()>8){
            name = "legendary";
        }
        else if (attributes.getStrength()>6||attributes.getDexterity()>6||attributes.getIntelligence()>6){
            name = "rare";
        }
        else if(attributes.getStrength()>2||attributes.getDexterity()>2||attributes.getIntelligence()>2){
            name = "uncommon";
        }
        else{
            name = "common";
        }
        return name;
    }


}