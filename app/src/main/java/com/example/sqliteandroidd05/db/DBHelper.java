package com.example.sqliteandroidd05.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "contacts.db";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Dinh nghia ra viec tao bang ??
        db.execSQL("CREATE TABLE contacts(\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  name TEXT NOT NULL,\n" +
                "  phone TEXT NOT NULL\n" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Tam thoi ko quan tam...
    }
}
