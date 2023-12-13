package com.example.sqliteandroidd05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sqliteandroidd05.adapter.MyAdapter;
import com.example.sqliteandroidd05.db.ContactDAO;
import com.example.sqliteandroidd05.db.DBHelper;
import com.example.sqliteandroidd05.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContacts;
    private List<Contact> contactList;
    private MyAdapter myAdapter;

    // Khai bao contactDAO, DBHelper
    private DBHelper dbHelper;
    private ContactDAO contactDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bind id cho view
        lvContacts = findViewById(R.id.lv_contacts);
        // Fake du lieu
//        contactList = new ArrayList<>();
        // Phan nay thuc te phai lay tu SQLite
        dbHelper = new DBHelper(this);
        contactDAO = new ContactDAO(dbHelper);

        // Them truc tiep 3 du lieu
//        contactDAO.insert(new Contact("contact 1","123456"));
//        contactDAO.insert(new Contact("contact 2","123457"));
//        contactDAO.insert(new Contact("contact 3","123458"));
        // Lay du lieu tu sqlite
        contactList = contactDAO.getAll();


        // Hien thi
        myAdapter = new MyAdapter(this, contactList);
        lvContacts.setAdapter(myAdapter);

        // Bat su kien long click
        lvContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Lay ra ban ghi can xoa
                Contact contact = contactList.get(position);

                // Lay ra id
                contactDAO.deleteContactById(contact.id);
                // Xoa tren listview
                contactList.remove(contact);
                // Thong bao adapter
                myAdapter.notifyDataSetChanged();


                return false;
            }
        });
    }
}