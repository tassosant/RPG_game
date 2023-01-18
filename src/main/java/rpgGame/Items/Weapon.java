package rpgGame.Items;
//subclass weapon
public class Weapon extends Item{
    //fields
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
    //declaration of weapontype
    WeaponType weaponType;
    //constructor
    public Weapon(String name, int requiredLevel, int weaponDamage, WeaponType weaponType) {
        super(name, requiredLevel);
        this.slot = Slot.Weapon;
        this.weaponDamage = weaponDamage;
        this.weaponType = weaponType;

    }
    //getters and setters
    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

}
