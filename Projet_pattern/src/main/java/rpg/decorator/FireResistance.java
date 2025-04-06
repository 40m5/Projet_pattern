package rpg.decorator;

import rpg.core.Character;

public class FireResistance extends CharacterDecorator {
    public FireResistance(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription() + " avec Résistance au Feu";
    }

    @Override
    public int getPowerLevel() {
        return decoratedCharacter.getPowerLevel() + 5;
    }
}