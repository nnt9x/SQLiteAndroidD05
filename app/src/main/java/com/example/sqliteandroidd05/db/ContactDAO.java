package com.example.sqliteandroidd05.db;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqliteandroidd05.model.Contact;

import java.util.ArrayList;
import java.util.List;

// DAO: data access object: dinh nghia CRUD
public class ContactDAO {
    private DBHelper dbHelper;

    public ContactDAO(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    // Them du lieu
    public Contact insert(Contact contact) {
        // contact ban dau chua co id
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", contact.name);
        values.put("phone", contact.phone);

        long newId = db.insert("contacts", null, values);

        contact.id = (int) newId;
        // lien he sau khi them SQLite -> bo sung id
        return contact;
    }

    // Lay du lieu
    public List<Contact> getAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Contact> data = new ArrayList<>();

        Cursor cursor = db.query("contacts", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Contact contact = new Contact();
            contact.id = cursor.getInt(0);
            contact.name = cursor.getString(1);
            contact.phone = cursor.getString(2);
            data.add(contact);
        }
        cursor.close();
        return data;
    }

    public Contact edit(Contact contact, long id) {
        // contact: chua du lieu can sua, id la id ban ghi can sua
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", contact.name);
        values.put("phone", contact.phone);

        // update ... set ... where id = 3

        db.update("contacts", values, "id = " + id, null);
        return contact;
    }

    // Xoa ban ghi
    public boolean deleteContactById(long id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int rs = db.delete("contacts", "id = " + id, null);
        return rs != 0;
    }

}
