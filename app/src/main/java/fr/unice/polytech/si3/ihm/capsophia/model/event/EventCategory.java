package fr.unice.polytech.si3.ihm.capsophia.model.event;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.model.Category;

public enum EventCategory implements Category {
    INTERNSHIP(R.string.INTERNSHIP, 0xEE62C9EA),
    GAME(R.string.GAME, 0xEEEA8262),
    CONTEST(R.string.CONTEST, 0xEEB64CFF);

    private int color;
    private int nameId;

    EventCategory(int nameId, int color) {
        this.nameId = nameId;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public int getNameId() {
        return nameId;
    }
}
