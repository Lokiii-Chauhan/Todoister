package com.lokiiichauhan.todoister.adapter;

import com.lokiiichauhan.todoister.model.Task;

public interface OnTodoClickListner {
    void onTodoClick(int adapterPosition, Task task);
    void onTodoRadioClicked(Task task);
}
