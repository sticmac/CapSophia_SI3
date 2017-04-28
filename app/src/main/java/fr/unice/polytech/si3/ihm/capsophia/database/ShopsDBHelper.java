package fr.unice.polytech.si3.ihm.capsophia.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.model.shop.ShopCategory;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.Shop;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Image;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Video;

public class ShopsDBHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "shops_database";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public ShopsDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    public void openDataBase() throws SQLException, IOException {
        //Open the database
        String myPath = myContext.getDatabasePath(DB_NAME).getAbsolutePath();
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if(!dbExist){
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            try {
                // Copy the database in assets to the application database.
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database", e);
            }
        }
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = myContext.getDatabasePath(DB_NAME).getAbsolutePath();
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch(SQLiteException e){
            //database doesn't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null;
    }

    private void copyDataBase() throws IOException{
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = myContext.getDatabasePath(DB_NAME).getAbsolutePath();
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    @Override
    public synchronized void close() {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public List<Shop> getAllShops() {
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM shops ORDER BY name", null);
        List<Shop> shops = new LinkedList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            shops.add(getShopFromCursor(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return shops;
    }

    public Cursor getCursorForQuery(String query) {
        return myDataBase.rawQuery(query, null);
    }

    public static Shop getShopFromCursor(Cursor cursor) {
        String string = cursor.getString(1);
        Shop shop = new Shop(
                cursor.getString(0),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4) == 0 ?
                        new Image(cursor.getString(5)) :
                        new Video(cursor.getString(5)),
                ShopCategory.valueOf(cursor.getString(1))
            );
        return shop;
    }
}