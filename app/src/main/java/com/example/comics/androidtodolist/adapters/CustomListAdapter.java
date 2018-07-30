package com.example.comics.androidtodolist.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.comics.androidtodolist.R;
import com.example.comics.androidtodolist.model.Task;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the list of todo list
    private final ArrayList<Task> toDos;

    public CustomListAdapter(Activity context, ArrayList<Task> toDos) {

        super(context, R.layout.task_list_view_row, toDos);
        this.context = context;
        this.toDos = toDos;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.task_list_view_row, null, true);

        //this code gets references to objects in the listview_row.xml file
        TextView taskNameTextView = (TextView) rowView.findViewById(R.id.taskNameTextViewID);
        TextView taskDateTextView = (TextView) rowView.findViewById(R.id.taskDateTextViewID);

        //this code sets the values of the objects to values from the arrays
        taskNameTextView.setText(toDos.get(position).getDescription());
        taskDateTextView.setText(toDos.get(position).getCurrentDate());

        Button deleteButton = (Button) rowView.findViewById(R.id.completeTaskButtonID);
        deleteButton.setTag(position);

        deleteButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer index = (Integer) v.getTag();
                        toDos.remove(index.intValue());
                        notifyDataSetChanged();
                    }
                });

        return rowView;
    }
}
