package mytodolist.androidtodolist.model;

import java.util.ArrayList;

public class DoneTaskManager {

    private ArrayList<Task> doneTasks;
    public static DoneTaskManager instance;

    public static DoneTaskManager getInstance() {
        if (instance == null) {
            instance = new DoneTaskManager();
        }
        return instance;
    }

    private DoneTaskManager() {
        doneTasks = new ArrayList<>();
    }

    public ArrayList<Task> getDoneTasks() {
        return doneTasks;
    }

    public void setDoneTasks(ArrayList<Task> doneTasks) {
        this.doneTasks = doneTasks;
    }

    public void addDoneTask(Task task) {
        doneTasks.add(task);
    }

    public Task getDoneTask(Integer position) {
        return doneTasks.get(position);
    }
}
