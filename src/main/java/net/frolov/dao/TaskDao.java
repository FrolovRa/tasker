package net.frolov.dao;

import net.frolov.entity.Task;

import java.util.Optional;
import java.util.Set;

public interface TaskDao {
    Optional<Task> findById(long taskId);

    Set<Task> findTasksByUserId(long userId);

    Task saveTask(Task task);
}
