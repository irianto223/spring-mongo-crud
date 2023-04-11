package com.iriantokbarek.springbootmongo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.findAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId) {
        return service.getTaskById(taskId);
    }
}
