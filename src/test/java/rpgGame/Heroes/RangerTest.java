package rpgGame.Heroes;

import org.junit.jupiter.api.Test;
import rpgGame.Items.*;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    @Test
    void getName() {
        Hero tasosRanger = new Ranger("tasos");
        assertEquals("tasos", tasosRanger.getName());
    }

    @Test
    void getLevel() {
        Hero tasosRanger = new Ranger("tasos");
        tasosRanger.levelUp();
        assertEquals(2, tasosRanger.getLevel());
    }


    @Test
    void getLevelAttributes() {
        Hero tasosRanger = new Ranger("tasos");
        int expectedStr = 1;
        int expectedDex = 7;
        int expectedInt = 1;
        int str = tasosRanger.getLevelAttributes().getStrength();
        int dex = tasosRanger.getLevelAttributes().getDexterity();
        int intel = tasosRanger.getLevelAttributes().getIntelligence();
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
    }

    @Test
    void levelUp() {
        Hero tasosRanger = new Ranger("tasos");
        tasosRanger.levelUp();
        tasosRanger.levelUp();
        int expectedStr = 3;
        int expectedDex = 17;
        int expectedInt = 3;
        int str = tasosRanger.getLevelAttributes().getStrength();
        int dex = tasosRanger.getLevelAttributes().getDexterity();
        int intel = tasosRanger.getLevelAttributes().getIntelligence();
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
    }

    @Test
    void display() {

    }

    @Test
    void totalAttributesWithNoWeaponAndLevel3() {
        Hero tasosRanger = new Ranger("tasos");
        tasosRanger.levelUp();
        tasosRanger.levelUp();
        int expectedStr = 3;
        int expectedDex = 17;
        int expectedInt = 3;
        int str = tasosRanger.totalAttributes().getStrength();
        int dex = tasosRanger.totalAttributes().getDexterity();
        int intel = tasosRanger.totalAttributes().getIntelligence();
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
    }

    @Test
    void equipOnePieceOfArmorAndLvl3() throws InvalidArmorException {
        Hero tasosRanger = new Ranger("tasos");
        Item leatherBody = new Armor("Common leather Body", 1, Armor.ArmorType.Leather, 1, 2, 1, Item.Slot.Body);
        Item leatherLegs = new Armor("Common leather Boots", 1, Armor.ArmorType.Leather, 1, 2, 1, Item.Slot.Legs);
        tasosRanger.levelUp();
        tasosRanger.levelUp();
        tasosRanger.equipArmor(leatherBody);
        int expectedStr = 4;
        int expectedDex = 19;
        int expectedInt = 4;
        int str = tasosRanger.totalAttributes().getStrength();
        int dex = tasosRanger.totalAttributes().getDexterity();
        int intel = tasosRanger.totalAttributes().getIntelligence();
        double dmg = (1 + (double) (17 + 2) / 100);
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
        assertEquals(dmg, tasosRanger.damage());
    }

    @Test
    void equipTwoPiecesOfArmorAndLvl3() throws InvalidArmorException {
        Hero tasosRanger = new Ranger("tasos");
        Item leatherBody = new Armor("Common leather Body", 1, Armor.ArmorType.Leather, 1, 2, 1, Item.Slot.Body);
        Item leatherLegs = new Armor("Common leather Boots", 1, Armor.ArmorType.Leather, 1, 2, 1, Item.Slot.Legs);
        tasosRanger.levelUp();
        tasosRanger.levelUp();
        tasosRanger.equipArmor(leatherBody);
        tasosRanger.equipArmor(leatherLegs);
        int expectedStr = 5;
        int expectedDex = 21;
        int expectedInt = 5;
        int str = tasosRanger.totalAttributes().getStrength();
        int dex = tasosRanger.totalAttributes().getDexterity();
        int intel = tasosRanger.totalAttributes().getIntelligence();
        double dmg = (1 + (double) (17 + 4) / 100);
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
        assertEquals(dmg, tasosRanger.damage());
    }

    @Test
    void equipTwoPiecesOfArmorThenReplaceOnePieceAndLvl3() throws InvalidArmorException {
        Hero tasosRanger = new Ranger("tasos");
        Item leatherBody = new Armor("Common leather Body", 1, Armor.ArmorType.Leather, 1, 2, 1, Item.Slot.Body);
        Item leatherLegs = new Armor("Common leather Boots", 1, Armor.ArmorType.Leather, 1, 2, 1, Item.Slot.Legs);
        Item rareLeatherBoots = new Armor("Rare leather Boots", 1, Armor.ArmorType.Leather, 1, 6, 1, Item.Slot.Legs);
        tasosRanger.levelUp();
        tasosRanger.levelUp();
        tasosRanger.equipArmor(leatherBody);
        tasosRanger.equipArmor(leatherLegs);
        tasosRanger.equipArmor(rareLeatherBoots);
        int expectedStr = 5;
        int expectedDex = 25;
        int expectedInt = 5;
        int str = tasosRanger.totalAttributes().getStrength();
        int dex = tasosRanger.totalAttributes().getDexterity();
        int intel = tasosRanger.totalAttributes().getIntelligence();
        double dmg = (1 + (double) (17 + 8) / 100);
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
        assertEquals(dmg, tasosRanger.damage());
    }

    @Test
    void equipAllEquipment() throws InvalidWeaponException, InvalidArmorException {
        Hero tasosRanger = new Ranger("tasos");
        Item commonBow = new Weapon("Common Bow", 1, 2, Weapon.WeaponType.Bow);
        Item leatherHelmet = new Armor("Common leather Helmet", 1, Armor.ArmorType.Leather, 2, 4, 1, Item.Slot.Head);
        Item leatherBody = new Armor("Common leather Body", 1, Armor.ArmorType.Leather, 1, 2, 1, Item.Slot.Body);
        Item leatherLegs = new Armor("Common leather Boots", 1, Armor.ArmorType.Leather, 1, 2, 1, Item.Slot.Legs);
        tasosRanger.levelUp();
        tasosRanger.levelUp();
        tasosRanger.equipWeapon(commonBow);
        tasosRanger.equipArmor(leatherHelmet);
        tasosRanger.equipArmor(leatherBody);
        tasosRanger.equipArmor(leatherLegs);
        int expectedStr = 7;
        int expectedDex = 25;
        int expectedInt = 6;
        int str = tasosRanger.totalAttributes().getStrength();
        int dex = tasosRanger.totalAttributes().getDexterity();
        int intel = tasosRanger.totalAttributes().getIntelligence();
        double dmg = 2 * (1 + (double) (17 + 8) / 100);
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
        assertEquals(dmg, tasosRanger.damage());

    }

    @Test
    void equipOneAndReplaceWeapon() throws InvalidWeaponException {
        Hero tasosRanger = new Ranger("tasos");
        Item commonBow = new Weapon("Common Bow", 1, 2, Weapon.WeaponType.Bow);
        Item legendaryBow = new Weapon("Legendary Bow", 1, 10, Weapon.WeaponType.Bow);
        tasosRanger.levelUp();
        tasosRanger.levelUp();
        int expectedStr = 3;
        int expectedDex = 17;
        int expectedInt = 3;
        int str = tasosRanger.totalAttributes().getStrength();
        int dex = tasosRanger.totalAttributes().getDexterity();
        int intel = tasosRanger.totalAttributes().getIntelligence();
        tasosRanger.equipWeapon(commonBow);
        tasosRanger.equipWeapon(legendaryBow);
        double dmg = 10 * (1 + (double) 17 / 100);
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
        assertEquals(dmg, tasosRanger.damage());

    }

    @Test
    void equipOneWeapon() throws InvalidWeaponException {
        Hero tasosRanger = new Ranger("tasos");
        Item commonBow = new Weapon("Common Bow", 1, 2, Weapon.WeaponType.Bow);
        Item legendaryBow = new Weapon("Legendary Bow", 1, 10, Weapon.WeaponType.Bow);
        tasosRanger.levelUp();
        tasosRanger.levelUp();
        int expectedStr = 3;
        int expectedDex = 17;
        int expectedInt = 3;
        int str = tasosRanger.totalAttributes().getStrength();
        int dex = tasosRanger.totalAttributes().getDexterity();
        int intel = tasosRanger.totalAttributes().getIntelligence();
        tasosRanger.equipWeapon(commonBow);

        double dmg = 2 * (1 + (double) 17 / 100);
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
        assertEquals(dmg, tasosRanger.damage());
        tasosRanger.display();

    }

    @Test
    void exceptionsHighLvlAndWrongType() throws InvalidWeaponException, InvalidArmorException {
        //I check if it throws excetpions, also I check if the attributes have changed
        Hero tasosRanger = new Ranger("tasos");
        Item plateHelmet = new Armor("Common plate Helmet", 1, Armor.ArmorType.Plate, 2, 4, 1, Item.Slot.Head);
        Item leatherBody = new Armor("Common leather Body", 8, Armor.ArmorType.Leather, 1, 2, 1, Item.Slot.Body);
        Item commonSword = new Weapon("Common Bow", 1, 2, Weapon.WeaponType.Sword);
        Item legendaryBow = new Weapon("Legendary Bow", 10, 10, Weapon.WeaponType.Bow);
        InvalidArmorException armorTypeException = assertThrows(InvalidArmorException.class, () -> tasosRanger.equipArmor(plateHelmet), "Didn't throw armor type");
        InvalidArmorException armorLevelException = assertThrows(InvalidArmorException.class, () -> tasosRanger.equipArmor(leatherBody), "Didn't throw required level armor");
        InvalidWeaponException weaponTypeException = assertThrows(InvalidWeaponException.class, () -> tasosRanger.equipWeapon(commonSword), "Didn't throw weapon type");
        InvalidWeaponException weaponLevelException = assertThrows(InvalidWeaponException.class, () -> tasosRanger.equipWeapon(legendaryBow), "Didn't throw required level weapon");
        assertTrue(armorTypeException.getMessage().contentEquals("Invalid Armor type"));
        assertTrue(armorLevelException.getMessage().contentEquals("Not yet at level:8"));
        assertTrue(weaponTypeException.getMessage().contentEquals("Invalid Weapon type"));
        assertTrue(weaponLevelException.getMessage().contentEquals("Not yet at level:10"));
        int expectedStr = 1;
        int expectedDex = 7;
        int expectedInt = 1;
        int str = tasosRanger.totalAttributes().getStrength();
        int dex = tasosRanger.totalAttributes().getDexterity();
        int intel = tasosRanger.totalAttributes().getIntelligence();
        double dmg = 1 * (1 + (double) 7 / 100);
        assertEquals(expectedStr, str);
        assertEquals(expectedDex, dex);
        assertEquals(expectedInt, intel);
        assertEquals(dmg, tasosRanger.damage());
    }

}