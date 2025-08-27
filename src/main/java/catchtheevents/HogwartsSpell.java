package catchtheevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpell {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int currentId = 1;

    public void addSpellEvent(String eventType, String actionDiscription) {
        int id = currentId++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDiscription);

        spellById.put(id, spellEvent);

        spellsByType.putIfAbsent(eventType,new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);

    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEventById(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> eventsOfType = spellsByType.get(spellEvent.eventType());
            if (eventsOfType != null) {
                eventsOfType.remove(spellEvent);
                if (eventsOfType.isEmpty()) {
                    spellsByType.remove(spellEvent.eventType());
                }
            }
        }
    }

    public void printAllSpells() {
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            for (SpellEvent event : entry.getValue()) {
                System.out.println("ID: " + event.id() +
                        ", Type: " + event.eventType() +
                        ", Action: " + event.action());
            }
        }
    }