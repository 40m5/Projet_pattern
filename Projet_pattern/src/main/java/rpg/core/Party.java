package rpg.core;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<Character> members = new ArrayList<>();

    public void addMember(Character character) {
        members.add(character);
    }

    public void removeMember(Character character) {
        members.remove(character);
    }

    public void removeMemberByName(String name) {
        members.removeIf(c -> c.getName().equals(name));
    }

    public int getTotalPower() {
        return members.stream().mapToInt(Character::getPowerLevel).sum();
    }

    public List<Character> getMembers() {
        return new ArrayList<>(members);
    }

    public void sortByName() {
        members.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
    }

    public void sortByPower() {
        members.sort((c1, c2) -> Integer.compare(c2.getPowerLevel(), c1.getPowerLevel()));
    }
}