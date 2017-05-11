package fr.unice.polytech.si3.ihm.capsophia.model.event;

import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Media;

public class Event extends LogicalElement {
    public Event(String name, String description, Media media, EventCategory eventCategory) {
        super(name, description, media, eventCategory);
    }
}
