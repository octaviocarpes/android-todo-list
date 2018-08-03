package com.example.comics.androidtodolist.database;

import com.example.comics.androidtodolist.model.Task;

import java.util.List;

import io.reactivex.Flowable;

public class TaskRepository implements ITaskDataSource{

    private ITaskDataSource mLocalDataSource;
    private static TaskRepository mInstance;

    public TaskRepository(ITaskDataSource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static TaskRepository getInstance(ITaskDataSource mLocalDataSource) {
        if (mInstance == null) {
            mInstance = new TaskRepository(mLocalDataSource);
        }
        return mInstance;
    }

    @Override
    public void insertTask(Task...tasks) {
        mLocalDataSource.insertTask(tasks);
    }

    @Override
    public Flowable<List<Task>> getAllTasks() {
        return mLocalDataSource.getAllTasks();
    }

    @Override
    public void deleteTask(Task... task) {
        mLocalDataSource.deleteTask(task);
    }
}
