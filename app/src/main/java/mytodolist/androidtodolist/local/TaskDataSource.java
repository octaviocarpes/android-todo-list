package mytodolist.androidtodolist.local;

import mytodolist.androidtodolist.database.ITaskDataSource;
import mytodolist.androidtodolist.model.Task;

import java.util.List;

import io.reactivex.Flowable;

public class TaskDataSource implements ITaskDataSource {

    private TaskDAO taskDAO;
    private static TaskDataSource mInstance;

    public TaskDataSource(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public static TaskDataSource getInstance(TaskDAO taskDAO) {
        if (mInstance == null) {
            mInstance = new TaskDataSource(taskDAO);
        }
        return mInstance;
    }

    @Override
    public void insertTask(Task... tasks) {
        taskDAO.insertTask(tasks);
    }

    @Override
    public Flowable<List<Task>> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @Override
    public void deleteTask(Task... tasks) {
        taskDAO.deleteTask(tasks);
    }
}
