package mytodolist.androidtodolist.database;

import mytodolist.androidtodolist.model.Task;

import java.util.List;

import io.reactivex.Flowable;

public interface ITaskDataSource {
    void insertTask(Task... tasks);
    Flowable<List<Task>> getAllTasks();
    void deleteTask(Task... tasks);
}
