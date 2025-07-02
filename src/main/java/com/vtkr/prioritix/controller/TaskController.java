package com.vtkr.prioritix.controller;

import com.vtkr.prioritix.model.Task;

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
}
