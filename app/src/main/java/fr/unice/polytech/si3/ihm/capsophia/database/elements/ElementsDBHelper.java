package fr.unice.polytech.si3.ihm.capsophia.database.elements;

import android.content.Context;

import fr.unice.polytech.si3.ihm.capsophia.database.DBHelper;

public abstract class ElementsDBHelper extends DBHelper {
    private static String DB_NAME = "elements_database";

    public ElementsDBHelper(Context context) {
        super(context, DB_NAME);
    }
}
