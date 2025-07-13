package com.vtkr.prioritix.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtkr.prioritix.model.Priority;
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
    @Override
    public Task createTask(@NonNull final Task task) {
        return taskRepository.save(task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Priority, List<Task>> getTasksByPriority() {
        final List<Task> tasks = taskRepository.findAll();
        if (tasks == null || tasks.isEmpty()) {
            return Map.of(); // Return empty map if no tasks found
        }
        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getPriority)); 
    }
}
