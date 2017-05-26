package fr.unice.polytech.si3.ihm.capsophia.database.parking;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ParkingInformationDBHelper extends ParkingDBHelper {
    public ParkingInformationDBHelper(Context context) {
        super(context);
    }

    public List<Pair<String, String>> getAllInformation() {
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM information", null);
        List<Pair<String, String>> information = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            information.add(getPieceOfInformationFromCursor(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return information;
    }

    private static Pair<String, String> getPieceOfInformationFromCursor(Cursor cursor) {
        return new Pair<>(
                cursor.getString(0),
                cursor.getInt(1)+""
        );
    }
}
