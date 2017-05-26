package fr.unice.polytech.si3.ihm.capsophia.database.elements;

import android.content.Context;
import android.database.Cursor;

import java.util.LinkedList;
import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.model.shop.ShopCategory;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.Shop;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Image;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Video;

public class ShopsDBHelper extends ElementsDBHelper {

    public ShopsDBHelper(Context context) {
        super(context);
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

    private static Shop getShopFromCursor(Cursor cursor) {
        String string = cursor.getString(1);
        Shop shop = new Shop(
                cursor.getString(0),
                cursor.getString(2),
                cursor.getInt(3) == 0 ?
                        new Image(cursor.getString(4)) :
                        new Video(cursor.getString(4)),
                ShopCategory.valueOf(cursor.getString(1))
            );
        return shop;
    }
}