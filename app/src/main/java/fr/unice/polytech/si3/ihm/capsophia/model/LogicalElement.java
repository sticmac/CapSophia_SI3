package fr.unice.polytech.si3.ihm.capsophia.model;

import fr.unice.polytech.si3.ihm.capsophia.model.media.Media;

public abstract class LogicalElement {
    protected String name;
    protected String shortDescription;
    protected String longDescription;
    protected Media media;

    public LogicalElement(String name, String shortDescription, String longDescription, Media media) {
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
