package com.example.comics.androidtodolist.model;

public class Task {

    private String description;
    private String completionDate;
    private String currentDate;
    private boolean isDone;

//    Criar singleton da task list e da done list

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", completionDate='" + completionDate + '\'' +
                ", currentDate='" + currentDate + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
