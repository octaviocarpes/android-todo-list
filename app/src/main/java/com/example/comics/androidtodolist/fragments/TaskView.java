package com.example.comics.androidtodolist.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.comics.androidtodolist.R;
import com.example.comics.androidtodolist.adapters.TaskViewListAdapter;
import com.example.comics.androidtodolist.model.Task;
import com.example.comics.androidtodolist.model.TaskManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TaskView extends Fragment {

    TaskViewListAdapter taskViewListAdapter;
    FloatingActionButton addTaskButton;

    ListView listView;
    private AlertDialog alert;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){

        View view = inflater.inflate(R.layout.task_view, container, false);
        taskViewListAdapter = new TaskViewListAdapter(this.getActivity(), TaskManager.getInstance().getTasks());
        listView = (ListView) view.findViewById(R.id.taskListViewID);
        listView.setAdapter(taskViewListAdapter);
        addTaskButton = (FloatingActionButton) view.findViewById(R.id.fab);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });

        return view;
    }

    public void addTask(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setTitle("Create Task");
        final EditText input = new EditText(this.getActivity());
        builder.setView(input);
        builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                TaskManager.getInstance().addTask(buildTask(input.getText().toString()));
                taskViewListAdapter.updateList(TaskManager.getInstance().getTasks());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                alert.dismiss();
            }
        });

        alert = builder.create();

        alert.show();
    }

    public Task buildTask(String description) {
        Task task = new Task(description);
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy h:mm a");
        task.setCurrentDate(simpleDateFormat.format(currentTime));
        return task;
    }
}
