package org.example;

public class Main {
    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {

        Mage tasos = new Mage("soulis");
        /*tasos.display();
        tasos.levelUp();
        tasos.display();*/
        Weapon bow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        Ranger tasosRanger = new Ranger("tasoss");
        tasosRanger.display();
        tasos.display();
        tasosRanger.equip(bow);
        tasosRanger.display();


    }
}