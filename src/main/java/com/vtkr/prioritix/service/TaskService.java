package com.vtkr.prioritix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtkr.prioritix.model.Task;
import com.vtkr.prioritix.repository.TaskRepository;

import lombok.NonNull;

/**
 * Service for managing {@link Task} entities.
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * Constructor for Task repository.
     * 
     * @param taskRepository {@link TaskRepository}
     */
    @Autowired
    public TaskService(@NonNull final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Creates and saves a new {@link Task}.
     * 
     * @param task {@link Task} New task to be created.
     * @return {@link Task} created task.
     */
    public Task createTask(@NonNull final Task task) {
        return taskRepository.save(task);
    }
}
