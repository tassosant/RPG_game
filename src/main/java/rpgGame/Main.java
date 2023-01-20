package rpgGame;

import java.util.Random;

import rpgGame.Heroes.Hero;
import rpgGame.Heroes.HeroAttribute;
import rpgGame.Heroes.Mage;
import rpgGame.Heroes.Ranger;
import rpgGame.Items.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {
        Hero tasos = new Ranger("tasos");
        Item commonLeatherBody = new Armor("Common leather Body", 1, Armor.ArmorType.Leather, 1, 2, 4, Item.Slot.Body);
        Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        tasos.equipArmor(commonLeatherBody);
        tasos.equipWeapon(commonBow);
        tasos.display();

    }




}