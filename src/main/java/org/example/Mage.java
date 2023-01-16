package org.example;

public class Mage extends Hero{


    public Mage(String name) {
        super(name, new HeroAttribute(1,1,8));
    }

    public void levelUp() {
        super.levelUp(1, 1, 5);
    }


}
