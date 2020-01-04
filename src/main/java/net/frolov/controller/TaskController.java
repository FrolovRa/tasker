package net.frolov.controller;

import net.frolov.entity.dto.TaskCreateDto;
import net.frolov.entity.dto.TaskReadDto;
import net.frolov.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    TasksService tasksService;

    @GetMapping("/byId/{id}")
    public TaskReadDto getTask(@PathVariable long id) {
        return tasksService.findById(id);
    }

    @GetMapping("/byUserId/{id}")
    public Set<TaskReadDto> getTasks(@PathVariable long id) {
        return tasksService.findByUserId(id);
    }

    @PostMapping
    public TaskReadDto addTask(@RequestBody TaskCreateDto task) {
        return tasksService.addTask(task);
    }
}
