package com.vtkr.prioritix.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtkr.prioritix.model.Task;
import com.vtkr.prioritix.repository.TaskRepository;
import com.vtkr.prioritix.service.TaskService;

import lombok.NonNull;

/**
 * Service for managing {@link Task} entities.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    /**
     * Constructor for TaskService.
     * 
     * @param taskRepository {@link TaskRepository}
     */
    @Autowired
    public TaskServiceImpl(@NonNull final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * {@inheritDoc}
     */
    public Task createTask(@NonNull final Task task) {
        return taskRepository.save(task);
    }
}
