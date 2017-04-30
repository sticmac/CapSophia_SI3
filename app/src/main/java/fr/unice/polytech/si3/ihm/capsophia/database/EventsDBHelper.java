package fr.unice.polytech.si3.ihm.capsophia.database;

import android.content.Context;
import android.database.Cursor;

import java.util.LinkedList;
import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.model.event.Event;
import fr.unice.polytech.si3.ihm.capsophia.model.event.EventCategory;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Image;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Video;

public class EventsDBHelper extends DBHelper {

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

    public static Event getEventFromCursor(Cursor cursor) {
        String string = cursor.getString(1);
        Event event = new Event(
                cursor.getString(0),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4) == 0 ?
                        new Image(cursor.getString(5)) :
                        new Video(cursor.getString(5)),
                EventCategory.valueOf(cursor.getString(1))
            );
        return event;
    }
}