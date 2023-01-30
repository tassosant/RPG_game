
# gradle_rpg


## Name
RPG game characters and items.

## Description
1. This project is a small RPG game with no graphics.

2. It is able to create some items(weapons and armor) and some heroes **(Mage, Ranger, Warrior, Rogue)**.

3. The heroes can equip armor or weapon and can damage an opponent. Unfortunately, there is no HP attribute yet.

4. The heroes have three attributes(strength, dexterity and intelligence).

5. The weapon types are **Staff,Wand,Dagger,Sword**

6. The armor's materials are **Leather,Plate,Mail,Cloth**.

7. All heroes can equip only one weapon(Slot weapon) and three armor pieces.<br/>The available armor slots are **Head,Body and Legs**, one armor piece per slot.

8. The weapon types of **Staff and Wand** are available to **Mages**. <br/>These Heroes can only be outfitted with **Cloth** armor.

9. The **Bow** weapon types are available for **Rangers** to use. <br/>These Heroes can only wear armor made of **Leather** and **Mail**.

10. The **Dagger and Sword** weapon types are available to **Rogues**.<br/> These Heroes can only wear armor made of **Leather or Mail**.

11. The **Axe,Hammer,Sword** weapon types are available to **Warriors**.<br/> Only **Mail and Plate** armor type can be equipped to these Heroes.

12. Mage's stats at level 1(str:1,dex:1,intel:8). Mage at level 2(str:2,dex:2,intel:13). The strong attribute of Mage is intelligence.

13. Ranger's stats at level 1(str:1,dex:7,intel:1). Ranger at level 2(str:2,dex:12,intel:2). The strong attribute of Ranger is dexterity.

14. Rogue's stats at level 1(str:2,dex:6,intel:1). Rogue at level 2(str:3,dex:10,intel:2). The strong attribute of Rogue is dexterity.

15. Warrior's stats at level 1(str:5,dex:2,intel:1). Warrior at level 2(str:8,dex:4,intel:2). The strong attribute of Warrior is strength.

16. Calculate damage at hero's lvl 1:

-  The dmg of warrior's at level 1 with no equipment must be 1*(1+(5/100)).(5 is the strong attribute of hero's, in this case it is strength). -  The dmg of warrior's at level 1 with weapon equipped must be 2*(1+(5/100)).(2 is the weapon's damage). -  The dmg of warrior's at level 1 with one armor piece equipped(e.g. plate body with strength 2) <br /> must be 1*(1+(5+2)/100). <br />"5+2" is hero's strong attribute plus the armor's attribute which must be the same type of hero's strong attribute -  The dmg of warrior's at level 1 with one armor piece equipped and weapon equipped<br/>(example d and c together) must be 2*(1+(5+2)/100)  17. As it is obvious from above, the hero's three attributes and damage changes depending on the equipped items and hero's levels.

18. Furthermore, the app can display the character status or item status.Also, it displays the equipment items which are equipped by the hero.


## Visuals
![Image with one armor equipped and weapon equipped](https://github.com/tassosant/RPG_game/blob/main/HeroCreationWithEquippingArmorPIeceAndWeapon.png)

## Installation
This app was created and tested in **intellij** using the **gradle** tool.

## Usage
1. There is a menu to choose a hero class
```  
Please choose a Hero:  
Please select from 1 to 5:  
1. Mage  
2. Ranger  
3. Rogue  
4. Warrior  
5. Exit  
```  
Type a number from 1 to 5 and press **Enter**

2. If you chose a hero, then this option will appear:
```  
Please select a name for your hero  
  
```  
Type whatever name you want and press **Enter**

3. Then, you will have to choose a Hero's action:
```  
Please select from 1 to 5:  
4. Level up  
5. Equip weapon  
6. Equip armor  
7. Display status  
8. Exit  
```  
Type the number and press **Enter**


9. If you equip the weapon:
    - It will appear on the screen to type the weapon's name. Type it and press **Enter**.
    - Then type the required Hero's level to equip this weapon(greater than 0). Type it and press **Enter**.
    - Type the weapon's dmg (greater than 0) and press **Enter**..
    - Choose the type of weapon(1 to 7). Type the number and press **Enter**.  
      -If it is the valid type for the hero's class it will appear on the screen(Equipped:Weapon's name).
10. If you equip armor:
    - It will appear on the screen to type the armor item's name. Type it and press **Enter**.
    - Then type the required Hero's level to equip this armor item(greater than 0). Type it and press **Enter**.
    - Write in a line the values of three attributes(strength, dexterity, intelligence) like this:
      ```2,5,2```
      Press **Enter**
    - Choose the type of armor(1 to 4). Type the number and press **Enter**.
    - Choose the slot you want to equip the armor(1 to 3). Type it and press **Enter**.
## Devs
In main method which is in the main class:

1. A hero(e.g. Ranger) is created like this example below:
```  
Hero heroName = new Ranger("myName");  
```  

You can display the status with this line:
```  
heroName.display();  
```  

2. An armor item can be created like this:
```  
Item leatherBody = new Armor("Common leather Body", 5, Armor.ArmorType.Leather, 1, 2, 4, Item.Slot.Body);  
```  
There are 7 arguments: (itemName, requiredLevel,**armorType**,strength,dexterity,intelligence,**slot**);  
The requiredLevel is the lowest level at which the Hero can use this specific item. (e.g. the item has requierdLevel=11, the hero must be at least of level 11 to be able to equip it).

3. A weapon can be created like this:
```  
Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);  
```  
The arguments are 4: (itemName, requiredLevel, weaponDamage, **weaponType**)  
The requiredLevel is described previously(check part 3 of this section).

4. Display Hero's stats:
```  
heroName.display();  
```  

5. Increase hero's level:
```  
heroName.levelUp();  
```  

6. Equip an armor piece:
```  
heroName.equipArmor(leatherBody);  
```  

7. Equip a weapon:
```  
heroName.equipWeapon(commonBow);  
```  
8. Drop a weapon:
```  
heroName.dropWeapon();  
```  
9. Drop an item:
```  
heroName.dropArmor(leatherBody);  
```  
10. Display an item:
      ```
      commonBow.displayStats();
      leatherBody.displayStats();
      ```
11. There are comments in code. The comments for all hero's subclasses are in Mage subclass.
12. Some parts of code satisfy the Liscov Substitution Principle.
13. Documentation generated in (https://github.com/tassosant/RPG_game/tree/main/gradle_rpg_doc)


## Roadmap
1. Autogenerate items in a chest class
2. Console game user interface(terminal ui)
3. Heroes can fight
4. Heroes can move


## Project status
This project is only for educational purposes