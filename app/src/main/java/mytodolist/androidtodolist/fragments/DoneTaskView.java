package mytodolist.androidtodolist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;


import mytodolist.androidtodolist.R;
import mytodolist.androidtodolist.adapters.DoneTaskViewListAdapter;

import mytodolist.androidtodolist.model.DoneTaskManager;

public class DoneTaskView extends Fragment {

    private DoneTaskViewListAdapter doneTaskViewListAdapter;
    private ListView listView;
    private ImageButton deleteTaskButton;
    private ImageButton restoreButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.done_task_view, container, false);
        doneTaskViewListAdapter = new DoneTaskViewListAdapter(this.getActivity(), DoneTaskManager.getInstance().getDoneTasks());
        listView = (ListView) view.findViewById(R.id.doneTaskListID);
        listView.setAdapter(doneTaskViewListAdapter);
        deleteTaskButton = (ImageButton) view.findViewById(R.id.deleteTaskButtonID);

        restoreButton = (ImageButton) view.findViewById(R.id.restoreTaskButtonID);
        return view;
    }

    @Override
    public void onResume() {
        updateView();
        super.onResume();
    }

    public void updateView(){
        doneTaskViewListAdapter.updateList(DoneTaskManager.getInstance().getDoneTasks());
    }

    public void restoreTask() {

    }

    public void deleteTask(View view) {
        Integer index = (Integer) view.getTag();
        DoneTaskManager.getInstance().getDoneTasks().remove(index.intValue());
        doneTaskViewListAdapter.notifyDataSetChanged();
    }
}
