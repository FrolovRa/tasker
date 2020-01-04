package net.frolov.service.impl;

import net.frolov.dao.TaskDao;
import net.frolov.entity.Task;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import net.frolov.service.TasksService;

import java.util.Set;

public class TasksServiceImpl implements TasksService {

    @Autowired
    private TaskDao taskDao;

    public Task findById(long taskId) {
        val task = taskDao.findById(taskId);
        // TODO handle null returning
        return task.orElse(null);
    }

    public Set<Task> findByUserId(long userId) {
        return null;
    }

    public void putTask(Task task) {
        taskDao.putTask(task);
    }
}