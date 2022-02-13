package com.lokiiichauhan.todoister;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.chip.Chip;
import com.lokiiichauhan.todoister.model.Priority;
import com.lokiiichauhan.todoister.model.Task;
import com.lokiiichauhan.todoister.model.TaskViewModel;

import java.util.Calendar;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    private EditText enterTodo;
    private ImageButton calenderButton, priorityButton;
    private RadioGroup priorityRadioGroup;
    private RadioButton selectradioButton;
    private int selectButtonId;
    private ImageButton saveButton;
    private CalendarView calendarView;
    private Group calenderGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.bottom_sheet, container, false);

        calenderGroup = view.findViewById(R.id.calendar_group);
        calendarView = view.findViewById(R.id.calendar_view);
        calenderButton = view.findViewById(R.id.today_calendar_button);
        enterTodo = view.findViewById(R.id.enter_todo_et);
        saveButton = view.findViewById(R.id.save_todo_button);
        priorityButton = view.findViewById(R.id.priority_todo_button);
        priorityRadioGroup = view.findViewById(R.id.radioGroup_priority);

        Chip todayChip = view.findViewById(R.id.today_chip);
        Chip tomorrowChip = view.findViewById(R.id.tomorrow_chip);
        Chip nextWeekChip = view.findViewById(R.id.next_week_chip);

        return view;
    }

    public BottomSheetFragment(){

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        saveButton.setOnClickListener(view1 -> {
            String task = enterTodo.getText().toString().trim();
            if (!TextUtils.isEmpty(task)){
                Task myTask = new Task(task, Priority.HIGH, Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime(), false);
                TaskViewModel.insert(myTask);
            }
        });
    }
}