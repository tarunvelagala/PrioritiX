package com.vtkr.prioritix.controller;

import java.util.List;
import java.util.Map;

import com.vtkr.prioritix.model.Priority;
import com.vtkr.prioritix.model.entity.Task;

/**
 * Defines the contract for managing tasks.
 */
public interface TaskController {
    /**
     * Controller method to a new task.
     *
     * @param task {@code Task} The task to be created.
     * @return The created task, possibly with an assigned ID.
     */
    Task createTask(final Task task);

    /**
     * Gets a map of tasks grouped by their priority.
     * 
     * @return Map of {@link Priority} to list of {@link Task} objects.
     */
    Map<Priority, List<Task>> getTasksByPriority();
}
