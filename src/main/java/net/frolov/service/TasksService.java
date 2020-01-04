package net.frolov.service;

import net.frolov.entity.Task;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface TasksService {
    Task findById(long taskId);

    Set<Task> findByUserId(long userId);

    void putTask(Task task);
}
