# gradle_rpg



## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.



## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.com/tasos.an.antoniou/gradle_rpg.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://gitlab.com/tasos.an.antoniou/gradle_rpg/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Automatically merge when pipeline succeeds](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***



## Suggestions for a good README
Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
RPG game characters and items.

## Description
1.	This project is a small RPG game with no graphics.

2.	It is able to create some items(weapons and armor) and some heroes **(Mage, Ranger, Warrior, Rogue)**.

3.	The heroes can equip armor or weapon and they can damage an opponent. Unfortunately, there is no HP attribute yet.

4.	The heroes have three attributes(strength, dexterity and intelligence).

5.	The weapon types are **Staff,Wand,Dagger,Sword**

6.	The armor's materials are **Leather,Plate,Mail,Cloth**.

7.	All heroes can equip only on weapon(Slot weapon) and three armor pieces.<br/>The available armor slots are **Head,Body and Legs**, one armor piece per slot.

8.	The weapon types of **Staff and Wand** are available to **Mages**. <br/>These Heroes can only be outfitted with **Cloth** armor.

9.	The **Bow** weapon types are available for **Rangers** to use. <br/>These Heroes can only wear armor made of **Leather** and **Mail**.

10.	The **Dagger and Sword** weapon types are available to **Rogues**.<br/> These Heroes can only wear armor made of **Leather or Mail**.

11.	The **Axe,Hammer,Sword** weapon types are available to **Warriors**.<br/> Only **Mail and Plate** armor type can be equipped to these Heroes.

12.	Mage's stats at level 1(str:1,dex:1,intel:8). Mage at level 2(str:2,dex:2,intel:13). The strong attribute of Mage is intelligence.

13.	Ranger's stats at level 1(str:1,dex:7,intel:1). Ranger at level 2(str:2,dex:12,intel:2). The strong attribute of Ranger is dexterity.

14.	Rogue's stats at level 1(str:2,dex:6,intel:1). Rogue at level 2(str:3,dex:10,intel:2). The strong attribute of Rogue is dexterity.

15.	Warrior's stats at level 1(str:5,dex:2,intel:1). Warrior at level 2(str:8,dex:4,intel:2). The strong attribute of Warrior is strength.

16.	Caclulate damage at hero's lvl 1:
	
	-	The dmg of warrior's at level 1 with no equipment must be 1*(1+(5/100)).(5 is the strong attribute of hero's, in this case it is strength).
	-	The dmg of warrior's at level 1 with weapon equipped must be 2*(1+(5/100)).(2 is the weapon's damage).
	-	The dmg of warrior's at level 1 with one armor piece equipped(e.g. plate body with strength 2) <br /> must be 1*(1+(5+2)/100). <br />"5+2" is hero's strong attribute plus the armor's attribute which must be the same type of hero's strong attribute
	-	The dmg of warrior's at level 1 with one armor piece equipped and weapon equipped<br/>(example d and c together) must be 2*(1+(5+2)/100)
	
17.	As it is obvious from above, the hero's three attributes and damage changes depending on the equipped items and hero's levels.

18.	Furthermore the app can display the character status or item status.Also, it displays the equipment items which are equipped by the hero.


## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
![Image with one armor equipped and weapon equipped](https://gitlab.com/tasos.an.antoniou/gradle_rpg/-/tree/main/HeroCreationWithEquippingArmorPIeceAndWeapon.png)

## Installation
This app was created and tested in intellij using the gradle tool.

## Usage
In main method which is in the main class:

1.	A hero(e.g. Mage) is created like this example below:
```
Hero heroName = new Ranger("myName");
```

You can display the status with this line:
```
heroName.display();
```

2.	An armor item can be created like this:
```
Item leatherBody = new Armor("Common leather Body", 5, Armor.ArmorType.Leather, 1, 2, 4, Item.Slot.Body);
```
The arguments are 7: (itemName, requiredLevel,**armorType**,strength,dexterity,intelligence,**slot**);
The requiredLevel is the level of the Hero who can equip this particular item. (e.g. the item has requierdLevel=11, the hero must be at least of level 11 to be able to equip it).

3.	A weapon can be created like this:
```
Item commonBow = new Weapon("Common Bow", 1,2, Weapon.WeaponType.Bow);
```
The arguments are 4:(itemName, requiredLevel, weaponDamage, **weaponType**)
The requiredLevel is explained above(check part 3 of this section).

4.	Display Hero's stats:
```
heroName.display();
```

5.	Increase hero's level:
```
heroName.levelUp();
```

6.	Equip an armor piece:
```
heroName.equipArmor(leatherBody);
```

7.	Equip a weapon:
```
heroName.equipWeapon(commonBow);
```

##Devs

1.	There are comments in code. The comments for all subclasses of hero are in Mage subclass.
2.	The code is designed to satisfy the Liscov Substitution Principle.
3.	Documentation generated in (https://gitlab.com/tasos.an.antoniou/gradle_rpg/-/tree/main/gradle_rpg_doc/index.html)
4.	Test reports generated in (https://gitlab.com/tasos.an.antoniou/gradle_rpg/-/tree/main/build/reports/tests/test/index.html)

## Roadmap
1. Autogenerate items in a chest class
2. Console game user interface(terminal ui)
3. Heroes can fight
4. Heroes can move


## Project status
This project is only for educational purposes
