package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.activity.EditExamActivity;
import com.example.cmsmobile.activity.ViewExamActivity;
import com.example.cmsmobile.entity.Exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExamViewAdapter extends RecyclerView.Adapter<ExamViewAdapter.ExamViewHolder> {

    private List<Exam> listExams;

    private Context context;

    public ExamViewAdapter(Context context){
        this.context = context;
    }

    public void setData(List<Exam> list) {
        this.listExams = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_exams, parent, false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        Exam exam = listExams.get(position);
        if (exam == null) {
            return;
        }
        holder.tvTitle.setText(exam.getName());
        holder.tvDueDate.setText(exam.getEnd_date());

        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Click thành công", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnEditExam.setOnClickListener(new View.OnClickListener() {
            private Activity ViewExamActivity;

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditExamActivity.class);
                int class_id = ((Activity) context).getIntent().getExtras().getInt("class_id");
                intent.putExtra("class_id", class_id);
                intent.putExtra("exam_id", exam.getExam_id());
                v.getContext().startActivity(intent);
            }
        });

        holder.btnRemoveExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Delete", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listExams != null) {
            return listExams.size();
        }
        return 0;
    }

    public class ExamViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvDueDate;
        private Button btnEditExam, btnRemoveExam;

        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDueDate = itemView.findViewById(R.id.tvDueDate);
            btnEditExam = itemView.findViewById(R.id.btn_edit_exam);
            btnRemoveExam = itemView.findViewById(R.id.btn_remove_exam);
        }
    }
}