package rpgGame.Heroes;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void increaseStrength(int strength){
        this.strength = getStrength() + strength;
    }

    public void increaseDexterity(int dexterity){
        this.dexterity = getDexterity()+dexterity;
    }

    public void increaseIntelligence(int intelligence){
        this.intelligence = getIntelligence()+intelligence;
    }
}
