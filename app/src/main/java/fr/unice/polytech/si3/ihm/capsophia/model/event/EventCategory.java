package fr.unice.polytech.si3.ihm.capsophia.model.event;

public enum EventCategory {
    INTERNSHIP(0x62C9EA),
    GAME(0xEA8262),
    CONTEST(0xB64CFF);

    private int color;

    EventCategory(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
