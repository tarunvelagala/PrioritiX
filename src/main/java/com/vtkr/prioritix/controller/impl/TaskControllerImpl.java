package com.vtkr.prioritix.controller.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtkr.prioritix.controller.TaskController;
import com.vtkr.prioritix.model.Priority;
import com.vtkr.prioritix.model.Task;
import com.vtkr.prioritix.service.TaskService;

import lombok.NonNull;

/**
 * TaskController implementation for managing {@link Task} operations.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    /**
     * Constructor for TaskController.
     *
     * @param taskService {@link TaskService}
     */
    @Autowired
    public TaskControllerImpl(@NonNull final TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PostMapping
    public Task createTask(@RequestBody @NonNull final Task task) {
        return taskService.createTask(task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @GetMapping
    public Map<Priority, List<Task>> getTasksByPriority() {
        return taskService.getTasksByPriority();
    }
}
