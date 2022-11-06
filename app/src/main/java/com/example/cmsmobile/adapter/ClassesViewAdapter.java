package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.dao.CourseDAO;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Account_Class;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.repository.CourseRepository;

import java.util.List;

public class ClassesViewAdapter extends RecyclerView.Adapter<ClassesViewAdapter.ClassesViewHolder> {

    private List<Classes> listClasses;
    private Activity activity;

    public void setData(List<Classes> list) {
        this.listClasses = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ClassesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_class_detail, parent, false);
        return new ClassesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassesViewHolder holder, int position) {
        Classes classes = listClasses.get(position);
        if (classes == null) {
            return;
        }

        holder.tvCourseName.setText(classes.getCourse_id());
        holder.tvClassName.setText(classes.getName());
        holder.tvCourseRedirect.setText(classes.getName());

    }

    @Override
    public int getItemCount() {
        if (listClasses != null) {
            return listClasses.size();
        }
        return 0;
    }

    public class ClassesViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCourseName, tvClassName, tvCourseRedirect;
        public ClassesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseName = itemView.findViewById(R.id.courseName);
            tvClassName = itemView.findViewById(R.id.className);
            tvCourseRedirect = itemView.findViewById(R.id.courseRedirect);
        }
    }
}
