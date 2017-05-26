package fr.unice.polytech.si3.ihm.capsophia.database.elements;

import android.content.Context;
import android.database.Cursor;

import java.util.LinkedList;
import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.model.event.Event;
import fr.unice.polytech.si3.ihm.capsophia.model.event.EventCategory;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Image;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Video;

public class EventsDBHelper extends ElementsDBHelper {
    public EventsDBHelper(Context context) {
        super(context);
    }

    public List<Event> getAllEvents() {
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM events ORDER BY name", null);
        List<Event> events = new LinkedList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            events.add(getEventFromCursor(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return events;
    }

    private static Event getEventFromCursor(Cursor cursor) {
        Event event = new Event(
                cursor.getString(0),
                cursor.getString(2),
                cursor.getInt(3) == 0 ?
                        new Image(cursor.getString(4)) :
                        new Video(cursor.getString(4)),
                EventCategory.valueOf(cursor.getString(1))
            );
        return event;
    }
}