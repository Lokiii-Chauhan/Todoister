package com.lokiiichauhan.todoister.adapter;

import com.lokiiichauhan.todoister.model.Task;

public interface OnTodoClickListner {
    void onTodoClick(Task task);
    void onTodoRadioClicked(Task task);
}
