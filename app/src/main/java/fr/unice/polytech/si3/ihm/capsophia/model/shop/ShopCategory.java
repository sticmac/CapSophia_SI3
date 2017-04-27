package fr.unice.polytech.si3.ihm.capsophia.model.shop;

public enum ShopCategory {
    WELFARE(0xCC96FF4C);

    private int color;

    ShopCategory(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
