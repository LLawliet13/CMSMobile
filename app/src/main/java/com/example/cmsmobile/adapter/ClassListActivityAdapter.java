package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.activity.EditClassActivity;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Account_Class;
import com.example.cmsmobile.entity.Classes;


import java.util.List;

public class ClassListActivityAdapter extends BaseAdapter {
    private Classes[] items;
    private Context context;
    private String role;
    private int account_id;
    private List<Account> accountList;
    private List<Account_Class> account_classList;
    private Activity activity;
    private int course_id;

    public ClassListActivityAdapter(Classes[] items, Context context, String role, int account_id, List<Account> accountList, List<Account_Class> account_classList, Activity activity, int course_id) {
        this.items = items;
        this.context = context;
        this.role = role;
        this.account_id = account_id;
        this.accountList = accountList;
        this.account_classList = account_classList;
        this.activity = activity;
        this.course_id = course_id;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.class_item_d, null);
        Button edit_button = (Button) convertView.findViewById(R.id.edit_button_classListActivity);
        edit_button.setText("Edit Class");
//        Button delete_button = (Button) convertView.findViewById(R.id.edit_button_classListActivity);
        if (position == 0) {
            TextView class_name = (TextView) convertView.findViewById(R.id.class_name_classListActivity);
            class_name.setText("Class Name");
            TextView teacher_name = (TextView) convertView.findViewById(R.id.teacher_name_classListActivity);
            teacher_name.setText("Teacher Name");
            edit_button.setVisibility(View.GONE);
//            delete_button.setVisibility(View.GONE);
        } else {
            edit_button.setVisibility(View.GONE);
            TextView class_name = (TextView) convertView.findViewById(R.id.class_name_classListActivity);
            class_name.setText(items[position].getName());
            TextView teacher_name = (TextView) convertView.findViewById(R.id.teacher_name_classListActivity);
            int account_id1 = account_classList.stream().filter(ac -> ac.getClass_id() == items[position]
                        .getClass_id()).findFirst().get().getAccount_id();
                String account_name = accountList.stream().filter(ac -> ac.getAccount_id() == account_id1).findFirst().get().getUsername();
                teacher_name.setText(account_name);

            if (role.equals("teacher")) {
                if (account_id == account_id1) {
                    edit_button.setVisibility(View.VISIBLE);
//                    delete_button.setVisibility(View.VISIBLE);
                }
            }
            if (role.equals("admin")) {
                edit_button.setVisibility(View.VISIBLE);
//                delete_button.setVisibility(View.GONE);
            }
            edit_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity.getApplicationContext(), EditClassActivity.class);
                    intent.putExtra("course_id",course_id);
                    intent.putExtra("class_id",items[position].getClass_id());
                    activity.startActivity(intent);

                }
            });
        }
        return convertView;
    }
}
