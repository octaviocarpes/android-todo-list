package com.example.comics.androidtodolist.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.comics.androidtodolist.R;
import com.example.comics.androidtodolist.model.Task;

import java.util.ArrayList;

public class DoneTaskViewListAdapter extends ArrayAdapter {

    private Activity context;
    private ArrayList<Task> doneTasks;

    public DoneTaskViewListAdapter(Activity context, ArrayList<Task> doneTasks) {
        super(context, R.layout.done_task_list_view_row, doneTasks);
        this.context = context;
        this.doneTasks = doneTasks;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.done_task_list_view_row, null, true);

        TextView taskNameTextView = (TextView) rowView.findViewById(R.id.doneTaskDescriptionID);
        TextView taskDateTextView = (TextView) rowView.findViewById(R.id.doneTaskDateID);

        taskNameTextView.setText(doneTasks.get(position).getDescription());
        taskDateTextView.setText(doneTasks.get(position).getCurrentDate());

        ImageButton deleteTaskButton = (ImageButton) rowView.findViewById(R.id.deleteTaskButtonID);
        deleteTaskButton.setTag(position);

        ImageButton restoreTaskButton = (ImageButton) rowView.findViewById(R.id.restoreTaskButtonID);
        restoreTaskButton.setTag(position);

        deleteTaskButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeRow(view);
            }
        });

        return rowView;
    }

    private void removeRow(View view) {
        Integer index = (Integer) view.getTag();
        doneTasks.remove(index.intValue());
        notifyDataSetChanged();
    }

    public void updateList(ArrayList<Task> items) {
        this.doneTasks = items;
        this.notifyDataSetChanged();
    }
}
