package com.example.lab6;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OnlineMenuDatabaseHelper extends SQLiteOpenHelper {

    private static int DB_VERSION = 2;

    public OnlineMenuDatabaseHelper(Context context) {
        super(context, null, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createTableOrder("AORDER"));

        ContentValues newItem = new ContentValues();
        newItem.put("NAME", "Test");
        newItem.put("AMOUNT", "100");
        db.insert("AORDER", null, newItem);

        db.execSQL(createTable("COMPUTER"));
        db.execSQL(createTable("TABLET"));
        db.execSQL(createTable("PHONE"));

        db.insert("COMPUTER", null,
                createItem("Macbook 12'", "Memory: 256GB, Proccesor: Intel M3 ",
                        1100.99f, R.drawable.macbook));
        db.insert("COMPUTER", null,
                createItem("Macbook Air 13'", "Memory: 256GB, Proccesor: Intel Core i5",
                        1400.99f, R.drawable.macbookair));
        db.insert("COMPUTER", null,
                createItem("Macbook Pro 13'", "Memory: 1TB, Proccesor: Intel Core i7",
                        1600.99f, R.drawable.macbookpro));

        db.insert("TABLET", null,
                createItem("IPad Pro 12.9'", "Memory: 256GB, Screen size: 12.9 Inch",
                        600.99f, R.drawable.ipad129));
        db.insert("TABLET", null,
                createItem("IPad Pro 11'", "Memory: 128GB, Screen size: 11.0 Inch",
                        700.99f, R.drawable.ipadpro111));
        db.insert("TABLET", null,
                createItem("IPad Mini", "Memory: 64GB, Screen size: 7,9 Inch Inch",
                        999.99f, R.drawable.ipad_mini_gold_new));

        db.insert("PHONE", null,
                createItem("Iphone 8 Plus", "Memory: 256GB, Color: Space Grey",
                        600.99f, R.drawable.iphone8plus));
        db.insert("PHONE", null,
                createItem("Iphone X", "Memory: 64GB, Color: Silver",
                        700.99f, R.drawable.xsilver));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private String createTable(String nameTable) {
        return "CREATE TABLE " + nameTable + " (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "PRICE REAL, "
                + "IMAGE_RESOURCE_ID INTEGER);";
    }

    private String createTableOrder(String nameTable) {
        return "CREATE TABLE " + nameTable + " (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "AMOUNT TEXT);";
    }

    private ContentValues createItem(String name, String description, float price, int imageResId) {
        ContentValues newItem = new ContentValues();

        newItem.put("NAME", name);
        newItem.put("DESCRIPTION", description);
        newItem.put("PRICE", price);
        newItem.put("IMAGE_RESOURCE_ID", imageResId);

        return newItem;
    }

}
