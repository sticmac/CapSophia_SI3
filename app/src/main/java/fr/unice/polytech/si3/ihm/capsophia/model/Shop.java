package fr.unice.polytech.si3.ihm.capsophia.model;

import fr.unice.polytech.si3.ihm.capsophia.model.media.Media;

public class Shop {
    private String name;
    private String shortDescription;
    private String longDescription;
    private Media media;

    public Shop(String name, String shortDescription, String longDescription, Media media) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.media = media;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public Media getMedia() {
        return media;
    }
}