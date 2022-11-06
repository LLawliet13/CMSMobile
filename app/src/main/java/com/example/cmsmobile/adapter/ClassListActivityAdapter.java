package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Account_Class;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.entity.Role;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.Account_ClassRepository;
import com.example.cmsmobile.repository.ClassRepository;

import java.util.List;

public class ClassListActivityAdapter extends BaseAdapter {
    private Classes[] items;
    private Context context;
    private String role;
    private List<Account> accountList;
    private List<Account_Class> account_classList;
    private Activity activity;

    public ClassListActivityAdapter(Classes[] items, Context context, String role, List<Account> accountList
            , List<Account_Class> account_classList, Activity activity) {
        this.items = items;
        this.context = context;
        this.role = role;
        this.accountList = accountList;
        this.account_classList = account_classList;
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
        convertView = inflater.inflate(R.layout.class_item_d,null);
        Button edit_button = (Button) convertView.findViewById(R.id.edit_button_classListActivity);
        Button delete_button = (Button) convertView.findViewById(R.id.edit_button_classListActivity);
        if(position == 0){
            TextView class_name = (TextView) convertView.findViewById(R.id.class_name_classListActivity);
            class_name.setText("Class Name");
            TextView teacher_name = (TextView) convertView.findViewById(R.id.class_name_classListActivity);
            teacher_name.setText("Teacher Name");
            edit_button.setVisibility(View.GONE);
            delete_button.setVisibility(View.GONE);
        }else {
            TextView class_name = (TextView) convertView.findViewById(R.id.class_name_classListActivity);
            class_name.setText(items[position].getName());
            TextView teacher_name = (TextView) convertView.findViewById(R.id.class_name_classListActivity);
            teacher_name.setText(items[position].getName());
        }
        if(role.equals("teacher")){

        }
        if(role.equals("admin")){

        }
        return convertView;
    }
}
