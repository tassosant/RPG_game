package rpgGame.Heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest{

    @Test
    void getName() {
        Hero tasosMage = new Mage("tasos mage");
        assertEquals("tasos mage",tasosMage.getName());
    }

    @Test
    void getLevel() {
        Hero tasosMage = new Mage("tasos mage");
        tasosMage.levelUp();
        assertEquals(2,tasosMage.getLevel());
    }




    @Test
    void getLevelAttributes() {
        Hero tasosMage = new Mage("tasos warrior");
        tasosMage.levelUp();
        int expectedStr = 2;
        int expectedDex = 2;
        int expectedInt = 13;
        int str = tasosMage.getLevelAttributes().getStrength();
        int dex = tasosMage.getLevelAttributes().getDexterity();
        int intel = tasosMage.getLevelAttributes().getIntelligence();
        assertEquals(expectedStr,str);
        assertEquals(expectedDex,dex);
        assertEquals(expectedInt,intel);

    }
}