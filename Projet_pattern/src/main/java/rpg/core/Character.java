package rpg.core;

public class Character{
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;

    public Character(String name, int strength, int agility, int intelligence){
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getPowerLevel(){
        return strength + agility + intelligence;
    }

    public String getDescription(){
        return String.format("%s (Force: %d, Agilité: %d, Intelligence: %d)", name, strength, agility, intelligence);
    }

    public String getName() { return name; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntelligence() { return intelligence; }

}