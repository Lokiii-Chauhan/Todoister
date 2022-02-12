package com.lokiiichauhan.todoister.data;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.lokiiichauhan.todoister.model.Task;
import com.lokiiichauhan.todoister.util.TaskRoomDatabase;

import java.util.List;

public class DoisterRepository {

    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;

    public DoisterRepository(Application application) {
        TaskRoomDatabase database = TaskRoomDatabase.getDatabase(application);

        this.taskDao = database.taskDao();
        this.allTasks = taskDao.getTasks();

    }

    public LiveData<List<Task>> getAllTasks(){
        return allTasks;
    }

    public void insert(Task task){
        TaskRoomDatabase.databaseWriterExecuter
                .execute(() -> taskDao.insertTask(task));
    }

    public LiveData<Task> getTask(long id){
        return taskDao.getTask(id);
    }

    public void update(Task task){
        TaskRoomDatabase.databaseWriterExecuter.
                execute(() -> taskDao.update(task));
    }

    public void delete(Task task){
        TaskRoomDatabase.databaseWriterExecuter
                .execute(() -> taskDao.deleteTask(task));
    }

}
