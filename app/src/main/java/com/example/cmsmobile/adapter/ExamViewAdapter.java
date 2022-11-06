package com.example.cmsmobile.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Exam;

import java.util.List;

public class ExamViewAdapter extends RecyclerView.Adapter<ExamViewAdapter.ExamViewHolder> {

    private List<Exam> listExams;

    public void setData(List<Exam> list) {
        this.listExams = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_exam, parent, false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        Exam exam = listExams.get(position);
        if (exam == null) {
            return;
        }
//        holder.tvCourseName.setText(exam.getCourse_id());
//        holder.tvClassName.setText(exam.getName());
//        holder.tvCourseRedirect.setText(exam.getCourse_id());
    }

    @Override
    public int getItemCount() {
        if (listExams != null) {
            return listExams.size();
        }
        return 0;
    }

    public class ExamViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCourseName, tvClassName, tvCourseRedirect;

        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseName = itemView.findViewById(R.id.courseName);
            tvClassName = itemView.findViewById(R.id.className);
            tvCourseRedirect = itemView.findViewById(R.id.courseRedirect);
        }
    }
}
