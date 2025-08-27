package catchtheevents;

public class Main {
    public static void main(String[] args) {
        HogwartsSpell hogwartsSpell = new HogwartsSpell();

        hogwartsSpell.addSpellEvent("Attack", "Stupefy");
        hogwartsSpell.addSpellEvent("Defense", "Protego");
        hogwartsSpell.addSpellEvent("Healing", "Episkey");
        hogwartsSpell.addSpellEvent("Attack", "Expelliarmus");

        System.out.println("Get Spell Event by ID 2:");
        System.out.println(hogwartsSpell.getSpellEventById(2));

        System.out.println("\nGet Spell Events by Type 'Attack':");
        for (SpellEvent event : hogwartsSpell.getSpellEventsByType("Attack")) {
            System.out.println(event);
        }

        System.out.println("\nAll Spells:");
        hogwartsSpell.printAllSpells();

        System.out.println("\nDelete Spell Event by ID 3:");
        hogwartsSpell.deleteSpellEventById(3);
    }
}