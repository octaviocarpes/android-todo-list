package com.example.comics.androidtodolist.model;

import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;
    public static TaskManager instance;

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    private TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(Integer position) {
        return tasks.get(position);
    }
}
