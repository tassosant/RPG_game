package rpgGame.Heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroAttributeTest {

    @Test
    void setStrength() {
        HeroAttribute MageAttributes = new HeroAttribute(1,1,8);
        MageAttributes.setStrength(6);
        assertEquals(6,MageAttributes.getStrength());
    }

    @Test
    void setDexterity() {
        HeroAttribute MageAttributes = new HeroAttribute(1,1,8);
        MageAttributes.setDexterity(3);
        assertEquals(3,MageAttributes.getDexterity());
    }

    @Test
    void setIntelligence() {
        HeroAttribute MageAttributes = new HeroAttribute(1,1,8);
        MageAttributes.setIntelligence(10);
        assertEquals(10,MageAttributes.getIntelligence());
    }

    @Test
    void getStrength() {
        HeroAttribute MageAttributes = new HeroAttribute(100,1,8);
        assertEquals(100,MageAttributes.getStrength());
    }

    @Test
    void getDexterity() {
        HeroAttribute MageAttributes = new HeroAttribute(1,16,8);
        assertEquals(16,MageAttributes.getDexterity());
    }

    @Test
    void getIntelligence() {
        HeroAttribute MageAttributes = new HeroAttribute(1,1,88);
        assertEquals(88, MageAttributes.getIntelligence());
    }

    @Test
    void increaseStrength() {
        HeroAttribute MageAttributes = new HeroAttribute(1,1,8);
        MageAttributes.increaseStrength(100);
        assertEquals(101,MageAttributes.getStrength());
    }

    @Test
    void increaseDexterity() {
        HeroAttribute MageAttributes = new HeroAttribute(1,2,8);
        MageAttributes.increaseDexterity(13);
        assertEquals(15,MageAttributes.getDexterity());
    }

    @Test
    void increaseIntelligence() {
        HeroAttribute MageAttributes = new HeroAttribute(1,1,8);
        MageAttributes.increaseIntelligence(10);
        assertEquals(18,MageAttributes.getIntelligence());
    }
}