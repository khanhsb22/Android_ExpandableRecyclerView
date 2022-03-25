package com.example.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {
    private ArrayList<Class> list;
    private Context context;
    private StudentAdapter studentAdapter = null;

    public ClassAdapter(ArrayList<Class> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Class model = list.get(position);

        holder.textView_class_name.setText(model.getClass_name());

        studentAdapter = new StudentAdapter(model.getStudents(), context);
        holder.recyclerView_student.setLayoutManager(new LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false));
        holder.recyclerView_student.setAdapter(studentAdapter);

        holder.imageView_arrow.setOnClickListener(view -> {
            onItemClicked(model);
        });

        // Set status for recyclerView_student
        if (model.isExpanded) {
            holder.recyclerView_student.setVisibility(View.VISIBLE);
            holder.imageView_arrow.setImageResource(R.drawable.ic_arrow_up);
        } else {
            holder.recyclerView_student.setVisibility(View.GONE);
            holder.imageView_arrow.setImageResource(R.drawable.ic_arrow_down);
        }
    }

    private void onItemClicked(Class item) {
        item.isExpanded = !item.isExpanded;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_class_name;
        private RecyclerView recyclerView_student;
        private ImageView imageView_arrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_class_name = itemView.findViewById(R.id.textView_class_name);
            recyclerView_student = itemView.findViewById(R.id.recyclerView_student);
            imageView_arrow = itemView.findViewById(R.id.imageView_arrow);
        }
    }
}