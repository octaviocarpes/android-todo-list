package com.example.comics.androidtodolist.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.comics.androidtodolist.model.Task;

import static com.example.comics.androidtodolist.local.TaskDatabase.DATABASE_VERSION;

@Database(entities = Task.class, version = DATABASE_VERSION)
public abstract class TaskDatabase extends RoomDatabase {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Task-Database";

    public abstract TaskDAO taskDAO();

    public static TaskDatabase mInstance;

    public static TaskDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context, TaskDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }

}
