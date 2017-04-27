package fr.unice.polytech.si3.ihm.capsophia.model.event;

import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Media;

public class Event extends LogicalElement {
    private EventCategory eventCategory;

    public Event(String name, String shortDescription, String longDescription, Media media, EventCategory eventCategory) {
        super(name, shortDescription, longDescription, media);
        this.eventCategory = eventCategory;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }
}
