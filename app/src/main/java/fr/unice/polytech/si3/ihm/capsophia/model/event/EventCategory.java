package fr.unice.polytech.si3.ihm.capsophia.model.event;

public enum EventCategory {
    INTERNSHIP(0xCC62C9EA),
    GAME(0xCCEA8262),
    CONTEST(0xCCB64CFF);

    private int color;

    EventCategory(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
