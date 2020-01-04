package net.frolov.service.impl;

import net.frolov.dao.TaskDao;
import net.frolov.entity.Task;
import lombok.val;
import net.frolov.entity.dto.TaskCreateDto;
import net.frolov.entity.dto.TaskReadDto;
import net.frolov.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import net.frolov.service.TasksService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TasksServiceImpl implements TasksService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public TaskReadDto findById(long taskId) {
        val taskOptional = taskDao.findById(taskId);
        val task = taskOptional.orElseThrow(() -> new EntityNotFoundException(Task.class, taskId));
        return toReadDto(task);
    }

    @Override
    public Set<TaskReadDto> findByUserId(long userId) {
        return taskDao.findTasksByUserId(userId)
                .stream()
                .map(this::toReadDto)
                .collect(Collectors.toSet());
    }

    @Override
    public TaskReadDto addTask(TaskCreateDto taskCreateDto) {
        val task = new Task();
        task.setTaskDescription(taskCreateDto.getTaskDescription());
        task.setCreated(taskCreateDto.getCreated());
        task.setOwnerId(taskCreateDto.getOwnerId());

        val savedTask = taskDao.saveTask(task);

        return toReadDto(savedTask);
    }

    private TaskReadDto toReadDto(Task task) {
        val taskReadDto = new TaskReadDto();
        taskReadDto.setId(task.getId());
        taskReadDto.setOwnerId(task.getOwnerId());
        taskReadDto.setTaskDescription(task.getTaskDescription());
        taskReadDto.setCreated(task.getCreated());
        return taskReadDto;
    }
}
