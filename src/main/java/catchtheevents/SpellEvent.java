package catchtheevents;

public record SpellEvent(int id, String eventType, String action) {


    @Override
    public String toString() {
        return "SpellEvent{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
