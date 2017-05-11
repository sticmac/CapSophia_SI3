package fr.unice.polytech.si3.ihm.capsophia.model;

import fr.unice.polytech.si3.ihm.capsophia.model.media.Media;

public abstract class LogicalElement {
    private String name;
    private String description;
    private Media media;
    private Category category;

    public LogicalElement(String name, String description, Media media, Category category) {
        this.name = name;
        this.description = description;
        this.media = media;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Media getMedia() {
        return media;
    }
}
