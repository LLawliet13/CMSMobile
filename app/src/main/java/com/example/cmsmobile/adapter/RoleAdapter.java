package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Role;

public class RoleAdapter extends BaseAdapter {
    private Role[] items;
    private Activity activity;
    public RoleAdapter(Activity activity,Role[] items){
        this.items = items;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.role_item,null);
        TextView textView = (TextView) convertView.findViewById(R.id.role_name);
        textView.setText(items[position].getName());
        return convertView;
    }
}
