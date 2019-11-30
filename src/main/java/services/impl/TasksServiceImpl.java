package services.impl;

import dao.TaskDao;
import dao.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import services.TasksService;

import java.util.Set;

public class TasksServiceImpl implements TasksService {

    @Autowired
    private TaskDao taskDao;

    public Task findById(long taskId) {
        return taskDao.findById(taskId);
    }

    public Set<Task> findByUserId(long userId) {
        return null;
    }
}
