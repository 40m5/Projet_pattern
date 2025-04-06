package rpg.decorator;

import rpg.core.Character;

public class Invisibility extends CharacterDecorator {
    public Invisibility(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription() + " avec la capacité d'Invisibilité";
    }

    @Override
    public int getPowerLevel() {
        return decoratedCharacter.getPowerLevel() + 10;
    }
}