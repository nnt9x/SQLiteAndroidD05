package com.example.sqliteandroidd05.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqliteandroidd05.R;
import com.example.sqliteandroidd05.model.Contact;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Contact> dataSource;
    private Context context;

    private LayoutInflater inflater;

    public MyAdapter(Context context, List<Contact> dataSource) {
        this.dataSource = dataSource;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_contact, parent, false);
        // Bind id
        TextView tvName = convertView.findViewById(R.id.tv_item_contact_name);
        TextView tvPhone = convertView.findViewById(R.id.tv_item_contact_phone);
        // Do du lieu (position) vao view
        Contact contact = dataSource.get(position);

        tvName.setText(contact.name);
        tvPhone.setText(contact.phone);

        return convertView;
    }
}
