package com.example.cmsmobile.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Classes;

import java.util.List;

public class ClassesViewAdapter extends RecyclerView.Adapter<ClassesViewAdapter.ClassesViewHolder>{

    private List<Classes> listClasses;
    private Context context;

    public void setData(List<Classes> list, Context context){
        this.listClasses = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_class_detail, parent,false);
        return new ClassesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassesViewHolder holder, int position) {
        Classes classes = listClasses.get(position);
        if(classes==null){
            return;
        }
    }

    @Override
    public int getItemCount() {
        if(listClasses!=null){
            return listClasses.size();
        }
        return 0;
    }

    public class ClassesViewHolder extends RecyclerView.ViewHolder{

        public ClassesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
