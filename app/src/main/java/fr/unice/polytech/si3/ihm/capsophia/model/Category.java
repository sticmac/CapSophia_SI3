package fr.unice.polytech.si3.ihm.capsophia.model;

public enum Category {
    WELFARE(0xCC96FF4C);

    private int color;

    Category(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
