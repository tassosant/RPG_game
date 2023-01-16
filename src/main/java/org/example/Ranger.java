package org.example;

public class Ranger extends Hero{
    public Ranger(String name) {
        super(name, new HeroAttribute(1,7,1));
    }

    public void levelUp() {
        super.levelUp(1, 5, 1);
    }
}
