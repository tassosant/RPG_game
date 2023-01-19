/*
package rpgGame.Heroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpgGame.Items.*;

import static org.junit.jupiter.api.Assertions.*;

class HeroesTest{

    int initDex = 1;
    int initInt = 1;
    int initStr = 1;
    int commonDex = 2;
    int commonInt = 2;
    int commonStr = 2;
    int rareInt = 5;
    int rareDex = 5;
    int rareStr = 5;
    int commonDmg = 2;
    int legendaryDmg = 10;
    int legendaryReqLvl = 10;
    int rangerDex = 7;
    int rangerDexLvlUp = 5;



   */
/* @BeforeEach
    void setUp() {*//*

        //bows
        Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        Item legendaryBow2 = new Weapon("Legendary Bow", 10,10, Weapon.WeaponType.Bow);
        Item legendaryBow = new Weapon("Legendary Bow", 1,10, Weapon.WeaponType.Bow);
        //swords
       */
/* Weapon sword = new Weapon("Common sword", 1, 2, Weapon.WeaponType.Sword);*//*


        //staffs
       */
/* Weapon commonStaff = new Weapon("Common staff", 1,2, Weapon.WeaponType.Staff);
        Weapon legendaryStaff = new Weapon("Legendary staff", 10,10, Weapon.WeaponType.Staff);*//*


        //armor to be equipped for Ranger
        Item leatherBody = new Armor("Common leather Body", 1, Armor.ArmorType.Leather,1,2,1, Item.Slot.Body);
        Item leatherLegs = new Armor("Common leather Boots", 1, Armor.ArmorType.Leather,1,2,1, Item.Slot.Legs);
        Item leatherHead = new Armor("Common leather Helmet", 1, Armor.ArmorType.Leather,1,2,1, Item.Slot.Head);
        Item clothBody = new Armor("Rare cloth Body", 1, Armor.ArmorType.Leather,1,5,1, Item.Slot.Body);

        //Armor to be equipped for Mage
        */
/*Armor mailBody = new Armor("Common mail Body", 1, Armor.ArmorType.Leather,1,1,2, Item.Slot.Body);
        Armor mailLegs = new Armor("Common mail Boots", 1, Armor.ArmorType.Leather,1,1,2, Item.Slot.Legs);
        Armor mailHead = new Armor("Common mail Helmet", 1, Armor.ArmorType.Leather,1,1,2, Item.Slot.Head);
        Armor plateBody = new Armor("Rare plate Body", 5, Armor.ArmorType.Leather,1,1,5, Item.Slot.Body);*//*


        Hero tasosRanger = new Ranger("tasos");
        Hero tasosRanger2 = new Ranger("tasos2");
        Hero tasosMage = new Mage("tasaras");

    //}

    @Test
    void testGetName() {

        String name1 = "tasos";
        String name2 = "tasos2";
        String name3 = "tasaras";
        assertEquals(name1,tasosRanger.getName());
        assertEquals(name2,tasosRanger2.getName());
        assertEquals(name3,tasosMage.getName());
    }

    @Test
    void testGetLevel() {
        int level = 1;
        assertEquals(level,tasosRanger.getLevel());
        assertEquals(level,tasosRanger2.getLevel());
        assertEquals(level,tasosMage.getLevel());
    }

    @Test
    void testLevelAndAttributesWithNoItems() {
        int level = 2;
        int initLevel = 1;
        */
/*tasosRanger.levelUp();*//*

        tasosRanger.levelUp();
        assertEquals(level,tasosRanger.getLevel());
        assertEquals(12,tasosRanger.getLevelAttributes().getDexterity());
        assertEquals(initLevel,tasosRanger2.getLevel());

        assertEquals(initLevel,tasosMage.getLevel());
    }

    @Test
    void testItemsAndSlotsAnd() {
        Item.Slot head = Item.Slot.Head;
        Item.Slot body = Item.Slot.Body;
        Item.Slot legs = Item.Slot.Legs;
        Item.Slot weapon = Item.Slot.Weapon;
        String name = "Common leather Boots";

        assertEquals(commonDmg,commonBow.getWeaponDamage());
        assertEquals(legendaryDmg,legendaryBow.getWeaponDamage());
        assertEquals(initInt,leatherBody.getArmorAttribute().getIntelligence());
        assertEquals(initStr, leatherBody.getArmorAttribute().getStrength());
        assertEquals(commonDex, leatherBody.getArmorAttribute().getDexterity());
        assertEquals(body, leatherBody.getSlot());
        assertEquals(head, leatherHead.getSlot());
        assertNotEquals(legs, leatherHead.getSlot());
    }
    @Test
    void testEquipArmor() {

    }

    @Test
    void testEquipWeapon() {
    }
    @Test
    void testTotalAttributes() throws InvalidWeaponException, InvalidArmorException {

        double damageWithNoWeapon = 1*(1+(double) rangerDex /100);
        double dmgWithWeapon = 10.0;
        double dmgWithWeaponAndLevelUp = dmgWithWeapon * (1+(double) (rangerDex+rangerDexLvlUp)/100);
        double dmgWithWeaponAndRareArmorOnePieceLvlUp = dmgWithWeapon * (1+(double) (rangerDex+rangerDexLvlUp+rareDex)/100);
        double dmgWithWeaponAndArmorTwoPiecesLvlUp = dmgWithWeapon * (1+(double) (rangerDex+rangerDexLvlUp+rareDex+commonDex)/100);
        //assertEquals(17,tasosRanger.getLevelAttributes().getDexterity());

        //test with no weapon
        assertEquals(damageWithNoWeapon, tasosRanger.damage());

        //test with weapon and lvl2
        tasosRanger2.equipWeapon(legendaryBow);
        tasosRanger2.levelUp();
        assertEquals(dmgWithWeaponAndLevelUp,tasosRanger2.damage());

        //test with one piece of rare armor and weapon and lvl 2
        tasosRanger2.equipArmor(clothBody);
        assertEquals(dmgWithWeaponAndRareArmorOnePieceLvlUp,tasosRanger2.damage());

        //test with two pieces of armor and equipped weapon at lvl 2
        tasosRanger2.equipArmor(leatherHead);
        assertEquals(rangerDex+rangerDexLvlUp+rareDex+commonDex,tasosRanger2.totalAttributes().getDexterity());
        assertEquals(dmgWithWeaponAndArmorTwoPiecesLvlUp, tasosRanger2.damage());

        //test with dropping the common armor piece
        tasosRanger2.dropArmor(leatherHead);
        assertEquals(dmgWithWeaponAndRareArmorOnePieceLvlUp, tasosRanger2.damage());

        //test with replacing the weapon (lvl2, one rare armor piece)
        tasosRanger2.equipWeapon(commonBow);
        double attrDmg = (1+(double) (rangerDex+rangerDexLvlUp+rareDex)/100);
        double commonWeaponDmg = 2 * attrDmg;
        assertEquals(commonWeaponDmg, tasosRanger2.damage());

    }

    @Test
    void testLevelUp() {
    }

    @Test
    void testDisplay() {
    }





    @Test
    void testDamage() {
    }

    @Test
    void testAddWeaponTypes() {
    }

    @Test
    void testAddArmorTypes() {
    }

    @Test
    void testInitEquipmentSlots() {
    }

    @Test
    void testDropWeapon() {
    }

    @Test
    void testDropArmor() {
    }

    @Test
    void testLevelUp1() {
    }

    @Test
    void testDamage1() {
    }
}*/
