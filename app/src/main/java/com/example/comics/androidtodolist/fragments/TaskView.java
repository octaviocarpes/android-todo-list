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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.comics.androidtodolist.R;
import com.example.comics.androidtodolist.activities.MainActivity;
import com.example.comics.androidtodolist.adapters.CustomListAdapter;
import com.example.comics.androidtodolist.model.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TaskView extends Fragment {

    CustomListAdapter customListAdapter;
    ListView listView;
    //Substituir pelo singleton
    ArrayList<Task> todoList = new ArrayList<>();
    FloatingActionButton addTaskButton;
    private AlertDialog alert;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){

        View view = inflater.inflate(R.layout.task_view, container, false);
        customListAdapter = new CustomListAdapter(this.getActivity(), todoList);
        listView = (ListView) view.findViewById(R.id.taskListViewID);
        listView.setAdapter(customListAdapter);
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
                todoList.add(buildTask(input.getText().toString()));
                customListAdapter.updateList(todoList);
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
        task.setCurrentDate(currentTime.toString());
        return task;
    }
}
