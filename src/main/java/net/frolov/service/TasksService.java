package net.frolov.service;

import net.frolov.entity.dto.TaskCreateDto;
import net.frolov.entity.dto.TaskReadDto;

import java.util.Set;

public interface TasksService {
    TaskReadDto findById(long taskId);

    Set<TaskReadDto> findByUserId(long userId);

    TaskReadDto addTask(TaskCreateDto task);
}
