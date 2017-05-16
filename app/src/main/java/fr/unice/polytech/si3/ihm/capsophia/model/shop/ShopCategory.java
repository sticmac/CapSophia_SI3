package fr.unice.polytech.si3.ihm.capsophia.model.shop;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.model.Category;

public enum ShopCategory implements Category {
    WELFARE(R.string.WELFARE, 0xEE96FF4C),
    FASHION_M(R.string.FASHION_M, 0xEE62C9EA),
    FASHION_F(R.string.FASHION_F, 0xEEF4C0F6),
    FASHION_C(R.string.FASHION_C, 0xEEF6E5C0),
    LEATHER(R.string.LEATHER, 0xEEFFD78F),
    DECORATION(R.string.DECORATION, 0xEED1B4F8);

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
