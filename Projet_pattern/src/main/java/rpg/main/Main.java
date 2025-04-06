package rpg.main;

import rpg.builder.CharacterBuilder;
import rpg.core.Character;
import rpg.core.Party;
import rpg.dao.CharacterDAO;
import rpg.decorator.FireResistance;
import rpg.decorator.Invisibility;
import rpg.decorator.Telepathy;
import rpg.settings.GameSettings;

public class Main {
    public static void main(String[] args) {
        // Création des personnages avec le Builder
        CharacterBuilder builder = new CharacterBuilder();
        
        Character warrior = builder.setName("Guerrier")
                                  .setStrength(10)
                                  .setAgility(5)
                                  .setIntelligence(3)
                                  .build();
        
        Character mage = builder.setName("Mage")
                               .setStrength(2)
                               .setAgility(4)
                               .setIntelligence(12)
                               .build();
        
        Character rogue = builder.setName("Voleur")
                                 .setStrength(5)
                                 .setAgility(10)
                                 .setIntelligence(5)
                                 .build();
        
        // Ajout de capacités avec Decorator
        warrior = new FireResistance(warrior);
        mage = new Telepathy(mage);
        rogue = new Invisibility(rogue);
        
        // Validation avec GameSettings
        GameSettings settings = GameSettings.getInstance();
        System.out.println("Guerrier valide: " + settings.isValid(warrior));
        System.out.println("Mage valide: " + settings.isValid(mage));
        System.out.println("Voleur valide: " + settings.isValid(rogue));
        
        // Stockage avec DAO
        CharacterDAO dao = new CharacterDAO();
        dao.save(warrior);
        dao.save(mage);
        dao.save(rogue);
        
        // Création d'une équipe
        Party party = new Party();
        party.addMember(warrior);
        party.addMember(mage);
        party.addMember(rogue);
        
        // Affichage des informations
        System.out.println("\nMembres de l'équipe:");
        party.getMembers().forEach(c -> {
            System.out.println(c.getDescription() + " - Puissance: " + c.getPowerLevel());
        });
        
        System.out.println("\nPuissance totale de l'équipe: " + party.getTotalPower());
        
        // Tri des personnages
        System.out.println("\nTri par puissance:");
        party.sortByPower();
        party.getMembers().forEach(c -> System.out.println(c.getName() + ": " + c.getPowerLevel()));
        
        System.out.println("\nTri par nom:");
        party.sortByName();
        party.getMembers().forEach(c -> System.out.println(c.getName()));
        
        // Simulation de combat simple
        System.out.println("\nCombat entre Guerrier et Mage:");
        simulateFight(warrior, mage);
    }
    
    private static void simulateFight(Character c1, Character c2) {
        int power1 = c1.getPowerLevel();
        int power2 = c2.getPowerLevel();
        
        if (power1 > power2) {
            System.out.println(c1.getName() + " gagne contre " + c2.getName());
        } else if (power2 > power1) {
            System.out.println(c2.getName() + " gagne contre " + c1.getName());
        } else {
            System.out.println("Match nul entre " + c1.getName() + " et " + c2.getName());
        }
    }
}    