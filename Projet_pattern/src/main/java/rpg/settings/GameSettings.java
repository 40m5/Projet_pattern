package rpg.settings;

import rpg.core.Character;

public class GameSettings {
    private static GameSettings instance;
    private int maxStatPoints = 30;

    private GameSettings() {}

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    public boolean isValid(Character character) {
        int totalStats = character.getStrength() + character.getAgility() + character.getIntelligence();
        return totalStats <= maxStatPoints;
    }

    public void setMaxStatPoints(int maxStatPoints) {
        this.maxStatPoints = maxStatPoints;
    }

    public int getMaxStatPoints() {
        return maxStatPoints;
    }
}