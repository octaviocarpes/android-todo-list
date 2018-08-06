package mytodolist.androidtodolist.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import mytodolist.androidtodolist.model.Task;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface TaskDAO {

    @Insert
    void insertTask(Task... tasks);

    @Query("Select * from task")
    Flowable<List<Task>> getAllTasks();

    @Delete
    void deleteTask(Task... tasks);
}
