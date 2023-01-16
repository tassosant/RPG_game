package org.example;

public class Weapon extends Item{
    public enum WeaponType {
        Axe,
        Bow,
        Dagger,
        Hammer,
        Staff,
        Sword,
        Wand
    }

    private int weaponDamage;
    WeaponType weaponType;
    public Weapon(String name, int requiredLevel, int weaponDamage, WeaponType weaponType, Slot slot) {
        super(name, requiredLevel, slot);
        this.weaponDamage = weaponDamage;
        this.weaponType = weaponType;

    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

}
