package org.example;

public class Main {
    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {

        Mage tasos = new Mage("soulis");
        /*tasos.display();
        tasos.levelUp();
        tasos.display();*/
        Weapon bow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow, Item.Slot.Weapon);
        Armor leatherBody = new Armor("Common leather Body", 1, Armor.ArmorType.Leather,new HeroAttribute(1,0,0), Item.Slot.Body);
        Ranger tasosRanger = new Ranger("tasoss");
        tasosRanger.display();
        tasos.display();
        tasosRanger.equip(bow, null);
        tasosRanger.display();
        Weapon bow2 = new Weapon("Legendary Bow2", 1,10, Weapon.WeaponType.Bow, Item.Slot.Weapon);
        tasosRanger.equip(bow2, null);
        tasosRanger.display();
        Weapon sword = new Weapon("common sword", 1, 2, Weapon.WeaponType.Sword, Item.Slot.Weapon);
        //tasosRanger.equip(sword, null);
        tasosRanger.equip(bow2, leatherBody);
        tasosRanger.display();

    }
}