package rpgGame.Heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    @Test
    void getName() {
        Hero tasosRogue = new Rogue("tasos rogue");
        assertEquals("tasos rogue",tasosRogue.getName());
    }

    @Test
    void getLevel() {
        Hero tasosRogue = new Rogue("tasos rogue");
        tasosRogue.levelUp();
        assertEquals(2,tasosRogue.getLevel());
    }




    @Test
    void getLevelAttributes() {
        Hero tasosRogue = new Rogue("tasos rogue");
        tasosRogue.levelUp();
        int expectedStr = 3;
        int expectedDex = 10;
        int expectedInt = 2;
        int str = tasosRogue.getLevelAttributes().getStrength();
        int dex = tasosRogue.getLevelAttributes().getDexterity();
        int intel = tasosRogue.getLevelAttributes().getIntelligence();
        assertEquals(expectedStr,str);
        assertEquals(expectedDex,dex);
        assertEquals(expectedInt,intel);

    }






}