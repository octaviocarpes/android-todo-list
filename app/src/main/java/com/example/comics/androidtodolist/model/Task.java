package com.example.comics.androidtodolist.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

@Entity
public class Task {

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "completion_date")
    private String completionDate;

    @ColumnInfo(name = "current_date")
    private String currentDate;

    @ColumnInfo(name = "is_done")
    private boolean isDone;

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
