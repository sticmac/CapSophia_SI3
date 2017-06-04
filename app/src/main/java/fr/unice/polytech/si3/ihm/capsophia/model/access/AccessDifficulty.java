package fr.unice.polytech.si3.ihm.capsophia.model.access;

import fr.unice.polytech.si3.ihm.capsophia.R;

public enum AccessDifficulty {
    IMPOSSIBLE(R.color.impossible_access),
    HARD(R.color.hard_access),
    MEDIUM(R.color.medium_access),
    EASY(R.color.easy_access);

    private int color;

    AccessDifficulty(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
