package fr.unice.polytech.si3.ihm.capsophia.database.parking;

import android.content.Context;
import android.database.Cursor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import fr.unice.polytech.si3.ihm.capsophia.model.access.AccessDaySchedule;
import fr.unice.polytech.si3.ihm.capsophia.model.access.AccessDifficulty;
import fr.unice.polytech.si3.ihm.capsophia.model.day.Day;

public class ParkingAccessDBHelper extends ParkingDBHelper {
    private Map<Day, AccessDaySchedule> scheduleMap;

    public ParkingAccessDBHelper(Context context) {
        super(context);
        scheduleMap = new HashMap<>();
    }

    public AccessDaySchedule getAccessDayScheduleForDay(Day day) {
        if (!scheduleMap.containsKey(day)) {
            try {
                this.openDataBase();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
                System.exit(2);
            }
            Cursor cursor = myDataBase.rawQuery("SELECT * FROM access WHERE day = '" + day.name()+"'", null);
            cursor.moveToFirst();
            AccessDifficulty morning = AccessDifficulty.valueOf(cursor.getString(2));
            cursor.moveToNext();
            AccessDifficulty noon = AccessDifficulty.valueOf(cursor.getString(2));
            cursor.moveToNext();
            AccessDifficulty afternoon = AccessDifficulty.valueOf(cursor.getString(2));
            cursor.moveToNext();
            AccessDifficulty evening = AccessDifficulty.valueOf(cursor.getString(2));
            cursor.close();
            scheduleMap.put(day, new AccessDaySchedule(day, morning, noon, afternoon, evening));
            this.close();
        }

        return scheduleMap.get(day);
    }

}
