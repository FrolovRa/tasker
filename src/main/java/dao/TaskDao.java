package dao;

import dao.entity.Task;

import java.util.Optional;
import java.util.Set;

public interface TaskDao {
    Optional<Task> findById(long taskId);

    Set<Task> findByUserId(long userId);

    void putTask(Task task);
}
