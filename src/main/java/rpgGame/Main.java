package rpgGame;

import rpgGame.Heroes.*;
import rpgGame.Items.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {
       /* Hero tasos = new Ranger("tasos");
        Item commonLeatherBody = new Armor("Common leather Body", 1, Armor.ArmorType.Leather, 1, 2, 4, Item.Slot.Body);
        Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        tasos.equipArmor(commonLeatherBody);
        tasos.equipWeapon(commonBow);
        tasos.display();*/
        UI();
        //Weapon.WeaponType[] types = Weapon.WeaponType.values();
        //System.out.println(types[0]);





    }

    public static void UI() throws InvalidWeaponException, InvalidArmorException {

        int HeroChoice = 1;
        String heroName;
        Hero hero;
        //menu for choosing a hero
        String[] menuHero = {"1. Mage","2. Ranger","3. Rogue","4. Warrior","5. Exit"};

        //menuHero is an array, so indexes begin from zero.
        // I make the user to choose always index+1 because in menus it is rare the zero option
        //The last index is menuHero.length-1, so for the user the last option is menuHero.length
        while (HeroChoice!=menuHero.length) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose a Hero:");
            menu(menuHero);
            HeroChoice = scanner.nextInt();
            scanner.nextLine();

            if(HeroChoice<=4 && HeroChoice>=1){
                System.out.println("Please select a name for your hero");
                heroName = scanner.nextLine();
                hero = createSelectedHero(HeroChoice,heroName, menuHero);

                if(hero!=null){
                    heroActionsUI(hero);

                }
                //if choice is not in the length of menuHero array and not between 1 and 4
            }else if (HeroChoice>=menuHero.length || HeroChoice<0){
                System.out.println("Please choose a valid choice");
                //go to the start of the loop
                continue;
            }else{
                System.out.println("Exit in progress...");
                //exit the loop
                break;
            }
        }
        System.out.println("Exited");


    }
    //method for choosing to level up, equip item,
    public static void heroActionsUI(Hero hero) throws InvalidWeaponException, InvalidArmorException {
        String[] heroActions = {"1. Level up", "2. Equip weapon", "3. Equip armor", "4. Display status", "5. Exit"};
        Scanner scanner = new Scanner(System.in);
        Item weapon;
        Item armor;
        int actionChoice = 0;
        menu(heroActions);
        actionChoice = scanner.nextInt();

        while (actionChoice!=heroActions.length){
            //if the option is in main menu except for the last option which is exit
            if(actionChoice>=1 && actionChoice<=heroActions.length-1){
                if(heroActions[actionChoice-1].contains("Level")){
                    hero.levelUp();

                }else if(heroActions[actionChoice-1].contains("Equip weapon")){
                    try {
                        weapon = createWeaponUI();

                        hero.equipWeapon(weapon);
                    }catch (InvalidWeaponException e){
                        System.out.println("Cannot equip this weapon");

                    }

                }else if(heroActions[actionChoice-1].contains("Equip armor")){
                    try {
                        armor = createArmorUI();

                        hero.equipArmor(armor);
                    }catch (InvalidArmorException e){
                        System.out.println("Cannot equip this armor item");
                    }

                }else {
                    //display the stats
                    hero.display();

                }
            //if the option is exit
            }else if(actionChoice==heroActions.length){
                break;
            //not valid option(e.g. -1)
            }else {
                System.out.println("Please choose a valid choice");
            }
            menu(heroActions);
            actionChoice = scanner.nextInt();
        }
    }
    public static void menu(Armor.ArmorType[] types){
        System.out.printf("Please select from 1 to %d:\n",types.length);
        int index = 0;
        for( Armor.ArmorType type:types){
            index++;
            System.out.printf("%d\t%s\n",index,type);
        }
    }

    public static void menu(Weapon.WeaponType[] types){
        System.out.printf("Please select from 1 to %d:\n",types.length);
        int index = 0;
        for (Weapon.WeaponType type:types){
            index++;
            System.out.printf("%d\t%s\n",index,type);
        }
    }

    public static void menu(Item.Slot[] slots){
        System.out.printf("Please select from 1 to %d:\n",slots.length-1);
        int index = 0;
        for (Item.Slot slot:slots){
            index++;
            if(slot.equals(Item.Slot.Weapon)){
                index--;
            }else
                System.out.printf("%d\t%s\n",index,slot);
        }
    }
    public static void menu(String[] menuOptions){
        System.out.printf("Please select from 1 to %d:\n",menuOptions.length);
        for(int index = 0; index < menuOptions.length; index++){
            System.out.println(menuOptions[index]);
        }
    }

    public static Hero createSelectedHero(int choice, String name, String[] menu){
        Hero hero;
        // I chose this statement method(contains) because if the subclasses expand (e.g. necromancer subclass) we will
        // need to add only one if-statement.
        if(menu[choice-1].contains("Mage")){

            hero = new Mage(name);
        }else if(menu[choice-1].contains("Ranger")){
            hero = new Ranger(name);
        } else if(menu[choice-1].contains("Rogue")) {
            hero = new Rogue(name);
        }else {
            hero = new Warrior(name);
        }
        return hero;
    }

    public static Item instantiateWeapon(String weaponName, int weaponDamage, int requiredLevel, Weapon.WeaponType weaponType){
        Item weapon = new Weapon(weaponName,requiredLevel, weaponDamage,weaponType);
        return weapon;
    }

    public static Item instantiateArmor(String armorName, int requiredLevel, Armor.ArmorType armorType, String[] attributesInput, Item.Slot slot){
        int[] attributes = new int[attributesInput.length];

        for(int index = 0; index < attributes.length; index++){

            attributes[index] = Integer.parseInt(attributesInput[index]);
        }
        int str = attributes[0];
        int dex = attributes[1];
        int intel = attributes[2];
        Item armor = new Armor(armorName,requiredLevel, armorType,str,dex,intel,slot);
        return armor;
    }

    public static boolean validateArmorType(int choice){
        boolean isValid = true;
        Armor.ArmorType[] types = Armor.ArmorType.values();
        if(choice>types.length || choice<=0){
            isValid = false;
            System.out.println("Please select valid armor type");
        }
        return isValid;
    }

    public static boolean validateWeaponType(int choice){
        boolean isValid = true;
        Weapon.WeaponType[] types = Weapon.WeaponType.values();
        if(choice>types.length || choice<=0){
            isValid = false;
            System.out.println("Please select valid weapon type");
        }
        return isValid;
    }

    public static boolean validateSlot(int choice){
        boolean isValid = true;
        Item.Slot[] slots = Item.Slot.values();
        //we don't want to choose the weapon slot
        if(choice>slots.length-1 || choice<=0){
            isValid = false;
            System.out.println("Please select valid slot");
        }
        return isValid;
    }

    public static boolean validateAttributes(String[] attributesInput){
        boolean isValid = true;
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        boolean matchFound;
        for (String attribute: attributesInput){
            matcher = pattern.matcher(attribute);
            matchFound = matcher.find();
            if(!matchFound){
                isValid = false;
            }
        }
        return isValid;
    }

    public static Item createWeaponUI(){

        Weapon.WeaponType[] weaponTypes = Weapon.WeaponType.values();
        int weaponTypeChoice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the weapon item you want to equip?");
        String weaponName = scanner.nextLine();
        System.out.println("What is the required level of the weapon item?");
        int requiredLevel = scanner.nextInt();
        while (requiredLevel<=0){
            System.out.println("Please write a valid level");
            requiredLevel = scanner.nextInt();
        }

        System.out.println("What is the weapon's damage?");
        int weaponDmg = scanner.nextInt();
        while (weaponDmg<=0){
            System.out.println("Please write a valid number");
            weaponDmg = scanner.nextInt();
        }
        scanner.nextLine();

            System.out.println("What is the weapon's type?");
            menu(Weapon.WeaponType.values());
            weaponTypeChoice = scanner.nextInt();

        while (!validateWeaponType(weaponTypeChoice)){
            menu(Weapon.WeaponType.values());
            weaponTypeChoice = scanner.nextInt();
        }
        return instantiateWeapon(weaponName, weaponDmg, requiredLevel, weaponTypes[weaponTypeChoice-1]);


    }

    public static Item createArmorUI(){
        int armorTypeChoice;
        int slotTypeChoice;
        Armor.ArmorType[] armorTypes = Armor.ArmorType.values();
        Armor.ArmorType armorType;
        Item.Slot[] armorSlots = Item.Slot.values();
        Item.Slot armorSlot;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the armor item you want to equip?");
        String armorName = scanner.nextLine();

        System.out.println("What is the required level of the armor item?");
        int requiredLevel = scanner.nextInt();
        while (requiredLevel<=0){
            System.out.println("Please write a valid level");
            requiredLevel = scanner.nextInt();
        }
        scanner.nextLine();

        System.out.println("Write in a line the values of three attributes(strength, dexterity, intelligence");
        String[] attributesInput = scanner.nextLine().split(",");
        while (!validateAttributes(attributesInput)) {

            System.out.println("PLease write the correct attribute's numbers like this 1,2,3");
            System.out.println("Write in a line the values of three attributes(strength, dexterity, intelligence)");
            attributesInput = scanner.nextLine().split(",");
        }

        System.out.println("What is the armor's type?");
        menu(Armor.ArmorType.values());
        armorTypeChoice = scanner.nextInt();

        while (!validateArmorType(armorTypeChoice)){
            menu(Armor.ArmorType.values());
            armorTypeChoice = scanner.nextInt();
        }
        armorType = armorTypes[armorTypeChoice-1];
        System.out.println("You chose the type:"+armorType);
        System.out.println("Which slot do you want to equip the armor?");
        menu(Item.Slot.values());
        slotTypeChoice = scanner.nextInt();
        while (!validateSlot(slotTypeChoice)){
            menu(Item.Slot.values());
            slotTypeChoice = scanner.nextInt();
        }

        //we avoided to use weapon slot
        armorSlot = armorSlots[slotTypeChoice];
        return instantiateArmor(armorName,requiredLevel,armorType,attributesInput,armorSlot);



    }



}