package com.lokiiichauhan.todoister.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.AsyncListUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.lokiiichauhan.todoister.R;
import com.lokiiichauhan.todoister.model.Task;
import com.lokiiichauhan.todoister.util.Utils;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Task> taskList;
    private final OnTodoClickListner todoClickListner;



    public RecyclerViewAdapter(List<Task> taskList, OnTodoClickListner onTodoClickListner) {
        this.taskList = taskList;
        this.todoClickListner = onTodoClickListner;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        Task task = taskList.get(position);
        String formatted = Utils.formatDate(task.getDueDate());

        holder.task.setText(task.getTask());
        holder.chip.setText(formatted);

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public AppCompatRadioButton radioButton;
        public AppCompatTextView task;
        public Chip chip;
        OnTodoClickListner onTodoClickListner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            radioButton = itemView.findViewById(R.id.todo_radio_button);
            task = itemView.findViewById(R.id.todo_row_todo);
            chip = itemView.findViewById(R.id.todo_row_chip);
            this.onTodoClickListner = todoClickListner;

            itemView.setOnClickListener(this);
            radioButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Task currTask;

            int id = v.getId();
            if (id == R.id.todo_row_layout){
                currTask = taskList.get(getAdapterPosition());
                onTodoClickListner.onTodoClick(getAdapterPosition(), currTask);
            }else if (id == R.id.todo_radio_button){
                currTask = taskList.get(getAdapterPosition());
                onTodoClickListner.onTodoRadioClicked(currTask);
            }
        }
    }
}
