package com.example.comics.androidtodolist.adapters;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.comics.androidtodolist.R;
import com.example.comics.androidtodolist.model.DoneTaskManager;
import com.example.comics.androidtodolist.model.Task;
import com.example.comics.androidtodolist.model.TaskManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TaskViewListAdapter extends ArrayAdapter {

    private final Activity context;

    private ArrayList<Task> toDos;

    public TaskViewListAdapter(Activity context, ArrayList<Task> toDos) {
        super(context, R.layout.task_list_view_row, toDos);
        this.context = context;
        this.toDos = toDos;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.task_list_view_row, null, true);

        final TextView taskNameTextView = (TextView) rowView.findViewById(R.id.taskNameTextViewID);
        final TextView taskDateTextView = (TextView) rowView.findViewById(R.id.taskDateTextViewID);

        taskNameTextView.setText(toDos.get(position).getDescription());
        taskDateTextView.setText(toDos.get(position).getCurrentDate());

        ImageButton completeTaskButton = (ImageButton) rowView.findViewById(R.id.completeTaskButtonID);
        completeTaskButton.setTag(position);

        completeTaskButton.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        moveTaskToDone(view);
                        removeRow(view);
                    }
                });

        return rowView;
    }

    private void removeRow(View view) {
        Integer index = (Integer) view.getTag();
        toDos.remove(index.intValue());
        notifyDataSetChanged();
    }

    private void moveTaskToDone(View view) {
        Integer index = (Integer) view.getTag();
        Task doneTask = TaskManager.getInstance().getTask(index);
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy h:mm a");
        doneTask.setCompletionDate(simpleDateFormat.format(currentTime));
        doneTask.setDone(true);
        DoneTaskManager.getInstance().addDoneTask(doneTask);

    }

    public void updateList(ArrayList<Task> items) {
        this.toDos = items;
        this.notifyDataSetChanged();
    }


}
