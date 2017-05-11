package fr.unice.polytech.si3.ihm.capsophia.model.shop;

import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Media;

public class Shop extends LogicalElement {
    public Shop(String name, String description, Media media, ShopCategory shopCategory) {
        super(name, description, media, shopCategory);
    }
}