package rpgGame.Items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {


    @Test
    void getArmorTypeAndName() {
        Item leatherBody = new Armor("Common leather Body", 5, Armor.ArmorType.Leather,1,2,5, Item.Slot.Body);
        Armor.ArmorType armorType = Armor.ArmorType.Leather;
        assertEquals(armorType,leatherBody.getArmorType());
        assertEquals("Common leather Body",leatherBody.getName());
        assertEquals(1,leatherBody.getArmorAttribute().getStrength());
        assertEquals(2,leatherBody.getArmorAttribute().getDexterity());
        assertEquals(5,leatherBody.getArmorAttribute().getIntelligence());
    }

    @Test
    void getArmorAttribute() {
        Item leatherBody = new Armor("Common leather Body", 5, Armor.ArmorType.Leather,1,2,5, Item.Slot.Body);
        assertEquals(1,leatherBody.getArmorAttribute().getStrength());
        assertEquals(2,leatherBody.getArmorAttribute().getDexterity());
        assertEquals(5,leatherBody.getArmorAttribute().getIntelligence());
    }

    @Test
    void getWeaponDamage() {
        Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        assertEquals(2,commonBow.getWeaponDamage());
    }

    @Test
    void getWeaponType() {
        Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        Weapon.WeaponType weaponType = Weapon.WeaponType.Bow;
        assertEquals(weaponType, commonBow.getWeaponType());
    }

    @Test
    void getName() {
        Item leatherBody = new Armor("Common leather Body", 5, Armor.ArmorType.Leather,1,2,5, Item.Slot.Body);
        Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        assertEquals("Common leather Body",leatherBody.getName());
        assertEquals("Common Bow",commonBow.getName());
    }

    @Test
    void getSlot() {
        Item leatherBody = new Armor("Common leather Body", 5, Armor.ArmorType.Leather,1,2,5, Item.Slot.Body);
        Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        Item.Slot armorSlot = Item.Slot.Body;
        Item.Slot weaponSlot = Item.Slot.Weapon;
        assertEquals(armorSlot,leatherBody.getSlot());
        assertEquals(weaponSlot,commonBow.getSlot());
    }

    @Test
    void getRequiredLevel() {
        Item leatherBody = new Armor("Common leather Body", 5, Armor.ArmorType.Leather,1,2,5, Item.Slot.Body);
        Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
        assertEquals(5,leatherBody.getRequiredLevel());
        assertEquals(1,commonBow.getRequiredLevel());
    }


}