package rpg.decorator;

import rpg.core.Character;

public class Telepathy extends CharacterDecorator {
    public Telepathy(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription() + " avec Télépathie";
    }

    @Override
    public int getPowerLevel() {
        return decoratedCharacter.getPowerLevel() + 15;
    }
}