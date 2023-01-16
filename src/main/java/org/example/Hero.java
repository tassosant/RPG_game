package org.example;

public abstract class Hero {
    private String name;
    private int level;
    private HeroAttribute levelAttributes;

    //Equipment: Hashmap <slot:key,Item:value>
    //ValidWeaponTypes : List
    //ValidArmorTypes : List


    public Hero(String name, HeroAttribute levelAttributes) {
        this.name = name;
        this.level = 1;
        this.levelAttributes = levelAttributes;
    }

    /*public Hero(String name,int level, HeroAttribute levelAttributes) {
        this.name = name;
        this.level = level;
        this.levelAttributes = levelAttributes;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp(int strength, int dexterity, int intelligence){
        this.levelAttributes.increaseStrength(strength);
        this.levelAttributes.increaseDexterity(dexterity);
        this.levelAttributes.increaseIntelligence(intelligence);
        setLevel(getLevel()+1);
    }

    public void display(){
        System.out.printf("Name=%s\tStrength=%d\tDexterity=%d\tIntelligence=%d\n",getName(),this.levelAttributes.getStrength(), this.levelAttributes.getDexterity(), this.levelAttributes.getIntelligence());
    }

    public HeroAttribute totalAttributes(){
        return this.levelAttributes;
    }

}
