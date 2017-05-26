package fr.unice.polytech.si3.ihm.capsophia.database.parking;

import android.content.Context;

import fr.unice.polytech.si3.ihm.capsophia.database.DBHelper;

public abstract class ParkingDBHelper extends DBHelper {
    private static final String DB_NAME = "parking_database";

    public ParkingDBHelper(Context context) {
        super(context, DB_NAME);
    }
}
