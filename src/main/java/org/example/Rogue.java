package org.example;

public class Rogue extends Hero{
    public Rogue(String name){
        super(name, new HeroAttribute(2,6,1));
    }
    public void levelUp() {
        super.levelUp(1, 4, 1);
    }
}
