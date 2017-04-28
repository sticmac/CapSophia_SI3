package fr.unice.polytech.si3.ihm.capsophia.model.shop;

import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Media;

public class Shop extends LogicalElement {
    private ShopCategory shopCategory;

    public Shop(String name, String shortDescription, String longDescription, Media media, ShopCategory shopCategory) {
        super(name, shortDescription, longDescription, media);
        this.shopCategory = shopCategory;
    }

    public ShopCategory getShopCategory() { return shopCategory; }
}