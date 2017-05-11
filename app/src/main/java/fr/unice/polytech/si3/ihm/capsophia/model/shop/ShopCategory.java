package fr.unice.polytech.si3.ihm.capsophia.model.shop;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.model.Category;

public enum ShopCategory implements Category {
    WELFARE(R.string.WELFARE, 0xCC96FF4C);

    private int color;
    private int nameId;

    ShopCategory(int nameId, int color) {
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
