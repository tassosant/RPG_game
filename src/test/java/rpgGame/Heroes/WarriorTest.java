package rpgGame.Heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    void getName() {
        Hero tasosWarrior = new Warrior("tasos warrior");
        assertEquals("tasos warrior",tasosWarrior.getName());
    }

    @Test
    void getLevel() {
        Hero tasosWarrior = new Warrior("tasos warrior");
        tasosWarrior.levelUp();
        assertEquals(2,tasosWarrior.getLevel());
    }




    @Test
    void getLevelAttributes() {
        Hero tasosWarrior = new Warrior("tasos warrior");
        tasosWarrior.levelUp();
        int expectedStr = 8;
        int expectedDex = 4;
        int expectedInt = 2;
        int str = tasosWarrior.getLevelAttributes().getStrength();
        int dex = tasosWarrior.getLevelAttributes().getDexterity();
        int intel = tasosWarrior.getLevelAttributes().getIntelligence();
        assertEquals(expectedStr,str);
        assertEquals(expectedDex,dex);
        assertEquals(expectedInt,intel);

    }
}