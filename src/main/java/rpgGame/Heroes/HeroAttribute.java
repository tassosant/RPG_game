package rpgGame.Heroes;
//class hero attributes
public class HeroAttribute {
    //fields
    private int strength;
    private int dexterity;
    private int intelligence;
    //Constructors
    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }
    //This constructor is used to totalAttributes method of Hero class in order to initialize the values
    public HeroAttribute(){
        this.strength=0;
        this.dexterity=0;
        this.intelligence=0;
    }
    //getters and setters
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
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
    //methods to increase every attribute, they are used for hero's level increment
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
